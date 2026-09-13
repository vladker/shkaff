package com.microsoft.schemas.office.excel;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STObjectType extends XmlString {
    public static final Enum BUTTON;
    public static final Enum CHECKBOX;
    public static final Enum DIALOG;
    public static final Enum DROP;
    public static final Enum EDIT;
    public static final SimpleTypeFactory<STObjectType> Factory;
    public static final Enum GROUP;
    public static final Enum G_BOX;
    public static final int INT_BUTTON = 1;
    public static final int INT_CHECKBOX = 2;
    public static final int INT_DIALOG = 3;
    public static final int INT_DROP = 4;
    public static final int INT_EDIT = 5;
    public static final int INT_GROUP = 18;
    public static final int INT_G_BOX = 6;
    public static final int INT_LABEL = 7;
    public static final int INT_LINE_A = 8;
    public static final int INT_LIST = 9;
    public static final int INT_MOVIE = 10;
    public static final int INT_NOTE = 11;
    public static final int INT_PICT = 12;
    public static final int INT_RADIO = 13;
    public static final int INT_RECT = 19;
    public static final int INT_RECT_A = 14;
    public static final int INT_SCROLL = 15;
    public static final int INT_SHAPE = 17;
    public static final int INT_SPIN = 16;
    public static final Enum LABEL;
    public static final Enum LINE_A;
    public static final Enum LIST;
    public static final Enum MOVIE;
    public static final Enum NOTE;
    public static final Enum PICT;
    public static final Enum RADIO;
    public static final Enum RECT;
    public static final Enum RECT_A;
    public static final Enum SCROLL;
    public static final Enum SHAPE;
    public static final Enum SPIN;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BUTTON = 1;
        static final int INT_CHECKBOX = 2;
        static final int INT_DIALOG = 3;
        static final int INT_DROP = 4;
        static final int INT_EDIT = 5;
        static final int INT_GROUP = 18;
        static final int INT_G_BOX = 6;
        static final int INT_LABEL = 7;
        static final int INT_LINE_A = 8;
        static final int INT_LIST = 9;
        static final int INT_MOVIE = 10;
        static final int INT_NOTE = 11;
        static final int INT_PICT = 12;
        static final int INT_RADIO = 13;
        static final int INT_RECT = 19;
        static final int INT_RECT_A = 14;
        static final int INT_SCROLL = 15;
        static final int INT_SHAPE = 17;
        static final int INT_SPIN = 16;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("Button", 1), new Enum("Checkbox", 2), new Enum("Dialog", 3), new Enum("Drop", 4), new Enum("Edit", 5), new Enum("GBox", 6), new Enum("Label", 7), new Enum("LineA", 8), new Enum("List", 9), new Enum("Movie", 10), new Enum("Note", 11), new Enum("Pict", 12), new Enum("Radio", 13), new Enum("RectA", 14), new Enum("Scroll", 15), new Enum("Spin", 16), new Enum("Shape", 17), new Enum("Group", 18), new Enum("Rect", 19)});

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
        SimpleTypeFactory<STObjectType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stobjecttype97a7type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        BUTTON = Enum.forString("Button");
        CHECKBOX = Enum.forString("Checkbox");
        DIALOG = Enum.forString("Dialog");
        DROP = Enum.forString("Drop");
        EDIT = Enum.forString("Edit");
        G_BOX = Enum.forString("GBox");
        LABEL = Enum.forString("Label");
        LINE_A = Enum.forString("LineA");
        LIST = Enum.forString("List");
        MOVIE = Enum.forString("Movie");
        NOTE = Enum.forString("Note");
        PICT = Enum.forString("Pict");
        RADIO = Enum.forString("Radio");
        RECT_A = Enum.forString("RectA");
        SCROLL = Enum.forString("Scroll");
        SPIN = Enum.forString("Spin");
        SHAPE = Enum.forString("Shape");
        GROUP = Enum.forString("Group");
        RECT = Enum.forString("Rect");
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
