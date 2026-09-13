package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class B1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8249a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ B1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8249a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8249a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeKern(iIntValue);
                break;
            case 1:
                this.b.removeSzCs(iIntValue);
                break;
            case 2:
                this.b.removeICs(iIntValue);
                break;
            case 3:
                this.b.removeCaps(iIntValue);
                break;
            case 4:
                this.b.removeShadow(iIntValue);
                break;
            case 5:
                this.b.removeHighlight(iIntValue);
                break;
            case 6:
                this.b.removeVertAlign(iIntValue);
                break;
            case 7:
                this.b.removeShd(iIntValue);
                break;
            case 8:
                this.b.removeOutline(iIntValue);
                break;
            case 9:
                this.b.removeRtl(iIntValue);
                break;
            case 10:
                this.b.removeEmboss(iIntValue);
                break;
            case 11:
                this.b.removeStrike(iIntValue);
                break;
            case 12:
                this.b.removeRStyle(iIntValue);
                break;
            case 13:
                this.b.removeBCs(iIntValue);
                break;
            case 14:
                this.b.removeU(iIntValue);
                break;
            case 15:
                this.b.removeB(iIntValue);
                break;
            case 16:
                this.b.removeSmallCaps(iIntValue);
                break;
            case 17:
                this.b.removeSz(iIntValue);
                break;
            case 18:
                this.b.removeColor(iIntValue);
                break;
            case 19:
                this.b.removeEffect(iIntValue);
                break;
            case 20:
                this.b.removeCs(iIntValue);
                break;
            case 21:
                this.b.removeEastAsianLayout(iIntValue);
                break;
            case 22:
                this.b.removeWebHidden(iIntValue);
                break;
            case 23:
                this.b.removeSnapToGrid(iIntValue);
                break;
            case 24:
                this.b.removeW(iIntValue);
                break;
            case 25:
                this.b.removeFitText(iIntValue);
                break;
            case 26:
                this.b.removeOMath(iIntValue);
                break;
            case 27:
                this.b.removeEm(iIntValue);
                break;
            case 28:
                this.b.removeNoProof(iIntValue);
                break;
            default:
                this.b.removeImprint(iIntValue);
                break;
        }
    }
}
