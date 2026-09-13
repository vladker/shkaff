package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STPhoneticType extends XmlString {
    public static final Enum FULLWIDTH_KATAKANA;
    public static final SimpleTypeFactory<STPhoneticType> Factory;
    public static final Enum HALFWIDTH_KATAKANA;
    public static final Enum HIRAGANA;
    public static final int INT_FULLWIDTH_KATAKANA = 2;
    public static final int INT_HALFWIDTH_KATAKANA = 1;
    public static final int INT_HIRAGANA = 3;
    public static final int INT_NO_CONVERSION = 4;
    public static final Enum NO_CONVERSION;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FULLWIDTH_KATAKANA = 2;
        static final int INT_HALFWIDTH_KATAKANA = 1;
        static final int INT_HIRAGANA = 3;
        static final int INT_NO_CONVERSION = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("halfwidthKatakana", 1), new Enum("fullwidthKatakana", 2), new Enum("Hiragana", 3), new Enum("noConversion", 4)});

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
        SimpleTypeFactory<STPhoneticType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stphonetictype4f93type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        HALFWIDTH_KATAKANA = Enum.forString("halfwidthKatakana");
        FULLWIDTH_KATAKANA = Enum.forString("fullwidthKatakana");
        HIRAGANA = Enum.forString("Hiragana");
        NO_CONVERSION = Enum.forString("noConversion");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
