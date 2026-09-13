package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentCellImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Q2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8325a;
    public final /* synthetic */ CTSdtContentCellImpl b;

    public /* synthetic */ Q2(CTSdtContentCellImpl cTSdtContentCellImpl, int i5) {
        this.f8325a = i5;
        this.b = cTSdtContentCellImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMoveToRangeEndArray;
        switch (this.f8325a) {
            case 0:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 1:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 2:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 3:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 4:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 5:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfProofErrArray();
                break;
            case 6:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 7:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 8:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 9:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 10:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 11:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveToArray();
                break;
            case 12:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfOMathArray();
                break;
            case 13:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 14:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 15:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 16:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 17:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 18:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfPermEndArray();
                break;
            case 19:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfTcArray();
                break;
            case 20:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 21:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 22:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 23:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 24:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 25:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 26:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfPermStartArray();
                break;
            default:
                iSizeOfMoveToRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
        }
        return Integer.valueOf(iSizeOfMoveToRangeEndArray);
    }
}
