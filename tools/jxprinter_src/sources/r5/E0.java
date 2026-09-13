package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPhoneticRun;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRElt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRstImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class E0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7986a;
    public final /* synthetic */ CTRstImpl b;

    public /* synthetic */ E0(CTRstImpl cTRstImpl, int i5) {
        this.f7986a = i5;
        this.b = cTRstImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7986a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setRPhArray(iIntValue, (CTPhoneticRun) obj2);
                break;
            default:
                this.b.setRArray(iIntValue, (CTRElt) obj2);
                break;
        }
    }
}
