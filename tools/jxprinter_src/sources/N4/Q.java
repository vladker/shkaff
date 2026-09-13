package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.SchemaDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Q implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f516a;
    public final /* synthetic */ SchemaDocumentImpl.SchemaImpl b;

    public /* synthetic */ Q(SchemaDocumentImpl.SchemaImpl schemaImpl, int i5) {
        this.f516a = i5;
        this.b = schemaImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f516a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAttributeArray(iIntValue, (TopLevelAttribute) obj2);
                break;
            case 1:
                this.b.setAnnotationArray(iIntValue, (AnnotationDocument.Annotation) obj2);
                break;
            case 2:
                this.b.setComplexTypeArray(iIntValue, (TopLevelComplexType) obj2);
                break;
            case 3:
                this.b.setSimpleTypeArray(iIntValue, (TopLevelSimpleType) obj2);
                break;
            case 4:
                this.b.setElementArray(iIntValue, (TopLevelElement) obj2);
                break;
            case 5:
                this.b.setIncludeArray(iIntValue, (IncludeDocument.Include) obj2);
                break;
            case 6:
                this.b.setAttributeGroupArray(iIntValue, (NamedAttributeGroup) obj2);
                break;
            case 7:
                this.b.setImportArray(iIntValue, (ImportDocument.Import) obj2);
                break;
            case 8:
                this.b.setRedefineArray(iIntValue, (RedefineDocument.Redefine) obj2);
                break;
            case 9:
                this.b.setNotationArray(iIntValue, (NotationDocument.Notation) obj2);
                break;
            default:
                this.b.setGroupArray(iIntValue, (NamedGroup) obj2);
                break;
        }
    }
}
