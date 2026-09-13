package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7802a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ d0(CTOMathImpl cTOMathImpl, int i5) {
        this.f7802a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7802a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewD(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 2:
                return this.b.getSSubArray(iIntValue);
            case 3:
                return this.b.insertNewSSub(iIntValue);
            case 4:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 5:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 6:
                return this.b.getFuncArray(iIntValue);
            case 7:
                return this.b.insertNewFunc(iIntValue);
            case 8:
                return this.b.getPermEndArray(iIntValue);
            default:
                return this.b.insertNewPermEnd(iIntValue);
        }
    }
}
