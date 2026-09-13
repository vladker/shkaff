package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class S implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8012a;
    public final /* synthetic */ CTFontImpl b;

    public /* synthetic */ S(CTFontImpl cTFontImpl, int i5) {
        this.f8012a = i5;
        this.b = cTFontImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8012a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getUArray(iIntValue);
            case 1:
                return this.b.getIArray(iIntValue);
            case 2:
                return this.b.insertNewI(iIntValue);
            case 3:
                return this.b.getSzArray(iIntValue);
            case 4:
                return this.b.insertNewSz(iIntValue);
            case 5:
                return this.b.getCondenseArray(iIntValue);
            case 6:
                return this.b.insertNewCondense(iIntValue);
            case 7:
                return this.b.getNameArray(iIntValue);
            case 8:
                return this.b.insertNewName(iIntValue);
            case 9:
                return this.b.insertNewU(iIntValue);
            case 10:
                return this.b.getBArray(iIntValue);
            case 11:
                return this.b.insertNewB(iIntValue);
            case 12:
                return this.b.getColorArray(iIntValue);
            case 13:
                return this.b.insertNewColor(iIntValue);
            case 14:
                return this.b.getSchemeArray(iIntValue);
            case 15:
                return this.b.insertNewScheme(iIntValue);
            case 16:
                return this.b.getFamilyArray(iIntValue);
            case 17:
                return this.b.insertNewFamily(iIntValue);
            case 18:
                return this.b.getStrikeArray(iIntValue);
            case 19:
                return this.b.insertNewStrike(iIntValue);
            case 20:
                return this.b.getVertAlignArray(iIntValue);
            case 21:
                return this.b.insertNewVertAlign(iIntValue);
            case 22:
                return this.b.getExtendArray(iIntValue);
            case 23:
                return this.b.getCharsetArray(iIntValue);
            case 24:
                return this.b.insertNewCharset(iIntValue);
            case 25:
                return this.b.getOutlineArray(iIntValue);
            case 26:
                return this.b.insertNewOutline(iIntValue);
            case 27:
                return this.b.getShadowArray(iIntValue);
            case 28:
                return this.b.insertNewShadow(iIntValue);
            default:
                return this.b.insertNewExtend(iIntValue);
        }
    }
}
