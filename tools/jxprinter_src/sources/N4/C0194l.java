package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ComplexTypeImpl;

/* JADX INFO: renamed from: N4.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0194l implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f531a;
    public final /* synthetic */ ComplexTypeImpl b;

    public /* synthetic */ C0194l(ComplexTypeImpl complexTypeImpl, int i5) {
        this.f531a = i5;
        this.b = complexTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAttributeGroupArray;
        switch (this.f531a) {
            case 0:
                iSizeOfAttributeGroupArray = this.b.sizeOfAttributeGroupArray();
                break;
            default:
                iSizeOfAttributeGroupArray = this.b.sizeOfAttributeArray();
                break;
        }
        return Integer.valueOf(iSizeOfAttributeGroupArray);
    }
}
