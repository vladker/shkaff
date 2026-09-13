package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class T2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8339a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ T2(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8339a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8339a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 1:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 2:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getInsArray(iIntValue);
            case 4:
                return this.b.insertNewIns(iIntValue);
            case 5:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 6:
                return this.b.getOMathParaArray(iIntValue);
            case 7:
                return this.b.insertNewOMathPara(iIntValue);
            case 8:
                return this.b.getSdtArray(iIntValue);
            case 9:
                return this.b.insertNewSdt(iIntValue);
            case 10:
                return this.b.getBookmarkStartArray(iIntValue);
            case 11:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 12:
                return this.b.getDelArray(iIntValue);
            case 13:
                return this.b.insertNewDel(iIntValue);
            case 14:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 15:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 17:
                return this.b.getOMathArray(iIntValue);
            case 18:
                return this.b.insertNewOMath(iIntValue);
            case 19:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 20:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 21:
                return this.b.getProofErrArray(iIntValue);
            case 22:
                return this.b.insertNewProofErr(iIntValue);
            case 23:
                return this.b.getRArray(iIntValue);
            case 24:
                return this.b.insertNewR(iIntValue);
            case 25:
                return this.b.getHyperlinkArray(iIntValue);
            case 26:
                return this.b.insertNewHyperlink(iIntValue);
            case 27:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 28:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
        }
    }
}
