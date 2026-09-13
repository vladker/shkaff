package p111t2;

import com.microsoft.schemas.vml.impl.CTShapetypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class X0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8593a;
    public final /* synthetic */ CTShapetypeImpl b;

    public /* synthetic */ X0(CTShapetypeImpl cTShapetypeImpl, int i5) {
        this.f8593a = i5;
        this.b = cTShapetypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCalloutArray;
        switch (this.f8593a) {
            case 0:
                iSizeOfCalloutArray = this.b.sizeOfCalloutArray();
                break;
            case 1:
                iSizeOfCalloutArray = this.b.sizeOfWrapArray();
                break;
            case 2:
                iSizeOfCalloutArray = this.b.sizeOfTextpathArray();
                break;
            case 3:
                iSizeOfCalloutArray = this.b.sizeOfBordertopArray();
                break;
            case 4:
                iSizeOfCalloutArray = this.b.sizeOfClippathArray();
                break;
            case 5:
                iSizeOfCalloutArray = this.b.sizeOfHandlesArray();
                break;
            case 6:
                iSizeOfCalloutArray = this.b.sizeOfFillArray();
                break;
            case 7:
                iSizeOfCalloutArray = this.b.sizeOfBorderrightArray();
                break;
            case 8:
                iSizeOfCalloutArray = this.b.sizeOfStrokeArray();
                break;
            case 9:
                iSizeOfCalloutArray = this.b.sizeOfFormulasArray();
                break;
            case 10:
                iSizeOfCalloutArray = this.b.sizeOfTextboxArray();
                break;
            case 11:
                iSizeOfCalloutArray = this.b.sizeOfLockArray();
                break;
            case 12:
                iSizeOfCalloutArray = this.b.sizeOfBorderbottomArray();
                break;
            case 13:
                iSizeOfCalloutArray = this.b.sizeOfTextdataArray();
                break;
            case 14:
                iSizeOfCalloutArray = this.b.sizeOfClientDataArray();
                break;
            case 15:
                iSizeOfCalloutArray = this.b.sizeOfAnchorlockArray();
                break;
            case 16:
                iSizeOfCalloutArray = this.b.sizeOfShadowArray();
                break;
            case 17:
                iSizeOfCalloutArray = this.b.sizeOfExtrusionArray();
                break;
            case 18:
                iSizeOfCalloutArray = this.b.sizeOfSkewArray();
                break;
            case 19:
                iSizeOfCalloutArray = this.b.sizeOfImagedataArray();
                break;
            case 20:
                iSizeOfCalloutArray = this.b.sizeOfSignaturelineArray();
                break;
            case 21:
                iSizeOfCalloutArray = this.b.sizeOfPathArray();
                break;
            default:
                iSizeOfCalloutArray = this.b.sizeOfBorderleftArray();
                break;
        }
        return Integer.valueOf(iSizeOfCalloutArray);
    }
}
