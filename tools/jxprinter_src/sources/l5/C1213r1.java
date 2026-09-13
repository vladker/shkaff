package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTScRgbColorImpl;

/* JADX INFO: renamed from: l5.r1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1213r1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6039a;
    public final /* synthetic */ CTScRgbColorImpl b;

    public /* synthetic */ C1213r1(CTScRgbColorImpl cTScRgbColorImpl, int i5) {
        this.f6039a = i5;
        this.b = cTScRgbColorImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6039a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeRedOff(iIntValue);
                break;
            case 1:
                this.b.removeInv(iIntValue);
                break;
            case 2:
                this.b.removeHueMod(iIntValue);
                break;
            case 3:
                this.b.removeLum(iIntValue);
                break;
            case 4:
                this.b.removeBlueOff(iIntValue);
                break;
            case 5:
                this.b.removeAlpha(iIntValue);
                break;
            case 6:
                this.b.removeAlphaMod(iIntValue);
                break;
            case 7:
                this.b.removeHueOff(iIntValue);
                break;
            case 8:
                this.b.removeSat(iIntValue);
                break;
            case 9:
                this.b.removeInvGamma(iIntValue);
                break;
            case 10:
                this.b.removeGreenMod(iIntValue);
                break;
            case 11:
                this.b.removeComp(iIntValue);
                break;
            case 12:
                this.b.removeLumOff(iIntValue);
                break;
            case 13:
                this.b.removeShade(iIntValue);
                break;
            case 14:
                this.b.removeGreenOff(iIntValue);
                break;
            case 15:
                this.b.removeSatMod(iIntValue);
                break;
            case 16:
                this.b.removeBlueMod(iIntValue);
                break;
            case 17:
                this.b.removeGamma(iIntValue);
                break;
            case 18:
                this.b.removeTint(iIntValue);
                break;
            case 19:
                this.b.removeHue(iIntValue);
                break;
            case 20:
                this.b.removeBlue(iIntValue);
                break;
            case 21:
                this.b.removeRedMod(iIntValue);
                break;
            case 22:
                this.b.removeGray(iIntValue);
                break;
            case 23:
                this.b.removeGreen(iIntValue);
                break;
            case 24:
                this.b.removeLumMod(iIntValue);
                break;
            case 25:
                this.b.removeSatOff(iIntValue);
                break;
            case 26:
                this.b.removeRed(iIntValue);
                break;
            default:
                this.b.removeAlphaOff(iIntValue);
                break;
        }
    }
}
