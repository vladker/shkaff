package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7938a;

    public /* synthetic */ f(int i5) {
        this.f7938a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7938a) {
            case 0:
                return CTClientDataImpl.lambda$getDefaultArray$32(i5);
            case 1:
                return CTClientDataImpl.lambda$getMoveWithCellsArray$0(i5);
            case 2:
                return CTClientDataImpl.lambda$getRowArray$44(i5);
            case 3:
                return CTClientDataImpl.lambda$xgetJustLastXArray$29(i5);
            case 4:
                return CTClientDataImpl.lambda$xgetAutoScaleArray$119(i5);
            case 5:
                return CTClientDataImpl.lambda$xgetCancelArray$37(i5);
            case 6:
                return CTClientDataImpl.lambda$xgetFirstButtonArray$93(i5);
            case 7:
                return CTClientDataImpl.lambda$xgetColumnArray$47(i5);
            case 8:
                return CTClientDataImpl.lambda$getNoThreeDArray$90(i5);
            case 9:
                return CTClientDataImpl.lambda$xgetListItemArray$77(i5);
            case 10:
                return CTClientDataImpl.lambda$xgetLockedArray$7(i5);
            case 11:
                return CTClientDataImpl.lambda$getCameraArray$114(i5);
            case 12:
                return CTClientDataImpl.lambda$getUIObjArray$122(i5);
            case 13:
                return CTClientDataImpl.lambda$getFmlaRangeArray$62(i5);
            case 14:
                return CTClientDataImpl.lambda$getAutoPictArray$18(i5);
            case 15:
                return CTClientDataImpl.lambda$xgetFmlaRangeArray$63(i5);
            case 16:
                return CTClientDataImpl.lambda$xgetAutoFillArray$15(i5);
            case 17:
                return CTClientDataImpl.lambda$xgetAccelArray$41(i5);
            case 18:
                return CTClientDataImpl.lambda$xgetDxArray$109(i5);
            case 19:
                return CTClientDataImpl.lambda$xgetHelpArray$35(i5);
            case 20:
                return CTClientDataImpl.lambda$getDDEArray$120(i5);
            case 21:
                return CTClientDataImpl.lambda$getDxArray$108(i5);
            case 22:
                return CTClientDataImpl.lambda$getSelArray$66(i5);
            case 23:
                return CTClientDataImpl.lambda$xgetHorizArray$107(i5);
            case 24:
                return CTClientDataImpl.lambda$getAutoLineArray$16(i5);
            case 25:
                return CTClientDataImpl.lambda$xgetVisibleArray$49(i5);
            case 26:
                return CTClientDataImpl.lambda$xgetNoThreeDArray$91(i5);
            case 27:
                return CTClientDataImpl.lambda$getFmlaMacroArray$20(i5);
            case 28:
                return CTClientDataImpl.lambda$getFmlaGroupArray$94(i5);
            default:
                return CTClientDataImpl.lambda$getMultiSelArray$72(i5);
        }
    }
}
