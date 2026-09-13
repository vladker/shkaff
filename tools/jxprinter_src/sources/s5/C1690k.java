package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBodyImpl;

/* JADX INFO: renamed from: s5.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1690k implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8430a;
    public final /* synthetic */ CTBodyImpl b;

    public /* synthetic */ C1690k(CTBodyImpl cTBodyImpl, int i5) {
        this.f8430a = i5;
        this.b = cTBodyImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8430a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 2:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 3:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 5:
                return this.b.getSdtArray(iIntValue);
            case 6:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 8:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 10:
                return this.b.getOMathParaArray(iIntValue);
            case 11:
                return this.b.insertNewOMathPara(iIntValue);
            case 12:
                return this.b.getMoveFromArray(iIntValue);
            case 13:
                return this.b.insertNewMoveFrom(iIntValue);
            case 14:
                return this.b.insertNewSdt(iIntValue);
            case 15:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 17:
                return this.b.getProofErrArray(iIntValue);
            case 18:
                return this.b.insertNewProofErr(iIntValue);
            case 19:
                return this.b.getPArray(iIntValue);
            case 20:
                return this.b.insertNewP(iIntValue);
            case 21:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 23:
                return this.b.getDelArray(iIntValue);
            case 24:
                return this.b.insertNewDel(iIntValue);
            case 25:
                return this.b.getPermEndArray(iIntValue);
            case 26:
                return this.b.insertNewPermEnd(iIntValue);
            case 27:
                return this.b.getOMathArray(iIntValue);
            case 28:
                return this.b.insertNewOMath(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
        }
    }
}
