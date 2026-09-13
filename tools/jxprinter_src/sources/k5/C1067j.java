package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTAreaSerImpl;

/* JADX INFO: renamed from: k5.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1067j implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5651a;
    public final /* synthetic */ CTAreaSerImpl b;

    public /* synthetic */ C1067j(CTAreaSerImpl cTAreaSerImpl, int i5) {
        this.f5651a = i5;
        this.b = cTAreaSerImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5651a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setErrBarsArray(iIntValue, (CTErrBars) obj2);
                break;
            default:
                this.b.setDPtArray(iIntValue, (CTDPt) obj2);
                break;
        }
    }
}
