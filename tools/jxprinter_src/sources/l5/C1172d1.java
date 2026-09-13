package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSRgbColorImpl;

/* JADX INFO: renamed from: l5.d1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1172d1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5988a;
    public final /* synthetic */ CTSRgbColorImpl b;

    public /* synthetic */ C1172d1(CTSRgbColorImpl cTSRgbColorImpl, int i5) {
        this.f5988a = i5;
        this.b = cTSRgbColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5988a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getInvArray(iIntValue);
            case 1:
                return this.b.getHueModArray(iIntValue);
            case 2:
                return this.b.insertNewHueMod(iIntValue);
            case 3:
                return this.b.getBlueOffArray(iIntValue);
            case 4:
                return this.b.insertNewBlueOff(iIntValue);
            case 5:
                return this.b.getRedArray(iIntValue);
            case 6:
                return this.b.getGammaArray(iIntValue);
            case 7:
                return this.b.insertNewGamma(iIntValue);
            case 8:
                return this.b.getGreenOffArray(iIntValue);
            case 9:
                return this.b.insertNewGreenOff(iIntValue);
            case 10:
                return this.b.getLumOffArray(iIntValue);
            case 11:
                return this.b.insertNewLumOff(iIntValue);
            case 12:
                return this.b.getBlueArray(iIntValue);
            case 13:
                return this.b.insertNewBlue(iIntValue);
            case 14:
                return this.b.insertNewRed(iIntValue);
            case 15:
                return this.b.getSatModArray(iIntValue);
            case 16:
                return this.b.insertNewSatMod(iIntValue);
            case 17:
                return this.b.getGrayArray(iIntValue);
            case 18:
                return this.b.insertNewGray(iIntValue);
            case 19:
                return this.b.getGreenArray(iIntValue);
            case 20:
                return this.b.insertNewGreen(iIntValue);
            case 21:
                return this.b.getLumModArray(iIntValue);
            case 22:
                return this.b.insertNewLumMod(iIntValue);
            case 23:
                return this.b.getInvGammaArray(iIntValue);
            case 24:
                return this.b.insertNewInvGamma(iIntValue);
            case 25:
                return this.b.insertNewInv(iIntValue);
            case 26:
                return this.b.getAlphaModArray(iIntValue);
            case 27:
                return this.b.insertNewAlphaMod(iIntValue);
            case 28:
                return this.b.getBlueModArray(iIntValue);
            default:
                return this.b.insertNewBlueMod(iIntValue);
        }
    }
}
