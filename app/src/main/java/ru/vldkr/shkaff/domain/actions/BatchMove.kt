package ru.vldkr.shkaff.domain.actions

// US-R: пакетный перенос выбранных вещей в ящик. Чистый Kotlin — только контракты
// результата и undo-снапшота; движок лежит в ItemRepository.batchMove/undoBatchMove.
data class MoveUndo(
    val itemId: String,
    val prevLocationId: String?,
    val prevUpdatedAt: Long,
    val prevDeviceLastModified: String,
)

data class BatchMoveResult(
    val moved: List<String>,
    val skipped: List<String>,
    val undo: List<MoveUndo>,
)
