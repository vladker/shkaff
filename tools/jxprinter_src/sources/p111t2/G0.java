package p111t2;

import com.microsoft.schemas.vml.impl.CTShapeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class G0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8560a;
    public final /* synthetic */ CTShapeImpl b;

    public /* synthetic */ G0(CTShapeImpl cTShapeImpl, int i5) {
        this.f8560a = i5;
        this.b = cTShapeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfImagedataArray;
        switch (this.f8560a) {
            case 0:
                iSizeOfImagedataArray = this.b.sizeOfImagedataArray();
                break;
            case 1:
                iSizeOfImagedataArray = this.b.sizeOfWrapArray();
                break;
            case 2:
                iSizeOfImagedataArray = this.b.sizeOfEquationxmlArray();
                break;
            case 3:
                iSizeOfImagedataArray = this.b.sizeOfTextpathArray();
                break;
            case 4:
                iSizeOfImagedataArray = this.b.sizeOfHandlesArray();
                break;
            case 5:
                iSizeOfImagedataArray = this.b.sizeOfBordertopArray();
                break;
            case 6:
                iSizeOfImagedataArray = this.b.sizeOfIscommentArray();
                break;
            case 7:
                iSizeOfImagedataArray = this.b.sizeOfCalloutArray();
                break;
            case 8:
                iSizeOfImagedataArray = this.b.sizeOfExtrusionArray();
                break;
            case 9:
                iSizeOfImagedataArray = this.b.sizeOfLockArray();
                break;
            case 10:
                iSizeOfImagedataArray = this.b.sizeOfFormulasArray();
                break;
            case 11:
                iSizeOfImagedataArray = this.b.sizeOfTextboxArray();
                break;
            case 12:
                iSizeOfImagedataArray = this.b.sizeOfBorderleftArray();
                break;
            case 13:
                iSizeOfImagedataArray = this.b.sizeOfInkArray();
                break;
            case 14:
                iSizeOfImagedataArray = this.b.sizeOfSkewArray();
                break;
            case 15:
                iSizeOfImagedataArray = this.b.sizeOfClippathArray();
                break;
            case 16:
                iSizeOfImagedataArray = this.b.sizeOfBorderbottomArray();
                break;
            case 17:
                iSizeOfImagedataArray = this.b.sizeOfFillArray();
                break;
            case 18:
                iSizeOfImagedataArray = this.b.sizeOfAnchorlockArray();
                break;
            case 19:
                iSizeOfImagedataArray = this.b.sizeOfSignaturelineArray();
                break;
            case 20:
                iSizeOfImagedataArray = this.b.sizeOfStrokeArray();
                break;
            case 21:
                iSizeOfImagedataArray = this.b.sizeOfBorderrightArray();
                break;
            case 22:
                iSizeOfImagedataArray = this.b.sizeOfShadowArray();
                break;
            case 23:
                iSizeOfImagedataArray = this.b.sizeOfPathArray();
                break;
            case 24:
                iSizeOfImagedataArray = this.b.sizeOfClientDataArray();
                break;
            default:
                iSizeOfImagedataArray = this.b.sizeOfTextdataArray();
                break;
        }
        return Integer.valueOf(iSizeOfImagedataArray);
    }
}
