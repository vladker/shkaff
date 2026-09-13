package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class P0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8318a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ P0(CTPImpl cTPImpl, int i5) {
        this.f8318a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8318a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 2:
                return this.b.insertNewFldSimple(iIntValue);
            case 3:
                return this.b.getInsArray(iIntValue);
            case 4:
                return this.b.insertNewIns(iIntValue);
            case 5:
                return this.b.getHyperlinkArray(iIntValue);
            case 6:
                return this.b.insertNewHyperlink(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 8:
                return this.b.getSubDocArray(iIntValue);
            case 9:
                return this.b.insertNewSubDoc(iIntValue);
            case 10:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 11:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 12:
                return this.b.getCustomXmlArray(iIntValue);
            case 13:
                return this.b.insertNewCustomXml(iIntValue);
            case 14:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 15:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 16:
                return this.b.getOMathParaArray(iIntValue);
            case 17:
                return this.b.insertNewOMathPara(iIntValue);
            case 18:
                return this.b.getPermEndArray(iIntValue);
            case 19:
                return this.b.insertNewPermEnd(iIntValue);
            case 20:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 21:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 22:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 23:
                return this.b.getBookmarkStartArray(iIntValue);
            case 24:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 25:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 27:
                return this.b.getPermStartArray(iIntValue);
            case 28:
                return this.b.insertNewPermStart(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
        }
    }
}
