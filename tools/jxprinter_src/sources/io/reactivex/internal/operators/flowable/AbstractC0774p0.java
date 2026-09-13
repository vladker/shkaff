package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0981n;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0774p0 extends AtomicLong implements InterfaceC0981n, t5.d {
    private static final long serialVersionUID = 7326289992464377023L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4725a;
    public final p033f3.h b = new p033f3.h();

    public AbstractC0774p0(t5.c cVar) {
        this.f4725a = cVar;
    }

    public final void a() {
        p033f3.h hVar = this.b;
        if (hVar.e()) {
            return;
        }
        try {
            this.f4725a.onComplete();
        } finally {
            hVar.getClass();
            p033f3.d.a(hVar);
        }
    }

    public final boolean b(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        p033f3.h hVar = this.b;
        if (hVar.e()) {
            return false;
        }
        try {
            this.f4725a.onError(th);
            return true;
        } finally {
            hVar.getClass();
            p033f3.d.a(hVar);
        }
    }

    public void c() {
        a();
    }

    @Override // t5.d
    public final void cancel() {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.a(hVar);
        e();
    }

    @Override // io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        io.reactivex.plugins.a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public abstract /* synthetic */ void onNext(Object obj);

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
            d();
        }
    }

    @Override // io.reactivex.InterfaceC0981n
    public final InterfaceC0981n serialize() {
        return new C0815w0(this);
    }

    @Override // io.reactivex.InterfaceC0981n
    public final void setCancellable(p027e3.f fVar) {
        setDisposable(new p033f3.b(null));
    }

    @Override // io.reactivex.InterfaceC0981n
    public final void setDisposable(p011b3.c cVar) {
        p033f3.h hVar = this.b;
        hVar.getClass();
        p033f3.d.d(hVar, cVar);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return androidx.exifinterface.media.a.A(getClass().getSimpleName(), VectorFormat.DEFAULT_PREFIX, super.toString(), VectorFormat.DEFAULT_SUFFIX);
    }

    @Override // io.reactivex.InterfaceC0981n
    public boolean tryOnError(Throwable th) {
        return b(th);
    }

    public void d() {
    }

    public void e() {
    }
}
