package ru.vldkr.shkaff.domain.access

import kotlinx.coroutines.flow.MutableStateFlow

// Активная роль как наблюдаемое состояние (PLAN_ONBOARDING П0.2, реактив по T-009):
// UI (rememberRole) перестраивается при смене/создании/удалении профиля и не мигает VIEW
// до первой загрузки — Deps инициализирует значение после сида профиля, репозиторий
// профилей обновляет при любом изменении.
object ActiveRole {
    val role = MutableStateFlow(Role.VIEW)

    fun set(roleStr: String?) {
        role.value = Role.parse(roleStr ?: "view")
    }
}
