package p006a3;

import android.os.Handler;
import io.reactivex.plugins.a;
import p011b3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f938a;
    public final Runnable b;
    public volatile boolean c;

    public e(Handler handler, Runnable runnable) {
        this.f938a = handler;
        this.b = runnable;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f938a.removeCallbacks(this);
        this.c = true;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.run();
        } catch (Throwable th) {
            a.onError(th);
        }
    }
}
