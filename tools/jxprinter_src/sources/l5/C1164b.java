package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTAdjustHandleListImpl;

/* JADX INFO: renamed from: l5.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1164b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5978a;
    public final /* synthetic */ CTAdjustHandleListImpl b;

    public /* synthetic */ C1164b(CTAdjustHandleListImpl cTAdjustHandleListImpl, int i5) {
        this.f5978a = i5;
        this.b = cTAdjustHandleListImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5978a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAhPolarArray(iIntValue, (CTPolarAdjustHandle) obj2);
                break;
            default:
                this.b.setAhXYArray(iIntValue, (CTXYAdjustHandle) obj2);
                break;
        }
    }
}
