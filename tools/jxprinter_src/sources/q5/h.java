package q5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTRel;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTGroupShapeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class h implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7862a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ h(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f7862a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7862a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCxnSpArray(iIntValue, (CTConnector) obj2);
                break;
            case 1:
                this.b.setGraphicFrameArray(iIntValue, (CTGraphicalObjectFrame) obj2);
                break;
            case 2:
                this.b.setSpArray(iIntValue, (CTShape) obj2);
                break;
            case 3:
                this.b.setGrpSpArray(iIntValue, (CTGroupShape) obj2);
                break;
            case 4:
                this.b.setPicArray(iIntValue, (CTPicture) obj2);
                break;
            default:
                this.b.setContentPartArray(iIntValue, (CTRel) obj2);
                break;
        }
    }
}
