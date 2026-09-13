package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1660e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8395a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1660e(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8395a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveFromRangeEndArray;
        switch (this.f8395a) {
            case 0:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfProofErrArray();
                break;
            case 3:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfFldSimpleArray();
                break;
            case 4:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfHyperlinkArray();
                break;
            case 5:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 6:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDirArray();
                break;
            case 7:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 8:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 9:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 10:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 11:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 12:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSubDocArray();
                break;
            case 13:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToArray();
                break;
            case 14:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 15:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBdoArray();
                break;
            case 16:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 17:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 18:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 19:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 20:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 21:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 22:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfPermStartArray();
                break;
            case 23:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfPermEndArray();
                break;
            case 24:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 25:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 26:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 27:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 28:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSmartTagArray();
                break;
            default:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveFromRangeEndArray);
    }
}
