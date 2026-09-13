package com.microsoft.schemas.vml;

import org.apache.commons.codec.language.bm.Languages;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STFillMethod extends XmlString {
    public static final Enum ANY;
    public static final SimpleTypeFactory<STFillMethod> Factory;
    public static final int INT_ANY = 4;
    public static final int INT_LINEAR = 2;
    public static final int INT_LINEAR_SIGMA = 5;
    public static final int INT_NONE = 1;
    public static final int INT_SIGMA = 3;
    public static final Enum LINEAR;
    public static final Enum LINEAR_SIGMA;
    public static final Enum NONE;
    public static final Enum SIGMA;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ANY = 4;
        static final int INT_LINEAR = 2;
        static final int INT_LINEAR_SIGMA = 5;
        static final int INT_NONE = 1;
        static final int INT_SIGMA = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("linear", 2), new Enum("sigma", 3), new Enum(Languages.ANY, 4), new Enum("linear sigma", 5)});

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
        SimpleTypeFactory<STFillMethod> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stfillmethoda592type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        LINEAR = Enum.forString("linear");
        SIGMA = Enum.forString("sigma");
        ANY = Enum.forString(Languages.ANY);
        LINEAR_SIGMA = Enum.forString("linear sigma");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
