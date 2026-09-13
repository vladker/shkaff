package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectContainerImpl;

/* JADX INFO: renamed from: l5.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1165b0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5979a;
    public final /* synthetic */ CTEffectContainerImpl b;

    public /* synthetic */ C1165b0(CTEffectContainerImpl cTEffectContainerImpl, int i5) {
        this.f5979a = i5;
        this.b = cTEffectContainerImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5979a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAlphaBiLevelArray(iIntValue);
            case 1:
                return this.b.insertNewAlphaBiLevel(iIntValue);
            case 2:
                return this.b.getAlphaReplArray(iIntValue);
            case 3:
                return this.b.insertNewAlphaRepl(iIntValue);
            case 4:
                return this.b.getBlurArray(iIntValue);
            case 5:
                return this.b.insertNewBlur(iIntValue);
            case 6:
                return this.b.getXfrmArray(iIntValue);
            case 7:
                return this.b.insertNewXfrm(iIntValue);
            case 8:
                return this.b.getClrReplArray(iIntValue);
            case 9:
                return this.b.insertNewClrRepl(iIntValue);
            case 10:
                return this.b.getContArray(iIntValue);
            case 11:
                return this.b.insertNewCont(iIntValue);
            case 12:
                return this.b.getAlphaModFixArray(iIntValue);
            case 13:
                return this.b.getSoftEdgeArray(iIntValue);
            case 14:
                return this.b.insertNewSoftEdge(iIntValue);
            case 15:
                return this.b.getDuotoneArray(iIntValue);
            case 16:
                return this.b.insertNewDuotone(iIntValue);
            case 17:
                return this.b.getHslArray(iIntValue);
            case 18:
                return this.b.insertNewHsl(iIntValue);
            case 19:
                return this.b.getLumArray(iIntValue);
            case 20:
                return this.b.insertNewLum(iIntValue);
            case 21:
                return this.b.insertNewAlphaModFix(iIntValue);
            case 22:
                return this.b.getAlphaModArray(iIntValue);
            case 23:
                return this.b.insertNewAlphaMod(iIntValue);
            case 24:
                return this.b.getGlowArray(iIntValue);
            case 25:
                return this.b.insertNewGlow(iIntValue);
            case 26:
                return this.b.getOuterShdwArray(iIntValue);
            case 27:
                return this.b.insertNewOuterShdw(iIntValue);
            case 28:
                return this.b.getFillArray(iIntValue);
            default:
                return this.b.insertNewFill(iIntValue);
        }
    }
}
