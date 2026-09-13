package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import io.flutter.plugins.firebase.crashlytics.Constants;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STRelFromV extends XmlToken {
    public static final Enum BOTTOM_MARGIN;
    public static final SimpleTypeFactory<STRelFromV> Factory;
    public static final Enum INSIDE_MARGIN;
    public static final int INT_BOTTOM_MARGIN = 6;
    public static final int INT_INSIDE_MARGIN = 7;
    public static final int INT_LINE = 4;
    public static final int INT_MARGIN = 1;
    public static final int INT_OUTSIDE_MARGIN = 8;
    public static final int INT_PAGE = 2;
    public static final int INT_PARAGRAPH = 3;
    public static final int INT_TOP_MARGIN = 5;
    public static final Enum LINE;
    public static final Enum MARGIN;
    public static final Enum OUTSIDE_MARGIN;
    public static final Enum PAGE;
    public static final Enum PARAGRAPH;
    public static final Enum TOP_MARGIN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM_MARGIN = 6;
        static final int INT_INSIDE_MARGIN = 7;
        static final int INT_LINE = 4;
        static final int INT_MARGIN = 1;
        static final int INT_OUTSIDE_MARGIN = 8;
        static final int INT_PAGE = 2;
        static final int INT_PARAGRAPH = 3;
        static final int INT_TOP_MARGIN = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("margin", 1), new Enum("page", 2), new Enum("paragraph", 3), new Enum(Constants.LINE, 4), new Enum("topMargin", 5), new Enum("bottomMargin", 6), new Enum("insideMargin", 7), new Enum("outsideMargin", 8)});

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
        SimpleTypeFactory<STRelFromV> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "strelfromv56dctype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        MARGIN = Enum.forString("margin");
        PAGE = Enum.forString("page");
        PARAGRAPH = Enum.forString("paragraph");
        LINE = Enum.forString(Constants.LINE);
        TOP_MARGIN = Enum.forString("topMargin");
        BOTTOM_MARGIN = Enum.forString("bottomMargin");
        INSIDE_MARGIN = Enum.forString("insideMargin");
        OUTSIDE_MARGIN = Enum.forString("outsideMargin");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
