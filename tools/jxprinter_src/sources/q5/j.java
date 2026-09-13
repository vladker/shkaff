package q5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7864a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ j(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f7864a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCxnSpArray;
        switch (this.f7864a) {
            case 0:
                iSizeOfCxnSpArray = this.b.sizeOfCxnSpArray();
                break;
            case 1:
                iSizeOfCxnSpArray = this.b.sizeOfGraphicFrameArray();
                break;
            case 2:
                iSizeOfCxnSpArray = this.b.sizeOfGrpSpArray();
                break;
            case 3:
                iSizeOfCxnSpArray = this.b.sizeOfPicArray();
                break;
            case 4:
                iSizeOfCxnSpArray = this.b.sizeOfSpArray();
                break;
            default:
                iSizeOfCxnSpArray = this.b.sizeOfContentPartArray();
                break;
        }
        return Integer.valueOf(iSizeOfCxnSpArray);
    }
}
