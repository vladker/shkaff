package s5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCnf;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJcTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTrPrBaseImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class a4 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8376a;
    public final /* synthetic */ CTTrPrBaseImpl b;

    public /* synthetic */ a4(CTTrPrBaseImpl cTTrPrBaseImpl, int i5) {
        this.f8376a = i5;
        this.b = cTTrPrBaseImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8376a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setCantSplitArray(iIntValue, (CTOnOff) obj2);
                break;
            case 1:
                this.b.setTrHeightArray(iIntValue, (CTHeight) obj2);
                break;
            case 2:
                this.b.setGridAfterArray(iIntValue, (CTDecimalNumber) obj2);
                break;
            case 3:
                this.b.setDivIdArray(iIntValue, (CTDecimalNumber) obj2);
                break;
            case 4:
                this.b.setCnfStyleArray(iIntValue, (CTCnf) obj2);
                break;
            case 5:
                this.b.setGridBeforeArray(iIntValue, (CTDecimalNumber) obj2);
                break;
            case 6:
                this.b.setWAfterArray(iIntValue, (CTTblWidth) obj2);
                break;
            case 7:
                this.b.setHiddenArray(iIntValue, (CTOnOff) obj2);
                break;
            case 8:
                this.b.setWBeforeArray(iIntValue, (CTTblWidth) obj2);
                break;
            case 9:
                this.b.setJcArray(iIntValue, (CTJcTable) obj2);
                break;
            case 10:
                this.b.setTblCellSpacingArray(iIntValue, (CTTblWidth) obj2);
                break;
            default:
                this.b.setTblHeaderArray(iIntValue, (CTOnOff) obj2);
                break;
        }
    }
}
