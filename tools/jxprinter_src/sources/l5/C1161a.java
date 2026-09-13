package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTAdjustHandleListImpl;

/* JADX INFO: renamed from: l5.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1161a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5974a;
    public final /* synthetic */ CTAdjustHandleListImpl b;

    public /* synthetic */ C1161a(CTAdjustHandleListImpl cTAdjustHandleListImpl, int i5) {
        this.f5974a = i5;
        this.b = cTAdjustHandleListImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5974a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAhPolarArray(iIntValue);
            case 1:
                return this.b.insertNewAhPolar(iIntValue);
            case 2:
                return this.b.getAhXYArray(iIntValue);
            default:
                return this.b.insertNewAhXY(iIntValue);
        }
    }
}
