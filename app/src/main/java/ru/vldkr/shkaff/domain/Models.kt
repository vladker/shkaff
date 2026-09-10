package ru.vldkr.shkaff.domain

data class ItemData(
    val name: String,
    val code: String = "",
    val description: String = "",
    val attributes: Map<String, String> = emptyMap(),
    val locationId: String? = null,
    val photoPath: String? = null,
    val expiryDate: String? = null,
    val ean: String? = null,
    val tags: List<String> = emptyList(),
    val volumeLiters: Double = 0.0,
    val weightKg: Double = 0.0
)

data class LocationData(
    val storageId: String,
    val parentId: String? = null,
    val label: String = "",
    val name: String = "",
    val attributes: Map<String, String> = emptyMap(),
    val capacityVolumeLiters: Double? = null,
    val capacityWeightKg: Double? = null,
    val dontFillToBrim: Boolean = false,
    val isFull: Boolean = false
)

data class StorageData(
    val name: String,
    val code: String = "",
    val description: String = "",
    val attributes: Map<String, String> = emptyMap(),
    val parentId: String? = null,
    val capacityVolumeLiters: Double? = null,
    val capacityWeightKg: Double? = null,
    val dontFillToBrim: Boolean = false,
    val isFull: Boolean = false
)
