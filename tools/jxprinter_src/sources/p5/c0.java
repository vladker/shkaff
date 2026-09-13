package p5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7800a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ c0(CTOMathImpl cTOMathImpl, int i5) {
        this.f7800a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7800a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setDArray(iIntValue, (CTD) obj2);
                break;
            case 1:
                this.b.setSSubArray(iIntValue, (CTSSub) obj2);
                break;
            case 2:
                this.b.setMoveToRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            default:
                this.b.setPermEndArray(iIntValue, (CTPerm) obj2);
                break;
        }
    }
}
