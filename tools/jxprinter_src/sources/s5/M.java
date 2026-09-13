package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDirContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class M implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8302a;
    public final /* synthetic */ CTDirContentRunImpl b;

    public /* synthetic */ M(CTDirContentRunImpl cTDirContentRunImpl, int i5) {
        this.f8302a = i5;
        this.b = cTDirContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfPermEndArray;
        switch (this.f8302a) {
            case 0:
                iSizeOfPermEndArray = this.b.sizeOfPermEndArray();
                break;
            case 1:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlArray();
                break;
            case 2:
                iSizeOfPermEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 3:
                iSizeOfPermEndArray = this.b.sizeOfBdoArray();
                break;
            case 4:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 5:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 6:
                iSizeOfPermEndArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 7:
                iSizeOfPermEndArray = this.b.sizeOfDelArray();
                break;
            case 8:
                iSizeOfPermEndArray = this.b.sizeOfProofErrArray();
                break;
            case 9:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 10:
                iSizeOfPermEndArray = this.b.sizeOfHyperlinkArray();
                break;
            case 11:
                iSizeOfPermEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 12:
                iSizeOfPermEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 13:
                iSizeOfPermEndArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 14:
                iSizeOfPermEndArray = this.b.sizeOfPermStartArray();
                break;
            case 15:
                iSizeOfPermEndArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 16:
                iSizeOfPermEndArray = this.b.sizeOfSubDocArray();
                break;
            case 17:
                iSizeOfPermEndArray = this.b.sizeOfRArray();
                break;
            case 18:
                iSizeOfPermEndArray = this.b.sizeOfFldSimpleArray();
                break;
            case 19:
                iSizeOfPermEndArray = this.b.sizeOfSdtArray();
                break;
            case 20:
                iSizeOfPermEndArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 21:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 22:
                iSizeOfPermEndArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 23:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 24:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 25:
                iSizeOfPermEndArray = this.b.sizeOfOMathParaArray();
                break;
            case 26:
                iSizeOfPermEndArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 27:
                iSizeOfPermEndArray = this.b.sizeOfDirArray();
                break;
            case 28:
                iSizeOfPermEndArray = this.b.sizeOfMoveToArray();
                break;
            default:
                iSizeOfPermEndArray = this.b.sizeOfSmartTagArray();
                break;
        }
        return Integer.valueOf(iSizeOfPermEndArray);
    }
}
