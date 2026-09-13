package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.w1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1751w1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8492a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1751w1(CTRImpl cTRImpl, int i5) {
        this.f8492a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8492a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setObjectArray(iIntValue, (CTObject) obj2);
                break;
            case 1:
                this.b.setCommentReferenceArray(iIntValue, (CTMarkup) obj2);
                break;
            default:
                this.b.setLastRenderedPageBreakArray(iIntValue, (CTEmpty) obj2);
                break;
        }
    }
}
