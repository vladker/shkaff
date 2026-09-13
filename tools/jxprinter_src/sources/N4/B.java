package N4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RealGroupImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class B implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f501a;
    public final /* synthetic */ RealGroupImpl b;

    public /* synthetic */ B(RealGroupImpl realGroupImpl, int i5) {
        this.f501a = i5;
        this.b = realGroupImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f501a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSequence(iIntValue);
                break;
            case 1:
                this.b.removeAll(iIntValue);
                break;
            default:
                this.b.removeChoice(iIntValue);
                break;
        }
    }
}
