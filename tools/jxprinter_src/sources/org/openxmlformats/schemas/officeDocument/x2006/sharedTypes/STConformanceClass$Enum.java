package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class STConformanceClass$Enum extends StringEnumAbstractBase {
    static final int INT_STRICT = 1;
    static final int INT_TRANSITIONAL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STConformanceClass$Enum[]{new STConformanceClass$Enum("strict", 1), new STConformanceClass$Enum("transitional", 2)});

    private STConformanceClass$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STConformanceClass$Enum forInt(int i5) {
        return (STConformanceClass$Enum) table.forInt(i5);
    }

    public static STConformanceClass$Enum forString(String str) {
        return (STConformanceClass$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
