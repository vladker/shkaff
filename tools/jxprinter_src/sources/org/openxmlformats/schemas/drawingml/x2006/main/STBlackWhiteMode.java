package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STBlackWhiteMode extends XmlToken {
    public static final Enum AUTO;
    public static final Enum BLACK;
    public static final Enum BLACK_GRAY;
    public static final Enum BLACK_WHITE;
    public static final Enum CLR;
    public static final SimpleTypeFactory<STBlackWhiteMode> Factory;
    public static final Enum GRAY;
    public static final Enum GRAY_WHITE;
    public static final Enum HIDDEN;
    public static final int INT_AUTO = 2;
    public static final int INT_BLACK = 9;
    public static final int INT_BLACK_GRAY = 7;
    public static final int INT_BLACK_WHITE = 8;
    public static final int INT_CLR = 1;
    public static final int INT_GRAY = 3;
    public static final int INT_GRAY_WHITE = 6;
    public static final int INT_HIDDEN = 11;
    public static final int INT_INV_GRAY = 5;
    public static final int INT_LT_GRAY = 4;
    public static final int INT_WHITE = 10;
    public static final Enum INV_GRAY;
    public static final Enum LT_GRAY;
    public static final Enum WHITE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 2;
        static final int INT_BLACK = 9;
        static final int INT_BLACK_GRAY = 7;
        static final int INT_BLACK_WHITE = 8;
        static final int INT_CLR = 1;
        static final int INT_GRAY = 3;
        static final int INT_GRAY_WHITE = 6;
        static final int INT_HIDDEN = 11;
        static final int INT_INV_GRAY = 5;
        static final int INT_LT_GRAY = 4;
        static final int INT_WHITE = 10;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clr", 1), new Enum("auto", 2), new Enum("gray", 3), new Enum("ltGray", 4), new Enum("invGray", 5), new Enum("grayWhite", 6), new Enum("blackGray", 7), new Enum("blackWhite", 8), new Enum("black", 9), new Enum("white", 10), new Enum(CellUtil.HIDDEN, 11)});

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
        SimpleTypeFactory<STBlackWhiteMode> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stblackwhitemode0558type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CLR = Enum.forString("clr");
        AUTO = Enum.forString("auto");
        GRAY = Enum.forString("gray");
        LT_GRAY = Enum.forString("ltGray");
        INV_GRAY = Enum.forString("invGray");
        GRAY_WHITE = Enum.forString("grayWhite");
        BLACK_GRAY = Enum.forString("blackGray");
        BLACK_WHITE = Enum.forString("blackWhite");
        BLACK = Enum.forString("black");
        WHITE = Enum.forString("white");
        HIDDEN = Enum.forString(CellUtil.HIDDEN);
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
