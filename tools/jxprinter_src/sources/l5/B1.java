package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSchemeColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class B1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5902a;
    public final /* synthetic */ CTSchemeColorImpl b;

    public /* synthetic */ B1(CTSchemeColorImpl cTSchemeColorImpl, int i5) {
        this.f5902a = i5;
        this.b = cTSchemeColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5902a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getLumArray(iIntValue);
            case 1:
                return this.b.getHueOffArray(iIntValue);
            case 2:
                return this.b.insertNewHueOff(iIntValue);
            case 3:
                return this.b.getAlphaModArray(iIntValue);
            case 4:
                return this.b.insertNewAlphaMod(iIntValue);
            case 5:
                return this.b.getRedOffArray(iIntValue);
            case 6:
                return this.b.getSatArray(iIntValue);
            case 7:
                return this.b.insertNewSat(iIntValue);
            case 8:
                return this.b.getAlphaOffArray(iIntValue);
            case 9:
                return this.b.insertNewAlphaOff(iIntValue);
            case 10:
                return this.b.getGammaArray(iIntValue);
            case 11:
                return this.b.insertNewGamma(iIntValue);
            case 12:
                return this.b.getRedModArray(iIntValue);
            case 13:
                return this.b.insertNewRedMod(iIntValue);
            case 14:
                return this.b.insertNewRedOff(iIntValue);
            case 15:
                return this.b.getBlueModArray(iIntValue);
            case 16:
                return this.b.insertNewBlueMod(iIntValue);
            case 17:
                return this.b.getShadeArray(iIntValue);
            case 18:
                return this.b.insertNewShade(iIntValue);
            case 19:
                return this.b.getInvGammaArray(iIntValue);
            case 20:
                return this.b.insertNewInvGamma(iIntValue);
            case 21:
                return this.b.getBlueArray(iIntValue);
            case 22:
                return this.b.insertNewBlue(iIntValue);
            case 23:
                return this.b.getAlphaArray(iIntValue);
            case 24:
                return this.b.insertNewAlpha(iIntValue);
            case 25:
                return this.b.insertNewLum(iIntValue);
            case 26:
                return this.b.getBlueOffArray(iIntValue);
            case 27:
                return this.b.insertNewBlueOff(iIntValue);
            case 28:
                return this.b.getSatModArray(iIntValue);
            default:
                return this.b.insertNewSatMod(iIntValue);
        }
    }
}
