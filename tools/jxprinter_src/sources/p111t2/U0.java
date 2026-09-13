package p111t2;

import com.microsoft.schemas.vml.impl.CTShapetypeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class U0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8587a;
    public final /* synthetic */ CTShapetypeImpl b;

    public /* synthetic */ U0(CTShapetypeImpl cTShapetypeImpl, int i5) {
        this.f8587a = i5;
        this.b = cTShapetypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8587a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getLockArray(iIntValue);
            case 1:
                return this.b.getCalloutArray(iIntValue);
            case 2:
                return this.b.insertNewCallout(iIntValue);
            case 3:
                return this.b.getWrapArray(iIntValue);
            case 4:
                return this.b.insertNewWrap(iIntValue);
            case 5:
                return this.b.getBordertopArray(iIntValue);
            case 6:
                return this.b.getTextpathArray(iIntValue);
            case 7:
                return this.b.insertNewTextpath(iIntValue);
            case 8:
                return this.b.insertNewBordertop(iIntValue);
            case 9:
                return this.b.getClippathArray(iIntValue);
            case 10:
                return this.b.insertNewClippath(iIntValue);
            case 11:
                return this.b.getHandlesArray(iIntValue);
            case 12:
                return this.b.insertNewHandles(iIntValue);
            case 13:
                return this.b.getFillArray(iIntValue);
            case 14:
                return this.b.insertNewFill(iIntValue);
            case 15:
                return this.b.insertNewLock(iIntValue);
            case 16:
                return this.b.getBorderrightArray(iIntValue);
            case 17:
                return this.b.insertNewBorderright(iIntValue);
            case 18:
                return this.b.getStrokeArray(iIntValue);
            case 19:
                return this.b.insertNewStroke(iIntValue);
            case 20:
                return this.b.getFormulasArray(iIntValue);
            case 21:
                return this.b.insertNewFormulas(iIntValue);
            case 22:
                return this.b.getTextboxArray(iIntValue);
            case 23:
                return this.b.insertNewTextbox(iIntValue);
            case 24:
                return this.b.getBorderbottomArray(iIntValue);
            case 25:
                return this.b.insertNewBorderbottom(iIntValue);
            case 26:
                return this.b.getTextdataArray(iIntValue);
            case 27:
                return this.b.insertNewTextdata(iIntValue);
            case 28:
                return this.b.getBorderleftArray(iIntValue);
            default:
                return this.b.getClientDataArray(iIntValue);
        }
    }
}
