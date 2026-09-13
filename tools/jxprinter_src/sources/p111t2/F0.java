package p111t2;

import com.microsoft.schemas.vml.impl.CTShapeImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class F0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8558a;
    public final /* synthetic */ CTShapeImpl b;

    public /* synthetic */ F0(CTShapeImpl cTShapeImpl, int i5) {
        this.f8558a = i5;
        this.b = cTShapeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8558a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeImagedata(iIntValue);
                break;
            case 1:
                this.b.removeWrap(iIntValue);
                break;
            case 2:
                this.b.removeEquationxml(iIntValue);
                break;
            case 3:
                this.b.removeTextpath(iIntValue);
                break;
            case 4:
                this.b.removeHandles(iIntValue);
                break;
            case 5:
                this.b.removeBordertop(iIntValue);
                break;
            case 6:
                this.b.removeIscomment(iIntValue);
                break;
            case 7:
                this.b.removeCallout(iIntValue);
                break;
            case 8:
                this.b.removeExtrusion(iIntValue);
                break;
            case 9:
                this.b.removeLock(iIntValue);
                break;
            case 10:
                this.b.removeFormulas(iIntValue);
                break;
            case 11:
                this.b.removeTextbox(iIntValue);
                break;
            case 12:
                this.b.removeSkew(iIntValue);
                break;
            case 13:
                this.b.removeBorderleft(iIntValue);
                break;
            case 14:
                this.b.removeInk(iIntValue);
                break;
            case 15:
                this.b.removeClippath(iIntValue);
                break;
            case 16:
                this.b.removeBorderbottom(iIntValue);
                break;
            case 17:
                this.b.removeFill(iIntValue);
                break;
            case 18:
                this.b.removeAnchorlock(iIntValue);
                break;
            case 19:
                this.b.removeSignatureline(iIntValue);
                break;
            case 20:
                this.b.removeStroke(iIntValue);
                break;
            case 21:
                this.b.removeBorderright(iIntValue);
                break;
            case 22:
                this.b.removeShadow(iIntValue);
                break;
            case 23:
                this.b.removeTextdata(iIntValue);
                break;
            case 24:
                this.b.removePath(iIntValue);
                break;
            default:
                this.b.removeClientData(iIntValue);
                break;
        }
    }
}
