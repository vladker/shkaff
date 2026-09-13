package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0691b1 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.S f4568a;
    public final long b;
    public final Object c;
    public t5.d d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4569f;

    public C0691b1(io.reactivex.S s6, long j6, Object obj) {
        this.f4568a = s6;
        this.b = j6;
        this.c = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.cancel();
        this.d = p094q3.g.f7849a;
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        this.d = p094q3.g.f7849a;
        if (this.f4569f) {
            return;
        }
        this.f4569f = true;
        io.reactivex.S s6 = this.f4568a;
        Object obj = this.c;
        if (obj != null) {
            s6.onSuccess(obj);
        } else {
            s6.onError(new NoSuchElementException());
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4569f) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f4569f = true;
        this.d = p094q3.g.f7849a;
        this.f4568a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4569f) {
            return;
        }
        long j6 = this.e;
        if (j6 != this.b) {
            this.e = j6 + 1;
            return;
        }
        this.f4569f = true;
        this.d.cancel();
        this.d = p094q3.g.f7849a;
        this.f4568a.onSuccess(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.d, dVar)) {
            this.d = dVar;
            this.f4568a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
