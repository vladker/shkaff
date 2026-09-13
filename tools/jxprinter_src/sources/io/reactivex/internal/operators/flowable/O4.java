package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O4 extends p094q3.c implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -8134157938864266736L;
    public t5.d c;

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        e(this.b);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.b = null;
        this.f7842a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        Collection collection = (Collection) this.b;
        if (collection != null) {
            collection.add(obj);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
