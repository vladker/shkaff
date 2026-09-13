package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.y1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1761y1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8502a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1761y1(CTRImpl cTRImpl, int i5) {
        this.f8502a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCommentReferenceArray;
        switch (this.f8502a) {
            case 0:
                iSizeOfCommentReferenceArray = this.b.sizeOfCommentReferenceArray();
                break;
            case 1:
                iSizeOfCommentReferenceArray = this.b.sizeOfLastRenderedPageBreakArray();
                break;
            default:
                iSizeOfCommentReferenceArray = this.b.sizeOfDelTextArray();
                break;
        }
        return Integer.valueOf(iSizeOfCommentReferenceArray);
    }
}
