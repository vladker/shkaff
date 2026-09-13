package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class N0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5937a;
    public final /* synthetic */ CTPath2DImpl b;

    public /* synthetic */ N0(CTPath2DImpl cTPath2DImpl, int i5) {
        this.f5937a = i5;
        this.b = cTPath2DImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5937a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCloseArray(iIntValue, (CTPath2DClose) obj2);
                break;
            case 1:
                this.b.setMoveToArray(iIntValue, (CTPath2DMoveTo) obj2);
                break;
            case 2:
                this.b.setCubicBezToArray(iIntValue, (CTPath2DCubicBezierTo) obj2);
                break;
            case 3:
                this.b.setArcToArray(iIntValue, (CTPath2DArcTo) obj2);
                break;
            case 4:
                this.b.setLnToArray(iIntValue, (CTPath2DLineTo) obj2);
                break;
            default:
                this.b.setQuadBezToArray(iIntValue, (CTPath2DQuadBezierTo) obj2);
                break;
        }
    }
}
