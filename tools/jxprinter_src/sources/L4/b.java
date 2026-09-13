package L4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ConfigDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f457a;
    public final /* synthetic */ ConfigDocumentImpl.ConfigImpl b;

    public /* synthetic */ b(ConfigDocumentImpl.ConfigImpl configImpl, int i5) {
        this.f457a = i5;
        this.b = configImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f457a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setNamespaceArray(iIntValue, (Nsconfig) obj2);
                break;
            case 1:
                this.b.setExtensionArray(iIntValue, (Extensionconfig) obj2);
                break;
            case 2:
                this.b.setUsertypeArray(iIntValue, (Usertypeconfig) obj2);
                break;
            default:
                this.b.setQnameArray(iIntValue, (Qnameconfig) obj2);
                break;
        }
    }
}
