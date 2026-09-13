package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STPTabAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_CENTER = 2;
    static final int INT_LEFT = 1;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPTabAlignment$Enum[]{new STPTabAlignment$Enum("left", 1), new STPTabAlignment$Enum("center", 2), new STPTabAlignment$Enum("right", 3)});

    private STPTabAlignment$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STPTabAlignment$Enum forInt(int i5) {
        return (STPTabAlignment$Enum) table.forInt(i5);
    }

    public static STPTabAlignment$Enum forString(String str) {
        return (STPTabAlignment$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
