package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STBorderStyle extends XmlString {
    public static final Enum DASHED;
    public static final Enum DASH_DOT;
    public static final Enum DASH_DOT_DOT;
    public static final Enum DOTTED;
    public static final Enum DOUBLE;
    public static final SimpleTypeFactory<STBorderStyle> Factory;
    public static final Enum HAIR;
    public static final int INT_DASHED = 4;
    public static final int INT_DASH_DOT = 10;
    public static final int INT_DASH_DOT_DOT = 12;
    public static final int INT_DOTTED = 5;
    public static final int INT_DOUBLE = 7;
    public static final int INT_HAIR = 8;
    public static final int INT_MEDIUM = 3;
    public static final int INT_MEDIUM_DASHED = 9;
    public static final int INT_MEDIUM_DASH_DOT = 11;
    public static final int INT_MEDIUM_DASH_DOT_DOT = 13;
    public static final int INT_NONE = 1;
    public static final int INT_SLANT_DASH_DOT = 14;
    public static final int INT_THICK = 6;
    public static final int INT_THIN = 2;
    public static final Enum MEDIUM;
    public static final Enum MEDIUM_DASHED;
    public static final Enum MEDIUM_DASH_DOT;
    public static final Enum MEDIUM_DASH_DOT_DOT;
    public static final Enum NONE;
    public static final Enum SLANT_DASH_DOT;
    public static final Enum THICK;
    public static final Enum THIN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASHED = 4;
        static final int INT_DASH_DOT = 10;
        static final int INT_DASH_DOT_DOT = 12;
        static final int INT_DOTTED = 5;
        static final int INT_DOUBLE = 7;
        static final int INT_HAIR = 8;
        static final int INT_MEDIUM = 3;
        static final int INT_MEDIUM_DASHED = 9;
        static final int INT_MEDIUM_DASH_DOT = 11;
        static final int INT_MEDIUM_DASH_DOT_DOT = 13;
        static final int INT_NONE = 1;
        static final int INT_SLANT_DASH_DOT = 14;
        static final int INT_THICK = 6;
        static final int INT_THIN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("thin", 2), new Enum(FirebaseAnalytics.Param.MEDIUM, 3), new Enum("dashed", 4), new Enum("dotted", 5), new Enum("thick", 6), new Enum(XmlErrorCodes.DOUBLE, 7), new Enum("hair", 8), new Enum("mediumDashed", 9), new Enum("dashDot", 10), new Enum("mediumDashDot", 11), new Enum("dashDotDot", 12), new Enum("mediumDashDotDot", 13), new Enum("slantDashDot", 14)});

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
        SimpleTypeFactory<STBorderStyle> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stborderstylec774type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        THIN = Enum.forString("thin");
        MEDIUM = Enum.forString(FirebaseAnalytics.Param.MEDIUM);
        DASHED = Enum.forString("dashed");
        DOTTED = Enum.forString("dotted");
        THICK = Enum.forString("thick");
        DOUBLE = Enum.forString(XmlErrorCodes.DOUBLE);
        HAIR = Enum.forString("hair");
        MEDIUM_DASHED = Enum.forString("mediumDashed");
        DASH_DOT = Enum.forString("dashDot");
        MEDIUM_DASH_DOT = Enum.forString("mediumDashDot");
        DASH_DOT_DOT = Enum.forString("dashDotDot");
        MEDIUM_DASH_DOT_DOT = Enum.forString("mediumDashDotDot");
        SLANT_DASH_DOT = Enum.forString("slantDashDot");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
