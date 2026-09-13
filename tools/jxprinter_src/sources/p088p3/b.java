package p088p3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import p043h3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements InterfaceC0984q, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7736a;
    public d b;
    public g c;
    public boolean d;
    public int e;

    public b(c cVar) {
        this.f7736a = cVar;
    }

    public final void a(Throwable th) {
        p017c3.d.throwIfFatal(th);
        this.b.cancel();
        onError(th);
    }

    @Override // p043h3.f
    public int c(int i5) {
        g gVar = this.c;
        if (gVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iC = gVar.c(i5);
        if (iC == 0) {
            return iC;
        }
        this.e = iC;
        return iC;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
    }

    public void clear() {
        this.c.clear();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // t5.c
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f7736a.onComplete();
    }

    @Override // t5.c
    public void onError(Throwable th) {
        if (this.d) {
            a.onError(th);
        } else {
            this.d = true;
            this.f7736a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            if (dVar instanceof g) {
                this.c = (g) dVar;
            }
            this.f7736a.onSubscribe(this);
        }
    }

    public abstract /* synthetic */ Object poll();

    @Override // t5.d
    public final void request(long j6) {
        this.b.request(j6);
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
