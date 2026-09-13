package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STCfType extends XmlString {
    public static final Enum ABOVE_AVERAGE;
    public static final Enum BEGINS_WITH;
    public static final Enum CELL_IS;
    public static final Enum COLOR_SCALE;
    public static final Enum CONTAINS_BLANKS;
    public static final Enum CONTAINS_ERRORS;
    public static final Enum CONTAINS_TEXT;
    public static final Enum DATA_BAR;
    public static final Enum DUPLICATE_VALUES;
    public static final Enum ENDS_WITH;
    public static final Enum EXPRESSION;
    public static final SimpleTypeFactory<STCfType> Factory;
    public static final Enum ICON_SET;
    public static final int INT_ABOVE_AVERAGE = 18;
    public static final int INT_BEGINS_WITH = 11;
    public static final int INT_CELL_IS = 2;
    public static final int INT_COLOR_SCALE = 3;
    public static final int INT_CONTAINS_BLANKS = 13;
    public static final int INT_CONTAINS_ERRORS = 15;
    public static final int INT_CONTAINS_TEXT = 9;
    public static final int INT_DATA_BAR = 4;
    public static final int INT_DUPLICATE_VALUES = 8;
    public static final int INT_ENDS_WITH = 12;
    public static final int INT_EXPRESSION = 1;
    public static final int INT_ICON_SET = 5;
    public static final int INT_NOT_CONTAINS_BLANKS = 14;
    public static final int INT_NOT_CONTAINS_ERRORS = 16;
    public static final int INT_NOT_CONTAINS_TEXT = 10;
    public static final int INT_TIME_PERIOD = 17;
    public static final int INT_TOP_10 = 6;
    public static final int INT_UNIQUE_VALUES = 7;
    public static final Enum NOT_CONTAINS_BLANKS;
    public static final Enum NOT_CONTAINS_ERRORS;
    public static final Enum NOT_CONTAINS_TEXT;
    public static final Enum TIME_PERIOD;
    public static final Enum TOP_10;
    public static final Enum UNIQUE_VALUES;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABOVE_AVERAGE = 18;
        static final int INT_BEGINS_WITH = 11;
        static final int INT_CELL_IS = 2;
        static final int INT_COLOR_SCALE = 3;
        static final int INT_CONTAINS_BLANKS = 13;
        static final int INT_CONTAINS_ERRORS = 15;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_DATA_BAR = 4;
        static final int INT_DUPLICATE_VALUES = 8;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EXPRESSION = 1;
        static final int INT_ICON_SET = 5;
        static final int INT_NOT_CONTAINS_BLANKS = 14;
        static final int INT_NOT_CONTAINS_ERRORS = 16;
        static final int INT_NOT_CONTAINS_TEXT = 10;
        static final int INT_TIME_PERIOD = 17;
        static final int INT_TOP_10 = 6;
        static final int INT_UNIQUE_VALUES = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("expression", 1), new Enum("cellIs", 2), new Enum("colorScale", 3), new Enum("dataBar", 4), new Enum("iconSet", 5), new Enum("top10", 6), new Enum("uniqueValues", 7), new Enum("duplicateValues", 8), new Enum("containsText", 9), new Enum("notContainsText", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12), new Enum("containsBlanks", 13), new Enum("notContainsBlanks", 14), new Enum("containsErrors", 15), new Enum("notContainsErrors", 16), new Enum("timePeriod", 17), new Enum("aboveAverage", 18)});

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
        SimpleTypeFactory<STCfType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcftype8016type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        EXPRESSION = Enum.forString("expression");
        CELL_IS = Enum.forString("cellIs");
        COLOR_SCALE = Enum.forString("colorScale");
        DATA_BAR = Enum.forString("dataBar");
        ICON_SET = Enum.forString("iconSet");
        TOP_10 = Enum.forString("top10");
        UNIQUE_VALUES = Enum.forString("uniqueValues");
        DUPLICATE_VALUES = Enum.forString("duplicateValues");
        CONTAINS_TEXT = Enum.forString("containsText");
        NOT_CONTAINS_TEXT = Enum.forString("notContainsText");
        BEGINS_WITH = Enum.forString("beginsWith");
        ENDS_WITH = Enum.forString("endsWith");
        CONTAINS_BLANKS = Enum.forString("containsBlanks");
        NOT_CONTAINS_BLANKS = Enum.forString("notContainsBlanks");
        CONTAINS_ERRORS = Enum.forString("containsErrors");
        NOT_CONTAINS_ERRORS = Enum.forString("notContainsErrors");
        TIME_PERIOD = Enum.forString("timePeriod");
        ABOVE_AVERAGE = Enum.forString("aboveAverage");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
