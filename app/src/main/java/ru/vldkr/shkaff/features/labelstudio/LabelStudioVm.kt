package ru.vldkr.shkaff.features.labelstudio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.domain.links.AppLink
import ru.vldkr.shkaff.features.labelstudio.domain.BarcodeElement
import ru.vldkr.shkaff.features.labelstudio.domain.ContentSource
import ru.vldkr.shkaff.features.labelstudio.domain.FieldElement
import ru.vldkr.shkaff.features.labelstudio.domain.ImageElement
import ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc
import ru.vldkr.shkaff.features.labelstudio.domain.LabelElement
import ru.vldkr.shkaff.features.labelstudio.domain.LabelRenderer
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps
import ru.vldkr.shkaff.features.labelstudio.domain.PageSettings
import ru.vldkr.shkaff.features.labelstudio.domain.PaletteType
import ru.vldkr.shkaff.features.labelstudio.domain.QrElement
import ru.vldkr.shkaff.features.labelstudio.domain.ShapeElement
import ru.vldkr.shkaff.features.labelstudio.domain.ShapeType
import ru.vldkr.shkaff.features.labelstudio.domain.TextElement
import ru.vldkr.shkaff.features.labelstudio.domain.withPosition
import ru.vldkr.shkaff.features.labelstudio.domain.withSize
import ru.vldkr.shkaff.util.newId

