package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTScRgbColorImpl;

/* JADX INFO: renamed from: l5.p1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1208p1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6033a;
    public final /* synthetic */ CTScRgbColorImpl b;

    public /* synthetic */ C1208p1(CTScRgbColorImpl cTScRgbColorImpl, int i5) {
        this.f6033a = i5;
        this.b = cTScRgbColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6033a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getGreenOffArray(iIntValue);
            case 1:
                return this.b.getRedOffArray(iIntValue);
            case 2:
                return this.b.insertNewRedOff(iIntValue);
            case 3:
                return this.b.getInvArray(iIntValue);
            case 4:
                return this.b.insertNewInv(iIntValue);
            case 5:
                return this.b.getSatArray(iIntValue);
            case 6:
                return this.b.getHueModArray(iIntValue);
            case 7:
                return this.b.insertNewHueMod(iIntValue);
            case 8:
                return this.b.getLumArray(iIntValue);
            case 9:
                return this.b.insertNewLum(iIntValue);
            case 10:
                return this.b.getBlueOffArray(iIntValue);
            case 11:
                return this.b.insertNewBlueOff(iIntValue);
            case 12:
                return this.b.getAlphaArray(iIntValue);
            case 13:
                return this.b.insertNewAlpha(iIntValue);
            case 14:
                return this.b.insertNewSat(iIntValue);
            case 15:
                return this.b.getAlphaModArray(iIntValue);
            case 16:
                return this.b.insertNewAlphaMod(iIntValue);
            case 17:
                return this.b.getHueOffArray(iIntValue);
            case 18:
                return this.b.insertNewHueOff(iIntValue);
            case 19:
                return this.b.getInvGammaArray(iIntValue);
            case 20:
                return this.b.insertNewInvGamma(iIntValue);
            case 21:
                return this.b.getGreenModArray(iIntValue);
            case 22:
                return this.b.insertNewGreenMod(iIntValue);
            case 23:
                return this.b.getCompArray(iIntValue);
            case 24:
                return this.b.insertNewComp(iIntValue);
            case 25:
                return this.b.insertNewGreenOff(iIntValue);
            case 26:
                return this.b.getLumOffArray(iIntValue);
            case 27:
                return this.b.insertNewLumOff(iIntValue);
            case 28:
                return this.b.getShadeArray(iIntValue);
            default:
                return this.b.insertNewShade(iIntValue);
        }
    }
}
