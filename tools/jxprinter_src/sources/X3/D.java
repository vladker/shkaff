package X3;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class D implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f842a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ Serializable c;
    public final /* synthetic */ Object d;

    public /* synthetic */ D(int i5, String str, p084o4.I i6) {
        this.b = i5;
        this.c = str;
        this.d = i6;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f842a) {
            case 0:
                return ((G) this.c).find((CharSequence) this.d, this.b);
            default:
                String str = (String) this.c;
                p084o4.I i5 = (p084o4.I) this.d;
                int i6 = this.b;
                p072m4.r[] rVarArr = new p072m4.r[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    rVarArr[i7] = p072m4.w.buildSerialDescriptor(str + '.' + i5.getElementName(i7), p072m4.D.INSTANCE, new p072m4.r[0], new S2.l(16));
                }
                return rVarArr;
        }
    }

    public /* synthetic */ D(CharSequence charSequence, G g6, int i5) {
        this.c = g6;
        this.d = charSequence;
        this.b = i5;
    }
}
