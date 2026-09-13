package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ComplexTypeImpl;

/* JADX INFO: renamed from: N4.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0192j implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f529a;
    public final /* synthetic */ ComplexTypeImpl b;

    public /* synthetic */ C0192j(ComplexTypeImpl complexTypeImpl, int i5) {
        this.f529a = i5;
        this.b = complexTypeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f529a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAttributeGroupArray(iIntValue, (AttributeGroupRef) obj2);
                break;
            default:
                this.b.setAttributeArray(iIntValue, (Attribute) obj2);
                break;
        }
    }
}
