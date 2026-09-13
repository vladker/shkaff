package p111t2;

import com.microsoft.schemas.vml.impl.CTLineImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1841y implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8654a;
    public final /* synthetic */ CTLineImpl b;

    public /* synthetic */ C1841y(CTLineImpl cTLineImpl, int i5) {
        this.f8654a = i5;
        this.b = cTLineImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8654a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getShadowArray(iIntValue);
            case 1:
                return this.b.getTextdataArray(iIntValue);
            case 2:
                return this.b.insertNewTextdata(iIntValue);
            case 3:
                return this.b.getSignaturelineArray(iIntValue);
            case 4:
                return this.b.insertNewSignatureline(iIntValue);
            case 5:
                return this.b.getWrapArray(iIntValue);
            case 6:
                return this.b.getCalloutArray(iIntValue);
            case 7:
                return this.b.insertNewCallout(iIntValue);
            case 8:
                return this.b.insertNewWrap(iIntValue);
            case 9:
                return this.b.getHandlesArray(iIntValue);
            case 10:
                return this.b.insertNewHandles(iIntValue);
            case 11:
                return this.b.getSkewArray(iIntValue);
            case 12:
                return this.b.insertNewSkew(iIntValue);
            case 13:
                return this.b.getFormulasArray(iIntValue);
            case 14:
                return this.b.insertNewFormulas(iIntValue);
            case 15:
                return this.b.insertNewShadow(iIntValue);
            case 16:
                return this.b.getBordertopArray(iIntValue);
            case 17:
                return this.b.insertNewBordertop(iIntValue);
            case 18:
                return this.b.getStrokeArray(iIntValue);
            case 19:
                return this.b.insertNewStroke(iIntValue);
            case 20:
                return this.b.getClippathArray(iIntValue);
            case 21:
                return this.b.insertNewClippath(iIntValue);
            case 22:
                return this.b.getImagedataArray(iIntValue);
            case 23:
                return this.b.insertNewImagedata(iIntValue);
            case 24:
                return this.b.getExtrusionArray(iIntValue);
            case 25:
                return this.b.insertNewExtrusion(iIntValue);
            case 26:
                return this.b.getBorderleftArray(iIntValue);
            case 27:
                return this.b.insertNewBorderleft(iIntValue);
            case 28:
                return this.b.getBorderrightArray(iIntValue);
            default:
                return this.b.getClientDataArray(iIntValue);
        }
    }
}
