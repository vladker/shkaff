package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class R1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8328a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ R1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8328a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8328a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getStrikeArray(iIntValue);
            case 1:
                return this.b.getOutlineArray(iIntValue);
            case 2:
                return this.b.insertNewOutline(iIntValue);
            case 3:
                return this.b.getBCsArray(iIntValue);
            case 4:
                return this.b.insertNewBCs(iIntValue);
            case 5:
                return this.b.getRFontsArray(iIntValue);
            case 6:
                return this.b.insertNewRFonts(iIntValue);
            case 7:
                return this.b.getRtlArray(iIntValue);
            case 8:
                return this.b.insertNewRtl(iIntValue);
            case 9:
                return this.b.insertNewStrike(iIntValue);
            case 10:
                return this.b.getShdArray(iIntValue);
            case 11:
                return this.b.insertNewShd(iIntValue);
            case 12:
                return this.b.getSnapToGridArray(iIntValue);
            case 13:
                return this.b.insertNewSnapToGrid(iIntValue);
            case 14:
                return this.b.getEmArray(iIntValue);
            case 15:
                return this.b.insertNewEm(iIntValue);
            case 16:
                return this.b.getColorArray(iIntValue);
            default:
                return this.b.insertNewColor(iIntValue);
        }
    }
}
