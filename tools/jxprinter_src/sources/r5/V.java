package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class V implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8018a;
    public final /* synthetic */ CTFontImpl b;

    public /* synthetic */ V(CTFontImpl cTFontImpl, int i5) {
        this.f8018a = i5;
        this.b = cTFontImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfIArray;
        switch (this.f8018a) {
            case 0:
                iSizeOfIArray = this.b.sizeOfIArray();
                break;
            case 1:
                iSizeOfIArray = this.b.sizeOfSzArray();
                break;
            case 2:
                iSizeOfIArray = this.b.sizeOfCondenseArray();
                break;
            case 3:
                iSizeOfIArray = this.b.sizeOfNameArray();
                break;
            case 4:
                iSizeOfIArray = this.b.sizeOfBArray();
                break;
            case 5:
                iSizeOfIArray = this.b.sizeOfColorArray();
                break;
            case 6:
                iSizeOfIArray = this.b.sizeOfSchemeArray();
                break;
            case 7:
                iSizeOfIArray = this.b.sizeOfFamilyArray();
                break;
            case 8:
                iSizeOfIArray = this.b.sizeOfUArray();
                break;
            case 9:
                iSizeOfIArray = this.b.sizeOfStrikeArray();
                break;
            case 10:
                iSizeOfIArray = this.b.sizeOfVertAlignArray();
                break;
            case 11:
                iSizeOfIArray = this.b.sizeOfCharsetArray();
                break;
            case 12:
                iSizeOfIArray = this.b.sizeOfOutlineArray();
                break;
            case 13:
                iSizeOfIArray = this.b.sizeOfShadowArray();
                break;
            default:
                iSizeOfIArray = this.b.sizeOfExtendArray();
                break;
        }
        return Integer.valueOf(iSizeOfIArray);
    }
}
