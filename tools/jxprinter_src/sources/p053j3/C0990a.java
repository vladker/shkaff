package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: j3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0990a implements InterfaceC0679f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5426a = 0;
    public final InterfaceC0679f b;
    public final b c;
    public final Serializable d;
    public Object e;

    public C0990a(InterfaceC0679f interfaceC0679f, b bVar, c cVar, AtomicInteger atomicInteger) {
        this.b = interfaceC0679f;
        this.c = bVar;
        this.d = cVar;
        this.e = atomicInteger;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5426a) {
            case 0:
                if (((AtomicBoolean) this.d).compareAndSet(false, true)) {
                    p011b3.c cVar = (p011b3.c) this.e;
                    b bVar = this.c;
                    bVar.delete(cVar);
                    bVar.dispose();
                    this.b.onComplete();
                }
                break;
            default:
                if (((AtomicInteger) this.e).decrementAndGet() == 0) {
                    Throwable thB = g.b((c) this.d);
                    InterfaceC0679f interfaceC0679f = this.b;
                    if (thB != null) {
                        interfaceC0679f.onError(thB);
                    } else {
                        interfaceC0679f.onComplete();
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        switch (this.f5426a) {
            case 0:
                if (!((AtomicBoolean) this.d).compareAndSet(false, true)) {
                    a.onError(th);
                } else {
                    p011b3.c cVar = (p011b3.c) this.e;
                    b bVar = this.c;
                    bVar.delete(cVar);
                    bVar.dispose();
                    this.b.onError(th);
                }
                break;
            default:
                c cVar2 = (c) this.d;
                if (!g.a(cVar2, th)) {
                    a.onError(th);
                } else if (((AtomicInteger) this.e).decrementAndGet() == 0) {
                    Throwable thB = g.b(cVar2);
                    InterfaceC0679f interfaceC0679f = this.b;
                    if (thB != null) {
                        interfaceC0679f.onError(thB);
                    } else {
                        interfaceC0679f.onComplete();
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5426a) {
            case 0:
                this.e = cVar;
                this.c.add(cVar);
                break;
            default:
                this.c.add(cVar);
                break;
        }
    }

    public C0990a(b bVar, InterfaceC0679f interfaceC0679f, AtomicBoolean atomicBoolean) {
        this.d = atomicBoolean;
        this.c = bVar;
        this.b = interfaceC0679f;
    }
}
