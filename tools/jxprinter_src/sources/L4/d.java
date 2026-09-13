package L4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ConfigDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f459a;
    public final /* synthetic */ ConfigDocumentImpl.ConfigImpl b;

    public /* synthetic */ d(ConfigDocumentImpl.ConfigImpl configImpl, int i5) {
        this.f459a = i5;
        this.b = configImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfNamespaceArray;
        switch (this.f459a) {
            case 0:
                iSizeOfNamespaceArray = this.b.sizeOfNamespaceArray();
                break;
            case 1:
                iSizeOfNamespaceArray = this.b.sizeOfExtensionArray();
                break;
            case 2:
                iSizeOfNamespaceArray = this.b.sizeOfUsertypeArray();
                break;
            default:
                iSizeOfNamespaceArray = this.b.sizeOfQnameArray();
                break;
        }
        return Integer.valueOf(iSizeOfNamespaceArray);
    }
}
