package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class g0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7808a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ g0(CTRImpl cTRImpl, int i5) {
        this.f7808a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7808a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSeparatorArray(iIntValue);
            case 1:
                return this.b.getFootnoteRefArray(iIntValue);
            case 2:
                return this.b.insertNewFootnoteRef(iIntValue);
            case 3:
                return this.b.getDayShortArray(iIntValue);
            case 4:
                return this.b.insertNewDayShort(iIntValue);
            case 5:
                return this.b.getDayLongArray(iIntValue);
            case 6:
                return this.b.getEndnoteReferenceArray(iIntValue);
            case 7:
                return this.b.insertNewEndnoteReference(iIntValue);
            case 8:
                return this.b.getEndnoteRefArray(iIntValue);
            case 9:
                return this.b.insertNewEndnoteRef(iIntValue);
            case 10:
                return this.b.getContinuationSeparatorArray(iIntValue);
            case 11:
                return this.b.insertNewContinuationSeparator(iIntValue);
            case 12:
                return this.b.getBrArray(iIntValue);
            case 13:
                return this.b.insertNewBr(iIntValue);
            case 14:
                return this.b.insertNewDayLong(iIntValue);
            case 15:
                return this.b.getCommentReferenceArray(iIntValue);
            case 16:
                return this.b.insertNewCommentReference(iIntValue);
            case 17:
                return this.b.getMonthLongArray(iIntValue);
            case 18:
                return this.b.insertNewMonthLong(iIntValue);
            case 19:
                return this.b.getSymArray(iIntValue);
            case 20:
                return this.b.insertNewSym(iIntValue);
            case 21:
                return this.b.getTabArray(iIntValue);
            case 22:
                return this.b.insertNewTab(iIntValue);
            case 23:
                return this.b.getPtabArray(iIntValue);
            case 24:
                return this.b.insertNewPtab(iIntValue);
            case 25:
                return this.b.getContentPartArray(iIntValue);
            case 26:
                return this.b.insertNewContentPart(iIntValue);
            case 27:
                return this.b.getAnnotationRefArray(iIntValue);
            case 28:
                return this.b.getDrawingArray(iIntValue);
            default:
                return this.b.insertNewDrawing(iIntValue);
        }
    }
}
