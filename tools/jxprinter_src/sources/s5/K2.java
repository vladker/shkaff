package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentBlockImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class K2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8295a;
    public final /* synthetic */ CTSdtContentBlockImpl b;

    public /* synthetic */ K2(CTSdtContentBlockImpl cTSdtContentBlockImpl, int i5) {
        this.f8295a = i5;
        this.b = cTSdtContentBlockImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDelArray;
        switch (this.f8295a) {
            case 0:
                iSizeOfDelArray = this.b.sizeOfDelArray();
                break;
            case 1:
                iSizeOfDelArray = this.b.sizeOfTblArray();
                break;
            case 2:
                iSizeOfDelArray = this.b.sizeOfPermStartArray();
                break;
            case 3:
                iSizeOfDelArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 4:
                iSizeOfDelArray = this.b.sizeOfProofErrArray();
                break;
            case 5:
                iSizeOfDelArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 6:
                iSizeOfDelArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 7:
                iSizeOfDelArray = this.b.sizeOfOMathArray();
                break;
            case 8:
                iSizeOfDelArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 9:
                iSizeOfDelArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 10:
                iSizeOfDelArray = this.b.sizeOfPArray();
                break;
            case 11:
                iSizeOfDelArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 12:
                iSizeOfDelArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 13:
                iSizeOfDelArray = this.b.sizeOfMoveFromArray();
                break;
            case 14:
                iSizeOfDelArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 15:
                iSizeOfDelArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 16:
                iSizeOfDelArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 17:
                iSizeOfDelArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 18:
                iSizeOfDelArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 19:
                iSizeOfDelArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 20:
                iSizeOfDelArray = this.b.sizeOfCustomXmlArray();
                break;
            case 21:
                iSizeOfDelArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 22:
                iSizeOfDelArray = this.b.sizeOfInsArray();
                break;
            case 23:
                iSizeOfDelArray = this.b.sizeOfMoveToArray();
                break;
            case 24:
                iSizeOfDelArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 25:
                iSizeOfDelArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 26:
                iSizeOfDelArray = this.b.sizeOfSdtArray();
                break;
            case 27:
                iSizeOfDelArray = this.b.sizeOfOMathParaArray();
                break;
            default:
                iSizeOfDelArray = this.b.sizeOfPermEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfDelArray);
    }
}
