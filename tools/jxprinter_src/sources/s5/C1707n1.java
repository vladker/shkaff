package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTParaRPrOriginalImpl;

/* JADX INFO: renamed from: s5.n1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1707n1 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8447a;
    public final /* synthetic */ CTParaRPrOriginalImpl b;

    public /* synthetic */ C1707n1(CTParaRPrOriginalImpl cTParaRPrOriginalImpl, int i5) {
        this.f8447a = i5;
        this.b = cTParaRPrOriginalImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCapsArray;
        switch (this.f8447a) {
            case 0:
                iSizeOfCapsArray = this.b.sizeOfCapsArray();
                break;
            case 1:
                iSizeOfCapsArray = this.b.sizeOfRtlArray();
                break;
            case 2:
                iSizeOfCapsArray = this.b.sizeOfBCsArray();
                break;
            case 3:
                iSizeOfCapsArray = this.b.sizeOfPositionArray();
                break;
            case 4:
                iSizeOfCapsArray = this.b.sizeOfSpacingArray();
                break;
            case 5:
                iSizeOfCapsArray = this.b.sizeOfBArray();
                break;
            case 6:
                iSizeOfCapsArray = this.b.sizeOfColorArray();
                break;
            case 7:
                iSizeOfCapsArray = this.b.sizeOfEastAsianLayoutArray();
                break;
            default:
                iSizeOfCapsArray = this.b.sizeOfIArray();
                break;
        }
        return Integer.valueOf(iSizeOfCapsArray);
    }
}
