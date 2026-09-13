package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTArea3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBar3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBubbleChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDateAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDoughnutChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLine3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLineChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTOfPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPie3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRadarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScatterChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurface3DChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSurfaceChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPlotAreaImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class o0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5662a;
    public final /* synthetic */ CTPlotAreaImpl b;

    public /* synthetic */ o0(CTPlotAreaImpl cTPlotAreaImpl, int i5) {
        this.f5662a = i5;
        this.b = cTPlotAreaImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5662a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setBar3DChartArray(iIntValue, (CTBar3DChart) obj2);
                break;
            case 1:
                this.b.setBubbleChartArray(iIntValue, (CTBubbleChart) obj2);
                break;
            case 2:
                this.b.setValAxArray(iIntValue, (CTValAx) obj2);
                break;
            case 3:
                this.b.setCatAxArray(iIntValue, (CTCatAx) obj2);
                break;
            case 4:
                this.b.setSurfaceChartArray(iIntValue, (CTSurfaceChart) obj2);
                break;
            case 5:
                this.b.setRadarChartArray(iIntValue, (CTRadarChart) obj2);
                break;
            case 6:
                this.b.setLineChartArray(iIntValue, (CTLineChart) obj2);
                break;
            case 7:
                this.b.setPie3DChartArray(iIntValue, (CTPie3DChart) obj2);
                break;
            case 8:
                this.b.setDateAxArray(iIntValue, (CTDateAx) obj2);
                break;
            case 9:
                this.b.setLine3DChartArray(iIntValue, (CTLine3DChart) obj2);
                break;
            case 10:
                this.b.setSurface3DChartArray(iIntValue, (CTSurface3DChart) obj2);
                break;
            case 11:
                this.b.setScatterChartArray(iIntValue, (CTScatterChart) obj2);
                break;
            case 12:
                this.b.setDoughnutChartArray(iIntValue, (CTDoughnutChart) obj2);
                break;
            case 13:
                this.b.setOfPieChartArray(iIntValue, (CTOfPieChart) obj2);
                break;
            case 14:
                this.b.setBarChartArray(iIntValue, (CTBarChart) obj2);
                break;
            case 15:
                this.b.setPieChartArray(iIntValue, (CTPieChart) obj2);
                break;
            case 16:
                this.b.setArea3DChartArray(iIntValue, (CTArea3DChart) obj2);
                break;
            case 17:
                this.b.setAreaChartArray(iIntValue, (CTAreaChart) obj2);
                break;
            default:
                this.b.setSerAxArray(iIntValue, (CTSerAx) obj2);
                break;
        }
    }
}
