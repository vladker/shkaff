package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTBlipImpl;

/* JADX INFO: renamed from: l5.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1191k implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6014a;
    public final /* synthetic */ CTBlipImpl b;

    public /* synthetic */ C1191k(CTBlipImpl cTBlipImpl, int i5) {
        this.f6014a = i5;
        this.b = cTBlipImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f6014a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeBiLevel(iIntValue);
                break;
            case 1:
                this.b.removeHsl(iIntValue);
                break;
            case 2:
                this.b.removeGrayscl(iIntValue);
                break;
            case 3:
                this.b.removeLum(iIntValue);
                break;
            case 4:
                this.b.removeAlphaBiLevel(iIntValue);
                break;
            case 5:
                this.b.removeAlphaInv(iIntValue);
                break;
            case 6:
                this.b.removeClrRepl(iIntValue);
                break;
            case 7:
                this.b.removeAlphaFloor(iIntValue);
                break;
            case 8:
                this.b.removeAlphaRepl(iIntValue);
                break;
            case 9:
                this.b.removeAlphaMod(iIntValue);
                break;
            case 10:
                this.b.removeAlphaCeiling(iIntValue);
                break;
            case 11:
                this.b.removeFillOverlay(iIntValue);
                break;
            case 12:
                this.b.removeClrChange(iIntValue);
                break;
            case 13:
                this.b.removeTint(iIntValue);
                break;
            case 14:
                this.b.removeDuotone(iIntValue);
                break;
            case 15:
                this.b.removeBlur(iIntValue);
                break;
            default:
                this.b.removeAlphaModFix(iIntValue);
                break;
        }
    }
}
