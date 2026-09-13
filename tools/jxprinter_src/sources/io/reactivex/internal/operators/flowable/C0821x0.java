package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.EnumC0675b;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0821x0 extends AbstractC0979l {
    public final EnumC0675b b;

    public C0821x0(EnumC0675b enumC0675b) {
        this.b = enumC0675b;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        AbstractC0774p0 c0803u0;
        int iOrdinal = this.b.ordinal();
        if (iOrdinal == 0) {
            c0803u0 = new C0803u0(cVar);
        } else if (iOrdinal == 1) {
            c0803u0 = new C0791s0(cVar);
        } else if (iOrdinal != 3) {
            c0803u0 = iOrdinal != 4 ? new C0780q0(cVar, AbstractC0979l.f5366a) : new C0797t0(cVar);
        } else {
            c0803u0 = new C0785r0(cVar);
        }
        cVar.onSubscribe(c0803u0);
        try {
            throw null;
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            c0803u0.onError(th);
        }
    }
}
