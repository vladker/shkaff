package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STTotalsRowFunction extends XmlString {
    public static final Enum AVERAGE;
    public static final Enum COUNT;
    public static final Enum COUNT_NUMS;
    public static final Enum CUSTOM;
    public static final SimpleTypeFactory<STTotalsRowFunction> Factory;
    public static final int INT_AVERAGE = 5;
    public static final int INT_COUNT = 6;
    public static final int INT_COUNT_NUMS = 7;
    public static final int INT_CUSTOM = 10;
    public static final int INT_MAX = 4;
    public static final int INT_MIN = 3;
    public static final int INT_NONE = 1;
    public static final int INT_STD_DEV = 8;
    public static final int INT_SUM = 2;
    public static final int INT_VAR = 9;
    public static final Enum MAX;
    public static final Enum MIN;
    public static final Enum NONE;
    public static final Enum STD_DEV;
    public static final Enum SUM;
    public static final Enum VAR;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVERAGE = 5;
        static final int INT_COUNT = 6;
        static final int INT_COUNT_NUMS = 7;
        static final int INT_CUSTOM = 10;
        static final int INT_MAX = 4;
        static final int INT_MIN = 3;
        static final int INT_NONE = 1;
        static final int INT_STD_DEV = 8;
        static final int INT_SUM = 2;
        static final int INT_VAR = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("sum", 2), new Enum("min", 3), new Enum("max", 4), new Enum("average", 5), new Enum("count", 6), new Enum("countNums", 7), new Enum("stdDev", 8), new Enum("var", 9), new Enum("custom", 10)});

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
        SimpleTypeFactory<STTotalsRowFunction> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttotalsrowfunctioncb72type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        SUM = Enum.forString("sum");
        MIN = Enum.forString("min");
        MAX = Enum.forString("max");
        AVERAGE = Enum.forString("average");
        COUNT = Enum.forString("count");
        COUNT_NUMS = Enum.forString("countNums");
        STD_DEV = Enum.forString("stdDev");
        VAR = Enum.forString("var");
        CUSTOM = Enum.forString("custom");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
