package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomWorkbookView extends XmlObject {
    public static final DocumentFactory<CTCustomWorkbookView> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomWorkbookView> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomworkbookview31d9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    long getActiveSheetId();

    boolean getAutoUpdate();

    boolean getChangesSavedWin();

    CTExtensionList getExtLst();

    String getGuid();

    boolean getIncludeHiddenRowCol();

    boolean getIncludePrintSettings();

    boolean getMaximized();

    long getMergeInterval();

    boolean getMinimized();

    String getName();

    boolean getOnlySync();

    boolean getPersonalView();

    STComments$Enum getShowComments();

    boolean getShowFormulaBar();

    boolean getShowHorizontalScroll();

    STObjects.Enum getShowObjects();

    boolean getShowSheetTabs();

    boolean getShowStatusbar();

    boolean getShowVerticalScroll();

    long getTabRatio();

    long getWindowHeight();

    long getWindowWidth();

    int getXWindow();

    int getYWindow();

    boolean isSetAutoUpdate();

    boolean isSetChangesSavedWin();

    boolean isSetExtLst();

    boolean isSetIncludeHiddenRowCol();

    boolean isSetIncludePrintSettings();

    boolean isSetMaximized();

    boolean isSetMergeInterval();

    boolean isSetMinimized();

    boolean isSetOnlySync();

    boolean isSetPersonalView();

    boolean isSetShowComments();

    boolean isSetShowFormulaBar();

    boolean isSetShowHorizontalScroll();

    boolean isSetShowObjects();

    boolean isSetShowSheetTabs();

    boolean isSetShowStatusbar();

    boolean isSetShowVerticalScroll();

    boolean isSetTabRatio();

    boolean isSetXWindow();

    boolean isSetYWindow();

    void setActiveSheetId(long j6);

    void setAutoUpdate(boolean z6);

    void setChangesSavedWin(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGuid(String str);

    void setIncludeHiddenRowCol(boolean z6);

    void setIncludePrintSettings(boolean z6);

    void setMaximized(boolean z6);

    void setMergeInterval(long j6);

    void setMinimized(boolean z6);

    void setName(String str);

    void setOnlySync(boolean z6);

    void setPersonalView(boolean z6);

    void setShowComments(STComments$Enum sTComments$Enum);

    void setShowFormulaBar(boolean z6);

    void setShowHorizontalScroll(boolean z6);

    void setShowObjects(STObjects.Enum r6);

    void setShowSheetTabs(boolean z6);

    void setShowStatusbar(boolean z6);

    void setShowVerticalScroll(boolean z6);

    void setTabRatio(long j6);

    void setWindowHeight(long j6);

    void setWindowWidth(long j6);

    void setXWindow(int i5);

    void setYWindow(int i5);

    void unsetAutoUpdate();

    void unsetChangesSavedWin();

    void unsetExtLst();

    void unsetIncludeHiddenRowCol();

    void unsetIncludePrintSettings();

    void unsetMaximized();

    void unsetMergeInterval();

    void unsetMinimized();

    void unsetOnlySync();

    void unsetPersonalView();

    void unsetShowComments();

    void unsetShowFormulaBar();

    void unsetShowHorizontalScroll();

    void unsetShowObjects();

    void unsetShowSheetTabs();

    void unsetShowStatusbar();

    void unsetShowVerticalScroll();

    void unsetTabRatio();

    void unsetXWindow();

    void unsetYWindow();

    XmlUnsignedInt xgetActiveSheetId();

    XmlBoolean xgetAutoUpdate();

    XmlBoolean xgetChangesSavedWin();

    STGuid xgetGuid();

    XmlBoolean xgetIncludeHiddenRowCol();

    XmlBoolean xgetIncludePrintSettings();

    XmlBoolean xgetMaximized();

    XmlUnsignedInt xgetMergeInterval();

    XmlBoolean xgetMinimized();

    STXstring xgetName();

    XmlBoolean xgetOnlySync();

    XmlBoolean xgetPersonalView();

    STComments xgetShowComments();

    XmlBoolean xgetShowFormulaBar();

    XmlBoolean xgetShowHorizontalScroll();

    STObjects xgetShowObjects();

    XmlBoolean xgetShowSheetTabs();

    XmlBoolean xgetShowStatusbar();

    XmlBoolean xgetShowVerticalScroll();

    XmlUnsignedInt xgetTabRatio();

    XmlUnsignedInt xgetWindowHeight();

    XmlUnsignedInt xgetWindowWidth();

    XmlInt xgetXWindow();

    XmlInt xgetYWindow();

    void xsetActiveSheetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetAutoUpdate(XmlBoolean xmlBoolean);

    void xsetChangesSavedWin(XmlBoolean xmlBoolean);

    void xsetGuid(STGuid sTGuid);

    void xsetIncludeHiddenRowCol(XmlBoolean xmlBoolean);

    void xsetIncludePrintSettings(XmlBoolean xmlBoolean);

    void xsetMaximized(XmlBoolean xmlBoolean);

    void xsetMergeInterval(XmlUnsignedInt xmlUnsignedInt);

    void xsetMinimized(XmlBoolean xmlBoolean);

    void xsetName(STXstring sTXstring);

    void xsetOnlySync(XmlBoolean xmlBoolean);

    void xsetPersonalView(XmlBoolean xmlBoolean);

    void xsetShowComments(STComments sTComments);

    void xsetShowFormulaBar(XmlBoolean xmlBoolean);

    void xsetShowHorizontalScroll(XmlBoolean xmlBoolean);

    void xsetShowObjects(STObjects sTObjects);

    void xsetShowSheetTabs(XmlBoolean xmlBoolean);

    void xsetShowStatusbar(XmlBoolean xmlBoolean);

    void xsetShowVerticalScroll(XmlBoolean xmlBoolean);

    void xsetTabRatio(XmlUnsignedInt xmlUnsignedInt);

    void xsetWindowHeight(XmlUnsignedInt xmlUnsignedInt);

    void xsetWindowWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetXWindow(XmlInt xmlInt);

    void xsetYWindow(XmlInt xmlInt);
}
