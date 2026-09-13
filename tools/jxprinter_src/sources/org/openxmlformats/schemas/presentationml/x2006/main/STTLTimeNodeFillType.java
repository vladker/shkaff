package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STTLTimeNodeFillType extends XmlToken {
    public static final Enum FREEZE;
    public static final SimpleTypeFactory<STTLTimeNodeFillType> Factory;
    public static final Enum HOLD;
    public static final int INT_FREEZE = 2;
    public static final int INT_HOLD = 3;
    public static final int INT_REMOVE = 1;
    public static final int INT_TRANSITION = 4;
    public static final Enum REMOVE;
    public static final Enum TRANSITION;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FREEZE = 2;
        static final int INT_HOLD = 3;
        static final int INT_REMOVE = 1;
        static final int INT_TRANSITION = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("remove", 1), new Enum("freeze", 2), new Enum("hold", 3), new Enum("transition", 4)});

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
        SimpleTypeFactory<STTLTimeNodeFillType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "sttltimenodefilltypeb7f1type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        REMOVE = Enum.forString("remove");
        FREEZE = Enum.forString("freeze");
        HOLD = Enum.forString("hold");
        TRANSITION = Enum.forString("transition");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
