package com.microsoft.schemas.office.word;

import io.flutter.plugins.firebase.crashlytics.Constants;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class STVerticalAnchor$Enum extends StringEnumAbstractBase {
    static final int INT_LINE = 4;
    static final int INT_MARGIN = 1;
    static final int INT_PAGE = 2;
    static final int INT_TEXT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STVerticalAnchor$Enum[]{new STVerticalAnchor$Enum("margin", 1), new STVerticalAnchor$Enum("page", 2), new STVerticalAnchor$Enum("text", 3), new STVerticalAnchor$Enum(Constants.LINE, 4)});

    private STVerticalAnchor$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STVerticalAnchor$Enum forInt(int i5) {
        return (STVerticalAnchor$Enum) table.forInt(i5);
    }

    public static STVerticalAnchor$Enum forString(String str) {
        return (STVerticalAnchor$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
