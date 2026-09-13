package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -8730235182291002949L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f4395a;
    public final int b;
    public final int c;
    public final int d;
    public int e;

    public P(O o6, int i5, int i6) {
        this.f4395a = o6;
        this.b = i5;
        this.c = i6;
        this.d = i6 - (i6 >> 2);
    }

    public final void a() {
        int i5 = this.e + 1;
        if (i5 != this.d) {
            this.e = i5;
        } else {
            this.e = 0;
            ((t5.d) get()).request(i5);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4395a.j(this.b);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        O o6 = this.f4395a;
        int i5 = this.b;
        if (!p100r3.g.a(o6.f4390m, th)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            if (o6.f4383f) {
                o6.j(i5);
                return;
            }
            o6.e();
            o6.f4389l = true;
            o6.f();
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        boolean z6;
        O o6 = this.f4395a;
        int i5 = this.b;
        synchronized (o6) {
            try {
                Object[] objArr = o6.e;
                int i6 = o6.f4385h;
                if (objArr[i5] == null) {
                    i6++;
                    o6.f4385h = i6;
                }
                objArr[i5] = obj;
                if (objArr.length == i6) {
                    o6.d.offer(o6.c[i5], objArr.clone());
                    z6 = false;
                } else {
                    z6 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z6) {
            o6.c[i5].a();
        } else {
            o6.f();
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, this.c);
    }
}
