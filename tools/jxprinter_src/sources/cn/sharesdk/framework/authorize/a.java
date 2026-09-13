package cn.sharesdk.framework.authorize;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f2181a;
    private Activity b;
    private boolean c;

    public static a c() {
        synchronized (a.class) {
            try {
                if (f2181a == null) {
                    synchronized (a.class) {
                        try {
                            if (f2181a == null) {
                                f2181a = new a();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f2181a;
    }

    public boolean a() {
        return this.c;
    }

    public Activity b() {
        return this.b;
    }

    public void a(boolean z6) {
        this.c = z6;
    }

    public void a(Activity activity) {
        this.b = activity;
    }
}
