package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotTableDefinition extends XmlObject {
    public static final DocumentFactory<CTPivotTableDefinition> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotTableDefinition> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivottabledefinitionb188type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTChartFormats addNewChartFormats();

    CTColFields addNewColFields();

    CTColHierarchiesUsage addNewColHierarchiesUsage();

    CTColItems addNewColItems();

    CTConditionalFormats addNewConditionalFormats();

    CTDataFields addNewDataFields();

    CTExtensionList addNewExtLst();

    CTPivotFilters addNewFilters();

    CTFormats addNewFormats();

    CTLocation addNewLocation();

    CTPageFields addNewPageFields();

    CTPivotFields addNewPivotFields();

    CTPivotHierarchies addNewPivotHierarchies();

    CTPivotTableStyle addNewPivotTableStyleInfo();

    CTRowFields addNewRowFields();

    CTRowHierarchiesUsage addNewRowHierarchiesUsage();

    CTRowItems addNewRowItems();

    boolean getApplyAlignmentFormats();

    boolean getApplyBorderFormats();

    boolean getApplyFontFormats();

    boolean getApplyNumberFormats();

    boolean getApplyPatternFormats();

    boolean getApplyWidthHeightFormats();

    boolean getAsteriskTotals();

    long getAutoFormatId();

    long getCacheId();

    long getChartFormat();

    CTChartFormats getChartFormats();

    CTColFields getColFields();

    boolean getColGrandTotals();

    String getColHeaderCaption();

    CTColHierarchiesUsage getColHierarchiesUsage();

    CTColItems getColItems();

    boolean getCompact();

    boolean getCompactData();

    CTConditionalFormats getConditionalFormats();

    short getCreatedVersion();

    boolean getCustomListSort();

    String getDataCaption();

    CTDataFields getDataFields();

    boolean getDataOnRows();

    long getDataPosition();

    boolean getDisableFieldList();

    boolean getEditData();

    boolean getEnableDrill();

    boolean getEnableFieldProperties();

    boolean getEnableWizard();

    String getErrorCaption();

    CTExtensionList getExtLst();

    boolean getFieldListSortAscending();

    boolean getFieldPrintTitles();

    CTPivotFilters getFilters();

    CTFormats getFormats();

    String getGrandTotalCaption();

    boolean getGridDropZones();

    boolean getImmersive();

    long getIndent();

    boolean getItemPrintTitles();

    CTLocation getLocation();

    boolean getMdxSubqueries();

    boolean getMergeItem();

    short getMinRefreshableVersion();

    String getMissingCaption();

    boolean getMultipleFieldFilters();

    String getName();

    boolean getOutline();

    boolean getOutlineData();

    CTPageFields getPageFields();

    boolean getPageOverThenDown();

    String getPageStyle();

    long getPageWrap();

    CTPivotFields getPivotFields();

    CTPivotHierarchies getPivotHierarchies();

    String getPivotTableStyle();

    CTPivotTableStyle getPivotTableStyleInfo();

    boolean getPreserveFormatting();

    boolean getPrintDrill();

    boolean getPublished();

    CTRowFields getRowFields();

    boolean getRowGrandTotals();

    String getRowHeaderCaption();

    CTRowHierarchiesUsage getRowHierarchiesUsage();

    CTRowItems getRowItems();

    boolean getShowCalcMbrs();

    boolean getShowDataDropDown();

    boolean getShowDataTips();

    boolean getShowDrill();

    boolean getShowDropZones();

    boolean getShowEmptyCol();

    boolean getShowEmptyRow();

    boolean getShowError();

    boolean getShowHeaders();

    boolean getShowItems();

    boolean getShowMemberPropertyTips();

    boolean getShowMissing();

    boolean getShowMultipleLabel();

    boolean getSubtotalHiddenItems();

    String getTag();

    short getUpdatedVersion();

    boolean getUseAutoFormatting();

    String getVacatedStyle();

    boolean getVisualTotals();

    boolean isSetApplyAlignmentFormats();

    boolean isSetApplyBorderFormats();

    boolean isSetApplyFontFormats();

    boolean isSetApplyNumberFormats();

    boolean isSetApplyPatternFormats();

    boolean isSetApplyWidthHeightFormats();

    boolean isSetAsteriskTotals();

    boolean isSetAutoFormatId();

    boolean isSetChartFormat();

    boolean isSetChartFormats();

    boolean isSetColFields();

    boolean isSetColGrandTotals();

    boolean isSetColHeaderCaption();

    boolean isSetColHierarchiesUsage();

    boolean isSetColItems();

    boolean isSetCompact();

    boolean isSetCompactData();

    boolean isSetConditionalFormats();

    boolean isSetCreatedVersion();

    boolean isSetCustomListSort();

    boolean isSetDataFields();

    boolean isSetDataOnRows();

    boolean isSetDataPosition();

    boolean isSetDisableFieldList();

    boolean isSetEditData();

    boolean isSetEnableDrill();

    boolean isSetEnableFieldProperties();

    boolean isSetEnableWizard();

    boolean isSetErrorCaption();

    boolean isSetExtLst();

    boolean isSetFieldListSortAscending();

    boolean isSetFieldPrintTitles();

    boolean isSetFilters();

    boolean isSetFormats();

    boolean isSetGrandTotalCaption();

    boolean isSetGridDropZones();

    boolean isSetImmersive();

    boolean isSetIndent();

    boolean isSetItemPrintTitles();

    boolean isSetMdxSubqueries();

    boolean isSetMergeItem();

    boolean isSetMinRefreshableVersion();

    boolean isSetMissingCaption();

    boolean isSetMultipleFieldFilters();

    boolean isSetOutline();

    boolean isSetOutlineData();

    boolean isSetPageFields();

    boolean isSetPageOverThenDown();

    boolean isSetPageStyle();

    boolean isSetPageWrap();

    boolean isSetPivotFields();

    boolean isSetPivotHierarchies();

    boolean isSetPivotTableStyle();

    boolean isSetPivotTableStyleInfo();

    boolean isSetPreserveFormatting();

    boolean isSetPrintDrill();

    boolean isSetPublished();

    boolean isSetRowFields();

    boolean isSetRowGrandTotals();

    boolean isSetRowHeaderCaption();

    boolean isSetRowHierarchiesUsage();

    boolean isSetRowItems();

    boolean isSetShowCalcMbrs();

    boolean isSetShowDataDropDown();

    boolean isSetShowDataTips();

    boolean isSetShowDrill();

    boolean isSetShowDropZones();

    boolean isSetShowEmptyCol();

    boolean isSetShowEmptyRow();

    boolean isSetShowError();

    boolean isSetShowHeaders();

    boolean isSetShowItems();

    boolean isSetShowMemberPropertyTips();

    boolean isSetShowMissing();

    boolean isSetShowMultipleLabel();

    boolean isSetSubtotalHiddenItems();

    boolean isSetTag();

    boolean isSetUpdatedVersion();

    boolean isSetUseAutoFormatting();

    boolean isSetVacatedStyle();

    boolean isSetVisualTotals();

    void setApplyAlignmentFormats(boolean z6);

    void setApplyBorderFormats(boolean z6);

    void setApplyFontFormats(boolean z6);

    void setApplyNumberFormats(boolean z6);

    void setApplyPatternFormats(boolean z6);

    void setApplyWidthHeightFormats(boolean z6);

    void setAsteriskTotals(boolean z6);

    void setAutoFormatId(long j6);

    void setCacheId(long j6);

    void setChartFormat(long j6);

    void setChartFormats(CTChartFormats cTChartFormats);

    void setColFields(CTColFields cTColFields);

    void setColGrandTotals(boolean z6);

    void setColHeaderCaption(String str);

    void setColHierarchiesUsage(CTColHierarchiesUsage cTColHierarchiesUsage);

    void setColItems(CTColItems cTColItems);

    void setCompact(boolean z6);

    void setCompactData(boolean z6);

    void setConditionalFormats(CTConditionalFormats cTConditionalFormats);

    void setCreatedVersion(short s6);

    void setCustomListSort(boolean z6);

    void setDataCaption(String str);

    void setDataFields(CTDataFields cTDataFields);

    void setDataOnRows(boolean z6);

    void setDataPosition(long j6);

    void setDisableFieldList(boolean z6);

    void setEditData(boolean z6);

    void setEnableDrill(boolean z6);

    void setEnableFieldProperties(boolean z6);

    void setEnableWizard(boolean z6);

    void setErrorCaption(String str);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFieldListSortAscending(boolean z6);

    void setFieldPrintTitles(boolean z6);

    void setFilters(CTPivotFilters cTPivotFilters);

    void setFormats(CTFormats cTFormats);

    void setGrandTotalCaption(String str);

    void setGridDropZones(boolean z6);

    void setImmersive(boolean z6);

    void setIndent(long j6);

    void setItemPrintTitles(boolean z6);

    void setLocation(CTLocation cTLocation);

    void setMdxSubqueries(boolean z6);

    void setMergeItem(boolean z6);

    void setMinRefreshableVersion(short s6);

    void setMissingCaption(String str);

    void setMultipleFieldFilters(boolean z6);

    void setName(String str);

    void setOutline(boolean z6);

    void setOutlineData(boolean z6);

    void setPageFields(CTPageFields cTPageFields);

    void setPageOverThenDown(boolean z6);

    void setPageStyle(String str);

    void setPageWrap(long j6);

    void setPivotFields(CTPivotFields cTPivotFields);

    void setPivotHierarchies(CTPivotHierarchies cTPivotHierarchies);

    void setPivotTableStyle(String str);

    void setPivotTableStyleInfo(CTPivotTableStyle cTPivotTableStyle);

    void setPreserveFormatting(boolean z6);

    void setPrintDrill(boolean z6);

    void setPublished(boolean z6);

    void setRowFields(CTRowFields cTRowFields);

    void setRowGrandTotals(boolean z6);

    void setRowHeaderCaption(String str);

    void setRowHierarchiesUsage(CTRowHierarchiesUsage cTRowHierarchiesUsage);

    void setRowItems(CTRowItems cTRowItems);

    void setShowCalcMbrs(boolean z6);

    void setShowDataDropDown(boolean z6);

    void setShowDataTips(boolean z6);

    void setShowDrill(boolean z6);

    void setShowDropZones(boolean z6);

    void setShowEmptyCol(boolean z6);

    void setShowEmptyRow(boolean z6);

    void setShowError(boolean z6);

    void setShowHeaders(boolean z6);

    void setShowItems(boolean z6);

    void setShowMemberPropertyTips(boolean z6);

    void setShowMissing(boolean z6);

    void setShowMultipleLabel(boolean z6);

    void setSubtotalHiddenItems(boolean z6);

    void setTag(String str);

    void setUpdatedVersion(short s6);

    void setUseAutoFormatting(boolean z6);

    void setVacatedStyle(String str);

    void setVisualTotals(boolean z6);

    void unsetApplyAlignmentFormats();

    void unsetApplyBorderFormats();

    void unsetApplyFontFormats();

    void unsetApplyNumberFormats();

    void unsetApplyPatternFormats();

    void unsetApplyWidthHeightFormats();

    void unsetAsteriskTotals();

    void unsetAutoFormatId();

    void unsetChartFormat();

    void unsetChartFormats();

    void unsetColFields();

    void unsetColGrandTotals();

    void unsetColHeaderCaption();

    void unsetColHierarchiesUsage();

    void unsetColItems();

    void unsetCompact();

    void unsetCompactData();

    void unsetConditionalFormats();

    void unsetCreatedVersion();

    void unsetCustomListSort();

    void unsetDataFields();

    void unsetDataOnRows();

    void unsetDataPosition();

    void unsetDisableFieldList();

    void unsetEditData();

    void unsetEnableDrill();

    void unsetEnableFieldProperties();

    void unsetEnableWizard();

    void unsetErrorCaption();

    void unsetExtLst();

    void unsetFieldListSortAscending();

    void unsetFieldPrintTitles();

    void unsetFilters();

    void unsetFormats();

    void unsetGrandTotalCaption();

    void unsetGridDropZones();

    void unsetImmersive();

    void unsetIndent();

    void unsetItemPrintTitles();

    void unsetMdxSubqueries();

    void unsetMergeItem();

    void unsetMinRefreshableVersion();

    void unsetMissingCaption();

    void unsetMultipleFieldFilters();

    void unsetOutline();

    void unsetOutlineData();

    void unsetPageFields();

    void unsetPageOverThenDown();

    void unsetPageStyle();

    void unsetPageWrap();

    void unsetPivotFields();

    void unsetPivotHierarchies();

    void unsetPivotTableStyle();

    void unsetPivotTableStyleInfo();

    void unsetPreserveFormatting();

    void unsetPrintDrill();

    void unsetPublished();

    void unsetRowFields();

    void unsetRowGrandTotals();

    void unsetRowHeaderCaption();

    void unsetRowHierarchiesUsage();

    void unsetRowItems();

    void unsetShowCalcMbrs();

    void unsetShowDataDropDown();

    void unsetShowDataTips();

    void unsetShowDrill();

    void unsetShowDropZones();

    void unsetShowEmptyCol();

    void unsetShowEmptyRow();

    void unsetShowError();

    void unsetShowHeaders();

    void unsetShowItems();

    void unsetShowMemberPropertyTips();

    void unsetShowMissing();

    void unsetShowMultipleLabel();

    void unsetSubtotalHiddenItems();

    void unsetTag();

    void unsetUpdatedVersion();

    void unsetUseAutoFormatting();

    void unsetVacatedStyle();

    void unsetVisualTotals();

    XmlBoolean xgetApplyAlignmentFormats();

    XmlBoolean xgetApplyBorderFormats();

    XmlBoolean xgetApplyFontFormats();

    XmlBoolean xgetApplyNumberFormats();

    XmlBoolean xgetApplyPatternFormats();

    XmlBoolean xgetApplyWidthHeightFormats();

    XmlBoolean xgetAsteriskTotals();

    XmlUnsignedInt xgetAutoFormatId();

    XmlUnsignedInt xgetCacheId();

    XmlUnsignedInt xgetChartFormat();

    XmlBoolean xgetColGrandTotals();

    STXstring xgetColHeaderCaption();

    XmlBoolean xgetCompact();

    XmlBoolean xgetCompactData();

    XmlUnsignedByte xgetCreatedVersion();

    XmlBoolean xgetCustomListSort();

    STXstring xgetDataCaption();

    XmlBoolean xgetDataOnRows();

    XmlUnsignedInt xgetDataPosition();

    XmlBoolean xgetDisableFieldList();

    XmlBoolean xgetEditData();

    XmlBoolean xgetEnableDrill();

    XmlBoolean xgetEnableFieldProperties();

    XmlBoolean xgetEnableWizard();

    STXstring xgetErrorCaption();

    XmlBoolean xgetFieldListSortAscending();

    XmlBoolean xgetFieldPrintTitles();

    STXstring xgetGrandTotalCaption();

    XmlBoolean xgetGridDropZones();

    XmlBoolean xgetImmersive();

    XmlUnsignedInt xgetIndent();

    XmlBoolean xgetItemPrintTitles();

    XmlBoolean xgetMdxSubqueries();

    XmlBoolean xgetMergeItem();

    XmlUnsignedByte xgetMinRefreshableVersion();

    STXstring xgetMissingCaption();

    XmlBoolean xgetMultipleFieldFilters();

    STXstring xgetName();

    XmlBoolean xgetOutline();

    XmlBoolean xgetOutlineData();

    XmlBoolean xgetPageOverThenDown();

    STXstring xgetPageStyle();

    XmlUnsignedInt xgetPageWrap();

    STXstring xgetPivotTableStyle();

    XmlBoolean xgetPreserveFormatting();

    XmlBoolean xgetPrintDrill();

    XmlBoolean xgetPublished();

    XmlBoolean xgetRowGrandTotals();

    STXstring xgetRowHeaderCaption();

    XmlBoolean xgetShowCalcMbrs();

    XmlBoolean xgetShowDataDropDown();

    XmlBoolean xgetShowDataTips();

    XmlBoolean xgetShowDrill();

    XmlBoolean xgetShowDropZones();

    XmlBoolean xgetShowEmptyCol();

    XmlBoolean xgetShowEmptyRow();

    XmlBoolean xgetShowError();

    XmlBoolean xgetShowHeaders();

    XmlBoolean xgetShowItems();

    XmlBoolean xgetShowMemberPropertyTips();

    XmlBoolean xgetShowMissing();

    XmlBoolean xgetShowMultipleLabel();

    XmlBoolean xgetSubtotalHiddenItems();

    STXstring xgetTag();

    XmlUnsignedByte xgetUpdatedVersion();

    XmlBoolean xgetUseAutoFormatting();

    STXstring xgetVacatedStyle();

    XmlBoolean xgetVisualTotals();

    void xsetApplyAlignmentFormats(XmlBoolean xmlBoolean);

    void xsetApplyBorderFormats(XmlBoolean xmlBoolean);

    void xsetApplyFontFormats(XmlBoolean xmlBoolean);

    void xsetApplyNumberFormats(XmlBoolean xmlBoolean);

    void xsetApplyPatternFormats(XmlBoolean xmlBoolean);

    void xsetApplyWidthHeightFormats(XmlBoolean xmlBoolean);

    void xsetAsteriskTotals(XmlBoolean xmlBoolean);

    void xsetAutoFormatId(XmlUnsignedInt xmlUnsignedInt);

    void xsetCacheId(XmlUnsignedInt xmlUnsignedInt);

    void xsetChartFormat(XmlUnsignedInt xmlUnsignedInt);

    void xsetColGrandTotals(XmlBoolean xmlBoolean);

    void xsetColHeaderCaption(STXstring sTXstring);

    void xsetCompact(XmlBoolean xmlBoolean);

    void xsetCompactData(XmlBoolean xmlBoolean);

    void xsetCreatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetCustomListSort(XmlBoolean xmlBoolean);

    void xsetDataCaption(STXstring sTXstring);

    void xsetDataOnRows(XmlBoolean xmlBoolean);

    void xsetDataPosition(XmlUnsignedInt xmlUnsignedInt);

    void xsetDisableFieldList(XmlBoolean xmlBoolean);

    void xsetEditData(XmlBoolean xmlBoolean);

    void xsetEnableDrill(XmlBoolean xmlBoolean);

    void xsetEnableFieldProperties(XmlBoolean xmlBoolean);

    void xsetEnableWizard(XmlBoolean xmlBoolean);

    void xsetErrorCaption(STXstring sTXstring);

    void xsetFieldListSortAscending(XmlBoolean xmlBoolean);

    void xsetFieldPrintTitles(XmlBoolean xmlBoolean);

    void xsetGrandTotalCaption(STXstring sTXstring);

    void xsetGridDropZones(XmlBoolean xmlBoolean);

    void xsetImmersive(XmlBoolean xmlBoolean);

    void xsetIndent(XmlUnsignedInt xmlUnsignedInt);

    void xsetItemPrintTitles(XmlBoolean xmlBoolean);

    void xsetMdxSubqueries(XmlBoolean xmlBoolean);

    void xsetMergeItem(XmlBoolean xmlBoolean);

    void xsetMinRefreshableVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetMissingCaption(STXstring sTXstring);

    void xsetMultipleFieldFilters(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetOutline(XmlBoolean xmlBoolean);

    void xsetOutlineData(XmlBoolean xmlBoolean);

    void xsetPageOverThenDown(XmlBoolean xmlBoolean);

    void xsetPageStyle(STXstring sTXstring);

    void xsetPageWrap(XmlUnsignedInt xmlUnsignedInt);

    void xsetPivotTableStyle(STXstring sTXstring);

    void xsetPreserveFormatting(XmlBoolean xmlBoolean);

    void xsetPrintDrill(XmlBoolean xmlBoolean);

    void xsetPublished(XmlBoolean xmlBoolean);

    void xsetRowGrandTotals(XmlBoolean xmlBoolean);

    void xsetRowHeaderCaption(STXstring sTXstring);

    void xsetShowCalcMbrs(XmlBoolean xmlBoolean);

    void xsetShowDataDropDown(XmlBoolean xmlBoolean);

    void xsetShowDataTips(XmlBoolean xmlBoolean);

    void xsetShowDrill(XmlBoolean xmlBoolean);

    void xsetShowDropZones(XmlBoolean xmlBoolean);

    void xsetShowEmptyCol(XmlBoolean xmlBoolean);

    void xsetShowEmptyRow(XmlBoolean xmlBoolean);

    void xsetShowError(XmlBoolean xmlBoolean);

    void xsetShowHeaders(XmlBoolean xmlBoolean);

    void xsetShowItems(XmlBoolean xmlBoolean);

    void xsetShowMemberPropertyTips(XmlBoolean xmlBoolean);

    void xsetShowMissing(XmlBoolean xmlBoolean);

    void xsetShowMultipleLabel(XmlBoolean xmlBoolean);

    void xsetSubtotalHiddenItems(XmlBoolean xmlBoolean);

    void xsetTag(STXstring sTXstring);

    void xsetUpdatedVersion(XmlUnsignedByte xmlUnsignedByte);

    void xsetUseAutoFormatting(XmlBoolean xmlBoolean);

    void xsetVacatedStyle(STXstring sTXstring);

    void xsetVisualTotals(XmlBoolean xmlBoolean);
}
