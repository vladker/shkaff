package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSharedItemsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class H0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7992a;
    public final /* synthetic */ CTSharedItemsImpl b;

    public /* synthetic */ H0(CTSharedItemsImpl cTSharedItemsImpl, int i5) {
        this.f7992a = i5;
        this.b = cTSharedItemsImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7992a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getNArray(iIntValue);
            case 1:
                return this.b.getMArray(iIntValue);
            case 2:
                return this.b.insertNewM(iIntValue);
            case 3:
                return this.b.getSArray(iIntValue);
            case 4:
                return this.b.insertNewS(iIntValue);
            case 5:
                return this.b.getBArray(iIntValue);
            case 6:
                return this.b.insertNewB(iIntValue);
            case 7:
                return this.b.getEArray(iIntValue);
            case 8:
                return this.b.insertNewE(iIntValue);
            case 9:
                return this.b.insertNewN(iIntValue);
            case 10:
                return this.b.getDArray(iIntValue);
            default:
                return this.b.insertNewD(iIntValue);
        }
    }
}
