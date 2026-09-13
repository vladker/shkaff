package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STFieldSortType$Enum extends StringEnumAbstractBase {
    static final int INT_ASCENDING = 2;
    static final int INT_DESCENDING = 3;
    static final int INT_MANUAL = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STFieldSortType$Enum[]{new STFieldSortType$Enum("manual", 1), new STFieldSortType$Enum("ascending", 2), new STFieldSortType$Enum("descending", 3)});

    private STFieldSortType$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STFieldSortType$Enum forInt(int i5) {
        return (STFieldSortType$Enum) table.forInt(i5);
    }

    public static STFieldSortType$Enum forString(String str) {
        return (STFieldSortType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
