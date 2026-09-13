package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface MinExclusiveDocument extends XmlObject {
    public static final DocumentFactory<MinExclusiveDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<MinExclusiveDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "minexclusive64d7doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Facet addNewMinExclusive();

    Facet getMinExclusive();

    void setMinExclusive(Facet facet);
}
