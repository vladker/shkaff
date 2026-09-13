package io.reactivex.internal.operators.observable;

import java.util.Collection;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0919q0 extends p048i3.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Collection f5258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.o f5259g;

    public C0919q0(io.reactivex.I i5, p027e3.o oVar, Collection collection) {
        super(i5);
        this.f5259g = oVar;
        this.f5258f = collection;
    }

    @Override // p048i3.a, p043h3.j
    public final void clear() {
        this.f5258f.clear();
        super.clear();
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f5258f.clear();
        this.f4046a.onComplete();
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.d = true;
        this.f5258f.clear();
        this.f4046a.onError(th);
    }

    @Override // p048i3.a, io.reactivex.I
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        int i5 = this.e;
        io.reactivex.I i6 = this.f4046a;
        if (i5 != 0) {
            i6.onNext(null);
            return;
        }
        try {
            Object objApply = this.f5259g.apply(obj);
            p039g3.A.b(objApply, "The keySelector returned a null key");
            if (this.f5258f.add(objApply)) {
                i6.onNext(obj);
            }
        } catch (Throwable th) {
            a(th);
        }
    }

    @Override // p048i3.a, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll;
        Object objApply;
        do {
            objPoll = this.c.poll();
            if (objPoll == null) {
                break;
            }
            objApply = this.f5259g.apply(objPoll);
            p039g3.A.b(objApply, "The keySelector returned a null key");
        } while (!this.f5258f.add(objApply));
        return objPoll;
    }
}
