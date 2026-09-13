package L4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ConfigDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f458a;
    public final /* synthetic */ ConfigDocumentImpl.ConfigImpl b;

    public /* synthetic */ c(ConfigDocumentImpl.ConfigImpl configImpl, int i5) {
        this.f458a = i5;
        this.b = configImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f458a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeNamespace(iIntValue);
                break;
            case 1:
                this.b.removeExtension(iIntValue);
                break;
            case 2:
                this.b.removeUsertype(iIntValue);
                break;
            default:
                this.b.removeQname(iIntValue);
                break;
        }
    }
}
