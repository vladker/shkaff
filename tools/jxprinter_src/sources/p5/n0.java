package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class n0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7822a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ n0(CTRImpl cTRImpl, int i5) {
        this.f7822a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7822a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removePgNum(iIntValue);
                break;
            case 1:
                this.b.removeDelInstrText(iIntValue);
                break;
            case 2:
                this.b.removeLastRenderedPageBreak(iIntValue);
                break;
            default:
                this.b.removeObject(iIntValue);
                break;
        }
    }
}
