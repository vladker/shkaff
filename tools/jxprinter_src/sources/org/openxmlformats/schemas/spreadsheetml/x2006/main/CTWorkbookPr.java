package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTWorkbookPr extends XmlObject {
    public static final DocumentFactory<CTWorkbookPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTWorkbookPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctworkbookpr03a5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getAllowRefreshQuery();

    boolean getAutoCompressPictures();

    boolean getBackupFile();

    boolean getCheckCompatibility();

    String getCodeName();

    boolean getDate1904();

    long getDefaultThemeVersion();

    boolean getFilterPrivacy();

    boolean getHidePivotFieldList();

    boolean getPromptedSolutions();

    boolean getPublishItems();

    boolean getRefreshAllConnections();

    boolean getSaveExternalLinkValues();

    boolean getShowBorderUnselectedTables();

    boolean getShowInkAnnotation();

    STObjects.Enum getShowObjects();

    boolean getShowPivotChartFilter();

    STUpdateLinks.Enum getUpdateLinks();

    boolean isSetAllowRefreshQuery();

    boolean isSetAutoCompressPictures();

    boolean isSetBackupFile();

    boolean isSetCheckCompatibility();

    boolean isSetCodeName();

    boolean isSetDate1904();

    boolean isSetDefaultThemeVersion();

    boolean isSetFilterPrivacy();

    boolean isSetHidePivotFieldList();

    boolean isSetPromptedSolutions();

    boolean isSetPublishItems();

    boolean isSetRefreshAllConnections();

    boolean isSetSaveExternalLinkValues();

    boolean isSetShowBorderUnselectedTables();

    boolean isSetShowInkAnnotation();

    boolean isSetShowObjects();

    boolean isSetShowPivotChartFilter();

    boolean isSetUpdateLinks();

    void setAllowRefreshQuery(boolean z6);

    void setAutoCompressPictures(boolean z6);

    void setBackupFile(boolean z6);

    void setCheckCompatibility(boolean z6);

    void setCodeName(String str);

    void setDate1904(boolean z6);

    void setDefaultThemeVersion(long j6);

    void setFilterPrivacy(boolean z6);

    void setHidePivotFieldList(boolean z6);

    void setPromptedSolutions(boolean z6);

    void setPublishItems(boolean z6);

    void setRefreshAllConnections(boolean z6);

    void setSaveExternalLinkValues(boolean z6);

    void setShowBorderUnselectedTables(boolean z6);

    void setShowInkAnnotation(boolean z6);

    void setShowObjects(STObjects.Enum r6);

    void setShowPivotChartFilter(boolean z6);

    void setUpdateLinks(STUpdateLinks.Enum r6);

    void unsetAllowRefreshQuery();

    void unsetAutoCompressPictures();

    void unsetBackupFile();

    void unsetCheckCompatibility();

    void unsetCodeName();

    void unsetDate1904();

    void unsetDefaultThemeVersion();

    void unsetFilterPrivacy();

    void unsetHidePivotFieldList();

    void unsetPromptedSolutions();

    void unsetPublishItems();

    void unsetRefreshAllConnections();

    void unsetSaveExternalLinkValues();

    void unsetShowBorderUnselectedTables();

    void unsetShowInkAnnotation();

    void unsetShowObjects();

    void unsetShowPivotChartFilter();

    void unsetUpdateLinks();

    XmlBoolean xgetAllowRefreshQuery();

    XmlBoolean xgetAutoCompressPictures();

    XmlBoolean xgetBackupFile();

    XmlBoolean xgetCheckCompatibility();

    XmlString xgetCodeName();

    XmlBoolean xgetDate1904();

    XmlUnsignedInt xgetDefaultThemeVersion();

    XmlBoolean xgetFilterPrivacy();

    XmlBoolean xgetHidePivotFieldList();

    XmlBoolean xgetPromptedSolutions();

    XmlBoolean xgetPublishItems();

    XmlBoolean xgetRefreshAllConnections();

    XmlBoolean xgetSaveExternalLinkValues();

    XmlBoolean xgetShowBorderUnselectedTables();

    XmlBoolean xgetShowInkAnnotation();

    STObjects xgetShowObjects();

    XmlBoolean xgetShowPivotChartFilter();

    STUpdateLinks xgetUpdateLinks();

    void xsetAllowRefreshQuery(XmlBoolean xmlBoolean);

    void xsetAutoCompressPictures(XmlBoolean xmlBoolean);

    void xsetBackupFile(XmlBoolean xmlBoolean);

    void xsetCheckCompatibility(XmlBoolean xmlBoolean);

    void xsetCodeName(XmlString xmlString);

    void xsetDate1904(XmlBoolean xmlBoolean);

    void xsetDefaultThemeVersion(XmlUnsignedInt xmlUnsignedInt);

    void xsetFilterPrivacy(XmlBoolean xmlBoolean);

    void xsetHidePivotFieldList(XmlBoolean xmlBoolean);

    void xsetPromptedSolutions(XmlBoolean xmlBoolean);

    void xsetPublishItems(XmlBoolean xmlBoolean);

    void xsetRefreshAllConnections(XmlBoolean xmlBoolean);

    void xsetSaveExternalLinkValues(XmlBoolean xmlBoolean);

    void xsetShowBorderUnselectedTables(XmlBoolean xmlBoolean);

    void xsetShowInkAnnotation(XmlBoolean xmlBoolean);

    void xsetShowObjects(STObjects sTObjects);

    void xsetShowPivotChartFilter(XmlBoolean xmlBoolean);

    void xsetUpdateLinks(STUpdateLinks sTUpdateLinks);
}
