package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSystemColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Q1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5947a;
    public final /* synthetic */ CTSystemColorImpl b;

    public /* synthetic */ Q1(CTSystemColorImpl cTSystemColorImpl, int i5) {
        this.f5947a = i5;
        this.b = cTSystemColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfHueArray;
        switch (this.f5947a) {
            case 0:
                iSizeOfHueArray = this.b.sizeOfHueArray();
                break;
            case 1:
                iSizeOfHueArray = this.b.sizeOfSatModArray();
                break;
            case 2:
                iSizeOfHueArray = this.b.sizeOfBlueArray();
                break;
            case 3:
                iSizeOfHueArray = this.b.sizeOfSatArray();
                break;
            case 4:
                iSizeOfHueArray = this.b.sizeOfLumArray();
                break;
            case 5:
                iSizeOfHueArray = this.b.sizeOfLumOffArray();
                break;
            case 6:
                iSizeOfHueArray = this.b.sizeOfGrayArray();
                break;
            case 7:
                iSizeOfHueArray = this.b.sizeOfAlphaArray();
                break;
            case 8:
                iSizeOfHueArray = this.b.sizeOfBlueModArray();
                break;
            case 9:
                iSizeOfHueArray = this.b.sizeOfGreenModArray();
                break;
            case 10:
                iSizeOfHueArray = this.b.sizeOfTintArray();
                break;
            case 11:
                iSizeOfHueArray = this.b.sizeOfGammaArray();
                break;
            case 12:
                iSizeOfHueArray = this.b.sizeOfShadeArray();
                break;
            case 13:
                iSizeOfHueArray = this.b.sizeOfRedOffArray();
                break;
            case 14:
                iSizeOfHueArray = this.b.sizeOfInvGammaArray();
                break;
            case 15:
                iSizeOfHueArray = this.b.sizeOfHueModArray();
                break;
            case 16:
                iSizeOfHueArray = this.b.sizeOfCompArray();
                break;
            case 17:
                iSizeOfHueArray = this.b.sizeOfBlueOffArray();
                break;
            case 18:
                iSizeOfHueArray = this.b.sizeOfAlphaModArray();
                break;
            case 19:
                iSizeOfHueArray = this.b.sizeOfRedModArray();
                break;
            case 20:
                iSizeOfHueArray = this.b.sizeOfRedArray();
                break;
            case 21:
                iSizeOfHueArray = this.b.sizeOfInvArray();
                break;
            case 22:
                iSizeOfHueArray = this.b.sizeOfAlphaOffArray();
                break;
            case 23:
                iSizeOfHueArray = this.b.sizeOfSatOffArray();
                break;
            case 24:
                iSizeOfHueArray = this.b.sizeOfLumModArray();
                break;
            case 25:
                iSizeOfHueArray = this.b.sizeOfGreenArray();
                break;
            case 26:
                iSizeOfHueArray = this.b.sizeOfGreenOffArray();
                break;
            default:
                iSizeOfHueArray = this.b.sizeOfHueOffArray();
                break;
        }
        return Integer.valueOf(iSizeOfHueArray);
    }
}
