package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSharedItemsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class J0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7996a;
    public final /* synthetic */ CTSharedItemsImpl b;

    public /* synthetic */ J0(CTSharedItemsImpl cTSharedItemsImpl, int i5) {
        this.f7996a = i5;
        this.b = cTSharedItemsImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7996a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeM(iIntValue);
                break;
            case 1:
                this.b.removeS(iIntValue);
                break;
            case 2:
                this.b.removeB(iIntValue);
                break;
            case 3:
                this.b.removeE(iIntValue);
                break;
            case 4:
                this.b.removeN(iIntValue);
                break;
            default:
                this.b.removeD(iIntValue);
                break;
        }
    }
}
