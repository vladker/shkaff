package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBarChartImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class r implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5667a;
    public final /* synthetic */ CTBarChartImpl b;

    public /* synthetic */ r(CTBarChartImpl cTBarChartImpl, int i5) {
        this.f5667a = i5;
        this.b = cTBarChartImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5667a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAxIdArray(iIntValue);
            case 1:
                return this.b.getSerArray(iIntValue);
            case 2:
                return this.b.insertNewSer(iIntValue);
            case 3:
                return this.b.insertNewAxId(iIntValue);
            case 4:
                return this.b.getSerLinesArray(iIntValue);
            default:
                return this.b.insertNewSerLines(iIntValue);
        }
    }
}
