package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSRgbColorImpl;

/* JADX INFO: renamed from: l5.g1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1181g1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6000a;
    public final /* synthetic */ CTSRgbColorImpl b;

    public /* synthetic */ C1181g1(CTSRgbColorImpl cTSRgbColorImpl, int i5) {
        this.f6000a = i5;
        this.b = cTSRgbColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfHueModArray;
        switch (this.f6000a) {
            case 0:
                iSizeOfHueModArray = this.b.sizeOfHueModArray();
                break;
            case 1:
                iSizeOfHueModArray = this.b.sizeOfBlueOffArray();
                break;
            case 2:
                iSizeOfHueModArray = this.b.sizeOfGammaArray();
                break;
            case 3:
                iSizeOfHueModArray = this.b.sizeOfGreenOffArray();
                break;
            case 4:
                iSizeOfHueModArray = this.b.sizeOfLumOffArray();
                break;
            case 5:
                iSizeOfHueModArray = this.b.sizeOfBlueArray();
                break;
            case 6:
                iSizeOfHueModArray = this.b.sizeOfSatModArray();
                break;
            case 7:
                iSizeOfHueModArray = this.b.sizeOfGrayArray();
                break;
            case 8:
                iSizeOfHueModArray = this.b.sizeOfRedArray();
                break;
            case 9:
                iSizeOfHueModArray = this.b.sizeOfGreenArray();
                break;
            case 10:
                iSizeOfHueModArray = this.b.sizeOfLumModArray();
                break;
            case 11:
                iSizeOfHueModArray = this.b.sizeOfInvGammaArray();
                break;
            case 12:
                iSizeOfHueModArray = this.b.sizeOfAlphaModArray();
                break;
            case 13:
                iSizeOfHueModArray = this.b.sizeOfBlueModArray();
                break;
            case 14:
                iSizeOfHueModArray = this.b.sizeOfHueOffArray();
                break;
            case 15:
                iSizeOfHueModArray = this.b.sizeOfGreenModArray();
                break;
            case 16:
                iSizeOfHueModArray = this.b.sizeOfInvArray();
                break;
            case 17:
                iSizeOfHueModArray = this.b.sizeOfSatArray();
                break;
            case 18:
                iSizeOfHueModArray = this.b.sizeOfLumArray();
                break;
            case 19:
                iSizeOfHueModArray = this.b.sizeOfHueArray();
                break;
            case 20:
                iSizeOfHueModArray = this.b.sizeOfAlphaArray();
                break;
            case 21:
                iSizeOfHueModArray = this.b.sizeOfTintArray();
                break;
            case 22:
                iSizeOfHueModArray = this.b.sizeOfAlphaOffArray();
                break;
            case 23:
                iSizeOfHueModArray = this.b.sizeOfShadeArray();
                break;
            case 24:
                iSizeOfHueModArray = this.b.sizeOfRedModArray();
                break;
            case 25:
                iSizeOfHueModArray = this.b.sizeOfSatOffArray();
                break;
            case 26:
                iSizeOfHueModArray = this.b.sizeOfRedOffArray();
                break;
            default:
                iSizeOfHueModArray = this.b.sizeOfCompArray();
                break;
        }
        return Integer.valueOf(iSizeOfHueModArray);
    }
}
