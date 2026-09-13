package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBubbleSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class D implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5601a;
    public final /* synthetic */ CTBubbleSerImpl b;

    public /* synthetic */ D(CTBubbleSerImpl cTBubbleSerImpl, int i5) {
        this.f5601a = i5;
        this.b = cTBubbleSerImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5601a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getTrendlineArray(iIntValue);
            case 1:
                return this.b.getErrBarsArray(iIntValue);
            case 2:
                return this.b.insertNewErrBars(iIntValue);
            case 3:
                return this.b.insertNewTrendline(iIntValue);
            case 4:
                return this.b.getDPtArray(iIntValue);
            default:
                return this.b.insertNewDPt(iIntValue);
        }
    }
}
