package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.SchemaDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class P implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f515a;
    public final /* synthetic */ SchemaDocumentImpl.SchemaImpl b;

    public /* synthetic */ P(SchemaDocumentImpl.SchemaImpl schemaImpl, int i5) {
        this.f515a = i5;
        this.b = schemaImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f515a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getComplexTypeArray(iIntValue);
            case 1:
                return this.b.getAttributeArray(iIntValue);
            case 2:
                return this.b.insertNewAttribute(iIntValue);
            case 3:
                return this.b.getAnnotationArray(iIntValue);
            case 4:
                return this.b.insertNewAnnotation(iIntValue);
            case 5:
                return this.b.getSimpleTypeArray(iIntValue);
            case 6:
                return this.b.insertNewSimpleType(iIntValue);
            case 7:
                return this.b.getElementArray(iIntValue);
            case 8:
                return this.b.insertNewElement(iIntValue);
            case 9:
                return this.b.insertNewComplexType(iIntValue);
            case 10:
                return this.b.getIncludeArray(iIntValue);
            case 11:
                return this.b.insertNewInclude(iIntValue);
            case 12:
                return this.b.getAttributeGroupArray(iIntValue);
            case 13:
                return this.b.insertNewAttributeGroup(iIntValue);
            case 14:
                return this.b.getImportArray(iIntValue);
            case 15:
                return this.b.insertNewImport(iIntValue);
            case 16:
                return this.b.getRedefineArray(iIntValue);
            case 17:
                return this.b.insertNewRedefine(iIntValue);
            case 18:
                return this.b.getNotationArray(iIntValue);
            case 19:
                return this.b.insertNewNotation(iIntValue);
            case 20:
                return this.b.getGroupArray(iIntValue);
            default:
                return this.b.insertNewGroup(iIntValue);
        }
    }
}
