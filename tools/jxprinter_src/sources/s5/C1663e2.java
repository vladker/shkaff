package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRubyContentImpl;

/* JADX INFO: renamed from: s5.e2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1663e2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8398a;
    public final /* synthetic */ CTRubyContentImpl b;

    public /* synthetic */ C1663e2(CTRubyContentImpl cTRubyContentImpl, int i5) {
        this.f8398a = i5;
        this.b = cTRubyContentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMoveToArray;
        switch (this.f8398a) {
            case 0:
                iSizeOfMoveToArray = this.b.sizeOfMoveToArray();
                break;
            case 1:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            case 2:
                iSizeOfMoveToArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 3:
                iSizeOfMoveToArray = this.b.sizeOfMoveToRangeEndArray();
                break;
            case 4:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 5:
                iSizeOfMoveToArray = this.b.sizeOfMoveFromArray();
                break;
            case 6:
                iSizeOfMoveToArray = this.b.sizeOfPermEndArray();
                break;
            case 7:
                iSizeOfMoveToArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 8:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 9:
                iSizeOfMoveToArray = this.b.sizeOfMoveFromRangeStartArray();
                break;
            case 10:
                iSizeOfMoveToArray = this.b.sizeOfBookmarkStartArray();
                break;
            case 11:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlMoveFromRangeStartArray();
                break;
            case 12:
                iSizeOfMoveToArray = this.b.sizeOfRArray();
                break;
            case 13:
                iSizeOfMoveToArray = this.b.sizeOfOMathParaArray();
                break;
            case 14:
                iSizeOfMoveToArray = this.b.sizeOfProofErrArray();
                break;
            case 15:
                iSizeOfMoveToArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
            case 16:
                iSizeOfMoveToArray = this.b.sizeOfDelArray();
                break;
            case 17:
                iSizeOfMoveToArray = this.b.sizeOfOMathArray();
                break;
            case 18:
                iSizeOfMoveToArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            case 19:
                iSizeOfMoveToArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 20:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 21:
                iSizeOfMoveToArray = this.b.sizeOfInsArray();
                break;
            case 22:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlDelRangeEndArray();
                break;
            case 23:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlMoveToRangeEndArray();
                break;
            case 24:
                iSizeOfMoveToArray = this.b.sizeOfCustomXmlDelRangeStartArray();
                break;
            default:
                iSizeOfMoveToArray = this.b.sizeOfPermStartArray();
                break;
        }
        return Integer.valueOf(iSizeOfMoveToArray);
    }
}
