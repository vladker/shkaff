package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.j2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1688j2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8428a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1688j2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8428a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlDelRangeStartArray;
        switch (this.f8428a) {
            case 0:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 1:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfPermEndArray();
                break;
            case 2:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfEqArrArray();
                break;
            case 3:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 4:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 5:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 6:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfOMathParaArray();
                break;
            case 7:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfSmartTagArray();
                break;
            case 8:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfCustomXmlArray();
                break;
            case 9:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 10:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfRArray();
                break;
            case 11:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfProofErrArray();
                break;
            case 12:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfSdtArray();
                break;
            case 13:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 14:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfBoxArray();
                break;
            case 15:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 16:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfSSubSupArray();
                break;
            case 17:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfPermStartArray();
                break;
            case 18:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfSPreArray();
                break;
            case 19:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfNaryArray();
                break;
            case 20:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfDArray();
                break;
            case 21:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfPhantArray();
                break;
            case 22:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfBarArray();
                break;
            case 23:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMArray();
                break;
            case 24:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 25:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMoveToArray();
                break;
            case 26:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfDirArray();
                break;
            case 27:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfAccArray();
                break;
            case 28:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            default:
                iSizeOfCustomXmlDelRangeStartArray = this.b.sizeOfDelArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlDelRangeStartArray);
    }
}
