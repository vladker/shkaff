package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class STAlignH$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 3;
    static final int INT_INSIDE = 4;
    static final int INT_LEFT = 1;
    static final int INT_OUTSIDE = 5;
    static final int INT_RIGHT = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STAlignH$Enum[]{new STAlignH$Enum("left", 1), new STAlignH$Enum("right", 2), new STAlignH$Enum("center", 3), new STAlignH$Enum("inside", 4), new STAlignH$Enum("outside", 5)});

    private STAlignH$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STAlignH$Enum forInt(int i5) {
        return (STAlignH$Enum) table.forInt(i5);
    }

    public static STAlignH$Enum forString(String str) {
        return (STAlignH$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
