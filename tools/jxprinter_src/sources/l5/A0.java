package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTHslColorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class A0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5898a;
    public final /* synthetic */ CTHslColorImpl b;

    public /* synthetic */ A0(CTHslColorImpl cTHslColorImpl, int i5) {
        this.f5898a = i5;
        this.b = cTHslColorImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfLumModArray;
        switch (this.f5898a) {
            case 0:
                iSizeOfLumModArray = this.b.sizeOfLumModArray();
                break;
            case 1:
                iSizeOfLumModArray = this.b.sizeOfHueOffArray();
                break;
            case 2:
                iSizeOfLumModArray = this.b.sizeOfRedModArray();
                break;
            case 3:
                iSizeOfLumModArray = this.b.sizeOfInvGammaArray();
                break;
            case 4:
                iSizeOfLumModArray = this.b.sizeOfSatArray();
                break;
            case 5:
                iSizeOfLumModArray = this.b.sizeOfGrayArray();
                break;
            case 6:
                iSizeOfLumModArray = this.b.sizeOfAlphaModArray();
                break;
            case 7:
                iSizeOfLumModArray = this.b.sizeOfGreenArray();
                break;
            case 8:
                iSizeOfLumModArray = this.b.sizeOfHueArray();
                break;
            case 9:
                iSizeOfLumModArray = this.b.sizeOfAlphaOffArray();
                break;
            case 10:
                iSizeOfLumModArray = this.b.sizeOfGreenOffArray();
                break;
            case 11:
                iSizeOfLumModArray = this.b.sizeOfBlueModArray();
                break;
            case 12:
                iSizeOfLumModArray = this.b.sizeOfSatModArray();
                break;
            case 13:
                iSizeOfLumModArray = this.b.sizeOfShadeArray();
                break;
            case 14:
                iSizeOfLumModArray = this.b.sizeOfHueModArray();
                break;
            case 15:
                iSizeOfLumModArray = this.b.sizeOfGreenModArray();
                break;
            case 16:
                iSizeOfLumModArray = this.b.sizeOfRedOffArray();
                break;
            case 17:
                iSizeOfLumModArray = this.b.sizeOfInvArray();
                break;
            case 18:
                iSizeOfLumModArray = this.b.sizeOfBlueArray();
                break;
            case 19:
                iSizeOfLumModArray = this.b.sizeOfTintArray();
                break;
            case 20:
                iSizeOfLumModArray = this.b.sizeOfGammaArray();
                break;
            case 21:
                iSizeOfLumModArray = this.b.sizeOfBlueOffArray();
                break;
            case 22:
                iSizeOfLumModArray = this.b.sizeOfLumOffArray();
                break;
            case 23:
                iSizeOfLumModArray = this.b.sizeOfAlphaArray();
                break;
            case 24:
                iSizeOfLumModArray = this.b.sizeOfSatOffArray();
                break;
            case 25:
                iSizeOfLumModArray = this.b.sizeOfRedArray();
                break;
            case 26:
                iSizeOfLumModArray = this.b.sizeOfLumArray();
                break;
            default:
                iSizeOfLumModArray = this.b.sizeOfCompArray();
                break;
        }
        return Integer.valueOf(iSizeOfLumModArray);
    }
}
