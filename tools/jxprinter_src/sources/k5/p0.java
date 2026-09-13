package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPlotAreaImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class p0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5664a;
    public final /* synthetic */ CTPlotAreaImpl b;

    public /* synthetic */ p0(CTPlotAreaImpl cTPlotAreaImpl, int i5) {
        this.f5664a = i5;
        this.b = cTPlotAreaImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5664a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewBarChart(iIntValue);
            case 1:
                return this.b.insertNewDoughnutChart(iIntValue);
            case 2:
                return this.b.getPieChartArray(iIntValue);
            case 3:
                return this.b.insertNewPieChart(iIntValue);
            case 4:
                return this.b.getArea3DChartArray(iIntValue);
            case 5:
                return this.b.insertNewArea3DChart(iIntValue);
            case 6:
                return this.b.getAreaChartArray(iIntValue);
            case 7:
                return this.b.insertNewAreaChart(iIntValue);
            case 8:
                return this.b.getSerAxArray(iIntValue);
            default:
                return this.b.insertNewSerAx(iIntValue);
        }
    }
}
