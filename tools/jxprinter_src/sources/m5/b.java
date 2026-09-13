package m5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6176a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ b(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f6176a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6176a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setTwoCellAnchorArray(iIntValue, (CTTwoCellAnchor) obj2);
                break;
            case 1:
                this.b.setOneCellAnchorArray(iIntValue, (CTOneCellAnchor) obj2);
                break;
            default:
                this.b.setAbsoluteAnchorArray(iIntValue, (CTAbsoluteAnchor) obj2);
                break;
        }
    }
}
