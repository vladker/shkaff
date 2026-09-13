package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotField extends XmlObject {
    public static final DocumentFactory<CTPivotField> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotField> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotfieldf961type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAutoSortScope addNewAutoSortScope();

    CTExtensionList addNewExtLst();

    CTItems addNewItems();

    boolean getAllDrilled();

    boolean getAutoShow();

    CTAutoSortScope getAutoSortScope();

    boolean getAvgSubtotal();

    STAxis.Enum getAxis();

    boolean getCompact();

    boolean getCountASubtotal();

    boolean getCountSubtotal();

    boolean getDataField();

    boolean getDataSourceSort();

    boolean getDefaultAttributeDrillState();

    boolean getDefaultSubtotal();

    boolean getDragOff();

    boolean getDragToCol();

    boolean getDragToData();

    boolean getDragToPage();

    boolean getDragToRow();

    CTExtensionList getExtLst();

    boolean getHiddenLevel();

    boolean getHideNewItems();

    boolean getIncludeNewItemsInFilter();

    boolean getInsertBlankRow();

    boolean getInsertPageBreak();

    long getItemPageCount();

    CTItems getItems();

    boolean getMaxSubtotal();

    boolean getMeasureFilter();

    boolean getMinSubtotal();

    boolean getMultipleItemSelectionAllowed();

    String getName();

    boolean getNonAutoSortDefault();

    long getNumFmtId();

    boolean getOutline();

    boolean getProductSubtotal();

    long getRankBy();

    boolean getServerField();

    boolean getShowAll();

    boolean getShowDropDowns();

    boolean getShowPropAsCaption();

    boolean getShowPropCell();

    boolean getShowPropTip();

    STFieldSortType$Enum getSortType();

    boolean getStdDevPSubtotal();

    boolean getStdDevSubtotal();

    String getSubtotalCaption();

    boolean getSubtotalTop();

    boolean getSumSubtotal();

    boolean getTopAutoShow();

    String getUniqueMemberProperty();

    boolean getVarPSubtotal();

    boolean getVarSubtotal();

    boolean isSetAllDrilled();

    boolean isSetAutoShow();

    boolean isSetAutoSortScope();

    boolean isSetAvgSubtotal();

    boolean isSetAxis();

    boolean isSetCompact();

    boolean isSetCountASubtotal();

    boolean isSetCountSubtotal();

    boolean isSetDataField();

    boolean isSetDataSourceSort();

    boolean isSetDefaultAttributeDrillState();

    boolean isSetDefaultSubtotal();

    boolean isSetDragOff();

    boolean isSetDragToCol();

    boolean isSetDragToData();

    boolean isSetDragToPage();

    boolean isSetDragToRow();

    boolean isSetExtLst();

    boolean isSetHiddenLevel();

    boolean isSetHideNewItems();

    boolean isSetIncludeNewItemsInFilter();

    boolean isSetInsertBlankRow();

    boolean isSetInsertPageBreak();

    boolean isSetItemPageCount();

    boolean isSetItems();

    boolean isSetMaxSubtotal();

    boolean isSetMeasureFilter();

    boolean isSetMinSubtotal();

    boolean isSetMultipleItemSelectionAllowed();

    boolean isSetName();

    boolean isSetNonAutoSortDefault();

    boolean isSetNumFmtId();

    boolean isSetOutline();

    boolean isSetProductSubtotal();

    boolean isSetRankBy();

    boolean isSetServerField();

    boolean isSetShowAll();

    boolean isSetShowDropDowns();

    boolean isSetShowPropAsCaption();

    boolean isSetShowPropCell();

    boolean isSetShowPropTip();

    boolean isSetSortType();

    boolean isSetStdDevPSubtotal();

    boolean isSetStdDevSubtotal();

    boolean isSetSubtotalCaption();

    boolean isSetSubtotalTop();

    boolean isSetSumSubtotal();

    boolean isSetTopAutoShow();

    boolean isSetUniqueMemberProperty();

    boolean isSetVarPSubtotal();

    boolean isSetVarSubtotal();

    void setAllDrilled(boolean z6);

    void setAutoShow(boolean z6);

    void setAutoSortScope(CTAutoSortScope cTAutoSortScope);

    void setAvgSubtotal(boolean z6);

    void setAxis(STAxis.Enum r6);

    void setCompact(boolean z6);

    void setCountASubtotal(boolean z6);

    void setCountSubtotal(boolean z6);

    void setDataField(boolean z6);

    void setDataSourceSort(boolean z6);

    void setDefaultAttributeDrillState(boolean z6);

    void setDefaultSubtotal(boolean z6);

    void setDragOff(boolean z6);

    void setDragToCol(boolean z6);

    void setDragToData(boolean z6);

    void setDragToPage(boolean z6);

    void setDragToRow(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setHiddenLevel(boolean z6);

    void setHideNewItems(boolean z6);

    void setIncludeNewItemsInFilter(boolean z6);

    void setInsertBlankRow(boolean z6);

    void setInsertPageBreak(boolean z6);

    void setItemPageCount(long j6);

    void setItems(CTItems cTItems);

    void setMaxSubtotal(boolean z6);

    void setMeasureFilter(boolean z6);

    void setMinSubtotal(boolean z6);

    void setMultipleItemSelectionAllowed(boolean z6);

    void setName(String str);

    void setNonAutoSortDefault(boolean z6);

    void setNumFmtId(long j6);

    void setOutline(boolean z6);

    void setProductSubtotal(boolean z6);

    void setRankBy(long j6);

    void setServerField(boolean z6);

    void setShowAll(boolean z6);

    void setShowDropDowns(boolean z6);

    void setShowPropAsCaption(boolean z6);

    void setShowPropCell(boolean z6);

    void setShowPropTip(boolean z6);

    void setSortType(STFieldSortType$Enum sTFieldSortType$Enum);

    void setStdDevPSubtotal(boolean z6);

    void setStdDevSubtotal(boolean z6);

    void setSubtotalCaption(String str);

    void setSubtotalTop(boolean z6);

    void setSumSubtotal(boolean z6);

    void setTopAutoShow(boolean z6);

    void setUniqueMemberProperty(String str);

    void setVarPSubtotal(boolean z6);

    void setVarSubtotal(boolean z6);

    void unsetAllDrilled();

    void unsetAutoShow();

    void unsetAutoSortScope();

    void unsetAvgSubtotal();

    void unsetAxis();

    void unsetCompact();

    void unsetCountASubtotal();

    void unsetCountSubtotal();

    void unsetDataField();

    void unsetDataSourceSort();

    void unsetDefaultAttributeDrillState();

    void unsetDefaultSubtotal();

    void unsetDragOff();

    void unsetDragToCol();

    void unsetDragToData();

    void unsetDragToPage();

    void unsetDragToRow();

    void unsetExtLst();

    void unsetHiddenLevel();

    void unsetHideNewItems();

    void unsetIncludeNewItemsInFilter();

    void unsetInsertBlankRow();

    void unsetInsertPageBreak();

    void unsetItemPageCount();

    void unsetItems();

    void unsetMaxSubtotal();

    void unsetMeasureFilter();

    void unsetMinSubtotal();

    void unsetMultipleItemSelectionAllowed();

    void unsetName();

    void unsetNonAutoSortDefault();

    void unsetNumFmtId();

    void unsetOutline();

    void unsetProductSubtotal();

    void unsetRankBy();

    void unsetServerField();

    void unsetShowAll();

    void unsetShowDropDowns();

    void unsetShowPropAsCaption();

    void unsetShowPropCell();

    void unsetShowPropTip();

    void unsetSortType();

    void unsetStdDevPSubtotal();

    void unsetStdDevSubtotal();

    void unsetSubtotalCaption();

    void unsetSubtotalTop();

    void unsetSumSubtotal();

    void unsetTopAutoShow();

    void unsetUniqueMemberProperty();

    void unsetVarPSubtotal();

    void unsetVarSubtotal();

    XmlBoolean xgetAllDrilled();

    XmlBoolean xgetAutoShow();

    XmlBoolean xgetAvgSubtotal();

    STAxis xgetAxis();

    XmlBoolean xgetCompact();

    XmlBoolean xgetCountASubtotal();

    XmlBoolean xgetCountSubtotal();

    XmlBoolean xgetDataField();

    XmlBoolean xgetDataSourceSort();

    XmlBoolean xgetDefaultAttributeDrillState();

    XmlBoolean xgetDefaultSubtotal();

    XmlBoolean xgetDragOff();

    XmlBoolean xgetDragToCol();

    XmlBoolean xgetDragToData();

    XmlBoolean xgetDragToPage();

    XmlBoolean xgetDragToRow();

    XmlBoolean xgetHiddenLevel();

    XmlBoolean xgetHideNewItems();

    XmlBoolean xgetIncludeNewItemsInFilter();

    XmlBoolean xgetInsertBlankRow();

    XmlBoolean xgetInsertPageBreak();

    XmlUnsignedInt xgetItemPageCount();

    XmlBoolean xgetMaxSubtotal();

    XmlBoolean xgetMeasureFilter();

    XmlBoolean xgetMinSubtotal();

    XmlBoolean xgetMultipleItemSelectionAllowed();

    STXstring xgetName();

    XmlBoolean xgetNonAutoSortDefault();

    STNumFmtId xgetNumFmtId();

    XmlBoolean xgetOutline();

    XmlBoolean xgetProductSubtotal();

    XmlUnsignedInt xgetRankBy();

    XmlBoolean xgetServerField();

    XmlBoolean xgetShowAll();

    XmlBoolean xgetShowDropDowns();

    XmlBoolean xgetShowPropAsCaption();

    XmlBoolean xgetShowPropCell();

    XmlBoolean xgetShowPropTip();

    STFieldSortType xgetSortType();

    XmlBoolean xgetStdDevPSubtotal();

    XmlBoolean xgetStdDevSubtotal();

    STXstring xgetSubtotalCaption();

    XmlBoolean xgetSubtotalTop();

    XmlBoolean xgetSumSubtotal();

    XmlBoolean xgetTopAutoShow();

    STXstring xgetUniqueMemberProperty();

    XmlBoolean xgetVarPSubtotal();

    XmlBoolean xgetVarSubtotal();

    void xsetAllDrilled(XmlBoolean xmlBoolean);

    void xsetAutoShow(XmlBoolean xmlBoolean);

    void xsetAvgSubtotal(XmlBoolean xmlBoolean);

    void xsetAxis(STAxis sTAxis);

    void xsetCompact(XmlBoolean xmlBoolean);

    void xsetCountASubtotal(XmlBoolean xmlBoolean);

    void xsetCountSubtotal(XmlBoolean xmlBoolean);

    void xsetDataField(XmlBoolean xmlBoolean);

    void xsetDataSourceSort(XmlBoolean xmlBoolean);

    void xsetDefaultAttributeDrillState(XmlBoolean xmlBoolean);

    void xsetDefaultSubtotal(XmlBoolean xmlBoolean);

    void xsetDragOff(XmlBoolean xmlBoolean);

    void xsetDragToCol(XmlBoolean xmlBoolean);

    void xsetDragToData(XmlBoolean xmlBoolean);

    void xsetDragToPage(XmlBoolean xmlBoolean);

    void xsetDragToRow(XmlBoolean xmlBoolean);

    void xsetHiddenLevel(XmlBoolean xmlBoolean);

    void xsetHideNewItems(XmlBoolean xmlBoolean);

    void xsetIncludeNewItemsInFilter(XmlBoolean xmlBoolean);

    void xsetInsertBlankRow(XmlBoolean xmlBoolean);

    void xsetInsertPageBreak(XmlBoolean xmlBoolean);

    void xsetItemPageCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetMaxSubtotal(XmlBoolean xmlBoolean);

    void xsetMeasureFilter(XmlBoolean xmlBoolean);

    void xsetMinSubtotal(XmlBoolean xmlBoolean);

    void xsetMultipleItemSelectionAllowed(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetNonAutoSortDefault(XmlBoolean xmlBoolean);

    void xsetNumFmtId(STNumFmtId sTNumFmtId);

    void xsetOutline(XmlBoolean xmlBoolean);

    void xsetProductSubtotal(XmlBoolean xmlBoolean);

    void xsetRankBy(XmlUnsignedInt xmlUnsignedInt);

    void xsetServerField(XmlBoolean xmlBoolean);

    void xsetShowAll(XmlBoolean xmlBoolean);

    void xsetShowDropDowns(XmlBoolean xmlBoolean);

    void xsetShowPropAsCaption(XmlBoolean xmlBoolean);

    void xsetShowPropCell(XmlBoolean xmlBoolean);

    void xsetShowPropTip(XmlBoolean xmlBoolean);

    void xsetSortType(STFieldSortType sTFieldSortType);

    void xsetStdDevPSubtotal(XmlBoolean xmlBoolean);

    void xsetStdDevSubtotal(XmlBoolean xmlBoolean);

    void xsetSubtotalCaption(STXstring sTXstring);

    void xsetSubtotalTop(XmlBoolean xmlBoolean);

    void xsetSumSubtotal(XmlBoolean xmlBoolean);

    void xsetTopAutoShow(XmlBoolean xmlBoolean);

    void xsetUniqueMemberProperty(STXstring sTXstring);

    void xsetVarPSubtotal(XmlBoolean xmlBoolean);

    void xsetVarSubtotal(XmlBoolean xmlBoolean);
}
