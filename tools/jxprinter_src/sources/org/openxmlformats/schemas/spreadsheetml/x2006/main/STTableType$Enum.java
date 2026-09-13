package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STTableType$Enum extends StringEnumAbstractBase {
    static final int INT_QUERY_TABLE = 3;
    static final int INT_WORKSHEET = 1;
    static final int INT_XML = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTableType$Enum[]{new STTableType$Enum("worksheet", 1), new STTableType$Enum("xml", 2), new STTableType$Enum("queryTable", 3)});

    private STTableType$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STTableType$Enum forInt(int i5) {
        return (STTableType$Enum) table.forInt(i5);
    }

    public static STTableType$Enum forString(String str) {
        return (STTableType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
