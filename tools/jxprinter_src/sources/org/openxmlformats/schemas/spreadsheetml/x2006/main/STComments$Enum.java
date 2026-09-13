package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STComments$Enum extends StringEnumAbstractBase {
    static final int INT_COMM_INDICATOR = 2;
    static final int INT_COMM_IND_AND_COMMENT = 3;
    static final int INT_COMM_NONE = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STComments$Enum[]{new STComments$Enum("commNone", 1), new STComments$Enum("commIndicator", 2), new STComments$Enum("commIndAndComment", 3)});

    private STComments$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STComments$Enum forInt(int i5) {
        return (STComments$Enum) table.forInt(i5);
    }

    public static STComments$Enum forString(String str) {
        return (STComments$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
