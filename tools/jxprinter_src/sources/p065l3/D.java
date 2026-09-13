package p065l3;

import io.reactivex.AbstractC0676c;
import io.reactivex.I;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D implements I, c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C f5799h = new C(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5800a;
    public final o b;
    public final boolean c;
    public final p100r3.c d = new p100r3.c();
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f5802g;

    public D(InterfaceC0679f interfaceC0679f, o oVar, boolean z6) {
        this.f5800a = interfaceC0679f;
        this.b = oVar;
        this.c = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5802g.dispose();
        AtomicReference atomicReference = this.e;
        C c = f5799h;
        C c6 = (C) atomicReference.getAndSet(c);
        if (c6 == null || c6 == c) {
            return;
        }
        d.a(c6);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.get() == f5799h;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5801f = true;
        if (this.e.get() == null) {
            p100r3.c cVar = this.d;
            cVar.getClass();
            Throwable thB = g.b(cVar);
            if (thB == null) {
                this.f5800a.onComplete();
            } else {
                this.f5800a.onError(thB);
            }
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (this.c) {
            onComplete();
            return;
        }
        AtomicReference atomicReference = this.e;
        C c = f5799h;
        C c6 = (C) atomicReference.getAndSet(c);
        if (c6 != null && c6 != c) {
            d.a(c6);
        }
        Throwable thB = g.b(cVar);
        if (thB != g.f7961a) {
            this.f5800a.onError(thB);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            C c = new C(this);
            while (true) {
                AtomicReference atomicReference = this.e;
                C c6 = (C) atomicReference.get();
                if (c6 == f5799h) {
                    return;
                }
                do {
                    if (atomicReference.compareAndSet(c6, c)) {
                        if (c6 != null) {
                            d.a(c6);
                        }
                        ((AbstractC0676c) interfaceC0682i).subscribe(c);
                        return;
                    }
                } while (atomicReference.get() == c6);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5802g.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.g(this.f5802g, cVar)) {
            this.f5802g = cVar;
            this.f5800a.onSubscribe(this);
        }
    }
}
