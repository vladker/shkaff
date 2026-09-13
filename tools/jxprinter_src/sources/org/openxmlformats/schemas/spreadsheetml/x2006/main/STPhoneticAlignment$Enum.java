package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STPhoneticAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 3;
    static final int INT_DISTRIBUTED = 4;
    static final int INT_LEFT = 2;
    static final int INT_NO_CONTROL = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPhoneticAlignment$Enum[]{new STPhoneticAlignment$Enum("noControl", 1), new STPhoneticAlignment$Enum("left", 2), new STPhoneticAlignment$Enum("center", 3), new STPhoneticAlignment$Enum("distributed", 4)});

    private STPhoneticAlignment$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STPhoneticAlignment$Enum forInt(int i5) {
        return (STPhoneticAlignment$Enum) table.forInt(i5);
    }

    public static STPhoneticAlignment$Enum forString(String str) {
        return (STPhoneticAlignment$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
