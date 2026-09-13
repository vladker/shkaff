package r5;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangeImpl;

/* JADX INFO: renamed from: r5.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1590u0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8078a;
    public final /* synthetic */ CTProtectedRangeImpl b;

    public /* synthetic */ C1590u0(CTProtectedRangeImpl cTProtectedRangeImpl, int i5) {
        this.f8078a = i5;
        this.b = cTProtectedRangeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8078a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSecurityDescriptorArray(iIntValue, (String) obj2);
                break;
            case 1:
                this.b.insertSecurityDescriptor(iIntValue, (String) obj2);
                break;
            default:
                this.b.xsetSecurityDescriptorArray(iIntValue, (XmlString) obj2);
                break;
        }
    }
}
