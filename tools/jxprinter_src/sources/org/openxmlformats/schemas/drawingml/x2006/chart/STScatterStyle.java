package org.openxmlformats.schemas.drawingml.x2006.chart;

import io.flutter.plugins.firebase.crashlytics.Constants;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STScatterStyle extends XmlString {
    public static final SimpleTypeFactory<STScatterStyle> Factory;
    public static final int INT_LINE = 2;
    public static final int INT_LINE_MARKER = 3;
    public static final int INT_MARKER = 4;
    public static final int INT_NONE = 1;
    public static final int INT_SMOOTH = 5;
    public static final int INT_SMOOTH_MARKER = 6;
    public static final Enum LINE;
    public static final Enum LINE_MARKER;
    public static final Enum MARKER;
    public static final Enum NONE;
    public static final Enum SMOOTH;
    public static final Enum SMOOTH_MARKER;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LINE = 2;
        static final int INT_LINE_MARKER = 3;
        static final int INT_MARKER = 4;
        static final int INT_NONE = 1;
        static final int INT_SMOOTH = 5;
        static final int INT_SMOOTH_MARKER = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum(Constants.LINE, 2), new Enum("lineMarker", 3), new Enum("marker", 4), new Enum("smooth", 5), new Enum("smoothMarker", 6)});

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
        SimpleTypeFactory<STScatterStyle> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stscatterstyle9eb9type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        LINE = Enum.forString(Constants.LINE);
        LINE_MARKER = Enum.forString("lineMarker");
        MARKER = Enum.forString("marker");
        SMOOTH = Enum.forString("smooth");
        SMOOTH_MARKER = Enum.forString("smoothMarker");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
