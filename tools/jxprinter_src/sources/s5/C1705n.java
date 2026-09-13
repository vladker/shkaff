package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBodyImpl;

/* JADX INFO: renamed from: s5.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1705n implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8445a;
    public final /* synthetic */ CTBodyImpl b;

    public /* synthetic */ C1705n(CTBodyImpl cTBodyImpl, int i5) {
        this.f8445a = i5;
        this.b = cTBodyImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCommentRangeEndArray;
        switch (this.f8445a) {
            case 0:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 1:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 2:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 3:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 4:
                iSizeOfCommentRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 5:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 6:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 7:
                iSizeOfCommentRangeEndArray = this.b.sizeOfProofErrArray();
                break;
            case 8:
                iSizeOfCommentRangeEndArray = this.b.sizeOfPArray();
                break;
            case 9:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 10:
                iSizeOfCommentRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 11:
                iSizeOfCommentRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 12:
                iSizeOfCommentRangeEndArray = this.b.sizeOfPermEndArray();
                break;
            case 13:
                iSizeOfCommentRangeEndArray = this.b.sizeOfOMathArray();
                break;
            case 14:
                iSizeOfCommentRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 15:
                iSizeOfCommentRangeEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 16:
                iSizeOfCommentRangeEndArray = this.b.sizeOfTblArray();
                break;
            case 17:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 18:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 19:
                iSizeOfCommentRangeEndArray = this.b.sizeOfPermStartArray();
                break;
            case 20:
                iSizeOfCommentRangeEndArray = this.b.sizeOfAltChunkArray();
                break;
            case 21:
                iSizeOfCommentRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 22:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 23:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 24:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 25:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 26:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 27:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveToArray();
                break;
            case 28:
                iSizeOfCommentRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            default:
                iSizeOfCommentRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfCommentRangeEndArray);
    }
}
