package ru.vldkr.shkaff.domain.llm

/**
 * Какие строки каталога моделей можно удалить (T-053) и как показывать
 * возобновляемую часть прерванной загрузки. Чистые функции без Android —
 * тестируются на JVM.
 */
object ModelAvailability {

    /**
     * «Удалить» нужно, когда удалять есть что или строка зависла: скачанный
     * файл, своя строка (запись в индексе), состояние ошибки (сбой мог не
     * оставить «*.part», а повторное добавление блокируется дублем), либо
     * ненулевые докачиваемые «*.part» основного или vision-файла.
     */
    fun deletable(
        got: Boolean,
        custom: Boolean,
        error: Boolean,
        partMainBytes: Long,
        partMmprojBytes: Long,
    ): Boolean = got || custom || error || partMainBytes > 0 || partMmprojBytes > 0

    /** Подсказка о докачанной части прерванной загрузки («Скачать» продолжит по Range). */
    fun partialText(partBytes: Long, totalBytes: Long): String {
        val from = if (totalBytes > 0) " из ${StorageFit.fmt(totalBytes)}" else ""
        return "загружено ${StorageFit.fmt(partBytes)}$from — «Скачать» продолжит с места остановки"
    }
}
