package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTScRgbColorImpl;

/* JADX INFO: renamed from: l5.x1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1231x1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6057a;
    public final /* synthetic */ CTScRgbColorImpl b;

    public /* synthetic */ C1231x1(CTScRgbColorImpl cTScRgbColorImpl, int i5) {
        this.f6057a = i5;
        this.b = cTScRgbColorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6057a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSatModArray(iIntValue);
            case 1:
                return this.b.insertNewSatMod(iIntValue);
            case 2:
                return this.b.getBlueModArray(iIntValue);
            case 3:
                return this.b.insertNewBlueMod(iIntValue);
            case 4:
                return this.b.getGammaArray(iIntValue);
            case 5:
                return this.b.insertNewGamma(iIntValue);
            case 6:
                return this.b.getTintArray(iIntValue);
            case 7:
                return this.b.insertNewTint(iIntValue);
            case 8:
                return this.b.getSatOffArray(iIntValue);
            case 9:
                return this.b.getHueArray(iIntValue);
            case 10:
                return this.b.insertNewHue(iIntValue);
            case 11:
                return this.b.getBlueArray(iIntValue);
            case 12:
                return this.b.insertNewBlue(iIntValue);
            case 13:
                return this.b.getRedModArray(iIntValue);
            case 14:
                return this.b.insertNewRedMod(iIntValue);
            case 15:
                return this.b.getGrayArray(iIntValue);
            case 16:
                return this.b.insertNewGray(iIntValue);
            case 17:
                return this.b.insertNewSatOff(iIntValue);
            case 18:
                return this.b.getGreenArray(iIntValue);
            case 19:
                return this.b.insertNewGreen(iIntValue);
            case 20:
                return this.b.getLumModArray(iIntValue);
            case 21:
                return this.b.insertNewLumMod(iIntValue);
            case 22:
                return this.b.getRedArray(iIntValue);
            case 23:
                return this.b.insertNewRed(iIntValue);
            case 24:
                return this.b.getAlphaOffArray(iIntValue);
            default:
                return this.b.insertNewAlphaOff(iIntValue);
        }
    }
}
