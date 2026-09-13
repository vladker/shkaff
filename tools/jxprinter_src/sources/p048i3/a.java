package p048i3;

import io.reactivex.I;
import p011b3.c;
import p017c3.d;
import p043h3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements I, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f4046a;
    public c b;
    public e c;
    public boolean d;
    public int e;

    public a(I i5) {
        this.f4046a = i5;
    }

    public final void a(Throwable th) {
        d.throwIfFatal(th);
        this.b.dispose();
        onError(th);
    }

    @Override // p043h3.f
    public int c(int i5) {
        e eVar = this.c;
        if (eVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iC = eVar.c(i5);
        if (iC == 0) {
            return iC;
        }
        this.e = iC;
        return iC;
    }

    @Override // p043h3.j
    public void clear() {
        this.c.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.I
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f4046a.onComplete();
    }

    @Override // io.reactivex.I
    public void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.d = true;
            this.f4046a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (p033f3.d.g(this.b, cVar)) {
            this.b = cVar;
            if (cVar instanceof e) {
                this.c = (e) cVar;
            }
            this.f4046a.onSubscribe(this);
        }
    }

    @Override // p043h3.e, p043h3.f, p043h3.j
    public abstract /* synthetic */ Object poll();

    @Override // p043h3.e, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
