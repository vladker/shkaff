package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPresetColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class R0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5948a;
    public final /* synthetic */ CTPresetColorImpl b;

    public /* synthetic */ R0(CTPresetColorImpl cTPresetColorImpl, int i5) {
        this.f5948a = i5;
        this.b = cTPresetColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5948a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAlphaArray(iIntValue);
            case 1:
                return this.b.getGreenModArray(iIntValue);
            case 2:
                return this.b.insertNewGreenMod(iIntValue);
            case 3:
                return this.b.getHueModArray(iIntValue);
            case 4:
                return this.b.insertNewHueMod(iIntValue);
            case 5:
                return this.b.getGreenArray(iIntValue);
            case 6:
                return this.b.getRedModArray(iIntValue);
            case 7:
                return this.b.insertNewRedMod(iIntValue);
            case 8:
                return this.b.getInvArray(iIntValue);
            case 9:
                return this.b.insertNewInv(iIntValue);
            case 10:
                return this.b.getBlueModArray(iIntValue);
            case 11:
                return this.b.insertNewBlueMod(iIntValue);
            case 12:
                return this.b.getAlphaOffArray(iIntValue);
            case 13:
                return this.b.insertNewAlphaOff(iIntValue);
            case 14:
                return this.b.insertNewGreen(iIntValue);
            case 15:
                return this.b.getGammaArray(iIntValue);
            case 16:
                return this.b.insertNewGamma(iIntValue);
            case 17:
                return this.b.getShadeArray(iIntValue);
            case 18:
                return this.b.insertNewShade(iIntValue);
            case 19:
                return this.b.getLumArray(iIntValue);
            case 20:
                return this.b.insertNewLum(iIntValue);
            case 21:
                return this.b.getHueOffArray(iIntValue);
            case 22:
                return this.b.insertNewHueOff(iIntValue);
            case 23:
                return this.b.getTintArray(iIntValue);
            case 24:
                return this.b.insertNewTint(iIntValue);
            case 25:
                return this.b.insertNewAlpha(iIntValue);
            case 26:
                return this.b.getRedOffArray(iIntValue);
            case 27:
                return this.b.insertNewRedOff(iIntValue);
            case 28:
                return this.b.getBlueArray(iIntValue);
            default:
                return this.b.insertNewBlue(iIntValue);
        }
    }
}
