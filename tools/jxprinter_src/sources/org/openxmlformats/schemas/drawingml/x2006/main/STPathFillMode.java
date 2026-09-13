package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STPathFillMode extends XmlToken {
    public static final Enum DARKEN;
    public static final Enum DARKEN_LESS;
    public static final SimpleTypeFactory<STPathFillMode> Factory;
    public static final int INT_DARKEN = 5;
    public static final int INT_DARKEN_LESS = 6;
    public static final int INT_LIGHTEN = 3;
    public static final int INT_LIGHTEN_LESS = 4;
    public static final int INT_NONE = 1;
    public static final int INT_NORM = 2;
    public static final Enum LIGHTEN;
    public static final Enum LIGHTEN_LESS;
    public static final Enum NONE;
    public static final Enum NORM;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_DARKEN = 5;
        static final int INT_DARKEN_LESS = 6;
        static final int INT_LIGHTEN = 3;
        static final int INT_LIGHTEN_LESS = 4;
        static final int INT_NONE = 1;
        static final int INT_NORM = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("norm", 2), new Enum("lighten", 3), new Enum("lightenLess", 4), new Enum("darken", 5), new Enum("darkenLess", 6)});

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
        SimpleTypeFactory<STPathFillMode> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpathfillmode3cf6type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NONE = Enum.forString("none");
        NORM = Enum.forString("norm");
        LIGHTEN = Enum.forString("lighten");
        LIGHTEN_LESS = Enum.forString("lightenLess");
        DARKEN = Enum.forString("darken");
        DARKEN_LESS = Enum.forString("darkenLess");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
