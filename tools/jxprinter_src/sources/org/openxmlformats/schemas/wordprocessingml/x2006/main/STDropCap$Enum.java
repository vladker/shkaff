package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STDropCap$Enum extends StringEnumAbstractBase {
    static final int INT_DROP = 2;
    static final int INT_MARGIN = 3;
    static final int INT_NONE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDropCap$Enum[]{new STDropCap$Enum("none", 1), new STDropCap$Enum("drop", 2), new STDropCap$Enum("margin", 3)});

    private STDropCap$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STDropCap$Enum forInt(int i5) {
        return (STDropCap$Enum) table.forInt(i5);
    }

    public static STDropCap$Enum forString(String str) {
        return (STDropCap$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
