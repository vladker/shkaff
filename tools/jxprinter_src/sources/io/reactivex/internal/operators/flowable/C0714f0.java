package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0714f0 extends AtomicReference implements InterfaceC0984q, InterfaceC0679f, t5.d {
    private static final long serialVersionUID = -7346385463600070225L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4614a;
    public t5.d b;
    public InterfaceC0682i c;
    public boolean d;

    public C0714f0(t5.c cVar, InterfaceC0682i interfaceC0682i) {
        this.f4614a = cVar;
        this.c = interfaceC0682i;
    }

    @Override // t5.d
    public final void cancel() {
        this.b.cancel();
        p033f3.d.a(this);
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.d) {
            this.f4614a.onComplete();
            return;
        }
        this.d = true;
        this.b = p094q3.g.f7849a;
        InterfaceC0682i interfaceC0682i = this.c;
        this.c = null;
        ((AbstractC0676c) interfaceC0682i).subscribe(this);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4614a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4614a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.b, dVar)) {
            this.b = dVar;
            this.f4614a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.b.request(j6);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
