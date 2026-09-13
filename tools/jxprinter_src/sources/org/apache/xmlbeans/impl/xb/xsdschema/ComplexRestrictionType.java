package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface ComplexRestrictionType extends RestrictionType {
    public static final DocumentFactory<ComplexRestrictionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<ComplexRestrictionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "complexrestrictiontype1b7dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
