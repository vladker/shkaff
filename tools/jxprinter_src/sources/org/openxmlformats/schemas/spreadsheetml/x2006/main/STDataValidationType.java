package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STDataValidationType extends XmlString {
    public static final Enum CUSTOM;
    public static final Enum DATE;
    public static final Enum DECIMAL;
    public static final SimpleTypeFactory<STDataValidationType> Factory;
    public static final int INT_CUSTOM = 8;
    public static final int INT_DATE = 5;
    public static final int INT_DECIMAL = 3;
    public static final int INT_LIST = 4;
    public static final int INT_NONE = 1;
    public static final int INT_TEXT_LENGTH = 7;
    public static final int INT_TIME = 6;
    public static final int INT_WHOLE = 2;
    public static final Enum LIST;
    public static final Enum NONE;
    public static final Enum TEXT_LENGTH;
    public static final Enum TIME;
    public static final Enum WHOLE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 8;
        static final int INT_DATE = 5;
        static final int INT_DECIMAL = 3;
        static final int INT_LIST = 4;
        static final int INT_NONE = 1;
        static final int INT_TEXT_LENGTH = 7;
        static final int INT_TIME = 6;
        static final int INT_WHOLE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("whole", 2), new Enum(XmlErrorCodes.DECIMAL, 3), new Enum(XmlErrorCodes.LIST, 4), new Enum(XmlErrorCodes.DATE, 5), new Enum("time", 6), new Enum("textLength", 7), new Enum("custom", 8)});

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
        SimpleTypeFactory<STDataValidationType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdatavalidationtypeabf6type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        WHOLE = Enum.forString("whole");
        DECIMAL = Enum.forString(XmlErrorCodes.DECIMAL);
        LIST = Enum.forString(XmlErrorCodes.LIST);
        DATE = Enum.forString(XmlErrorCodes.DATE);
        TIME = Enum.forString("time");
        TEXT_LENGTH = Enum.forString("textLength");
        CUSTOM = Enum.forString("custom");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
