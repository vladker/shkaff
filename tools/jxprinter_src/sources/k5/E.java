package k5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBubbleSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class E implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5603a;
    public final /* synthetic */ CTBubbleSerImpl b;

    public /* synthetic */ E(CTBubbleSerImpl cTBubbleSerImpl, int i5) {
        this.f5603a = i5;
        this.b = cTBubbleSerImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5603a;
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
