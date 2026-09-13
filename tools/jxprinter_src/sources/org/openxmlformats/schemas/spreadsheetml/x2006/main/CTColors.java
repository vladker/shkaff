package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTColors extends XmlObject {
    public static final DocumentFactory<CTColors> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColors> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolors6579type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTIndexedColors addNewIndexedColors();

    CTMRUColors addNewMruColors();

    CTIndexedColors getIndexedColors();

    CTMRUColors getMruColors();

    boolean isSetIndexedColors();

    boolean isSetMruColors();

    void setIndexedColors(CTIndexedColors cTIndexedColors);

    void setMruColors(CTMRUColors cTMRUColors);

    void unsetIndexedColors();

    void unsetMruColors();
}
