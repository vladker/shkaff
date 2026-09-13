package p111t2;

import com.microsoft.schemas.vml.impl.CTLineImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8549a;
    public final /* synthetic */ CTLineImpl b;

    public /* synthetic */ B(CTLineImpl cTLineImpl, int i5) {
        this.f8549a = i5;
        this.b = cTLineImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTextdataArray;
        switch (this.f8549a) {
            case 0:
                iSizeOfTextdataArray = this.b.sizeOfTextdataArray();
                break;
            case 1:
                iSizeOfTextdataArray = this.b.sizeOfSignaturelineArray();
                break;
            case 2:
                iSizeOfTextdataArray = this.b.sizeOfCalloutArray();
                break;
            case 3:
                iSizeOfTextdataArray = this.b.sizeOfWrapArray();
                break;
            case 4:
                iSizeOfTextdataArray = this.b.sizeOfHandlesArray();
                break;
            case 5:
                iSizeOfTextdataArray = this.b.sizeOfSkewArray();
                break;
            case 6:
                iSizeOfTextdataArray = this.b.sizeOfFormulasArray();
                break;
            case 7:
                iSizeOfTextdataArray = this.b.sizeOfBordertopArray();
                break;
            case 8:
                iSizeOfTextdataArray = this.b.sizeOfStrokeArray();
                break;
            case 9:
                iSizeOfTextdataArray = this.b.sizeOfClippathArray();
                break;
            case 10:
                iSizeOfTextdataArray = this.b.sizeOfImagedataArray();
                break;
            case 11:
                iSizeOfTextdataArray = this.b.sizeOfShadowArray();
                break;
            case 12:
                iSizeOfTextdataArray = this.b.sizeOfExtrusionArray();
                break;
            case 13:
                iSizeOfTextdataArray = this.b.sizeOfBorderleftArray();
                break;
            case 14:
                iSizeOfTextdataArray = this.b.sizeOfClientDataArray();
                break;
            case 15:
                iSizeOfTextdataArray = this.b.sizeOfBorderbottomArray();
                break;
            case 16:
                iSizeOfTextdataArray = this.b.sizeOfFillArray();
                break;
            case 17:
                iSizeOfTextdataArray = this.b.sizeOfTextpathArray();
                break;
            case 18:
                iSizeOfTextdataArray = this.b.sizeOfPathArray();
                break;
            case 19:
                iSizeOfTextdataArray = this.b.sizeOfTextboxArray();
                break;
            case 20:
                iSizeOfTextdataArray = this.b.sizeOfLockArray();
                break;
            case 21:
                iSizeOfTextdataArray = this.b.sizeOfAnchorlockArray();
                break;
            default:
                iSizeOfTextdataArray = this.b.sizeOfBorderrightArray();
                break;
        }
        return Integer.valueOf(iSizeOfTextdataArray);
    }
}
