package p147z3;

import E3.g;
import E3.q;
import E3.r;

/* JADX INFO: renamed from: z3.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1924d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f9130a;
    public final /* synthetic */ C1925e b;
    public final /* synthetic */ O3.q c;
    public final /* synthetic */ g d;

    public C1924d(r rVar, C1925e c1925e, O3.q qVar, g gVar) {
        this.f9130a = rVar;
        this.b = c1925e;
        this.c = qVar;
        this.d = gVar;
    }

    @Override // E3.g
    public final q getContext() {
        return this.f9130a;
    }

    @Override // E3.g
    public final void resumeWith(Object obj) {
        O3.q qVar = this.c;
        C1925e c1925e = this.b;
        c1925e.function = qVar;
        c1925e.cont = this.d;
        c1925e.result = obj;
    }
}
