package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STHighlightColor extends XmlString {
    public static final Enum BLACK;
    public static final Enum BLUE;
    public static final Enum CYAN;
    public static final Enum DARK_BLUE;
    public static final Enum DARK_CYAN;
    public static final Enum DARK_GRAY;
    public static final Enum DARK_GREEN;
    public static final Enum DARK_MAGENTA;
    public static final Enum DARK_RED;
    public static final Enum DARK_YELLOW;
    public static final SimpleTypeFactory<STHighlightColor> Factory;
    public static final Enum GREEN;
    public static final int INT_BLACK = 1;
    public static final int INT_BLUE = 2;
    public static final int INT_CYAN = 3;
    public static final int INT_DARK_BLUE = 9;
    public static final int INT_DARK_CYAN = 10;
    public static final int INT_DARK_GRAY = 15;
    public static final int INT_DARK_GREEN = 11;
    public static final int INT_DARK_MAGENTA = 12;
    public static final int INT_DARK_RED = 13;
    public static final int INT_DARK_YELLOW = 14;
    public static final int INT_GREEN = 4;
    public static final int INT_LIGHT_GRAY = 16;
    public static final int INT_MAGENTA = 5;
    public static final int INT_NONE = 17;
    public static final int INT_RED = 6;
    public static final int INT_WHITE = 8;
    public static final int INT_YELLOW = 7;
    public static final Enum LIGHT_GRAY;
    public static final Enum MAGENTA;
    public static final Enum NONE;
    public static final Enum RED;
    public static final Enum WHITE;
    public static final Enum YELLOW;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLACK = 1;
        static final int INT_BLUE = 2;
        static final int INT_CYAN = 3;
        static final int INT_DARK_BLUE = 9;
        static final int INT_DARK_CYAN = 10;
        static final int INT_DARK_GRAY = 15;
        static final int INT_DARK_GREEN = 11;
        static final int INT_DARK_MAGENTA = 12;
        static final int INT_DARK_RED = 13;
        static final int INT_DARK_YELLOW = 14;
        static final int INT_GREEN = 4;
        static final int INT_LIGHT_GRAY = 16;
        static final int INT_MAGENTA = 5;
        static final int INT_NONE = 17;
        static final int INT_RED = 6;
        static final int INT_WHITE = 8;
        static final int INT_YELLOW = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("black", 1), new Enum("blue", 2), new Enum("cyan", 3), new Enum("green", 4), new Enum("magenta", 5), new Enum("red", 6), new Enum("yellow", 7), new Enum("white", 8), new Enum("darkBlue", 9), new Enum("darkCyan", 10), new Enum("darkGreen", 11), new Enum("darkMagenta", 12), new Enum("darkRed", 13), new Enum("darkYellow", 14), new Enum("darkGray", 15), new Enum("lightGray", 16), new Enum("none", 17)});

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
        SimpleTypeFactory<STHighlightColor> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sthighlightcolora8e9type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BLACK = Enum.forString("black");
        BLUE = Enum.forString("blue");
        CYAN = Enum.forString("cyan");
        GREEN = Enum.forString("green");
        MAGENTA = Enum.forString("magenta");
        RED = Enum.forString("red");
        YELLOW = Enum.forString("yellow");
        WHITE = Enum.forString("white");
        DARK_BLUE = Enum.forString("darkBlue");
        DARK_CYAN = Enum.forString("darkCyan");
        DARK_GREEN = Enum.forString("darkGreen");
        DARK_MAGENTA = Enum.forString("darkMagenta");
        DARK_RED = Enum.forString("darkRed");
        DARK_YELLOW = Enum.forString("darkYellow");
        DARK_GRAY = Enum.forString("darkGray");
        LIGHT_GRAY = Enum.forString("lightGray");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
