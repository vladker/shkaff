package ru.vldkr.shkaff.features.labels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps

// T-045: правка зонального шаблона (имени/размера) в TemplatesScreen молча
// сбрасывала layout_mode/qr_count/qr_scale/offset_x_mm/offset_y_mm/label_attrs
// и стирала logo_path — upsert REPLACE писал constructed-s-not-copy.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class TemplatesZonePreserveTest {

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    @Test
    fun `editing a zone template keeps zones fields`() {
        val dao = Deps.db.labelTemplateDao()
        val id = "zone-tpl-" + System.nanoTime()
        val createdAt = 1_700_000_000_000L
        val seed = LabelTemplateEntity(
            id = id,
            name = "Зона A 70×30 мм",
            width_mm = 70.0,
            height_mm = 30.0,
            margin_mm = 0.0,
            layout_mode = "v",
            qr_count = 2,
            qr_scale = 0.5,
            offset_x_mm = 12.5,
            offset_y_mm = 34.0,
            label_attrs = """["Цвет"]""",
            logo_path = "logo.png",
            created_at = createdAt,
            updated_at = createdAt,
            device_last_modified = "seed"
        )
        runBlocking { dao.upsert(seed) }
        try {
            val vm = TemplatesVm()
            val loaded = runBlocking { dao.byId(id) }
            assertNotNull("шаблон должен читаться из БД", loaded)
            vm.openEdit(loaded!!)
            // T-046: форма неизменяемая — правка имени идёт через Ui-state.
            vm.editForm { it.copy(name = "Зона A переименована") }
            vm.save()

            var saved: LabelTemplateEntity? = null
            var renamed = false
            repeat(40) {
                saved = runBlocking { dao.byId(id) }
                renamed = saved?.name == "Зона A переименована"
                if (renamed) return@repeat
                Thread.sleep(50)
            }
            val t = saved!!
            assertEquals("имя применилось", true, renamed)
            // Зональные поля не должны превратиться в дефолты classic-шаблона:
            assertEquals("v", t.layout_mode)
            assertEquals(2, t.qr_count)
            assertEquals(0.5, t.qr_scale, 1e-9)
            assertEquals(12.5, t.offset_x_mm, 1e-9)
            assertEquals(34.0, t.offset_y_mm, 1e-9)
            assertEquals("""["Цвет"]""", t.label_attrs)
            assertEquals("logo.png", t.logo_path)
            assertEquals(createdAt, t.created_at)
        } finally {
            runBlocking { dao.hardDelete(id) }
        }
    }
}
