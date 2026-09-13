package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPlotAreaImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class n0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5660a;
    public final /* synthetic */ CTPlotAreaImpl b;

    public /* synthetic */ n0(CTPlotAreaImpl cTPlotAreaImpl, int i5) {
        this.f5660a = i5;
        this.b = cTPlotAreaImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfStockChartArray;
        switch (this.f5660a) {
            case 0:
                iSizeOfStockChartArray = this.b.sizeOfStockChartArray();
                break;
            case 1:
                iSizeOfStockChartArray = this.b.sizeOfBar3DChartArray();
                break;
            case 2:
                iSizeOfStockChartArray = this.b.sizeOfValAxArray();
                break;
            case 3:
                iSizeOfStockChartArray = this.b.sizeOfCatAxArray();
                break;
            case 4:
                iSizeOfStockChartArray = this.b.sizeOfSurfaceChartArray();
                break;
            case 5:
                iSizeOfStockChartArray = this.b.sizeOfRadarChartArray();
                break;
            case 6:
                iSizeOfStockChartArray = this.b.sizeOfLineChartArray();
                break;
            case 7:
                iSizeOfStockChartArray = this.b.sizeOfPie3DChartArray();
                break;
            case 8:
                iSizeOfStockChartArray = this.b.sizeOfBubbleChartArray();
                break;
            case 9:
                iSizeOfStockChartArray = this.b.sizeOfDateAxArray();
                break;
            case 10:
                iSizeOfStockChartArray = this.b.sizeOfLine3DChartArray();
                break;
            case 11:
                iSizeOfStockChartArray = this.b.sizeOfSurface3DChartArray();
                break;
            case 12:
                iSizeOfStockChartArray = this.b.sizeOfScatterChartArray();
                break;
            case 13:
                iSizeOfStockChartArray = this.b.sizeOfOfPieChartArray();
                break;
            case 14:
                iSizeOfStockChartArray = this.b.sizeOfBarChartArray();
                break;
            case 15:
                iSizeOfStockChartArray = this.b.sizeOfPieChartArray();
                break;
            case 16:
                iSizeOfStockChartArray = this.b.sizeOfArea3DChartArray();
                break;
            case 17:
                iSizeOfStockChartArray = this.b.sizeOfAreaChartArray();
                break;
            case 18:
                iSizeOfStockChartArray = this.b.sizeOfSerAxArray();
                break;
            default:
                iSizeOfStockChartArray = this.b.sizeOfDoughnutChartArray();
                break;
        }
        return Integer.valueOf(iSizeOfStockChartArray);
    }
}
