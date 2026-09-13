package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTScatterSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class z0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5684a;
    public final /* synthetic */ CTScatterSerImpl b;

    public /* synthetic */ z0(CTScatterSerImpl cTScatterSerImpl, int i5) {
        this.f5684a = i5;
        this.b = cTScatterSerImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5684a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getErrBarsArray(iIntValue);
            case 1:
                return this.b.getDPtArray(iIntValue);
            case 2:
                return this.b.insertNewDPt(iIntValue);
            case 3:
                return this.b.insertNewErrBars(iIntValue);
            case 4:
                return this.b.getTrendlineArray(iIntValue);
            default:
                return this.b.insertNewTrendline(iIntValue);
        }
    }
}
