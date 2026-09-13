package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STDLblPos extends XmlString {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Enum f7696B;
    public static final Enum BEST_FIT;
    public static final Enum CTR;
    public static final SimpleTypeFactory<STDLblPos> Factory;
    public static final int INT_B = 2;
    public static final int INT_BEST_FIT = 1;
    public static final int INT_CTR = 3;
    public static final int INT_IN_BASE = 4;
    public static final int INT_IN_END = 5;
    public static final int INT_L = 6;
    public static final int INT_OUT_END = 7;
    public static final int INT_R = 8;
    public static final int INT_T = 9;
    public static final Enum IN_BASE;
    public static final Enum IN_END;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final Enum f7697L;
    public static final Enum OUT_END;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final Enum f7698R;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Enum f7699T;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 2;
        static final int INT_BEST_FIT = 1;
        static final int INT_CTR = 3;
        static final int INT_IN_BASE = 4;
        static final int INT_IN_END = 5;
        static final int INT_L = 6;
        static final int INT_OUT_END = 7;
        static final int INT_R = 8;
        static final int INT_T = 9;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("bestFit", 1), new Enum("b", 2), new Enum("ctr", 3), new Enum("inBase", 4), new Enum("inEnd", 5), new Enum("l", 6), new Enum("outEnd", 7), new Enum("r", 8), new Enum("t", 9)});

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
        SimpleTypeFactory<STDLblPos> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stdlblpos1cf4type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BEST_FIT = Enum.forString("bestFit");
        f7696B = Enum.forString("b");
        CTR = Enum.forString("ctr");
        IN_BASE = Enum.forString("inBase");
        IN_END = Enum.forString("inEnd");
        f7697L = Enum.forString("l");
        OUT_END = Enum.forString("outEnd");
        f7698R = Enum.forString("r");
        f7699T = Enum.forString("t");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
