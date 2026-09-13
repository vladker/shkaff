package org.apache.xmlbeans.impl.xb.xmlschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLLANG.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface LangAttribute extends XmlObject {
    public static final DocumentFactory<LangAttribute> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Lang extends XmlAnySimpleType {
        public static final ElementFactory<Lang> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Member extends XmlString {
            public static final ElementFactory<Member> Factory;
            public static final int INT_X = 1;

            /* JADX INFO: renamed from: X, reason: collision with root package name */
            public static final Enum f7459X;
            public static final SchemaType type;

            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public static final class Enum extends StringEnumAbstractBase {
                static final int INT_X = 1;
                private static final long serialVersionUID = 1;
                public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("", 1)});

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
                ElementFactory<Member> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "anon695ftype");
                Factory = elementFactory;
                type = elementFactory.getType();
                f7459X = Enum.forString("");
            }

            StringEnumAbstractBase getEnumValue();

            void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
        }

        static {
            ElementFactory<Lang> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "lang1224attrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        Object getObjectValue();

        SchemaType instanceType();

        void setObjectValue(Object obj);
    }

    static {
        DocumentFactory<LangAttribute> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "lange126attrtypetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getLang();

    boolean isSetLang();

    void setLang(String str);

    void unsetLang();

    Lang xgetLang();

    void xsetLang(Lang lang);
}
