package com.microsoft.schemas.vml;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeArrowLength$Enum extends StringEnumAbstractBase {
    static final int INT_LONG = 3;
    static final int INT_MEDIUM = 2;
    static final int INT_SHORT = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeArrowLength$Enum[]{new STStrokeArrowLength$Enum("short", 1), new STStrokeArrowLength$Enum(FirebaseAnalytics.Param.MEDIUM, 2), new STStrokeArrowLength$Enum(XmlErrorCodes.LONG, 3)});

    private STStrokeArrowLength$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STStrokeArrowLength$Enum forInt(int i5) {
        return (STStrokeArrowLength$Enum) table.forInt(i5);
    }

    public static STStrokeArrowLength$Enum forString(String str) {
        return (STStrokeArrowLength$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
