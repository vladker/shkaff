package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRPrEltImpl;

/* JADX INFO: renamed from: r5.x0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1596x0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8084a;
    public final /* synthetic */ CTRPrEltImpl b;

    public /* synthetic */ C1596x0(CTRPrEltImpl cTRPrEltImpl, int i5) {
        this.f8084a = i5;
        this.b = cTRPrEltImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8084a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCharsetArray(iIntValue, (CTIntProperty) obj2);
                break;
            case 1:
                this.b.setStrikeArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 2:
                this.b.setOutlineArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 3:
                this.b.setUArray(iIntValue, (CTUnderlineProperty) obj2);
                break;
            case 4:
                this.b.setColorArray(iIntValue, (CTColor) obj2);
                break;
            case 5:
                this.b.setCondenseArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 6:
                this.b.setIArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 7:
                this.b.setSchemeArray(iIntValue, (CTFontScheme) obj2);
                break;
            case 8:
                this.b.setBArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 9:
                this.b.setSzArray(iIntValue, (CTFontSize) obj2);
                break;
            case 10:
                this.b.setFamilyArray(iIntValue, (CTIntProperty) obj2);
                break;
            case 11:
                this.b.setRFontArray(iIntValue, (CTFontName) obj2);
                break;
            case 12:
                this.b.setShadowArray(iIntValue, (CTBooleanProperty) obj2);
                break;
            case 13:
                this.b.setVertAlignArray(iIntValue, (CTVerticalAlignFontProperty) obj2);
                break;
            default:
                this.b.setExtendArray(iIntValue, (CTBooleanProperty) obj2);
                break;
        }
    }
}
