package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RedefineDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class D implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f503a;
    public final /* synthetic */ RedefineDocumentImpl.RedefineImpl b;

    public /* synthetic */ D(RedefineDocumentImpl.RedefineImpl redefineImpl, int i5) {
        this.f503a = i5;
        this.b = redefineImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f503a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAnnotationArray(iIntValue);
            case 1:
                return this.b.getAttributeGroupArray(iIntValue);
            case 2:
                return this.b.insertNewAttributeGroup(iIntValue);
            case 3:
                return this.b.getComplexTypeArray(iIntValue);
            case 4:
                return this.b.insertNewComplexType(iIntValue);
            case 5:
                return this.b.getGroupArray(iIntValue);
            case 6:
                return this.b.insertNewGroup(iIntValue);
            case 7:
                return this.b.insertNewAnnotation(iIntValue);
            case 8:
                return this.b.getSimpleTypeArray(iIntValue);
            default:
                return this.b.insertNewSimpleType(iIntValue);
        }
    }
}
