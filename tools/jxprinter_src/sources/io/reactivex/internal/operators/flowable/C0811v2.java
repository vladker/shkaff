package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.v2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0811v2 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4809a = 1;
    public final io.reactivex.S b;
    public Object c;
    public t5.d d;
    public Object e;

    public C0811v2(io.reactivex.S s6, Object obj) {
        this.b = s6;
        this.c = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4809a) {
            case 0:
                this.d.cancel();
                this.d = p094q3.g.f7849a;
                break;
            default:
                this.d.cancel();
                this.d = p094q3.g.f7849a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4809a) {
            case 0:
                return this.d == p094q3.g.f7849a;
            default:
                return this.d == p094q3.g.f7849a;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4809a) {
            case 0:
                this.d = p094q3.g.f7849a;
                Object obj = this.e;
                io.reactivex.S s6 = this.b;
                if (obj == null) {
                    Object obj2 = this.c;
                    if (obj2 == null) {
                        s6.onError(new NoSuchElementException());
                    } else {
                        s6.onSuccess(obj2);
                    }
                } else {
                    this.e = null;
                    s6.onSuccess(obj);
                }
                break;
            default:
                Object obj3 = this.c;
                if (obj3 != null) {
                    this.c = null;
                    this.d = p094q3.g.f7849a;
                    this.b.onSuccess(obj3);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4809a) {
            case 0:
                this.d = p094q3.g.f7849a;
                this.e = null;
                this.b.onError(th);
                break;
            default:
                if (this.c == null) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.c = null;
                    this.d = p094q3.g.f7849a;
                    this.b.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4809a) {
            case 0:
                this.e = obj;
                break;
            default:
                Object obj2 = this.c;
                if (obj2 != null) {
                    try {
                        Object objApply = ((p027e3.c) this.e).apply(obj2, obj);
                        p039g3.A.b(objApply, "The reducer returned a null value");
                        this.c = objApply;
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.d.cancel();
                        onError(th);
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4809a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            default:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    public C0811v2(io.reactivex.S s6, p027e3.c cVar, Object obj) {
        this.b = s6;
        this.c = obj;
        this.e = cVar;
    }
}
