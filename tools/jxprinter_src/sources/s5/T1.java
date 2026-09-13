package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRPrOriginalImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class T1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8338a;
    public final /* synthetic */ CTRPrOriginalImpl b;

    public /* synthetic */ T1(CTRPrOriginalImpl cTRPrOriginalImpl, int i5) {
        this.f8338a = i5;
        this.b = cTRPrOriginalImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfOutlineArray;
        switch (this.f8338a) {
            case 0:
                iSizeOfOutlineArray = this.b.sizeOfOutlineArray();
                break;
            case 1:
                iSizeOfOutlineArray = this.b.sizeOfBCsArray();
                break;
            case 2:
                iSizeOfOutlineArray = this.b.sizeOfRFontsArray();
                break;
            case 3:
                iSizeOfOutlineArray = this.b.sizeOfRtlArray();
                break;
            case 4:
                iSizeOfOutlineArray = this.b.sizeOfShdArray();
                break;
            case 5:
                iSizeOfOutlineArray = this.b.sizeOfSnapToGridArray();
                break;
            case 6:
                iSizeOfOutlineArray = this.b.sizeOfEmArray();
                break;
            case 7:
                iSizeOfOutlineArray = this.b.sizeOfColorArray();
                break;
            default:
                iSizeOfOutlineArray = this.b.sizeOfStrikeArray();
                break;
        }
        return Integer.valueOf(iSizeOfOutlineArray);
    }
}
