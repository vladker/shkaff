package io.reactivex.internal.schedulers;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends AbstractC0962a implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    @Override // java.lang.Runnable
    public final void run() {
        this.b = Thread.currentThread();
        try {
            this.f5345a.run();
            this.b = null;
        } catch (Throwable th) {
            this.b = null;
            lazySet(AbstractC0962a.c);
            io.reactivex.plugins.a.onError(th);
        }
    }
}
