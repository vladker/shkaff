package m5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6179a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ e(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f6179a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6179a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCxnSpArray(iIntValue);
            case 1:
                return this.b.getGrpSpArray(iIntValue);
            case 2:
                return this.b.insertNewGrpSp(iIntValue);
            case 3:
                return this.b.getPicArray(iIntValue);
            case 4:
                return this.b.insertNewPic(iIntValue);
            case 5:
                return this.b.getSpArray(iIntValue);
            case 6:
                return this.b.insertNewSp(iIntValue);
            case 7:
                return this.b.insertNewCxnSp(iIntValue);
            case 8:
                return this.b.getGraphicFrameArray(iIntValue);
            default:
                return this.b.insertNewGraphicFrame(iIntValue);
        }
    }
}
