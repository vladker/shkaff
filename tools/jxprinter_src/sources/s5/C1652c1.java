package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: renamed from: s5.c1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1652c1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8385a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ C1652c1(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8385a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8385a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeStrike(iIntValue);
                break;
            case 1:
                this.b.removeRFonts(iIntValue);
                break;
            case 2:
                this.b.removeSpacing(iIntValue);
                break;
            case 3:
                this.b.removeVanish(iIntValue);
                break;
            case 4:
                this.b.removeVertAlign(iIntValue);
                break;
            case 5:
                this.b.removeSnapToGrid(iIntValue);
                break;
            case 6:
                this.b.removeEm(iIntValue);
                break;
            case 7:
                this.b.removeSpecVanish(iIntValue);
                break;
            default:
                this.b.removeShd(iIntValue);
                break;
        }
    }
}
