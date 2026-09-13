package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class G implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8272a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ G(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8272a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8272a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setOMathArray(iIntValue, (CTOMath) obj2);
                break;
            case 1:
                this.b.setSubDocArray(iIntValue, (CTRel) obj2);
                break;
            case 2:
                this.b.setOMathParaArray(iIntValue, (CTOMathPara) obj2);
                break;
            default:
                this.b.setMoveToRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
        }
    }
}
