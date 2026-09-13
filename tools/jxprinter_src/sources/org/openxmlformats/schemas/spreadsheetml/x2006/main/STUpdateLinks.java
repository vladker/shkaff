package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STUpdateLinks extends XmlString {
    public static final Enum ALWAYS;
    public static final SimpleTypeFactory<STUpdateLinks> Factory;
    public static final int INT_ALWAYS = 3;
    public static final int INT_NEVER = 2;
    public static final int INT_USER_SET = 1;
    public static final Enum NEVER;
    public static final Enum USER_SET;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALWAYS = 3;
        static final int INT_NEVER = 2;
        static final int INT_USER_SET = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("userSet", 1), new Enum("never", 2), new Enum("always", 3)});

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
        SimpleTypeFactory<STUpdateLinks> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stupdatelinksfb3ftype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        USER_SET = Enum.forString("userSet");
        NEVER = Enum.forString("never");
        ALWAYS = Enum.forString("always");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
