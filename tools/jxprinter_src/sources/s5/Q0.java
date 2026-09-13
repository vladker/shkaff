package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Q0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8323a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ Q0(CTPImpl cTPImpl, int i5) {
        this.f8323a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8323a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getOMathArray(iIntValue);
            case 1:
                return this.b.insertNewOMath(iIntValue);
            case 2:
                return this.b.getDelArray(iIntValue);
            case 3:
                return this.b.insertNewDel(iIntValue);
            case 4:
                return this.b.getProofErrArray(iIntValue);
            case 5:
                return this.b.insertNewProofErr(iIntValue);
            case 6:
                return this.b.getRArray(iIntValue);
            default:
                return this.b.insertNewR(iIntValue);
        }
    }
}
