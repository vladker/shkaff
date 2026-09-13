package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentBlockImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class L2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8300a;
    public final /* synthetic */ CTSdtContentBlockImpl b;

    public /* synthetic */ L2(CTSdtContentBlockImpl cTSdtContentBlockImpl, int i5) {
        this.f8300a = i5;
        this.b = cTSdtContentBlockImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8300a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 2:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 4:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 5:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 6:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 7:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 8:
                return this.b.getBookmarkEndArray(iIntValue);
            case 9:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 10:
                return this.b.getPermEndArray(iIntValue);
            case 11:
                return this.b.getCustomXmlArray(iIntValue);
            case 12:
                return this.b.insertNewCustomXml(iIntValue);
            case 13:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 14:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 15:
                return this.b.getInsArray(iIntValue);
            case 16:
                return this.b.insertNewIns(iIntValue);
            case 17:
                return this.b.getMoveToArray(iIntValue);
            case 18:
                return this.b.insertNewMoveTo(iIntValue);
            case 19:
                return this.b.insertNewPermEnd(iIntValue);
            case 20:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 21:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 22:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 23:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 24:
                return this.b.getSdtArray(iIntValue);
            case 25:
                return this.b.insertNewSdt(iIntValue);
            case 26:
                return this.b.getOMathParaArray(iIntValue);
            default:
                return this.b.insertNewOMathPara(iIntValue);
        }
    }
}
