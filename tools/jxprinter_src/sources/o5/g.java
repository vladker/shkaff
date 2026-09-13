package o5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.impl.CTVectorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class g implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6480a;
    public final /* synthetic */ CTVectorImpl b;

    public /* synthetic */ g(CTVectorImpl cTVectorImpl, int i5) {
        this.f6480a = i5;
        this.b = cTVectorImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6480a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewI1(iIntValue);
            case 1:
                return this.b.xgetFiletimeArray(iIntValue);
            case 2:
                return this.b.insertNewFiletime(iIntValue);
            case 3:
                return this.b.xgetLpstrArray(iIntValue);
            case 4:
                return this.b.insertNewLpwstr(iIntValue);
            case 5:
                return this.b.insertNewLpstr(iIntValue);
            case 6:
                return Double.valueOf(this.b.getR8Array(iIntValue));
            case 7:
                return this.b.xgetI4Array(iIntValue);
            case 8:
                return this.b.insertNewI4(iIntValue);
            case 9:
                return this.b.getUi8Array(iIntValue);
            case 10:
                return this.b.xgetErrorArray(iIntValue);
            case 11:
                return this.b.insertNewError(iIntValue);
            case 12:
                return this.b.xgetUi8Array(iIntValue);
            case 13:
                return this.b.insertNewUi8(iIntValue);
            case 14:
                return this.b.xgetR8Array(iIntValue);
            case 15:
                return this.b.insertNewR8(iIntValue);
            case 16:
                return this.b.getVariantArray(iIntValue);
            case 17:
                return this.b.insertNewVariant(iIntValue);
            case 18:
                return Long.valueOf(this.b.getI8Array(iIntValue));
            case 19:
                return this.b.xgetUi4Array(iIntValue);
            case 20:
                return Byte.valueOf(this.b.getI1Array(iIntValue));
            case 21:
                return Integer.valueOf(this.b.getI4Array(iIntValue));
            case 22:
                return this.b.xgetR4Array(iIntValue);
            case 23:
                return this.b.insertNewR4(iIntValue);
            case 24:
                return this.b.getCyArray(iIntValue);
            case 25:
                return this.b.insertNewUi4(iIntValue);
            case 26:
                return Short.valueOf(this.b.getUi1Array(iIntValue));
            case 27:
                return this.b.xgetBstrArray(iIntValue);
            default:
                return this.b.insertNewBstr(iIntValue);
        }
    }
}
