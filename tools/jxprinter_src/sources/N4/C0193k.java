package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ComplexTypeImpl;

/* JADX INFO: renamed from: N4.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0193k implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f530a;
    public final /* synthetic */ ComplexTypeImpl b;

    public /* synthetic */ C0193k(ComplexTypeImpl complexTypeImpl, int i5) {
        this.f530a = i5;
        this.b = complexTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f530a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAttributeGroup(iIntValue);
                break;
            default:
                this.b.removeAttribute(iIntValue);
                break;
        }
    }
}
