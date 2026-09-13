package W3;

import p007a4.AbstractC0261a0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f792a;
    public final /* synthetic */ O3.l b;

    public /* synthetic */ B(int i5, O3.l lVar) {
        this.f792a = i5;
        this.b = lVar;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f792a) {
            case 0:
                this.b.invoke(obj);
                return obj;
            default:
                return Long.valueOf(AbstractC0261a0.a(((Y3.b) this.b.invoke(obj)).f873a));
        }
    }
}
