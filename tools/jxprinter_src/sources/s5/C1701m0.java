package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFtnEdnImpl;

/* JADX INFO: renamed from: s5.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1701m0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8441a;
    public final /* synthetic */ CTFtnEdnImpl b;

    public /* synthetic */ C1701m0(CTFtnEdnImpl cTFtnEdnImpl, int i5) {
        this.f8441a = i5;
        this.b = cTFtnEdnImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAltChunkArray;
        switch (this.f8441a) {
            case 0:
                iSizeOfAltChunkArray = this.b.sizeOfAltChunkArray();
                break;
            case 1:
                iSizeOfAltChunkArray = this.b.sizeOfProofErrArray();
                break;
            case 2:
                iSizeOfAltChunkArray = this.b.sizeOfOMathArray();
                break;
            case 3:
                iSizeOfAltChunkArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 4:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlArray();
                break;
            case 5:
                iSizeOfAltChunkArray = this.b.sizeOfTblArray();
                break;
            case 6:
                iSizeOfAltChunkArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 7:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 8:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 9:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 10:
                iSizeOfAltChunkArray = this.b.sizeOfOMathParaArray();
                break;
            case 11:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 12:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 13:
                iSizeOfAltChunkArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 14:
                iSizeOfAltChunkArray = this.b.sizeOfMoveToArray();
                break;
            case 15:
                iSizeOfAltChunkArray = this.b.sizeOfPermEndArray();
                break;
            case 16:
                iSizeOfAltChunkArray = this.b.sizeOfDelArray();
                break;
            case 17:
                iSizeOfAltChunkArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 18:
                iSizeOfAltChunkArray = this.b.sizeOfMoveFromArray();
                break;
            case 19:
                iSizeOfAltChunkArray = this.b.sizeOfPermStartArray();
                break;
            case 20:
                iSizeOfAltChunkArray = this.b.sizeOfInsArray();
                break;
            case 21:
                iSizeOfAltChunkArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 22:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 23:
                iSizeOfAltChunkArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 24:
                iSizeOfAltChunkArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 25:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 26:
                iSizeOfAltChunkArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 27:
                iSizeOfAltChunkArray = this.b.sizeOfPArray();
                break;
            case 28:
                iSizeOfAltChunkArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            default:
                iSizeOfAltChunkArray = this.b.sizeOfSdtArray();
                break;
        }
        return Integer.valueOf(iSizeOfAltChunkArray);
    }
}
