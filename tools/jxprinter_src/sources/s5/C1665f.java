package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1665f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8401a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1665f(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8401a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8401a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 2:
                return this.b.insertNewBdo(iIntValue);
            case 3:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 5:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 6:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 7:
                return this.b.insertNewPermStart(iIntValue);
            case 8:
                return this.b.getBookmarkEndArray(iIntValue);
            case 9:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 10:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 11:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 12:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 13:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 14:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 15:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 16:
                return this.b.getPermEndArray(iIntValue);
            case 17:
                return this.b.insertNewPermEnd(iIntValue);
            case 18:
                return this.b.getSdtArray(iIntValue);
            case 19:
                return this.b.insertNewSdt(iIntValue);
            case 20:
                return this.b.getOMathArray(iIntValue);
            case 21:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 23:
                return this.b.getDelArray(iIntValue);
            case 24:
                return this.b.insertNewDel(iIntValue);
            case 25:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 27:
                return this.b.getSmartTagArray(iIntValue);
            case 28:
                return this.b.insertNewSmartTag(iIntValue);
            default:
                return this.b.insertNewOMath(iIntValue);
        }
    }
}
