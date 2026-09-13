package N4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RealGroupImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class A implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f500a;
    public final /* synthetic */ RealGroupImpl b;

    public /* synthetic */ A(RealGroupImpl realGroupImpl, int i5) {
        this.f500a = i5;
        this.b = realGroupImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f500a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSequenceArray(iIntValue, (ExplicitGroup) obj2);
                break;
            case 1:
                this.b.setAllArray(iIntValue, (All) obj2);
                break;
            default:
                this.b.setChoiceArray(iIntValue, (ExplicitGroup) obj2);
                break;
        }
    }
}
