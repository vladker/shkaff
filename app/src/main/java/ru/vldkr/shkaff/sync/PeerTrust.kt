package ru.vldkr.shkaff.sync

import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.domain.access.Role

// Флаги доверия пир-базы (US-G2): роль (US-G1) + область видимости по хранилищам.
// role — что устройство может делать (view — только читать, add/move/admin — и менять);
// scope — "all" (вся база) или "some" (только перечисленные хранилища и их поддерево).
data class PeerTrust(
    val role: Role = Role.ADMIN,
    val scope: String = SCOPE_ALL,
    val storages: List<String> = emptyList()
) {
    companion object {
        const val SCOPE_ALL = "all"
        const val SCOPE_SOME = "some"

        // Новый пир подключается «на доверии по умолчанию» — полный доступ;
        // админ может сузить область и роль в экране «Федерация».
        val DEFAULT = PeerTrust(Role.ADMIN, SCOPE_ALL)

        fun parse(json: String?): PeerTrust = try {
            val o = JSONObject(json ?: "")
            val scope = if (o.optString("scope") == SCOPE_SOME) SCOPE_SOME else SCOPE_ALL
            val arr = o.optJSONArray("storages")
            PeerTrust(
                role = Role.parse(o.optString("role", Role.ADMIN.preset)),
                scope = scope,
                storages = if (scope == SCOPE_SOME && arr != null) {
                    (0 until arr.length()).map { arr.getString(it) }
                } else emptyList()
            )
        } catch (e: Exception) {
            DEFAULT
        }

        fun toJson(t: PeerTrust): String = JSONObject().apply {
            put("role", t.role.preset)
            put("scope", t.scope)
            if (t.scope == SCOPE_SOME) put("storages", JSONArray(t.storages))
        }.toString()

        fun label(t: PeerTrust): String = when (t.scope) {
            SCOPE_SOME -> "хранилищ: ${t.storages.size}"
            else -> "вся база"
        }
    }
}
