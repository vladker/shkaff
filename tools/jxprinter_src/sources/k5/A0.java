package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTScatterSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class A0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5596a;
    public final /* synthetic */ CTScatterSerImpl b;

    public /* synthetic */ A0(CTScatterSerImpl cTScatterSerImpl, int i5) {
        this.f5596a = i5;
        this.b = cTScatterSerImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5596a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setDPtArray(iIntValue, (CTDPt) obj2);
                break;
            default:
                this.b.setErrBarsArray(iIntValue, (CTErrBars) obj2);
                break;
        }
    }
}
