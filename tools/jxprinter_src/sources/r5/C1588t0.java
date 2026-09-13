package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangeImpl;

/* JADX INFO: renamed from: r5.t0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1588t0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8076a;
    public final /* synthetic */ CTProtectedRangeImpl b;

    public /* synthetic */ C1588t0(CTProtectedRangeImpl cTProtectedRangeImpl, int i5) {
        this.f8076a = i5;
        this.b = cTProtectedRangeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8076a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSecurityDescriptorArray(iIntValue);
            case 1:
                return this.b.xgetSecurityDescriptorArray(iIntValue);
            default:
                return this.b.insertNewSecurityDescriptor(iIntValue);
        }
    }
}
