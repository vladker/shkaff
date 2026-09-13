package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STSortBy$Enum extends StringEnumAbstractBase {
    static final int INT_CELL_COLOR = 2;
    static final int INT_FONT_COLOR = 3;
    static final int INT_ICON = 4;
    static final int INT_VALUE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STSortBy$Enum[]{new STSortBy$Enum("value", 1), new STSortBy$Enum("cellColor", 2), new STSortBy$Enum("fontColor", 3), new STSortBy$Enum("icon", 4)});

    private STSortBy$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STSortBy$Enum forInt(int i5) {
        return (STSortBy$Enum) table.forInt(i5);
    }

    public static STSortBy$Enum forString(String str) {
        return (STSortBy$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
