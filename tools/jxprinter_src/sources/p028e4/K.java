package p028e4;

import X3.V;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class K {
    public static final boolean systemProp(String str, boolean z6) {
        String strSystemProp = I.systemProp(str);
        return strSystemProp != null ? Boolean.parseBoolean(strSystemProp) : z6;
    }

    public static final int systemProp(String str, int i5, int i6, int i7) {
        return (int) I.systemProp(str, i5, i6, i7);
    }

    public static final long systemProp(String str, long j6, long j7, long j8) {
        String strSystemProp = I.systemProp(str);
        if (strSystemProp == null) {
            return j6;
        }
        Long longOrNull = V.toLongOrNull(strSystemProp);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strSystemProp + Chars.QUOTE).toString());
        }
        long jLongValue = longOrNull.longValue();
        if (j7 <= jLongValue && jLongValue <= j8) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j7 + ".." + j8 + ", but is '" + jLongValue + Chars.QUOTE).toString());
    }

    public static final String systemProp(String str, String str2) {
        String strSystemProp = I.systemProp(str);
        return strSystemProp == null ? str2 : strSystemProp;
    }
}
