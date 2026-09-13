package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTrPrBaseImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Z3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8370a;
    public final /* synthetic */ CTTrPrBaseImpl b;

    public /* synthetic */ Z3(CTTrPrBaseImpl cTTrPrBaseImpl, int i5) {
        this.f8370a = i5;
        this.b = cTTrPrBaseImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8370a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getGridAfterArray(iIntValue);
            case 1:
                return this.b.getCantSplitArray(iIntValue);
            case 2:
                return this.b.insertNewCantSplit(iIntValue);
            case 3:
                return this.b.getTrHeightArray(iIntValue);
            case 4:
                return this.b.insertNewTrHeight(iIntValue);
            case 5:
                return this.b.getDivIdArray(iIntValue);
            case 6:
                return this.b.insertNewDivId(iIntValue);
            case 7:
                return this.b.getCnfStyleArray(iIntValue);
            case 8:
                return this.b.insertNewCnfStyle(iIntValue);
            case 9:
                return this.b.insertNewGridAfter(iIntValue);
            case 10:
                return this.b.getGridBeforeArray(iIntValue);
            case 11:
                return this.b.insertNewGridBefore(iIntValue);
            case 12:
                return this.b.getWAfterArray(iIntValue);
            case 13:
                return this.b.insertNewWAfter(iIntValue);
            case 14:
                return this.b.getHiddenArray(iIntValue);
            case 15:
                return this.b.insertNewHidden(iIntValue);
            case 16:
                return this.b.getWBeforeArray(iIntValue);
            case 17:
                return this.b.insertNewWBefore(iIntValue);
            case 18:
                return this.b.getJcArray(iIntValue);
            case 19:
                return this.b.insertNewJc(iIntValue);
            case 20:
                return this.b.getTblCellSpacingArray(iIntValue);
            case 21:
                return this.b.insertNewTblCellSpacing(iIntValue);
            case 22:
                return this.b.getTblHeaderArray(iIntValue);
            default:
                return this.b.insertNewTblHeader(iIntValue);
        }
    }
}
