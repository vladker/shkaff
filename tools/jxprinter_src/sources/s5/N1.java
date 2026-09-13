package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class N1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8309a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ N1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8309a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSzArray;
        switch (this.f8309a) {
            case 0:
                iSizeOfSzArray = this.b.sizeOfSzArray();
                break;
            case 1:
                iSizeOfSzArray = this.b.sizeOfPositionArray();
                break;
            case 2:
                iSizeOfSzArray = this.b.sizeOfRStyleArray();
                break;
            case 3:
                iSizeOfSzArray = this.b.sizeOfWArray();
                break;
            case 4:
                iSizeOfSzArray = this.b.sizeOfBdrArray();
                break;
            case 5:
                iSizeOfSzArray = this.b.sizeOfFitTextArray();
                break;
            case 6:
                iSizeOfSzArray = this.b.sizeOfSpecVanishArray();
                break;
            case 7:
                iSizeOfSzArray = this.b.sizeOfLangArray();
                break;
            case 8:
                iSizeOfSzArray = this.b.sizeOfBArray();
                break;
            case 9:
                iSizeOfSzArray = this.b.sizeOfNoProofArray();
                break;
            case 10:
                iSizeOfSzArray = this.b.sizeOfDstrikeArray();
                break;
            case 11:
                iSizeOfSzArray = this.b.sizeOfWebHiddenArray();
                break;
            case 12:
                iSizeOfSzArray = this.b.sizeOfEffectArray();
                break;
            case 13:
                iSizeOfSzArray = this.b.sizeOfKernArray();
                break;
            case 14:
                iSizeOfSzArray = this.b.sizeOfUArray();
                break;
            case 15:
                iSizeOfSzArray = this.b.sizeOfSmallCapsArray();
                break;
            case 16:
                iSizeOfSzArray = this.b.sizeOfEmbossArray();
                break;
            case 17:
                iSizeOfSzArray = this.b.sizeOfHighlightArray();
                break;
            case 18:
                iSizeOfSzArray = this.b.sizeOfCapsArray();
                break;
            case 19:
                iSizeOfSzArray = this.b.sizeOfImprintArray();
                break;
            case 20:
                iSizeOfSzArray = this.b.sizeOfEastAsianLayoutArray();
                break;
            case 21:
                iSizeOfSzArray = this.b.sizeOfCsArray();
                break;
            case 22:
                iSizeOfSzArray = this.b.sizeOfShadowArray();
                break;
            case 23:
                iSizeOfSzArray = this.b.sizeOfVanishArray();
                break;
            case 24:
                iSizeOfSzArray = this.b.sizeOfVertAlignArray();
                break;
            case 25:
                iSizeOfSzArray = this.b.sizeOfOMathArray();
                break;
            case 26:
                iSizeOfSzArray = this.b.sizeOfICsArray();
                break;
            case 27:
                iSizeOfSzArray = this.b.sizeOfSzCsArray();
                break;
            case 28:
                iSizeOfSzArray = this.b.sizeOfIArray();
                break;
            default:
                iSizeOfSzArray = this.b.sizeOfSpacingArray();
                break;
        }
        return Integer.valueOf(iSizeOfSzArray);
    }
}
