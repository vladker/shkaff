package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.u2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1742u2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8483a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1742u2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8483a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8483a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 1:
                return this.b.getDelArray(iIntValue);
            case 2:
                return this.b.insertNewDel(iIntValue);
            case 3:
                return this.b.getInsArray(iIntValue);
            case 4:
                return this.b.insertNewIns(iIntValue);
            case 5:
                return this.b.getBdoArray(iIntValue);
            case 6:
                return this.b.insertNewBdo(iIntValue);
            case 7:
                return this.b.getMoveFromArray(iIntValue);
            case 8:
                return this.b.insertNewMoveFrom(iIntValue);
            case 9:
                return this.b.getRadArray(iIntValue);
            case 10:
                return this.b.insertNewRad(iIntValue);
            case 11:
                return this.b.insertNewOMath(iIntValue);
            case 12:
                return this.b.getFArray(iIntValue);
            case 13:
                return this.b.insertNewF(iIntValue);
            case 14:
                return this.b.getSSupArray(iIntValue);
            case 15:
                return this.b.insertNewSSup(iIntValue);
            case 16:
                return this.b.getR2Array(iIntValue);
            case 17:
                return this.b.insertNewR2(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 20:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 21:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 22:
                return this.b.getSSubArray(iIntValue);
            case 23:
                return this.b.insertNewSSub(iIntValue);
            case 24:
                return this.b.getBookmarkEndArray(iIntValue);
            case 25:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 27:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 28:
                return this.b.insertNewCommentRangeStart(iIntValue);
            default:
                return this.b.getGroupChrArray(iIntValue);
        }
    }
}
