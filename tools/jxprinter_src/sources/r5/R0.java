package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetViewImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class R0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8011a;
    public final /* synthetic */ CTSheetViewImpl b;

    public /* synthetic */ R0(CTSheetViewImpl cTSheetViewImpl, int i5) {
        this.f8011a = i5;
        this.b = cTSheetViewImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8011a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSelectionArray(iIntValue);
            case 1:
                return this.b.insertNewSelection(iIntValue);
            case 2:
                return this.b.getPivotSelectionArray(iIntValue);
            default:
                return this.b.insertNewPivotSelection(iIntValue);
        }
    }
}
