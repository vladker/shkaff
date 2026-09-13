package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STHorizontalAlignment extends XmlString {
    public static final Enum CENTER;
    public static final Enum CENTER_CONTINUOUS;
    public static final Enum DISTRIBUTED;
    public static final Enum FILL;
    public static final SimpleTypeFactory<STHorizontalAlignment> Factory;
    public static final Enum GENERAL;
    public static final int INT_CENTER = 3;
    public static final int INT_CENTER_CONTINUOUS = 7;
    public static final int INT_DISTRIBUTED = 8;
    public static final int INT_FILL = 5;
    public static final int INT_GENERAL = 1;
    public static final int INT_JUSTIFY = 6;
    public static final int INT_LEFT = 2;
    public static final int INT_RIGHT = 4;
    public static final Enum JUSTIFY;
    public static final Enum LEFT;
    public static final Enum RIGHT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 3;
        static final int INT_CENTER_CONTINUOUS = 7;
        static final int INT_DISTRIBUTED = 8;
        static final int INT_FILL = 5;
        static final int INT_GENERAL = 1;
        static final int INT_JUSTIFY = 6;
        static final int INT_LEFT = 2;
        static final int INT_RIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("general", 1), new Enum("left", 2), new Enum("center", 3), new Enum("right", 4), new Enum("fill", 5), new Enum("justify", 6), new Enum("centerContinuous", 7), new Enum("distributed", 8)});

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
        SimpleTypeFactory<STHorizontalAlignment> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sthorizontalalignmentf92etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        GENERAL = Enum.forString("general");
        LEFT = Enum.forString("left");
        CENTER = Enum.forString("center");
        RIGHT = Enum.forString("right");
        FILL = Enum.forString("fill");
        JUSTIFY = Enum.forString("justify");
        CENTER_CONTINUOUS = Enum.forString("centerContinuous");
        DISTRIBUTED = Enum.forString("distributed");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
