package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBlipImpl;

/* JADX INFO: renamed from: l5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1185i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6006a;
    public final /* synthetic */ CTBlipImpl b;

    public /* synthetic */ C1185i(CTBlipImpl cTBlipImpl, int i5) {
        this.f6006a = i5;
        this.b = cTBlipImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6006a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getClrReplArray(iIntValue);
            case 1:
                return this.b.getBiLevelArray(iIntValue);
            case 2:
                return this.b.insertNewBiLevel(iIntValue);
            case 3:
                return this.b.getHslArray(iIntValue);
            case 4:
                return this.b.insertNewHsl(iIntValue);
            case 5:
                return this.b.getGraysclArray(iIntValue);
            case 6:
                return this.b.insertNewGrayscl(iIntValue);
            case 7:
                return this.b.getLumArray(iIntValue);
            case 8:
                return this.b.insertNewLum(iIntValue);
            case 9:
                return this.b.insertNewClrRepl(iIntValue);
            case 10:
                return this.b.getAlphaBiLevelArray(iIntValue);
            case 11:
                return this.b.insertNewAlphaBiLevel(iIntValue);
            case 12:
                return this.b.getAlphaInvArray(iIntValue);
            case 13:
                return this.b.insertNewAlphaInv(iIntValue);
            case 14:
                return this.b.getAlphaFloorArray(iIntValue);
            case 15:
                return this.b.insertNewAlphaFloor(iIntValue);
            case 16:
                return this.b.getAlphaReplArray(iIntValue);
            case 17:
                return this.b.insertNewAlphaRepl(iIntValue);
            case 18:
                return this.b.getAlphaModArray(iIntValue);
            case 19:
                return this.b.insertNewAlphaMod(iIntValue);
            case 20:
                return this.b.getAlphaCeilingArray(iIntValue);
            case 21:
                return this.b.insertNewAlphaCeiling(iIntValue);
            case 22:
                return this.b.getAlphaModFixArray(iIntValue);
            case 23:
                return this.b.getFillOverlayArray(iIntValue);
            case 24:
                return this.b.insertNewFillOverlay(iIntValue);
            case 25:
                return this.b.getClrChangeArray(iIntValue);
            case 26:
                return this.b.insertNewClrChange(iIntValue);
            case 27:
                return this.b.getTintArray(iIntValue);
            case 28:
                return this.b.insertNewTint(iIntValue);
            default:
                return this.b.getDuotoneArray(iIntValue);
        }
    }
}
