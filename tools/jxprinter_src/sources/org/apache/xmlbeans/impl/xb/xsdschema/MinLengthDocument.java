package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface MinLengthDocument extends XmlObject {
    public static final DocumentFactory<MinLengthDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<MinLengthDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "minlengthe7fddoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    NumFacet addNewMinLength();

    NumFacet getMinLength();

    void setMinLength(NumFacet numFacet);
}
