package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = -2311252482644620661L;
    public final p027e3.q c;
    public t5.d d;
    public boolean e;

    public r(t5.c cVar, p027e3.q qVar) {
        super(cVar);
        this.c = qVar;
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.d.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        e(Boolean.FALSE);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.e) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.e = true;
            this.f7842a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.e) {
            return;
        }
        try {
            if (this.c.test(obj)) {
                this.e = true;
                this.d.cancel();
                e(Boolean.TRUE);
            }
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
