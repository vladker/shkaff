package k5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBarChartImpl;

/* JADX INFO: renamed from: k5.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1080t implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5671a;
    public final /* synthetic */ CTBarChartImpl b;

    public /* synthetic */ C1080t(CTBarChartImpl cTBarChartImpl, int i5) {
        this.f5671a = i5;
        this.b = cTBarChartImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5671a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSer(iIntValue);
                break;
            case 1:
                this.b.removeAxId(iIntValue);
                break;
            default:
                this.b.removeSerLines(iIntValue);
                break;
        }
    }
}
