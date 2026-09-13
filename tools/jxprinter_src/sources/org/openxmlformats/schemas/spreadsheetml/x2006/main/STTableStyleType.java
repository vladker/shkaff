package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STTableStyleType extends XmlString {
    public static final Enum BLANK_ROW;
    public static final Enum FIRST_COLUMN;
    public static final Enum FIRST_COLUMN_STRIPE;
    public static final Enum FIRST_COLUMN_SUBHEADING;
    public static final Enum FIRST_HEADER_CELL;
    public static final Enum FIRST_ROW_STRIPE;
    public static final Enum FIRST_ROW_SUBHEADING;
    public static final Enum FIRST_SUBTOTAL_COLUMN;
    public static final Enum FIRST_SUBTOTAL_ROW;
    public static final Enum FIRST_TOTAL_CELL;
    public static final SimpleTypeFactory<STTableStyleType> Factory;
    public static final Enum HEADER_ROW;
    public static final int INT_BLANK_ROW = 20;
    public static final int INT_FIRST_COLUMN = 4;
    public static final int INT_FIRST_COLUMN_STRIPE = 8;
    public static final int INT_FIRST_COLUMN_SUBHEADING = 21;
    public static final int INT_FIRST_HEADER_CELL = 10;
    public static final int INT_FIRST_ROW_STRIPE = 6;
    public static final int INT_FIRST_ROW_SUBHEADING = 24;
    public static final int INT_FIRST_SUBTOTAL_COLUMN = 14;
    public static final int INT_FIRST_SUBTOTAL_ROW = 17;
    public static final int INT_FIRST_TOTAL_CELL = 12;
    public static final int INT_HEADER_ROW = 2;
    public static final int INT_LAST_COLUMN = 5;
    public static final int INT_LAST_HEADER_CELL = 11;
    public static final int INT_LAST_TOTAL_CELL = 13;
    public static final int INT_PAGE_FIELD_LABELS = 27;
    public static final int INT_PAGE_FIELD_VALUES = 28;
    public static final int INT_SECOND_COLUMN_STRIPE = 9;
    public static final int INT_SECOND_COLUMN_SUBHEADING = 22;
    public static final int INT_SECOND_ROW_STRIPE = 7;
    public static final int INT_SECOND_ROW_SUBHEADING = 25;
    public static final int INT_SECOND_SUBTOTAL_COLUMN = 15;
    public static final int INT_SECOND_SUBTOTAL_ROW = 18;
    public static final int INT_THIRD_COLUMN_SUBHEADING = 23;
    public static final int INT_THIRD_ROW_SUBHEADING = 26;
    public static final int INT_THIRD_SUBTOTAL_COLUMN = 16;
    public static final int INT_THIRD_SUBTOTAL_ROW = 19;
    public static final int INT_TOTAL_ROW = 3;
    public static final int INT_WHOLE_TABLE = 1;
    public static final Enum LAST_COLUMN;
    public static final Enum LAST_HEADER_CELL;
    public static final Enum LAST_TOTAL_CELL;
    public static final Enum PAGE_FIELD_LABELS;
    public static final Enum PAGE_FIELD_VALUES;
    public static final Enum SECOND_COLUMN_STRIPE;
    public static final Enum SECOND_COLUMN_SUBHEADING;
    public static final Enum SECOND_ROW_STRIPE;
    public static final Enum SECOND_ROW_SUBHEADING;
    public static final Enum SECOND_SUBTOTAL_COLUMN;
    public static final Enum SECOND_SUBTOTAL_ROW;
    public static final Enum THIRD_COLUMN_SUBHEADING;
    public static final Enum THIRD_ROW_SUBHEADING;
    public static final Enum THIRD_SUBTOTAL_COLUMN;
    public static final Enum THIRD_SUBTOTAL_ROW;
    public static final Enum TOTAL_ROW;
    public static final Enum WHOLE_TABLE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLANK_ROW = 20;
        static final int INT_FIRST_COLUMN = 4;
        static final int INT_FIRST_COLUMN_STRIPE = 8;
        static final int INT_FIRST_COLUMN_SUBHEADING = 21;
        static final int INT_FIRST_HEADER_CELL = 10;
        static final int INT_FIRST_ROW_STRIPE = 6;
        static final int INT_FIRST_ROW_SUBHEADING = 24;
        static final int INT_FIRST_SUBTOTAL_COLUMN = 14;
        static final int INT_FIRST_SUBTOTAL_ROW = 17;
        static final int INT_FIRST_TOTAL_CELL = 12;
        static final int INT_HEADER_ROW = 2;
        static final int INT_LAST_COLUMN = 5;
        static final int INT_LAST_HEADER_CELL = 11;
        static final int INT_LAST_TOTAL_CELL = 13;
        static final int INT_PAGE_FIELD_LABELS = 27;
        static final int INT_PAGE_FIELD_VALUES = 28;
        static final int INT_SECOND_COLUMN_STRIPE = 9;
        static final int INT_SECOND_COLUMN_SUBHEADING = 22;
        static final int INT_SECOND_ROW_STRIPE = 7;
        static final int INT_SECOND_ROW_SUBHEADING = 25;
        static final int INT_SECOND_SUBTOTAL_COLUMN = 15;
        static final int INT_SECOND_SUBTOTAL_ROW = 18;
        static final int INT_THIRD_COLUMN_SUBHEADING = 23;
        static final int INT_THIRD_ROW_SUBHEADING = 26;
        static final int INT_THIRD_SUBTOTAL_COLUMN = 16;
        static final int INT_THIRD_SUBTOTAL_ROW = 19;
        static final int INT_TOTAL_ROW = 3;
        static final int INT_WHOLE_TABLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("wholeTable", 1), new Enum("headerRow", 2), new Enum("totalRow", 3), new Enum("firstColumn", 4), new Enum("lastColumn", 5), new Enum("firstRowStripe", 6), new Enum("secondRowStripe", 7), new Enum("firstColumnStripe", 8), new Enum("secondColumnStripe", 9), new Enum("firstHeaderCell", 10), new Enum("lastHeaderCell", 11), new Enum("firstTotalCell", 12), new Enum("lastTotalCell", 13), new Enum("firstSubtotalColumn", 14), new Enum("secondSubtotalColumn", 15), new Enum("thirdSubtotalColumn", 16), new Enum("firstSubtotalRow", 17), new Enum("secondSubtotalRow", 18), new Enum("thirdSubtotalRow", 19), new Enum("blankRow", 20), new Enum("firstColumnSubheading", 21), new Enum("secondColumnSubheading", 22), new Enum("thirdColumnSubheading", 23), new Enum("firstRowSubheading", 24), new Enum("secondRowSubheading", 25), new Enum("thirdRowSubheading", 26), new Enum("pageFieldLabels", 27), new Enum("pageFieldValues", 28)});

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
        SimpleTypeFactory<STTableStyleType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttablestyletype9936type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        WHOLE_TABLE = Enum.forString("wholeTable");
        HEADER_ROW = Enum.forString("headerRow");
        TOTAL_ROW = Enum.forString("totalRow");
        FIRST_COLUMN = Enum.forString("firstColumn");
        LAST_COLUMN = Enum.forString("lastColumn");
        FIRST_ROW_STRIPE = Enum.forString("firstRowStripe");
        SECOND_ROW_STRIPE = Enum.forString("secondRowStripe");
        FIRST_COLUMN_STRIPE = Enum.forString("firstColumnStripe");
        SECOND_COLUMN_STRIPE = Enum.forString("secondColumnStripe");
        FIRST_HEADER_CELL = Enum.forString("firstHeaderCell");
        LAST_HEADER_CELL = Enum.forString("lastHeaderCell");
        FIRST_TOTAL_CELL = Enum.forString("firstTotalCell");
        LAST_TOTAL_CELL = Enum.forString("lastTotalCell");
        FIRST_SUBTOTAL_COLUMN = Enum.forString("firstSubtotalColumn");
        SECOND_SUBTOTAL_COLUMN = Enum.forString("secondSubtotalColumn");
        THIRD_SUBTOTAL_COLUMN = Enum.forString("thirdSubtotalColumn");
        FIRST_SUBTOTAL_ROW = Enum.forString("firstSubtotalRow");
        SECOND_SUBTOTAL_ROW = Enum.forString("secondSubtotalRow");
        THIRD_SUBTOTAL_ROW = Enum.forString("thirdSubtotalRow");
        BLANK_ROW = Enum.forString("blankRow");
        FIRST_COLUMN_SUBHEADING = Enum.forString("firstColumnSubheading");
        SECOND_COLUMN_SUBHEADING = Enum.forString("secondColumnSubheading");
        THIRD_COLUMN_SUBHEADING = Enum.forString("thirdColumnSubheading");
        FIRST_ROW_SUBHEADING = Enum.forString("firstRowSubheading");
        SECOND_ROW_SUBHEADING = Enum.forString("secondRowSubheading");
        THIRD_ROW_SUBHEADING = Enum.forString("thirdRowSubheading");
        PAGE_FIELD_LABELS = Enum.forString("pageFieldLabels");
        PAGE_FIELD_VALUES = Enum.forString("pageFieldValues");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
