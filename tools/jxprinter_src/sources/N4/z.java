package N4;

import java.util.function.Function;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.RealGroupImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class z implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f545a;
    public final /* synthetic */ RealGroupImpl b;

    public /* synthetic */ z(RealGroupImpl realGroupImpl, int i5) {
        this.f545a = i5;
        this.b = realGroupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f545a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAllArray(iIntValue);
            case 1:
                return this.b.getSequenceArray(iIntValue);
            case 2:
                return this.b.insertNewSequence(iIntValue);
            case 3:
                return this.b.insertNewAll(iIntValue);
            case 4:
                return this.b.getChoiceArray(iIntValue);
            default:
                return this.b.insertNewChoice(iIntValue);
        }
    }
}
