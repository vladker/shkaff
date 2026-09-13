package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STTextVerticalType extends XmlToken {
    public static final Enum EA_VERT;
    public static final SimpleTypeFactory<STTextVerticalType> Factory;
    public static final Enum HORZ;
    public static final int INT_EA_VERT = 5;
    public static final int INT_HORZ = 1;
    public static final int INT_MONGOLIAN_VERT = 6;
    public static final int INT_VERT = 2;
    public static final int INT_VERT_270 = 3;
    public static final int INT_WORD_ART_VERT = 4;
    public static final int INT_WORD_ART_VERT_RTL = 7;
    public static final Enum MONGOLIAN_VERT;
    public static final Enum VERT;
    public static final Enum VERT_270;
    public static final Enum WORD_ART_VERT;
    public static final Enum WORD_ART_VERT_RTL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EA_VERT = 5;
        static final int INT_HORZ = 1;
        static final int INT_MONGOLIAN_VERT = 6;
        static final int INT_VERT = 2;
        static final int INT_VERT_270 = 3;
        static final int INT_WORD_ART_VERT = 4;
        static final int INT_WORD_ART_VERT_RTL = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("horz", 1), new Enum("vert", 2), new Enum("vert270", 3), new Enum("wordArtVert", 4), new Enum("eaVert", 5), new Enum("mongolianVert", 6), new Enum("wordArtVertRtl", 7)});

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
        SimpleTypeFactory<STTextVerticalType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttextverticaltyped988type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        HORZ = Enum.forString("horz");
        VERT = Enum.forString("vert");
        VERT_270 = Enum.forString("vert270");
        WORD_ART_VERT = Enum.forString("wordArtVert");
        EA_VERT = Enum.forString("eaVert");
        MONGOLIAN_VERT = Enum.forString("mongolianVert");
        WORD_ART_VERT_RTL = Enum.forString("wordArtVertRtl");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
