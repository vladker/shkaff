package org.apache.xmlbeans.impl.xb.xsdschema;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface BlockSet extends XmlAnySimpleType {
    public static final SimpleTypeFactory<BlockSet> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Member extends XmlToken {
        public static final Enum ALL;
        public static final ElementFactory<Member> Factory;
        public static final int INT_ALL = 1;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ALL = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("#all", 1)});

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
            ElementFactory<Member> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon0683type");
            Factory = elementFactory;
            type = elementFactory.getType();
            ALL = Enum.forString("#all");
        }

        StringEnumAbstractBase getEnumValue();

        void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Member2 extends XmlAnySimpleType {
        public static final ElementFactory<Member2> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Item extends DerivationControl {
            public static final DerivationControl.Enum EXTENSION;
            public static final ElementFactory<Item> Factory;
            public static final int INT_EXTENSION = 2;
            public static final int INT_RESTRICTION = 3;
            public static final int INT_SUBSTITUTION = 1;
            public static final DerivationControl.Enum RESTRICTION;
            public static final DerivationControl.Enum SUBSTITUTION;
            public static final SchemaType type;

            static {
                ElementFactory<Item> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon421ctype");
                Factory = elementFactory;
                type = elementFactory.getType();
                EXTENSION = DerivationControl.EXTENSION;
                RESTRICTION = DerivationControl.RESTRICTION;
                SUBSTITUTION = DerivationControl.SUBSTITUTION;
            }
        }

        static {
            ElementFactory<Member2> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anonc904type");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        List getListValue();

        void setListValue(List<?> list);

        List xgetListValue();
    }

    static {
        SimpleTypeFactory<BlockSet> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "blockset815etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }

    Object getObjectValue();

    SchemaType instanceType();

    void setObjectValue(Object obj);
}
