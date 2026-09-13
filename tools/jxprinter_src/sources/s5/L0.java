package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class L0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8298a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ L0(CTPImpl cTPImpl, int i5) {
        this.f8298a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8298a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.getBookmarkEndArray(iIntValue);
            case 2:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 3:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 5:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 6:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 8:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 10:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 12:
                return this.b.getSdtArray(iIntValue);
            case 13:
                return this.b.insertNewSdt(iIntValue);
            case 14:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 15:
                return this.b.getBdoArray(iIntValue);
            case 16:
                return this.b.insertNewBdo(iIntValue);
            case 17:
                return this.b.getDirArray(iIntValue);
            case 18:
                return this.b.insertNewDir(iIntValue);
            case 19:
                return this.b.getMoveFromArray(iIntValue);
            case 20:
                return this.b.insertNewMoveFrom(iIntValue);
            case 21:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 23:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 25:
                return this.b.getSmartTagArray(iIntValue);
            case 26:
                return this.b.insertNewSmartTag(iIntValue);
            case 27:
                return this.b.getFldSimpleArray(iIntValue);
            case 28:
                return this.b.getMoveToArray(iIntValue);
            default:
                return this.b.insertNewMoveTo(iIntValue);
        }
    }
}
