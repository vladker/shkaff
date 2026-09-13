package k5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBar3DChartImpl;

/* JADX INFO: renamed from: k5.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1077p implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5663a;
    public final /* synthetic */ CTBar3DChartImpl b;

    public /* synthetic */ C1077p(CTBar3DChartImpl cTBar3DChartImpl, int i5) {
        this.f5663a = i5;
        this.b = cTBar3DChartImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5663a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAxId(iIntValue);
                break;
            default:
                this.b.removeSer(iIntValue);
                break;
        }
    }
}
