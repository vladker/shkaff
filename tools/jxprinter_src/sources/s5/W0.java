package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class W0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8352a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ W0(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8352a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8352a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeDstrike(iIntValue);
                break;
            case 1:
                this.b.removeShadow(iIntValue);
                break;
            case 2:
                this.b.removeCaps(iIntValue);
                break;
            case 3:
                this.b.removeSmallCaps(iIntValue);
                break;
            case 4:
                this.b.removePosition(iIntValue);
                break;
            case 5:
                this.b.removeI(iIntValue);
                break;
            case 6:
                this.b.removeOutline(iIntValue);
                break;
            case 7:
                this.b.removeRtl(iIntValue);
                break;
            case 8:
                this.b.removeICs(iIntValue);
                break;
            case 9:
                this.b.removeSzCs(iIntValue);
                break;
            case 10:
                this.b.removeWebHidden(iIntValue);
                break;
            case 11:
                this.b.removeOMath(iIntValue);
                break;
            case 12:
                this.b.removeCs(iIntValue);
                break;
            case 13:
                this.b.removeNoProof(iIntValue);
                break;
            case 14:
                this.b.removeHighlight(iIntValue);
                break;
            case 15:
                this.b.removeKern(iIntValue);
                break;
            case 16:
                this.b.removeBdr(iIntValue);
                break;
            case 17:
                this.b.removeFitText(iIntValue);
                break;
            case 18:
                this.b.removeBCs(iIntValue);
                break;
            case 19:
                this.b.removeEffect(iIntValue);
                break;
            case 20:
                this.b.removeB(iIntValue);
                break;
            case 21:
                this.b.removeW(iIntValue);
                break;
            case 22:
                this.b.removeRStyle(iIntValue);
                break;
            case 23:
                this.b.removeEmboss(iIntValue);
                break;
            case 24:
                this.b.removeImprint(iIntValue);
                break;
            case 25:
                this.b.removeSz(iIntValue);
                break;
            case 26:
                this.b.removeEastAsianLayout(iIntValue);
                break;
            case 27:
                this.b.removeColor(iIntValue);
                break;
            case 28:
                this.b.removeU(iIntValue);
                break;
            default:
                this.b.removeLang(iIntValue);
                break;
        }
    }
}
