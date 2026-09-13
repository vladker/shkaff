package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STEditAs extends XmlString {
    public static final Enum BULLSEYE;
    public static final Enum CANVAS;
    public static final Enum CYCLE;
    public static final SimpleTypeFactory<STEditAs> Factory;
    public static final int INT_BULLSEYE = 7;
    public static final int INT_CANVAS = 1;
    public static final int INT_CYCLE = 4;
    public static final int INT_ORGCHART = 2;
    public static final int INT_RADIAL = 3;
    public static final int INT_STACKED = 5;
    public static final int INT_VENN = 6;
    public static final Enum ORGCHART;
    public static final Enum RADIAL;
    public static final Enum STACKED;
    public static final Enum VENN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BULLSEYE = 7;
        static final int INT_CANVAS = 1;
        static final int INT_CYCLE = 4;
        static final int INT_ORGCHART = 2;
        static final int INT_RADIAL = 3;
        static final int INT_STACKED = 5;
        static final int INT_VENN = 6;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("canvas", 1), new Enum("orgchart", 2), new Enum("radial", 3), new Enum("cycle", 4), new Enum("stacked", 5), new Enum("venn", 6), new Enum("bullseye", 7)});

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
        SimpleTypeFactory<STEditAs> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "steditas85aatype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CANVAS = Enum.forString("canvas");
        ORGCHART = Enum.forString("orgchart");
        RADIAL = Enum.forString("radial");
        CYCLE = Enum.forString("cycle");
        STACKED = Enum.forString("stacked");
        VENN = Enum.forString("venn");
        BULLSEYE = Enum.forString("bullseye");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
