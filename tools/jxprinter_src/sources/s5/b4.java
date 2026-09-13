package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTrPrBaseImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class b4 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8382a;
    public final /* synthetic */ CTTrPrBaseImpl b;

    public /* synthetic */ b4(CTTrPrBaseImpl cTTrPrBaseImpl, int i5) {
        this.f8382a = i5;
        this.b = cTTrPrBaseImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8382a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCantSplit(iIntValue);
                break;
            case 1:
                this.b.removeTrHeight(iIntValue);
                break;
            case 2:
                this.b.removeDivId(iIntValue);
                break;
            case 3:
                this.b.removeCnfStyle(iIntValue);
                break;
            case 4:
                this.b.removeGridBefore(iIntValue);
                break;
            case 5:
                this.b.removeWAfter(iIntValue);
                break;
            case 6:
                this.b.removeGridAfter(iIntValue);
                break;
            case 7:
                this.b.removeHidden(iIntValue);
                break;
            case 8:
                this.b.removeWBefore(iIntValue);
                break;
            case 9:
                this.b.removeJc(iIntValue);
                break;
            case 10:
                this.b.removeTblCellSpacing(iIntValue);
                break;
            default:
                this.b.removeTblHeader(iIntValue);
                break;
        }
    }
}
