package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTWorksheetImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class i1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8054a;
    public final /* synthetic */ CTWorksheetImpl b;

    public /* synthetic */ i1(CTWorksheetImpl cTWorksheetImpl, int i5) {
        this.f8054a = i5;
        this.b = cTWorksheetImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfColsArray;
        switch (this.f8054a) {
            case 0:
                iSizeOfColsArray = this.b.sizeOfColsArray();
                break;
            default:
                iSizeOfColsArray = this.b.sizeOfConditionalFormattingArray();
                break;
        }
        return Integer.valueOf(iSizeOfColsArray);
    }
}
