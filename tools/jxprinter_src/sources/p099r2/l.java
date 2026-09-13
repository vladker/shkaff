package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7944a;

    public /* synthetic */ l(int i5) {
        this.f7944a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7944a) {
            case 0:
                return CTClientDataImpl.lambda$getColumnArray$46(i5);
            case 1:
                return CTClientDataImpl.lambda$getLCTArray$74(i5);
            case 2:
                return CTClientDataImpl.lambda$getRecalcAlwaysArray$116(i5);
            case 3:
                return CTClientDataImpl.lambda$getIncArray$102(i5);
            case 4:
                return CTClientDataImpl.lambda$getMinArray$98(i5);
            case 5:
                return CTClientDataImpl.lambda$xgetCameraArray$115(i5);
            case 6:
                return CTClientDataImpl.lambda$xgetMinArray$99(i5);
            case 7:
                return CTClientDataImpl.lambda$xgetMultiLineArray$57(i5);
            case 8:
                return CTClientDataImpl.lambda$xgetSelTypeArray$71(i5);
            case 9:
                return CTClientDataImpl.lambda$xgetDisabledArray$13(i5);
            case 10:
                return CTClientDataImpl.lambda$xgetCheckedArray$85(i5);
            case 11:
                return CTClientDataImpl.lambda$xgetAutoLineArray$17(i5);
            case 12:
                return CTClientDataImpl.lambda$xgetDropLinesArray$83(i5);
            case 13:
                return CTClientDataImpl.lambda$getListItemArray$76(i5);
            case 14:
                return CTClientDataImpl.lambda$getColHiddenArray$52(i5);
            case 15:
                return CTClientDataImpl.lambda$xgetUIObjArray$123(i5);
            case 16:
                return CTClientDataImpl.lambda$getAccel2Array$42(i5);
            case 17:
                return CTClientDataImpl.lambda$xgetMoveWithCellsArray$1(i5);
            case 18:
                return CTClientDataImpl.lambda$xgetDefaultSizeArray$9(i5);
            case 19:
                return CTClientDataImpl.lambda$getNoThreeD2Array$68(i5);
            case 20:
                return CTClientDataImpl.lambda$getWidthMinArray$64(i5);
            case 21:
                return CTClientDataImpl.lambda$getJustLastXArray$28(i5);
            case 22:
                return CTClientDataImpl.lambda$getHelpArray$34(i5);
            case 23:
                return CTClientDataImpl.lambda$xgetWidthMinArray$65(i5);
            case 24:
                return CTClientDataImpl.lambda$xgetAccel2Array$43(i5);
            case 25:
                return CTClientDataImpl.lambda$xgetSecretEditArray$31(i5);
            case 26:
                return CTClientDataImpl.lambda$xgetSizeWithCellsArray$3(i5);
            case 27:
                return CTClientDataImpl.lambda$getAutoScaleArray$118(i5);
            case 28:
                return CTClientDataImpl.lambda$getDropLinesArray$82(i5);
            default:
                return CTClientDataImpl.lambda$getMapOCXArray$110(i5);
        }
    }
}
