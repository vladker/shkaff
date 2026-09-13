package com.microsoft.schemas.office.word;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class STWrapSide$Enum extends StringEnumAbstractBase {
    static final int INT_BOTH = 1;
    static final int INT_LARGEST = 4;
    static final int INT_LEFT = 2;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STWrapSide$Enum[]{new STWrapSide$Enum("both", 1), new STWrapSide$Enum("left", 2), new STWrapSide$Enum("right", 3), new STWrapSide$Enum("largest", 4)});

    private STWrapSide$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STWrapSide$Enum forInt(int i5) {
        return (STWrapSide$Enum) table.forInt(i5);
    }

    public static STWrapSide$Enum forString(String str) {
        return (STWrapSide$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
