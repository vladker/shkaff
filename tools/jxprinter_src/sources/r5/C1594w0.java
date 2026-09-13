package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRPrEltImpl;

/* JADX INFO: renamed from: r5.w0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1594w0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8082a;
    public final /* synthetic */ CTRPrEltImpl b;

    public /* synthetic */ C1594w0(CTRPrEltImpl cTRPrEltImpl, int i5) {
        this.f8082a = i5;
        this.b = cTRPrEltImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8082a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getOutlineArray(iIntValue);
            case 1:
                return this.b.getCharsetArray(iIntValue);
            case 2:
                return this.b.insertNewCharset(iIntValue);
            case 3:
                return this.b.getStrikeArray(iIntValue);
            case 4:
                return this.b.insertNewStrike(iIntValue);
            case 5:
                return this.b.getUArray(iIntValue);
            case 6:
                return this.b.insertNewU(iIntValue);
            case 7:
                return this.b.getColorArray(iIntValue);
            case 8:
                return this.b.insertNewColor(iIntValue);
            case 9:
                return this.b.insertNewOutline(iIntValue);
            case 10:
                return this.b.getCondenseArray(iIntValue);
            case 11:
                return this.b.insertNewCondense(iIntValue);
            case 12:
                return this.b.getIArray(iIntValue);
            case 13:
                return this.b.insertNewI(iIntValue);
            case 14:
                return this.b.getSchemeArray(iIntValue);
            case 15:
                return this.b.insertNewScheme(iIntValue);
            case 16:
                return this.b.getBArray(iIntValue);
            case 17:
                return this.b.insertNewB(iIntValue);
            case 18:
                return this.b.getSzArray(iIntValue);
            case 19:
                return this.b.insertNewSz(iIntValue);
            case 20:
                return this.b.getFamilyArray(iIntValue);
            case 21:
                return this.b.insertNewFamily(iIntValue);
            case 22:
                return this.b.getVertAlignArray(iIntValue);
            case 23:
                return this.b.getRFontArray(iIntValue);
            case 24:
                return this.b.insertNewRFont(iIntValue);
            case 25:
                return this.b.getShadowArray(iIntValue);
            case 26:
                return this.b.insertNewShadow(iIntValue);
            case 27:
                return this.b.getExtendArray(iIntValue);
            case 28:
                return this.b.insertNewExtend(iIntValue);
            default:
                return this.b.insertNewVertAlign(iIntValue);
        }
    }
}
