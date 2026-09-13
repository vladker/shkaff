package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ExtensionTypeImpl;

/* JADX INFO: renamed from: N4.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0201t implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f539a;
    public final /* synthetic */ ExtensionTypeImpl b;

    public /* synthetic */ C0201t(ExtensionTypeImpl extensionTypeImpl, int i5) {
        this.f539a = i5;
        this.b = extensionTypeImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfAttributeGroupArray;
        switch (this.f539a) {
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
