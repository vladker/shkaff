package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBubbleSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5607a;
    public final /* synthetic */ CTBubbleSerImpl b;

    public /* synthetic */ G(CTBubbleSerImpl cTBubbleSerImpl, int i5) {
        this.f5607a = i5;
        this.b = cTBubbleSerImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfErrBarsArray;
        switch (this.f5607a) {
            case 0:
                iSizeOfErrBarsArray = this.b.sizeOfErrBarsArray();
                break;
            case 1:
                iSizeOfErrBarsArray = this.b.sizeOfTrendlineArray();
                break;
            default:
                iSizeOfErrBarsArray = this.b.sizeOfDPtArray();
                break;
        }
        return Integer.valueOf(iSizeOfErrBarsArray);
    }
}
