package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STBarGrouping extends XmlString {
    public static final Enum CLUSTERED;
    public static final SimpleTypeFactory<STBarGrouping> Factory;
    public static final int INT_CLUSTERED = 2;
    public static final int INT_PERCENT_STACKED = 1;
    public static final int INT_STACKED = 4;
    public static final int INT_STANDARD = 3;
    public static final Enum PERCENT_STACKED;
    public static final Enum STACKED;
    public static final Enum STANDARD;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CLUSTERED = 2;
        static final int INT_PERCENT_STACKED = 1;
        static final int INT_STACKED = 4;
        static final int INT_STANDARD = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("percentStacked", 1), new Enum("clustered", 2), new Enum("standard", 3), new Enum("stacked", 4)});

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
        SimpleTypeFactory<STBarGrouping> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stbargrouping8400type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        PERCENT_STACKED = Enum.forString("percentStacked");
        CLUSTERED = Enum.forString("clustered");
        STANDARD = Enum.forString("standard");
        STACKED = Enum.forString("stacked");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
