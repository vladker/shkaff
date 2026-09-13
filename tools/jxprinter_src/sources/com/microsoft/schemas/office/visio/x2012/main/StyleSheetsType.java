package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface StyleSheetsType extends XmlObject {
    public static final DocumentFactory<StyleSheetsType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<StyleSheetsType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "stylesheetstypeb706type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    StyleSheetType addNewStyleSheet();

    StyleSheetType getStyleSheetArray(int i5);

    StyleSheetType[] getStyleSheetArray();

    List<StyleSheetType> getStyleSheetList();

    StyleSheetType insertNewStyleSheet(int i5);

    void removeStyleSheet(int i5);

    void setStyleSheetArray(int i5, StyleSheetType styleSheetType);

    void setStyleSheetArray(StyleSheetType[] styleSheetTypeArr);

    int sizeOfStyleSheetArray();
}
