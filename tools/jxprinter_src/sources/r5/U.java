package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class U implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8016a;
    public final /* synthetic */ CTFontImpl b;

    public /* synthetic */ U(CTFontImpl cTFontImpl, int i5) {
        this.f8016a = i5;
        this.b = cTFontImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8016a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeI(iIntValue);
                break;
            case 1:
                this.b.removeSz(iIntValue);
                break;
            case 2:
                this.b.removeCondense(iIntValue);
                break;
            case 3:
                this.b.removeName(iIntValue);
                break;
            case 4:
                this.b.removeB(iIntValue);
                break;
            case 5:
                this.b.removeColor(iIntValue);
                break;
            case 6:
                this.b.removeU(iIntValue);
                break;
            case 7:
                this.b.removeScheme(iIntValue);
                break;
            case 8:
                this.b.removeFamily(iIntValue);
                break;
            case 9:
                this.b.removeStrike(iIntValue);
                break;
            case 10:
                this.b.removeVertAlign(iIntValue);
                break;
            case 11:
                this.b.removeCharset(iIntValue);
                break;
            case 12:
                this.b.removeOutline(iIntValue);
                break;
            case 13:
                this.b.removeShadow(iIntValue);
                break;
            default:
                this.b.removeExtend(iIntValue);
                break;
        }
    }
}
