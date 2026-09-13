package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBdoContentRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Z2 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8369a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ Z2(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8369a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8369a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setFldSimpleArray(iIntValue, (CTSimpleField) obj2);
                break;
            case 1:
                this.b.setPermStartArray(iIntValue, (CTPermStart) obj2);
                break;
            case 2:
                this.b.setBdoArray(iIntValue, (CTBdoContentRun) obj2);
                break;
            default:
                this.b.setMoveToRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
        }
    }
}
