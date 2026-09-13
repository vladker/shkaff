package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectContainerImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class K implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5927a;
    public final /* synthetic */ CTEffectContainerImpl b;

    public /* synthetic */ K(CTEffectContainerImpl cTEffectContainerImpl, int i5) {
        this.f5927a = i5;
        this.b = cTEffectContainerImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5927a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeRelOff(iIntValue);
                break;
            case 1:
                this.b.removeAlphaOutset(iIntValue);
                break;
            case 2:
                this.b.removeFillOverlay(iIntValue);
                break;
            case 3:
                this.b.removeAlphaInv(iIntValue);
                break;
            case 4:
                this.b.removeTint(iIntValue);
                break;
            case 5:
                this.b.removeClrChange(iIntValue);
                break;
            case 6:
                this.b.removeAlphaCeiling(iIntValue);
                break;
            case 7:
                this.b.removeBiLevel(iIntValue);
                break;
            case 8:
                this.b.removeGrayscl(iIntValue);
                break;
            case 9:
                this.b.removeEffect(iIntValue);
                break;
            case 10:
                this.b.removeBlend(iIntValue);
                break;
            case 11:
                this.b.removeReflection(iIntValue);
                break;
            case 12:
                this.b.removePrstShdw(iIntValue);
                break;
            case 13:
                this.b.removeAlphaFloor(iIntValue);
                break;
            case 14:
                this.b.removeAlphaBiLevel(iIntValue);
                break;
            case 15:
                this.b.removeAlphaRepl(iIntValue);
                break;
            case 16:
                this.b.removeInnerShdw(iIntValue);
                break;
            case 17:
                this.b.removeBlur(iIntValue);
                break;
            case 18:
                this.b.removeXfrm(iIntValue);
                break;
            case 19:
                this.b.removeClrRepl(iIntValue);
                break;
            case 20:
                this.b.removeCont(iIntValue);
                break;
            case 21:
                this.b.removeSoftEdge(iIntValue);
                break;
            case 22:
                this.b.removeDuotone(iIntValue);
                break;
            case 23:
                this.b.removeHsl(iIntValue);
                break;
            case 24:
                this.b.removeLum(iIntValue);
                break;
            case 25:
                this.b.removeAlphaMod(iIntValue);
                break;
            case 26:
                this.b.removeGlow(iIntValue);
                break;
            case 27:
                this.b.removeAlphaModFix(iIntValue);
                break;
            case 28:
                this.b.removeOuterShdw(iIntValue);
                break;
            default:
                this.b.removeFill(iIntValue);
                break;
        }
    }
}
