package p5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTText;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFldChar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdnRef;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRuby;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSym;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7810a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ h0(CTRImpl cTRImpl, int i5) {
        this.f7810a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7810a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setFootnoteRefArray(iIntValue, (CTEmpty) obj2);
                break;
            case 1:
                this.b.setDayShortArray(iIntValue, (CTEmpty) obj2);
                break;
            case 2:
                this.b.setEndnoteReferenceArray(iIntValue, (CTFtnEdnRef) obj2);
                break;
            case 3:
                this.b.setEndnoteRefArray(iIntValue, (CTEmpty) obj2);
                break;
            case 4:
                this.b.setDayLongArray(iIntValue, (CTEmpty) obj2);
                break;
            case 5:
                this.b.setContinuationSeparatorArray(iIntValue, (CTEmpty) obj2);
                break;
            case 6:
                this.b.setBrArray(iIntValue, (CTBr) obj2);
                break;
            case 7:
                this.b.setCommentReferenceArray(iIntValue, (CTMarkup) obj2);
                break;
            case 8:
                this.b.setMonthLongArray(iIntValue, (CTEmpty) obj2);
                break;
            case 9:
                this.b.setSymArray(iIntValue, (CTSym) obj2);
                break;
            case 10:
                this.b.setTabArray(iIntValue, (CTEmpty) obj2);
                break;
            case 11:
                this.b.setPtabArray(iIntValue, (CTPTab) obj2);
                break;
            case 12:
                this.b.setContentPartArray(iIntValue, (CTRel) obj2);
                break;
            case 13:
                this.b.setDrawingArray(iIntValue, (CTDrawing) obj2);
                break;
            case 14:
                this.b.setT2Array(iIntValue, (CTText) obj2);
                break;
            case 15:
                this.b.setAnnotationRefArray(iIntValue, (CTEmpty) obj2);
                break;
            case 16:
                this.b.setSeparatorArray(iIntValue, (CTEmpty) obj2);
                break;
            case 17:
                this.b.setYearShortArray(iIntValue, (CTEmpty) obj2);
                break;
            case 18:
                this.b.setInstrTextArray(iIntValue, (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText) obj2);
                break;
            case 19:
                this.b.setDelTextArray(iIntValue, (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText) obj2);
                break;
            case 20:
                this.b.setPictArray(iIntValue, (CTPicture) obj2);
                break;
            case 21:
                this.b.setSoftHyphenArray(iIntValue, (CTEmpty) obj2);
                break;
            case 22:
                this.b.setYearLongArray(iIntValue, (CTEmpty) obj2);
                break;
            case 23:
                this.b.setCrArray(iIntValue, (CTEmpty) obj2);
                break;
            case 24:
                this.b.setTArray(iIntValue, (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText) obj2);
                break;
            case 25:
                this.b.setMonthShortArray(iIntValue, (CTEmpty) obj2);
                break;
            case 26:
                this.b.setFldCharArray(iIntValue, (CTFldChar) obj2);
                break;
            case 27:
                this.b.setDelInstrTextArray(iIntValue, (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText) obj2);
                break;
            case 28:
                this.b.setRubyArray(iIntValue, (CTRuby) obj2);
                break;
            default:
                this.b.setNoBreakHyphenArray(iIntValue, (CTEmpty) obj2);
                break;
        }
    }
}
