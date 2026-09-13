package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.f1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1667f1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8403a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1667f1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8403a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8403a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSpecVanishArray(iIntValue);
            case 1:
                return this.b.getKernArray(iIntValue);
            case 2:
                return this.b.insertNewKern(iIntValue);
            case 3:
                return this.b.getVanishArray(iIntValue);
            case 4:
                return this.b.insertNewVanish(iIntValue);
            case 5:
                return this.b.getStrikeArray(iIntValue);
            case 6:
                return this.b.getSzArray(iIntValue);
            case 7:
                return this.b.insertNewSz(iIntValue);
            case 8:
                return this.b.getUArray(iIntValue);
            case 9:
                return this.b.insertNewU(iIntValue);
            case 10:
                return this.b.getOutlineArray(iIntValue);
            case 11:
                return this.b.insertNewOutline(iIntValue);
            case 12:
                return this.b.getSzCsArray(iIntValue);
            case 13:
                return this.b.insertNewSzCs(iIntValue);
            case 14:
                return this.b.insertNewStrike(iIntValue);
            case 15:
                return this.b.getSnapToGridArray(iIntValue);
            case 16:
                return this.b.insertNewSnapToGrid(iIntValue);
            case 17:
                return this.b.getImprintArray(iIntValue);
            case 18:
                return this.b.insertNewImprint(iIntValue);
            case 19:
                return this.b.getFitTextArray(iIntValue);
            case 20:
                return this.b.insertNewFitText(iIntValue);
            case 21:
                return this.b.getNoProofArray(iIntValue);
            case 22:
                return this.b.insertNewNoProof(iIntValue);
            case 23:
                return this.b.getVertAlignArray(iIntValue);
            case 24:
                return this.b.insertNewVertAlign(iIntValue);
            case 25:
                return this.b.getSmallCapsArray(iIntValue);
            case 26:
                return this.b.insertNewSmallCaps(iIntValue);
            case 27:
                return this.b.getOMathArray(iIntValue);
            case 28:
                return this.b.getWebHiddenArray(iIntValue);
            default:
                return this.b.insertNewWebHidden(iIntValue);
        }
    }
}
