package K4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.substwsdl.impl.DefinitionsDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f395a;
    public final /* synthetic */ DefinitionsDocumentImpl.DefinitionsImpl b;

    public /* synthetic */ c(DefinitionsDocumentImpl.DefinitionsImpl definitionsImpl, int i5) {
        this.f395a = i5;
        this.b = definitionsImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f395a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeTypes(iIntValue);
                break;
            case 1:
                this.b.removePortType(iIntValue);
                break;
            case 2:
                this.b.removeService(iIntValue);
                break;
            case 3:
                this.b.removeBinding(iIntValue);
                break;
            case 4:
                this.b.removeMessage(iIntValue);
                break;
            default:
                this.b.removeImport(iIntValue);
                break;
        }
    }
}
