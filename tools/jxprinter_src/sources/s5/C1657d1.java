package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: renamed from: s5.d1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1657d1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8391a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ C1657d1(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8391a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfStrikeArray;
        switch (this.f8391a) {
            case 0:
                iSizeOfStrikeArray = this.b.sizeOfStrikeArray();
                break;
            case 1:
                iSizeOfStrikeArray = this.b.sizeOfRFontsArray();
                break;
            case 2:
                iSizeOfStrikeArray = this.b.sizeOfSpacingArray();
                break;
            case 3:
                iSizeOfStrikeArray = this.b.sizeOfVanishArray();
                break;
            case 4:
                iSizeOfStrikeArray = this.b.sizeOfVertAlignArray();
                break;
            case 5:
                iSizeOfStrikeArray = this.b.sizeOfSnapToGridArray();
                break;
            case 6:
                iSizeOfStrikeArray = this.b.sizeOfSpecVanishArray();
                break;
            case 7:
                iSizeOfStrikeArray = this.b.sizeOfShdArray();
                break;
            default:
                iSizeOfStrikeArray = this.b.sizeOfEmArray();
                break;
        }
        return Integer.valueOf(iSizeOfStrikeArray);
    }
}
