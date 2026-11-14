package ru.vldkr.shkaff.domain.scan

/** T-058: маршрут HID-кода по текущему пункту назначения NavHost. */
enum class ScanRoute {
    /** Экран сам потребляет код (живая подписка на ScanBus.codes или взятие lastCode по кнопке). */
    Local,

    /** Экран к шине безразличен: глобальный подписчик открывает «Вещи» с кодом как запросом. */
    OpenItems,
}

object ScanRouting {
    // Экраны, читающие lastCode по требованию (кнопка «из скана») или ведущие свой скан-процесс:
    // уводить их на «Вещи» нельзя — код нужен прямо на экране.
    private val onDemand = setOf("scan", "item-form", "labels")

    fun routeFor(route: String?): ScanRoute {
        if (route == null) return ScanRoute.OpenItems
        // «Вещи» (items/{tag}) и «Поиск» держат живую подписку на ScanBus.codes.
        if (route == "items" || route.startsWith("items/")) return ScanRoute.Local
        if (route == "search") return ScanRoute.Local
        if (onDemand.any { route == it || route.startsWith("$it/") }) return ScanRoute.Local
        return ScanRoute.OpenItems
    }
}
