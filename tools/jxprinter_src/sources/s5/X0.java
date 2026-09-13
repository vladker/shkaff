package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class X0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8357a;
    public final /* synthetic */ CTParaRPrImpl b;

    public /* synthetic */ X0(CTParaRPrImpl cTParaRPrImpl, int i5) {
        this.f8357a = i5;
        this.b = cTParaRPrImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDstrikeArray;
        switch (this.f8357a) {
            case 0:
                iSizeOfDstrikeArray = this.b.sizeOfDstrikeArray();
                break;
            case 1:
                iSizeOfDstrikeArray = this.b.sizeOfShadowArray();
                break;
            case 2:
                iSizeOfDstrikeArray = this.b.sizeOfCapsArray();
                break;
            case 3:
                iSizeOfDstrikeArray = this.b.sizeOfSmallCapsArray();
                break;
            case 4:
                iSizeOfDstrikeArray = this.b.sizeOfPositionArray();
                break;
            case 5:
                iSizeOfDstrikeArray = this.b.sizeOfIArray();
                break;
            case 6:
                iSizeOfDstrikeArray = this.b.sizeOfOutlineArray();
                break;
            case 7:
                iSizeOfDstrikeArray = this.b.sizeOfRtlArray();
                break;
            case 8:
                iSizeOfDstrikeArray = this.b.sizeOfSzCsArray();
                break;
            case 9:
                iSizeOfDstrikeArray = this.b.sizeOfWebHiddenArray();
                break;
            case 10:
                iSizeOfDstrikeArray = this.b.sizeOfICsArray();
                break;
            case 11:
                iSizeOfDstrikeArray = this.b.sizeOfOMathArray();
                break;
            case 12:
                iSizeOfDstrikeArray = this.b.sizeOfCsArray();
                break;
            case 13:
                iSizeOfDstrikeArray = this.b.sizeOfNoProofArray();
                break;
            case 14:
                iSizeOfDstrikeArray = this.b.sizeOfHighlightArray();
                break;
            case 15:
                iSizeOfDstrikeArray = this.b.sizeOfKernArray();
                break;
            case 16:
                iSizeOfDstrikeArray = this.b.sizeOfBdrArray();
                break;
            case 17:
                iSizeOfDstrikeArray = this.b.sizeOfFitTextArray();
                break;
            case 18:
                iSizeOfDstrikeArray = this.b.sizeOfBCsArray();
                break;
            case 19:
                iSizeOfDstrikeArray = this.b.sizeOfBArray();
                break;
            case 20:
                iSizeOfDstrikeArray = this.b.sizeOfEffectArray();
                break;
            case 21:
                iSizeOfDstrikeArray = this.b.sizeOfWArray();
                break;
            case 22:
                iSizeOfDstrikeArray = this.b.sizeOfRStyleArray();
                break;
            case 23:
                iSizeOfDstrikeArray = this.b.sizeOfEmbossArray();
                break;
            case 24:
                iSizeOfDstrikeArray = this.b.sizeOfImprintArray();
                break;
            case 25:
                iSizeOfDstrikeArray = this.b.sizeOfEastAsianLayoutArray();
                break;
            case 26:
                iSizeOfDstrikeArray = this.b.sizeOfColorArray();
                break;
            case 27:
                iSizeOfDstrikeArray = this.b.sizeOfSzArray();
                break;
            case 28:
                iSizeOfDstrikeArray = this.b.sizeOfUArray();
                break;
            default:
                iSizeOfDstrikeArray = this.b.sizeOfLangArray();
                break;
        }
        return Integer.valueOf(iSizeOfDstrikeArray);
    }
}
