package p134x2;

import G3.d;

/* JADX INFO: renamed from: x2.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1863j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8906a;
    public M0 b;
    public boolean c;
    public boolean d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ E f8907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8908g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1863j(E e, d dVar) {
        super(dVar);
        this.f8907f = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f8908g |= Integer.MIN_VALUE;
        return this.f8907f.k(null, false, false, this);
    }
}
