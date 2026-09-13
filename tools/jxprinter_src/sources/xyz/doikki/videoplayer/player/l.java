package xyz.doikki.videoplayer.player;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class l {
    public static l b;
    public static k c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9009a;

    public static k a() {
        if (c == null) {
            synchronized (k.class) {
                try {
                    if (c == null) {
                        c = new k(new j());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static l b() {
        if (b == null) {
            synchronized (l.class) {
                try {
                    if (b == null) {
                        l lVar = new l();
                        new LinkedHashMap();
                        a().getClass();
                        lVar.f9009a = true;
                        b = lVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
