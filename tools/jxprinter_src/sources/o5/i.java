package o5;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.IntFunction;
import org.apache.poi.hssf.record.common.ExtRst;
import org.apache.poi.ss.formula.eval.forked.ForkedEvaluator;
import org.apache.poi.util.CodepointsUtil;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class i implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6482a;

    public /* synthetic */ i(int i5) {
        this.f6482a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f6482a) {
            case 0:
                return CTVectorImpl.lambda$xgetUi8Array$8(i5);
            case 1:
                return CTVectorImpl.lambda$xgetLpstrArray$12(i5);
            case 2:
                return CTVectorImpl.lambda$getFiletimeArray$19(i5);
            case 3:
                return CTVectorImpl.lambda$xgetI8Array$3(i5);
            case 4:
                return CTVectorImpl.lambda$getErrorArray$24(i5);
            case 5:
                return ExtRst.lambda$new$0(i5);
            case 6:
                return ForkedEvaluator.lambda$setupEnvironment$1(i5);
            case 7:
                return CodepointsUtil.lambda$iteratorFor$0(i5);
            case 8:
                return CTClientDataImpl.lambda$getColoredArray$80(i5);
            case 9:
                return CTClientDataImpl.lambda$getVisibleArray$48(i5);
            case 10:
                return CTClientDataImpl.lambda$xgetScriptExtendedArray$127(i5);
            case 11:
                return CTClientDataImpl.lambda$xgetDismissArray$39(i5);
            case 12:
                return CTClientDataImpl.lambda$getFirstButtonArray$92(i5);
            case 13:
                return CTClientDataImpl.lambda$getScriptLocationArray$130(i5);
            case 14:
                return CTClientDataImpl.lambda$xgetScriptLanguageArray$129(i5);
            case 15:
                return CTClientDataImpl.lambda$xgetValArray$97(i5);
            case 16:
                return CTClientDataImpl.lambda$xgetLCTArray$75(i5);
            case 17:
                return CTClientDataImpl.lambda$xgetValidIdsArray$61(i5);
            case 18:
                return CTClientDataImpl.lambda$getLockTextArray$26(i5);
            case 19:
                return CTClientDataImpl.lambda$getPageArray$104(i5);
            case 20:
                return CTClientDataImpl.lambda$xgetAutoPictArray$19(i5);
            case 21:
                return CTClientDataImpl.lambda$xgetIncArray$103(i5);
            case 22:
                return CTClientDataImpl.lambda$getMaxArray$100(i5);
            case 23:
                return CTClientDataImpl.lambda$xgetNoThreeD2Array$69(i5);
            case 24:
                return CTClientDataImpl.lambda$getDropStyleArray$78(i5);
            case 25:
                return CTClientDataImpl.lambda$xgetRecalcAlwaysArray$117(i5);
            case 26:
                return CTClientDataImpl.lambda$xgetMaxArray$101(i5);
            case 27:
                return CTClientDataImpl.lambda$getDisabledArray$12(i5);
            case 28:
                return CTClientDataImpl.lambda$xgetTextHAlignArray$23(i5);
            default:
                return CTClientDataImpl.lambda$xgetScriptLocationArray$131(i5);
        }
    }
}
