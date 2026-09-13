package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1814k implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8626a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1814k(CTGroupImpl cTGroupImpl, int i5) {
        this.f8626a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8626a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getLockArray(iIntValue);
            case 1:
                return this.b.insertNewLock(iIntValue);
            case 2:
                return this.b.getGroupArray(iIntValue);
            case 3:
                return this.b.insertNewGroup(iIntValue);
            case 4:
                return this.b.insertNewBorderbottom(iIntValue);
            case 5:
                return this.b.getWrapArray(iIntValue);
            case 6:
                return this.b.insertNewWrap(iIntValue);
            case 7:
                return this.b.getFormulasArray(iIntValue);
            case 8:
                return this.b.insertNewFormulas(iIntValue);
            case 9:
                return this.b.insertNewExtrusion(iIntValue);
            case 10:
                return this.b.getBorderleftArray(iIntValue);
            case 11:
                return this.b.insertNewBorderleft(iIntValue);
            case 12:
                return this.b.getClientDataArray(iIntValue);
            case 13:
                return this.b.insertNewClientData(iIntValue);
            case 14:
                return this.b.getImageArray(iIntValue);
            case 15:
                return this.b.insertNewImage(iIntValue);
            case 16:
                return this.b.getDiagramArray(iIntValue);
            case 17:
                return this.b.insertNewDiagram(iIntValue);
            case 18:
                return this.b.getAnchorlockArray(iIntValue);
            case 19:
                return this.b.insertNewAnchorlock(iIntValue);
            case 20:
                return this.b.getStrokeArray(iIntValue);
            case 21:
                return this.b.insertNewStroke(iIntValue);
            case 22:
                return this.b.getBordertopArray(iIntValue);
            case 23:
                return this.b.getFillArray(iIntValue);
            case 24:
                return this.b.insertNewFill(iIntValue);
            case 25:
                return this.b.getOvalArray(iIntValue);
            case 26:
                return this.b.insertNewOval(iIntValue);
            case 27:
                return this.b.getBorderrightArray(iIntValue);
            case 28:
                return this.b.insertNewBorderright(iIntValue);
            default:
                return this.b.getImagedataArray(iIntValue);
        }
    }
}
