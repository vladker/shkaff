package k5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTScatterChartImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class x0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5680a;
    public final /* synthetic */ CTScatterChartImpl b;

    public /* synthetic */ x0(CTScatterChartImpl cTScatterChartImpl, int i5) {
        this.f5680a = i5;
        this.b = cTScatterChartImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5680a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSer(iIntValue);
                break;
            default:
                this.b.removeAxId(iIntValue);
                break;
        }
    }
}
