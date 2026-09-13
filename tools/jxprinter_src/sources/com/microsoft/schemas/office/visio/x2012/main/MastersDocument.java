package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface MastersDocument extends XmlObject {
    public static final DocumentFactory<MastersDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<MastersDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "masters0341doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    MastersType addNewMasters();

    MastersType getMasters();

    void setMasters(MastersType mastersType);
}
