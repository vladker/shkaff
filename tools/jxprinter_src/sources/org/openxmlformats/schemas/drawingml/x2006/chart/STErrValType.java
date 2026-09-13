package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STErrValType extends XmlString {
    public static final Enum CUST;
    public static final Enum FIXED_VAL;
    public static final SimpleTypeFactory<STErrValType> Factory;
    public static final int INT_CUST = 1;
    public static final int INT_FIXED_VAL = 2;
    public static final int INT_PERCENTAGE = 3;
    public static final int INT_STD_DEV = 4;
    public static final int INT_STD_ERR = 5;
    public static final Enum PERCENTAGE;
    public static final Enum STD_DEV;
    public static final Enum STD_ERR;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUST = 1;
        static final int INT_FIXED_VAL = 2;
        static final int INT_PERCENTAGE = 3;
        static final int INT_STD_DEV = 4;
        static final int INT_STD_ERR = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("cust", 1), new Enum("fixedVal", 2), new Enum("percentage", 3), new Enum("stdDev", 4), new Enum("stdErr", 5)});

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
        SimpleTypeFactory<STErrValType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sterrvaltype96d6type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CUST = Enum.forString("cust");
        FIXED_VAL = Enum.forString("fixedVal");
        PERCENTAGE = Enum.forString("percentage");
        STD_DEV = Enum.forString("stdDev");
        STD_ERR = Enum.forString("stdErr");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
