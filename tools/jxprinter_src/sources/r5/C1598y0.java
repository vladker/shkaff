package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRPrEltImpl;

/* JADX INFO: renamed from: r5.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1598y0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8086a;
    public final /* synthetic */ CTRPrEltImpl b;

    public /* synthetic */ C1598y0(CTRPrEltImpl cTRPrEltImpl, int i5) {
        this.f8086a = i5;
        this.b = cTRPrEltImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8086a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCharset(iIntValue);
                break;
            case 1:
                this.b.removeStrike(iIntValue);
                break;
            case 2:
                this.b.removeU(iIntValue);
                break;
            case 3:
                this.b.removeColor(iIntValue);
                break;
            case 4:
                this.b.removeCondense(iIntValue);
                break;
            case 5:
                this.b.removeI(iIntValue);
                break;
            case 6:
                this.b.removeOutline(iIntValue);
                break;
            case 7:
                this.b.removeScheme(iIntValue);
                break;
            case 8:
                this.b.removeB(iIntValue);
                break;
            case 9:
                this.b.removeSz(iIntValue);
                break;
            case 10:
                this.b.removeFamily(iIntValue);
                break;
            case 11:
                this.b.removeRFont(iIntValue);
                break;
            case 12:
                this.b.removeShadow(iIntValue);
                break;
            case 13:
                this.b.removeExtend(iIntValue);
                break;
            default:
                this.b.removeVertAlign(iIntValue);
                break;
        }
    }
}
