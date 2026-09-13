package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.AttributeGroupImpl;

/* JADX INFO: renamed from: N4.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0187e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f524a;
    public final /* synthetic */ AttributeGroupImpl b;

    public /* synthetic */ C0187e(AttributeGroupImpl attributeGroupImpl, int i5) {
        this.f524a = i5;
        this.b = attributeGroupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f524a;
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
