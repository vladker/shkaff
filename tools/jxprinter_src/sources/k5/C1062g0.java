package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTOfPieChartImpl;

/* JADX INFO: renamed from: k5.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1062g0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5646a;
    public final /* synthetic */ CTOfPieChartImpl b;

    public /* synthetic */ C1062g0(CTOfPieChartImpl cTOfPieChartImpl, int i5) {
        this.f5646a = i5;
        this.b = cTOfPieChartImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSerArray;
        switch (this.f5646a) {
            case 0:
                iSizeOfSerArray = this.b.sizeOfSerArray();
                break;
            default:
                iSizeOfSerArray = this.b.sizeOfSerLinesArray();
                break;
        }
        return Integer.valueOf(iSizeOfSerArray);
    }
}
