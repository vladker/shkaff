package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class O0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8313a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ O0(CTPImpl cTPImpl, int i5) {
        this.f8313a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBookmarkEndArray;
        switch (this.f8313a) {
            case 0:
                iSizeOfBookmarkEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 1:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 2:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 3:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 4:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 5:
                iSizeOfBookmarkEndArray = this.b.sizeOfSdtArray();
                break;
            case 6:
                iSizeOfBookmarkEndArray = this.b.sizeOfBdoArray();
                break;
            case 7:
                iSizeOfBookmarkEndArray = this.b.sizeOfDirArray();
                break;
            case 8:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 9:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 10:
                iSizeOfBookmarkEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 11:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 12:
                iSizeOfBookmarkEndArray = this.b.sizeOfSmartTagArray();
                break;
            case 13:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveToArray();
                break;
            case 14:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 15:
                iSizeOfBookmarkEndArray = this.b.sizeOfFldSimpleArray();
                break;
            case 16:
                iSizeOfBookmarkEndArray = this.b.sizeOfInsArray();
                break;
            case 17:
                iSizeOfBookmarkEndArray = this.b.sizeOfHyperlinkArray();
                break;
            case 18:
                iSizeOfBookmarkEndArray = this.b.sizeOfSubDocArray();
                break;
            case 19:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 20:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 21:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 22:
                iSizeOfBookmarkEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 23:
                iSizeOfBookmarkEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 24:
                iSizeOfBookmarkEndArray = this.b.sizeOfPermEndArray();
                break;
            case 25:
                iSizeOfBookmarkEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 26:
                iSizeOfBookmarkEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 27:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 28:
                iSizeOfBookmarkEndArray = this.b.sizeOfPermStartArray();
                break;
            default:
                iSizeOfBookmarkEndArray = this.b.sizeOfOMathArray();
                break;
        }
        return Integer.valueOf(iSizeOfBookmarkEndArray);
    }
}