class LabelStudioVm(
    private val deps: LabelStudioDeps,
    private val kind: String,
    private val subjectId: String,
    private val templateId: String?
) : ViewModel() {

    data class Ui(
        val loading: Boolean = true,
        val error: String? = null,
        val subject: LabelStudioDeps.Subject? = null,
        val doc: LabelDoc? = null,
        val bindings: Map<String, String> = emptyMap(),
        val selectedId: String? = null,
        val zoom: Float = 1f,
        val templates: List<LabelStudioDeps.TemplateSummary> = emptyList(),
        val printers: List<LabelStudioDeps.PrinterProfile> = emptyList(),
        val selectedPrinterId: String? = null,
        val printing: Boolean = false,
        val printResult: String? = null,
        val showInspector: Boolean = false,
        val showPrinters: Boolean = false,
        val showTemplates: Boolean = false,
        val dirty: Boolean = false
    )

    private val _ui = MutableStateFlow(Ui())
    val ui: StateFlow<Ui> = _ui

    private var doc: LabelDoc? = null
    private var bindings: Map<String, String> = emptyMap()

    init {
        viewModelScope.launch { load() }
    }

    private suspend fun load() {
        _ui.value = _ui.value.copy(loading = true, error = null)
        val subject = deps.loadSubject(kind, subjectId)
        if (subject == null) {
            _ui.value = _ui.value.copy(loading = false, error = "Объект не найден")
            return
        }
        val templates = deps.loadTemplates(kind)
        val printers = deps.loadPrinters()
        val loaded = deps.loadTemplateDoc(kind, templateId) ?: deps.loadTemplateDoc(kind, null)
        val d = loaded ?: defaultDoc(subject)
        doc = d
        bindings = buildBindings(subject)
        _ui.value = _ui.value.copy(
            loading = false,
            subject = subject,
            doc = d,
            bindings = bindings,
            templates = templates,
            printers = printers,
            selectedPrinterId = printers.firstOrNull { it.isDefault }?.id ?: printers.firstOrNull()?.id
        )
    }

    private fun defaultDoc(subject: LabelStudioDeps.Subject): LabelDoc {
        val page = PageSettings()
        val innerW = page.printableWidthMm - page.marginLeftMm - page.marginRightMm
        return LabelDoc(
            name = "Этикетка ${subject.name}",
            page = page,
            elements = listOf(
                QrElement(
                    xMm = 4f, yMm = 4f, widthMm = 20f, heightMm = 20f,
                    content = ContentSource.Field("code")
                ),
                TextElement(
                    xMm = 26f, yMm = 4f, widthMm = innerW - 26f, heightMm = 8f,
                    content = ContentSource.Field("name"), sizeMm = 3.5f, bold = true
                ),
                FieldElement(
                    xMm = 26f, yMm = 12f, widthMm = innerW - 26f, heightMm = 4f,
                    key = "code", label = "Код:", sizeMm = 2.5f
                )
            )
        )
    }

    private fun buildBindings(subject: LabelStudioDeps.Subject): Map<String, String> {
        val m = HashMap<String, String>()
        m["name"] = subject.name
        m["code"] = subject.code
        m["id"] = subject.id
        m["appLink"] = AppLink.urlFor(subject.code)
        m.putAll(subject.attrs)
        return m
    }

    fun select(id: String?) {
        _ui.value = _ui.value.copy(selectedId = id)
    }

    fun selectPrinter(id: String) {
        _ui.value = _ui.value.copy(selectedPrinterId = id)
    }

    fun zoomIn() {
        _ui.value = _ui.value.copy(zoom = (_ui.value.zoom * 1.25f).coerceAtMost(4f))
    }

    fun zoomOut() {
        _ui.value = _ui.value.copy(zoom = (_ui.value.zoom / 1.25f).coerceAtLeast(0.5f))
    }

    fun updateElement(el: LabelElement) {
        val d = doc ?: return
        val updated = d.copy(
            elements = d.elements.map { if (it.id == el.id) el else it },
            updatedAt = System.currentTimeMillis()
        )
        doc = updated
        _ui.value = _ui.value.copy(doc = updated, dirty = true)
    }

    fun addElement(type: PaletteType) {
        val d = doc ?: return
        val el: LabelElement = when (type) {
            PaletteType.QR -> QrElement(xMm = 4f, yMm = 4f, widthMm = 20f, heightMm = 20f)
            PaletteType.BARCODE -> BarcodeElement(xMm = 4f, yMm = 4f, widthMm = 40f, heightMm = 10f)
            PaletteType.TEXT -> TextElement(xMm = 4f, yMm = 4f, widthMm = 40f, heightMm = 8f)
            PaletteType.FIELD -> FieldElement(xMm = 4f, yMm = 4f, widthMm = 40f, heightMm = 4f)
            PaletteType.IMAGE -> ImageElement(xMm = 4f, yMm = 4f, widthMm = 15f, heightMm = 15f)
            PaletteType.LINE -> ShapeElement(xMm = 4f, yMm = 4f, widthMm = 40f, heightMm = 0.5f, shape = ShapeType.LINE)
            PaletteType.RECT -> ShapeElement(xMm = 4f, yMm = 4f, widthMm = 20f, heightMm = 10f, shape = ShapeType.RECT)
        }
        val updated = d.copy(elements = d.elements + el, updatedAt = System.currentTimeMillis())
        doc = updated
        _ui.value = _ui.value.copy(doc = updated, selectedId = el.id, dirty = true)
    }

    fun deleteSelected() {
        val d = doc ?: return
        val id = _ui.value.selectedId ?: return
        val updated = d.copy(
            elements = d.elements.filterNot { it.id == id },
            updatedAt = System.currentTimeMillis()
        )
        doc = updated
        _ui.value = _ui.value.copy(doc = updated, selectedId = null, dirty = true)
    }

    fun duplicateSelected() {
        val d = doc ?: return
        val id = _ui.value.selectedId ?: return
        val src = d.elements.find { it.id == id } ?: return
        val copy: LabelElement = when (src) {
            is QrElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
            is BarcodeElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
            is TextElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
            is FieldElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
            is ImageElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
            is ShapeElement -> src.copy(id = newId(), xMm = src.xMm + 2f, yMm = src.yMm + 2f)
        }
        val updated = d.copy(elements = d.elements + copy, updatedAt = System.currentTimeMillis())
        doc = updated
        _ui.value = _ui.value.copy(doc = updated, selectedId = copy.id, dirty = true)
    }

    fun moveSelected(dxMm: Float, dyMm: Float) {
        val d = doc ?: return
        val id = _ui.value.selectedId ?: return
        val el = d.elements.find { it.id == id } ?: return
        updateElement(el.withPosition(el.xMm + dxMm, el.yMm + dyMm))
    }

    fun resizeSelected(id: String, xMm: Float, yMm: Float, wMm: Float, hMm: Float) {
        val d = doc ?: return
        val el = d.elements.find { it.id == id } ?: return
        updateElement(el.withPosition(xMm, yMm).withSize(wMm, hMm))
    }

    fun updatePage(p: PageSettings) {
        val d = doc ?: return
        val updated = d.copy(page = p, updatedAt = System.currentTimeMillis())
        doc = updated
        _ui.value = _ui.value.copy(doc = updated, dirty = true)
    }

    fun save() {
        val d = doc ?: return
        viewModelScope.launch {
            val summary = deps.saveTemplateDoc(kind, d)
            _ui.value = _ui.value.copy(
                dirty = false,
                templates = _ui.value.templates.filterNot { it.id == summary.id } + summary
            )
        }
    }

    fun print() {
        val d = doc ?: return
        val profile = _ui.value.printers.find { it.id == _ui.value.selectedPrinterId }
            ?: _ui.value.printers.firstOrNull { it.isDefault }
            ?: _ui.value.printers.firstOrNull()
        if (profile == null) {
            _ui.value = _ui.value.copy(printResult = "Нет принтеров")
            return
        }
        viewModelScope.launch {
            _ui.value = _ui.value.copy(printing = true, printResult = null)
            val bmp = LabelRenderer.render(d, bindings, dpi = profile.dpi)
            val mono = LabelRenderer.toMonochrome(bmp, dither = true)
            val result = deps.printBitmap(
                profile, mono, d.page.printableWidthMm,
                d.page.feedLines, profile.offsetXmm, profile.offsetYmm
            )
            if (result.isSuccess) {
                deps.markLabelled(kind, subjectId)
                _ui.value = _ui.value.copy(printing = false, printResult = "Отправлено на печать")
            } else {
                _ui.value = _ui.value.copy(
                    printing = false,
                    printResult = "Ошибка печати: ${result.exceptionOrNull()?.message}"
                )
            }
        }
    }

    fun testPrint() {
        val profile = _ui.value.printers.firstOrNull { it.isDefault }
            ?: _ui.value.printers.firstOrNull() ?: return
        viewModelScope.launch {
            _ui.value = _ui.value.copy(printing = true)
            val r = deps.testPrint(profile)
            _ui.value = _ui.value.copy(
                printing = false,
                printResult = if (r.isSuccess) "Тест отправлен" else "Ошибка: ${r.exceptionOrNull()?.message}"
            )
        }
    }

    fun toggleInspector() {
        _ui.value = _ui.value.copy(showInspector = !_ui.value.showInspector)
    }

    fun togglePrinters() {
        _ui.value = _ui.value.copy(showPrinters = !_ui.value.showPrinters)
    }

    fun toggleTemplates() {
        _ui.value = _ui.value.copy(showTemplates = !_ui.value.showTemplates)
    }

    fun applyTemplate(t: LabelStudioDeps.TemplateSummary) {
        viewModelScope.launch {
            val d = deps.loadTemplateDoc(kind, t.id) ?: return@launch
            doc = d
            _ui.value = _ui.value.copy(doc = d, dirty = true, showTemplates = false)
        }
    }

    fun newDoc() {
        val subject = _ui.value.subject ?: return
        val d = defaultDoc(subject)
        doc = d
        _ui.value = _ui.value.copy(doc = d, selectedId = null, dirty = true, showTemplates = false)
    }

    companion object {
        fun Factory(
            deps: LabelStudioDeps,
            kind: String,
            subjectId: String,
            templateId: String?
        ) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                LabelStudioVm(deps, kind, subjectId, templateId) as T
        }
    }
}