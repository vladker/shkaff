package p111t2;

import com.microsoft.schemas.vml.impl.CTShapetypeImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8612a;
    public final /* synthetic */ CTShapetypeImpl b;

    public /* synthetic */ e1(CTShapetypeImpl cTShapetypeImpl, int i5) {
        this.f8612a = i5;
        this.b = cTShapetypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8612a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewClientData(iIntValue);
            case 1:
                return this.b.getAnchorlockArray(iIntValue);
            case 2:
                return this.b.insertNewAnchorlock(iIntValue);
            case 3:
                return this.b.getShadowArray(iIntValue);
            case 4:
                return this.b.insertNewShadow(iIntValue);
            case 5:
                return this.b.getExtrusionArray(iIntValue);
            case 6:
                return this.b.insertNewExtrusion(iIntValue);
            case 7:
                return this.b.insertNewBorderleft(iIntValue);
            case 8:
                return this.b.getSkewArray(iIntValue);
            case 9:
                return this.b.insertNewSkew(iIntValue);
            case 10:
                return this.b.getImagedataArray(iIntValue);
            case 11:
                return this.b.insertNewImagedata(iIntValue);
            case 12:
                return this.b.getSignaturelineArray(iIntValue);
            case 13:
                return this.b.insertNewSignatureline(iIntValue);
            case 14:
                return this.b.getPathArray(iIntValue);
            default:
                return this.b.insertNewPath(iIntValue);
        }
    }
}
