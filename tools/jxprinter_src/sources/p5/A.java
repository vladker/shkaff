package p5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class A implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7770a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ A(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7770a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7770a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSSubArray(iIntValue, (CTSSub) obj2);
                break;
            case 1:
                this.b.setCustomXmlMoveFromRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 2:
                this.b.setOMathArray(iIntValue, (CTOMath) obj2);
                break;
            default:
                this.b.setCustomXmlArray(iIntValue, (CTCustomXmlRun) obj2);
                break;
        }
    }
}
