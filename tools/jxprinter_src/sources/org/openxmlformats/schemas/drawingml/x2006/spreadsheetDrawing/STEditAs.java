package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STEditAs extends XmlToken {
    public static final Enum ABSOLUTE;
    public static final SimpleTypeFactory<STEditAs> Factory;
    public static final int INT_ABSOLUTE = 3;
    public static final int INT_ONE_CELL = 2;
    public static final int INT_TWO_CELL = 1;
    public static final Enum ONE_CELL;
    public static final Enum TWO_CELL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ABSOLUTE = 3;
        static final int INT_ONE_CELL = 2;
        static final int INT_TWO_CELL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("twoCell", 1), new Enum("oneCell", 2), new Enum("absolute", 3)});

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
        SimpleTypeFactory<STEditAs> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "steditasad40type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        TWO_CELL = Enum.forString("twoCell");
        ONE_CELL = Enum.forString("oneCell");
        ABSOLUTE = Enum.forString("absolute");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
