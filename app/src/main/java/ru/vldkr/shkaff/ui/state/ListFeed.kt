package ru.vldkr.shkaff.ui.state

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

// US-O8: единое состояние экранного списка вместо «пустой список == всё загрузилось».
sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Error(val message: String) : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
}

private const val ERROR_TEXT_MAX = 300

/**
 * T-040: человекочитаемый текст сбоя загрузки для error-состояния списка.
 * Стек-трейс экрану не нужен, а «что именно упало» — нужно: у пользователя нет логов.
 */
fun loadErrorText(e: Throwable): String {
    // цель по цепочке: cause не должен зациклить обход (cause == self бывает у JNI-обёрток)
    val chain = ArrayList<Throwable>(8)
    var cur: Throwable? = e
    while (cur != null && chain.size < 8 && cur !in chain) {
        chain += cur
        cur = cur.cause
    }
    val deepest = chain.last()
    // Room/SQLite сообщают о проблеме именем класса — называем её «база данных» честно.
    val database = chain.any {
        val n = it.javaClass.simpleName
        n.contains("sqlite", true) || n.contains("database", true)
    }
    val reason = deepest.message?.trim()?.takeIf { it.isNotEmpty() }
        ?: deepest.javaClass.simpleName.ifEmpty { "неизвестная ошибка" }
    val head = if (database) "Не удалось прочитать базу данных" else "Не удалось загрузить данные"
    val text = "$head: $reason"
    return if (text.length <= ERROR_TEXT_MAX) text else text.take(ERROR_TEXT_MAX - 1) + "…"
}

/**
 * T-040: подписка экранного списка на репозиторный flow с честными ветками.
 *
 * До первой эмиссии — [UiState.Loading]: экран рисует [ListSkeleton], а не «список пуст»
 * (иначе на долю секунды врёт «Ничего не найдено» / «Хранилищ пока нет»). Сбой Room/DAO
 * превращается в [UiState.Error] с текстом: без catch поток молча умирал, а экран
 * оставался в вечном skeleton. Отмена области (закрыт экран/VM) ошибкой не считается.
 *
 * Источник ленивый (`() -> Flow<T>`), поэтому [retry] переподписывается заново — кнопка
 * «Повторить» в error-состоянии реально перезапускает запрос.
 */
class ListFeed<T>(private val scope: CoroutineScope, private val source: () -> Flow<T>) {

    private val _state = MutableStateFlow<UiState<T>>(UiState.Loading)
    val state: StateFlow<UiState<T>> get() = _state

    private val _gate = MutableStateFlow<UiState<Nothing>?>(UiState.Loading)
    /** Ветка экрана: Error — текст сбоя, null — данные готовы, иначе ещё грузится. */
    val gate: StateFlow<UiState<Nothing>?> get() = _gate

    private var job: Job? = null

    fun start() {
        job?.cancel()
        publish(UiState.Loading)
        job = scope.launch {
            try {
                source().collect { publish(UiState.Success(it)) }
            } catch (c: CancellationException) {
                publish(UiState.Loading)
                throw c
            } catch (e: Throwable) {
                publish(UiState.Error(loadErrorText(e)))
            }
        }
    }

    fun retry() = start()

    fun stop() {
        job?.cancel()
        job = null
        publish(UiState.Loading)
    }

    private fun publish(next: UiState<T>) {
        _state.value = next
        _gate.value = when (next) {
            is UiState.Error -> next
            is UiState.Success -> null
            UiState.Loading -> UiState.Loading
        }
    }
}

/** Гейт нескольких подписок одного экрана: сбой важнее загрузки, null — всё живо. */
fun mergeGate(a: UiState<Nothing>?, b: UiState<Nothing>?): UiState<Nothing>? = when {
    a is UiState.Error -> a
    b is UiState.Error -> b
    a is UiState.Loading -> a
    b is UiState.Loading -> b
    else -> null
}

/** Один гейт на все подписки экрана — по нему экран решает skeleton/ошибка/данные. */
fun mergeFeeds(feeds: List<ListFeed<*>>): Flow<UiState<Nothing>?> {
    if (feeds.isEmpty()) return flowOf(null)
    val gates: List<Flow<UiState<Nothing>?>> = feeds.map { it.gate }
    return gates.drop(1).fold(gates.first()) { acc, g -> combine(acc, g) { x, y -> mergeGate(x, y) } }
}
