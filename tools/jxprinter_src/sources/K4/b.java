package K4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;
import org.apache.xmlbeans.impl.xb.substwsdl.impl.DefinitionsDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f394a;
    public final /* synthetic */ DefinitionsDocumentImpl.DefinitionsImpl b;

    public /* synthetic */ b(DefinitionsDocumentImpl.DefinitionsImpl definitionsImpl, int i5) {
        this.f394a = i5;
        this.b = definitionsImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f394a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setTypesArray(iIntValue, (XmlObject) obj2);
                break;
            case 1:
                this.b.setPortTypeArray(iIntValue, (XmlObject) obj2);
                break;
            case 2:
                this.b.setMessageArray(iIntValue, (XmlObject) obj2);
                break;
            case 3:
                this.b.setServiceArray(iIntValue, (XmlObject) obj2);
                break;
            case 4:
                this.b.setBindingArray(iIntValue, (XmlObject) obj2);
                break;
            default:
                this.b.setImportArray(iIntValue, (TImport) obj2);
                break;
        }
    }
}
