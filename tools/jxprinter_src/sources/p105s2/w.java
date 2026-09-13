package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.SheetTypeImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8227a;
    public final /* synthetic */ SheetTypeImpl b;

    public /* synthetic */ w(SheetTypeImpl sheetTypeImpl, int i5) {
        this.f8227a = i5;
        this.b = sheetTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCellArray;
        switch (this.f8227a) {
            case 0:
                iSizeOfCellArray = this.b.sizeOfCellArray();
                break;
            case 1:
                iSizeOfCellArray = this.b.sizeOfSectionArray();
                break;
            default:
                iSizeOfCellArray = this.b.sizeOfTriggerArray();
                break;
        }
        return Integer.valueOf(iSizeOfCellArray);
    }
}
