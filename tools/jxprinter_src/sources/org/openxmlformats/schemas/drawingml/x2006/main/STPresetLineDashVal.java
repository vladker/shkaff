package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STPresetLineDashVal extends XmlToken {
    public static final Enum DASH;
    public static final Enum DASH_DOT;
    public static final Enum DOT;
    public static final SimpleTypeFactory<STPresetLineDashVal> Factory;
    public static final int INT_DASH = 3;
    public static final int INT_DASH_DOT = 5;
    public static final int INT_DOT = 2;
    public static final int INT_LG_DASH = 4;
    public static final int INT_LG_DASH_DOT = 6;
    public static final int INT_LG_DASH_DOT_DOT = 7;
    public static final int INT_SOLID = 1;
    public static final int INT_SYS_DASH = 8;
    public static final int INT_SYS_DASH_DOT = 10;
    public static final int INT_SYS_DASH_DOT_DOT = 11;
    public static final int INT_SYS_DOT = 9;
    public static final Enum LG_DASH;
    public static final Enum LG_DASH_DOT;
    public static final Enum LG_DASH_DOT_DOT;
    public static final Enum SOLID;
    public static final Enum SYS_DASH;
    public static final Enum SYS_DASH_DOT;
    public static final Enum SYS_DASH_DOT_DOT;
    public static final Enum SYS_DOT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DASH = 3;
        static final int INT_DASH_DOT = 5;
        static final int INT_DOT = 2;
        static final int INT_LG_DASH = 4;
        static final int INT_LG_DASH_DOT = 6;
        static final int INT_LG_DASH_DOT_DOT = 7;
        static final int INT_SOLID = 1;
        static final int INT_SYS_DASH = 8;
        static final int INT_SYS_DASH_DOT = 10;
        static final int INT_SYS_DASH_DOT_DOT = 11;
        static final int INT_SYS_DOT = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("solid", 1), new Enum("dot", 2), new Enum("dash", 3), new Enum("lgDash", 4), new Enum("dashDot", 5), new Enum("lgDashDot", 6), new Enum("lgDashDotDot", 7), new Enum("sysDash", 8), new Enum("sysDot", 9), new Enum("sysDashDot", 10), new Enum("sysDashDotDot", 11)});

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
        SimpleTypeFactory<STPresetLineDashVal> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpresetlinedashval159dtype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SOLID = Enum.forString("solid");
        DOT = Enum.forString("dot");
        DASH = Enum.forString("dash");
        LG_DASH = Enum.forString("lgDash");
        DASH_DOT = Enum.forString("dashDot");
        LG_DASH_DOT = Enum.forString("lgDashDot");
        LG_DASH_DOT_DOT = Enum.forString("lgDashDotDot");
        SYS_DASH = Enum.forString("sysDash");
        SYS_DOT = Enum.forString("sysDot");
        SYS_DASH_DOT = Enum.forString("sysDashDot");
        SYS_DASH_DOT_DOT = Enum.forString("sysDashDotDot");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
