package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class R0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8327a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ R0(CTPImpl cTPImpl, int i5) {
        this.f8327a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8327a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setOMathArray(iIntValue, (CTOMath) obj2);
                break;
            case 1:
                this.b.setDelArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 2:
                this.b.setProofErrArray(iIntValue, (CTProofErr) obj2);
                break;
            default:
                this.b.setRArray(iIntValue, (CTR) obj2);
                break;
        }
    }
}
