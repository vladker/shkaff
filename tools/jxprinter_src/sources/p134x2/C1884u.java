package p134x2;

import G3.d;
import p049i4.b;

/* JADX INFO: renamed from: x2.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1884u extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8940a;
    public b b;
    public M0 c;
    public /* synthetic */ Object d;
    public final /* synthetic */ E e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8941f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1884u(E e, d dVar) {
        super(dVar);
        this.e = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f8941f |= Integer.MIN_VALUE;
        return E.a(this.e, 0L, this);
    }
}
