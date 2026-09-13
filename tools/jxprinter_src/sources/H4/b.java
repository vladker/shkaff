package H4;

import java.util.function.IntFunction;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemaEntryImpl;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f305a;

    public /* synthetic */ b(int i5) {
        this.f305a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f305a) {
            case 0:
                return ColorGradientFormatting.lambda$new$0(i5);
            case 1:
                return ColorGradientFormatting.lambda$new$1(i5);
            case 2:
                return IconMultiStateFormatting.lambda$new$0(i5);
            case 3:
                return DownloadedSchemaEntryImpl.lambda$xgetSchemaLocationArray$1(i5);
            case 4:
                return DownloadedSchemaEntryImpl.lambda$getSchemaLocationArray$0(i5);
            case 5:
                return SOAPArrayType.lambda$soap11DimensionString$0(i5);
            case 6:
                return SOAPArrayType.lambda$soap12DimensionString$1(i5);
            case 7:
                return CTVectorImpl.lambda$xgetFiletimeArray$20(i5);
            case 8:
                return CTVectorImpl.lambda$xgetI1Array$0(i5);
            case 9:
                return CTVectorImpl.lambda$xgetI2Array$1(i5);
            case 10:
                return CTVectorImpl.lambda$xgetR8Array$10(i5);
            case 11:
                return CTVectorImpl.lambda$xgetUi4Array$6(i5);
            case 12:
                return CTVectorImpl.lambda$xgetErrorArray$25(i5);
            case 13:
                return CTVectorImpl.lambda$xgetDateArray$18(i5);
            case 14:
                return CTVectorImpl.lambda$getBstrArray$15(i5);
            case 15:
                return CTVectorImpl.lambda$xgetUi2Array$5(i5);
            case 16:
                return CTVectorImpl.lambda$getDateArray$17(i5);
            case 17:
                return CTVectorImpl.lambda$getCyArray$22(i5);
            case 18:
                return CTVectorImpl.lambda$xgetR4Array$9(i5);
            case 19:
                return CTVectorImpl.lambda$xgetI4Array$2(i5);
            case 20:
                return CTVectorImpl.lambda$xgetUi1Array$4(i5);
            case 21:
                return CTVectorImpl.lambda$getLpstrArray$11(i5);
            case 22:
                return CTVectorImpl.lambda$getUi8Array$7(i5);
            case 23:
                return CTVectorImpl.lambda$xgetBoolArray$21(i5);
            case 24:
                return CTVectorImpl.lambda$xgetBstrArray$16(i5);
            case 25:
                return CTVectorImpl.lambda$xgetLpwstrArray$14(i5);
            case 26:
                return CTVectorImpl.lambda$getLpwstrArray$13(i5);
            case 27:
                return CTVectorImpl.lambda$getClsidArray$26(i5);
            case 28:
                return CTVectorImpl.lambda$xgetClsidArray$27(i5);
            default:
                return CTVectorImpl.lambda$xgetCyArray$23(i5);
        }
    }
}
