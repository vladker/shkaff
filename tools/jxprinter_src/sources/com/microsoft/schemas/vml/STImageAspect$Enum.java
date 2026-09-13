package com.microsoft.schemas.vml;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class STImageAspect$Enum extends StringEnumAbstractBase {
    static final int INT_AT_LEAST = 3;
    static final int INT_AT_MOST = 2;
    static final int INT_IGNORE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STImageAspect$Enum[]{new STImageAspect$Enum("ignore", 1), new STImageAspect$Enum("atMost", 2), new STImageAspect$Enum("atLeast", 3)});

    private STImageAspect$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STImageAspect$Enum forInt(int i5) {
        return (STImageAspect$Enum) table.forInt(i5);
    }

    public static STImageAspect$Enum forString(String str) {
        return (STImageAspect$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
