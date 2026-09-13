package p093q2;

import com.microsoft.schemas.office.drawing.x2008.diagram.CTGroupShape;
import com.microsoft.schemas.office.drawing.x2008.diagram.CTShape;
import com.microsoft.schemas.office.drawing.x2008.diagram.impl.CTGroupShapeImpl;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7839a;
    public final /* synthetic */ CTGroupShapeImpl b;

    public /* synthetic */ b(CTGroupShapeImpl cTGroupShapeImpl, int i5) {
        this.f7839a = i5;
        this.b = cTGroupShapeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7839a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSpArray(iIntValue, (CTShape) obj2);
                break;
            default:
                this.b.setGrpSpArray(iIntValue, (CTGroupShape) obj2);
                break;
        }
    }
}
