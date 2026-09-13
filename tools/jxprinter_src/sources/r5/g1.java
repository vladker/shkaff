package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTWorksheetImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class g1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8048a;
    public final /* synthetic */ CTWorksheetImpl b;

    public /* synthetic */ g1(CTWorksheetImpl cTWorksheetImpl, int i5) {
        this.f8048a = i5;
        this.b = cTWorksheetImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8048a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setColsArray(iIntValue, (CTCols) obj2);
                break;
            default:
                this.b.setConditionalFormattingArray(iIntValue, (CTConditionalFormatting) obj2);
                break;
        }
    }
}
