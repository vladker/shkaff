package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface FieldDocument extends XmlObject {
    public static final DocumentFactory<FieldDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Field extends Annotated {
        public static final ElementFactory<Field> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Xpath extends XmlToken {
            public static final ElementFactory<Xpath> Factory;
            public static final SchemaType type;

            static {
                ElementFactory<Xpath> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "xpath7f90attrtype");
                Factory = elementFactory;
                type = elementFactory.getType();
            }
        }

        static {
            ElementFactory<Field> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "field12f5elemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        String getXpath();

        void setXpath(String str);

        Xpath xgetXpath();

        void xsetXpath(Xpath xpath);
    }

    static {
        DocumentFactory<FieldDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "field3f9bdoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Field addNewField();

    Field getField();

    void setField(Field field);
}
