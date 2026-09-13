package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class i0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7812a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ i0(CTRImpl cTRImpl, int i5) {
        this.f7812a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7812a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFootnoteRef(iIntValue);
                break;
            case 1:
                this.b.removeDayShort(iIntValue);
                break;
            case 2:
                this.b.removeEndnoteReference(iIntValue);
                break;
            case 3:
                this.b.removeEndnoteRef(iIntValue);
                break;
            case 4:
                this.b.removeContinuationSeparator(iIntValue);
                break;
            case 5:
                this.b.removeBr(iIntValue);
                break;
            case 6:
                this.b.removeCommentReference(iIntValue);
                break;
            case 7:
                this.b.removeMonthLong(iIntValue);
                break;
            case 8:
                this.b.removeDayLong(iIntValue);
                break;
            case 9:
                this.b.removeSym(iIntValue);
                break;
            case 10:
                this.b.removeTab(iIntValue);
                break;
            case 11:
                this.b.removePtab(iIntValue);
                break;
            case 12:
                this.b.removeContentPart(iIntValue);
                break;
            case 13:
                this.b.removeDrawing(iIntValue);
                break;
            case 14:
                this.b.removeT2(iIntValue);
                break;
            case 15:
                this.b.removeAnnotationRef(iIntValue);
                break;
            case 16:
                this.b.removeYearShort(iIntValue);
                break;
            case 17:
                this.b.removeInstrText(iIntValue);
                break;
            case 18:
                this.b.removeDelText(iIntValue);
                break;
            case 19:
                this.b.removePict(iIntValue);
                break;
            case 20:
                this.b.removeSeparator(iIntValue);
                break;
            case 21:
                this.b.removeSoftHyphen(iIntValue);
                break;
            case 22:
                this.b.removeYearLong(iIntValue);
                break;
            case 23:
                this.b.removeCr(iIntValue);
                break;
            case 24:
                this.b.removeT(iIntValue);
                break;
            case 25:
                this.b.removeMonthShort(iIntValue);
                break;
            case 26:
                this.b.removeFldChar(iIntValue);
                break;
            case 27:
                this.b.removeRuby(iIntValue);
                break;
            case 28:
                this.b.removeNoBreakHyphen(iIntValue);
                break;
            default:
                this.b.removeFootnoteReference(iIntValue);
                break;
        }
    }
}
