package l5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDuotoneEffectImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class F implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5912a;
    public final /* synthetic */ CTDuotoneEffectImpl b;

    public /* synthetic */ F(CTDuotoneEffectImpl cTDuotoneEffectImpl, int i5) {
        this.f5912a = i5;
        this.b = cTDuotoneEffectImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f5912a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSysClrArray(iIntValue, (CTSystemColor) obj2);
                break;
            case 1:
                this.b.setScrgbClrArray(iIntValue, (CTScRgbColor) obj2);
                break;
            case 2:
                this.b.setHslClrArray(iIntValue, (CTHslColor) obj2);
                break;
            case 3:
                this.b.setPrstClrArray(iIntValue, (CTPresetColor) obj2);
                break;
            case 4:
                this.b.setSrgbClrArray(iIntValue, (CTSRgbColor) obj2);
                break;
            default:
                this.b.setSchemeClrArray(iIntValue, (CTSchemeColor) obj2);
                break;
        }
    }
}
