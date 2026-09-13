package org.apache.xmlbeans.impl.xb.xmlschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLLANG.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SpaceAttribute extends XmlObject {
    public static final DocumentFactory<SpaceAttribute> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Space extends XmlNCName {
        public static final Enum DEFAULT;
        public static final ElementFactory<Space> Factory;
        public static final int INT_DEFAULT = 1;
        public static final int INT_PRESERVE = 2;
        public static final Enum PRESERVE;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_DEFAULT = 1;
            static final int INT_PRESERVE = 2;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("default", 1), new Enum("preserve", 2)});

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
            ElementFactory<Space> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "spaceb986attrtype");
            Factory = elementFactory;
            type = elementFactory.getType();
            DEFAULT = Enum.forString("default");
            PRESERVE = Enum.forString("preserve");
        }

        StringEnumAbstractBase getEnumValue();

        void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
    }

    static {
        DocumentFactory<SpaceAttribute> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "space9344attrtypetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Space.Enum getSpace();

    boolean isSetSpace();

    void setSpace(Space.Enum r6);

    void unsetSpace();

    Space xgetSpace();

    void xsetSpace(Space space);
}
