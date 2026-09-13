package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class H implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7777a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ H(CTOMathImpl cTOMathImpl, int i5) {
        this.f7777a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfFldSimpleArray;
        switch (this.f7777a) {
            case 0:
                iSizeOfFldSimpleArray = this.b.sizeOfFldSimpleArray();
                break;
            case 1:
                iSizeOfFldSimpleArray = this.b.sizeOfPhantArray();
                break;
            case 2:
                iSizeOfFldSimpleArray = this.b.sizeOfMArray();
                break;
            case 3:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToArray();
                break;
            case 4:
                iSizeOfFldSimpleArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 5:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 6:
                iSizeOfFldSimpleArray = this.b.sizeOfOMathParaArray();
                break;
            case 7:
                iSizeOfFldSimpleArray = this.b.sizeOfBoxArray();
                break;
            case 8:
                iSizeOfFldSimpleArray = this.b.sizeOfInsArray();
                break;
            case 9:
                iSizeOfFldSimpleArray = this.b.sizeOfProofErrArray();
                break;
            case 10:
                iSizeOfFldSimpleArray = this.b.sizeOfRadArray();
                break;
            case 11:
                iSizeOfFldSimpleArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 12:
                iSizeOfFldSimpleArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 13:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 14:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 15:
                iSizeOfFldSimpleArray = this.b.sizeOfNaryArray();
                break;
            case 16:
                iSizeOfFldSimpleArray = this.b.sizeOfSdtArray();
                break;
            case 17:
                iSizeOfFldSimpleArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 18:
                iSizeOfFldSimpleArray = this.b.sizeOfBarArray();
                break;
            case 19:
                iSizeOfFldSimpleArray = this.b.sizeOfLimLowArray();
                break;
            case 20:
                iSizeOfFldSimpleArray = this.b.sizeOfFArray();
                break;
            case 21:
                iSizeOfFldSimpleArray = this.b.sizeOfHyperlinkArray();
                break;
            case 22:
                iSizeOfFldSimpleArray = this.b.sizeOfSSubSupArray();
                break;
            case 23:
                iSizeOfFldSimpleArray = this.b.sizeOfRArray();
                break;
            case 24:
                iSizeOfFldSimpleArray = this.b.sizeOfSmartTagArray();
                break;
            case 25:
                iSizeOfFldSimpleArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 26:
                iSizeOfFldSimpleArray = this.b.sizeOfPermStartArray();
                break;
            case 27:
                iSizeOfFldSimpleArray = this.b.sizeOfOMathArray();
                break;
            case 28:
                iSizeOfFldSimpleArray = this.b.sizeOfSPreArray();
                break;
            default:
                iSizeOfFldSimpleArray = this.b.sizeOfMoveToRangeStartArray();
                break;
        }
        return Integer.valueOf(iSizeOfFldSimpleArray);
    }
}
