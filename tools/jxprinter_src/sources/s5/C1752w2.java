package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.w2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1752w2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8493a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1752w2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8493a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfInsArray;
        switch (this.f8493a) {
            case 0:
                iSizeOfInsArray = this.b.sizeOfInsArray();
                break;
            case 1:
                iSizeOfInsArray = this.b.sizeOfBdoArray();
                break;
            case 2:
                iSizeOfInsArray = this.b.sizeOfFuncArray();
                break;
            case 3:
                iSizeOfInsArray = this.b.sizeOfMoveFromArray();
                break;
            case 4:
                iSizeOfInsArray = this.b.sizeOfRadArray();
                break;
            case 5:
                iSizeOfInsArray = this.b.sizeOfFArray();
                break;
            case 6:
                iSizeOfInsArray = this.b.sizeOfSSupArray();
                break;
            case 7:
                iSizeOfInsArray = this.b.sizeOfR2Array();
                break;
            case 8:
                iSizeOfInsArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 9:
                iSizeOfInsArray = this.b.sizeOfOMathArray();
                break;
            case 10:
                iSizeOfInsArray = this.b.sizeOfCustomXmlInsRangeEndArray();
                break;
            case 11:
                iSizeOfInsArray = this.b.sizeOfSSubArray();
                break;
            case 12:
                iSizeOfInsArray = this.b.sizeOfCommentRangeEndArray();
                break;
            case 13:
                iSizeOfInsArray = this.b.sizeOfCommentRangeStartArray();
                break;
            case 14:
                iSizeOfInsArray = this.b.sizeOfGroupChrArray();
                break;
            case 15:
                iSizeOfInsArray = this.b.sizeOfBorderBoxArray();
                break;
            case 16:
                iSizeOfInsArray = this.b.sizeOfCustomXmlInsRangeStartArray();
                break;
            case 17:
                iSizeOfInsArray = this.b.sizeOfLimUppArray();
                break;
            case 18:
                iSizeOfInsArray = this.b.sizeOfLimLowArray();
                break;
            case 19:
                iSizeOfInsArray = this.b.sizeOfCustomXmlMoveToRangeStartArray();
                break;
            default:
                iSizeOfInsArray = this.b.sizeOfBookmarkEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfInsArray);
    }
}
