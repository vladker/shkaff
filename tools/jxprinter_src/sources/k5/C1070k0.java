package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPlotAreaImpl;

/* JADX INFO: renamed from: k5.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1070k0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5654a;
    public final /* synthetic */ CTPlotAreaImpl b;

    public /* synthetic */ C1070k0(CTPlotAreaImpl cTPlotAreaImpl, int i5) {
        this.f5654a = i5;
        this.b = cTPlotAreaImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5654a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getBubbleChartArray(iIntValue);
            case 1:
                return this.b.getStockChartArray(iIntValue);
            case 2:
                return this.b.insertNewStockChart(iIntValue);
            case 3:
                return this.b.getBar3DChartArray(iIntValue);
            case 4:
                return this.b.insertNewBar3DChart(iIntValue);
            case 5:
                return this.b.getValAxArray(iIntValue);
            case 6:
                return this.b.insertNewValAx(iIntValue);
            case 7:
                return this.b.getCatAxArray(iIntValue);
            case 8:
                return this.b.insertNewCatAx(iIntValue);
            case 9:
                return this.b.insertNewBubbleChart(iIntValue);
            case 10:
                return this.b.getSurfaceChartArray(iIntValue);
            case 11:
                return this.b.insertNewSurfaceChart(iIntValue);
            case 12:
                return this.b.getRadarChartArray(iIntValue);
            case 13:
                return this.b.insertNewRadarChart(iIntValue);
            case 14:
                return this.b.getLineChartArray(iIntValue);
            case 15:
                return this.b.insertNewLineChart(iIntValue);
            case 16:
                return this.b.getPie3DChartArray(iIntValue);
            case 17:
                return this.b.insertNewPie3DChart(iIntValue);
            case 18:
                return this.b.getDateAxArray(iIntValue);
            case 19:
                return this.b.insertNewDateAx(iIntValue);
            case 20:
                return this.b.getLine3DChartArray(iIntValue);
            case 21:
                return this.b.insertNewLine3DChart(iIntValue);
            case 22:
                return this.b.getDoughnutChartArray(iIntValue);
            case 23:
                return this.b.getSurface3DChartArray(iIntValue);
            case 24:
                return this.b.insertNewSurface3DChart(iIntValue);
            case 25:
                return this.b.getScatterChartArray(iIntValue);
            case 26:
                return this.b.insertNewScatterChart(iIntValue);
            case 27:
                return this.b.getOfPieChartArray(iIntValue);
            case 28:
                return this.b.insertNewOfPieChart(iIntValue);
            default:
                return this.b.getBarChartArray(iIntValue);
        }
    }
}
