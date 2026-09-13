package k5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTScatterSerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class B0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5598a;
    public final /* synthetic */ CTScatterSerImpl b;

    public /* synthetic */ B0(CTScatterSerImpl cTScatterSerImpl, int i5) {
        this.f5598a = i5;
        this.b = cTScatterSerImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5598a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeDPt(iIntValue);
                break;
            case 1:
                this.b.removeErrBars(iIntValue);
                break;
            default:
                this.b.removeTrendline(iIntValue);
                break;
        }
    }
}
