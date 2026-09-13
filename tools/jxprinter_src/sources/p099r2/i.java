package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7941a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ i(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7941a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7941a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getTextVAlignArray(iIntValue);
            case 1:
                return this.b.getFmlaGroupArray(iIntValue);
            case 2:
                return this.b.getDefaultSizeArray(iIntValue);
            case 3:
                return this.b.getDropStyleArray(iIntValue);
            case 4:
                return this.b.getSizeWithCellsArray(iIntValue);
            case 5:
                return this.b.getCheckedArray(iIntValue);
            case 6:
                return this.b.xgetHorizArray(iIntValue);
            case 7:
                return this.b.getColHiddenArray(iIntValue);
            case 8:
                return this.b.insertNewHoriz(iIntValue);
            case 9:
                return this.b.getNoThreeDArray(iIntValue);
            case 10:
                return this.b.xgetRowHiddenArray(iIntValue);
            case 11:
                return this.b.insertNewRowHidden(iIntValue);
            case 12:
                return this.b.xgetHelpArray(iIntValue);
            case 13:
                return this.b.insertNewHelp(iIntValue);
            case 14:
                return this.b.getMultiLineArray(iIntValue);
            case 15:
                return this.b.xgetIncArray(iIntValue);
            case 16:
                return this.b.insertNewInc(iIntValue);
            case 17:
                return this.b.xgetJustLastXArray(iIntValue);
            case 18:
                return this.b.insertNewJustLastX(iIntValue);
            case 19:
                return this.b.xgetVTEditArray(iIntValue);
            case 20:
                return this.b.insertNewVTEdit(iIntValue);
            case 21:
                return this.b.xgetRecalcAlwaysArray(iIntValue);
            case 22:
                return this.b.insertNewRecalcAlways(iIntValue);
            case 23:
                return this.b.getValidIdsArray(iIntValue);
            case 24:
                return this.b.xgetMapOCXArray(iIntValue);
            case 25:
                return this.b.insertNewMapOCX(iIntValue);
            case 26:
                return this.b.getSecretEditArray(iIntValue);
            case 27:
                return this.b.xgetWidthMinArray(iIntValue);
            case 28:
                return this.b.xgetFirstButtonArray(iIntValue);
            default:
                return this.b.insertNewFirstButton(iIntValue);
        }
    }
}
