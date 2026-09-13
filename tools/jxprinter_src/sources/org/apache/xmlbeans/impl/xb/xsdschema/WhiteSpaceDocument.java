package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface WhiteSpaceDocument extends XmlObject {
    public static final DocumentFactory<WhiteSpaceDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface WhiteSpace extends Facet {
        public static final ElementFactory<WhiteSpace> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Value extends XmlNMTOKEN {
            public static final Enum COLLAPSE;
            public static final ElementFactory<Value> Factory;
            public static final int INT_COLLAPSE = 3;
            public static final int INT_PRESERVE = 1;
            public static final int INT_REPLACE = 2;
            public static final Enum PRESERVE;
            public static final Enum REPLACE;
            public static final SchemaType type;

            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_COLLAPSE = 3;
                static final int INT_PRESERVE = 1;
                static final int INT_REPLACE = 2;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("preserve", 1), new Enum("replace", 2), new Enum("collapse", 3)});

                private Enum(String str, int i5) {
                    super(str, i5);
                }

                public static Enum forInt(int i5) {
                    return (Enum) table.forInt(i5);
                }

                public static Enum forString(String str) {
                    return (Enum) table.forString(str);
                }

                private Object readResolve() {
                    return forInt(intValue());
                }
            }

            static {
                ElementFactory<Value> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "value8186attrtype");
                Factory = elementFactory;
                type = elementFactory.getType();
                PRESERVE = Enum.forString("preserve");
                REPLACE = Enum.forString("replace");
                COLLAPSE = Enum.forString("collapse");
            }

            StringEnumAbstractBase getEnumValue();

            void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
        }

        static {
            ElementFactory<WhiteSpace> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "whitespace97ffelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }
    }

    static {
        DocumentFactory<WhiteSpaceDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "whitespaced2c6doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    WhiteSpace addNewWhiteSpace();

    WhiteSpace getWhiteSpace();

    void setWhiteSpace(WhiteSpace whiteSpace);
}
