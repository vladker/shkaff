package k5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPlotAreaImpl;

/* JADX INFO: renamed from: k5.m0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1074m0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5658a;
    public final /* synthetic */ CTPlotAreaImpl b;

    public /* synthetic */ C1074m0(CTPlotAreaImpl cTPlotAreaImpl, int i5) {
        this.f5658a = i5;
        this.b = cTPlotAreaImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5658a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeStockChart(iIntValue);
                break;
            case 1:
                this.b.removeBar3DChart(iIntValue);
                break;
            case 2:
                this.b.removeValAx(iIntValue);
                break;
            case 3:
                this.b.removeCatAx(iIntValue);
                break;
            case 4:
                this.b.removeSurfaceChart(iIntValue);
                break;
            case 5:
                this.b.removeRadarChart(iIntValue);
                break;
            case 6:
                this.b.removeBubbleChart(iIntValue);
                break;
            case 7:
                this.b.removeLineChart(iIntValue);
                break;
            case 8:
                this.b.removePie3DChart(iIntValue);
                break;
            case 9:
                this.b.removeDateAx(iIntValue);
                break;
            case 10:
                this.b.removeLine3DChart(iIntValue);
                break;
            case 11:
                this.b.removeSurface3DChart(iIntValue);
                break;
            case 12:
                this.b.removeScatterChart(iIntValue);
                break;
            case 13:
                this.b.removeOfPieChart(iIntValue);
                break;
            case 14:
                this.b.removeBarChart(iIntValue);
                break;
            case 15:
                this.b.removePieChart(iIntValue);
                break;
            case 16:
                this.b.removeArea3DChart(iIntValue);
                break;
            case 17:
                this.b.removeDoughnutChart(iIntValue);
                break;
            case 18:
                this.b.removeAreaChart(iIntValue);
                break;
            default:
                this.b.removeSerAx(iIntValue);
                break;
        }
    }
}
