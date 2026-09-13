package l5;

import java.util.function.Function;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class M0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5934a;
    public final /* synthetic */ CTPath2DImpl b;

    public /* synthetic */ M0(CTPath2DImpl cTPath2DImpl, int i5) {
        this.f5934a = i5;
        this.b = cTPath2DImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f5934a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCubicBezToArray(iIntValue);
            case 1:
                return this.b.getCloseArray(iIntValue);
            case 2:
                return this.b.insertNewClose(iIntValue);
            case 3:
                return this.b.getMoveToArray(iIntValue);
            case 4:
                return this.b.insertNewMoveTo(iIntValue);
            case 5:
                return this.b.getArcToArray(iIntValue);
            case 6:
                return this.b.insertNewArcTo(iIntValue);
            case 7:
                return this.b.getLnToArray(iIntValue);
            case 8:
                return this.b.insertNewLnTo(iIntValue);
            case 9:
                return this.b.insertNewCubicBezTo(iIntValue);
            case 10:
                return this.b.getQuadBezToArray(iIntValue);
            default:
                return this.b.insertNewQuadBezTo(iIntValue);
        }
    }
}
