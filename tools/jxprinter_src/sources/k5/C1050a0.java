package k5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTLineSerImpl;

/* JADX INFO: renamed from: k5.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1050a0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5634a;
    public final /* synthetic */ CTLineSerImpl b;

    public /* synthetic */ C1050a0(CTLineSerImpl cTLineSerImpl, int i5) {
        this.f5634a = i5;
        this.b = cTLineSerImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDPtArray;
        switch (this.f5634a) {
            case 0:
                iSizeOfDPtArray = this.b.sizeOfDPtArray();
                break;
            default:
                iSizeOfDPtArray = this.b.sizeOfTrendlineArray();
                break;
        }
        return Integer.valueOf(iSizeOfDPtArray);
    }
}
