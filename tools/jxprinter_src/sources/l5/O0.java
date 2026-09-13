package l5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class O0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5940a;
    public final /* synthetic */ CTPath2DImpl b;

    public /* synthetic */ O0(CTPath2DImpl cTPath2DImpl, int i5) {
        this.f5940a = i5;
        this.b = cTPath2DImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f5940a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeClose(iIntValue);
                break;
            case 1:
                this.b.removeMoveTo(iIntValue);
                break;
            case 2:
                this.b.removeArcTo(iIntValue);
                break;
            case 3:
                this.b.removeLnTo(iIntValue);
                break;
            case 4:
                this.b.removeCubicBezTo(iIntValue);
                break;
            default:
                this.b.removeQuadBezTo(iIntValue);
                break;
        }
    }
}
