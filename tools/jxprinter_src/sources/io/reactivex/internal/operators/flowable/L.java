package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = -3589550218733891694L;
    public final p027e3.b c;
    public final Object d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4332f;

    public L(t5.c cVar, Object obj, p027e3.b bVar) {
        super(cVar);
        this.c = bVar;
        this.d = obj;
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.e.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4332f) {
            return;
        }
        this.f4332f = true;
        e(this.d);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4332f) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4332f = true;
            this.f7842a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4332f) {
            return;
        }
        try {
            this.c.accept(this.d, obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.e.cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
