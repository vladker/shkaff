package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STJc extends XmlString {
    public static final Enum BOTH;
    public static final Enum CENTER;
    public static final Enum DISTRIBUTE;
    public static final Enum END;
    public static final SimpleTypeFactory<STJc> Factory;
    public static final Enum HIGH_KASHIDA;
    public static final int INT_BOTH = 4;
    public static final int INT_CENTER = 2;
    public static final int INT_DISTRIBUTE = 6;
    public static final int INT_END = 3;
    public static final int INT_HIGH_KASHIDA = 8;
    public static final int INT_LEFT = 11;
    public static final int INT_LOW_KASHIDA = 9;
    public static final int INT_MEDIUM_KASHIDA = 5;
    public static final int INT_NUM_TAB = 7;
    public static final int INT_RIGHT = 12;
    public static final int INT_START = 1;
    public static final int INT_THAI_DISTRIBUTE = 10;
    public static final Enum LEFT;
    public static final Enum LOW_KASHIDA;
    public static final Enum MEDIUM_KASHIDA;
    public static final Enum NUM_TAB;
    public static final Enum RIGHT;
    public static final Enum START;
    public static final Enum THAI_DISTRIBUTE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTH = 4;
        static final int INT_CENTER = 2;
        static final int INT_DISTRIBUTE = 6;
        static final int INT_END = 3;
        static final int INT_HIGH_KASHIDA = 8;
        static final int INT_LEFT = 11;
        static final int INT_LOW_KASHIDA = 9;
        static final int INT_MEDIUM_KASHIDA = 5;
        static final int INT_NUM_TAB = 7;
        static final int INT_RIGHT = 12;
        static final int INT_START = 1;
        static final int INT_THAI_DISTRIBUTE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("start", 1), new Enum("center", 2), new Enum("end", 3), new Enum("both", 4), new Enum("mediumKashida", 5), new Enum("distribute", 6), new Enum("numTab", 7), new Enum("highKashida", 8), new Enum("lowKashida", 9), new Enum("thaiDistribute", 10), new Enum("left", 11), new Enum("right", 12)});

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
        SimpleTypeFactory<STJc> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stjc977ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        START = Enum.forString("start");
        CENTER = Enum.forString("center");
        END = Enum.forString("end");
        BOTH = Enum.forString("both");
        MEDIUM_KASHIDA = Enum.forString("mediumKashida");
        DISTRIBUTE = Enum.forString("distribute");
        NUM_TAB = Enum.forString("numTab");
        HIGH_KASHIDA = Enum.forString("highKashida");
        LOW_KASHIDA = Enum.forString("lowKashida");
        THAI_DISTRIBUTE = Enum.forString("thaiDistribute");
        LEFT = Enum.forString("left");
        RIGHT = Enum.forString("right");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
