package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.plugins.a;
import p017c3.d;
import p027e3.c;
import p039g3.A;
import p088p3.f;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends f {
    private static final long serialVersionUID = 8200530050639449080L;
    public final c d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6158f;

    public t(t5.c cVar, Object obj, c cVar2) {
        super(cVar);
        this.e = obj;
        this.d = cVar2;
    }

    @Override // p088p3.f, p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f6158f) {
            return;
        }
        this.f6158f = true;
        Object obj = this.e;
        this.e = null;
        e(obj);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f6158f) {
            a.onError(th);
            return;
        }
        this.f6158f = true;
        this.e = null;
        this.f7842a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f6158f) {
            return;
        }
        try {
            Object objApply = this.d.apply(this.e, obj);
            A.b(objApply, "The reducer returned a null value");
            this.e = objApply;
        } catch (Throwable th) {
            d.throwIfFatal(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (g.g(this.c, dVar)) {
            this.c = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
