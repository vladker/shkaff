package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPresetColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class T0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5954a;
    public final /* synthetic */ CTPresetColorImpl b;

    public /* synthetic */ T0(CTPresetColorImpl cTPresetColorImpl, int i5) {
        this.f5954a = i5;
        this.b = cTPresetColorImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5954a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeGreenMod(iIntValue);
                break;
            case 1:
                this.b.removeHueMod(iIntValue);
                break;
            case 2:
                this.b.removeRedMod(iIntValue);
                break;
            case 3:
                this.b.removeInv(iIntValue);
                break;
            case 4:
                this.b.removeBlueMod(iIntValue);
                break;
            case 5:
                this.b.removeAlphaOff(iIntValue);
                break;
            case 6:
                this.b.removeGamma(iIntValue);
                break;
            case 7:
                this.b.removeShade(iIntValue);
                break;
            case 8:
                this.b.removeGreen(iIntValue);
                break;
            case 9:
                this.b.removeLum(iIntValue);
                break;
            case 10:
                this.b.removeHueOff(iIntValue);
                break;
            case 11:
                this.b.removeTint(iIntValue);
                break;
            case 12:
                this.b.removeRedOff(iIntValue);
                break;
            case 13:
                this.b.removeBlue(iIntValue);
                break;
            case 14:
                this.b.removeAlpha(iIntValue);
                break;
            case 15:
                this.b.removeSat(iIntValue);
                break;
            case 16:
                this.b.removeSatOff(iIntValue);
                break;
            case 17:
                this.b.removeComp(iIntValue);
                break;
            case 18:
                this.b.removeGray(iIntValue);
                break;
            case 19:
                this.b.removeGreenOff(iIntValue);
                break;
            case 20:
                this.b.removeLumOff(iIntValue);
                break;
            case 21:
                this.b.removeHue(iIntValue);
                break;
            case 22:
                this.b.removeLumMod(iIntValue);
                break;
            case 23:
                this.b.removeAlphaMod(iIntValue);
                break;
            case 24:
                this.b.removeRed(iIntValue);
                break;
            case 25:
                this.b.removeBlueOff(iIntValue);
                break;
            case 26:
                this.b.removeInvGamma(iIntValue);
                break;
            default:
                this.b.removeSatMod(iIntValue);
                break;
        }
    }
}
