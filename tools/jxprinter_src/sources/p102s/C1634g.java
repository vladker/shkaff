package p102s;

import O3.l;
import p026e2.a;
import p147z3.u;

/* JADX INFO: renamed from: s.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1634g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8173a;
    public final /* synthetic */ l b;

    public /* synthetic */ C1634g(int i5, l lVar) {
        this.f8173a = i5;
        this.b = lVar;
    }

    @Override // p026e2.a
    public final void onRequestPermissionFail() {
        switch (this.f8173a) {
            case 0:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.FALSE)));
                break;
            case 1:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.FALSE)));
                break;
            default:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.FALSE)));
                break;
        }
    }

    @Override // p026e2.a
    public final void onRequestPermissionSuccess() {
        switch (this.f8173a) {
            case 0:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.TRUE)));
                break;
            case 1:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.TRUE)));
                break;
            default:
                this.b.invoke(u.a(u.m1361constructorimpl(Boolean.TRUE)));
                break;
        }
    }
}
