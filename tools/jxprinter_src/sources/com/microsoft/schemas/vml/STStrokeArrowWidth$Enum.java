package com.microsoft.schemas.vml;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class STStrokeArrowWidth$Enum extends StringEnumAbstractBase {
    static final int INT_MEDIUM = 2;
    static final int INT_NARROW = 1;
    static final int INT_WIDE = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STStrokeArrowWidth$Enum[]{new STStrokeArrowWidth$Enum("narrow", 1), new STStrokeArrowWidth$Enum(FirebaseAnalytics.Param.MEDIUM, 2), new STStrokeArrowWidth$Enum("wide", 3)});

    private STStrokeArrowWidth$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STStrokeArrowWidth$Enum forInt(int i5) {
        return (STStrokeArrowWidth$Enum) table.forInt(i5);
    }

    public static STStrokeArrowWidth$Enum forString(String str) {
        return (STStrokeArrowWidth$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
