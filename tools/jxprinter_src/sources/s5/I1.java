package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class I1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8284a;
    public final /* synthetic */ CTRPrImpl b;

    public /* synthetic */ I1(CTRPrImpl cTRPrImpl, int i5) {
        this.f8284a = i5;
        this.b = cTRPrImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfIArray;
        switch (this.f8284a) {
            case 0:
                iSizeOfIArray = this.b.sizeOfIArray();
                break;
            case 1:
                iSizeOfIArray = this.b.sizeOfVanishArray();
                break;
            case 2:
                iSizeOfIArray = this.b.sizeOfLangArray();
                break;
            case 3:
                iSizeOfIArray = this.b.sizeOfSpacingArray();
                break;
            case 4:
                iSizeOfIArray = this.b.sizeOfSpecVanishArray();
                break;
            case 5:
                iSizeOfIArray = this.b.sizeOfBdrArray();
                break;
            case 6:
                iSizeOfIArray = this.b.sizeOfDstrikeArray();
                break;
            case 7:
                iSizeOfIArray = this.b.sizeOfPositionArray();
                break;
            default:
                iSizeOfIArray = this.b.sizeOfRFontsArray();
                break;
        }
        return Integer.valueOf(iSizeOfIArray);
    }
}
