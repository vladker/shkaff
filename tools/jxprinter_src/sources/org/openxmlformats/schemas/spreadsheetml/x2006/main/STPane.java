package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STPane extends XmlString {
    public static final Enum BOTTOM_LEFT;
    public static final Enum BOTTOM_RIGHT;
    public static final SimpleTypeFactory<STPane> Factory;
    public static final int INT_BOTTOM_LEFT = 3;
    public static final int INT_BOTTOM_RIGHT = 1;
    public static final int INT_TOP_LEFT = 4;
    public static final int INT_TOP_RIGHT = 2;
    public static final Enum TOP_LEFT;
    public static final Enum TOP_RIGHT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM_LEFT = 3;
        static final int INT_BOTTOM_RIGHT = 1;
        static final int INT_TOP_LEFT = 4;
        static final int INT_TOP_RIGHT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bottomRight", 1), new Enum("topRight", 2), new Enum("bottomLeft", 3), new Enum("topLeft", 4)});

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
        SimpleTypeFactory<STPane> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpane2ac1type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BOTTOM_RIGHT = Enum.forString("bottomRight");
        TOP_RIGHT = Enum.forString("topRight");
        BOTTOM_LEFT = Enum.forString("bottomLeft");
        TOP_LEFT = Enum.forString("topLeft");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
