package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STGrouping extends XmlString {
    public static final SimpleTypeFactory<STGrouping> Factory;
    public static final int INT_PERCENT_STACKED = 1;
    public static final int INT_STACKED = 3;
    public static final int INT_STANDARD = 2;
    public static final Enum PERCENT_STACKED;
    public static final Enum STACKED;
    public static final Enum STANDARD;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_PERCENT_STACKED = 1;
        static final int INT_STACKED = 3;
        static final int INT_STANDARD = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("percentStacked", 1), new Enum("standard", 2), new Enum("stacked", 3)});

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
        SimpleTypeFactory<STGrouping> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stgrouping5ec9type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        PERCENT_STACKED = Enum.forString("percentStacked");
        STANDARD = Enum.forString("standard");
        STACKED = Enum.forString("stacked");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
