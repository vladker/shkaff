package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetViewImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class S0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8013a;
    public final /* synthetic */ CTSheetViewImpl b;

    public /* synthetic */ S0(CTSheetViewImpl cTSheetViewImpl, int i5) {
        this.f8013a = i5;
        this.b = cTSheetViewImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8013a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSelection(iIntValue);
                break;
            default:
                this.b.removePivotSelection(iIntValue);
                break;
        }
    }
}
