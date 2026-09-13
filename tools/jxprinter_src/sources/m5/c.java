package m5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTDrawingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6177a;
    public final /* synthetic */ CTDrawingImpl b;

    public /* synthetic */ c(CTDrawingImpl cTDrawingImpl, int i5) {
        this.f6177a = i5;
        this.b = cTDrawingImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6177a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeTwoCellAnchor(iIntValue);
                break;
            case 1:
                this.b.removeOneCellAnchor(iIntValue);
                break;
            default:
                this.b.removeAbsoluteAnchor(iIntValue);
                break;
        }
    }
}
