package com.microsoft.schemas.vml;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STFillType extends XmlString {
    public static final Enum FRAME;
    public static final SimpleTypeFactory<STFillType> Factory;
    public static final Enum GRADIENT;
    public static final Enum GRADIENT_RADIAL;
    public static final int INT_FRAME = 6;
    public static final int INT_GRADIENT = 2;
    public static final int INT_GRADIENT_RADIAL = 3;
    public static final int INT_PATTERN = 5;
    public static final int INT_SOLID = 1;
    public static final int INT_TILE = 4;
    public static final Enum PATTERN;
    public static final Enum SOLID;
    public static final Enum TILE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FRAME = 6;
        static final int INT_GRADIENT = 2;
        static final int INT_GRADIENT_RADIAL = 3;
        static final int INT_PATTERN = 5;
        static final int INT_SOLID = 1;
        static final int INT_TILE = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("solid", 1), new Enum("gradient", 2), new Enum("gradientRadial", 3), new Enum("tile", 4), new Enum("pattern", 5), new Enum(TypedValues.AttributesType.S_FRAME, 6)});

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
        SimpleTypeFactory<STFillType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stfilltype382btype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SOLID = Enum.forString("solid");
        GRADIENT = Enum.forString("gradient");
        GRADIENT_RADIAL = Enum.forString("gradientRadial");
        TILE = Enum.forString("tile");
        PATTERN = Enum.forString("pattern");
        FRAME = Enum.forString(TypedValues.AttributesType.S_FRAME);
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
