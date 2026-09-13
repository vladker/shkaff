package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCommentImpl;

/* JADX INFO: renamed from: s5.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1744v implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8485a;
    public final /* synthetic */ CTCommentImpl b;

    public /* synthetic */ C1744v(CTCommentImpl cTCommentImpl, int i5) {
        this.f8485a = i5;
        this.b = cTCommentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBookmarkStartArray;
        switch (this.f8485a) {
            case 0:
                iSizeOfBookmarkStartArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 1:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveFromArray();
                break;
            case 2:
                iSizeOfBookmarkStartArray = this.b.sizeOfProofErrArray();
                break;
            case 3:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 4:
                iSizeOfBookmarkStartArray = this.b.sizeOfOMathArray();
                break;
            case 5:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 6:
                iSizeOfBookmarkStartArray = this.b.sizeOfInsArray();
                break;
            case 7:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 8:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 9:
                iSizeOfBookmarkStartArray = this.b.sizeOfOMathParaArray();
                break;
            case 10:
                iSizeOfBookmarkStartArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 11:
                iSizeOfBookmarkStartArray = this.b.sizeOfSdtArray();
                break;
            case 12:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 13:
                iSizeOfBookmarkStartArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 14:
                iSizeOfBookmarkStartArray = this.b.sizeOfPArray();
                break;
            case 15:
                iSizeOfBookmarkStartArray = this.b.sizeOfTblArray();
                break;
            case 16:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 17:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 18:
                iSizeOfBookmarkStartArray = this.b.sizeOfAltChunkArray();
                break;
            case 19:
                iSizeOfBookmarkStartArray = this.b.sizeOfDelArray();
                break;
            case 20:
                iSizeOfBookmarkStartArray = this.b.sizeOfPermEndArray();
                break;
            case 21:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 22:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 23:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 24:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlArray();
                break;
            case 25:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 26:
                iSizeOfBookmarkStartArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 27:
                iSizeOfBookmarkStartArray = this.b.sizeOfMoveToArray();
                break;
            case 28:
                iSizeOfBookmarkStartArray = this.b.sizeOfCommentRangeEndArray();
                break;
            default:
                iSizeOfBookmarkStartArray = this.b.sizeOfPermStartArray();
                break;
        }
        return Integer.valueOf(iSizeOfBookmarkStartArray);
    }
}
