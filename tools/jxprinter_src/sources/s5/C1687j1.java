package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.j1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1687j1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8427a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1687j1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8427a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8427a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getHighlightArray(iIntValue);
            case 1:
                return this.b.insertNewHighlight(iIntValue);
            case 2:
                return this.b.getBdrArray(iIntValue);
            case 3:
                return this.b.insertNewBdr(iIntValue);
            case 4:
                return this.b.getRFontsArray(iIntValue);
            case 5:
                return this.b.insertNewRFonts(iIntValue);
            case 6:
                return this.b.insertNewOMath(iIntValue);
            case 7:
                return this.b.getLangArray(iIntValue);
            case 8:
                return this.b.insertNewLang(iIntValue);
            case 9:
                return this.b.getShadowArray(iIntValue);
            case 10:
                return this.b.insertNewShadow(iIntValue);
            case 11:
                return this.b.getEmArray(iIntValue);
            case 12:
                return this.b.insertNewEm(iIntValue);
            case 13:
                return this.b.getWArray(iIntValue);
            case 14:
                return this.b.insertNewW(iIntValue);
            case 15:
                return this.b.getEmbossArray(iIntValue);
            case 16:
                return this.b.insertNewEmboss(iIntValue);
            case 17:
                return this.b.insertNewSpecVanish(iIntValue);
            case 18:
                return this.b.getICsArray(iIntValue);
            case 19:
                return this.b.insertNewICs(iIntValue);
            case 20:
                return this.b.getShdArray(iIntValue);
            case 21:
                return this.b.insertNewShd(iIntValue);
            case 22:
                return this.b.getRStyleArray(iIntValue);
            case 23:
                return this.b.insertNewRStyle(iIntValue);
            case 24:
                return this.b.getDstrikeArray(iIntValue);
            case 25:
                return this.b.insertNewDstrike(iIntValue);
            case 26:
                return this.b.getEffectArray(iIntValue);
            case 27:
                return this.b.insertNewEffect(iIntValue);
            case 28:
                return this.b.getCsArray(iIntValue);
            default:
                return this.b.insertNewCs(iIntValue);
        }
    }
}
