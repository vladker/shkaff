package l5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTAdjustHandleListImpl;

/* JADX INFO: renamed from: l5.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1170d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5986a;
    public final /* synthetic */ CTAdjustHandleListImpl b;

    public /* synthetic */ C1170d(CTAdjustHandleListImpl cTAdjustHandleListImpl, int i5) {
        this.f5986a = i5;
        this.b = cTAdjustHandleListImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAhPolarArray;
        switch (this.f5986a) {
            case 0:
                iSizeOfAhPolarArray = this.b.sizeOfAhPolarArray();
                break;
            default:
                iSizeOfAhPolarArray = this.b.sizeOfAhXYArray();
                break;
        }
        return Integer.valueOf(iSizeOfAhPolarArray);
    }
}
