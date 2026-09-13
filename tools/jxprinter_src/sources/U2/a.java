package U2;

import E3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f713a;
    public p049i4.b b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f714f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, g gVar) {
        super(gVar);
        this.e = eVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f714f |= Integer.MIN_VALUE;
        return this.e.deleteRequest(0L, this);
    }
}
