package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s6) {
        return Half.valueOf(s6);
    }

    @RequiresApi(26)
    public static final Half toHalf(float f6) {
        return Half.valueOf(f6);
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        return Half.valueOf((float) d);
    }
}
