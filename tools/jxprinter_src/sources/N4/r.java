package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ExtensionTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class r implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f537a;
    public final /* synthetic */ ExtensionTypeImpl b;

    public /* synthetic */ r(ExtensionTypeImpl extensionTypeImpl, int i5) {
        this.f537a = i5;
        this.b = extensionTypeImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f537a;
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
