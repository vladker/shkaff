package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetViewImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class T0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8015a;
    public final /* synthetic */ CTSheetViewImpl b;

    public /* synthetic */ T0(CTSheetViewImpl cTSheetViewImpl, int i5) {
        this.f8015a = i5;
        this.b = cTSheetViewImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSelectionArray;
        switch (this.f8015a) {
            case 0:
                iSizeOfSelectionArray = this.b.sizeOfSelectionArray();
                break;
            default:
                iSizeOfSelectionArray = this.b.sizeOfPivotSelectionArray();
                break;
        }
        return Integer.valueOf(iSizeOfSelectionArray);
    }
}
