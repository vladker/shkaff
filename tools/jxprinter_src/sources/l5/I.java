package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectContainerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class I implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5921a;
    public final /* synthetic */ CTEffectContainerImpl b;

    public /* synthetic */ I(CTEffectContainerImpl cTEffectContainerImpl, int i5) {
        this.f5921a = i5;
        this.b = cTEffectContainerImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5921a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getInnerShdwArray(iIntValue);
            case 1:
                return this.b.getRelOffArray(iIntValue);
            case 2:
                return this.b.insertNewRelOff(iIntValue);
            case 3:
                return this.b.getAlphaOutsetArray(iIntValue);
            case 4:
                return this.b.insertNewAlphaOutset(iIntValue);
            case 5:
                return this.b.getGraysclArray(iIntValue);
            case 6:
                return this.b.getFillOverlayArray(iIntValue);
            case 7:
                return this.b.insertNewFillOverlay(iIntValue);
            case 8:
                return this.b.getAlphaInvArray(iIntValue);
            case 9:
                return this.b.insertNewAlphaInv(iIntValue);
            case 10:
                return this.b.getTintArray(iIntValue);
            case 11:
                return this.b.insertNewTint(iIntValue);
            case 12:
                return this.b.getClrChangeArray(iIntValue);
            case 13:
                return this.b.insertNewClrChange(iIntValue);
            case 14:
                return this.b.insertNewGrayscl(iIntValue);
            case 15:
                return this.b.getAlphaCeilingArray(iIntValue);
            case 16:
                return this.b.insertNewAlphaCeiling(iIntValue);
            case 17:
                return this.b.getBiLevelArray(iIntValue);
            case 18:
                return this.b.insertNewBiLevel(iIntValue);
            case 19:
                return this.b.getEffectArray(iIntValue);
            case 20:
                return this.b.insertNewEffect(iIntValue);
            case 21:
                return this.b.getBlendArray(iIntValue);
            case 22:
                return this.b.insertNewBlend(iIntValue);
            case 23:
                return this.b.getReflectionArray(iIntValue);
            case 24:
                return this.b.insertNewReflection(iIntValue);
            case 25:
                return this.b.getPrstShdwArray(iIntValue);
            case 26:
                return this.b.insertNewPrstShdw(iIntValue);
            case 27:
                return this.b.getAlphaFloorArray(iIntValue);
            case 28:
                return this.b.insertNewAlphaFloor(iIntValue);
            default:
                return this.b.insertNewInnerShdw(iIntValue);
        }
    }
}
