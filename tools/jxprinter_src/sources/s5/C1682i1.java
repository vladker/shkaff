package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.i1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1682i1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8421a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1682i1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8421a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfKernArray;
        switch (this.f8421a) {
            case 0:
                iSizeOfKernArray = this.b.sizeOfKernArray();
                break;
            case 1:
                iSizeOfKernArray = this.b.sizeOfVanishArray();
                break;
            case 2:
                iSizeOfKernArray = this.b.sizeOfSzArray();
                break;
            case 3:
                iSizeOfKernArray = this.b.sizeOfUArray();
                break;
            case 4:
                iSizeOfKernArray = this.b.sizeOfOutlineArray();
                break;
            case 5:
                iSizeOfKernArray = this.b.sizeOfSzCsArray();
                break;
            case 6:
                iSizeOfKernArray = this.b.sizeOfSnapToGridArray();
                break;
            case 7:
                iSizeOfKernArray = this.b.sizeOfImprintArray();
                break;
            case 8:
                iSizeOfKernArray = this.b.sizeOfFitTextArray();
                break;
            case 9:
                iSizeOfKernArray = this.b.sizeOfNoProofArray();
                break;
            case 10:
                iSizeOfKernArray = this.b.sizeOfStrikeArray();
                break;
            case 11:
                iSizeOfKernArray = this.b.sizeOfVertAlignArray();
                break;
            case 12:
                iSizeOfKernArray = this.b.sizeOfSmallCapsArray();
                break;
            case 13:
                iSizeOfKernArray = this.b.sizeOfWebHiddenArray();
                break;
            case 14:
                iSizeOfKernArray = this.b.sizeOfHighlightArray();
                break;
            case 15:
                iSizeOfKernArray = this.b.sizeOfBdrArray();
                break;
            case 16:
                iSizeOfKernArray = this.b.sizeOfRFontsArray();
                break;
            case 17:
                iSizeOfKernArray = this.b.sizeOfLangArray();
                break;
            case 18:
                iSizeOfKernArray = this.b.sizeOfShadowArray();
                break;
            case 19:
                iSizeOfKernArray = this.b.sizeOfEmArray();
                break;
            case 20:
                iSizeOfKernArray = this.b.sizeOfOMathArray();
                break;
            case 21:
                iSizeOfKernArray = this.b.sizeOfWArray();
                break;
            case 22:
                iSizeOfKernArray = this.b.sizeOfEmbossArray();
                break;
            case 23:
                iSizeOfKernArray = this.b.sizeOfICsArray();
                break;
            case 24:
                iSizeOfKernArray = this.b.sizeOfShdArray();
                break;
            case 25:
                iSizeOfKernArray = this.b.sizeOfRStyleArray();
                break;
            case 26:
                iSizeOfKernArray = this.b.sizeOfDstrikeArray();
                break;
            case 27:
                iSizeOfKernArray = this.b.sizeOfSpecVanishArray();
                break;
            case 28:
                iSizeOfKernArray = this.b.sizeOfEffectArray();
                break;
            default:
                iSizeOfKernArray = this.b.sizeOfCsArray();
                break;
        }
        return Integer.valueOf(iSizeOfKernArray);
    }
}
