package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class STChapterSep$Enum extends StringEnumAbstractBase {
    static final int INT_COLON = 3;
    static final int INT_EM_DASH = 4;
    static final int INT_EN_DASH = 5;
    static final int INT_HYPHEN = 1;
    static final int INT_PERIOD = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STChapterSep$Enum[]{new STChapterSep$Enum("hyphen", 1), new STChapterSep$Enum(TypedValues.CycleType.S_WAVE_PERIOD, 2), new STChapterSep$Enum("colon", 3), new STChapterSep$Enum("emDash", 4), new STChapterSep$Enum("enDash", 5)});

    private STChapterSep$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STChapterSep$Enum forInt(int i5) {
        return (STChapterSep$Enum) table.forInt(i5);
    }

    public static STChapterSep$Enum forString(String str) {
        return (STChapterSep$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
