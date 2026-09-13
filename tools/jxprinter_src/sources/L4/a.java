package L4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ConfigDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f456a;
    public final /* synthetic */ ConfigDocumentImpl.ConfigImpl b;

    public /* synthetic */ a(ConfigDocumentImpl.ConfigImpl configImpl, int i5) {
        this.f456a = i5;
        this.b = configImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f456a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getUsertypeArray(iIntValue);
            case 1:
                return this.b.getNamespaceArray(iIntValue);
            case 2:
                return this.b.insertNewNamespace(iIntValue);
            case 3:
                return this.b.getExtensionArray(iIntValue);
            case 4:
                return this.b.insertNewExtension(iIntValue);
            case 5:
                return this.b.insertNewUsertype(iIntValue);
            case 6:
                return this.b.getQnameArray(iIntValue);
            default:
                return this.b.insertNewQname(iIntValue);
        }
    }
}
