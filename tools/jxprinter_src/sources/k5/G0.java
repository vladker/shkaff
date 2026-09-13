package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTSurface3DChartImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5608a;
    public final /* synthetic */ CTSurface3DChartImpl b;

    public /* synthetic */ G0(CTSurface3DChartImpl cTSurface3DChartImpl, int i5) {
        this.f5608a = i5;
        this.b = cTSurface3DChartImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5608a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAxIdArray(iIntValue, (CTUnsignedInt) obj2);
                break;
            default:
                this.b.setSerArray(iIntValue, (CTSurfaceSer) obj2);
                break;
        }
    }
}
