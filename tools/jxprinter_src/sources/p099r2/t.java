package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.IntFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTAuthorsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCfRuleImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7952a;

    public /* synthetic */ t(int i5) {
        this.f7952a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f7952a) {
            case 0:
                return CTClientDataImpl.lambda$getRowHiddenArray$50(i5);
            case 1:
                return CTClientDataImpl.lambda$xgetFmlaMacroArray$21(i5);
            case 2:
                return CTClientDataImpl.lambda$xgetColHiddenArray$53(i5);
            case 3:
                return CTClientDataImpl.lambda$xgetVTEditArray$55(i5);
            case 4:
                return CTClientDataImpl.lambda$xgetTextVAlignArray$25(i5);
            case 5:
                return CTClientDataImpl.lambda$getAnchorArray$4(i5);
            case 6:
                return CTClientDataImpl.lambda$getValidIdsArray$60(i5);
            case 7:
                return CTClientDataImpl.lambda$getHorizArray$106(i5);
            case 8:
                return CTClientDataImpl.lambda$getAutoFillArray$14(i5);
            case 9:
                return CTClientDataImpl.lambda$getTextHAlignArray$22(i5);
            case 10:
                return CTClientDataImpl.lambda$getMultiLineArray$56(i5);
            case 11:
                return CTClientDataImpl.lambda$getScriptLanguageArray$128(i5);
            case 12:
                return CTClientDataImpl.lambda$xgetCFArray$113(i5);
            case 13:
                return CTClientDataImpl.lambda$getDismissArray$38(i5);
            case 14:
                return CTClientDataImpl.lambda$xgetDefaultArray$33(i5);
            case 15:
                return CTClientDataImpl.lambda$getDefaultSizeArray$8(i5);
            case 16:
                return CTClientDataImpl.lambda$xgetPrintObjectArray$11(i5);
            case 17:
                return CTClientDataImpl.lambda$getSizeWithCellsArray$2(i5);
            case 18:
                return CTClientDataImpl.lambda$xgetLockTextArray$27(i5);
            case 19:
                return CTClientDataImpl.lambda$xgetColoredArray$81(i5);
            case 20:
                return CTClientDataImpl.lambda$getValArray$96(i5);
            case 21:
                return CTClientDataImpl.lambda$getLockedArray$6(i5);
            case 22:
                return CTAuthorsImpl.lambda$getAuthorArray$0(i5);
            case 23:
                return CTAuthorsImpl.lambda$xgetAuthorArray$1(i5);
            case 24:
                return CTCfRuleImpl.lambda$getFormulaArray$0(i5);
            case 25:
                return CTCfRuleImpl.lambda$xgetFormulaArray$1(i5);
            case 26:
                return CTProtectedRangeImpl.lambda$getSecurityDescriptorArray$0(i5);
            default:
                return CTProtectedRangeImpl.lambda$xgetSecurityDescriptorArray$1(i5);
        }
    }
}
