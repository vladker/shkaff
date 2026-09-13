package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface IncludeDocument extends XmlObject {
    public static final DocumentFactory<IncludeDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Include extends Annotated {
        public static final ElementFactory<Include> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Include> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "include59d9elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        String getSchemaLocation();

        void setSchemaLocation(String str);

        XmlAnyURI xgetSchemaLocation();

        void xsetSchemaLocation(XmlAnyURI xmlAnyURI);
    }

    static {
        DocumentFactory<IncludeDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "includeaf6ddoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Include addNewInclude();

    Include getInclude();

    void setInclude(Include include);
}
