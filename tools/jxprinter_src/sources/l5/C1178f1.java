package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSRgbColorImpl;

/* JADX INFO: renamed from: l5.f1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1178f1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5996a;
    public final /* synthetic */ CTSRgbColorImpl b;

    public /* synthetic */ C1178f1(CTSRgbColorImpl cTSRgbColorImpl, int i5) {
        this.f5996a = i5;
        this.b = cTSRgbColorImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5996a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeHueMod(iIntValue);
                break;
            case 1:
                this.b.removeBlueOff(iIntValue);
                break;
            case 2:
                this.b.removeGamma(iIntValue);
                break;
            case 3:
                this.b.removeGreenOff(iIntValue);
                break;
            case 4:
                this.b.removeLumOff(iIntValue);
                break;
            case 5:
                this.b.removeBlue(iIntValue);
                break;
            case 6:
                this.b.removeSatMod(iIntValue);
                break;
            case 7:
                this.b.removeGray(iIntValue);
                break;
            case 8:
                this.b.removeRed(iIntValue);
                break;
            case 9:
                this.b.removeGreen(iIntValue);
                break;
            case 10:
                this.b.removeLumMod(iIntValue);
                break;
            case 11:
                this.b.removeInvGamma(iIntValue);
                break;
            case 12:
                this.b.removeAlphaMod(iIntValue);
                break;
            case 13:
                this.b.removeBlueMod(iIntValue);
                break;
            case 14:
                this.b.removeInv(iIntValue);
                break;
            case 15:
                this.b.removeHueOff(iIntValue);
                break;
            case 16:
                this.b.removeGreenMod(iIntValue);
                break;
            case 17:
                this.b.removeSat(iIntValue);
                break;
            case 18:
                this.b.removeLum(iIntValue);
                break;
            case 19:
                this.b.removeHue(iIntValue);
                break;
            case 20:
                this.b.removeAlpha(iIntValue);
                break;
            case 21:
                this.b.removeTint(iIntValue);
                break;
            case 22:
                this.b.removeAlphaOff(iIntValue);
                break;
            case 23:
                this.b.removeShade(iIntValue);
                break;
            case 24:
                this.b.removeRedMod(iIntValue);
                break;
            case 25:
                this.b.removeComp(iIntValue);
                break;
            case 26:
                this.b.removeSatOff(iIntValue);
                break;
            default:
                this.b.removeRedOff(iIntValue);
                break;
        }
    }
}
