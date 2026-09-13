package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0903n extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5238a;
    public final int b;
    public final io.reactivex.G c;
    public final Object d;
    public final Object e;

    public C0903n(io.reactivex.G g6, io.reactivex.G g7, p027e3.d dVar, int i5) {
        this.f5238a = 1;
        this.c = g6;
        this.d = g7;
        this.e = dVar;
        this.b = i5;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5238a) {
            case 0:
                p106s3.a aVar = (p106s3.a) this.c;
                aVar.subscribe(i5);
                if (((AtomicInteger) this.e).incrementAndGet() == this.b) {
                    aVar.connect((p027e3.g) this.d);
                }
                break;
            default:
                N2 n6 = new N2(i5, this.b, this.c, (io.reactivex.G) this.d, (p027e3.d) this.e);
                i5.onSubscribe(n6);
                O2[] o2Arr = n6.f5043f;
                n6.d.subscribe(o2Arr[0]);
                n6.e.subscribe(o2Arr[1]);
                break;
        }
    }

    public C0903n(p106s3.a aVar, int i5, p027e3.g gVar) {
        this.f5238a = 0;
        this.c = aVar;
        this.b = i5;
        this.d = gVar;
        this.e = new AtomicInteger();
    }
}
