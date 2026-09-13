package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STRestartNumber extends XmlString {
    public static final Enum CONTINUOUS;
    public static final Enum EACH_PAGE;
    public static final Enum EACH_SECT;
    public static final SimpleTypeFactory<STRestartNumber> Factory;
    public static final int INT_CONTINUOUS = 1;
    public static final int INT_EACH_PAGE = 3;
    public static final int INT_EACH_SECT = 2;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUOUS = 1;
        static final int INT_EACH_PAGE = 3;
        static final int INT_EACH_SECT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("continuous", 1), new Enum("eachSect", 2), new Enum("eachPage", 3)});

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
        SimpleTypeFactory<STRestartNumber> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "strestartnumber11aatype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        CONTINUOUS = Enum.forString("continuous");
        EACH_SECT = Enum.forString("eachSect");
        EACH_PAGE = Enum.forString("eachPage");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
