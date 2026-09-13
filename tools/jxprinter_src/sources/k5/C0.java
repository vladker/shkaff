package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTScatterSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5600a;
    public final /* synthetic */ CTScatterSerImpl b;

    public /* synthetic */ C0(CTScatterSerImpl cTScatterSerImpl, int i5) {
        this.f5600a = i5;
        this.b = cTScatterSerImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDPtArray;
        switch (this.f5600a) {
            case 0:
                iSizeOfDPtArray = this.b.sizeOfDPtArray();
                break;
            case 1:
                iSizeOfDPtArray = this.b.sizeOfErrBarsArray();
                break;
            default:
                iSizeOfDPtArray = this.b.sizeOfTrendlineArray();
                break;
        }
        return Integer.valueOf(iSizeOfDPtArray);
    }
}
