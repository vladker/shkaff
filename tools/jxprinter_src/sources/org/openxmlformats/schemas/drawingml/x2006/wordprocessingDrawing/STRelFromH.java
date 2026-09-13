package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STRelFromH extends XmlToken {
    public static final Enum CHARACTER;
    public static final Enum COLUMN;
    public static final SimpleTypeFactory<STRelFromH> Factory;
    public static final Enum INSIDE_MARGIN;
    public static final int INT_CHARACTER = 4;
    public static final int INT_COLUMN = 3;
    public static final int INT_INSIDE_MARGIN = 7;
    public static final int INT_LEFT_MARGIN = 5;
    public static final int INT_MARGIN = 1;
    public static final int INT_OUTSIDE_MARGIN = 8;
    public static final int INT_PAGE = 2;
    public static final int INT_RIGHT_MARGIN = 6;
    public static final Enum LEFT_MARGIN;
    public static final Enum MARGIN;
    public static final Enum OUTSIDE_MARGIN;
    public static final Enum PAGE;
    public static final Enum RIGHT_MARGIN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CHARACTER = 4;
        static final int INT_COLUMN = 3;
        static final int INT_INSIDE_MARGIN = 7;
        static final int INT_LEFT_MARGIN = 5;
        static final int INT_MARGIN = 1;
        static final int INT_OUTSIDE_MARGIN = 8;
        static final int INT_PAGE = 2;
        static final int INT_RIGHT_MARGIN = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("margin", 1), new Enum("page", 2), new Enum("column", 3), new Enum(FirebaseAnalytics.Param.CHARACTER, 4), new Enum("leftMargin", 5), new Enum("rightMargin", 6), new Enum("insideMargin", 7), new Enum("outsideMargin", 8)});

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
        SimpleTypeFactory<STRelFromH> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "strelfromh72aatype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        MARGIN = Enum.forString("margin");
        PAGE = Enum.forString("page");
        COLUMN = Enum.forString("column");
        CHARACTER = Enum.forString(FirebaseAnalytics.Param.CHARACTER);
        LEFT_MARGIN = Enum.forString("leftMargin");
        RIGHT_MARGIN = Enum.forString("rightMargin");
        INSIDE_MARGIN = Enum.forString("insideMargin");
        OUTSIDE_MARGIN = Enum.forString("outsideMargin");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
