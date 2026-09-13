package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ElementImpl;

/* JADX INFO: renamed from: N4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0198p implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f535a;
    public final /* synthetic */ ElementImpl b;

    public /* synthetic */ C0198p(ElementImpl elementImpl, int i5) {
        this.f535a = i5;
        this.b = elementImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfKeyrefArray;
        switch (this.f535a) {
            case 0:
                iSizeOfKeyrefArray = this.b.sizeOfKeyrefArray();
                break;
            case 1:
                iSizeOfKeyrefArray = this.b.sizeOfUniqueArray();
                break;
            default:
                iSizeOfKeyrefArray = this.b.sizeOfKeyArray();
                break;
        }
        return Integer.valueOf(iSizeOfKeyrefArray);
    }
}
