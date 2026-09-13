package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STSectionMark extends XmlString {
    public static final Enum CONTINUOUS;
    public static final Enum EVEN_PAGE;
    public static final SimpleTypeFactory<STSectionMark> Factory;
    public static final int INT_CONTINUOUS = 3;
    public static final int INT_EVEN_PAGE = 4;
    public static final int INT_NEXT_COLUMN = 2;
    public static final int INT_NEXT_PAGE = 1;
    public static final int INT_ODD_PAGE = 5;
    public static final Enum NEXT_COLUMN;
    public static final Enum NEXT_PAGE;
    public static final Enum ODD_PAGE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUOUS = 3;
        static final int INT_EVEN_PAGE = 4;
        static final int INT_NEXT_COLUMN = 2;
        static final int INT_NEXT_PAGE = 1;
        static final int INT_ODD_PAGE = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("nextPage", 1), new Enum("nextColumn", 2), new Enum("continuous", 3), new Enum("evenPage", 4), new Enum("oddPage", 5)});

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
        SimpleTypeFactory<STSectionMark> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stsectionmark2010type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        NEXT_PAGE = Enum.forString("nextPage");
        NEXT_COLUMN = Enum.forString("nextColumn");
        CONTINUOUS = Enum.forString("continuous");
        EVEN_PAGE = Enum.forString("evenPage");
        ODD_PAGE = Enum.forString("oddPage");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
