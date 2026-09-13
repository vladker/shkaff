package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface AnyAttributeDocument extends XmlObject {
    public static final DocumentFactory<AnyAttributeDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<AnyAttributeDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "anyattribute23b3doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Wildcard addNewAnyAttribute();

    Wildcard getAnyAttribute();

    void setAnyAttribute(Wildcard wildcard);
}
