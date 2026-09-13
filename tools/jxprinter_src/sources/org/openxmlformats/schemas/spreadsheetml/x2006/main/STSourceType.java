package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STSourceType extends XmlString {
    public static final Enum CONSOLIDATION;
    public static final Enum EXTERNAL;
    public static final SimpleTypeFactory<STSourceType> Factory;
    public static final int INT_CONSOLIDATION = 3;
    public static final int INT_EXTERNAL = 2;
    public static final int INT_SCENARIO = 4;
    public static final int INT_WORKSHEET = 1;
    public static final Enum SCENARIO;
    public static final Enum WORKSHEET;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONSOLIDATION = 3;
        static final int INT_EXTERNAL = 2;
        static final int INT_SCENARIO = 4;
        static final int INT_WORKSHEET = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("worksheet", 1), new Enum("external", 2), new Enum("consolidation", 3), new Enum("scenario", 4)});

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
        SimpleTypeFactory<STSourceType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stsourcetype074etype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        WORKSHEET = Enum.forString("worksheet");
        EXTERNAL = Enum.forString("external");
        CONSOLIDATION = Enum.forString("consolidation");
        SCENARIO = Enum.forString("scenario");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
