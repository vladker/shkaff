package p111t2;

import com.microsoft.schemas.vml.impl.CTOvalImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class P implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8577a;
    public final /* synthetic */ CTOvalImpl b;

    public /* synthetic */ P(CTOvalImpl cTOvalImpl, int i5) {
        this.f8577a = i5;
        this.b = cTOvalImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSkewArray;
        switch (this.f8577a) {
            case 0:
                iSizeOfSkewArray = this.b.sizeOfSkewArray();
                break;
            case 1:
                iSizeOfSkewArray = this.b.sizeOfExtrusionArray();
                break;
            case 2:
                iSizeOfSkewArray = this.b.sizeOfBorderrightArray();
                break;
            case 3:
                iSizeOfSkewArray = this.b.sizeOfClippathArray();
                break;
            case 4:
                iSizeOfSkewArray = this.b.sizeOfBordertopArray();
                break;
            case 5:
                iSizeOfSkewArray = this.b.sizeOfBorderleftArray();
                break;
            case 6:
                iSizeOfSkewArray = this.b.sizeOfSignaturelineArray();
                break;
            case 7:
                iSizeOfSkewArray = this.b.sizeOfShadowArray();
                break;
            case 8:
                iSizeOfSkewArray = this.b.sizeOfTextboxArray();
                break;
            case 9:
                iSizeOfSkewArray = this.b.sizeOfAnchorlockArray();
                break;
            case 10:
                iSizeOfSkewArray = this.b.sizeOfStrokeArray();
                break;
            case 11:
                iSizeOfSkewArray = this.b.sizeOfCalloutArray();
                break;
            case 12:
                iSizeOfSkewArray = this.b.sizeOfBorderbottomArray();
                break;
            case 13:
                iSizeOfSkewArray = this.b.sizeOfTextpathArray();
                break;
            case 14:
                iSizeOfSkewArray = this.b.sizeOfTextdataArray();
                break;
            case 15:
                iSizeOfSkewArray = this.b.sizeOfImagedataArray();
                break;
            case 16:
                iSizeOfSkewArray = this.b.sizeOfClientDataArray();
                break;
            case 17:
                iSizeOfSkewArray = this.b.sizeOfLockArray();
                break;
            case 18:
                iSizeOfSkewArray = this.b.sizeOfPathArray();
                break;
            case 19:
                iSizeOfSkewArray = this.b.sizeOfHandlesArray();
                break;
            case 20:
                iSizeOfSkewArray = this.b.sizeOfFillArray();
                break;
            case 21:
                iSizeOfSkewArray = this.b.sizeOfFormulasArray();
                break;
            default:
                iSizeOfSkewArray = this.b.sizeOfWrapArray();
                break;
        }
        return Integer.valueOf(iSizeOfSkewArray);
    }
}
