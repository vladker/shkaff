package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTAreaSerImpl;

/* JADX INFO: renamed from: k5.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1071l implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5655a;
    public final /* synthetic */ CTAreaSerImpl b;

    public /* synthetic */ C1071l(CTAreaSerImpl cTAreaSerImpl, int i5) {
        this.f5655a = i5;
        this.b = cTAreaSerImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfErrBarsArray;
        switch (this.f5655a) {
            case 0:
                iSizeOfErrBarsArray = this.b.sizeOfErrBarsArray();
                break;
            case 1:
                iSizeOfErrBarsArray = this.b.sizeOfDPtArray();
                break;
            default:
                iSizeOfErrBarsArray = this.b.sizeOfTrendlineArray();
                break;
        }
        return Integer.valueOf(iSizeOfErrBarsArray);
    }
}
