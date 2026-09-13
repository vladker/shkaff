package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STJcTable extends XmlString {
    public static final Enum CENTER;
    public static final Enum END;
    public static final SimpleTypeFactory<STJcTable> Factory;
    public static final int INT_CENTER = 1;
    public static final int INT_END = 2;
    public static final int INT_LEFT = 3;
    public static final int INT_RIGHT = 4;
    public static final int INT_START = 5;
    public static final Enum LEFT;
    public static final Enum RIGHT;
    public static final Enum START;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CENTER = 1;
        static final int INT_END = 2;
        static final int INT_LEFT = 3;
        static final int INT_RIGHT = 4;
        static final int INT_START = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("center", 1), new Enum("end", 2), new Enum("left", 3), new Enum("right", 4), new Enum("start", 5)});

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
        SimpleTypeFactory<STJcTable> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stjctable2eadtype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CENTER = Enum.forString("center");
        END = Enum.forString("end");
        LEFT = Enum.forString("left");
        RIGHT = Enum.forString("right");
        START = Enum.forString("start");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
