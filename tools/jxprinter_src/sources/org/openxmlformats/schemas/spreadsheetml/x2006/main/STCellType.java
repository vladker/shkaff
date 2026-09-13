package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STCellType extends XmlString {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Enum f7728B;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final Enum f7729E;
    public static final SimpleTypeFactory<STCellType> Factory;
    public static final Enum INLINE_STR;
    public static final int INT_B = 1;
    public static final int INT_E = 3;
    public static final int INT_INLINE_STR = 6;
    public static final int INT_N = 2;
    public static final int INT_S = 4;
    public static final int INT_STR = 5;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final Enum f7730N;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final Enum f7731S;
    public static final Enum STR;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 1;
        static final int INT_E = 3;
        static final int INT_INLINE_STR = 6;
        static final int INT_N = 2;
        static final int INT_S = 4;
        static final int INT_STR = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("b", 1), new Enum("n", 2), new Enum("e", 3), new Enum("s", 4), new Enum("str", 5), new Enum("inlineStr", 6)});

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
        SimpleTypeFactory<STCellType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcelltypebf95type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        f7728B = Enum.forString("b");
        f7730N = Enum.forString("n");
        f7729E = Enum.forString("e");
        f7731S = Enum.forString("s");
        STR = Enum.forString("str");
        INLINE_STR = Enum.forString("inlineStr");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
