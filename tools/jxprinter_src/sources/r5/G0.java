package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRstImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class G0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7990a;
    public final /* synthetic */ CTRstImpl b;

    public /* synthetic */ G0(CTRstImpl cTRstImpl, int i5) {
        this.f7990a = i5;
        this.b = cTRstImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfRPhArray;
        switch (this.f7990a) {
            case 0:
                iSizeOfRPhArray = this.b.sizeOfRPhArray();
                break;
            default:
                iSizeOfRPhArray = this.b.sizeOfRArray();
                break;
        }
        return Integer.valueOf(iSizeOfRPhArray);
    }
}
