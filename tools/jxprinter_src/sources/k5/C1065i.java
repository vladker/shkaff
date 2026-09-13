package k5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTAreaSerImpl;

/* JADX INFO: renamed from: k5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1065i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5649a;
    public final /* synthetic */ CTAreaSerImpl b;

    public /* synthetic */ C1065i(CTAreaSerImpl cTAreaSerImpl, int i5) {
        this.f5649a = i5;
        this.b = cTAreaSerImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5649a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getDPtArray(iIntValue);
            case 1:
                return this.b.getErrBarsArray(iIntValue);
            case 2:
                return this.b.insertNewErrBars(iIntValue);
            case 3:
                return this.b.insertNewDPt(iIntValue);
            case 4:
                return this.b.getTrendlineArray(iIntValue);
            default:
                return this.b.insertNewTrendline(iIntValue);
        }
    }
}
