package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTAdjustHandleListImpl;

/* JADX INFO: renamed from: l5.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1167c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5982a;
    public final /* synthetic */ CTAdjustHandleListImpl b;

    public /* synthetic */ C1167c(CTAdjustHandleListImpl cTAdjustHandleListImpl, int i5) {
        this.f5982a = i5;
        this.b = cTAdjustHandleListImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5982a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAhPolar(iIntValue);
                break;
            default:
                this.b.removeAhXY(iIntValue);
                break;
        }
    }
}
