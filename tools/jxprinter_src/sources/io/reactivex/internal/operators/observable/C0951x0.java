package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0951x0 extends AbstractC0838a {
    public final long b;
    public final Object c;
    public final boolean d;

    public C0951x0(io.reactivex.B b, long j6, Object obj, boolean z6) {
        super(b);
        this.b = j6;
        this.c = obj;
        this.d = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.f5141a.subscribe(new C0947w0(i5, this.b, this.c, this.d));
    }
}
