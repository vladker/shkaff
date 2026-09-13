package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSheetView extends XmlObject {
    public static final DocumentFactory<CTSheetView> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheetView> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheetview0f43type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTPane addNewPane();

    CTPivotSelection addNewPivotSelection();

    CTSelection addNewSelection();

    long getColorId();

    boolean getDefaultGridColor();

    CTExtensionList getExtLst();

    CTPane getPane();

    CTPivotSelection getPivotSelectionArray(int i5);

    CTPivotSelection[] getPivotSelectionArray();

    List<CTPivotSelection> getPivotSelectionList();

    boolean getRightToLeft();

    CTSelection getSelectionArray(int i5);

    CTSelection[] getSelectionArray();

    List<CTSelection> getSelectionList();

    boolean getShowFormulas();

    boolean getShowGridLines();

    boolean getShowOutlineSymbols();

    boolean getShowRowColHeaders();

    boolean getShowRuler();

    boolean getShowWhiteSpace();

    boolean getShowZeros();

    boolean getTabSelected();

    String getTopLeftCell();

    STSheetViewType.Enum getView();

    boolean getWindowProtection();

    long getWorkbookViewId();

    long getZoomScale();

    long getZoomScaleNormal();

    long getZoomScalePageLayoutView();

    long getZoomScaleSheetLayoutView();

    CTPivotSelection insertNewPivotSelection(int i5);

    CTSelection insertNewSelection(int i5);

    boolean isSetColorId();

    boolean isSetDefaultGridColor();

    boolean isSetExtLst();

    boolean isSetPane();

    boolean isSetRightToLeft();

    boolean isSetShowFormulas();

    boolean isSetShowGridLines();

    boolean isSetShowOutlineSymbols();

    boolean isSetShowRowColHeaders();

    boolean isSetShowRuler();

    boolean isSetShowWhiteSpace();

    boolean isSetShowZeros();

    boolean isSetTabSelected();

    boolean isSetTopLeftCell();

    boolean isSetView();

    boolean isSetWindowProtection();

    boolean isSetZoomScale();

    boolean isSetZoomScaleNormal();

    boolean isSetZoomScalePageLayoutView();

    boolean isSetZoomScaleSheetLayoutView();

    void removePivotSelection(int i5);

    void removeSelection(int i5);

    void setColorId(long j6);

    void setDefaultGridColor(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setPane(CTPane cTPane);

    void setPivotSelectionArray(int i5, CTPivotSelection cTPivotSelection);

    void setPivotSelectionArray(CTPivotSelection[] cTPivotSelectionArr);

    void setRightToLeft(boolean z6);

    void setSelectionArray(int i5, CTSelection cTSelection);

    void setSelectionArray(CTSelection[] cTSelectionArr);

    void setShowFormulas(boolean z6);

    void setShowGridLines(boolean z6);

    void setShowOutlineSymbols(boolean z6);

    void setShowRowColHeaders(boolean z6);

    void setShowRuler(boolean z6);

    void setShowWhiteSpace(boolean z6);

    void setShowZeros(boolean z6);

    void setTabSelected(boolean z6);

    void setTopLeftCell(String str);

    void setView(STSheetViewType.Enum r6);

    void setWindowProtection(boolean z6);

    void setWorkbookViewId(long j6);

    void setZoomScale(long j6);

    void setZoomScaleNormal(long j6);

    void setZoomScalePageLayoutView(long j6);

    void setZoomScaleSheetLayoutView(long j6);

    int sizeOfPivotSelectionArray();

    int sizeOfSelectionArray();

    void unsetColorId();

    void unsetDefaultGridColor();

    void unsetExtLst();

    void unsetPane();

    void unsetRightToLeft();

    void unsetShowFormulas();

    void unsetShowGridLines();

    void unsetShowOutlineSymbols();

    void unsetShowRowColHeaders();

    void unsetShowRuler();

    void unsetShowWhiteSpace();

    void unsetShowZeros();

    void unsetTabSelected();

    void unsetTopLeftCell();

    void unsetView();

    void unsetWindowProtection();

    void unsetZoomScale();

    void unsetZoomScaleNormal();

    void unsetZoomScalePageLayoutView();

    void unsetZoomScaleSheetLayoutView();

    XmlUnsignedInt xgetColorId();

    XmlBoolean xgetDefaultGridColor();

    XmlBoolean xgetRightToLeft();

    XmlBoolean xgetShowFormulas();

    XmlBoolean xgetShowGridLines();

    XmlBoolean xgetShowOutlineSymbols();

    XmlBoolean xgetShowRowColHeaders();

    XmlBoolean xgetShowRuler();

    XmlBoolean xgetShowWhiteSpace();

    XmlBoolean xgetShowZeros();

    XmlBoolean xgetTabSelected();

    STCellRef xgetTopLeftCell();

    STSheetViewType xgetView();

    XmlBoolean xgetWindowProtection();

    XmlUnsignedInt xgetWorkbookViewId();

    XmlUnsignedInt xgetZoomScale();

    XmlUnsignedInt xgetZoomScaleNormal();

    XmlUnsignedInt xgetZoomScalePageLayoutView();

    XmlUnsignedInt xgetZoomScaleSheetLayoutView();

    void xsetColorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetDefaultGridColor(XmlBoolean xmlBoolean);

    void xsetRightToLeft(XmlBoolean xmlBoolean);

    void xsetShowFormulas(XmlBoolean xmlBoolean);

    void xsetShowGridLines(XmlBoolean xmlBoolean);

    void xsetShowOutlineSymbols(XmlBoolean xmlBoolean);

    void xsetShowRowColHeaders(XmlBoolean xmlBoolean);

    void xsetShowRuler(XmlBoolean xmlBoolean);

    void xsetShowWhiteSpace(XmlBoolean xmlBoolean);

    void xsetShowZeros(XmlBoolean xmlBoolean);

    void xsetTabSelected(XmlBoolean xmlBoolean);

    void xsetTopLeftCell(STCellRef sTCellRef);

    void xsetView(STSheetViewType sTSheetViewType);

    void xsetWindowProtection(XmlBoolean xmlBoolean);

    void xsetWorkbookViewId(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScale(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScaleNormal(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScalePageLayoutView(XmlUnsignedInt xmlUnsignedInt);

    void xsetZoomScaleSheetLayoutView(XmlUnsignedInt xmlUnsignedInt);
}
