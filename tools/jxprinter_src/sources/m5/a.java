package m5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6175a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ a(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f6175a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f6175a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getOneCellAnchorArray(iIntValue);
            case 1:
                return this.b.getTwoCellAnchorArray(iIntValue);
            case 2:
                return this.b.insertNewTwoCellAnchor(iIntValue);
            case 3:
                return this.b.insertNewOneCellAnchor(iIntValue);
            case 4:
                return this.b.getAbsoluteAnchorArray(iIntValue);
            default:
                return this.b.insertNewAbsoluteAnchor(iIntValue);
        }
    }
}
