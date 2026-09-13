package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTWorksheetImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class f1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8045a;
    public final /* synthetic */ CTWorksheetImpl b;

    public /* synthetic */ f1(CTWorksheetImpl cTWorksheetImpl, int i5) {
        this.f8045a = i5;
        this.b = cTWorksheetImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8045a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getColsArray(iIntValue);
            case 1:
                return this.b.insertNewCols(iIntValue);
            case 2:
                return this.b.getConditionalFormattingArray(iIntValue);
            default:
                return this.b.insertNewConditionalFormatting(iIntValue);
        }
    }
}
