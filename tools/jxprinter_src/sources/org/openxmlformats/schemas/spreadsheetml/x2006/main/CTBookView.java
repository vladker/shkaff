package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBookView extends XmlObject {
    public static final DocumentFactory<CTBookView> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBookView> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbookviewf677type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    long getActiveTab();

    boolean getAutoFilterDateGrouping();

    CTExtensionList getExtLst();

    long getFirstSheet();

    boolean getMinimized();

    boolean getShowHorizontalScroll();

    boolean getShowSheetTabs();

    boolean getShowVerticalScroll();

    long getTabRatio();

    STVisibility.Enum getVisibility();

    long getWindowHeight();

    long getWindowWidth();

    int getXWindow();

    int getYWindow();

    boolean isSetActiveTab();

    boolean isSetAutoFilterDateGrouping();

    boolean isSetExtLst();

    boolean isSetFirstSheet();

    boolean isSetMinimized();

    boolean isSetShowHorizontalScroll();

    boolean isSetShowSheetTabs();

    boolean isSetShowVerticalScroll();

    boolean isSetTabRatio();

    boolean isSetVisibility();

    boolean isSetWindowHeight();

    boolean isSetWindowWidth();

    boolean isSetXWindow();

    boolean isSetYWindow();

    void setActiveTab(long j6);

    void setAutoFilterDateGrouping(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFirstSheet(long j6);

    void setMinimized(boolean z6);

    void setShowHorizontalScroll(boolean z6);

    void setShowSheetTabs(boolean z6);

    void setShowVerticalScroll(boolean z6);

    void setTabRatio(long j6);

    void setVisibility(STVisibility.Enum r6);

    void setWindowHeight(long j6);

    void setWindowWidth(long j6);

    void setXWindow(int i5);

    void setYWindow(int i5);

    void unsetActiveTab();

    void unsetAutoFilterDateGrouping();

    void unsetExtLst();

    void unsetFirstSheet();

    void unsetMinimized();

    void unsetShowHorizontalScroll();

    void unsetShowSheetTabs();

    void unsetShowVerticalScroll();

    void unsetTabRatio();

    void unsetVisibility();

    void unsetWindowHeight();

    void unsetWindowWidth();

    void unsetXWindow();

    void unsetYWindow();

    XmlUnsignedInt xgetActiveTab();

    XmlBoolean xgetAutoFilterDateGrouping();

    XmlUnsignedInt xgetFirstSheet();

    XmlBoolean xgetMinimized();

    XmlBoolean xgetShowHorizontalScroll();

    XmlBoolean xgetShowSheetTabs();

    XmlBoolean xgetShowVerticalScroll();

    XmlUnsignedInt xgetTabRatio();

    STVisibility xgetVisibility();

    XmlUnsignedInt xgetWindowHeight();

    XmlUnsignedInt xgetWindowWidth();

    XmlInt xgetXWindow();

    XmlInt xgetYWindow();

    void xsetActiveTab(XmlUnsignedInt xmlUnsignedInt);

    void xsetAutoFilterDateGrouping(XmlBoolean xmlBoolean);

    void xsetFirstSheet(XmlUnsignedInt xmlUnsignedInt);

    void xsetMinimized(XmlBoolean xmlBoolean);

    void xsetShowHorizontalScroll(XmlBoolean xmlBoolean);

    void xsetShowSheetTabs(XmlBoolean xmlBoolean);

    void xsetShowVerticalScroll(XmlBoolean xmlBoolean);

    void xsetTabRatio(XmlUnsignedInt xmlUnsignedInt);

    void xsetVisibility(STVisibility sTVisibility);

    void xsetWindowHeight(XmlUnsignedInt xmlUnsignedInt);

    void xsetWindowWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetXWindow(XmlInt xmlInt);

    void xsetYWindow(XmlInt xmlInt);
}
