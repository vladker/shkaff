package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7937a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ e(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7937a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7937a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewAnchor(iIntValue);
            case 1:
                return this.b.xgetNoThreeD2Array(iIntValue);
            case 2:
                return this.b.insertNewNoThreeD2(iIntValue);
            case 3:
                return this.b.xgetAutoScaleArray(iIntValue);
            case 4:
                return this.b.insertNewAutoScale(iIntValue);
            case 5:
                return this.b.xgetMultiLineArray(iIntValue);
            case 6:
                return this.b.insertNewMultiLine(iIntValue);
            case 7:
                return this.b.getAutoFillArray(iIntValue);
            case 8:
                return this.b.getAnchorArray(iIntValue);
            case 9:
                return this.b.getAutoLineArray(iIntValue);
            case 10:
                return this.b.getPrintObjectArray(iIntValue);
            case 11:
                return this.b.getWidthMinArray(iIntValue);
            case 12:
                return this.b.getLockedArray(iIntValue);
            case 13:
                return this.b.xgetScriptExtendedArray(iIntValue);
            case 14:
                return this.b.insertNewScriptExtended(iIntValue);
            case 15:
                return this.b.getNoThreeD2Array(iIntValue);
            case 16:
                return this.b.getVisibleArray(iIntValue);
            case 17:
                return this.b.getScriptExtendedArray(iIntValue);
            case 18:
                return this.b.getMinArray(iIntValue);
            case 19:
                return this.b.getCFArray(iIntValue);
            case 20:
                return this.b.getMaxArray(iIntValue);
            case 21:
                return this.b.getColoredArray(iIntValue);
            case 22:
                return this.b.xgetFmlaGroupArray(iIntValue);
            case 23:
                return this.b.insertNewFmlaGroup(iIntValue);
            case 24:
                return this.b.getIncArray(iIntValue);
            case 25:
                return this.b.getMoveWithCellsArray(iIntValue);
            case 26:
                return this.b.getMultiSelArray(iIntValue);
            case 27:
                return this.b.getLCTArray(iIntValue);
            case 28:
                return this.b.getScriptLanguageArray(iIntValue);
            default:
                return this.b.getUIObjArray(iIntValue);
        }
    }
}
