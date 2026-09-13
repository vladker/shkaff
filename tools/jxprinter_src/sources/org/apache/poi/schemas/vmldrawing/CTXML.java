package org.apache.poi.schemas.vmldrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CTXML extends XmlObject {
    public static final DocumentFactory<CTXML> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTXML> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctxml2989type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
