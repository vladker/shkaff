package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDirContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class S implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8331a;
    public final /* synthetic */ CTDirContentRunImpl b;

    public /* synthetic */ S(CTDirContentRunImpl cTDirContentRunImpl, int i5) {
        this.f8331a = i5;
        this.b = cTDirContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfOMathArray;
        switch (this.f8331a) {
            case 0:
                iSizeOfOMathArray = this.b.sizeOfOMathArray();
                break;
            case 1:
                iSizeOfOMathArray = this.b.sizeOfCustomXmlMoveFromRangeEndArray();
                break;
            case 2:
                iSizeOfOMathArray = this.b.sizeOfCommentRangeEndArray();
                break;
            default:
                iSizeOfOMathArray = this.b.sizeOfInsArray();
                break;
        }
        return Integer.valueOf(iSizeOfOMathArray);
    }
}
