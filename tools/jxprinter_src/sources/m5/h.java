package m5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6182a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ h(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f6182a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfGrpSpArray;
        switch (this.f6182a) {
            case 0:
                iSizeOfGrpSpArray = this.b.sizeOfGrpSpArray();
                break;
            case 1:
                iSizeOfGrpSpArray = this.b.sizeOfPicArray();
                break;
            case 2:
                iSizeOfGrpSpArray = this.b.sizeOfSpArray();
                break;
            case 3:
                iSizeOfGrpSpArray = this.b.sizeOfCxnSpArray();
                break;
            default:
                iSizeOfGrpSpArray = this.b.sizeOfGraphicFrameArray();
                break;
        }
        return Integer.valueOf(iSizeOfGrpSpArray);
    }
}
