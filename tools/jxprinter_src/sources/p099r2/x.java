package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7956a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ x(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7956a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfLockedArray;
        switch (this.f7956a) {
            case 0:
                iSizeOfLockedArray = this.b.sizeOfLockedArray();
                break;
            case 1:
                iSizeOfLockedArray = this.b.sizeOfVScrollArray();
                break;
            case 2:
                iSizeOfLockedArray = this.b.sizeOfRecalcAlwaysArray();
                break;
            case 3:
                iSizeOfLockedArray = this.b.sizeOfScriptLocationArray();
                break;
            case 4:
                iSizeOfLockedArray = this.b.sizeOfCancelArray();
                break;
            case 5:
                iSizeOfLockedArray = this.b.sizeOfDDEArray();
                break;
            default:
                iSizeOfLockedArray = this.b.sizeOfDefaultArray();
                break;
        }
        return Integer.valueOf(iSizeOfLockedArray);
    }
}
