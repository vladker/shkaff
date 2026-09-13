package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7946a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ n(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7946a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7946a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.xgetDefaultSizeArray(iIntValue);
            case 1:
                return this.b.insertNewDefaultSize(iIntValue);
            case 2:
                return this.b.getFmlaMacroArray(iIntValue);
            case 3:
                return this.b.getTextHAlignArray(iIntValue);
            case 4:
                return this.b.getJustLastXArray(iIntValue);
            case 5:
                return this.b.insertNewWidthMin(iIntValue);
            case 6:
                return this.b.xgetPageArray(iIntValue);
            case 7:
                return this.b.insertNewPage(iIntValue);
            case 8:
                return this.b.getCameraArray(iIntValue);
            case 9:
                return this.b.xgetRowArray(iIntValue);
            case 10:
                return this.b.insertNewRow(iIntValue);
            case 11:
                return this.b.getColumnArray(iIntValue);
            case 12:
                return this.b.xgetColHiddenArray(iIntValue);
            case 13:
                return this.b.insertNewColHidden(iIntValue);
            case 14:
                return this.b.xgetLCTArray(iIntValue);
            case 15:
                return this.b.insertNewLCT(iIntValue);
            case 16:
                return this.b.getVTEditArray(iIntValue);
            case 17:
                return this.b.getFmlaLinkArray(iIntValue);
            case 18:
                return this.b.xgetUIObjArray(iIntValue);
            case 19:
                return this.b.xgetCameraArray(iIntValue);
            case 20:
                return this.b.insertNewUIObj(iIntValue);
            case 21:
                return this.b.xgetColoredArray(iIntValue);
            case 22:
                return this.b.insertNewColored(iIntValue);
            case 23:
                return this.b.getAutoScaleArray(iIntValue);
            case 24:
                return this.b.getFirstButtonArray(iIntValue);
            case 25:
                return this.b.xgetSecretEditArray(iIntValue);
            case 26:
                return this.b.insertNewSecretEdit(iIntValue);
            case 27:
                return this.b.getHorizArray(iIntValue);
            case 28:
                return this.b.xgetSelArray(iIntValue);
            default:
                return this.b.insertNewCamera(iIntValue);
        }
    }
}
