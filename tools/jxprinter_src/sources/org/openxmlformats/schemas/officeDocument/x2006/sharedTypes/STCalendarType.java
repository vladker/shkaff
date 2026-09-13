package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import androidx.core.text.util.LocalePreferences;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STCalendarType extends XmlString {
    public static final SimpleTypeFactory<STCalendarType> Factory;
    public static final Enum GREGORIAN;
    public static final Enum GREGORIAN_ARABIC;
    public static final Enum GREGORIAN_ME_FRENCH;
    public static final Enum GREGORIAN_US;
    public static final Enum GREGORIAN_XLIT_ENGLISH;
    public static final Enum GREGORIAN_XLIT_FRENCH;
    public static final Enum HEBREW;
    public static final Enum HIJRI;
    public static final int INT_GREGORIAN = 1;
    public static final int INT_GREGORIAN_ARABIC = 4;
    public static final int INT_GREGORIAN_ME_FRENCH = 3;
    public static final int INT_GREGORIAN_US = 2;
    public static final int INT_GREGORIAN_XLIT_ENGLISH = 12;
    public static final int INT_GREGORIAN_XLIT_FRENCH = 13;
    public static final int INT_HEBREW = 6;
    public static final int INT_HIJRI = 5;
    public static final int INT_JAPAN = 8;
    public static final int INT_KOREA = 10;
    public static final int INT_NONE = 14;
    public static final int INT_SAKA = 11;
    public static final int INT_TAIWAN = 7;
    public static final int INT_THAI = 9;
    public static final Enum JAPAN;
    public static final Enum KOREA;
    public static final Enum NONE;
    public static final Enum SAKA;
    public static final Enum TAIWAN;
    public static final Enum THAI;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_GREGORIAN = 1;
        static final int INT_GREGORIAN_ARABIC = 4;
        static final int INT_GREGORIAN_ME_FRENCH = 3;
        static final int INT_GREGORIAN_US = 2;
        static final int INT_GREGORIAN_XLIT_ENGLISH = 12;
        static final int INT_GREGORIAN_XLIT_FRENCH = 13;
        static final int INT_HEBREW = 6;
        static final int INT_HIJRI = 5;
        static final int INT_JAPAN = 8;
        static final int INT_KOREA = 10;
        static final int INT_NONE = 14;
        static final int INT_SAKA = 11;
        static final int INT_TAIWAN = 7;
        static final int INT_THAI = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(LocalePreferences.CalendarType.GREGORIAN, 1), new Enum("gregorianUs", 2), new Enum("gregorianMeFrench", 3), new Enum("gregorianArabic", 4), new Enum("hijri", 5), new Enum(LocalePreferences.CalendarType.HEBREW, 6), new Enum("taiwan", 7), new Enum("japan", 8), new Enum("thai", 9), new Enum("korea", 10), new Enum("saka", 11), new Enum("gregorianXlitEnglish", 12), new Enum("gregorianXlitFrench", 13), new Enum("none", 14)});

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
        SimpleTypeFactory<STCalendarType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcalendartype8cd2type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        GREGORIAN = Enum.forString(LocalePreferences.CalendarType.GREGORIAN);
        GREGORIAN_US = Enum.forString("gregorianUs");
        GREGORIAN_ME_FRENCH = Enum.forString("gregorianMeFrench");
        GREGORIAN_ARABIC = Enum.forString("gregorianArabic");
        HIJRI = Enum.forString("hijri");
        HEBREW = Enum.forString(LocalePreferences.CalendarType.HEBREW);
        TAIWAN = Enum.forString("taiwan");
        JAPAN = Enum.forString("japan");
        THAI = Enum.forString("thai");
        KOREA = Enum.forString("korea");
        SAKA = Enum.forString("saka");
        GREGORIAN_XLIT_ENGLISH = Enum.forString("gregorianXlitEnglish");
        GREGORIAN_XLIT_FRENCH = Enum.forString("gregorianXlitFrench");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
