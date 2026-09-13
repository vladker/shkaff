package org.apache.xmlbeans.impl.xb.xmlconfig;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLCONFIG.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface Qnametargetenum extends XmlToken {
    public static final Enum ACCESSOR_ATTRIBUTE;
    public static final Enum ACCESSOR_ELEMENT;
    public static final Enum DOCUMENT_TYPE;
    public static final SimpleTypeFactory<Qnametargetenum> Factory;
    public static final int INT_ACCESSOR_ATTRIBUTE = 4;
    public static final int INT_ACCESSOR_ELEMENT = 3;
    public static final int INT_DOCUMENT_TYPE = 2;
    public static final int INT_TYPE = 1;
    public static final Enum TYPE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCESSOR_ATTRIBUTE = 4;
        static final int INT_ACCESSOR_ELEMENT = 3;
        static final int INT_DOCUMENT_TYPE = 2;
        static final int INT_TYPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("type", 1), new Enum("document-type", 2), new Enum("accessor-element", 3), new Enum("accessor-attribute", 4)});

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
        SimpleTypeFactory<Qnametargetenum> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "qnametargetenum9f8ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        TYPE = Enum.forString("type");
        DOCUMENT_TYPE = Enum.forString("document-type");
        ACCESSOR_ELEMENT = Enum.forString("accessor-element");
        ACCESSOR_ATTRIBUTE = Enum.forString("accessor-attribute");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
