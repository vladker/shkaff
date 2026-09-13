package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class I implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8282a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ I(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8282a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSubDocArray;
        switch (this.f8282a) {
            case 0:
                iSizeOfSubDocArray = this.b.sizeOfSubDocArray();
                break;
            case 1:
                iSizeOfSubDocArray = this.b.sizeOfOMathParaArray();
                break;
            case 2:
                iSizeOfSubDocArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            default:
                iSizeOfSubDocArray = this.b.sizeOfMoveFromRangeEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfSubDocArray);
    }
}
