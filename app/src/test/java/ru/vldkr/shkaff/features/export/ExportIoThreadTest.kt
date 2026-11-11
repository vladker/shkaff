package ru.vldkr.shkaff.features.export

import android.app.Application
import android.net.Uri
import android.os.Looper
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import ru.vldkr.shkaff.export.Sheet
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.FilterOutputStream
import java.io.IOException
import java.io.OutputStream
import java.util.concurrent.CopyOnWriteArrayList
import java.util.zip.ZipInputStream

// T-029: сериализация OOXML и запись в SAF-поток не имеют права идти на главном потоке —
// на большой базе экспорт идёт секунды и UI подвисает. Пишем в поток-регистратор и
// требуем, чтобы ни один write не пришёл с главного потока.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ExportIoThreadTest {

    /** Пишет в sink и запоминает потоки, из которых пришли write-вызовы. */
    private class RecordingStream(sink: OutputStream) : FilterOutputStream(sink) {
        val writeThreads = CopyOnWriteArrayList<Thread>()
        override fun write(b: ByteArray, off: Int, len: Int) {
            writeThreads += Thread.currentThread()
            out.write(b, off, len)
        }
    }

    private val sheet = Sheet("Вещи", listOf("Название", "Код"), listOf(listOf("Дрель", "DR-1")))

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun app(): Application = ApplicationProvider.getApplicationContext()

    private fun assertOffMainThread(threads: List<Thread>, caller: Thread) {
        val main = Looper.getMainLooper().thread
        assertTrue("записей не было вообще", threads.isNotEmpty())
        for (t in threads) {
            assertTrue("write выполнен на главном потоке: ${t.name}", t !== main && t !== caller)
        }
    }

    @Test
    fun `xlsx export writes off the main thread and stays valid ooxml`() = runTest {
        val sink = ByteArrayOutputStream()
        val rec = RecordingStream(sink)
        val caller = Thread.currentThread()
        val ctx = app()
        val uri = Uri.parse("content://shkaff.export/items.xlsx")
        shadowOf(ctx.contentResolver).registerOutputStream(uri, rec)

        ExportVm().writeToUri(ctx, uri, sheet, ExportVm.Fmt.XLSX)

        assertOffMainThread(rec.writeThreads, caller)
        val entries = HashMap<String, String>()
        ZipInputStream(ByteArrayInputStream(sink.toByteArray())).use { z ->
            var e = z.nextEntry
            while (e != null) {
                entries[e.name] = String(z.readBytes(), Charsets.UTF_8)
                e = z.nextEntry
            }
        }
        assertTrue("нет листа OOXML", entries.containsKey("xl/worksheets/sheet1.xml"))
        assertTrue(
            "значение не попало в лист",
            entries.getValue("xl/worksheets/sheet1.xml").contains("Дрель")
        )
    }

    @Test
    fun `csv export writes off the main thread with utf8 bom`() = runTest {
        val sink = ByteArrayOutputStream()
        val rec = RecordingStream(sink)
        val caller = Thread.currentThread()
        val ctx = app()
        val uri = Uri.parse("content://shkaff.export/items.csv")
        shadowOf(ctx.contentResolver).registerOutputStream(uri, rec)

        ExportVm().writeToUri(ctx, uri, sheet, ExportVm.Fmt.CSV)

        assertOffMainThread(rec.writeThreads, caller)
        val bytes = sink.toByteArray()
        assertEquals("BOM 1", 0xEF, bytes[0].toInt() and 0xFF)
        assertEquals("BOM 2", 0xBB, bytes[1].toInt() and 0xFF)
        assertEquals("BOM 3", 0xBF, bytes[2].toInt() and 0xFF)
        assertTrue("значение не попало в csv", String(bytes, Charsets.UTF_8).contains("Дрель"))
    }

    // Публичный вход не должен терять обработку сбоя записи: ошибка в error, busy гасится.
    @Test
    fun `exportToUri reports a failed write and clears busy`() {
        val ctx = app()
        val uri = Uri.parse("content://shkaff.export/broken.csv")
        shadowOf(ctx.contentResolver).registerOutputStream(
            uri,
            object : OutputStream() {
                override fun write(b: Int) {
                    throw IOException("диск закончился")
                }

                override fun write(b: ByteArray, off: Int, len: Int) {
                    throw IOException("диск закончился")
                }
            }
        )
        val vm = ExportVm()
        vm.exportToUri(ctx, uri, ExportVm.Kind.ITEMS, ExportVm.Fmt.CSV)

        var waited = 0
        while (vm.busy.value && waited < 5000) {
            Thread.sleep(20)
            waited += 20
        }
        assertEquals("экспорт не завершился", false, vm.busy.value)
        assertTrue(
            "текст ошибки не показан: ${vm.error.value}",
            vm.error.value?.contains("диск закончился") == true
        )
        assertEquals(null, vm.message.value)
    }
}
