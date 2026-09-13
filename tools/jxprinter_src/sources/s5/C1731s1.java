package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.s1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1731s1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8472a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1731s1(CTRImpl cTRImpl, int i5) {
        this.f8472a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8472a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFootnoteReference(iIntValue);
                break;
            case 1:
                this.b.removeMonthLong(iIntValue);
                break;
            case 2:
                this.b.removeInstrText(iIntValue);
                break;
            case 3:
                this.b.removeFldChar(iIntValue);
                break;
            case 4:
                this.b.removeContentPart(iIntValue);
                break;
            case 5:
                this.b.removeRuby(iIntValue);
                break;
            case 6:
                this.b.removeSeparator(iIntValue);
                break;
            case 7:
                this.b.removeDayShort(iIntValue);
                break;
            case 8:
                this.b.removeSoftHyphen(iIntValue);
                break;
            case 9:
                this.b.removeDayLong(iIntValue);
                break;
            case 10:
                this.b.removeCr(iIntValue);
                break;
            case 11:
                this.b.removeDrawing(iIntValue);
                break;
            case 12:
                this.b.removeContinuationSeparator(iIntValue);
                break;
            case 13:
                this.b.removeYearShort(iIntValue);
                break;
            case 14:
                this.b.removeSym(iIntValue);
                break;
            case 15:
                this.b.removeAnnotationRef(iIntValue);
                break;
            case 16:
                this.b.removePgNum(iIntValue);
                break;
            case 17:
                this.b.removeEndnoteRef(iIntValue);
                break;
            case 18:
                this.b.removeT(iIntValue);
                break;
            case 19:
                this.b.removeTab(iIntValue);
                break;
            case 20:
                this.b.removeFootnoteRef(iIntValue);
                break;
            case 21:
                this.b.removeDelInstrText(iIntValue);
                break;
            case 22:
                this.b.removeNoBreakHyphen(iIntValue);
                break;
            case 23:
                this.b.removePict(iIntValue);
                break;
            case 24:
                this.b.removeYearLong(iIntValue);
                break;
            case 25:
                this.b.removePtab(iIntValue);
                break;
            case 26:
                this.b.removeEndnoteReference(iIntValue);
                break;
            case 27:
                this.b.removeMonthShort(iIntValue);
                break;
            case 28:
                this.b.removeBr(iIntValue);
                break;
            default:
                this.b.removeObject(iIntValue);
                break;
        }
    }
}
