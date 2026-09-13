package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class H1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8279a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ H1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8279a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8279a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeI(iIntValue);
                break;
            case 1:
                this.b.removeVanish(iIntValue);
                break;
            case 2:
                this.b.removeLang(iIntValue);
                break;
            case 3:
                this.b.removeSpacing(iIntValue);
                break;
            case 4:
                this.b.removeSpecVanish(iIntValue);
                break;
            case 5:
                this.b.removeBdr(iIntValue);
                break;
            case 6:
                this.b.removeRFonts(iIntValue);
                break;
            case 7:
                this.b.removeDstrike(iIntValue);
                break;
            default:
                this.b.removePosition(iIntValue);
                break;
        }
    }
}
