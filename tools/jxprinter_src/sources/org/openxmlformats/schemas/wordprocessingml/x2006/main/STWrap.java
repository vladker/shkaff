package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STWrap extends XmlString {
    public static final Enum AROUND;
    public static final Enum AUTO;
    public static final SimpleTypeFactory<STWrap> Factory;
    public static final int INT_AROUND = 3;
    public static final int INT_AUTO = 1;
    public static final int INT_NONE = 6;
    public static final int INT_NOT_BESIDE = 2;
    public static final int INT_THROUGH = 5;
    public static final int INT_TIGHT = 4;
    public static final Enum NONE;
    public static final Enum NOT_BESIDE;
    public static final Enum THROUGH;
    public static final Enum TIGHT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AROUND = 3;
        static final int INT_AUTO = 1;
        static final int INT_NONE = 6;
        static final int INT_NOT_BESIDE = 2;
        static final int INT_THROUGH = 5;
        static final int INT_TIGHT = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("auto", 1), new Enum("notBeside", 2), new Enum("around", 3), new Enum("tight", 4), new Enum("through", 5), new Enum("none", 6)});

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
        SimpleTypeFactory<STWrap> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stwrap3f4etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        AUTO = Enum.forString("auto");
        NOT_BESIDE = Enum.forString("notBeside");
        AROUND = Enum.forString("around");
        TIGHT = Enum.forString("tight");
        THROUGH = Enum.forString("through");
        NONE = Enum.forString("none");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
