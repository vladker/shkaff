package org.apache.poi.hssf.record.chart;

import java.util.function.Supplier;
import org.apache.poi.hssf.record.StandardRecord;

/* JADX INFO: renamed from: org.apache.poi.hssf.record.chart.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C1387c implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7053a;
    public final /* synthetic */ StandardRecord b;

    public /* synthetic */ C1387c(StandardRecord standardRecord, int i5) {
        this.f7053a = i5;
        this.b = standardRecord;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7053a) {
            case 0:
                return Short.valueOf(((AxisLineFormatRecord) this.b).getAxisType());
            case 1:
                return Short.valueOf(((AxisUsedRecord) this.b).getNumAxis());
            case 2:
                return ((ChartTitleFormatRecord) this.b).lambda$getGenericProperties$1();
            case 3:
                return Short.valueOf(((DefaultDataLabelTextPropertiesRecord) this.b).getCategoryDataType());
            case 4:
                return Short.valueOf(((FontIndexRecord) this.b).getFontIndex());
            case 5:
                return Short.valueOf(((NumberFormatIndexRecord) this.b).getFormatIndex());
            case 6:
                return Short.valueOf(((SeriesChartGroupIndexRecord) this.b).getChartGroupIndex());
            case 7:
                return Short.valueOf(((SeriesIndexRecord) this.b).getIndex());
            case 8:
                return Short.valueOf(((SeriesLabelsRecord) this.b).getFormatFlags());
            case 9:
                return ((SeriesListRecord) this.b).getSeriesNumbers();
            default:
                return Short.valueOf(((UnitsRecord) this.b).getUnits());
        }
    }
}
