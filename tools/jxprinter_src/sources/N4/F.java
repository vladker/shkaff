package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RedefineDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class F implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f505a;
    public final /* synthetic */ RedefineDocumentImpl.RedefineImpl b;

    public /* synthetic */ F(RedefineDocumentImpl.RedefineImpl redefineImpl, int i5) {
        this.f505a = i5;
        this.b = redefineImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f505a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeAttributeGroup(iIntValue);
                break;
            case 1:
                this.b.removeComplexType(iIntValue);
                break;
            case 2:
                this.b.removeGroup(iIntValue);
                break;
            case 3:
                this.b.removeAnnotation(iIntValue);
                break;
            default:
                this.b.removeSimpleType(iIntValue);
                break;
        }
    }
}
