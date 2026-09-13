package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTcImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class W3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8355a;
    public final /* synthetic */ CTTcImpl b;

    public /* synthetic */ W3(CTTcImpl cTTcImpl, int i5) {
        this.f8355a = i5;
        this.b = cTTcImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveToRangeStartArray;
        switch (this.f8355a) {
            case 0:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlArray();
                break;
            case 3:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveToArray();
                break;
            case 4:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfTblArray();
                break;
            case 5:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfOMathArray();
                break;
            case 6:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 7:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 8:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 9:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfProofErrArray();
                break;
            case 10:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfAltChunkArray();
                break;
            case 11:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 12:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 13:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 14:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfPermStartArray();
                break;
            case 15:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfDelArray();
                break;
            case 16:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfPermEndArray();
                break;
            case 17:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 18:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 19:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 20:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfOMathParaArray();
                break;
            case 21:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 22:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 23:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfInsArray();
                break;
            case 24:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 25:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 26:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfPArray();
                break;
            case 27:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 28:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfSdtArray();
                break;
            default:
                iSizeOfCustomXmlMoveToRangeStartArray = this.b.sizeOfMoveFromArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveToRangeStartArray);
    }
}
