package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorWindowCompat {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CursorWindow createCursorWindow(String str, long j6) {
            return new CursorWindow(str, j6);
        }
    }

    private CursorWindowCompat() {
    }

    public static CursorWindow create(String str, long j6) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j6) : new CursorWindow(str);
    }
}
