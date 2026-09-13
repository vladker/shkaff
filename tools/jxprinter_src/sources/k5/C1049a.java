package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTArea3DChartImpl;

/* JADX INFO: renamed from: k5.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1049a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5633a;
    public final /* synthetic */ CTArea3DChartImpl b;

    public /* synthetic */ C1049a(CTArea3DChartImpl cTArea3DChartImpl, int i5) {
        this.f5633a = i5;
        this.b = cTArea3DChartImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5633a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAxIdArray(iIntValue);
            case 1:
                return this.b.insertNewAxId(iIntValue);
            case 2:
                return this.b.getSerArray(iIntValue);
            default:
                return this.b.insertNewSer(iIntValue);
        }
    }
}
