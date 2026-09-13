package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColorScaleImpl;

/* JADX INFO: renamed from: r5.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1589u implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8077a;
    public final /* synthetic */ CTColorScaleImpl b;

    public /* synthetic */ C1589u(CTColorScaleImpl cTColorScaleImpl, int i5) {
        this.f8077a = i5;
        this.b = cTColorScaleImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8077a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCfvo(iIntValue);
                break;
            default:
                this.b.removeColor(iIntValue);
                break;
        }
    }
}
