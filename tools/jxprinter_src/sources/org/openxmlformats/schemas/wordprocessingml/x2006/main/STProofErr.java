package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STProofErr extends XmlString {
    public static final SimpleTypeFactory<STProofErr> Factory;
    public static final Enum GRAM_END;
    public static final Enum GRAM_START;
    public static final int INT_GRAM_END = 4;
    public static final int INT_GRAM_START = 3;
    public static final int INT_SPELL_END = 2;
    public static final int INT_SPELL_START = 1;
    public static final Enum SPELL_END;
    public static final Enum SPELL_START;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_GRAM_END = 4;
        static final int INT_GRAM_START = 3;
        static final int INT_SPELL_END = 2;
        static final int INT_SPELL_START = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("spellStart", 1), new Enum("spellEnd", 2), new Enum("gramStart", 3), new Enum("gramEnd", 4)});

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
        SimpleTypeFactory<STProofErr> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stprooferr6bf7type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SPELL_START = Enum.forString("spellStart");
        SPELL_END = Enum.forString("spellEnd");
        GRAM_START = Enum.forString("gramStart");
        GRAM_END = Enum.forString("gramEnd");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
