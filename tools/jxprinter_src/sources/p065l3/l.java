package p065l3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p039g3.A;
import p100r3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements InterfaceC0984q, c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C1160k f5856h = new C1160k(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5857a;
    public final o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f5859g;

    public l(InterfaceC0679f interfaceC0679f, o oVar, boolean z6) {
        this.f5857a = interfaceC0679f;
        this.b = oVar;
        this.c = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5859g.cancel();
        AtomicReference atomicReference = this.e;
        C1160k c1160k = f5856h;
        C1160k c1160k2 = (C1160k) atomicReference.getAndSet(c1160k);
        if (c1160k2 == null || c1160k2 == c1160k) {
            return;
        }
        p033f3.d.a(c1160k2);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.get() == f5856h;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f5858f = true;
        if (this.e.get() == null) {
            p100r3.c cVar = this.d;
            cVar.getClass();
            Throwable thB = g.b(cVar);
            if (thB == null) {
                this.f5857a.onComplete();
            } else {
                this.f5857a.onError(thB);
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.c) {
            onComplete();
            return;
        }
        AtomicReference atomicReference = this.e;
        C1160k c1160k = f5856h;
        C1160k c1160k2 = (C1160k) atomicReference.getAndSet(c1160k);
        if (c1160k2 != null && c1160k2 != c1160k) {
            p033f3.d.a(c1160k2);
        }
        Throwable thB = g.b(cVar);
        if (thB != g.f7961a) {
            this.f5857a.onError(thB);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            C1160k c1160k = new C1160k(this);
            while (true) {
                AtomicReference atomicReference = this.e;
                C1160k c1160k2 = (C1160k) atomicReference.get();
                if (c1160k2 == f5856h) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(c1160k2, c1160k)) {
                        if (c1160k2 != null) {
                            p033f3.d.a(c1160k2);
                        }
                        ((AbstractC0676c) interfaceC0682i).subscribe(c1160k);
                        return;
                    }
                } while (atomicReference.get() == c1160k2);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5859g.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.f5859g, dVar)) {
            this.f5859g = dVar;
            this.f5857a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
