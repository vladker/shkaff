package ru.vldkr.shkaff.domain.onboarding

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

// П4.4: строка «Профиль: X» в шапке — это подсказка про профили/федерацию.
// На одном устройстве она только путает, показываем её когда появится второе
// устройство (peer_db непустой). Чистый Kotlin, без Android.
class ProfileHeaderGateTest {

    @Test
    fun `пока устройство одно — профиль в шапке не показываем`() {
        assertNull(Onboarding.profileInHeader("Я", hasPeerDevice = false))
        assertNull(Onboarding.profileInHeader("Админ", hasPeerDevice = false))
    }

    @Test
    fun `появилось второе устройство — подсказка про профиль открывается`() {
        assertEquals("Я", Onboarding.profileInHeader("Я", hasPeerDevice = true))
    }

    @Test
    fun `нет активного профиля — нечего показывать и при пире`() {
        assertNull(Onboarding.profileInHeader(null, hasPeerDevice = true))
    }
}
