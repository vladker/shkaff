package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface UniqueDocument extends XmlObject {
    public static final DocumentFactory<UniqueDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<UniqueDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "unique3752doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Keybase addNewUnique();

    Keybase getUnique();

    void setUnique(Keybase keybase);
}
