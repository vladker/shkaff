package p112t3;

import io.reactivex.I;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f8660a = new AtomicReference();

    @Override // p011b3.c
    public final void dispose() {
        d.a(this.f8660a);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f8660a.get() == d.f3969a;
    }

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onError(Throwable th);

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        AtomicReference atomicReference;
        Class<?> cls = getClass();
        A.b(cVar, "next is null");
        do {
            atomicReference = this.f8660a;
            if (atomicReference.compareAndSet(null, cVar)) {
                return;
            }
        } while (atomicReference.get() == null);
        cVar.dispose();
        if (atomicReference.get() != d.f3969a) {
            p002a.d.b(cls);
        }
    }
}
