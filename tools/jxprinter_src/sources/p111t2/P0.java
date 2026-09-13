package p111t2;

import com.microsoft.schemas.vml.impl.CTShapeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class P0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8578a;
    public final /* synthetic */ CTShapeImpl b;

    public /* synthetic */ P0(CTShapeImpl cTShapeImpl, int i5) {
        this.f8578a = i5;
        this.b = cTShapeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8578a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getClippathArray(iIntValue);
            case 1:
                return this.b.insertNewClippath(iIntValue);
            case 2:
                return this.b.getBorderbottomArray(iIntValue);
            case 3:
                return this.b.insertNewBorderbottom(iIntValue);
            case 4:
                return this.b.getTextdataArray(iIntValue);
            case 5:
                return this.b.getFillArray(iIntValue);
            case 6:
                return this.b.insertNewFill(iIntValue);
            case 7:
                return this.b.getAnchorlockArray(iIntValue);
            case 8:
                return this.b.insertNewAnchorlock(iIntValue);
            case 9:
                return this.b.getSignaturelineArray(iIntValue);
            case 10:
                return this.b.insertNewSignatureline(iIntValue);
            case 11:
                return this.b.getStrokeArray(iIntValue);
            case 12:
                return this.b.insertNewStroke(iIntValue);
            case 13:
                return this.b.insertNewTextdata(iIntValue);
            case 14:
                return this.b.getBorderrightArray(iIntValue);
            case 15:
                return this.b.insertNewBorderright(iIntValue);
            case 16:
                return this.b.getShadowArray(iIntValue);
            case 17:
                return this.b.insertNewShadow(iIntValue);
            case 18:
                return this.b.getPathArray(iIntValue);
            case 19:
                return this.b.insertNewPath(iIntValue);
            case 20:
                return this.b.getClientDataArray(iIntValue);
            default:
                return this.b.insertNewClientData(iIntValue);
        }
    }
}
