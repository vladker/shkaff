package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColorScaleImpl;

/* JADX INFO: renamed from: r5.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1587t implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8075a;
    public final /* synthetic */ CTColorScaleImpl b;

    public /* synthetic */ C1587t(CTColorScaleImpl cTColorScaleImpl, int i5) {
        this.f8075a = i5;
        this.b = cTColorScaleImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8075a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCfvoArray(iIntValue, (CTCfvo) obj2);
                break;
            default:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
        }
    }
}
