package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STSortMethod$Enum extends StringEnumAbstractBase {
    static final int INT_NONE = 3;
    static final int INT_PIN_YIN = 2;
    static final int INT_STROKE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STSortMethod$Enum[]{new STSortMethod$Enum("stroke", 1), new STSortMethod$Enum("pinYin", 2), new STSortMethod$Enum("none", 3)});

    private STSortMethod$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STSortMethod$Enum forInt(int i5) {
        return (STSortMethod$Enum) table.forInt(i5);
    }

    public static STSortMethod$Enum forString(String str) {
        return (STSortMethod$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
