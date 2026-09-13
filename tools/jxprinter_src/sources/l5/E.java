package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDuotoneEffectImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class E implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5909a;
    public final /* synthetic */ CTDuotoneEffectImpl b;

    public /* synthetic */ E(CTDuotoneEffectImpl cTDuotoneEffectImpl, int i5) {
        this.f5909a = i5;
        this.b = cTDuotoneEffectImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5909a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getHslClrArray(iIntValue);
            case 1:
                return this.b.getSysClrArray(iIntValue);
            case 2:
                return this.b.insertNewSysClr(iIntValue);
            case 3:
                return this.b.getScrgbClrArray(iIntValue);
            case 4:
                return this.b.insertNewScrgbClr(iIntValue);
            case 5:
                return this.b.getPrstClrArray(iIntValue);
            case 6:
                return this.b.insertNewPrstClr(iIntValue);
            case 7:
                return this.b.getSrgbClrArray(iIntValue);
            case 8:
                return this.b.insertNewSrgbClr(iIntValue);
            case 9:
                return this.b.insertNewHslClr(iIntValue);
            case 10:
                return this.b.getSchemeClrArray(iIntValue);
            default:
                return this.b.insertNewSchemeClr(iIntValue);
        }
    }
}
