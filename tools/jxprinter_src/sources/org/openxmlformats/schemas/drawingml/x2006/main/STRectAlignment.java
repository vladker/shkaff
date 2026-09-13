package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STRectAlignment extends XmlToken {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Enum f7709B;
    public static final Enum BL;
    public static final Enum BR;
    public static final Enum CTR;
    public static final SimpleTypeFactory<STRectAlignment> Factory;
    public static final int INT_B = 8;
    public static final int INT_BL = 7;
    public static final int INT_BR = 9;
    public static final int INT_CTR = 5;
    public static final int INT_L = 4;
    public static final int INT_R = 6;
    public static final int INT_T = 2;
    public static final int INT_TL = 1;
    public static final int INT_TR = 3;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final Enum f7710L;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final Enum f7711R;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Enum f7712T;
    public static final Enum TL;
    public static final Enum TR;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 8;
        static final int INT_BL = 7;
        static final int INT_BR = 9;
        static final int INT_CTR = 5;
        static final int INT_L = 4;
        static final int INT_R = 6;
        static final int INT_T = 2;
        static final int INT_TL = 1;
        static final int INT_TR = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("tl", 1), new Enum("t", 2), new Enum("tr", 3), new Enum("l", 4), new Enum("ctr", 5), new Enum("r", 6), new Enum("bl", 7), new Enum("b", 8), new Enum(CompressorStreamFactory.BROTLI, 9)});

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
        SimpleTypeFactory<STRectAlignment> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "strectalignmentd400type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        TL = Enum.forString("tl");
        f7712T = Enum.forString("t");
        TR = Enum.forString("tr");
        f7710L = Enum.forString("l");
        CTR = Enum.forString("ctr");
        f7711R = Enum.forString("r");
        BL = Enum.forString("bl");
        f7709B = Enum.forString("b");
        BR = Enum.forString(CompressorStreamFactory.BROTLI);
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
