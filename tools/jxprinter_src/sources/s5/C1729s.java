package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCommentImpl;

/* JADX INFO: renamed from: s5.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1729s implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8470a;
    public final /* synthetic */ CTCommentImpl b;

    public /* synthetic */ C1729s(CTCommentImpl cTCommentImpl, int i5) {
        this.f8470a = i5;
        this.b = cTCommentImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8470a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getAltChunkArray(iIntValue);
            case 1:
                return this.b.getBookmarkStartArray(iIntValue);
            case 2:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 3:
                return this.b.getMoveFromArray(iIntValue);
            case 4:
                return this.b.insertNewMoveFrom(iIntValue);
            case 5:
                return this.b.getBookmarkEndArray(iIntValue);
            case 6:
                return this.b.getProofErrArray(iIntValue);
            case 7:
                return this.b.insertNewProofErr(iIntValue);
            case 8:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 9:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 10:
                return this.b.getOMathArray(iIntValue);
            case 11:
                return this.b.insertNewOMath(iIntValue);
            case 12:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 13:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 14:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 15:
                return this.b.getInsArray(iIntValue);
            case 16:
                return this.b.insertNewIns(iIntValue);
            case 17:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 18:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 19:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 20:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 21:
                return this.b.getOMathParaArray(iIntValue);
            case 22:
                return this.b.insertNewOMathPara(iIntValue);
            case 23:
                return this.b.getSdtArray(iIntValue);
            case 24:
                return this.b.insertNewSdt(iIntValue);
            case 25:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 27:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 28:
                return this.b.insertNewCommentRangeStart(iIntValue);
            default:
                return this.b.insertNewAltChunk(iIntValue);
        }
    }
}
