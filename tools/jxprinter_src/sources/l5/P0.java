package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class P0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5943a;
    public final /* synthetic */ CTPath2DImpl b;

    public /* synthetic */ P0(CTPath2DImpl cTPath2DImpl, int i5) {
        this.f5943a = i5;
        this.b = cTPath2DImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCloseArray;
        switch (this.f5943a) {
            case 0:
                iSizeOfCloseArray = this.b.sizeOfCloseArray();
                break;
            case 1:
                iSizeOfCloseArray = this.b.sizeOfMoveToArray();
                break;
            case 2:
                iSizeOfCloseArray = this.b.sizeOfArcToArray();
                break;
            case 3:
                iSizeOfCloseArray = this.b.sizeOfLnToArray();
                break;
            case 4:
                iSizeOfCloseArray = this.b.sizeOfCubicBezToArray();
                break;
            default:
                iSizeOfCloseArray = this.b.sizeOfQuadBezToArray();
                break;
        }
        return Integer.valueOf(iSizeOfCloseArray);
    }
}
