package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSystemColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class V1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5961a;
    public final /* synthetic */ CTSystemColorImpl b;

    public /* synthetic */ V1(CTSystemColorImpl cTSystemColorImpl, int i5) {
        this.f5961a = i5;
        this.b = cTSystemColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5961a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getInvGammaArray(iIntValue);
            case 1:
                return this.b.insertNewInvGamma(iIntValue);
            case 2:
                return this.b.getHueModArray(iIntValue);
            case 3:
                return this.b.insertNewHueMod(iIntValue);
            case 4:
                return this.b.getBlueOffArray(iIntValue);
            case 5:
                return this.b.insertNewBlueOff(iIntValue);
            case 6:
                return this.b.getAlphaModArray(iIntValue);
            case 7:
                return this.b.insertNewAlphaMod(iIntValue);
            case 8:
                return this.b.getHueOffArray(iIntValue);
            case 9:
                return this.b.getRedModArray(iIntValue);
            case 10:
                return this.b.insertNewRedMod(iIntValue);
            case 11:
                return this.b.getRedArray(iIntValue);
            case 12:
                return this.b.insertNewRed(iIntValue);
            case 13:
                return this.b.getInvArray(iIntValue);
            case 14:
                return this.b.insertNewInv(iIntValue);
            case 15:
                return this.b.getAlphaOffArray(iIntValue);
            case 16:
                return this.b.insertNewAlphaOff(iIntValue);
            case 17:
                return this.b.insertNewHueOff(iIntValue);
            case 18:
                return this.b.getSatOffArray(iIntValue);
            case 19:
                return this.b.insertNewSatOff(iIntValue);
            case 20:
                return this.b.getLumModArray(iIntValue);
            case 21:
                return this.b.insertNewLumMod(iIntValue);
            case 22:
                return this.b.getGreenArray(iIntValue);
            case 23:
                return this.b.insertNewGreen(iIntValue);
            case 24:
                return this.b.getGreenOffArray(iIntValue);
            default:
                return this.b.insertNewGreenOff(iIntValue);
        }
    }
}
