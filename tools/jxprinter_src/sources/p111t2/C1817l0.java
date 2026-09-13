package p111t2;

import com.microsoft.schemas.vml.impl.CTRectImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1817l0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8629a;
    public final /* synthetic */ CTRectImpl b;

    public /* synthetic */ C1817l0(CTRectImpl cTRectImpl, int i5) {
        this.f8629a = i5;
        this.b = cTRectImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8629a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewBorderright(iIntValue);
            case 1:
                return this.b.getPathArray(iIntValue);
            case 2:
                return this.b.insertNewPath(iIntValue);
            case 3:
                return this.b.getStrokeArray(iIntValue);
            case 4:
                return this.b.insertNewStroke(iIntValue);
            case 5:
                return this.b.getCalloutArray(iIntValue);
            case 6:
                return this.b.insertNewCallout(iIntValue);
            case 7:
                return this.b.insertNewBorderbottom(iIntValue);
            case 8:
                return this.b.getFormulasArray(iIntValue);
            case 9:
                return this.b.insertNewFormulas(iIntValue);
            case 10:
                return this.b.getSkewArray(iIntValue);
            case 11:
                return this.b.insertNewSkew(iIntValue);
            case 12:
                return this.b.getHandlesArray(iIntValue);
            case 13:
                return this.b.insertNewHandles(iIntValue);
            case 14:
                return this.b.getFillArray(iIntValue);
            default:
                return this.b.insertNewFill(iIntValue);
        }
    }
}
