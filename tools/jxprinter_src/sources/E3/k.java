package E3;

import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f230a;
    public final /* synthetic */ O3.l b;

    public k(q qVar, O3.l lVar) {
        this.f230a = qVar;
        this.b = lVar;
    }

    @Override // E3.g
    public final q getContext() {
        return this.f230a;
    }

    @Override // E3.g
    public final void resumeWith(Object obj) {
        this.b.invoke(u.a(obj));
    }
}
