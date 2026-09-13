package U2;

import E3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f717a;
    public f b;
    public p049i4.b c;
    public long d;
    public /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f719g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, g gVar) {
        super(gVar);
        this.f718f = eVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f719g |= Integer.MIN_VALUE;
        return this.f718f.registerRequest(0L, null, this);
    }
}
