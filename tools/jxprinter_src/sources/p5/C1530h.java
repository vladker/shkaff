package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1530h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7809a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1530h(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7809a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlMoveFromRangeEndArray;
        switch (this.f7809a) {
            case 0:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 1:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDArray();
                break;
            case 2:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 3:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 4:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfFuncArray();
                break;
            case 5:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 6:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfRadArray();
                break;
            case 7:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 8:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfNaryArray();
                break;
            case 9:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfDelArray();
                break;
            case 10:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfFArray();
                break;
            case 11:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 12:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 13:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfAccArray();
                break;
            case 14:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 15:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 16:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfHyperlinkArray();
                break;
            case 17:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfGroupChrArray();
                break;
            case 18:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 19:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 20:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfBarArray();
                break;
            case 21:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 22:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 23:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 24:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSdtArray();
                break;
            case 25:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSPreArray();
                break;
            case 26:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfInsArray();
                break;
            case 27:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 28:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfFldSimpleArray();
                break;
            default:
                iSizeOfCustomXmlMoveFromRangeEndArray = this.b.sizeOfSmartTagArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlMoveFromRangeEndArray);
    }
}
