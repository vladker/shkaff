package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STPaneState extends XmlString {
    public static final Enum FROZEN;
    public static final Enum FROZEN_SPLIT;
    public static final SimpleTypeFactory<STPaneState> Factory;
    public static final int INT_FROZEN = 2;
    public static final int INT_FROZEN_SPLIT = 3;
    public static final int INT_SPLIT = 1;
    public static final Enum SPLIT;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FROZEN = 2;
        static final int INT_FROZEN_SPLIT = 3;
        static final int INT_SPLIT = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("split", 1), new Enum("frozen", 2), new Enum("frozenSplit", 3)});

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
        SimpleTypeFactory<STPaneState> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpanestateae58type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        SPLIT = Enum.forString("split");
        FROZEN = Enum.forString("frozen");
        FROZEN_SPLIT = Enum.forString("frozenSplit");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
