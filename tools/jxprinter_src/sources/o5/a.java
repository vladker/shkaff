package o5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6474a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ a(CTVectorImpl cTVectorImpl, int i5) {
        this.f6474a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6474a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.xgetLpwstrArray(iIntValue);
            case 1:
                return this.b.xgetUi2Array(iIntValue);
            case 2:
                return this.b.insertNewUi2(iIntValue);
            case 3:
                return this.b.getLpwstrArray(iIntValue);
            case 4:
                return this.b.getFiletimeArray(iIntValue);
            case 5:
                return this.b.xgetDateArray(iIntValue);
            case 6:
                return this.b.insertNewDate(iIntValue);
            case 7:
                return Float.valueOf(this.b.getR4Array(iIntValue));
            case 8:
                return this.b.getClsidArray(iIntValue);
            case 9:
                return this.b.xgetClsidArray(iIntValue);
            case 10:
                return this.b.insertNewClsid(iIntValue);
            case 11:
                return this.b.xgetI2Array(iIntValue);
            case 12:
                return this.b.insertNewI2(iIntValue);
            case 13:
                return Short.valueOf(this.b.getI2Array(iIntValue));
            case 14:
                return this.b.getBstrArray(iIntValue);
            case 15:
                return this.b.xgetUi1Array(iIntValue);
            case 16:
                return this.b.insertNewUi1(iIntValue);
            case 17:
                return Boolean.valueOf(this.b.getBoolArray(iIntValue));
            case 18:
                return this.b.xgetI8Array(iIntValue);
            case 19:
                return this.b.insertNewI8(iIntValue);
            case 20:
                return this.b.getErrorArray(iIntValue);
            case 21:
                return this.b.xgetCyArray(iIntValue);
            case 22:
                return this.b.insertNewCy(iIntValue);
            case 23:
                return this.b.getDateArray(iIntValue);
            case 24:
                return this.b.xgetBoolArray(iIntValue);
            case 25:
                return this.b.xgetI1Array(iIntValue);
            case 26:
                return this.b.insertNewBool(iIntValue);
            case 27:
                return this.b.getLpstrArray(iIntValue);
            case 28:
                return Integer.valueOf(this.b.getUi2Array(iIntValue));
            default:
                return Long.valueOf(this.b.getUi4Array(iIntValue));
        }
    }
}
