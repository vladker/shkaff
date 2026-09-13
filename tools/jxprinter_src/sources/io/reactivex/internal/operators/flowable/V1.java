package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V1 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4482a;
    public final Object b;
    public t5.d c;

    public /* synthetic */ V1(Object obj, int i5) {
        this.f4482a = i5;
        this.b = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4482a) {
            case 0:
                this.c.cancel();
                this.c = p094q3.g.f7849a;
                break;
            case 1:
                this.c.cancel();
                this.c = p094q3.g.f7849a;
                break;
            default:
                this.c.cancel();
                this.c = p094q3.g.f7849a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4482a) {
            case 0:
                return this.c == p094q3.g.f7849a;
            case 1:
                return this.c == p094q3.g.f7849a;
            default:
                return this.c == p094q3.g.f7849a;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4482a) {
            case 0:
                this.c = p094q3.g.f7849a;
                ((InterfaceC0679f) this.b).onComplete();
                break;
            case 1:
                ((InterfaceC0679f) this.b).onComplete();
                break;
            default:
                ((io.reactivex.I) this.b).onComplete();
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4482a) {
            case 0:
                this.c = p094q3.g.f7849a;
                ((InterfaceC0679f) this.b).onError(th);
                break;
            case 1:
                ((InterfaceC0679f) this.b).onError(th);
                break;
            default:
                ((io.reactivex.I) this.b).onError(th);
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4482a) {
            case 0:
            case 1:
                break;
            default:
                ((io.reactivex.I) this.b).onNext(obj);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4482a) {
            case 0:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((InterfaceC0679f) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            case 1:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((InterfaceC0679f) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            default:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((io.reactivex.I) this.b).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    private final void a(Object obj) {
    }

    private final void b(Object obj) {
    }
}
