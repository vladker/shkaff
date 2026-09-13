package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STConditionalFormattingOperator extends XmlString {
    public static final Enum BEGINS_WITH;
    public static final Enum BETWEEN;
    public static final Enum CONTAINS_TEXT;
    public static final Enum ENDS_WITH;
    public static final Enum EQUAL;
    public static final SimpleTypeFactory<STConditionalFormattingOperator> Factory;
    public static final Enum GREATER_THAN;
    public static final Enum GREATER_THAN_OR_EQUAL;
    public static final int INT_BEGINS_WITH = 11;
    public static final int INT_BETWEEN = 7;
    public static final int INT_CONTAINS_TEXT = 9;
    public static final int INT_ENDS_WITH = 12;
    public static final int INT_EQUAL = 3;
    public static final int INT_GREATER_THAN = 6;
    public static final int INT_GREATER_THAN_OR_EQUAL = 5;
    public static final int INT_LESS_THAN = 1;
    public static final int INT_LESS_THAN_OR_EQUAL = 2;
    public static final int INT_NOT_BETWEEN = 8;
    public static final int INT_NOT_CONTAINS = 10;
    public static final int INT_NOT_EQUAL = 4;
    public static final Enum LESS_THAN;
    public static final Enum LESS_THAN_OR_EQUAL;
    public static final Enum NOT_BETWEEN;
    public static final Enum NOT_CONTAINS;
    public static final Enum NOT_EQUAL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEGINS_WITH = 11;
        static final int INT_BETWEEN = 7;
        static final int INT_CONTAINS_TEXT = 9;
        static final int INT_ENDS_WITH = 12;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 6;
        static final int INT_GREATER_THAN_OR_EQUAL = 5;
        static final int INT_LESS_THAN = 1;
        static final int INT_LESS_THAN_OR_EQUAL = 2;
        static final int INT_NOT_BETWEEN = 8;
        static final int INT_NOT_CONTAINS = 10;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("lessThan", 1), new Enum("lessThanOrEqual", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("greaterThanOrEqual", 5), new Enum("greaterThan", 6), new Enum("between", 7), new Enum("notBetween", 8), new Enum("containsText", 9), new Enum("notContains", 10), new Enum("beginsWith", 11), new Enum("endsWith", 12)});

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
        SimpleTypeFactory<STConditionalFormattingOperator> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stconditionalformattingoperatora99etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        LESS_THAN = Enum.forString("lessThan");
        LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
        EQUAL = Enum.forString("equal");
        NOT_EQUAL = Enum.forString("notEqual");
        GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");
        GREATER_THAN = Enum.forString("greaterThan");
        BETWEEN = Enum.forString("between");
        NOT_BETWEEN = Enum.forString("notBetween");
        CONTAINS_TEXT = Enum.forString("containsText");
        NOT_CONTAINS = Enum.forString("notContains");
        BEGINS_WITH = Enum.forString("beginsWith");
        ENDS_WITH = Enum.forString("endsWith");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
