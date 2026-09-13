package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STBlipCompression extends XmlToken {
    public static final Enum EMAIL;
    public static final SimpleTypeFactory<STBlipCompression> Factory;
    public static final Enum HQPRINT;
    public static final int INT_EMAIL = 1;
    public static final int INT_HQPRINT = 4;
    public static final int INT_NONE = 5;
    public static final int INT_PRINT = 3;
    public static final int INT_SCREEN = 2;
    public static final Enum NONE;
    public static final Enum PRINT;
    public static final Enum SCREEN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EMAIL = 1;
        static final int INT_HQPRINT = 4;
        static final int INT_NONE = 5;
        static final int INT_PRINT = 3;
        static final int INT_SCREEN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("email", 1), new Enum("screen", 2), new Enum("print", 3), new Enum("hqprint", 4), new Enum("none", 5)});

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
        SimpleTypeFactory<STBlipCompression> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stblipcompressionb216type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        EMAIL = Enum.forString("email");
        SCREEN = Enum.forString("screen");
        PRINT = Enum.forString("print");
        HQPRINT = Enum.forString("hqprint");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
