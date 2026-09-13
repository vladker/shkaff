package com.microsoft.schemas.vml;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STStrokeArrowType extends XmlString {
    public static final Enum BLOCK;
    public static final Enum CLASSIC;
    public static final Enum DIAMOND;
    public static final SimpleTypeFactory<STStrokeArrowType> Factory;
    public static final int INT_BLOCK = 2;
    public static final int INT_CLASSIC = 3;
    public static final int INT_DIAMOND = 5;
    public static final int INT_NONE = 1;
    public static final int INT_OPEN = 6;
    public static final int INT_OVAL = 4;
    public static final Enum NONE;
    public static final Enum OPEN;
    public static final Enum OVAL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BLOCK = 2;
        static final int INT_CLASSIC = 3;
        static final int INT_DIAMOND = 5;
        static final int INT_NONE = 1;
        static final int INT_OPEN = 6;
        static final int INT_OVAL = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("block", 2), new Enum("classic", 3), new Enum("oval", 4), new Enum("diamond", 5), new Enum("open", 6)});

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
        SimpleTypeFactory<STStrokeArrowType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "ststrokearrowtype7b4ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        BLOCK = Enum.forString("block");
        CLASSIC = Enum.forString("classic");
        OVAL = Enum.forString("oval");
        DIAMOND = Enum.forString("diamond");
        OPEN = Enum.forString("open");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
