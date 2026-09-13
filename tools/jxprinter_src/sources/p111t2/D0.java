package p111t2;

import com.microsoft.schemas.vml.impl.CTShapeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class D0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8554a;
    public final /* synthetic */ CTShapeImpl b;

    public /* synthetic */ D0(CTShapeImpl cTShapeImpl, int i5) {
        this.f8554a = i5;
        this.b = cTShapeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8554a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSkewArray(iIntValue);
            case 1:
                return this.b.getImagedataArray(iIntValue);
            case 2:
                return this.b.insertNewImagedata(iIntValue);
            case 3:
                return this.b.getWrapArray(iIntValue);
            case 4:
                return this.b.insertNewWrap(iIntValue);
            case 5:
                return this.b.getIscommentArray(iIntValue);
            case 6:
                return this.b.getEquationxmlArray(iIntValue);
            case 7:
                return this.b.insertNewEquationxml(iIntValue);
            case 8:
                return this.b.getTextpathArray(iIntValue);
            case 9:
                return this.b.insertNewTextpath(iIntValue);
            case 10:
                return this.b.getHandlesArray(iIntValue);
            case 11:
                return this.b.insertNewHandles(iIntValue);
            case 12:
                return this.b.getBordertopArray(iIntValue);
            case 13:
                return this.b.insertNewBordertop(iIntValue);
            case 14:
                return this.b.insertNewIscomment(iIntValue);
            case 15:
                return this.b.getCalloutArray(iIntValue);
            case 16:
                return this.b.insertNewCallout(iIntValue);
            case 17:
                return this.b.getExtrusionArray(iIntValue);
            case 18:
                return this.b.insertNewExtrusion(iIntValue);
            case 19:
                return this.b.getLockArray(iIntValue);
            case 20:
                return this.b.insertNewLock(iIntValue);
            case 21:
                return this.b.insertNewSkew(iIntValue);
            case 22:
                return this.b.getFormulasArray(iIntValue);
            case 23:
                return this.b.insertNewFormulas(iIntValue);
            case 24:
                return this.b.getTextboxArray(iIntValue);
            case 25:
                return this.b.insertNewTextbox(iIntValue);
            case 26:
                return this.b.getBorderleftArray(iIntValue);
            case 27:
                return this.b.insertNewBorderleft(iIntValue);
            case 28:
                return this.b.getInkArray(iIntValue);
            default:
                return this.b.insertNewInk(iIntValue);
        }
    }
}
