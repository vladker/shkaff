package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTblImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class P3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8321a;
    public final /* synthetic */ CTTblImpl b;

    public /* synthetic */ P3(CTTblImpl cTTblImpl, int i5) {
        this.f8321a = i5;
        this.b = cTTblImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlInsRangeStartArray;
        switch (this.f8321a) {
            case 0:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 1:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 2:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 3:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlArray();
                break;
            case 4:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfProofErrArray();
                break;
            case 5:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 6:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 7:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 8:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfDelArray();
                break;
            case 9:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 10:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 11:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 12:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 13:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfPermEndArray();
                break;
            case 14:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfPermStartArray();
                break;
            case 15:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfInsArray();
                break;
            case 16:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveToArray();
                break;
            case 17:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfOMathArray();
                break;
            case 18:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 19:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 20:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfSdtArray();
                break;
            case 21:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 22:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfTrArray();
                break;
            case 23:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 24:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 25:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 26:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveFromArray();
                break;
            default:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfOMathParaArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlInsRangeStartArray);
    }
}
