package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class B0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8248a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ B0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8248a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8248a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCustomXmlInsRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 1:
                this.b.setFldSimpleArray(iIntValue, (CTSimpleField) obj2);
                break;
            case 2:
                this.b.setMoveToArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            default:
                this.b.setOMathParaArray(iIntValue, (CTOMathPara) obj2);
                break;
        }
    }
}
