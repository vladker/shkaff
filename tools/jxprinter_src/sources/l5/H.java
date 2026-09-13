package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDuotoneEffectImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class H implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5918a;
    public final /* synthetic */ CTDuotoneEffectImpl b;

    public /* synthetic */ H(CTDuotoneEffectImpl cTDuotoneEffectImpl, int i5) {
        this.f5918a = i5;
        this.b = cTDuotoneEffectImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSysClrArray;
        switch (this.f5918a) {
            case 0:
                iSizeOfSysClrArray = this.b.sizeOfSysClrArray();
                break;
            case 1:
                iSizeOfSysClrArray = this.b.sizeOfScrgbClrArray();
                break;
            case 2:
                iSizeOfSysClrArray = this.b.sizeOfPrstClrArray();
                break;
            case 3:
                iSizeOfSysClrArray = this.b.sizeOfSrgbClrArray();
                break;
            case 4:
                iSizeOfSysClrArray = this.b.sizeOfHslClrArray();
                break;
            default:
                iSizeOfSysClrArray = this.b.sizeOfSchemeClrArray();
                break;
        }
        return Integer.valueOf(iSizeOfSysClrArray);
    }
}
