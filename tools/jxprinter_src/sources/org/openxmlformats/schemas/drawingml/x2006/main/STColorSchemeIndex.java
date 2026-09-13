package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STColorSchemeIndex extends XmlToken {
    public static final Enum ACCENT_1;
    public static final Enum ACCENT_2;
    public static final Enum ACCENT_3;
    public static final Enum ACCENT_4;
    public static final Enum ACCENT_5;
    public static final Enum ACCENT_6;
    public static final Enum DK_1;
    public static final Enum DK_2;
    public static final Enum FOL_HLINK;
    public static final SimpleTypeFactory<STColorSchemeIndex> Factory;
    public static final Enum HLINK;
    public static final int INT_ACCENT_1 = 5;
    public static final int INT_ACCENT_2 = 6;
    public static final int INT_ACCENT_3 = 7;
    public static final int INT_ACCENT_4 = 8;
    public static final int INT_ACCENT_5 = 9;
    public static final int INT_ACCENT_6 = 10;
    public static final int INT_DK_1 = 1;
    public static final int INT_DK_2 = 3;
    public static final int INT_FOL_HLINK = 12;
    public static final int INT_HLINK = 11;
    public static final int INT_LT_1 = 2;
    public static final int INT_LT_2 = 4;
    public static final Enum LT_1;
    public static final Enum LT_2;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCENT_1 = 5;
        static final int INT_ACCENT_2 = 6;
        static final int INT_ACCENT_3 = 7;
        static final int INT_ACCENT_4 = 8;
        static final int INT_ACCENT_5 = 9;
        static final int INT_ACCENT_6 = 10;
        static final int INT_DK_1 = 1;
        static final int INT_DK_2 = 3;
        static final int INT_FOL_HLINK = 12;
        static final int INT_HLINK = 11;
        static final int INT_LT_1 = 2;
        static final int INT_LT_2 = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("dk1", 1), new Enum("lt1", 2), new Enum("dk2", 3), new Enum("lt2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), new Enum("hlink", 11), new Enum("folHlink", 12)});

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
        SimpleTypeFactory<STColorSchemeIndex> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcolorschemeindexe6f5type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        DK_1 = Enum.forString("dk1");
        LT_1 = Enum.forString("lt1");
        DK_2 = Enum.forString("dk2");
        LT_2 = Enum.forString("lt2");
        ACCENT_1 = Enum.forString("accent1");
        ACCENT_2 = Enum.forString("accent2");
        ACCENT_3 = Enum.forString("accent3");
        ACCENT_4 = Enum.forString("accent4");
        ACCENT_5 = Enum.forString("accent5");
        ACCENT_6 = Enum.forString("accent6");
        HLINK = Enum.forString("hlink");
        FOL_HLINK = Enum.forString("folHlink");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
