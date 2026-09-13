package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface NumFacet extends Facet {
    public static final DocumentFactory<NumFacet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<NumFacet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "numfacet93a2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
