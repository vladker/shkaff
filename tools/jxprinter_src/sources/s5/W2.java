package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class W2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8354a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ W2(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8354a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveFromRangeEndArray;
        switch (this.f8354a) {
            case 0:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 3:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 4:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 5:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 6:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 7:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfOMathArray();
                break;
            case 8:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 9:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfProofErrArray();
                break;
            case 10:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 11:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfRArray();
                break;
            case 12:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfHyperlinkArray();
                break;
            case 13:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 14:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 15:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 16:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSmartTagArray();
                break;
            case 17:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 18:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 19:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSubDocArray();
                break;
            case 20:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 21:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 22:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 23:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToArray();
                break;
            case 24:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 25:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfPermEndArray();
                break;
            case 26:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 27:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDirArray();
                break;
            case 28:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            default:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfFldSimpleArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveFromRangeEndArray);
    }
}
