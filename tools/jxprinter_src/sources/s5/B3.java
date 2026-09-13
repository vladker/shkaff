package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class B3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8251a;
    public final /* synthetic */ CTSmartTagRunImpl b;

    public /* synthetic */ B3(CTSmartTagRunImpl cTSmartTagRunImpl, int i5) {
        this.f8251a = i5;
        this.b = cTSmartTagRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFldSimpleArray;
        switch (this.f8251a) {
            case 0:
                iSizeOfFldSimpleArray = this.b.sizeOfFldSimpleArray();
                break;
            case 1:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 2:
                iSizeOfFldSimpleArray = this.b.sizeOfSdtArray();
                break;
            case 3:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 4:
                iSizeOfFldSimpleArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 5:
                iSizeOfFldSimpleArray = this.b.sizeOfBdoArray();
                break;
            case 6:
                iSizeOfFldSimpleArray = this.b.sizeOfHyperlinkArray();
                break;
            case 7:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToArray();
                break;
            case 8:
                iSizeOfFldSimpleArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 9:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 10:
                iSizeOfFldSimpleArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 11:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 12:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 13:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 14:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 15:
                iSizeOfFldSimpleArray = this.b.sizeOfProofErrArray();
                break;
            case 16:
                iSizeOfFldSimpleArray = this.b.sizeOfOMathParaArray();
                break;
            case 17:
                iSizeOfFldSimpleArray = this.b.sizeOfDirArray();
                break;
            case 18:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 19:
                iSizeOfFldSimpleArray = this.b.sizeOfPermStartArray();
                break;
            case 20:
                iSizeOfFldSimpleArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 21:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 22:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveFromArray();
                break;
            case 23:
                iSizeOfFldSimpleArray = this.b.sizeOfSubDocArray();
                break;
            case 24:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 25:
                iSizeOfFldSimpleArray = this.b.sizeOfOMathArray();
                break;
            case 26:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlArray();
                break;
            case 27:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 28:
                iSizeOfFldSimpleArray = this.b.sizeOfPermEndArray();
                break;
            default:
                iSizeOfFldSimpleArray = this.b.sizeOfRArray();
                break;
        }
        return Integer.valueOf(iSizeOfFldSimpleArray);
    }
}
