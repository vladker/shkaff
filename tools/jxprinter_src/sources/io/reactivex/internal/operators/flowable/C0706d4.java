package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.d4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0706d4 extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = -5526049321428043809L;
    public final Object c;
    public final boolean d;
    public t5.d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4594f;

    public C0706d4(t5.c cVar, Object obj, boolean z6) {
        super(cVar);
        this.c = obj;
        this.d = z6;
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.e.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4594f) {
            return;
        }
        this.f4594f = true;
        Object obj = this.b;
        this.b = null;
        if (obj == null) {
            obj = this.c;
        }
        if (obj != null) {
            e(obj);
            return;
        }
        boolean z6 = this.d;
        t5.c cVar = this.f7842a;
        if (z6) {
            cVar.onError(new NoSuchElementException());
        } else {
            cVar.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4594f) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4594f = true;
            this.f7842a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4594f) {
            return;
        }
        if (this.b == null) {
            this.b = obj;
            return;
        }
        this.f4594f = true;
        this.e.cancel();
        this.f7842a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
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
