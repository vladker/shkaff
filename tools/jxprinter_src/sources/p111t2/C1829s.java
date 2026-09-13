package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1829s implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8642a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1829s(CTGroupImpl cTGroupImpl, int i5) {
        this.f8642a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8642a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewImagedata(iIntValue);
            case 1:
                return this.b.insertNewBordertop(iIntValue);
            case 2:
                return this.b.getSkewArray(iIntValue);
            case 3:
                return this.b.insertNewSkew(iIntValue);
            case 4:
                return this.b.getPolylineArray(iIntValue);
            case 5:
                return this.b.insertNewPolyline(iIntValue);
            case 6:
                return this.b.getShapetypeArray(iIntValue);
            case 7:
                return this.b.insertNewShapetype(iIntValue);
            case 8:
                return this.b.getShapeArray(iIntValue);
            default:
                return this.b.insertNewShape(iIntValue);
        }
    }
}
