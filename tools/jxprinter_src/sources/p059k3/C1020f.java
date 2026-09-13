package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.h;
import p094q3.g;
import p100r3.n;
import p122v2.a;
import t5.c;
import t5.d;

/* JADX INFO: renamed from: k3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1020f extends AtomicInteger implements InterfaceC0988v, d {
    private static final long serialVersionUID = 3520831347801429610L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f5547a;
    public final y[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f5548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5549g;
    public final AtomicLong b = new AtomicLong();
    public final h d = new h();
    public final AtomicReference c = new AtomicReference(n.f7968a);

    public C1020f(c cVar, y[] yVarArr) {
        this.f5547a = cVar;
        this.e = yVarArr;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        do {
            h hVar = this.d;
            boolean zE = hVar.e();
            AtomicReference atomicReference = this.c;
            if (zE) {
                atomicReference.lazySet(null);
                return;
            }
            Object obj = atomicReference.get();
            if (obj != null) {
                n nVar = n.f7968a;
                c cVar = this.f5547a;
                if (obj != nVar) {
                    long j6 = this.f5549g;
                    if (j6 != this.b.get()) {
                        this.f5549g = j6 + 1;
                        atomicReference.lazySet(null);
                        cVar.onNext(obj);
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!hVar.e()) {
                    int i5 = this.f5548f;
                    y[] yVarArr = this.e;
                    if (i5 == yVarArr.length) {
                        cVar.onComplete();
                        return;
                    } else {
                        this.f5548f = i5 + 1;
                        ((AbstractC0985s) yVarArr[i5]).subscribe(this);
                    }
                }
            }
        } while (decrementAndGet() != 0);
    }

    @Override // t5.d
    public final void cancel() {
        h hVar = this.d;
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.c.lazySet(n.f7968a);
        a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5547a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        h hVar = this.d;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.c.lazySet(obj);
        a();
    }

    @Override // t5.d
    public final void request(long j6) {
        if (g.f(j6)) {
            a.a(this.b, j6);
            a();
        }
    }
}
