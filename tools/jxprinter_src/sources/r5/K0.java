package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSharedItemsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class K0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7998a;
    public final /* synthetic */ CTSharedItemsImpl b;

    public /* synthetic */ K0(CTSharedItemsImpl cTSharedItemsImpl, int i5) {
        this.f7998a = i5;
        this.b = cTSharedItemsImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMArray;
        switch (this.f7998a) {
            case 0:
                iSizeOfMArray = this.b.sizeOfMArray();
                break;
            case 1:
                iSizeOfMArray = this.b.sizeOfSArray();
                break;
            case 2:
                iSizeOfMArray = this.b.sizeOfBArray();
                break;
            case 3:
                iSizeOfMArray = this.b.sizeOfEArray();
                break;
            case 4:
                iSizeOfMArray = this.b.sizeOfNArray();
                break;
            default:
                iSizeOfMArray = this.b.sizeOfDArray();
                break;
        }
        return Integer.valueOf(iSizeOfMArray);
    }
}
