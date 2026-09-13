package m5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6178a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ d(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f6178a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTwoCellAnchorArray;
        switch (this.f6178a) {
            case 0:
                iSizeOfTwoCellAnchorArray = this.b.sizeOfTwoCellAnchorArray();
                break;
            case 1:
                iSizeOfTwoCellAnchorArray = this.b.sizeOfOneCellAnchorArray();
                break;
            default:
                iSizeOfTwoCellAnchorArray = this.b.sizeOfAbsoluteAnchorArray();
                break;
        }
        return Integer.valueOf(iSizeOfTwoCellAnchorArray);
    }
}
