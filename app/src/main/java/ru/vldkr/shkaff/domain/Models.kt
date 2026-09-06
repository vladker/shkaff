package ru.vldkr.shkaff.domain

data class ItemData(
    val name: String,
    val code: String = "",
    val description: String = "",
    val attributes: Map<String, String> = emptyMap(),
    val locationId: String? = null,
    val photoPath: String? = null,
    val expiryDate: String? = null
)

data class LocationData(
    val storageId: String,
    val parentId: String? = null,
    val label: String = "",
    val name: String = "",
    val attributes: Map<String, String> = emptyMap()
)

data class StorageData(
    val name: String,
    val description: String = "",
    val attributes: Map<String, String> = emptyMap(),
    val parentId: String? = null
)
