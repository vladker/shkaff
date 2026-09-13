package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0921q2 extends p106s3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p106s3.a f5261a;
    public final io.reactivex.B b;

    public C0921q2(p106s3.a aVar, io.reactivex.B b) {
        this.f5261a = aVar;
        this.b = b;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.b.subscribe(i5);
    }

    @Override // p106s3.a
    public final void connect(p027e3.g gVar) {
        this.f5261a.connect(gVar);
    }
}
