package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7948a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ p(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7948a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7948a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewSel(iIntValue);
            case 1:
                return this.b.xgetSelTypeArray(iIntValue);
            case 2:
                return this.b.insertNewSelType(iIntValue);
            case 3:
                return this.b.xgetAccelArray(iIntValue);
            case 4:
                return this.b.insertNewAccel(iIntValue);
            case 5:
                return this.b.xgetColumnArray(iIntValue);
            case 6:
                return this.b.insertNewColumn(iIntValue);
            case 7:
                return this.b.getAccel2Array(iIntValue);
            case 8:
                return this.b.getValArray(iIntValue);
            case 9:
                return this.b.xgetAccel2Array(iIntValue);
            case 10:
                return this.b.insertNewAccel2(iIntValue);
            case 11:
                return this.b.getFmlaPictArray(iIntValue);
            case 12:
                return this.b.xgetSizeWithCellsArray(iIntValue);
            case 13:
                return this.b.insertNewSizeWithCells(iIntValue);
            case 14:
                return this.b.xgetScriptLanguageArray(iIntValue);
            case 15:
                return this.b.insertNewScriptLanguage(iIntValue);
            case 16:
                return this.b.getHelpArray(iIntValue);
            case 17:
                return this.b.getDDEArray(iIntValue);
            case 18:
                return this.b.getDefaultArray(iIntValue);
            case 19:
                return this.b.xgetDismissArray(iIntValue);
            case 20:
                return this.b.insertNewDismiss(iIntValue);
            case 21:
                return this.b.xgetValArray(iIntValue);
            case 22:
                return this.b.insertNewVal(iIntValue);
            case 23:
                return this.b.xgetDropLinesArray(iIntValue);
            case 24:
                return this.b.insertNewDropLines(iIntValue);
            case 25:
                return this.b.getDisabledArray(iIntValue);
            case 26:
                return this.b.xgetDxArray(iIntValue);
            case 27:
                return this.b.insertNewDx(iIntValue);
            case 28:
                return this.b.getDxArray(iIntValue);
            default:
                return this.b.xgetAutoFillArray(iIntValue);
        }
    }
}
