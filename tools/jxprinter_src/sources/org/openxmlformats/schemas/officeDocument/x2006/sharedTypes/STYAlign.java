package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STYAlign extends XmlString {
    public static final Enum BOTTOM;
    public static final Enum CENTER;
    public static final SimpleTypeFactory<STYAlign> Factory;
    public static final Enum INLINE;
    public static final Enum INSIDE;
    public static final int INT_BOTTOM = 4;
    public static final int INT_CENTER = 3;
    public static final int INT_INLINE = 1;
    public static final int INT_INSIDE = 5;
    public static final int INT_OUTSIDE = 6;
    public static final int INT_TOP = 2;
    public static final Enum OUTSIDE;
    public static final Enum TOP;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BOTTOM = 4;
        static final int INT_CENTER = 3;
        static final int INT_INLINE = 1;
        static final int INT_INSIDE = 5;
        static final int INT_OUTSIDE = 6;
        static final int INT_TOP = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("inline", 1), new Enum("top", 2), new Enum("center", 3), new Enum("bottom", 4), new Enum("inside", 5), new Enum("outside", 6)});

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
        SimpleTypeFactory<STYAlign> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "styalign3606type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        INLINE = Enum.forString("inline");
        TOP = Enum.forString("top");
        CENTER = Enum.forString("center");
        BOTTOM = Enum.forString("bottom");
        INSIDE = Enum.forString("inside");
        OUTSIDE = Enum.forString("outside");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
