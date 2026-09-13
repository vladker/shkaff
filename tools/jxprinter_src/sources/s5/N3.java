package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTblImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class N3 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8311a;
    public final /* synthetic */ CTTblImpl b;

    public /* synthetic */ N3(CTTblImpl cTTblImpl, int i5) {
        this.f8311a = i5;
        this.b = cTTblImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8311a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCustomXmlInsRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 1:
                this.b.setCustomXmlMoveToRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 2:
                this.b.setBookmarkEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 3:
                this.b.setDelArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 4:
                this.b.setProofErrArray(iIntValue, (CTProofErr) obj2);
                break;
            case 5:
                this.b.setCommentRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 6:
                this.b.setMoveToRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
            case 7:
                this.b.setCustomXmlInsRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 8:
                this.b.setCustomXmlMoveToRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 9:
                this.b.setMoveToArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 10:
                this.b.setMoveFromRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
            case 11:
                this.b.setCommentRangeStartArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 12:
                this.b.setCustomXmlMoveFromRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 13:
                this.b.setPermEndArray(iIntValue, (CTPerm) obj2);
                break;
            case 14:
                this.b.setPermStartArray(iIntValue, (CTPermStart) obj2);
                break;
            case 15:
                this.b.setInsArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 16:
                this.b.setOMathArray(iIntValue, (CTOMath) obj2);
                break;
            case 17:
                this.b.setMoveToRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 18:
                this.b.setMoveFromRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 19:
                this.b.setOMathParaArray(iIntValue, (CTOMathPara) obj2);
                break;
            case 20:
                this.b.setCustomXmlMoveFromRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 21:
                this.b.setTrArray(iIntValue, (CTRow) obj2);
                break;
            case 22:
                this.b.setCustomXmlDelRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 23:
                this.b.setCustomXmlDelRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 24:
                this.b.setBookmarkStartArray(iIntValue, (CTBookmark) obj2);
                break;
            default:
                this.b.setMoveFromArray(iIntValue, (CTRunTrackChange) obj2);
                break;
        }
    }
}
