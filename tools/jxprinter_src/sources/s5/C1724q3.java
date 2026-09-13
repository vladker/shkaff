package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.q3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1724q3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8464a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1724q3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8464a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfProofErrArray;
        switch (this.f8464a) {
            case 0:
                iSizeOfProofErrArray = this.b.sizeOfProofErrArray();
                break;
            case 1:
                iSizeOfProofErrArray = this.b.sizeOfFldSimpleArray();
                break;
            case 2:
                iSizeOfProofErrArray = this.b.sizeOfSubDocArray();
                break;
            case 3:
                iSizeOfProofErrArray = this.b.sizeOfBdoArray();
                break;
            case 4:
                iSizeOfProofErrArray = this.b.sizeOfDelArray();
                break;
            case 5:
                iSizeOfProofErrArray = this.b.sizeOfPermEndArray();
                break;
            case 6:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlArray();
                break;
            case 7:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 8:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 9:
                iSizeOfProofErrArray = this.b.sizeOfMoveToArray();
                break;
            case 10:
                iSizeOfProofErrArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 11:
                iSizeOfProofErrArray = this.b.sizeOfPermStartArray();
                break;
            case 12:
                iSizeOfProofErrArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 13:
                iSizeOfProofErrArray = this.b.sizeOfDirArray();
                break;
            case 14:
                iSizeOfProofErrArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 15:
                iSizeOfProofErrArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 16:
                iSizeOfProofErrArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 17:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 18:
                iSizeOfProofErrArray = this.b.sizeOfHyperlinkArray();
                break;
            case 19:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 20:
                iSizeOfProofErrArray = this.b.sizeOfSdtArray();
                break;
            case 21:
                iSizeOfProofErrArray = this.b.sizeOfRArray();
                break;
            case 22:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 23:
                iSizeOfProofErrArray = this.b.sizeOfSmartTagArray();
                break;
            case 24:
                iSizeOfProofErrArray = this.b.sizeOfOMathArray();
                break;
            case 25:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 26:
                iSizeOfProofErrArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 27:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            case 28:
                iSizeOfProofErrArray = this.b.sizeOfOMathParaArray();
                break;
            default:
                iSizeOfProofErrArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfProofErrArray);
    }
}
