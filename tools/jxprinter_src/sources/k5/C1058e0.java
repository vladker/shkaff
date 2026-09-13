package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartLines;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTOfPieChartImpl;

/* JADX INFO: renamed from: k5.e0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1058e0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5642a;
    public final /* synthetic */ CTOfPieChartImpl b;

    public /* synthetic */ C1058e0(CTOfPieChartImpl cTOfPieChartImpl, int i5) {
        this.f5642a = i5;
        this.b = cTOfPieChartImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5642a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSerArray(iIntValue, (CTPieSer) obj2);
                break;
            default:
                this.b.setSerLinesArray(iIntValue, (CTChartLines) obj2);
                break;
        }
    }
}
