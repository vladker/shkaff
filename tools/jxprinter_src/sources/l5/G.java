package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDuotoneEffectImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5915a;
    public final /* synthetic */ CTDuotoneEffectImpl b;

    public /* synthetic */ G(CTDuotoneEffectImpl cTDuotoneEffectImpl, int i5) {
        this.f5915a = i5;
        this.b = cTDuotoneEffectImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5915a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSysClr(iIntValue);
                break;
            case 1:
                this.b.removeScrgbClr(iIntValue);
                break;
            case 2:
                this.b.removePrstClr(iIntValue);
                break;
            case 3:
                this.b.removeSrgbClr(iIntValue);
                break;
            case 4:
                this.b.removeHslClr(iIntValue);
                break;
            default:
                this.b.removeSchemeClr(iIntValue);
                break;
        }
    }
}
