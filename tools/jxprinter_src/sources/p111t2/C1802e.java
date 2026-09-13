package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Supplier;

/* JADX INFO: renamed from: t2.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1802e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8610a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1802e(CTGroupImpl cTGroupImpl, int i5) {
        this.f8610a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSignaturelineArray;
        switch (this.f8610a) {
            case 0:
                iSizeOfSignaturelineArray = this.b.sizeOfSignaturelineArray();
                break;
            case 1:
                iSizeOfSignaturelineArray = this.b.sizeOfRectArray();
                break;
            case 2:
                iSizeOfSignaturelineArray = this.b.sizeOfCalloutArray();
                break;
            case 3:
                iSizeOfSignaturelineArray = this.b.sizeOfArcArray();
                break;
            case 4:
                iSizeOfSignaturelineArray = this.b.sizeOfClippathArray();
                break;
            case 5:
                iSizeOfSignaturelineArray = this.b.sizeOfTextdataArray();
                break;
            case 6:
                iSizeOfSignaturelineArray = this.b.sizeOfRoundrectArray();
                break;
            case 7:
                iSizeOfSignaturelineArray = this.b.sizeOfTextpathArray();
                break;
            case 8:
                iSizeOfSignaturelineArray = this.b.sizeOfTextboxArray();
                break;
            case 9:
                iSizeOfSignaturelineArray = this.b.sizeOfLineArray();
                break;
            case 10:
                iSizeOfSignaturelineArray = this.b.sizeOfHandlesArray();
                break;
            case 11:
                iSizeOfSignaturelineArray = this.b.sizeOfCurveArray();
                break;
            case 12:
                iSizeOfSignaturelineArray = this.b.sizeOfShadowArray();
                break;
            case 13:
                iSizeOfSignaturelineArray = this.b.sizeOfPathArray();
                break;
            case 14:
                iSizeOfSignaturelineArray = this.b.sizeOfLockArray();
                break;
            case 15:
                iSizeOfSignaturelineArray = this.b.sizeOfGroupArray();
                break;
            case 16:
                iSizeOfSignaturelineArray = this.b.sizeOfBorderbottomArray();
                break;
            case 17:
                iSizeOfSignaturelineArray = this.b.sizeOfWrapArray();
                break;
            case 18:
                iSizeOfSignaturelineArray = this.b.sizeOfFormulasArray();
                break;
            case 19:
                iSizeOfSignaturelineArray = this.b.sizeOfBorderleftArray();
                break;
            case 20:
                iSizeOfSignaturelineArray = this.b.sizeOfClientDataArray();
                break;
            case 21:
                iSizeOfSignaturelineArray = this.b.sizeOfImageArray();
                break;
            case 22:
                iSizeOfSignaturelineArray = this.b.sizeOfDiagramArray();
                break;
            case 23:
                iSizeOfSignaturelineArray = this.b.sizeOfExtrusionArray();
                break;
            case 24:
                iSizeOfSignaturelineArray = this.b.sizeOfAnchorlockArray();
                break;
            case 25:
                iSizeOfSignaturelineArray = this.b.sizeOfStrokeArray();
                break;
            case 26:
                iSizeOfSignaturelineArray = this.b.sizeOfFillArray();
                break;
            case 27:
                iSizeOfSignaturelineArray = this.b.sizeOfOvalArray();
                break;
            case 28:
                iSizeOfSignaturelineArray = this.b.sizeOfBorderrightArray();
                break;
            default:
                iSizeOfSignaturelineArray = this.b.sizeOfImagedataArray();
                break;
        }
        return Integer.valueOf(iSizeOfSignaturelineArray);
    }
}
