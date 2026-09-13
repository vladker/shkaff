package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STDataValidationOperator extends XmlString {
    public static final Enum BETWEEN;
    public static final Enum EQUAL;
    public static final SimpleTypeFactory<STDataValidationOperator> Factory;
    public static final Enum GREATER_THAN;
    public static final Enum GREATER_THAN_OR_EQUAL;
    public static final int INT_BETWEEN = 1;
    public static final int INT_EQUAL = 3;
    public static final int INT_GREATER_THAN = 7;
    public static final int INT_GREATER_THAN_OR_EQUAL = 8;
    public static final int INT_LESS_THAN = 5;
    public static final int INT_LESS_THAN_OR_EQUAL = 6;
    public static final int INT_NOT_BETWEEN = 2;
    public static final int INT_NOT_EQUAL = 4;
    public static final Enum LESS_THAN;
    public static final Enum LESS_THAN_OR_EQUAL;
    public static final Enum NOT_BETWEEN;
    public static final Enum NOT_EQUAL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BETWEEN = 1;
        static final int INT_EQUAL = 3;
        static final int INT_GREATER_THAN = 7;
        static final int INT_GREATER_THAN_OR_EQUAL = 8;
        static final int INT_LESS_THAN = 5;
        static final int INT_LESS_THAN_OR_EQUAL = 6;
        static final int INT_NOT_BETWEEN = 2;
        static final int INT_NOT_EQUAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("between", 1), new Enum("notBetween", 2), new Enum("equal", 3), new Enum("notEqual", 4), new Enum("lessThan", 5), new Enum("lessThanOrEqual", 6), new Enum("greaterThan", 7), new Enum("greaterThanOrEqual", 8)});

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
        SimpleTypeFactory<STDataValidationOperator> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdatavalidationoperatore0e0type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BETWEEN = Enum.forString("between");
        NOT_BETWEEN = Enum.forString("notBetween");
        EQUAL = Enum.forString("equal");
        NOT_EQUAL = Enum.forString("notEqual");
        LESS_THAN = Enum.forString("lessThan");
        LESS_THAN_OR_EQUAL = Enum.forString("lessThanOrEqual");
        GREATER_THAN = Enum.forString("greaterThan");
        GREATER_THAN_OR_EQUAL = Enum.forString("greaterThanOrEqual");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
