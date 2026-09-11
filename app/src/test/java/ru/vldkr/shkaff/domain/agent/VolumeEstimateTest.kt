package ru.vldkr.shkaff.domain.agent

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.domain.capacity.CapacityUsage
import java.util.Locale

@RunWith(RobolectricTestRunner::class)
class VolumeEstimateTest {

    private var savedLocale: Locale? = null

    @Before
    fun setUp() {
        savedLocale = Locale.getDefault()
        Locale.setDefault(Locale.US)
    }

    @After
    fun tearDown() {
        savedLocale?.let { Locale.setDefault(it) }
    }

    private val ids = mapOf(
        "id-1" to "Мука",
        "id-2" to "Дрель",
        "id-3" to "Кружка"
    )

    @Test
    fun parse_validJson() {
        val text = """
        {
          "proposals": [
            {"id":"id-1","volume_liters":1.5,"weight_kg":1.2,"reason":"пакет 1 кг"},
            {"id":"id-2","volume_liters":4.0,"weight_kg":1.9,"reason":"перфоратор с кейсом"}
          ]
        }
        """.trimIndent()
        val p = VolumeEstimate.parse(text, ids)
        assertEquals(2, p.size)
        assertEquals("Мука", p[0].name)
        assertEquals(1.5, p[0].volumeLiters, 0.0001)
        assertEquals(1.2, p[0].weightKg, 0.0001)
        assertEquals("пакет 1 кг", p[0].reason)
    }

    @Test
    fun parse_markdownFenceAndFreeText() {
        val text = """
        Вот оценки:
        ```json
        {"proposals":[{"id":"id-3","volume_liters":0.35,"weight_kg":0.3}]}
        ```
        Надеюсь, поможет.
        """.trimIndent()
        val p = VolumeEstimate.parse(text, ids)
        assertEquals(1, p.size)
        assertEquals("Кружка", p[0].name)
        assertEquals(0.35, p[0].volumeLiters, 0.0001)
    }

    @Test
    fun parse_bareArray() {
        val text = "Оценки: [{\"id\":\"id-1\",\"volume_liters\":2.0,\"weight_kg\":1.5}]"
        val p = VolumeEstimate.parse(text, ids)
        assertEquals(1, p.size)
        assertEquals("Мука", p[0].name)
    }

    @Test
    fun parse_dropsUnknownIdsAndBadVolumes() {
        val text = """
        {"proposals":[
          {"id":"id-999","volume_liters":3.0,"weight_kg":1.0},
          {"id":"id-1","volume_liters":-2.0,"weight_kg":1.0},
          {"id":"id-2","volume_liters":0,"weight_kg":1.0},
          {"id":"id-3","volume_liters":0.5,"weight_kg":-4.0}
        ]}
        """.trimIndent()
        val p = VolumeEstimate.parse(text, ids)
        // Только id-3: отрицательная и нулевая масса обнуляются, но объём валиден.
        assertEquals(1, p.size)
        assertEquals("Кружка", p[0].name)
        assertEquals(0.0, p[0].weightKg, 0.0001)
    }

    @Test
    fun parse_garbageReturnsEmpty() {
        assertTrue(VolumeEstimate.parse("Не могу оценить объём без фото", ids).isEmpty())
        assertTrue(VolumeEstimate.parse("", ids).isEmpty())
        assertTrue(VolumeEstimate.parse("""{"proposals":[]}""", ids).isEmpty())
        assertTrue(VolumeEstimate.parse("""{"proposals":"текст"}""", ids).isEmpty())
    }

    @Test
    fun parse_clampsAbsurdValues() {
        val text = """{"proposals":[{"id":"id-1","volume_liters":999999.0,"weight_kg":999999.0}]}"""
        val p = VolumeEstimate.parse(text, ids)
        assertEquals(1, p.size)
        assertEquals(VolumeEstimate.MAX_VOLUME, p[0].volumeLiters, 0.0001)
        assertEquals(VolumeEstimate.MAX_WEIGHT, p[0].weightKg, 0.0001)
    }

    @Test
    fun buildPrompt_containsAllItems() {
        val prompt = VolumeEstimate.buildPrompt(
            listOf(
                VolumeItemLine("id-1", "Мука", "M-01", "Продукты", "1 кг", "пакет"),
                VolumeItemLine("id-2", "Дрель", "", "", "", "")
            )
        )
        assertTrue(prompt.contains("id-1"))
        assertTrue(prompt.contains("Мука"))
        assertTrue(prompt.contains("Продукты"))
        assertTrue(prompt.contains("id-2"))
        assertTrue(prompt.contains("proposals"))
    }

    @Test
    fun fitText_noLimits() {
        val u = CapacityUsage(volumeLiters = 2.0, weightKg = 1.0)
        assertEquals("ёмкость не задана", FitReport.fitText(u))
    }

    @Test
    fun fitText_freeSpace() {
        val u = CapacityUsage(volumeLiters = 2.3, weightKg = 0.5, capacityVolumeLiters = 5.0)
        val t = FitReport.fitText(u)
        assertTrue(t.contains("2.3/5.0 л"))
        assertTrue(t.contains("свободно 2.7 л"))
    }

    @Test
    fun fitText_overflow() {
        val u = CapacityUsage(volumeLiters = 6.2, weightKg = 1.0, capacityVolumeLiters = 5.0)
        val t = FitReport.fitText(u)
        assertTrue(t.contains("6.2/5.0 л"))
        assertTrue(t.contains("переполнено на 1.2 л"))
    }

    @Test
    fun fitText_brimReserve() {
        // «Не до упора» — лимит 10 л эффективен как 9 л.
        val u = CapacityUsage(volumeLiters = 9.5, weightKg = 0.0, capacityVolumeLiters = 10.0, dontFillToBrim = true)
        val t = FitReport.fitText(u)
        assertTrue(t.contains("9.0 л"))
        assertTrue(t.contains("переполнено на 0.5 л"))
    }

    @Test
    fun fitText_volumeAndWeight() {
        val u = CapacityUsage(volumeLiters = 1.0, weightKg = 3.0, capacityVolumeLiters = 5.0, capacityWeightKg = 4.0)
        val t = FitReport.fitText(u)
        assertTrue(t.contains("свободно 4.0 л"))
        assertTrue(t.contains("масса 3.0/4.0 кг"))
    }
}
