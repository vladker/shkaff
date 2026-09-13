package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STShadowType extends XmlString {
    public static final Enum DOUBLE;
    public static final Enum EMBOSS;
    public static final SimpleTypeFactory<STShadowType> Factory;
    public static final int INT_DOUBLE = 2;
    public static final int INT_EMBOSS = 3;
    public static final int INT_PERSPECTIVE = 4;
    public static final int INT_SINGLE = 1;
    public static final Enum PERSPECTIVE;
    public static final Enum SINGLE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DOUBLE = 2;
        static final int INT_EMBOSS = 3;
        static final int INT_PERSPECTIVE = 4;
        static final int INT_SINGLE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("single", 1), new Enum(XmlErrorCodes.DOUBLE, 2), new Enum("emboss", 3), new Enum("perspective", 4)});

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
        SimpleTypeFactory<STShadowType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stshadowtype8b48type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SINGLE = Enum.forString("single");
        DOUBLE = Enum.forString(XmlErrorCodes.DOUBLE);
        EMBOSS = Enum.forString("emboss");
        PERSPECTIVE = Enum.forString("perspective");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
