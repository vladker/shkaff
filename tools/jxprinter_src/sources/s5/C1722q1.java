package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.q1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1722q1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8462a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1722q1(CTRImpl cTRImpl, int i5) {
        this.f8462a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8462a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getTabArray(iIntValue);
            case 1:
                return this.b.getFootnoteReferenceArray(iIntValue);
            case 2:
                return this.b.insertNewFootnoteReference(iIntValue);
            case 3:
                return this.b.getMonthLongArray(iIntValue);
            case 4:
                return this.b.insertNewMonthLong(iIntValue);
            case 5:
                return this.b.getSoftHyphenArray(iIntValue);
            case 6:
                return this.b.getInstrTextArray(iIntValue);
            case 7:
                return this.b.insertNewInstrText(iIntValue);
            case 8:
                return this.b.getFldCharArray(iIntValue);
            case 9:
                return this.b.insertNewFldChar(iIntValue);
            case 10:
                return this.b.getContentPartArray(iIntValue);
            case 11:
                return this.b.insertNewContentPart(iIntValue);
            case 12:
                return this.b.getRubyArray(iIntValue);
            case 13:
                return this.b.insertNewRuby(iIntValue);
            case 14:
                return this.b.insertNewSoftHyphen(iIntValue);
            case 15:
                return this.b.getSeparatorArray(iIntValue);
            case 16:
                return this.b.insertNewSeparator(iIntValue);
            case 17:
                return this.b.getDayShortArray(iIntValue);
            case 18:
                return this.b.insertNewDayShort(iIntValue);
            case 19:
                return this.b.getDayLongArray(iIntValue);
            case 20:
                return this.b.insertNewDayLong(iIntValue);
            case 21:
                return this.b.getCrArray(iIntValue);
            case 22:
                return this.b.insertNewCr(iIntValue);
            case 23:
                return this.b.getDrawingArray(iIntValue);
            case 24:
                return this.b.insertNewDrawing(iIntValue);
            case 25:
                return this.b.getContinuationSeparatorArray(iIntValue);
            case 26:
                return this.b.insertNewContinuationSeparator(iIntValue);
            case 27:
                return this.b.getSymArray(iIntValue);
            case 28:
                return this.b.getYearShortArray(iIntValue);
            default:
                return this.b.insertNewYearShort(iIntValue);
        }
    }
}
