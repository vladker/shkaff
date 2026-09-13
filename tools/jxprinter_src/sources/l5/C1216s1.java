package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTScRgbColorImpl;

/* JADX INFO: renamed from: l5.s1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1216s1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6042a;
    public final /* synthetic */ CTScRgbColorImpl b;

    public /* synthetic */ C1216s1(CTScRgbColorImpl cTScRgbColorImpl, int i5) {
        this.f6042a = i5;
        this.b = cTScRgbColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfRedOffArray;
        switch (this.f6042a) {
            case 0:
                iSizeOfRedOffArray = this.b.sizeOfRedOffArray();
                break;
            case 1:
                iSizeOfRedOffArray = this.b.sizeOfInvArray();
                break;
            case 2:
                iSizeOfRedOffArray = this.b.sizeOfHueModArray();
                break;
            case 3:
                iSizeOfRedOffArray = this.b.sizeOfLumArray();
                break;
            case 4:
                iSizeOfRedOffArray = this.b.sizeOfBlueOffArray();
                break;
            case 5:
                iSizeOfRedOffArray = this.b.sizeOfAlphaArray();
                break;
            case 6:
                iSizeOfRedOffArray = this.b.sizeOfAlphaModArray();
                break;
            case 7:
                iSizeOfRedOffArray = this.b.sizeOfHueOffArray();
                break;
            case 8:
                iSizeOfRedOffArray = this.b.sizeOfSatArray();
                break;
            case 9:
                iSizeOfRedOffArray = this.b.sizeOfInvGammaArray();
                break;
            case 10:
                iSizeOfRedOffArray = this.b.sizeOfGreenModArray();
                break;
            case 11:
                iSizeOfRedOffArray = this.b.sizeOfCompArray();
                break;
            case 12:
                iSizeOfRedOffArray = this.b.sizeOfLumOffArray();
                break;
            case 13:
                iSizeOfRedOffArray = this.b.sizeOfShadeArray();
                break;
            case 14:
                iSizeOfRedOffArray = this.b.sizeOfSatModArray();
                break;
            case 15:
                iSizeOfRedOffArray = this.b.sizeOfBlueModArray();
                break;
            case 16:
                iSizeOfRedOffArray = this.b.sizeOfGreenOffArray();
                break;
            case 17:
                iSizeOfRedOffArray = this.b.sizeOfGammaArray();
                break;
            case 18:
                iSizeOfRedOffArray = this.b.sizeOfTintArray();
                break;
            case 19:
                iSizeOfRedOffArray = this.b.sizeOfHueArray();
                break;
            case 20:
                iSizeOfRedOffArray = this.b.sizeOfBlueArray();
                break;
            case 21:
                iSizeOfRedOffArray = this.b.sizeOfRedModArray();
                break;
            case 22:
                iSizeOfRedOffArray = this.b.sizeOfGrayArray();
                break;
            case 23:
                iSizeOfRedOffArray = this.b.sizeOfGreenArray();
                break;
            case 24:
                iSizeOfRedOffArray = this.b.sizeOfLumModArray();
                break;
            case 25:
                iSizeOfRedOffArray = this.b.sizeOfRedArray();
                break;
            case 26:
                iSizeOfRedOffArray = this.b.sizeOfAlphaOffArray();
                break;
            default:
                iSizeOfRedOffArray = this.b.sizeOfSatOffArray();
                break;
        }
        return Integer.valueOf(iSizeOfRedOffArray);
    }
}
