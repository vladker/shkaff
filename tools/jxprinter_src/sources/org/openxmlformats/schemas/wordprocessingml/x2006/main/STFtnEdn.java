package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STFtnEdn extends XmlString {
    public static final Enum CONTINUATION_NOTICE;
    public static final Enum CONTINUATION_SEPARATOR;
    public static final SimpleTypeFactory<STFtnEdn> Factory;
    public static final int INT_CONTINUATION_NOTICE = 4;
    public static final int INT_CONTINUATION_SEPARATOR = 3;
    public static final int INT_NORMAL = 1;
    public static final int INT_SEPARATOR = 2;
    public static final Enum NORMAL;
    public static final Enum SEPARATOR;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUATION_NOTICE = 4;
        static final int INT_CONTINUATION_SEPARATOR = 3;
        static final int INT_NORMAL = 1;
        static final int INT_SEPARATOR = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("normal", 1), new Enum("separator", 2), new Enum("continuationSeparator", 3), new Enum("continuationNotice", 4)});

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
        SimpleTypeFactory<STFtnEdn> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stftnednd4c9type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NORMAL = Enum.forString("normal");
        SEPARATOR = Enum.forString("separator");
        CONTINUATION_SEPARATOR = Enum.forString("continuationSeparator");
        CONTINUATION_NOTICE = Enum.forString("continuationNotice");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
