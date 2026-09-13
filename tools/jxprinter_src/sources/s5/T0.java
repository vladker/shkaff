package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class T0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8337a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ T0(CTPImpl cTPImpl, int i5) {
        this.f8337a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDelArray;
        switch (this.f8337a) {
            case 0:
                iSizeOfDelArray = this.b.sizeOfDelArray();
                break;
            case 1:
                iSizeOfDelArray = this.b.sizeOfProofErrArray();
                break;
            case 2:
                iSizeOfDelArray = this.b.sizeOfRArray();
                break;
            default:
                iSizeOfDelArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfDelArray);
    }
}
