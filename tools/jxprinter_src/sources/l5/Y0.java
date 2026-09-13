package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPresetColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Y0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5969a;
    public final /* synthetic */ CTPresetColorImpl b;

    public /* synthetic */ Y0(CTPresetColorImpl cTPresetColorImpl, int i5) {
        this.f5969a = i5;
        this.b = cTPresetColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5969a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSatArray(iIntValue);
            case 1:
                return this.b.insertNewSat(iIntValue);
            case 2:
                return this.b.getSatOffArray(iIntValue);
            case 3:
                return this.b.insertNewSatOff(iIntValue);
            case 4:
                return this.b.getCompArray(iIntValue);
            case 5:
                return this.b.insertNewComp(iIntValue);
            case 6:
                return this.b.getGrayArray(iIntValue);
            case 7:
                return this.b.insertNewGray(iIntValue);
            case 8:
                return this.b.getBlueOffArray(iIntValue);
            case 9:
                return this.b.getGreenOffArray(iIntValue);
            case 10:
                return this.b.insertNewGreenOff(iIntValue);
            case 11:
                return this.b.getLumOffArray(iIntValue);
            case 12:
                return this.b.insertNewLumOff(iIntValue);
            case 13:
                return this.b.getHueArray(iIntValue);
            case 14:
                return this.b.insertNewHue(iIntValue);
            case 15:
                return this.b.getLumModArray(iIntValue);
            case 16:
                return this.b.insertNewLumMod(iIntValue);
            case 17:
                return this.b.insertNewBlueOff(iIntValue);
            case 18:
                return this.b.getAlphaModArray(iIntValue);
            case 19:
                return this.b.insertNewAlphaMod(iIntValue);
            case 20:
                return this.b.getRedArray(iIntValue);
            case 21:
                return this.b.insertNewRed(iIntValue);
            case 22:
                return this.b.getInvGammaArray(iIntValue);
            case 23:
                return this.b.insertNewInvGamma(iIntValue);
            case 24:
                return this.b.getSatModArray(iIntValue);
            default:
                return this.b.insertNewSatMod(iIntValue);
        }
    }
}
