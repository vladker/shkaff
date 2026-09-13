package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRubyContentImpl;

/* JADX INFO: renamed from: s5.b2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1648b2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8380a;
    public final /* synthetic */ CTRubyContentImpl b;

    public /* synthetic */ C1648b2(CTRubyContentImpl cTRubyContentImpl, int i5) {
        this.f8380a = i5;
        this.b = cTRubyContentImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8380a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getProofErrArray(iIntValue);
            case 1:
                return this.b.getMoveToArray(iIntValue);
            case 2:
                return this.b.insertNewMoveTo(iIntValue);
            case 3:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 5:
                return this.b.getPermEndArray(iIntValue);
            case 6:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 7:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 8:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 9:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 10:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 12:
                return this.b.getMoveFromArray(iIntValue);
            case 13:
                return this.b.insertNewMoveFrom(iIntValue);
            case 14:
                return this.b.insertNewPermEnd(iIntValue);
            case 15:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 16:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 17:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 18:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 19:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 20:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 21:
                return this.b.insertNewProofErr(iIntValue);
            case 22:
                return this.b.getBookmarkStartArray(iIntValue);
            case 23:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 24:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 25:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 26:
                return this.b.getRArray(iIntValue);
            case 27:
                return this.b.insertNewR(iIntValue);
            case 28:
                return this.b.getOMathParaArray(iIntValue);
            default:
                return this.b.insertNewOMathPara(iIntValue);
        }
    }
}
