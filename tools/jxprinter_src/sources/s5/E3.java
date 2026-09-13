package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class E3 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8266a;
    public final /* synthetic */ CTSmartTagRunImpl b;

    public /* synthetic */ E3(CTSmartTagRunImpl cTSmartTagRunImpl, int i5) {
        this.f8266a = i5;
        this.b = cTSmartTagRunImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8266a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setRArray(iIntValue, (CTR) obj2);
                break;
            case 1:
                this.b.setCustomXmlMoveToRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 2:
                this.b.setInsArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            default:
                this.b.setSmartTagArray(iIntValue, (CTSmartTagRun) obj2);
                break;
        }
    }
}
