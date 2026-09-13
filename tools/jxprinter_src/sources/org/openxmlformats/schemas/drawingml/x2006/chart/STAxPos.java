package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STAxPos extends XmlString {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Enum f7692B;
    public static final SimpleTypeFactory<STAxPos> Factory;
    public static final int INT_B = 1;
    public static final int INT_L = 2;
    public static final int INT_R = 3;
    public static final int INT_T = 4;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final Enum f7693L;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final Enum f7694R;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final Enum f7695T;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 1;
        static final int INT_L = 2;
        static final int INT_R = 3;
        static final int INT_T = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("b", 1), new Enum("l", 2), new Enum("r", 3), new Enum("t", 4)});

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
        SimpleTypeFactory<STAxPos> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "staxpos4379type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        f7692B = Enum.forString("b");
        f7693L = Enum.forString("l");
        f7694R = Enum.forString("r");
        f7695T = Enum.forString("t");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
