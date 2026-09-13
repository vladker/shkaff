package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRstImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class D0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7984a;
    public final /* synthetic */ CTRstImpl b;

    public /* synthetic */ D0(CTRstImpl cTRstImpl, int i5) {
        this.f7984a = i5;
        this.b = cTRstImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7984a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getRPhArray(iIntValue);
            case 1:
                return this.b.insertNewRPh(iIntValue);
            case 2:
                return this.b.getRArray(iIntValue);
            default:
                return this.b.insertNewR(iIntValue);
        }
    }
}
