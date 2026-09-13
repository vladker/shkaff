package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTWorksheetImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class h1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8051a;
    public final /* synthetic */ CTWorksheetImpl b;

    public /* synthetic */ h1(CTWorksheetImpl cTWorksheetImpl, int i5) {
        this.f8051a = i5;
        this.b = cTWorksheetImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8051a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCols(iIntValue);
                break;
            default:
                this.b.removeConditionalFormatting(iIntValue);
                break;
        }
    }
}
