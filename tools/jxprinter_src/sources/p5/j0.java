package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7814a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ j0(CTRImpl cTRImpl, int i5) {
        this.f7814a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFootnoteRefArray;
        switch (this.f7814a) {
            case 0:
                iSizeOfFootnoteRefArray = this.b.sizeOfFootnoteRefArray();
                break;
            case 1:
                iSizeOfFootnoteRefArray = this.b.sizeOfDayShortArray();
                break;
            case 2:
                iSizeOfFootnoteRefArray = this.b.sizeOfEndnoteReferenceArray();
                break;
            case 3:
                iSizeOfFootnoteRefArray = this.b.sizeOfEndnoteRefArray();
                break;
            case 4:
                iSizeOfFootnoteRefArray = this.b.sizeOfContinuationSeparatorArray();
                break;
            case 5:
                iSizeOfFootnoteRefArray = this.b.sizeOfBrArray();
                break;
            case 6:
                iSizeOfFootnoteRefArray = this.b.sizeOfCommentReferenceArray();
                break;
            case 7:
                iSizeOfFootnoteRefArray = this.b.sizeOfMonthLongArray();
                break;
            case 8:
                iSizeOfFootnoteRefArray = this.b.sizeOfSymArray();
                break;
            case 9:
                iSizeOfFootnoteRefArray = this.b.sizeOfTabArray();
                break;
            case 10:
                iSizeOfFootnoteRefArray = this.b.sizeOfDayLongArray();
                break;
            case 11:
                iSizeOfFootnoteRefArray = this.b.sizeOfPtabArray();
                break;
            case 12:
                iSizeOfFootnoteRefArray = this.b.sizeOfContentPartArray();
                break;
            case 13:
                iSizeOfFootnoteRefArray = this.b.sizeOfDrawingArray();
                break;
            case 14:
                iSizeOfFootnoteRefArray = this.b.sizeOfT2Array();
                break;
            case 15:
                iSizeOfFootnoteRefArray = this.b.sizeOfAnnotationRefArray();
                break;
            case 16:
                iSizeOfFootnoteRefArray = this.b.sizeOfYearShortArray();
                break;
            case 17:
                iSizeOfFootnoteRefArray = this.b.sizeOfInstrTextArray();
                break;
            case 18:
                iSizeOfFootnoteRefArray = this.b.sizeOfDelTextArray();
                break;
            case 19:
                iSizeOfFootnoteRefArray = this.b.sizeOfPictArray();
                break;
            case 20:
                iSizeOfFootnoteRefArray = this.b.sizeOfSoftHyphenArray();
                break;
            case 21:
                iSizeOfFootnoteRefArray = this.b.sizeOfYearLongArray();
                break;
            case 22:
                iSizeOfFootnoteRefArray = this.b.sizeOfSeparatorArray();
                break;
            case 23:
                iSizeOfFootnoteRefArray = this.b.sizeOfCrArray();
                break;
            case 24:
                iSizeOfFootnoteRefArray = this.b.sizeOfTArray();
                break;
            case 25:
                iSizeOfFootnoteRefArray = this.b.sizeOfMonthShortArray();
                break;
            case 26:
                iSizeOfFootnoteRefArray = this.b.sizeOfFldCharArray();
                break;
            case 27:
                iSizeOfFootnoteRefArray = this.b.sizeOfRubyArray();
                break;
            case 28:
                iSizeOfFootnoteRefArray = this.b.sizeOfNoBreakHyphenArray();
                break;
            default:
                iSizeOfFootnoteRefArray = this.b.sizeOfFootnoteReferenceArray();
                break;
        }
        return Integer.valueOf(iSizeOfFootnoteRefArray);
    }
}
