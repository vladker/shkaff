package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTSchemeColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class E1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5911a;
    public final /* synthetic */ CTSchemeColorImpl b;

    public /* synthetic */ E1(CTSchemeColorImpl cTSchemeColorImpl, int i5) {
        this.f5911a = i5;
        this.b = cTSchemeColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfHueOffArray;
        switch (this.f5911a) {
            case 0:
                iSizeOfHueOffArray = this.b.sizeOfHueOffArray();
                break;
            case 1:
                iSizeOfHueOffArray = this.b.sizeOfAlphaModArray();
                break;
            case 2:
                iSizeOfHueOffArray = this.b.sizeOfSatArray();
                break;
            case 3:
                iSizeOfHueOffArray = this.b.sizeOfAlphaOffArray();
                break;
            case 4:
                iSizeOfHueOffArray = this.b.sizeOfGammaArray();
                break;
            case 5:
                iSizeOfHueOffArray = this.b.sizeOfRedModArray();
                break;
            case 6:
                iSizeOfHueOffArray = this.b.sizeOfBlueModArray();
                break;
            case 7:
                iSizeOfHueOffArray = this.b.sizeOfShadeArray();
                break;
            case 8:
                iSizeOfHueOffArray = this.b.sizeOfRedOffArray();
                break;
            case 9:
                iSizeOfHueOffArray = this.b.sizeOfInvGammaArray();
                break;
            case 10:
                iSizeOfHueOffArray = this.b.sizeOfBlueArray();
                break;
            case 11:
                iSizeOfHueOffArray = this.b.sizeOfAlphaArray();
                break;
            case 12:
                iSizeOfHueOffArray = this.b.sizeOfBlueOffArray();
                break;
            case 13:
                iSizeOfHueOffArray = this.b.sizeOfSatModArray();
                break;
            case 14:
                iSizeOfHueOffArray = this.b.sizeOfLumModArray();
                break;
            case 15:
                iSizeOfHueOffArray = this.b.sizeOfRedArray();
                break;
            case 16:
                iSizeOfHueOffArray = this.b.sizeOfLumArray();
                break;
            case 17:
                iSizeOfHueOffArray = this.b.sizeOfInvArray();
                break;
            case 18:
                iSizeOfHueOffArray = this.b.sizeOfSatOffArray();
                break;
            case 19:
                iSizeOfHueOffArray = this.b.sizeOfHueModArray();
                break;
            case 20:
                iSizeOfHueOffArray = this.b.sizeOfGreenOffArray();
                break;
            case 21:
                iSizeOfHueOffArray = this.b.sizeOfLumOffArray();
                break;
            case 22:
                iSizeOfHueOffArray = this.b.sizeOfTintArray();
                break;
            case 23:
                iSizeOfHueOffArray = this.b.sizeOfHueArray();
                break;
            case 24:
                iSizeOfHueOffArray = this.b.sizeOfCompArray();
                break;
            case 25:
                iSizeOfHueOffArray = this.b.sizeOfGreenArray();
                break;
            case 26:
                iSizeOfHueOffArray = this.b.sizeOfGreenModArray();
                break;
            default:
                iSizeOfHueOffArray = this.b.sizeOfGrayArray();
                break;
        }
        return Integer.valueOf(iSizeOfHueOffArray);
    }
}
