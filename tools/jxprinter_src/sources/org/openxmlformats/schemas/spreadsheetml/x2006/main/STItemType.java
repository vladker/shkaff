package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STItemType extends XmlString {
    public static final Enum AVG;
    public static final Enum BLANK;
    public static final Enum COUNT;
    public static final Enum COUNT_A;
    public static final Enum DATA;
    public static final Enum DEFAULT;
    public static final SimpleTypeFactory<STItemType> Factory;
    public static final Enum GRAND;
    public static final int INT_AVG = 5;
    public static final int INT_BLANK = 15;
    public static final int INT_COUNT = 9;
    public static final int INT_COUNT_A = 4;
    public static final int INT_DATA = 1;
    public static final int INT_DEFAULT = 2;
    public static final int INT_GRAND = 14;
    public static final int INT_MAX = 6;
    public static final int INT_MIN = 7;
    public static final int INT_PRODUCT = 8;
    public static final int INT_STD_DEV = 10;
    public static final int INT_STD_DEV_P = 11;
    public static final int INT_SUM = 3;
    public static final int INT_VAR = 12;
    public static final int INT_VAR_P = 13;
    public static final Enum MAX;
    public static final Enum MIN;
    public static final Enum PRODUCT;
    public static final Enum STD_DEV;
    public static final Enum STD_DEV_P;
    public static final Enum SUM;
    public static final Enum VAR;
    public static final Enum VAR_P;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AVG = 5;
        static final int INT_BLANK = 15;
        static final int INT_COUNT = 9;
        static final int INT_COUNT_A = 4;
        static final int INT_DATA = 1;
        static final int INT_DEFAULT = 2;
        static final int INT_GRAND = 14;
        static final int INT_MAX = 6;
        static final int INT_MIN = 7;
        static final int INT_PRODUCT = 8;
        static final int INT_STD_DEV = 10;
        static final int INT_STD_DEV_P = 11;
        static final int INT_SUM = 3;
        static final int INT_VAR = 12;
        static final int INT_VAR_P = 13;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("data", 1), new Enum("default", 2), new Enum("sum", 3), new Enum("countA", 4), new Enum("avg", 5), new Enum("max", 6), new Enum("min", 7), new Enum("product", 8), new Enum("count", 9), new Enum("stdDev", 10), new Enum("stdDevP", 11), new Enum("var", 12), new Enum("varP", 13), new Enum("grand", 14), new Enum("blank", 15)});

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
        SimpleTypeFactory<STItemType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stitemtype6186type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        DATA = Enum.forString("data");
        DEFAULT = Enum.forString("default");
        SUM = Enum.forString("sum");
        COUNT_A = Enum.forString("countA");
        AVG = Enum.forString("avg");
        MAX = Enum.forString("max");
        MIN = Enum.forString("min");
        PRODUCT = Enum.forString("product");
        COUNT = Enum.forString("count");
        STD_DEV = Enum.forString("stdDev");
        STD_DEV_P = Enum.forString("stdDevP");
        VAR = Enum.forString("var");
        VAR_P = Enum.forString("varP");
        GRAND = Enum.forString("grand");
        BLANK = Enum.forString("blank");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
