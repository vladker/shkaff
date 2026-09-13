package p5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: renamed from: p5.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1528f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7805a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1528f(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7805a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7805a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCustomXmlMoveFromRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 1:
                this.b.setDArray(iIntValue, (CTD) obj2);
                break;
            case 2:
                this.b.setOMathParaArray(iIntValue, (CTOMathPara) obj2);
                break;
            case 3:
                this.b.setBookmarkStartArray(iIntValue, (CTBookmark) obj2);
                break;
            case 4:
                this.b.setMoveFromRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
            case 5:
                this.b.setMoveFromRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 6:
                this.b.setDelArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 7:
                this.b.setBookmarkEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 8:
                this.b.setMoveToRangeStartArray(iIntValue, (CTMoveBookmark) obj2);
                break;
            case 9:
                this.b.setCustomXmlInsRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 10:
                this.b.setCommentRangeStartArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 11:
                this.b.setCustomXmlMoveToRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 12:
                this.b.setHyperlinkArray(iIntValue, (CTHyperlink) obj2);
                break;
            case 13:
                this.b.setMoveToRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 14:
                this.b.setCustomXmlDelRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 15:
                this.b.setCustomXmlMoveToRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 16:
                this.b.setCustomXmlDelRangeEndArray(iIntValue, (CTMarkup) obj2);
                break;
            case 17:
                this.b.setSdtArray(iIntValue, (CTSdtRun) obj2);
                break;
            case 18:
                this.b.setInsArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 19:
                this.b.setMoveFromArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 20:
                this.b.setFldSimpleArray(iIntValue, (CTSimpleField) obj2);
                break;
            case 21:
                this.b.setSmartTagArray(iIntValue, (CTSmartTagRun) obj2);
                break;
            case 22:
                this.b.setMoveToArray(iIntValue, (CTRunTrackChange) obj2);
                break;
            case 23:
                this.b.setPermStartArray(iIntValue, (CTPermStart) obj2);
                break;
            case 24:
                this.b.setCommentRangeEndArray(iIntValue, (CTMarkupRange) obj2);
                break;
            case 25:
                this.b.setCustomXmlInsRangeStartArray(iIntValue, (CTTrackChange) obj2);
                break;
            case 26:
                this.b.setMArray(iIntValue, (CTM) obj2);
                break;
            case 27:
                this.b.setProofErrArray(iIntValue, (CTProofErr) obj2);
                break;
            case 28:
                this.b.setRArray(iIntValue, (CTR) obj2);
                break;
            default:
                this.b.setPermEndArray(iIntValue, (CTPerm) obj2);
                break;
        }
    }
}
