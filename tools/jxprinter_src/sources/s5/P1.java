package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class P1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8319a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ P1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8319a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8319a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getUArray(iIntValue);
            case 1:
                return this.b.insertNewU(iIntValue);
            case 2:
                return this.b.getSmallCapsArray(iIntValue);
            case 3:
                return this.b.insertNewSmallCaps(iIntValue);
            case 4:
                return this.b.getEmbossArray(iIntValue);
            case 5:
                return this.b.insertNewEmboss(iIntValue);
            case 6:
                return this.b.insertNewEastAsianLayout(iIntValue);
            case 7:
                return this.b.getHighlightArray(iIntValue);
            case 8:
                return this.b.insertNewHighlight(iIntValue);
            case 9:
                return this.b.getCapsArray(iIntValue);
            case 10:
                return this.b.insertNewCaps(iIntValue);
            case 11:
                return this.b.getImprintArray(iIntValue);
            case 12:
                return this.b.insertNewImprint(iIntValue);
            case 13:
                return this.b.getCsArray(iIntValue);
            case 14:
                return this.b.insertNewCs(iIntValue);
            case 15:
                return this.b.getShadowArray(iIntValue);
            case 16:
                return this.b.insertNewShadow(iIntValue);
            case 17:
                return this.b.insertNewSzCs(iIntValue);
            case 18:
                return this.b.getVanishArray(iIntValue);
            case 19:
                return this.b.insertNewVanish(iIntValue);
            case 20:
                return this.b.getVertAlignArray(iIntValue);
            case 21:
                return this.b.insertNewVertAlign(iIntValue);
            case 22:
                return this.b.getOMathArray(iIntValue);
            case 23:
                return this.b.insertNewOMath(iIntValue);
            case 24:
                return this.b.getICsArray(iIntValue);
            case 25:
                return this.b.insertNewICs(iIntValue);
            case 26:
                return this.b.getIArray(iIntValue);
            case 27:
                return this.b.insertNewI(iIntValue);
            case 28:
                return this.b.getSpacingArray(iIntValue);
            default:
                return this.b.insertNewSpacing(iIntValue);
        }
    }
}
