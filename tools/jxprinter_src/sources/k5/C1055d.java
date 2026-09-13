package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTArea3DChartImpl;

/* JADX INFO: renamed from: k5.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1055d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5639a;
    public final /* synthetic */ CTArea3DChartImpl b;

    public /* synthetic */ C1055d(CTArea3DChartImpl cTArea3DChartImpl, int i5) {
        this.f5639a = i5;
        this.b = cTArea3DChartImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAxIdArray;
        switch (this.f5639a) {
            case 0:
                iSizeOfAxIdArray = this.b.sizeOfAxIdArray();
                break;
            default:
                iSizeOfAxIdArray = this.b.sizeOfSerArray();
                break;
        }
        return Integer.valueOf(iSizeOfAxIdArray);
    }
}
