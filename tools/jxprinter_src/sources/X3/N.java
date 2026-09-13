package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class N implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f850a;
    public final /* synthetic */ String b;

    public /* synthetic */ N(String str, int i5) {
        this.f850a = i5;
        this.b = str;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        String it = (String) obj;
        switch (this.f850a) {
            case 0:
                kotlin.jvm.internal.E.f(it, "it");
                boolean zIsBlank = b0.isBlank(it);
                String str = this.b;
                if (zIsBlank) {
                    return it.length() < str.length() ? str : it;
                }
                return androidx.collection.a.n(str, it);
            default:
                kotlin.jvm.internal.E.f(it, "line");
                return this.b + it;
        }
    }
}
