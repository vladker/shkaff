package p060k4;

import O3.l;
import p072m4.C1241a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5593a;
    public final /* synthetic */ i b;

    public /* synthetic */ h(i iVar, int i5) {
        this.f5593a = i5;
        this.b = iVar;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f5593a) {
            case 0:
                return i.a(this.b, (C1241a) obj);
            default:
                return i.b(this.b, (C1241a) obj);
        }
    }
}
