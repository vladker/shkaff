package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STCryptProv extends XmlString {
    public static final Enum CUSTOM;
    public static final SimpleTypeFactory<STCryptProv> Factory;
    public static final int INT_CUSTOM = 3;
    public static final int INT_RSA_AES = 1;
    public static final int INT_RSA_FULL = 2;
    public static final Enum RSA_AES;
    public static final Enum RSA_FULL;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CUSTOM = 3;
        static final int INT_RSA_AES = 1;
        static final int INT_RSA_FULL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rsaAES", 1), new Enum("rsaFull", 2), new Enum("custom", 3)});

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
        SimpleTypeFactory<STCryptProv> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stcryptprov36a7type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        RSA_AES = Enum.forString("rsaAES");
        RSA_FULL = Enum.forString("rsaFull");
        CUSTOM = Enum.forString("custom");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
