package ru.vldkr.shkaff.features.labelstudio.domain

import android.graphics.Bitmap

/**
 * Абстракция над приложением для LabelStudio: загрузка объекта (вещь/ящик/шкаф),
 * шаблонов, принтеров и печать. Реализация — ShkaffLabelStudioDeps (адаптер к Deps).
 */
interface LabelStudioDeps {

    data class Subject(
        val kind: String,
        val id: String,
        val name: String,
        val code: String,
        val attrs: Map<String, String>
    )

    data class TemplateSummary(
        val id: String,
        val name: String
    )

    data class PrinterProfile(
        val id: String,
        val name: String,
        val transport: String,
        val physicalPaperWidthMm: Float = 58f,
        val printableWidthMm: Float = 48f,
        val dpi: Int = 203,
        val paperType: String = "continuous",
        val gapMm: Float = 2.5f,
        val feedLines: Int = 3,
        val offsetXmm: Float = 0f,
        val offsetYmm: Float = 0f,
        val isDefault: Boolean = false
    )

    suspend fun loadSubject(kind: String, id: String): Subject?

    suspend fun loadTemplates(entityKind: String): List<TemplateSummary>

    /** templateId == null — дефолтный документ для entityKind. */
    suspend fun loadTemplateDoc(entityKind: String, templateId: String?): LabelDoc?

    suspend fun saveTemplateDoc(entityKind: String, doc: LabelDoc): TemplateSummary

    suspend fun loadPrinters(): List<PrinterProfile>

    suspend fun printBitmap(
        profile: PrinterProfile,
        bmp: Bitmap,
        widthMm: Float,
        feedLines: Int,
        offsetXmm: Float,
        offsetYmm: Float
    ): Result<Unit>

    suspend fun testPrint(profile: PrinterProfile): Result<Unit>

    suspend fun markLabelled(kind: String, id: String)
}