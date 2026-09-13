package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ExtensionTypeImpl;

/* JADX INFO: renamed from: N4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0200s implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f538a;
    public final /* synthetic */ ExtensionTypeImpl b;

    public /* synthetic */ C0200s(ExtensionTypeImpl extensionTypeImpl, int i5) {
        this.f538a = i5;
        this.b = extensionTypeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f538a;
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
