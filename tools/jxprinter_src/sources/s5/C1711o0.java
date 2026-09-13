package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFtnEdnImpl;

/* JADX INFO: renamed from: s5.o0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1711o0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8451a;
    public final /* synthetic */ CTFtnEdnImpl b;

    public /* synthetic */ C1711o0(CTFtnEdnImpl cTFtnEdnImpl, int i5) {
        this.f8451a = i5;
        this.b = cTFtnEdnImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8451a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveToArray(iIntValue);
            case 1:
                return this.b.insertNewMoveTo(iIntValue);
            case 2:
                return this.b.getPermEndArray(iIntValue);
            case 3:
                return this.b.insertNewPermEnd(iIntValue);
            case 4:
                return this.b.getDelArray(iIntValue);
            case 5:
                return this.b.insertNewDel(iIntValue);
            case 6:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 7:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 8:
                return this.b.getPermStartArray(iIntValue);
            case 9:
                return this.b.insertNewPermStart(iIntValue);
            case 10:
                return this.b.getInsArray(iIntValue);
            case 11:
                return this.b.insertNewIns(iIntValue);
            case 12:
                return this.b.getSdtArray(iIntValue);
            case 13:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 14:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 15:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 17:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 18:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 19:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 20:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 21:
                return this.b.insertNewSdt(iIntValue);
            case 22:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 23:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 24:
                return this.b.getBookmarkStartArray(iIntValue);
            case 25:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 26:
                return this.b.getPArray(iIntValue);
            case 27:
                return this.b.insertNewP(iIntValue);
            case 28:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
        }
    }
}
