package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumberingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class H0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8278a;
    public final /* synthetic */ CTNumberingImpl b;

    public /* synthetic */ H0(CTNumberingImpl cTNumberingImpl, int i5) {
        this.f8278a = i5;
        this.b = cTNumberingImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8278a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAbstractNumArray(iIntValue, (CTAbstractNum) obj2);
                break;
            default:
                this.b.setNumArray(iIntValue, (CTNum) obj2);
                break;
        }
    }
}
