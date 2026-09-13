package p111t2;

import com.microsoft.schemas.vml.impl.CTRoundRectImpl;
import java.util.function.Supplier;

/* JADX INFO: renamed from: t2.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1830s0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8643a;
    public final /* synthetic */ CTRoundRectImpl b;

    public /* synthetic */ C1830s0(CTRoundRectImpl cTRoundRectImpl, int i5) {
        this.f8643a = i5;
        this.b = cTRoundRectImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfShadowArray;
        switch (this.f8643a) {
            case 0:
                iSizeOfShadowArray = this.b.sizeOfShadowArray();
                break;
            case 1:
                iSizeOfShadowArray = this.b.sizeOfFillArray();
                break;
            case 2:
                iSizeOfShadowArray = this.b.sizeOfClippathArray();
                break;
            case 3:
                iSizeOfShadowArray = this.b.sizeOfPathArray();
                break;
            case 4:
                iSizeOfShadowArray = this.b.sizeOfBorderleftArray();
                break;
            case 5:
                iSizeOfShadowArray = this.b.sizeOfTextdataArray();
                break;
            case 6:
                iSizeOfShadowArray = this.b.sizeOfHandlesArray();
                break;
            case 7:
                iSizeOfShadowArray = this.b.sizeOfBorderbottomArray();
                break;
            case 8:
                iSizeOfShadowArray = this.b.sizeOfSkewArray();
                break;
            case 9:
                iSizeOfShadowArray = this.b.sizeOfCalloutArray();
                break;
            case 10:
                iSizeOfShadowArray = this.b.sizeOfClientDataArray();
                break;
            case 11:
                iSizeOfShadowArray = this.b.sizeOfFormulasArray();
                break;
            case 12:
                iSizeOfShadowArray = this.b.sizeOfTextboxArray();
                break;
            case 13:
                iSizeOfShadowArray = this.b.sizeOfWrapArray();
                break;
            case 14:
                iSizeOfShadowArray = this.b.sizeOfImagedataArray();
                break;
            case 15:
                iSizeOfShadowArray = this.b.sizeOfSignaturelineArray();
                break;
            case 16:
                iSizeOfShadowArray = this.b.sizeOfTextpathArray();
                break;
            case 17:
                iSizeOfShadowArray = this.b.sizeOfLockArray();
                break;
            case 18:
                iSizeOfShadowArray = this.b.sizeOfExtrusionArray();
                break;
            case 19:
                iSizeOfShadowArray = this.b.sizeOfStrokeArray();
                break;
            case 20:
                iSizeOfShadowArray = this.b.sizeOfAnchorlockArray();
                break;
            case 21:
                iSizeOfShadowArray = this.b.sizeOfBordertopArray();
                break;
            default:
                iSizeOfShadowArray = this.b.sizeOfBorderrightArray();
                break;
        }
        return Integer.valueOf(iSizeOfShadowArray);
    }
}
