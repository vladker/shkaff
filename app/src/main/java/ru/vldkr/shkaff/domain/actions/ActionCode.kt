package ru.vldkr.shkaff.domain.actions

// Служебные QR (US-F1): QR кодирует действие. Формат — компактная строка
//   shkaff:v1:<verb>:<entityType>:<entityId>
// (entityType/entityId — опционально). Чистый Kotlin — парсится и в тестах.
// Установка без приложения (US-I3): INSTALL_URL — обычная HTTPS-ссылка на релиз,
// скан на устройстве без «Шкафа» показывает страницу, а не падает.
object ActionCode {
    const val PREFIX = "shkaff:"
    // US-I3: ссылка обновляется, когда появится настоящий релизный адрес.
    const val INSTALL_URL = "https://github.com/vldkr/shkaff/releases/latest"

    object Verb {
        const val ADD = "add"           // добавить объект (итм/хранилище/ящик)
        const val MOVE = "move"         // переложить объект
        const val DELETE = "delete"     // удалить (мягко, с подтверждением)
        const val LEND = "lend"         // временная выдача
        const val EXPORT = "export"     // экспорт/бэкап
        const val JOURNAL = "journal"   // показать журнал действий
    }

    data class Parsed(
        val valid: Boolean,
        val verb: String = "",
        val entityType: String = "",
        val entityId: String = ""
    )

    fun isServiceCode(raw: String): Boolean = raw.startsWith(PREFIX)

    fun encode(verb: String, entityType: String = "", entityId: String = ""): String =
        "$PREFIX${join(verb, entityType, entityId)}"

    // Приватно собираем через разделитель; UUID не содержат ':', поэтому безопасно.
    private fun join(verb: String, entityType: String = "", entityId: String = ""): String =
        listOf("v1", verb, entityType, entityId).joinToString(":")

    fun parse(raw: String): Parsed {
        if (!raw.startsWith(PREFIX)) return Parsed(false)
        val parts = raw.removePrefix(PREFIX).split(":")
        val version = parts.getOrNull(0)
        val verb = parts.getOrNull(1).orEmpty()
        val entityType = parts.getOrNull(2).orEmpty()
        val entityId = parts.getOrNull(3).orEmpty()
        if (version != "v1" || verb.isBlank()) return Parsed(false)
        return Parsed(true, verb, entityType, entityId)
    }
}