package K4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.substwsdl.impl.DefinitionsDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f396a;
    public final /* synthetic */ DefinitionsDocumentImpl.DefinitionsImpl b;

    public /* synthetic */ d(DefinitionsDocumentImpl.DefinitionsImpl definitionsImpl, int i5) {
        this.f396a = i5;
        this.b = definitionsImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTypesArray;
        switch (this.f396a) {
            case 0:
                iSizeOfTypesArray = this.b.sizeOfTypesArray();
                break;
            case 1:
                iSizeOfTypesArray = this.b.sizeOfPortTypeArray();
                break;
            case 2:
                iSizeOfTypesArray = this.b.sizeOfServiceArray();
                break;
            case 3:
                iSizeOfTypesArray = this.b.sizeOfBindingArray();
                break;
            case 4:
                iSizeOfTypesArray = this.b.sizeOfMessageArray();
                break;
            default:
                iSizeOfTypesArray = this.b.sizeOfImportArray();
                break;
        }
        return Integer.valueOf(iSizeOfTypesArray);
    }
}
