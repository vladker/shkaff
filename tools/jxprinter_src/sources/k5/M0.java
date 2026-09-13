package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTSurfaceChartImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class M0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5620a;
    public final /* synthetic */ CTSurfaceChartImpl b;

    public /* synthetic */ M0(CTSurfaceChartImpl cTSurfaceChartImpl, int i5) {
        this.f5620a = i5;
        this.b = cTSurfaceChartImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAxIdArray;
        switch (this.f5620a) {
            case 0:
                iSizeOfAxIdArray = this.b.sizeOfAxIdArray();
                break;
            default:
                iSizeOfAxIdArray = this.b.sizeOfSerArray();
                break;
        }
        return Integer.valueOf(iSizeOfAxIdArray);
    }
}
