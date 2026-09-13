package p120v0;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f8759a;

    public a(f fVar) {
        this.f8759a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        synchronized (this.f8759a) {
            try {
                f fVar = this.f8759a;
                if (fVar.f8770i == null) {
                    return null;
                }
                fVar.trimToSize();
                if (this.f8759a.a()) {
                    this.f8759a.rebuildJournal();
                    this.f8759a.f8772k = 0;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
