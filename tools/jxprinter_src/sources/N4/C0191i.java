package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ComplexTypeImpl;

/* JADX INFO: renamed from: N4.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0191i implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f528a;
    public final /* synthetic */ ComplexTypeImpl b;

    public /* synthetic */ C0191i(ComplexTypeImpl complexTypeImpl, int i5) {
        this.f528a = i5;
        this.b = complexTypeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f528a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAttributeGroupArray(iIntValue);
            case 1:
                return this.b.insertNewAttributeGroup(iIntValue);
            case 2:
                return this.b.getAttributeArray(iIntValue);
            default:
                return this.b.insertNewAttribute(iIntValue);
        }
    }
}
