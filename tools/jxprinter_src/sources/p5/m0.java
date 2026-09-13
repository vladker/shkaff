package p5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class m0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7820a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ m0(CTRImpl cTRImpl, int i5) {
        this.f7820a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7820a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setFootnoteReferenceArray(iIntValue, (CTFtnEdnRef) obj2);
                break;
            case 1:
                this.b.setPgNumArray(iIntValue, (CTEmpty) obj2);
                break;
            case 2:
                this.b.setLastRenderedPageBreakArray(iIntValue, (CTEmpty) obj2);
                break;
            default:
                this.b.setObjectArray(iIntValue, (CTObject) obj2);
                break;
        }
    }
}
