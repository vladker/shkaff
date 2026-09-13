package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.SchemaDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class T implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f518a;
    public final /* synthetic */ SchemaDocumentImpl.SchemaImpl b;

    public /* synthetic */ T(SchemaDocumentImpl.SchemaImpl schemaImpl, int i5) {
        this.f518a = i5;
        this.b = schemaImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAttributeArray;
        switch (this.f518a) {
            case 0:
                iSizeOfAttributeArray = this.b.sizeOfAttributeArray();
                break;
            case 1:
                iSizeOfAttributeArray = this.b.sizeOfAnnotationArray();
                break;
            case 2:
                iSizeOfAttributeArray = this.b.sizeOfSimpleTypeArray();
                break;
            case 3:
                iSizeOfAttributeArray = this.b.sizeOfElementArray();
                break;
            case 4:
                iSizeOfAttributeArray = this.b.sizeOfIncludeArray();
                break;
            case 5:
                iSizeOfAttributeArray = this.b.sizeOfAttributeGroupArray();
                break;
            case 6:
                iSizeOfAttributeArray = this.b.sizeOfImportArray();
                break;
            case 7:
                iSizeOfAttributeArray = this.b.sizeOfRedefineArray();
                break;
            case 8:
                iSizeOfAttributeArray = this.b.sizeOfComplexTypeArray();
                break;
            case 9:
                iSizeOfAttributeArray = this.b.sizeOfNotationArray();
                break;
            default:
                iSizeOfAttributeArray = this.b.sizeOfGroupArray();
                break;
        }
        return Integer.valueOf(iSizeOfAttributeArray);
    }
}
