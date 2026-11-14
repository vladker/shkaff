package ru.vldkr.shkaff.features.labelstudio

import android.graphics.Bitmap
import android.graphics.Color
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.LabelDocEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc
import ru.vldkr.shkaff.features.labelstudio.domain.LabelDocCodec
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps.PrinterProfile
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps.Subject
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps.TemplateSummary
import ru.vldkr.shkaff.util.newUlid
import java.util.concurrent.ConcurrentHashMap

/**
 * Адаптер LabelStudio к приложению: объекты (вещь/ящик/шкаф) через Deps.items/locations/storages,
 * документы — через label_doc, печать — через PrintManager.printBitmap (тот же путь, что и старые этикетки).
 */
object ShkaffLabelStudioDeps : LabelStudioDeps {

    // Профили принтеров нужны для печати целиком (транспорт host/bt_mac), поэтому держим сущности.
    private val printerEntities = ConcurrentHashMap<String, PrinterProfileEntity>()

    override suspend fun loadSubject(kind: String, id: String): Subject? = when (kind) {
        "item" -> Deps.items.byId(id)?.let {
            Subject("item", it.id, it.name, it.code, AttrJson.toMap(it.attributes))
        }
        "location" -> Deps.locations.byId(id)?.let {
            Subject("location", it.id, it.name.ifBlank { it.label }, it.label, AttrJson.toMap(it.attributes))
        }
        "storage" -> Deps.storages.byId(id)?.let {
            Subject("storage", it.id, it.name, it.code, AttrJson.toMap(it.attributes))
        }
        // T-016 (US-E2): стек — субъект этикетки; QR несёт номер стека, а пустой
        // номер стеку присваивается при выдаче (как вещи) — пустой QR печатать нельзя.
        "stack" -> Deps.stacks.byId(id)?.let {
            val code = it.code.ifBlank {
                newUlid().also { c -> Deps.stacks.rename(it.id, it.name, c) }
            }
            Subject("stack", it.id, it.name.ifBlank { "Стек" }, code, emptyMap())
        }
        else -> null
    }

    override suspend fun loadTemplates(entityKind: String): List<TemplateSummary> =
        Deps.db.labelDocDao().byKind(entityKind).map { TemplateSummary(it.id, it.name) }

    override suspend fun loadTemplateDoc(entityKind: String, templateId: String?): LabelDoc? {
        val entity = if (templateId != null) {
            Deps.db.labelDocDao().byId(templateId)
        } else {
            Deps.db.labelDocDao().defaultByKind(entityKind)
        } ?: return null
        return runCatching { LabelDocCodec.fromJson(entity.doc_json) }.getOrNull()
    }

    override suspend fun saveTemplateDoc(entityKind: String, doc: LabelDoc): TemplateSummary {
        val dao = Deps.db.labelDocDao()
        val now = System.currentTimeMillis()
        // T-067: повторное сохранение того же id — правка, а не новый макет:
        // «по умолчанию» и created_at берём из существующей строки, иначе правка
        // дефолтного макета снимала дефолт у вида и двигала created_at (LWW при слиянии).
        val current = dao.byId(doc.id)
        val entity = LabelDocEntity(
            id = doc.id,
            name = doc.name,
            entity_kind = entityKind,
            doc_json = LabelDocCodec.toJson(doc),
            is_default = current?.is_default ?: dao.byKind(entityKind).isEmpty(),
            created_at = current?.created_at ?: now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = Deps.deviceId
        )
        dao.upsert(entity)
        return TemplateSummary(entity.id, entity.name)
    }

    override suspend fun loadPrinters(): List<PrinterProfile> {
        return Deps.db.printerDao().allWithDeleted()
            .filter { it.deleted_at == null }
            .map { e ->
                printerEntities[e.id] = e
                PrinterProfile(
                    id = e.id,
                    name = e.name,
                    transport = e.transport,
                    physicalPaperWidthMm = e.paper_width_mm.toFloat(),
                    printableWidthMm = e.printable_width_mm.toFloat(),
                    dpi = e.dpi,
                    paperType = e.paper_type,
                    gapMm = e.gap_mm.toFloat(),
                    feedLines = e.feed_lines,
                    offsetXmm = e.offset_x_mm.toFloat(),
                    offsetYmm = e.offset_y_mm.toFloat(),
                    isDefault = e.is_default
                )
            }
    }

    override suspend fun printBitmap(
        profile: PrinterProfile,
        bmp: Bitmap,
        widthMm: Float,
        feedLines: Int,
        offsetXmm: Float,
        offsetYmm: Float
    ): Result<Unit> {
        val entity = printerEntities[profile.id] ?: return Result.failure(
            IllegalStateException("Профиль принтера не найден: ${profile.name}")
        )
        return PrintManager.printBitmap(
            profile = entity,
            bmp = bmp,
            dark = Color.BLACK,
            light = Color.WHITE,
            feedLines = feedLines,
            widthMm = widthMm.toDouble(),
            offsetXpx = LabelMath.px(offsetXmm.toDouble()),
            offsetYpx = LabelMath.px(offsetYmm.toDouble())
        )
    }

    override suspend fun testPrint(profile: PrinterProfile): Result<Unit> {
        val entity = printerEntities[profile.id] ?: return Result.failure(
            IllegalStateException("Профиль принтера не найден: ${profile.name}")
        )
        return PrintManager.testPrint(entity)
    }

    override suspend fun markLabelled(kind: String, id: String) {
        when (kind) {
            "item" -> Deps.items.markLabelled(id)
            "location" -> Deps.locations.markLabelled(id)
            "storage" -> Deps.storages.markLabelled(id)
        }
    }
}