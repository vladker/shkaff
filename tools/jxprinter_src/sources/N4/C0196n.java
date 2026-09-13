package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ElementImpl;

/* JADX INFO: renamed from: N4.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0196n implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f533a;
    public final /* synthetic */ ElementImpl b;

    public /* synthetic */ C0196n(ElementImpl elementImpl, int i5) {
        this.f533a = i5;
        this.b = elementImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f533a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setKeyrefArray(iIntValue, (KeyrefDocument.Keyref) obj2);
                break;
            case 1:
                this.b.setUniqueArray(iIntValue, (Keybase) obj2);
                break;
            default:
                this.b.setKeyArray(iIntValue, (Keybase) obj2);
                break;
        }
    }
}
