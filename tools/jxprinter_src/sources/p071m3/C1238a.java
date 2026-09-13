package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.plugins.a;
import p017c3.d;
import p027e3.b;
import p088p3.f;
import p094q3.g;
import t5.c;

/* JADX INFO: renamed from: m3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1238a extends f {
    private static final long serialVersionUID = -4767392946044436228L;
    public final b d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6126f;

    public C1238a(c cVar, Object obj, b bVar) {
        super(cVar);
        this.e = obj;
        this.d = bVar;
    }

    @Override // p088p3.f, p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.c.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f6126f) {
            return;
        }
        this.f6126f = true;
        Object obj = this.e;
        this.e = null;
        e(obj);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f6126f) {
            a.onError(th);
            return;
        }
        this.f6126f = true;
        this.e = null;
        this.f7842a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f6126f) {
            return;
        }
        try {
            this.d.accept(this.e, obj);
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
