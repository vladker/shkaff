package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHdrFtrImpl;

/* JADX INFO: renamed from: s5.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1730s0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8471a;
    public final /* synthetic */ CTHdrFtrImpl b;

    public /* synthetic */ C1730s0(CTHdrFtrImpl cTHdrFtrImpl, int i5) {
        this.f8471a = i5;
        this.b = cTHdrFtrImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveToRangeEndArray;
        switch (this.f8471a) {
            case 0:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 3:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 4:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 5:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfOMathArray();
                break;
            case 6:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 7:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 8:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 9:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 10:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 11:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfPArray();
                break;
            case 12:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 13:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveToArray();
                break;
            case 14:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfAltChunkArray();
                break;
            case 15:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfPermEndArray();
                break;
            case 16:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 17:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfPermStartArray();
                break;
            case 18:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfProofErrArray();
                break;
            case 19:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 20:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 21:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 22:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 23:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 24:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 25:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 26:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 27:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 28:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            default:
                iSizeOfCustomXmlMoveToRangeEndArray = this.b.sizeOfTblArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveToRangeEndArray);
    }
}
