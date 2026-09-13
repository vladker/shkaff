package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0930s2 extends AtomicReference implements io.reactivex.I, p011b3.c {
    public static final C0911o2[] e = new C0911o2[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0911o2[] f5279f = new C0911o2[0];
    private static final long serialVersionUID = -533785617179540163L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0925r2 f5280a;
    public boolean b;
    public final AtomicReference c = new AtomicReference(e);
    public final AtomicBoolean d = new AtomicBoolean();

    public C0930s2(InterfaceC0925r2 interfaceC0925r2) {
        this.f5280a = interfaceC0925r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(C0911o2 c0911o2) {
        C0911o2[] c0911o2Arr;
        while (true) {
            AtomicReference atomicReference = this.c;
            C0911o2[] c0911o2Arr2 = (C0911o2[]) atomicReference.get();
            int length = c0911o2Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (c0911o2Arr2[i5].equals(c0911o2)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                c0911o2Arr = e;
            } else {
                C0911o2[] c0911o2Arr3 = new C0911o2[length - 1];
                System.arraycopy(c0911o2Arr2, 0, c0911o2Arr3, 0, i5);
                System.arraycopy(c0911o2Arr2, i5 + 1, c0911o2Arr3, i5, (length - i5) - 1);
                c0911o2Arr = c0911o2Arr3;
            }
            while (!atomicReference.compareAndSet(c0911o2Arr2, c0911o2Arr)) {
                if (atomicReference.get() != c0911o2Arr2) {
                }
            }
            return;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.set(f5279f);
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == f5279f;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.b) {
            return;
        }
        this.b = true;
        InterfaceC0925r2 interfaceC0925r2 = this.f5280a;
        interfaceC0925r2.complete();
        for (C0911o2 c0911o2 : (C0911o2[]) this.c.getAndSet(f5279f)) {
            interfaceC0925r2.e(c0911o2);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.b) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.b = true;
        InterfaceC0925r2 interfaceC0925r2 = this.f5280a;
        interfaceC0925r2.error(th);
        for (C0911o2 c0911o2 : (C0911o2[]) this.c.getAndSet(f5279f)) {
            interfaceC0925r2.e(c0911o2);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.b) {
            return;
        }
        InterfaceC0925r2 interfaceC0925r2 = this.f5280a;
        interfaceC0925r2.a(obj);
        for (C0911o2 c0911o2 : (C0911o2[]) this.c.get()) {
            interfaceC0925r2.e(c0911o2);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this, cVar)) {
            for (C0911o2 c0911o2 : (C0911o2[]) this.c.get()) {
                this.f5280a.e(c0911o2);
            }
        }
    }
}
