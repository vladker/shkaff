package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0900m1 implements p027e3.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p027e3.c f5235a;
    public final Object b;

    public C0900m1(Object obj, p027e3.c cVar) {
        this.f5235a = cVar;
        this.b = obj;
    }

    @Override // p027e3.o
    public Object apply(Object obj) {
        return this.f5235a.apply(this.b, obj);
    }
}
