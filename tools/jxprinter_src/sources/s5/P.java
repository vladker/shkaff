package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDirContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class P implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8317a;
    public final /* synthetic */ CTDirContentRunImpl b;

    public /* synthetic */ P(CTDirContentRunImpl cTDirContentRunImpl, int i5) {
        this.f8317a = i5;
        this.b = cTDirContentRunImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8317a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSmartTagArray(iIntValue, (CTSmartTagRun) obj2);
                break;
            case 1:
                this.b.setOMathArray(iIntValue, (CTOMath) obj2);
                break;
            case 2:
                this.b.setCustomXmlMoveFromRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            default:
                this.b.setCommentRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
        }
    }
}
