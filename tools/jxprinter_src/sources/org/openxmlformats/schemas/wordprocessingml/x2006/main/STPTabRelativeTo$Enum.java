package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STPTabRelativeTo$Enum extends StringEnumAbstractBase {
    static final int INT_INDENT = 2;
    static final int INT_MARGIN = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabRelativeTo$Enum[]{new STPTabRelativeTo$Enum("margin", 1), new STPTabRelativeTo$Enum("indent", 2)});

    private STPTabRelativeTo$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STPTabRelativeTo$Enum forInt(int i5) {
        return (STPTabRelativeTo$Enum) table.forInt(i5);
    }

    public static STPTabRelativeTo$Enum forString(String str) {
        return (STPTabRelativeTo$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
