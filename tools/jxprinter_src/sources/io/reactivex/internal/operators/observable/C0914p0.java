package io.reactivex.internal.operators.observable;

import io.reactivex.InterfaceC0679f;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0914p0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5251a;
    public Object b;
    public p011b3.c c;

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5251a) {
            case 0:
                p011b3.c cVar = this.c;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                cVar.dispose();
                break;
            case 1:
                this.c.dispose();
                break;
            case 2:
                this.c.dispose();
                break;
            case 3:
                this.c.dispose();
                break;
            default:
                this.c.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5251a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this.c.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5251a) {
            case 0:
                io.reactivex.I i5 = (io.reactivex.I) this.b;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                i5.onComplete();
                break;
            case 1:
                ((io.reactivex.I) this.b).onComplete();
                break;
            case 2:
                ((io.reactivex.I) this.b).onComplete();
                break;
            case 3:
                io.reactivex.A aCreateOnComplete = io.reactivex.A.createOnComplete();
                io.reactivex.I i6 = (io.reactivex.I) this.b;
                i6.onNext(aCreateOnComplete);
                i6.onComplete();
                break;
            default:
                ((InterfaceC0679f) this.b).onComplete();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5251a) {
            case 0:
                io.reactivex.I i5 = (io.reactivex.I) this.b;
                p100r3.e eVar = p100r3.e.f7960a;
                this.c = eVar;
                this.b = eVar;
                i5.onError(th);
                break;
            case 1:
                ((io.reactivex.I) this.b).onError(th);
                break;
            case 2:
                ((io.reactivex.I) this.b).onError(th);
                break;
            case 3:
                io.reactivex.A aCreateOnError = io.reactivex.A.createOnError(th);
                io.reactivex.I i6 = (io.reactivex.I) this.b;
                i6.onNext(aCreateOnError);
                i6.onComplete();
                break;
            default:
                ((InterfaceC0679f) this.b).onError(th);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5251a) {
            case 0:
                ((io.reactivex.I) this.b).onNext(obj);
                break;
            case 1:
                ((io.reactivex.I) this.b).onNext(obj);
                break;
            case 3:
                ((io.reactivex.I) this.b).onNext(io.reactivex.A.createOnNext(obj));
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5251a) {
            case 0:
                if (p033f3.d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                }
                break;
            case 2:
                this.c = cVar;
                ((io.reactivex.I) this.b).onSubscribe(this);
                break;
            case 3:
                if (p033f3.d.g(this.c, cVar)) {
                    this.c = cVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                }
                break;
            default:
                this.c = cVar;
                ((InterfaceC0679f) this.b).onSubscribe(this);
                break;
        }
    }

    public /* synthetic */ C0914p0(Object obj, int i5) {
        this.f5251a = i5;
        this.b = obj;
    }

    private final void a(Object obj) {
    }

    private final void b(Object obj) {
    }
}
