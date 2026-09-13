package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class U0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8342a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ U0(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8342a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8342a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSzArray(iIntValue);
            case 1:
                return this.b.getDstrikeArray(iIntValue);
            case 2:
                return this.b.insertNewDstrike(iIntValue);
            case 3:
                return this.b.getShadowArray(iIntValue);
            case 4:
                return this.b.insertNewShadow(iIntValue);
            case 5:
                return this.b.getICsArray(iIntValue);
            case 6:
                return this.b.getCapsArray(iIntValue);
            case 7:
                return this.b.insertNewCaps(iIntValue);
            case 8:
                return this.b.getSmallCapsArray(iIntValue);
            case 9:
                return this.b.insertNewSmallCaps(iIntValue);
            case 10:
                return this.b.getPositionArray(iIntValue);
            case 11:
                return this.b.insertNewPosition(iIntValue);
            case 12:
                return this.b.getIArray(iIntValue);
            case 13:
                return this.b.insertNewI(iIntValue);
            case 14:
                return this.b.insertNewICs(iIntValue);
            case 15:
                return this.b.getOutlineArray(iIntValue);
            case 16:
                return this.b.insertNewOutline(iIntValue);
            case 17:
                return this.b.getRtlArray(iIntValue);
            case 18:
                return this.b.insertNewRtl(iIntValue);
            case 19:
                return this.b.getSzCsArray(iIntValue);
            case 20:
                return this.b.insertNewSzCs(iIntValue);
            case 21:
                return this.b.getWebHiddenArray(iIntValue);
            case 22:
                return this.b.insertNewWebHidden(iIntValue);
            case 23:
                return this.b.getOMathArray(iIntValue);
            case 24:
                return this.b.insertNewOMath(iIntValue);
            case 25:
                return this.b.getCsArray(iIntValue);
            case 26:
                return this.b.insertNewCs(iIntValue);
            case 27:
                return this.b.getEffectArray(iIntValue);
            case 28:
                return this.b.getNoProofArray(iIntValue);
            default:
                return this.b.insertNewNoProof(iIntValue);
        }
    }
}
