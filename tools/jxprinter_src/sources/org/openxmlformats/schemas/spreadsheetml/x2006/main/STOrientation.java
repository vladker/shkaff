package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STOrientation extends XmlString {
    public static final Enum DEFAULT;
    public static final SimpleTypeFactory<STOrientation> Factory;
    public static final int INT_DEFAULT = 1;
    public static final int INT_LANDSCAPE = 3;
    public static final int INT_PORTRAIT = 2;
    public static final Enum LANDSCAPE;
    public static final Enum PORTRAIT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DEFAULT = 1;
        static final int INT_LANDSCAPE = 3;
        static final int INT_PORTRAIT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("default", 1), new Enum("portrait", 2), new Enum("landscape", 3)});

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
        SimpleTypeFactory<STOrientation> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "storientation3c9ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        DEFAULT = Enum.forString("default");
        PORTRAIT = Enum.forString("portrait");
        LANDSCAPE = Enum.forString("landscape");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
