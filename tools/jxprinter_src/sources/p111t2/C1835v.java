package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Supplier;

/* JADX INFO: renamed from: t2.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1835v implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8648a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1835v(CTGroupImpl cTGroupImpl, int i5) {
        this.f8648a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSkewArray;
        switch (this.f8648a) {
            case 0:
                iSizeOfSkewArray = this.b.sizeOfSkewArray();
                break;
            case 1:
                iSizeOfSkewArray = this.b.sizeOfPolylineArray();
                break;
            case 2:
                iSizeOfSkewArray = this.b.sizeOfShapetypeArray();
                break;
            case 3:
                iSizeOfSkewArray = this.b.sizeOfShapeArray();
                break;
            default:
                iSizeOfSkewArray = this.b.sizeOfBordertopArray();
                break;
        }
        return Integer.valueOf(iSizeOfSkewArray);
    }
}
