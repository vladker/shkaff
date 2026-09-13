package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface VisioDocumentType extends XmlObject {
    public static final DocumentFactory<VisioDocumentType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<VisioDocumentType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "visiodocumenttypebfcatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    ColorsType addNewColors();

    DocumentSettingsType addNewDocumentSettings();

    DocumentSheetType addNewDocumentSheet();

    EventListType addNewEventList();

    FaceNamesType addNewFaceNames();

    HeaderFooterType addNewHeaderFooter();

    PublishSettingsType addNewPublishSettings();

    StyleSheetsType addNewStyleSheets();

    ColorsType getColors();

    DocumentSettingsType getDocumentSettings();

    DocumentSheetType getDocumentSheet();

    EventListType getEventList();

    FaceNamesType getFaceNames();

    HeaderFooterType getHeaderFooter();

    PublishSettingsType getPublishSettings();

    StyleSheetsType getStyleSheets();

    boolean isSetColors();

    boolean isSetDocumentSettings();

    boolean isSetDocumentSheet();

    boolean isSetEventList();

    boolean isSetFaceNames();

    boolean isSetHeaderFooter();

    boolean isSetPublishSettings();

    boolean isSetStyleSheets();

    void setColors(ColorsType colorsType);

    void setDocumentSettings(DocumentSettingsType documentSettingsType);

    void setDocumentSheet(DocumentSheetType documentSheetType);

    void setEventList(EventListType eventListType);

    void setFaceNames(FaceNamesType faceNamesType);

    void setHeaderFooter(HeaderFooterType headerFooterType);

    void setPublishSettings(PublishSettingsType publishSettingsType);

    void setStyleSheets(StyleSheetsType styleSheetsType);

    void unsetColors();

    void unsetDocumentSettings();

    void unsetDocumentSheet();

    void unsetEventList();

    void unsetFaceNames();

    void unsetHeaderFooter();

    void unsetPublishSettings();

    void unsetStyleSheets();
}
