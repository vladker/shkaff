package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface KeyDocument extends XmlObject {
    public static final DocumentFactory<KeyDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<KeyDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "key5d16doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Keybase addNewKey();

    Keybase getKey();

    void setKey(Keybase keybase);
}
