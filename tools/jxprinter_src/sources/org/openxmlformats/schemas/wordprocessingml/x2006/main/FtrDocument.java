package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface FtrDocument extends XmlObject {
    public static final DocumentFactory<FtrDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<FtrDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ftre182doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHdrFtr addNewFtr();

    CTHdrFtr getFtr();

    void setFtr(CTHdrFtr cTHdrFtr);
}
