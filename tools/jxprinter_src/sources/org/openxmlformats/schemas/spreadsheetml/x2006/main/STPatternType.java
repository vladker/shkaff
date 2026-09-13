package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STPatternType extends XmlString {
    public static final Enum DARK_DOWN;
    public static final Enum DARK_GRAY;
    public static final Enum DARK_GRID;
    public static final Enum DARK_HORIZONTAL;
    public static final Enum DARK_TRELLIS;
    public static final Enum DARK_UP;
    public static final Enum DARK_VERTICAL;
    public static final SimpleTypeFactory<STPatternType> Factory;
    public static final Enum GRAY_0625;
    public static final Enum GRAY_125;
    public static final int INT_DARK_DOWN = 8;
    public static final int INT_DARK_GRAY = 4;
    public static final int INT_DARK_GRID = 10;
    public static final int INT_DARK_HORIZONTAL = 6;
    public static final int INT_DARK_TRELLIS = 11;
    public static final int INT_DARK_UP = 9;
    public static final int INT_DARK_VERTICAL = 7;
    public static final int INT_GRAY_0625 = 19;
    public static final int INT_GRAY_125 = 18;
    public static final int INT_LIGHT_DOWN = 14;
    public static final int INT_LIGHT_GRAY = 5;
    public static final int INT_LIGHT_GRID = 16;
    public static final int INT_LIGHT_HORIZONTAL = 12;
    public static final int INT_LIGHT_TRELLIS = 17;
    public static final int INT_LIGHT_UP = 15;
    public static final int INT_LIGHT_VERTICAL = 13;
    public static final int INT_MEDIUM_GRAY = 3;
    public static final int INT_NONE = 1;
    public static final int INT_SOLID = 2;
    public static final Enum LIGHT_DOWN;
    public static final Enum LIGHT_GRAY;
    public static final Enum LIGHT_GRID;
    public static final Enum LIGHT_HORIZONTAL;
    public static final Enum LIGHT_TRELLIS;
    public static final Enum LIGHT_UP;
    public static final Enum LIGHT_VERTICAL;
    public static final Enum MEDIUM_GRAY;
    public static final Enum NONE;
    public static final Enum SOLID;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DARK_DOWN = 8;
        static final int INT_DARK_GRAY = 4;
        static final int INT_DARK_GRID = 10;
        static final int INT_DARK_HORIZONTAL = 6;
        static final int INT_DARK_TRELLIS = 11;
        static final int INT_DARK_UP = 9;
        static final int INT_DARK_VERTICAL = 7;
        static final int INT_GRAY_0625 = 19;
        static final int INT_GRAY_125 = 18;
        static final int INT_LIGHT_DOWN = 14;
        static final int INT_LIGHT_GRAY = 5;
        static final int INT_LIGHT_GRID = 16;
        static final int INT_LIGHT_HORIZONTAL = 12;
        static final int INT_LIGHT_TRELLIS = 17;
        static final int INT_LIGHT_UP = 15;
        static final int INT_LIGHT_VERTICAL = 13;
        static final int INT_MEDIUM_GRAY = 3;
        static final int INT_NONE = 1;
        static final int INT_SOLID = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("solid", 2), new Enum("mediumGray", 3), new Enum("darkGray", 4), new Enum("lightGray", 5), new Enum("darkHorizontal", 6), new Enum("darkVertical", 7), new Enum("darkDown", 8), new Enum("darkUp", 9), new Enum("darkGrid", 10), new Enum("darkTrellis", 11), new Enum("lightHorizontal", 12), new Enum("lightVertical", 13), new Enum("lightDown", 14), new Enum("lightUp", 15), new Enum("lightGrid", 16), new Enum("lightTrellis", 17), new Enum("gray125", 18), new Enum("gray0625", 19)});

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
        SimpleTypeFactory<STPatternType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpatterntype7939type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        SOLID = Enum.forString("solid");
        MEDIUM_GRAY = Enum.forString("mediumGray");
        DARK_GRAY = Enum.forString("darkGray");
        LIGHT_GRAY = Enum.forString("lightGray");
        DARK_HORIZONTAL = Enum.forString("darkHorizontal");
        DARK_VERTICAL = Enum.forString("darkVertical");
        DARK_DOWN = Enum.forString("darkDown");
        DARK_UP = Enum.forString("darkUp");
        DARK_GRID = Enum.forString("darkGrid");
        DARK_TRELLIS = Enum.forString("darkTrellis");
        LIGHT_HORIZONTAL = Enum.forString("lightHorizontal");
        LIGHT_VERTICAL = Enum.forString("lightVertical");
        LIGHT_DOWN = Enum.forString("lightDown");
        LIGHT_UP = Enum.forString("lightUp");
        LIGHT_GRID = Enum.forString("lightGrid");
        LIGHT_TRELLIS = Enum.forString("lightTrellis");
        GRAY_125 = Enum.forString("gray125");
        GRAY_0625 = Enum.forString("gray0625");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
