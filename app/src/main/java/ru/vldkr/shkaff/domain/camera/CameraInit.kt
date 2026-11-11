package ru.vldkr.shkaff.domain.camera

// T-012 (US-I5): сбой камеры в сканере больше не молча чёрное превью.
// Чистая машина состояний инициализации + человекочитаемые русские тексты ошибок;
// Compose-обвязка (оверлей поверх превью и «Повторить») строится поверх этого.

sealed interface CamState {
    object Initializing : CamState
    object Ready : CamState
    data class Failed(val message: String) : CamState
}

// Текст отказа по цепочке причин: CameraX бросает ExecutionException с вложенной причиной,
// на части устройств сообщение приходит только в стеке классов. Классы ищем по имени,
// чтобы файл оставался чистым Kotlin (без Android-зависимостей) и тестировался на JVM.
fun cameraErrorText(t: Throwable): String {
    val chain = generateSequence<Throwable>(t) { it.cause }.toList()
    val hay = buildString {
        for (e in chain) {
            append(e.message.orEmpty().lowercase())
            append(' ')
            append(e.javaClass.name.lowercase())
            append(' ')
        }
    }
    return when {
        chain.any { it is SecurityException } || hay.contains("permission denied") ||
            hay.contains("camera permission") ->
            "Нет доступа к камере — проверьте разрешение приложения в настройках."
        hay.contains("camera in use") || hay.contains("in use by another") ||
            hay.contains("max_cameras") || hay.contains("max cameras") ||
            hay.contains("cannot connect to camera") || hay.contains("cameradisabledbydevicepolicy") ->
            "Камера занята другим приложением. Закройте его и нажмите «Повторить»."
        hay.contains("disabled by device policy") || hay.contains("camera disabled") ->
            "Камера отключена политикой устройства."
        hay.contains("disconnect") || hay.contains("evict") ->
            "Связь со службой камеры потеряна. Нажмите «Повторить»."
        hay.contains("camerainfounavailable") || hay.contains("no camera") ||
            hay.contains("no valid camera") || hay.contains("camera with the requested") ||
            hay.contains("no camera id") ->
            "Камера не найдена — на устройстве нет подходящей камеры."
        else -> {
            val detail = chain.lastOrNull()?.message?.takeIf { it.isNotBlank() }
                ?: chain.lastOrNull()?.javaClass?.simpleName ?: "неизвестная ошибка"
            "Не удалось запустить камеру: $detail"
        }
    }
}

class CameraInitTracker {
    var state: CamState = CamState.Initializing
        private set

    // Старт (и повтор по «Повторить») — каждая попытка инициализации камеры.
    fun attempt() {
        state = CamState.Initializing
    }

    fun ready() {
        state = CamState.Ready
    }

    // И отказ инициализации, и рантайм-отключение (CameraState.error) ведут в Failed.
    fun fail(t: Throwable) {
        state = CamState.Failed(cameraErrorText(t))
    }
}
