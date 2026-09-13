package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STOleUpdate$Enum extends StringEnumAbstractBase {
    static final int INT_OLEUPDATE_ALWAYS = 1;
    static final int INT_OLEUPDATE_ONCALL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STOleUpdate$Enum[]{new STOleUpdate$Enum("OLEUPDATE_ALWAYS", 1), new STOleUpdate$Enum("OLEUPDATE_ONCALL", 2)});

    private STOleUpdate$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STOleUpdate$Enum forInt(int i5) {
        return (STOleUpdate$Enum) table.forInt(i5);
    }

    public static STOleUpdate$Enum forString(String str) {
        return (STOleUpdate$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
