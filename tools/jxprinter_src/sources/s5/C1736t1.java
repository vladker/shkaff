package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.t1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1736t1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8477a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1736t1(CTRImpl cTRImpl, int i5) {
        this.f8477a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFootnoteReferenceArray;
        switch (this.f8477a) {
            case 0:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfFootnoteReferenceArray();
                break;
            case 1:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfMonthLongArray();
                break;
            case 2:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfInstrTextArray();
                break;
            case 3:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfFldCharArray();
                break;
            case 4:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfContentPartArray();
                break;
            case 5:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfRubyArray();
                break;
            case 6:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfSeparatorArray();
                break;
            case 7:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfDayShortArray();
                break;
            case 8:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfDayLongArray();
                break;
            case 9:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfCrArray();
                break;
            case 10:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfSoftHyphenArray();
                break;
            case 11:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfDrawingArray();
                break;
            case 12:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfContinuationSeparatorArray();
                break;
            case 13:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfYearShortArray();
                break;
            case 14:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfSymArray();
                break;
            case 15:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfAnnotationRefArray();
                break;
            case 16:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfPgNumArray();
                break;
            case 17:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfEndnoteRefArray();
                break;
            case 18:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfTArray();
                break;
            case 19:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfFootnoteRefArray();
                break;
            case 20:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfDelInstrTextArray();
                break;
            case 21:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfTabArray();
                break;
            case 22:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfNoBreakHyphenArray();
                break;
            case 23:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfPictArray();
                break;
            case 24:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfYearLongArray();
                break;
            case 25:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfPtabArray();
                break;
            case 26:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfEndnoteReferenceArray();
                break;
            case 27:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfMonthShortArray();
                break;
            case 28:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfBrArray();
                break;
            default:
                iSizeOfFootnoteReferenceArray = this.b.sizeOfObjectArray();
                break;
        }
        return Integer.valueOf(iSizeOfFootnoteReferenceArray);
    }
}
