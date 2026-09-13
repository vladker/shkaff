package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class A implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8242a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ A(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8242a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8242a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getProofErrArray(iIntValue);
            case 1:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 2:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 3:
                return this.b.getPermEndArray(iIntValue);
            case 4:
                return this.b.insertNewPermEnd(iIntValue);
            case 5:
                return this.b.getBookmarkEndArray(iIntValue);
            case 6:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 8:
                return this.b.getRArray(iIntValue);
            case 9:
                return this.b.insertNewR(iIntValue);
            case 10:
                return this.b.getSdtArray(iIntValue);
            case 11:
                return this.b.insertNewSdt(iIntValue);
            case 12:
                return this.b.getDelArray(iIntValue);
            case 13:
                return this.b.insertNewDel(iIntValue);
            case 14:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 15:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 17:
                return this.b.getCustomXmlArray(iIntValue);
            case 18:
                return this.b.insertNewCustomXml(iIntValue);
            case 19:
                return this.b.getFldSimpleArray(iIntValue);
            case 20:
                return this.b.insertNewFldSimple(iIntValue);
            case 21:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 23:
                return this.b.getBdoArray(iIntValue);
            case 24:
                return this.b.insertNewBdo(iIntValue);
            case 25:
                return this.b.getMoveFromArray(iIntValue);
            case 26:
                return this.b.insertNewMoveFrom(iIntValue);
            case 27:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 28:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
        }
    }
}
