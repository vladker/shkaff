package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.ElementImpl;

/* JADX INFO: renamed from: N4.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C0197o implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f534a;
    public final /* synthetic */ ElementImpl b;

    public /* synthetic */ C0197o(ElementImpl elementImpl, int i5) {
        this.f534a = i5;
        this.b = elementImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f534a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeKeyref(iIntValue);
                break;
            case 1:
                this.b.removeUnique(iIntValue);
                break;
            default:
                this.b.removeKey(iIntValue);
                break;
        }
    }
}
