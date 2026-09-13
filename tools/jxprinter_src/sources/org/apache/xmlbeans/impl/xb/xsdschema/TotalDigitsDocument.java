package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TotalDigitsDocument extends XmlObject {
    public static final DocumentFactory<TotalDigitsDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface TotalDigits extends NumFacet {
        public static final ElementFactory<TotalDigits> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<TotalDigits> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "totaldigits2615elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }
    }

    static {
        DocumentFactory<TotalDigitsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "totaldigits4a8bdoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    TotalDigits addNewTotalDigits();

    TotalDigits getTotalDigits();

    void setTotalDigits(TotalDigits totalDigits);
}
