package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: renamed from: s5.z1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1766z1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8507a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ C1766z1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8507a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8507a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFitTextArray(iIntValue);
            case 1:
                return this.b.getKernArray(iIntValue);
            case 2:
                return this.b.insertNewKern(iIntValue);
            case 3:
                return this.b.getSzCsArray(iIntValue);
            case 4:
                return this.b.insertNewSzCs(iIntValue);
            case 5:
                return this.b.getOutlineArray(iIntValue);
            case 6:
                return this.b.getICsArray(iIntValue);
            case 7:
                return this.b.insertNewICs(iIntValue);
            case 8:
                return this.b.getCapsArray(iIntValue);
            case 9:
                return this.b.insertNewCaps(iIntValue);
            case 10:
                return this.b.getShadowArray(iIntValue);
            case 11:
                return this.b.insertNewShadow(iIntValue);
            case 12:
                return this.b.getHighlightArray(iIntValue);
            case 13:
                return this.b.insertNewHighlight(iIntValue);
            case 14:
                return this.b.insertNewOutline(iIntValue);
            case 15:
                return this.b.getVertAlignArray(iIntValue);
            case 16:
                return this.b.insertNewVertAlign(iIntValue);
            case 17:
                return this.b.getShdArray(iIntValue);
            case 18:
                return this.b.insertNewShd(iIntValue);
            case 19:
                return this.b.getRtlArray(iIntValue);
            case 20:
                return this.b.insertNewRtl(iIntValue);
            case 21:
                return this.b.getEmbossArray(iIntValue);
            case 22:
                return this.b.insertNewEmboss(iIntValue);
            case 23:
                return this.b.getStrikeArray(iIntValue);
            case 24:
                return this.b.insertNewStrike(iIntValue);
            case 25:
                return this.b.getRStyleArray(iIntValue);
            case 26:
                return this.b.insertNewRStyle(iIntValue);
            case 27:
                return this.b.getEffectArray(iIntValue);
            case 28:
                return this.b.getBCsArray(iIntValue);
            default:
                return this.b.insertNewBCs(iIntValue);
        }
    }
}
