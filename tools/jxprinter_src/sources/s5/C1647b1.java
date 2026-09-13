package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: renamed from: s5.b1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1647b1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8379a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ C1647b1(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8379a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8379a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getEmArray(iIntValue);
            case 1:
                return this.b.getStrikeArray(iIntValue);
            case 2:
                return this.b.insertNewStrike(iIntValue);
            case 3:
                return this.b.getRFontsArray(iIntValue);
            case 4:
                return this.b.insertNewRFonts(iIntValue);
            case 5:
                return this.b.getSpacingArray(iIntValue);
            case 6:
                return this.b.insertNewSpacing(iIntValue);
            case 7:
                return this.b.getVanishArray(iIntValue);
            case 8:
                return this.b.insertNewVanish(iIntValue);
            case 9:
                return this.b.insertNewEm(iIntValue);
            case 10:
                return this.b.getVertAlignArray(iIntValue);
            case 11:
                return this.b.insertNewVertAlign(iIntValue);
            case 12:
                return this.b.getSnapToGridArray(iIntValue);
            case 13:
                return this.b.insertNewSnapToGrid(iIntValue);
            case 14:
                return this.b.getSpecVanishArray(iIntValue);
            case 15:
                return this.b.insertNewSpecVanish(iIntValue);
            case 16:
                return this.b.getShdArray(iIntValue);
            default:
                return this.b.insertNewShd(iIntValue);
        }
    }
}
