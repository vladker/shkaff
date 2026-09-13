package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTrPrBaseImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class c4 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8388a;
    public final /* synthetic */ CTTrPrBaseImpl b;

    public /* synthetic */ c4(CTTrPrBaseImpl cTTrPrBaseImpl, int i5) {
        this.f8388a = i5;
        this.b = cTTrPrBaseImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCantSplitArray;
        switch (this.f8388a) {
            case 0:
                iSizeOfCantSplitArray = this.b.sizeOfCantSplitArray();
                break;
            case 1:
                iSizeOfCantSplitArray = this.b.sizeOfTrHeightArray();
                break;
            case 2:
                iSizeOfCantSplitArray = this.b.sizeOfDivIdArray();
                break;
            case 3:
                iSizeOfCantSplitArray = this.b.sizeOfCnfStyleArray();
                break;
            case 4:
                iSizeOfCantSplitArray = this.b.sizeOfGridBeforeArray();
                break;
            case 5:
                iSizeOfCantSplitArray = this.b.sizeOfWAfterArray();
                break;
            case 6:
                iSizeOfCantSplitArray = this.b.sizeOfHiddenArray();
                break;
            case 7:
                iSizeOfCantSplitArray = this.b.sizeOfWBeforeArray();
                break;
            case 8:
                iSizeOfCantSplitArray = this.b.sizeOfGridAfterArray();
                break;
            case 9:
                iSizeOfCantSplitArray = this.b.sizeOfJcArray();
                break;
            case 10:
                iSizeOfCantSplitArray = this.b.sizeOfTblCellSpacingArray();
                break;
            default:
                iSizeOfCantSplitArray = this.b.sizeOfTblHeaderArray();
                break;
        }
        return Integer.valueOf(iSizeOfCantSplitArray);
    }
}
