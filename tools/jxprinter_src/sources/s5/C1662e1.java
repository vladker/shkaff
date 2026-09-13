package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: renamed from: s5.e1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1662e1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8397a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ C1662e1(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8397a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8397a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setEmArray(iIntValue, (CTEm) obj2);
                break;
            case 1:
                this.b.setSpacingArray(iIntValue, (CTSignedTwipsMeasure) obj2);
                break;
            case 2:
                this.b.setVanishArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setVertAlignArray(iIntValue, (CTVerticalAlignRun) obj2);
                break;
            case 4:
                this.b.setSnapToGridArray(iIntValue, (CTOnOff) obj2);
                break;
            case 5:
                this.b.setSpecVanishArray(iIntValue, (CTOnOff) obj2);
                break;
            default:
                this.b.setShdArray(iIntValue, (CTShd) obj2);
                break;
        }
    }
}
