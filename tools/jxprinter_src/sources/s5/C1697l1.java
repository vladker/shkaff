package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.l1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1697l1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8437a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1697l1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8437a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8437a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getIArray(iIntValue);
            case 1:
                return this.b.getCapsArray(iIntValue);
            case 2:
                return this.b.insertNewCaps(iIntValue);
            case 3:
                return this.b.getRtlArray(iIntValue);
            case 4:
                return this.b.insertNewRtl(iIntValue);
            case 5:
                return this.b.getBCsArray(iIntValue);
            case 6:
                return this.b.insertNewBCs(iIntValue);
            case 7:
                return this.b.getPositionArray(iIntValue);
            case 8:
                return this.b.insertNewPosition(iIntValue);
            case 9:
                return this.b.insertNewI(iIntValue);
            case 10:
                return this.b.getSpacingArray(iIntValue);
            case 11:
                return this.b.insertNewSpacing(iIntValue);
            case 12:
                return this.b.getBArray(iIntValue);
            case 13:
                return this.b.insertNewB(iIntValue);
            case 14:
                return this.b.getColorArray(iIntValue);
            case 15:
                return this.b.insertNewColor(iIntValue);
            case 16:
                return this.b.getEastAsianLayoutArray(iIntValue);
            default:
                return this.b.insertNewEastAsianLayout(iIntValue);
        }
    }
}
