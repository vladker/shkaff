package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class D3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8261a;
    public final /* synthetic */ CTSmartTagRunImpl b;

    public /* synthetic */ D3(CTSmartTagRunImpl cTSmartTagRunImpl, int i5) {
        this.f8261a = i5;
        this.b = cTSmartTagRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8261a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getRArray(iIntValue);
            case 1:
                return this.b.insertNewR(iIntValue);
            case 2:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 4:
                return this.b.getInsArray(iIntValue);
            case 5:
                return this.b.insertNewIns(iIntValue);
            case 6:
                return this.b.getSmartTagArray(iIntValue);
            default:
                return this.b.insertNewSmartTag(iIntValue);
        }
    }
}
