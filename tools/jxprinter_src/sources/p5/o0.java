package p5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTRImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class o0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7824a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ o0(CTRImpl cTRImpl, int i5) {
        this.f7824a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfPgNumArray;
        switch (this.f7824a) {
            case 0:
                iSizeOfPgNumArray = this.b.sizeOfPgNumArray();
                break;
            case 1:
                iSizeOfPgNumArray = this.b.sizeOfLastRenderedPageBreakArray();
                break;
            case 2:
                iSizeOfPgNumArray = this.b.sizeOfObjectArray();
                break;
            default:
                iSizeOfPgNumArray = this.b.sizeOfDelInstrTextArray();
                break;
        }
        return Integer.valueOf(iSizeOfPgNumArray);
    }
}
