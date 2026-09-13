package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBlipImpl;

/* JADX INFO: renamed from: l5.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1194l implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6018a;
    public final /* synthetic */ CTBlipImpl b;

    public /* synthetic */ C1194l(CTBlipImpl cTBlipImpl, int i5) {
        this.f6018a = i5;
        this.b = cTBlipImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBiLevelArray;
        switch (this.f6018a) {
            case 0:
                iSizeOfBiLevelArray = this.b.sizeOfBiLevelArray();
                break;
            case 1:
                iSizeOfBiLevelArray = this.b.sizeOfHslArray();
                break;
            case 2:
                iSizeOfBiLevelArray = this.b.sizeOfGraysclArray();
                break;
            case 3:
                iSizeOfBiLevelArray = this.b.sizeOfLumArray();
                break;
            case 4:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaBiLevelArray();
                break;
            case 5:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaInvArray();
                break;
            case 6:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaFloorArray();
                break;
            case 7:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaReplArray();
                break;
            case 8:
                iSizeOfBiLevelArray = this.b.sizeOfClrReplArray();
                break;
            case 9:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaModArray();
                break;
            case 10:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaCeilingArray();
                break;
            case 11:
                iSizeOfBiLevelArray = this.b.sizeOfFillOverlayArray();
                break;
            case 12:
                iSizeOfBiLevelArray = this.b.sizeOfClrChangeArray();
                break;
            case 13:
                iSizeOfBiLevelArray = this.b.sizeOfTintArray();
                break;
            case 14:
                iSizeOfBiLevelArray = this.b.sizeOfDuotoneArray();
                break;
            case 15:
                iSizeOfBiLevelArray = this.b.sizeOfBlurArray();
                break;
            default:
                iSizeOfBiLevelArray = this.b.sizeOfAlphaModFixArray();
                break;
        }
        return Integer.valueOf(iSizeOfBiLevelArray);
    }
}
