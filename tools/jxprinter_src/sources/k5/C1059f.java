package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAreaSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTAreaChartImpl;

/* JADX INFO: renamed from: k5.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1059f implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5643a;
    public final /* synthetic */ CTAreaChartImpl b;

    public /* synthetic */ C1059f(CTAreaChartImpl cTAreaChartImpl, int i5) {
        this.f5643a = i5;
        this.b = cTAreaChartImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5643a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSerArray(iIntValue, (CTAreaSer) obj2);
                break;
            default:
                this.b.setAxIdArray(iIntValue, (CTUnsignedInt) obj2);
                break;
        }
    }
}
