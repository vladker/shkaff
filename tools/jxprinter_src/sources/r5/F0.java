package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRstImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class F0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7988a;
    public final /* synthetic */ CTRstImpl b;

    public /* synthetic */ F0(CTRstImpl cTRstImpl, int i5) {
        this.f7988a = i5;
        this.b = cTRstImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7988a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeRPh(iIntValue);
                break;
            default:
                this.b.removeR(iIntValue);
                break;
        }
    }
}
