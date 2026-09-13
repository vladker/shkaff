package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSystemColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class N1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5938a;
    public final /* synthetic */ CTSystemColorImpl b;

    public /* synthetic */ N1(CTSystemColorImpl cTSystemColorImpl, int i5) {
        this.f5938a = i5;
        this.b = cTSystemColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5938a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCompArray(iIntValue);
            case 1:
                return this.b.getHueArray(iIntValue);
            case 2:
                return this.b.insertNewHue(iIntValue);
            case 3:
                return this.b.getSatModArray(iIntValue);
            case 4:
                return this.b.insertNewSatMod(iIntValue);
            case 5:
                return this.b.getBlueModArray(iIntValue);
            case 6:
                return this.b.getBlueArray(iIntValue);
            case 7:
                return this.b.insertNewBlue(iIntValue);
            case 8:
                return this.b.getSatArray(iIntValue);
            case 9:
                return this.b.insertNewSat(iIntValue);
            case 10:
                return this.b.getLumArray(iIntValue);
            case 11:
                return this.b.insertNewLum(iIntValue);
            case 12:
                return this.b.getLumOffArray(iIntValue);
            case 13:
                return this.b.insertNewLumOff(iIntValue);
            case 14:
                return this.b.insertNewBlueMod(iIntValue);
            case 15:
                return this.b.getGrayArray(iIntValue);
            case 16:
                return this.b.insertNewGray(iIntValue);
            case 17:
                return this.b.getAlphaArray(iIntValue);
            case 18:
                return this.b.insertNewAlpha(iIntValue);
            case 19:
                return this.b.getGreenModArray(iIntValue);
            case 20:
                return this.b.insertNewGreenMod(iIntValue);
            case 21:
                return this.b.getTintArray(iIntValue);
            case 22:
                return this.b.insertNewTint(iIntValue);
            case 23:
                return this.b.getGammaArray(iIntValue);
            case 24:
                return this.b.insertNewGamma(iIntValue);
            case 25:
                return this.b.insertNewComp(iIntValue);
            case 26:
                return this.b.getShadeArray(iIntValue);
            case 27:
                return this.b.insertNewShade(iIntValue);
            case 28:
                return this.b.getRedOffArray(iIntValue);
            default:
                return this.b.insertNewRedOff(iIntValue);
        }
    }
}
