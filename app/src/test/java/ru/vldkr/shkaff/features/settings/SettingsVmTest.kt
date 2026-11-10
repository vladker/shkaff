package ru.vldkr.shkaff.features.settings

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.ActiveRole

// T-009: настройки объявлены зоной ADMIN (Access.ADMIN) — редактировать значения может
// только профиль с полным доступом; VM обязан отклонять правки остальных ролей.
@RunWith(RobolectricTestRunner::class)
class SettingsVmTest {

    @After
    fun restore() {
        ActiveRole.set("admin")
        Deps.setThemeLight(false)
        Deps.setNumberingAuto(true)
        Deps.setExpiryThresholdDays(90)
    }

    @Test
    fun `roles without admin cannot change settings`() {
        Deps.setThemeLight(false)
        Deps.setNumberingAuto(true)
        Deps.setExpiryThresholdDays(90)
        for (r in listOf("view", "add", "move")) {
            ActiveRole.set(r)
            val vm = SettingsVm()
            vm.setTheme(true)
            vm.setNumberingAuto(false)
            vm.setExpiryThreshold(30)
            assertEquals("$r тема", false, vm.ui.value.themeIsLight)
            assertEquals("$r тема в базе", false, Deps.themeIsLight())
            assertEquals("$r нумерация", true, Deps.numberingAuto())
            assertEquals("$r сроки", 90, Deps.expiryThresholdDays())
        }
    }

    @Test
    fun `admin changes settings and ui follows`() {
        Deps.setThemeLight(false)
        Deps.setNumberingAuto(true)
        Deps.setExpiryThresholdDays(90)
        ActiveRole.set("admin")
        val vm = SettingsVm()
        vm.setTheme(true)
        assertEquals(true, Deps.themeIsLight())
        assertEquals(true, vm.ui.value.themeIsLight)
        vm.setNumberingAuto(false)
        assertEquals(false, Deps.numberingAuto())
        assertEquals(false, vm.ui.value.numberingAuto)
        vm.setExpiryThreshold(30)
        assertEquals(30, Deps.expiryThresholdDays())
        assertEquals(30, vm.ui.value.expiryThreshold)
    }
}
