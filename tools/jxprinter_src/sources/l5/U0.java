package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPresetColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class U0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5957a;
    public final /* synthetic */ CTPresetColorImpl b;

    public /* synthetic */ U0(CTPresetColorImpl cTPresetColorImpl, int i5) {
        this.f5957a = i5;
        this.b = cTPresetColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfGreenModArray;
        switch (this.f5957a) {
            case 0:
                iSizeOfGreenModArray = this.b.sizeOfGreenModArray();
                break;
            case 1:
                iSizeOfGreenModArray = this.b.sizeOfHueModArray();
                break;
            case 2:
                iSizeOfGreenModArray = this.b.sizeOfRedModArray();
                break;
            case 3:
                iSizeOfGreenModArray = this.b.sizeOfInvArray();
                break;
            case 4:
                iSizeOfGreenModArray = this.b.sizeOfBlueModArray();
                break;
            case 5:
                iSizeOfGreenModArray = this.b.sizeOfAlphaOffArray();
                break;
            case 6:
                iSizeOfGreenModArray = this.b.sizeOfGammaArray();
                break;
            case 7:
                iSizeOfGreenModArray = this.b.sizeOfShadeArray();
                break;
            case 8:
                iSizeOfGreenModArray = this.b.sizeOfGreenArray();
                break;
            case 9:
                iSizeOfGreenModArray = this.b.sizeOfLumArray();
                break;
            case 10:
                iSizeOfGreenModArray = this.b.sizeOfHueOffArray();
                break;
            case 11:
                iSizeOfGreenModArray = this.b.sizeOfTintArray();
                break;
            case 12:
                iSizeOfGreenModArray = this.b.sizeOfRedOffArray();
                break;
            case 13:
                iSizeOfGreenModArray = this.b.sizeOfBlueArray();
                break;
            case 14:
                iSizeOfGreenModArray = this.b.sizeOfSatArray();
                break;
            case 15:
                iSizeOfGreenModArray = this.b.sizeOfSatOffArray();
                break;
            case 16:
                iSizeOfGreenModArray = this.b.sizeOfAlphaArray();
                break;
            case 17:
                iSizeOfGreenModArray = this.b.sizeOfCompArray();
                break;
            case 18:
                iSizeOfGreenModArray = this.b.sizeOfGrayArray();
                break;
            case 19:
                iSizeOfGreenModArray = this.b.sizeOfGreenOffArray();
                break;
            case 20:
                iSizeOfGreenModArray = this.b.sizeOfLumOffArray();
                break;
            case 21:
                iSizeOfGreenModArray = this.b.sizeOfHueArray();
                break;
            case 22:
                iSizeOfGreenModArray = this.b.sizeOfLumModArray();
                break;
            case 23:
                iSizeOfGreenModArray = this.b.sizeOfAlphaModArray();
                break;
            case 24:
                iSizeOfGreenModArray = this.b.sizeOfRedArray();
                break;
            case 25:
                iSizeOfGreenModArray = this.b.sizeOfInvGammaArray();
                break;
            case 26:
                iSizeOfGreenModArray = this.b.sizeOfSatModArray();
                break;
            default:
                iSizeOfGreenModArray = this.b.sizeOfBlueOffArray();
                break;
        }
        return Integer.valueOf(iSizeOfGreenModArray);
    }
}
