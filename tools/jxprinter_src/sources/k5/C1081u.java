package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBarChartImpl;

/* JADX INFO: renamed from: k5.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1081u implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5673a;
    public final /* synthetic */ CTBarChartImpl b;

    public /* synthetic */ C1081u(CTBarChartImpl cTBarChartImpl, int i5) {
        this.f5673a = i5;
        this.b = cTBarChartImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSerArray;
        switch (this.f5673a) {
            case 0:
                iSizeOfSerArray = this.b.sizeOfSerArray();
                break;
            case 1:
                iSizeOfSerArray = this.b.sizeOfAxIdArray();
                break;
            default:
                iSizeOfSerArray = this.b.sizeOfSerLinesArray();
                break;
        }
        return Integer.valueOf(iSizeOfSerArray);
    }
}
