package C1;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {
    public static void loadLibrary(Context context, String str) {
        loadLibrary(context, str, null, null);
    }

    public static i log(g gVar) {
        return new i().log(gVar);
    }

    public static void loadLibrary(Context context, String str, String str2) {
        loadLibrary(context, str, str2, null);
    }

    public static void loadLibrary(Context context, String str, f fVar) {
        loadLibrary(context, str, null, fVar);
    }

    public static void loadLibrary(Context context, String str, String str2, f fVar) {
        new i().loadLibrary(context, str, str2, fVar);
    }
}
