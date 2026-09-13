package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface PageSheetType extends SheetType {
    public static final DocumentFactory<PageSheetType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<PageSheetType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "pagesheettype679btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getUniqueID();

    boolean isSetUniqueID();

    void setUniqueID(String str);

    void unsetUniqueID();

    XmlString xgetUniqueID();

    void xsetUniqueID(XmlString xmlString);
}
