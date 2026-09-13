package m5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTConnector;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTGroupShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6180a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ f(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f6180a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6180a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setGrpSpArray(iIntValue, (CTGroupShape) obj2);
                break;
            case 1:
                this.b.setPicArray(iIntValue, (CTPicture) obj2);
                break;
            case 2:
                this.b.setCxnSpArray(iIntValue, (CTConnector) obj2);
                break;
            case 3:
                this.b.setSpArray(iIntValue, (CTShape) obj2);
                break;
            default:
                this.b.setGraphicFrameArray(iIntValue, (CTGraphicalObjectFrame) obj2);
                break;
        }
    }
}
