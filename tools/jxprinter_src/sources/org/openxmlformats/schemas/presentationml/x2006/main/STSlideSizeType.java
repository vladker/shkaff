package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STSlideSizeType extends XmlToken {
    public static final Enum A_3;
    public static final Enum A_4;
    public static final Enum BANNER;
    public static final Enum B_4_ISO;
    public static final Enum B_4_JIS;
    public static final Enum B_5_ISO;
    public static final Enum B_5_JIS;
    public static final Enum CUSTOM;
    public static final SimpleTypeFactory<STSlideSizeType> Factory;
    public static final Enum HAGAKI_CARD;
    public static final int INT_A_3 = 9;
    public static final int INT_A_4 = 3;
    public static final int INT_BANNER = 6;
    public static final int INT_B_4_ISO = 10;
    public static final int INT_B_4_JIS = 12;
    public static final int INT_B_5_ISO = 11;
    public static final int INT_B_5_JIS = 13;
    public static final int INT_CUSTOM = 7;
    public static final int INT_HAGAKI_CARD = 14;
    public static final int INT_LEDGER = 8;
    public static final int INT_LETTER = 2;
    public static final int INT_OVERHEAD = 5;
    public static final int INT_SCREEN_16_X_10 = 16;
    public static final int INT_SCREEN_16_X_9 = 15;
    public static final int INT_SCREEN_4_X_3 = 1;
    public static final int INT_X_35_MM = 4;
    public static final Enum LEDGER;
    public static final Enum LETTER;
    public static final Enum OVERHEAD;
    public static final Enum SCREEN_16_X_10;
    public static final Enum SCREEN_16_X_9;
    public static final Enum SCREEN_4_X_3;
    public static final Enum X_35_MM;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_A_3 = 9;
        static final int INT_A_4 = 3;
        static final int INT_BANNER = 6;
        static final int INT_B_4_ISO = 10;
        static final int INT_B_4_JIS = 12;
        static final int INT_B_5_ISO = 11;
        static final int INT_B_5_JIS = 13;
        static final int INT_CUSTOM = 7;
        static final int INT_HAGAKI_CARD = 14;
        static final int INT_LEDGER = 8;
        static final int INT_LETTER = 2;
        static final int INT_OVERHEAD = 5;
        static final int INT_SCREEN_16_X_10 = 16;
        static final int INT_SCREEN_16_X_9 = 15;
        static final int INT_SCREEN_4_X_3 = 1;
        static final int INT_X_35_MM = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("screen4x3", 1), new Enum("letter", 2), new Enum("A4", 3), new Enum("35mm", 4), new Enum("overhead", 5), new Enum("banner", 6), new Enum("custom", 7), new Enum("ledger", 8), new Enum("A3", 9), new Enum("B4ISO", 10), new Enum("B5ISO", 11), new Enum("B4JIS", 12), new Enum("B5JIS", 13), new Enum("hagakiCard", 14), new Enum("screen16x9", 15), new Enum("screen16x10", 16)});

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
        SimpleTypeFactory<STSlideSizeType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stslidesizetypeb7f3type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SCREEN_4_X_3 = Enum.forString("screen4x3");
        LETTER = Enum.forString("letter");
        A_4 = Enum.forString("A4");
        X_35_MM = Enum.forString("35mm");
        OVERHEAD = Enum.forString("overhead");
        BANNER = Enum.forString("banner");
        CUSTOM = Enum.forString("custom");
        LEDGER = Enum.forString("ledger");
        A_3 = Enum.forString("A3");
        B_4_ISO = Enum.forString("B4ISO");
        B_5_ISO = Enum.forString("B5ISO");
        B_4_JIS = Enum.forString("B4JIS");
        B_5_JIS = Enum.forString("B5JIS");
        HAGAKI_CARD = Enum.forString("hagakiCard");
        SCREEN_16_X_9 = Enum.forString("screen16x9");
        SCREEN_16_X_10 = Enum.forString("screen16x10");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
