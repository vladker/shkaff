package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomSheetView extends XmlObject {
    public static final DocumentFactory<CTCustomSheetView> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomSheetView> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomsheetview59d2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAutoFilter addNewAutoFilter();

    CTPageBreak addNewColBreaks();

    CTExtensionList addNewExtLst();

    CTHeaderFooter addNewHeaderFooter();

    CTPageMargins addNewPageMargins();

    CTPageSetup addNewPageSetup();

    CTPane addNewPane();

    CTPrintOptions addNewPrintOptions();

    CTPageBreak addNewRowBreaks();

    CTSelection addNewSelection();

    CTAutoFilter getAutoFilter();

    CTPageBreak getColBreaks();

    long getColorId();

    CTExtensionList getExtLst();

    boolean getFilter();

    boolean getFilterUnique();

    boolean getFitToPage();

    String getGuid();

    CTHeaderFooter getHeaderFooter();

    boolean getHiddenColumns();

    boolean getHiddenRows();

    boolean getOutlineSymbols();

    CTPageMargins getPageMargins();

    CTPageSetup getPageSetup();

    CTPane getPane();

    boolean getPrintArea();

    CTPrintOptions getPrintOptions();

    CTPageBreak getRowBreaks();

    long getScale();

    CTSelection getSelection();

    boolean getShowAutoFilter();

    boolean getShowFormulas();

    boolean getShowGridLines();

    boolean getShowPageBreaks();

    boolean getShowRowCol();

    boolean getShowRuler();

    STSheetState.Enum getState();

    String getTopLeftCell();

    STSheetViewType.Enum getView();

    boolean getZeroValues();

    boolean isSetAutoFilter();

    boolean isSetColBreaks();

    boolean isSetColorId();

    boolean isSetExtLst();

    boolean isSetFilter();

    boolean isSetFilterUnique();

    boolean isSetFitToPage();

    boolean isSetHeaderFooter();

    boolean isSetHiddenColumns();

    boolean isSetHiddenRows();

    boolean isSetOutlineSymbols();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    boolean isSetPane();

    boolean isSetPrintArea();

    boolean isSetPrintOptions();

    boolean isSetRowBreaks();

    boolean isSetScale();

    boolean isSetSelection();

    boolean isSetShowAutoFilter();

    boolean isSetShowFormulas();

    boolean isSetShowGridLines();

    boolean isSetShowPageBreaks();

    boolean isSetShowRowCol();

    boolean isSetShowRuler();

    boolean isSetState();

    boolean isSetTopLeftCell();

    boolean isSetView();

    boolean isSetZeroValues();

    void setAutoFilter(CTAutoFilter cTAutoFilter);

    void setColBreaks(CTPageBreak cTPageBreak);

    void setColorId(long j6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFilter(boolean z6);

    void setFilterUnique(boolean z6);

    void setFitToPage(boolean z6);

    void setGuid(String str);

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setHiddenColumns(boolean z6);

    void setHiddenRows(boolean z6);

    void setOutlineSymbols(boolean z6);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTPageSetup cTPageSetup);

    void setPane(CTPane cTPane);

    void setPrintArea(boolean z6);

    void setPrintOptions(CTPrintOptions cTPrintOptions);

    void setRowBreaks(CTPageBreak cTPageBreak);

    void setScale(long j6);

    void setSelection(CTSelection cTSelection);

    void setShowAutoFilter(boolean z6);

    void setShowFormulas(boolean z6);

    void setShowGridLines(boolean z6);

    void setShowPageBreaks(boolean z6);

    void setShowRowCol(boolean z6);

    void setShowRuler(boolean z6);

    void setState(STSheetState.Enum r6);

    void setTopLeftCell(String str);

    void setView(STSheetViewType.Enum r6);

    void setZeroValues(boolean z6);

    void unsetAutoFilter();

    void unsetColBreaks();

    void unsetColorId();

    void unsetExtLst();

    void unsetFilter();

    void unsetFilterUnique();

    void unsetFitToPage();

    void unsetHeaderFooter();

    void unsetHiddenColumns();

    void unsetHiddenRows();

    void unsetOutlineSymbols();

    void unsetPageMargins();

    void unsetPageSetup();

    void unsetPane();

    void unsetPrintArea();

    void unsetPrintOptions();

    void unsetRowBreaks();

    void unsetScale();

    void unsetSelection();

    void unsetShowAutoFilter();

    void unsetShowFormulas();

    void unsetShowGridLines();

    void unsetShowPageBreaks();

    void unsetShowRowCol();

    void unsetShowRuler();

    void unsetState();

    void unsetTopLeftCell();

    void unsetView();

    void unsetZeroValues();

    XmlUnsignedInt xgetColorId();

    XmlBoolean xgetFilter();

    XmlBoolean xgetFilterUnique();

    XmlBoolean xgetFitToPage();

    STGuid xgetGuid();

    XmlBoolean xgetHiddenColumns();

    XmlBoolean xgetHiddenRows();

    XmlBoolean xgetOutlineSymbols();

    XmlBoolean xgetPrintArea();

    XmlUnsignedInt xgetScale();

    XmlBoolean xgetShowAutoFilter();

    XmlBoolean xgetShowFormulas();

    XmlBoolean xgetShowGridLines();

    XmlBoolean xgetShowPageBreaks();

    XmlBoolean xgetShowRowCol();

    XmlBoolean xgetShowRuler();

    STSheetState xgetState();

    STCellRef xgetTopLeftCell();

    STSheetViewType xgetView();

    XmlBoolean xgetZeroValues();

    void xsetColorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetFilter(XmlBoolean xmlBoolean);

    void xsetFilterUnique(XmlBoolean xmlBoolean);

    void xsetFitToPage(XmlBoolean xmlBoolean);

    void xsetGuid(STGuid sTGuid);

    void xsetHiddenColumns(XmlBoolean xmlBoolean);

    void xsetHiddenRows(XmlBoolean xmlBoolean);

    void xsetOutlineSymbols(XmlBoolean xmlBoolean);

    void xsetPrintArea(XmlBoolean xmlBoolean);

    void xsetScale(XmlUnsignedInt xmlUnsignedInt);

    void xsetShowAutoFilter(XmlBoolean xmlBoolean);

    void xsetShowFormulas(XmlBoolean xmlBoolean);

    void xsetShowGridLines(XmlBoolean xmlBoolean);

    void xsetShowPageBreaks(XmlBoolean xmlBoolean);

    void xsetShowRowCol(XmlBoolean xmlBoolean);

    void xsetShowRuler(XmlBoolean xmlBoolean);

    void xsetState(STSheetState sTSheetState);

    void xsetTopLeftCell(STCellRef sTCellRef);

    void xsetView(STSheetViewType sTSheetViewType);

    void xsetZeroValues(XmlBoolean xmlBoolean);
}
