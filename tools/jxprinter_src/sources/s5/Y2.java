package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Y2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8364a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ Y2(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8364a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8364a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getFldSimpleArray(iIntValue);
            case 1:
                return this.b.insertNewFldSimple(iIntValue);
            case 2:
                return this.b.getPermStartArray(iIntValue);
            case 3:
                return this.b.insertNewPermStart(iIntValue);
            case 4:
                return this.b.getBdoArray(iIntValue);
            case 5:
                return this.b.insertNewBdo(iIntValue);
            case 6:
                return this.b.getMoveToRangeStartArray(iIntValue);
            default:
                return this.b.insertNewMoveToRangeStart(iIntValue);
        }
    }
}
