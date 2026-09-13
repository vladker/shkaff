package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STCfvoType extends XmlString {
    public static final Enum FORMULA;
    public static final SimpleTypeFactory<STCfvoType> Factory;
    public static final int INT_FORMULA = 5;
    public static final int INT_MAX = 3;
    public static final int INT_MIN = 4;
    public static final int INT_NUM = 1;
    public static final int INT_PERCENT = 2;
    public static final int INT_PERCENTILE = 6;
    public static final Enum MAX;
    public static final Enum MIN;
    public static final Enum NUM;
    public static final Enum PERCENT;
    public static final Enum PERCENTILE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FORMULA = 5;
        static final int INT_MAX = 3;
        static final int INT_MIN = 4;
        static final int INT_NUM = 1;
        static final int INT_PERCENT = 2;
        static final int INT_PERCENTILE = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("num", 1), new Enum("percent", 2), new Enum("max", 3), new Enum("min", 4), new Enum("formula", 5), new Enum("percentile", 6)});

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
        SimpleTypeFactory<STCfvoType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcfvotypeeb0ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NUM = Enum.forString("num");
        PERCENT = Enum.forString("percent");
        MAX = Enum.forString("max");
        MIN = Enum.forString("min");
        FORMULA = Enum.forString("formula");
        PERCENTILE = Enum.forString("percentile");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
