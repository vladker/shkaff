package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RedefineDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f506a;
    public final /* synthetic */ RedefineDocumentImpl.RedefineImpl b;

    public /* synthetic */ G(RedefineDocumentImpl.RedefineImpl redefineImpl, int i5) {
        this.f506a = i5;
        this.b = redefineImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAttributeGroupArray;
        switch (this.f506a) {
            case 0:
                iSizeOfAttributeGroupArray = this.b.sizeOfAttributeGroupArray();
                break;
            case 1:
                iSizeOfAttributeGroupArray = this.b.sizeOfComplexTypeArray();
                break;
            case 2:
                iSizeOfAttributeGroupArray = this.b.sizeOfGroupArray();
                break;
            case 3:
                iSizeOfAttributeGroupArray = this.b.sizeOfAnnotationArray();
                break;
            default:
                iSizeOfAttributeGroupArray = this.b.sizeOfSimpleTypeArray();
                break;
        }
        return Integer.valueOf(iSizeOfAttributeGroupArray);
    }
}
