package N4;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RealGroupImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f502a;
    public final /* synthetic */ RealGroupImpl b;

    public /* synthetic */ C(RealGroupImpl realGroupImpl, int i5) {
        this.f502a = i5;
        this.b = realGroupImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSequenceArray;
        switch (this.f502a) {
            case 0:
                iSizeOfSequenceArray = this.b.sizeOfSequenceArray();
                break;
            case 1:
                iSizeOfSequenceArray = this.b.sizeOfAllArray();
                break;
            default:
                iSizeOfSequenceArray = this.b.sizeOfChoiceArray();
                break;
        }
        return Integer.valueOf(iSizeOfSequenceArray);
    }
}
