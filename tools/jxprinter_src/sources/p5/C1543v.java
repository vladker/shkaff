package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1543v implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7831a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1543v(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7831a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMoveToArray;
        switch (this.f7831a) {
            case 0:
                iSizeOfMoveToArray = this.b.sizeOfMoveToArray();
                break;
            case 1:
                iSizeOfMoveToArray = this.b.sizeOfBorderBoxArray();
                break;
            case 2:
                iSizeOfMoveToArray = this.b.sizeOfLimUppArray();
                break;
            case 3:
                iSizeOfMoveToArray = this.b.sizeOfPermStartArray();
                break;
            case 4:
                iSizeOfMoveToArray = this.b.sizeOfBoxArray();
                break;
            case 5:
                iSizeOfMoveToArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 6:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 7:
                iSizeOfMoveToArray = this.b.sizeOfPhantArray();
                break;
            case 8:
                iSizeOfMoveToArray = this.b.sizeOfSSupArray();
                break;
            case 9:
                iSizeOfMoveToArray = this.b.sizeOfMArray();
                break;
            case 10:
                iSizeOfMoveToArray = this.b.sizeOfLimLowArray();
                break;
            case 11:
                iSizeOfMoveToArray = this.b.sizeOfProofErrArray();
                break;
            case 12:
                iSizeOfMoveToArray = this.b.sizeOfRArray();
                break;
            case 13:
                iSizeOfMoveToArray = this.b.sizeOfSSubArray();
                break;
            case 14:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 15:
                iSizeOfMoveToArray = this.b.sizeOfOMathArray();
                break;
            case 16:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlArray();
                break;
            case 17:
                iSizeOfMoveToArray = this.b.sizeOfEqArrArray();
                break;
            case 18:
                iSizeOfMoveToArray = this.b.sizeOfSSubSupArray();
                break;
            default:
                iSizeOfMoveToArray = this.b.sizeOfPermEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfMoveToArray);
    }
}
