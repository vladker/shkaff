package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.k3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0747k3 extends AbstractC0979l {
    public final long b;
    public final long c;

    public C0747k3(long j6, long j7) {
        this.b = j6;
        this.c = j6 + j7;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        if (cVar instanceof p043h3.a) {
            cVar.onSubscribe(new C0735i3((p043h3.a) cVar, this.b, this.c));
        } else {
            cVar.onSubscribe(new C0741j3(cVar, this.b, this.c));
        }
    }
}
