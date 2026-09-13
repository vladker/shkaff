package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7951a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ s(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7951a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7951a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewAutoFill(iIntValue);
            case 1:
                return this.b.getPageArray(iIntValue);
            case 2:
                return this.b.xgetLockTextArray(iIntValue);
            case 3:
                return this.b.insertNewLockText(iIntValue);
            case 4:
                return this.b.xgetDropStyleArray(iIntValue);
            case 5:
                return this.b.getScriptTextArray(iIntValue);
            case 6:
                return this.b.xgetCheckedArray(iIntValue);
            case 7:
                return this.b.insertNewChecked(iIntValue);
            case 8:
                return this.b.getFmlaTxbxArray(iIntValue);
            case 9:
                return this.b.getFmlaRangeArray(iIntValue);
            case 10:
                return this.b.insertNewDropStyle(iIntValue);
            case 11:
                return this.b.xgetDefaultArray(iIntValue);
            case 12:
                return this.b.getDropLinesArray(iIntValue);
            case 13:
                return this.b.getVScrollArray(iIntValue);
            case 14:
                return this.b.xgetCFArray(iIntValue);
            case 15:
                return this.b.insertNewCF(iIntValue);
            case 16:
                return this.b.getRowHiddenArray(iIntValue);
            case 17:
                return this.b.xgetMaxArray(iIntValue);
            case 18:
                return this.b.insertNewMax(iIntValue);
            case 19:
                return this.b.xgetMoveWithCellsArray(iIntValue);
            case 20:
                return this.b.insertNewMoveWithCells(iIntValue);
            case 21:
                return this.b.xgetTextHAlignArray(iIntValue);
            case 22:
                return this.b.insertNewTextHAlign(iIntValue);
            case 23:
                return this.b.getDismissArray(iIntValue);
            case 24:
                return this.b.xgetFmlaPictArray(iIntValue);
            case 25:
                return this.b.insertNewFmlaPict(iIntValue);
            case 26:
                return this.b.xgetFmlaRangeArray(iIntValue);
            case 27:
                return this.b.insertNewFmlaRange(iIntValue);
            case 28:
                return this.b.xgetValidIdsArray(iIntValue);
            default:
                return this.b.insertNewValidIds(iIntValue);
        }
    }
}
