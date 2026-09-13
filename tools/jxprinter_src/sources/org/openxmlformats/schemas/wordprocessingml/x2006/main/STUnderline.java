package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STUnderline extends XmlString {
    public static final Enum DASH;
    public static final Enum DASHED_HEAVY;
    public static final Enum DASH_DOT_DOT_HEAVY;
    public static final Enum DASH_DOT_HEAVY;
    public static final Enum DASH_LONG;
    public static final Enum DASH_LONG_HEAVY;
    public static final Enum DOTTED;
    public static final Enum DOTTED_HEAVY;
    public static final Enum DOT_DASH;
    public static final Enum DOT_DOT_DASH;
    public static final Enum DOUBLE;
    public static final SimpleTypeFactory<STUnderline> Factory;
    public static final int INT_DASH = 7;
    public static final int INT_DASHED_HEAVY = 8;
    public static final int INT_DASH_DOT_DOT_HEAVY = 14;
    public static final int INT_DASH_DOT_HEAVY = 12;
    public static final int INT_DASH_LONG = 9;
    public static final int INT_DASH_LONG_HEAVY = 10;
    public static final int INT_DOTTED = 5;
    public static final int INT_DOTTED_HEAVY = 6;
    public static final int INT_DOT_DASH = 11;
    public static final int INT_DOT_DOT_DASH = 13;
    public static final int INT_DOUBLE = 3;
    public static final int INT_NONE = 18;
    public static final int INT_SINGLE = 1;
    public static final int INT_THICK = 4;
    public static final int INT_WAVE = 15;
    public static final int INT_WAVY_DOUBLE = 17;
    public static final int INT_WAVY_HEAVY = 16;
    public static final int INT_WORDS = 2;
    public static final Enum NONE;
    public static final Enum SINGLE;
    public static final Enum THICK;
    public static final Enum WAVE;
    public static final Enum WAVY_DOUBLE;
    public static final Enum WAVY_HEAVY;
    public static final Enum WORDS;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASH = 7;
        static final int INT_DASHED_HEAVY = 8;
        static final int INT_DASH_DOT_DOT_HEAVY = 14;
        static final int INT_DASH_DOT_HEAVY = 12;
        static final int INT_DASH_LONG = 9;
        static final int INT_DASH_LONG_HEAVY = 10;
        static final int INT_DOTTED = 5;
        static final int INT_DOTTED_HEAVY = 6;
        static final int INT_DOT_DASH = 11;
        static final int INT_DOT_DOT_DASH = 13;
        static final int INT_DOUBLE = 3;
        static final int INT_NONE = 18;
        static final int INT_SINGLE = 1;
        static final int INT_THICK = 4;
        static final int INT_WAVE = 15;
        static final int INT_WAVY_DOUBLE = 17;
        static final int INT_WAVY_HEAVY = 16;
        static final int INT_WORDS = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("single", 1), new Enum("words", 2), new Enum(XmlErrorCodes.DOUBLE, 3), new Enum("thick", 4), new Enum("dotted", 5), new Enum("dottedHeavy", 6), new Enum("dash", 7), new Enum("dashedHeavy", 8), new Enum("dashLong", 9), new Enum("dashLongHeavy", 10), new Enum("dotDash", 11), new Enum("dashDotHeavy", 12), new Enum("dotDotDash", 13), new Enum("dashDotDotHeavy", 14), new Enum("wave", 15), new Enum("wavyHeavy", 16), new Enum("wavyDouble", 17), new Enum("none", 18)});

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
        SimpleTypeFactory<STUnderline> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stunderlinef416type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SINGLE = Enum.forString("single");
        WORDS = Enum.forString("words");
        DOUBLE = Enum.forString(XmlErrorCodes.DOUBLE);
        THICK = Enum.forString("thick");
        DOTTED = Enum.forString("dotted");
        DOTTED_HEAVY = Enum.forString("dottedHeavy");
        DASH = Enum.forString("dash");
        DASHED_HEAVY = Enum.forString("dashedHeavy");
        DASH_LONG = Enum.forString("dashLong");
        DASH_LONG_HEAVY = Enum.forString("dashLongHeavy");
        DOT_DASH = Enum.forString("dotDash");
        DASH_DOT_HEAVY = Enum.forString("dashDotHeavy");
        DOT_DOT_DASH = Enum.forString("dotDotDash");
        DASH_DOT_DOT_HEAVY = Enum.forString("dashDotDotHeavy");
        WAVE = Enum.forString("wave");
        WAVY_HEAVY = Enum.forString("wavyHeavy");
        WAVY_DOUBLE = Enum.forString("wavyDouble");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
