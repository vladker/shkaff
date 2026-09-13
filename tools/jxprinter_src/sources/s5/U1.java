package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class U1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8343a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ U1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8343a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8343a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setStrikeArray(iIntValue, (CTOnOff) obj2);
                break;
            case 1:
                this.b.setRFontsArray(iIntValue, (CTFonts) obj2);
                break;
            case 2:
                this.b.setRtlArray(iIntValue, (CTOnOff) obj2);
                break;
            case 3:
                this.b.setShdArray(iIntValue, (CTShd) obj2);
                break;
            case 4:
                this.b.setSnapToGridArray(iIntValue, (CTOnOff) obj2);
                break;
            case 5:
                this.b.setEmArray(iIntValue, (CTEm) obj2);
                break;
            default:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
        }
    }
}
