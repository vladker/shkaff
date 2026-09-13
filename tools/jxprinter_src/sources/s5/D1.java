package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class D1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8259a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ D1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8259a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8259a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getUArray(iIntValue);
            case 1:
                return this.b.insertNewU(iIntValue);
            case 2:
                return this.b.getBArray(iIntValue);
            case 3:
                return this.b.insertNewB(iIntValue);
            case 4:
                return this.b.getSmallCapsArray(iIntValue);
            case 5:
                return this.b.insertNewSmallCaps(iIntValue);
            case 6:
                return this.b.insertNewEffect(iIntValue);
            case 7:
                return this.b.getSzArray(iIntValue);
            case 8:
                return this.b.insertNewSz(iIntValue);
            case 9:
                return this.b.getColorArray(iIntValue);
            case 10:
                return this.b.insertNewColor(iIntValue);
            case 11:
                return this.b.getCsArray(iIntValue);
            case 12:
                return this.b.insertNewCs(iIntValue);
            case 13:
                return this.b.getEastAsianLayoutArray(iIntValue);
            case 14:
                return this.b.insertNewEastAsianLayout(iIntValue);
            case 15:
                return this.b.getWebHiddenArray(iIntValue);
            case 16:
                return this.b.insertNewWebHidden(iIntValue);
            case 17:
                return this.b.insertNewFitText(iIntValue);
            case 18:
                return this.b.getSnapToGridArray(iIntValue);
            case 19:
                return this.b.insertNewSnapToGrid(iIntValue);
            case 20:
                return this.b.getWArray(iIntValue);
            case 21:
                return this.b.insertNewW(iIntValue);
            case 22:
                return this.b.getOMathArray(iIntValue);
            case 23:
                return this.b.insertNewOMath(iIntValue);
            case 24:
                return this.b.getEmArray(iIntValue);
            case 25:
                return this.b.insertNewEm(iIntValue);
            case 26:
                return this.b.getNoProofArray(iIntValue);
            case 27:
                return this.b.insertNewNoProof(iIntValue);
            case 28:
                return this.b.getImprintArray(iIntValue);
            default:
                return this.b.insertNewImprint(iIntValue);
        }
    }
}
