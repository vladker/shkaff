package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: renamed from: s5.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1760y0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8501a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ C1760y0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8501a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMoveFromArray;
        switch (this.f8501a) {
            case 0:
                iSizeOfMoveFromArray = this.b.sizeOfMoveFromArray();
                break;
            case 1:
                iSizeOfMoveFromArray = this.b.sizeOfDelArray();
                break;
            case 2:
                iSizeOfMoveFromArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 3:
                iSizeOfMoveFromArray = this.b.sizeOfHyperlinkArray();
                break;
            case 4:
                iSizeOfMoveFromArray = this.b.sizeOfInsArray();
                break;
            case 5:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 6:
                iSizeOfMoveFromArray = this.b.sizeOfPermEndArray();
                break;
            case 7:
                iSizeOfMoveFromArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 8:
                iSizeOfMoveFromArray = this.b.sizeOfProofErrArray();
                break;
            case 9:
                iSizeOfMoveFromArray = this.b.sizeOfSmartTagArray();
                break;
            case 10:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 11:
                iSizeOfMoveFromArray = this.b.sizeOfDirArray();
                break;
            case 12:
                iSizeOfMoveFromArray = this.b.sizeOfSubDocArray();
                break;
            case 13:
                iSizeOfMoveFromArray = this.b.sizeOfOMathArray();
                break;
            case 14:
                iSizeOfMoveFromArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 15:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 16:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 17:
                iSizeOfMoveFromArray = this.b.sizeOfPermStartArray();
                break;
            case 18:
                iSizeOfMoveFromArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 19:
                iSizeOfMoveFromArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 20:
                iSizeOfMoveFromArray = this.b.sizeOfRArray();
                break;
            case 21:
                iSizeOfMoveFromArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 22:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 23:
                iSizeOfMoveFromArray = this.b.sizeOfSdtArray();
                break;
            case 24:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 25:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 26:
                iSizeOfMoveFromArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 27:
                iSizeOfMoveFromArray = this.b.sizeOfBdoArray();
                break;
            case 28:
                iSizeOfMoveFromArray = this.b.sizeOfCommentRangeStartArray();
                break;
            default:
                iSizeOfMoveFromArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfMoveFromArray);
    }
}
