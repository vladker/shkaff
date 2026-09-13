package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTcImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class Y3 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8365a;
    public final /* synthetic */ CTTcImpl b;

    public /* synthetic */ Y3(CTTcImpl cTTcImpl, int i5) {
        this.f8365a = i5;
        this.b = cTTcImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8365a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getPermStartArray(iIntValue);
            case 1:
                return this.b.insertNewPermStart(iIntValue);
            case 2:
                return this.b.getDelArray(iIntValue);
            case 3:
                return this.b.insertNewDel(iIntValue);
            case 4:
                return this.b.getPermEndArray(iIntValue);
            case 5:
                return this.b.insertNewPermEnd(iIntValue);
            case 6:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 7:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 8:
                return this.b.getBookmarkEndArray(iIntValue);
            case 9:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 10:
                return this.b.getOMathParaArray(iIntValue);
            case 11:
                return this.b.insertNewOMathPara(iIntValue);
            case 12:
                return this.b.getMoveFromArray(iIntValue);
            case 13:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 14:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 15:
                return this.b.getBookmarkStartArray(iIntValue);
            case 16:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 17:
                return this.b.getInsArray(iIntValue);
            case 18:
                return this.b.insertNewIns(iIntValue);
            case 19:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 20:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 21:
                return this.b.insertNewMoveFrom(iIntValue);
            case 22:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 23:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 24:
                return this.b.getPArray(iIntValue);
            case 25:
                return this.b.insertNewP(iIntValue);
            case 26:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 27:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 28:
                return this.b.getSdtArray(iIntValue);
            default:
                return this.b.insertNewSdt(iIntValue);
        }
    }
}
