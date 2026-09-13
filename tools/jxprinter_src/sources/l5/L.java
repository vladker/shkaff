package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectContainerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class L implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5930a;
    public final /* synthetic */ CTEffectContainerImpl b;

    public /* synthetic */ L(CTEffectContainerImpl cTEffectContainerImpl, int i5) {
        this.f5930a = i5;
        this.b = cTEffectContainerImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfRelOffArray;
        switch (this.f5930a) {
            case 0:
                iSizeOfRelOffArray = this.b.sizeOfRelOffArray();
                break;
            case 1:
                iSizeOfRelOffArray = this.b.sizeOfAlphaOutsetArray();
                break;
            case 2:
                iSizeOfRelOffArray = this.b.sizeOfFillOverlayArray();
                break;
            case 3:
                iSizeOfRelOffArray = this.b.sizeOfAlphaInvArray();
                break;
            case 4:
                iSizeOfRelOffArray = this.b.sizeOfTintArray();
                break;
            case 5:
                iSizeOfRelOffArray = this.b.sizeOfClrChangeArray();
                break;
            case 6:
                iSizeOfRelOffArray = this.b.sizeOfAlphaCeilingArray();
                break;
            case 7:
                iSizeOfRelOffArray = this.b.sizeOfBiLevelArray();
                break;
            case 8:
                iSizeOfRelOffArray = this.b.sizeOfEffectArray();
                break;
            case 9:
                iSizeOfRelOffArray = this.b.sizeOfBlendArray();
                break;
            case 10:
                iSizeOfRelOffArray = this.b.sizeOfGraysclArray();
                break;
            case 11:
                iSizeOfRelOffArray = this.b.sizeOfReflectionArray();
                break;
            case 12:
                iSizeOfRelOffArray = this.b.sizeOfPrstShdwArray();
                break;
            case 13:
                iSizeOfRelOffArray = this.b.sizeOfAlphaFloorArray();
                break;
            case 14:
                iSizeOfRelOffArray = this.b.sizeOfAlphaBiLevelArray();
                break;
            case 15:
                iSizeOfRelOffArray = this.b.sizeOfAlphaReplArray();
                break;
            case 16:
                iSizeOfRelOffArray = this.b.sizeOfBlurArray();
                break;
            case 17:
                iSizeOfRelOffArray = this.b.sizeOfXfrmArray();
                break;
            case 18:
                iSizeOfRelOffArray = this.b.sizeOfInnerShdwArray();
                break;
            case 19:
                iSizeOfRelOffArray = this.b.sizeOfClrReplArray();
                break;
            case 20:
                iSizeOfRelOffArray = this.b.sizeOfContArray();
                break;
            case 21:
                iSizeOfRelOffArray = this.b.sizeOfSoftEdgeArray();
                break;
            case 22:
                iSizeOfRelOffArray = this.b.sizeOfDuotoneArray();
                break;
            case 23:
                iSizeOfRelOffArray = this.b.sizeOfHslArray();
                break;
            case 24:
                iSizeOfRelOffArray = this.b.sizeOfLumArray();
                break;
            case 25:
                iSizeOfRelOffArray = this.b.sizeOfAlphaModArray();
                break;
            case 26:
                iSizeOfRelOffArray = this.b.sizeOfGlowArray();
                break;
            case 27:
                iSizeOfRelOffArray = this.b.sizeOfOuterShdwArray();
                break;
            case 28:
                iSizeOfRelOffArray = this.b.sizeOfFillArray();
                break;
            default:
                iSizeOfRelOffArray = this.b.sizeOfAlphaModFixArray();
                break;
        }
        return Integer.valueOf(iSizeOfRelOffArray);
    }
}
