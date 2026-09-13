package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.l3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0753l3 extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = -4663883003264602070L;
    public final p027e3.c c;
    public t5.d d;

    public C0753l3(t5.c cVar, p027e3.c cVar2) {
        super(cVar);
        this.c = cVar2;
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.d.cancel();
        this.d = p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        t5.d dVar = this.d;
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar == gVar) {
            return;
        }
        this.d = gVar;
        Object obj = this.b;
        if (obj != null) {
            e(obj);
        } else {
            this.f7842a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        t5.d dVar = this.d;
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar == gVar) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.d = gVar;
            this.f7842a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d == p094q3.g.f7849a) {
            return;
        }
        Object obj2 = this.b;
        if (obj2 == null) {
            this.b = obj;
            return;
        }
        try {
            Object objApply = this.c.apply(obj2, obj);
            p039g3.A.b(objApply, "The reducer returned a null value");
            this.b = objApply;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.d.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.d, dVar)) {
            this.d = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
