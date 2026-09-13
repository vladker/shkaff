package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STDataConsolidateFunction extends XmlString {
    public static final Enum AVERAGE;
    public static final Enum COUNT;
    public static final Enum COUNT_NUMS;
    public static final SimpleTypeFactory<STDataConsolidateFunction> Factory;
    public static final int INT_AVERAGE = 1;
    public static final int INT_COUNT = 2;
    public static final int INT_COUNT_NUMS = 3;
    public static final int INT_MAX = 4;
    public static final int INT_MIN = 5;
    public static final int INT_PRODUCT = 6;
    public static final int INT_STD_DEV = 7;
    public static final int INT_STD_DEVP = 8;
    public static final int INT_SUM = 9;
    public static final int INT_VAR = 10;
    public static final int INT_VARP = 11;
    public static final Enum MAX;
    public static final Enum MIN;
    public static final Enum PRODUCT;
    public static final Enum STD_DEV;
    public static final Enum STD_DEVP;
    public static final Enum SUM;
    public static final Enum VAR;
    public static final Enum VARP;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVERAGE = 1;
        static final int INT_COUNT = 2;
        static final int INT_COUNT_NUMS = 3;
        static final int INT_MAX = 4;
        static final int INT_MIN = 5;
        static final int INT_PRODUCT = 6;
        static final int INT_STD_DEV = 7;
        static final int INT_STD_DEVP = 8;
        static final int INT_SUM = 9;
        static final int INT_VAR = 10;
        static final int INT_VARP = 11;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("average", 1), new Enum("count", 2), new Enum("countNums", 3), new Enum("max", 4), new Enum("min", 5), new Enum("product", 6), new Enum("stdDev", 7), new Enum("stdDevp", 8), new Enum("sum", 9), new Enum("var", 10), new Enum("varp", 11)});

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
        SimpleTypeFactory<STDataConsolidateFunction> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdataconsolidatefunction1206type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        AVERAGE = Enum.forString("average");
        COUNT = Enum.forString("count");
        COUNT_NUMS = Enum.forString("countNums");
        MAX = Enum.forString("max");
        MIN = Enum.forString("min");
        PRODUCT = Enum.forString("product");
        STD_DEV = Enum.forString("stdDev");
        STD_DEVP = Enum.forString("stdDevp");
        SUM = Enum.forString("sum");
        VAR = Enum.forString("var");
        VARP = Enum.forString("varp");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
