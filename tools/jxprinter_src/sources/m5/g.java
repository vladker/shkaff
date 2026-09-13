package m5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class g implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6181a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ g(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f6181a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6181a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeGrpSp(iIntValue);
                break;
            case 1:
                this.b.removePic(iIntValue);
                break;
            case 2:
                this.b.removeSp(iIntValue);
                break;
            case 3:
                this.b.removeCxnSp(iIntValue);
                break;
            default:
                this.b.removeGraphicFrame(iIntValue);
                break;
        }
    }
}
