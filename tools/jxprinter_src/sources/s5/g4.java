package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTxbxContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class g4 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8412a;
    public final /* synthetic */ CTTxbxContentImpl b;

    public /* synthetic */ g4(CTTxbxContentImpl cTTxbxContentImpl, int i5) {
        this.f8412a = i5;
        this.b = cTTxbxContentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTblArray;
        switch (this.f8412a) {
            case 0:
                iSizeOfTblArray = this.b.sizeOfTblArray();
                break;
            case 1:
                iSizeOfTblArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 2:
                iSizeOfTblArray = this.b.sizeOfPermStartArray();
                break;
            case 3:
                iSizeOfTblArray = this.b.sizeOfOMathParaArray();
                break;
            case 4:
                iSizeOfTblArray = this.b.sizeOfMoveToArray();
                break;
            case 5:
                iSizeOfTblArray = this.b.sizeOfSdtArray();
                break;
            case 6:
                iSizeOfTblArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 7:
                iSizeOfTblArray = this.b.sizeOfInsArray();
                break;
            case 8:
                iSizeOfTblArray = this.b.sizeOfMoveFromArray();
                break;
            case 9:
                iSizeOfTblArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 10:
                iSizeOfTblArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 11:
                iSizeOfTblArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 12:
                iSizeOfTblArray = this.b.sizeOfDelArray();
                break;
            case 13:
                iSizeOfTblArray = this.b.sizeOfProofErrArray();
                break;
            case 14:
                iSizeOfTblArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 15:
                iSizeOfTblArray = this.b.sizeOfPArray();
                break;
            case 16:
                iSizeOfTblArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 17:
                iSizeOfTblArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 18:
                iSizeOfTblArray = this.b.sizeOfOMathArray();
                break;
            case 19:
                iSizeOfTblArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 20:
                iSizeOfTblArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 21:
                iSizeOfTblArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 22:
                iSizeOfTblArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 23:
                iSizeOfTblArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 24:
                iSizeOfTblArray = this.b.sizeOfAltChunkArray();
                break;
            case 25:
                iSizeOfTblArray = this.b.sizeOfCustomXmlArray();
                break;
            case 26:
                iSizeOfTblArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 27:
                iSizeOfTblArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 28:
                iSizeOfTblArray = this.b.sizeOfPermEndArray();
                break;
            default:
                iSizeOfTblArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfTblArray);
    }
}
