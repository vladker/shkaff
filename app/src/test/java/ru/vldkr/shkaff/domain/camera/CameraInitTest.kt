package ru.vldkr.shkaff.domain.camera

import java.util.concurrent.ExecutionException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

// T-012 (US-I5): сбой камеры в сканере — не молча чёрное превью, а текст ошибки + «Повторить».
// Чистая логика состояний и текстов — здесь; Compose-обвязка проверяется вручную.
class CameraInitTest {

    @Test
    fun `трекер стартует с состояния инициализации`() {
        assertEquals(CamState.Initializing, CameraInitTracker().state)
    }

    @Test
    fun `сбой provider переводит в Failed с читаемым русским текстом`() {
        val tr = CameraInitTracker()
        tr.attempt()
        tr.fail(RuntimeException("boom"))
        val s = tr.state
        assertTrue("ожидался Failed, получено $s", s is CamState.Failed)
        val msg = (s as CamState.Failed).message
        assertTrue("текст без упоминания камеры: $msg", msg.contains("камер", ignoreCase = true))
    }

    @Test
    fun `нет камеры — «не найдена», даже когда причина завёрнута в ExecutionException`() {
        // ProcessCameraProvider.getInstance(..).get() бросает ExecutionException с причиной внутри.
        val e = ExecutionException(IllegalStateException("No camera present"))
        val msg = cameraErrorText(e)
        assertTrue("получено: $msg", msg.contains("не найдена", ignoreCase = true))
    }

    @Test
    fun `занятая другим приложением камера — подсказка закрыть его`() {
        val e = ExecutionException(RuntimeException("Camera in use by another client"))
        val msg = cameraErrorText(e)
        assertTrue("получено: $msg", msg.contains("занята", ignoreCase = true))
        assertTrue("получено: $msg", msg.contains("приложен", ignoreCase = true))
    }

    @Test
    fun `обрыв связи со службой камеры — отдельная подсказка`() {
        val msg = cameraErrorText(RuntimeException("Camera service disconnected"))
        assertTrue("получено: $msg", msg.contains("служб", ignoreCase = true))
    }

    @Test
    fun `отзыв разрешения на камере — SecurityException подсказывает про разрешения`() {
        val msg = cameraErrorText(SecurityException("denial of camera permission"))
        assertTrue("получено: $msg", msg.contains("разрешени", ignoreCase = true))
    }

    @Test
    fun `неизвестный сбой сохраняет подробности для диагностики`() {
        val msg = cameraErrorText(RuntimeException("some vendor failure"))
        assertTrue("получено: $msg", msg.contains("some vendor failure"))
    }

    @Test
    fun `повтор после сбоя сбрасывает ошибку и ведёт к восстановлению без перезапуска`() {
        val tr = CameraInitTracker()
        tr.attempt()
        tr.fail(RuntimeException("boom"))
        assertTrue(tr.state is CamState.Failed)
        tr.attempt() // «Повторить» = повторная инициализация
        assertEquals(CamState.Initializing, tr.state)
        tr.ready()
        assertEquals(CamState.Ready, tr.state)
    }

    @Test
    fun `рантайм-отключение камеры после Ready тоже уходит в Failed`() {
        val tr = CameraInitTracker()
        tr.attempt()
        tr.ready()
        tr.fail(RuntimeException("Camera service disconnected"))
        val s = tr.state
        assertTrue("ожидался Failed, получено $s", s is CamState.Failed)
        assertTrue((s as CamState.Failed).message.contains("служб", ignoreCase = true))
    }
}
