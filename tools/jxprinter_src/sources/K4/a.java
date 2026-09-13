package K4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.substwsdl.impl.DefinitionsDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f393a;
    public final /* synthetic */ DefinitionsDocumentImpl.DefinitionsImpl b;

    public /* synthetic */ a(DefinitionsDocumentImpl.DefinitionsImpl definitionsImpl, int i5) {
        this.f393a = i5;
        this.b = definitionsImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f393a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMessageArray(iIntValue);
            case 1:
                return this.b.getTypesArray(iIntValue);
            case 2:
                return this.b.insertNewTypes(iIntValue);
            case 3:
                return this.b.getPortTypeArray(iIntValue);
            case 4:
                return this.b.insertNewPortType(iIntValue);
            case 5:
                return this.b.getServiceArray(iIntValue);
            case 6:
                return this.b.insertNewService(iIntValue);
            case 7:
                return this.b.getBindingArray(iIntValue);
            case 8:
                return this.b.insertNewBinding(iIntValue);
            case 9:
                return this.b.insertNewMessage(iIntValue);
            case 10:
                return this.b.getImportArray(iIntValue);
            default:
                return this.b.insertNewImport(iIntValue);
        }
    }
}
