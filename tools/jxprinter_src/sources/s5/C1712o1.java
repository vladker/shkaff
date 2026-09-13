package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedHpsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.o1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1712o1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8452a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1712o1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8452a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8452a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setRtlArray(iIntValue, (CTOnOff) obj2);
                break;
            case 1:
                this.b.setIArray(iIntValue, (CTOnOff) obj2);
                break;
            case 2:
                this.b.setBCsArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setPositionArray(iIntValue, (CTSignedHpsMeasure) obj2);
                break;
            case 4:
                this.b.setSpacingArray(iIntValue, (CTSignedTwipsMeasure) obj2);
                break;
            case 5:
                this.b.setBArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
        }
    }
}
