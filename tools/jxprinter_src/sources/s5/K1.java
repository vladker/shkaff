package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class K1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8294a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ K1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8294a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8294a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSzCsArray(iIntValue);
            case 1:
                return this.b.getSzArray(iIntValue);
            case 2:
                return this.b.insertNewSz(iIntValue);
            case 3:
                return this.b.getPositionArray(iIntValue);
            case 4:
                return this.b.insertNewPosition(iIntValue);
            case 5:
                return this.b.getDstrikeArray(iIntValue);
            case 6:
                return this.b.getRStyleArray(iIntValue);
            case 7:
                return this.b.insertNewRStyle(iIntValue);
            case 8:
                return this.b.getWArray(iIntValue);
            case 9:
                return this.b.insertNewW(iIntValue);
            case 10:
                return this.b.getBdrArray(iIntValue);
            case 11:
                return this.b.insertNewBdr(iIntValue);
            case 12:
                return this.b.getFitTextArray(iIntValue);
            case 13:
                return this.b.insertNewFitText(iIntValue);
            case 14:
                return this.b.insertNewDstrike(iIntValue);
            case 15:
                return this.b.getSpecVanishArray(iIntValue);
            case 16:
                return this.b.insertNewSpecVanish(iIntValue);
            case 17:
                return this.b.getLangArray(iIntValue);
            case 18:
                return this.b.insertNewLang(iIntValue);
            case 19:
                return this.b.getBArray(iIntValue);
            case 20:
                return this.b.insertNewB(iIntValue);
            case 21:
                return this.b.getNoProofArray(iIntValue);
            case 22:
                return this.b.insertNewNoProof(iIntValue);
            case 23:
                return this.b.getWebHiddenArray(iIntValue);
            case 24:
                return this.b.insertNewWebHidden(iIntValue);
            case 25:
                return this.b.getEffectArray(iIntValue);
            case 26:
                return this.b.insertNewEffect(iIntValue);
            case 27:
                return this.b.getEastAsianLayoutArray(iIntValue);
            case 28:
                return this.b.getKernArray(iIntValue);
            default:
                return this.b.insertNewKern(iIntValue);
        }
    }
}
