package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.RowTypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8218a;
    public final /* synthetic */ RowTypeImpl b;

    public /* synthetic */ n(RowTypeImpl rowTypeImpl, int i5) {
        this.f8218a = i5;
        this.b = rowTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTriggerArray;
        switch (this.f8218a) {
            case 0:
                iSizeOfTriggerArray = this.b.sizeOfTriggerArray();
                break;
            default:
                iSizeOfTriggerArray = this.b.sizeOfCellArray();
                break;
        }
        return Integer.valueOf(iSizeOfTriggerArray);
    }
}
