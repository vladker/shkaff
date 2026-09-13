package p111t2;

import com.microsoft.schemas.vml.impl.CTRectImpl;
import java.util.function.Supplier;

/* JADX INFO: renamed from: t2.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1803e0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8611a;
    public final /* synthetic */ CTRectImpl b;

    public /* synthetic */ C1803e0(CTRectImpl cTRectImpl, int i5) {
        this.f8611a = i5;
        this.b = cTRectImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBordertopArray;
        switch (this.f8611a) {
            case 0:
                iSizeOfBordertopArray = this.b.sizeOfBordertopArray();
                break;
            case 1:
                iSizeOfBordertopArray = this.b.sizeOfTextboxArray();
                break;
            case 2:
                iSizeOfBordertopArray = this.b.sizeOfAnchorlockArray();
                break;
            case 3:
                iSizeOfBordertopArray = this.b.sizeOfWrapArray();
                break;
            case 4:
                iSizeOfBordertopArray = this.b.sizeOfShadowArray();
                break;
            case 5:
                iSizeOfBordertopArray = this.b.sizeOfExtrusionArray();
                break;
            case 6:
                iSizeOfBordertopArray = this.b.sizeOfClippathArray();
                break;
            case 7:
                iSizeOfBordertopArray = this.b.sizeOfLockArray();
                break;
            case 8:
                iSizeOfBordertopArray = this.b.sizeOfTextdataArray();
                break;
            case 9:
                iSizeOfBordertopArray = this.b.sizeOfTextpathArray();
                break;
            case 10:
                iSizeOfBordertopArray = this.b.sizeOfBorderleftArray();
                break;
            case 11:
                iSizeOfBordertopArray = this.b.sizeOfImagedataArray();
                break;
            case 12:
                iSizeOfBordertopArray = this.b.sizeOfSignaturelineArray();
                break;
            case 13:
                iSizeOfBordertopArray = this.b.sizeOfClientDataArray();
                break;
            case 14:
                iSizeOfBordertopArray = this.b.sizeOfBorderrightArray();
                break;
            case 15:
                iSizeOfBordertopArray = this.b.sizeOfPathArray();
                break;
            case 16:
                iSizeOfBordertopArray = this.b.sizeOfStrokeArray();
                break;
            case 17:
                iSizeOfBordertopArray = this.b.sizeOfCalloutArray();
                break;
            case 18:
                iSizeOfBordertopArray = this.b.sizeOfFormulasArray();
                break;
            case 19:
                iSizeOfBordertopArray = this.b.sizeOfSkewArray();
                break;
            case 20:
                iSizeOfBordertopArray = this.b.sizeOfHandlesArray();
                break;
            case 21:
                iSizeOfBordertopArray = this.b.sizeOfFillArray();
                break;
            default:
                iSizeOfBordertopArray = this.b.sizeOfBorderbottomArray();
                break;
        }
        return Integer.valueOf(iSizeOfBordertopArray);
    }
}
