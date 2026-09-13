package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.SchemaDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class S implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f517a;
    public final /* synthetic */ SchemaDocumentImpl.SchemaImpl b;

    public /* synthetic */ S(SchemaDocumentImpl.SchemaImpl schemaImpl, int i5) {
        this.f517a = i5;
        this.b = schemaImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f517a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAttribute(iIntValue);
                break;
            case 1:
                this.b.removeAnnotation(iIntValue);
                break;
            case 2:
                this.b.removeSimpleType(iIntValue);
                break;
            case 3:
                this.b.removeElement(iIntValue);
                break;
            case 4:
                this.b.removeInclude(iIntValue);
                break;
            case 5:
                this.b.removeAttributeGroup(iIntValue);
                break;
            case 6:
                this.b.removeComplexType(iIntValue);
                break;
            case 7:
                this.b.removeImport(iIntValue);
                break;
            case 8:
                this.b.removeRedefine(iIntValue);
                break;
            case 9:
                this.b.removeNotation(iIntValue);
                break;
            default:
                this.b.removeGroup(iIntValue);
                break;
        }
    }
}
