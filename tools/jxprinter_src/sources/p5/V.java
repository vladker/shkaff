package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class V implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7790a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ V(CTOMathImpl cTOMathImpl, int i5) {
        this.f7790a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCustomXmlInsRangeStartArray;
        switch (this.f7790a) {
            case 0:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 1:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfLimUppArray();
                break;
            case 2:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveFromArray();
                break;
            case 3:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfSSupArray();
                break;
            case 4:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfBorderBoxArray();
                break;
            case 5:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfAccArray();
                break;
            case 6:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 7:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfEqArrArray();
                break;
            case 8:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlArray();
                break;
            case 9:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 10:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfDelArray();
                break;
            case 11:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 12:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 13:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfGroupChrArray();
                break;
            case 14:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfDArray();
                break;
            case 15:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfSSubArray();
                break;
            case 16:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 17:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfFuncArray();
                break;
            case 18:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfPermEndArray();
                break;
            default:
                iSizeOfCustomXmlInsRangeStartArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
        }
        return Integer.valueOf(iSizeOfCustomXmlInsRangeStartArray);
    }
}
