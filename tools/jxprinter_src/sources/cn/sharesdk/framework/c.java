package cn.sharesdk.framework;

import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile c b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2185a = false;

    private c() {
        new Thread() { // from class: cn.sharesdk.framework.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    c.this.f2185a = MobSDK.isForb();
                } catch (Throwable th) {
                    SSDKLog.b().b(th);
                }
            }
        }.start();
    }

    public static c a() {
        synchronized (c.class) {
            try {
                if (b == null) {
                    synchronized (c.class) {
                        try {
                            if (b == null) {
                                b = new c();
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
        return b;
    }
}
