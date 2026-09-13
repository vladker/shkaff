package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAlphaModulateFixedEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDuotoneEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOuterShadowEffect;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectContainerImpl;

/* JADX INFO: renamed from: l5.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1183h0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6003a;
    public final /* synthetic */ CTEffectContainerImpl b;

    public /* synthetic */ C1183h0(CTEffectContainerImpl cTEffectContainerImpl, int i5) {
        this.f6003a = i5;
        this.b = cTEffectContainerImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f6003a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setContArray(iIntValue, (CTEffectContainer) obj2);
                break;
            case 1:
                this.b.setDuotoneArray(iIntValue, (CTDuotoneEffect) obj2);
                break;
            case 2:
                this.b.setAlphaModFixArray(iIntValue, (CTAlphaModulateFixedEffect) obj2);
                break;
            default:
                this.b.setOuterShdwArray(iIntValue, (CTOuterShadowEffect) obj2);
                break;
        }
    }
}
