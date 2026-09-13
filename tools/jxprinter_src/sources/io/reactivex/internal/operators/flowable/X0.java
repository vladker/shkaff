package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X0 extends p094q3.c implements InterfaceC0984q {
    private static final long serialVersionUID = 4066607327284737757L;
    public final long c;
    public final Object d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4506h;

    public X0(t5.c cVar, long j6, Object obj, boolean z6) {
        super(cVar);
        this.c = j6;
        this.d = obj;
        this.e = z6;
    }

    @Override // p094q3.c, t5.d
    public final void cancel() {
        super.cancel();
        this.f4504f.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4506h) {
            return;
        }
        this.f4506h = true;
        Object obj = this.d;
        if (obj != null) {
            e(obj);
            return;
        }
        boolean z6 = this.e;
        t5.c cVar = this.f7842a;
        if (z6) {
            cVar.onError(new NoSuchElementException());
        } else {
            cVar.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4506h) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4506h = true;
            this.f7842a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4506h) {
            return;
        }
        long j6 = this.f4505g;
        if (j6 != this.c) {
            this.f4505g = j6 + 1;
            return;
        }
        this.f4506h = true;
        this.f4504f.cancel();
        e(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4504f, dVar)) {
            this.f4504f = dVar;
            this.f7842a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
