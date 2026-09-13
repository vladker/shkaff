package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumberingImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class J0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8288a;
    public final /* synthetic */ CTNumberingImpl b;

    public /* synthetic */ J0(CTNumberingImpl cTNumberingImpl, int i5) {
        this.f8288a = i5;
        this.b = cTNumberingImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAbstractNumArray;
        switch (this.f8288a) {
            case 0:
                iSizeOfAbstractNumArray = this.b.sizeOfAbstractNumArray();
                break;
            case 1:
                iSizeOfAbstractNumArray = this.b.sizeOfNumPicBulletArray();
                break;
            default:
                iSizeOfAbstractNumArray = this.b.sizeOfNumArray();
                break;
        }
        return Integer.valueOf(iSizeOfAbstractNumArray);
    }
}
