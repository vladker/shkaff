package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STPageBorderDisplay extends XmlString {
    public static final Enum ALL_PAGES;
    public static final Enum FIRST_PAGE;
    public static final SimpleTypeFactory<STPageBorderDisplay> Factory;
    public static final int INT_ALL_PAGES = 1;
    public static final int INT_FIRST_PAGE = 2;
    public static final int INT_NOT_FIRST_PAGE = 3;
    public static final Enum NOT_FIRST_PAGE;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL_PAGES = 1;
        static final int INT_FIRST_PAGE = 2;
        static final int INT_NOT_FIRST_PAGE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("allPages", 1), new Enum("firstPage", 2), new Enum("notFirstPage", 3)});

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
        SimpleTypeFactory<STPageBorderDisplay> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpageborderdisplay731btype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        ALL_PAGES = Enum.forString("allPages");
        FIRST_PAGE = Enum.forString("firstPage");
        NOT_FIRST_PAGE = Enum.forString("notFirstPage");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
