package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRPrEltImpl;

/* JADX INFO: renamed from: r5.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1600z0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8088a;
    public final /* synthetic */ CTRPrEltImpl b;

    public /* synthetic */ C1600z0(CTRPrEltImpl cTRPrEltImpl, int i5) {
        this.f8088a = i5;
        this.b = cTRPrEltImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCharsetArray;
        switch (this.f8088a) {
            case 0:
                iSizeOfCharsetArray = this.b.sizeOfCharsetArray();
                break;
            case 1:
                iSizeOfCharsetArray = this.b.sizeOfStrikeArray();
                break;
            case 2:
                iSizeOfCharsetArray = this.b.sizeOfUArray();
                break;
            case 3:
                iSizeOfCharsetArray = this.b.sizeOfColorArray();
                break;
            case 4:
                iSizeOfCharsetArray = this.b.sizeOfCondenseArray();
                break;
            case 5:
                iSizeOfCharsetArray = this.b.sizeOfIArray();
                break;
            case 6:
                iSizeOfCharsetArray = this.b.sizeOfSchemeArray();
                break;
            case 7:
                iSizeOfCharsetArray = this.b.sizeOfBArray();
                break;
            case 8:
                iSizeOfCharsetArray = this.b.sizeOfOutlineArray();
                break;
            case 9:
                iSizeOfCharsetArray = this.b.sizeOfSzArray();
                break;
            case 10:
                iSizeOfCharsetArray = this.b.sizeOfFamilyArray();
                break;
            case 11:
                iSizeOfCharsetArray = this.b.sizeOfRFontArray();
                break;
            case 12:
                iSizeOfCharsetArray = this.b.sizeOfShadowArray();
                break;
            case 13:
                iSizeOfCharsetArray = this.b.sizeOfExtendArray();
                break;
            default:
                iSizeOfCharsetArray = this.b.sizeOfVertAlignArray();
                break;
        }
        return Integer.valueOf(iSizeOfCharsetArray);
    }
}
