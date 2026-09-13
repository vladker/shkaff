package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class G1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8274a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ G1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8274a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8274a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getRFontsArray(iIntValue);
            case 1:
                return this.b.getIArray(iIntValue);
            case 2:
                return this.b.insertNewI(iIntValue);
            case 3:
                return this.b.getVanishArray(iIntValue);
            case 4:
                return this.b.insertNewVanish(iIntValue);
            case 5:
                return this.b.getLangArray(iIntValue);
            case 6:
                return this.b.insertNewLang(iIntValue);
            case 7:
                return this.b.getSpacingArray(iIntValue);
            case 8:
                return this.b.insertNewSpacing(iIntValue);
            case 9:
                return this.b.insertNewRFonts(iIntValue);
            case 10:
                return this.b.getSpecVanishArray(iIntValue);
            case 11:
                return this.b.insertNewSpecVanish(iIntValue);
            case 12:
                return this.b.getBdrArray(iIntValue);
            case 13:
                return this.b.insertNewBdr(iIntValue);
            case 14:
                return this.b.getDstrikeArray(iIntValue);
            case 15:
                return this.b.insertNewDstrike(iIntValue);
            case 16:
                return this.b.getPositionArray(iIntValue);
            default:
                return this.b.insertNewPosition(iIntValue);
        }
    }
}
