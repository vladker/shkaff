package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.m1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1702m1 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8442a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1702m1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8442a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8442a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCaps(iIntValue);
                break;
            case 1:
                this.b.removeRtl(iIntValue);
                break;
            case 2:
                this.b.removeBCs(iIntValue);
                break;
            case 3:
                this.b.removePosition(iIntValue);
                break;
            case 4:
                this.b.removeSpacing(iIntValue);
                break;
            case 5:
                this.b.removeB(iIntValue);
                break;
            case 6:
                this.b.removeI(iIntValue);
                break;
            case 7:
                this.b.removeColor(iIntValue);
                break;
            default:
                this.b.removeEastAsianLayout(iIntValue);
                break;
        }
    }
}
