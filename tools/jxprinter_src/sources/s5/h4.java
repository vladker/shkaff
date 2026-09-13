package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTxbxContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class h4 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8418a;
    public final /* synthetic */ CTTxbxContentImpl b;

    public /* synthetic */ h4(CTTxbxContentImpl cTTxbxContentImpl, int i5) {
        this.f8418a = i5;
        this.b = cTTxbxContentImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8418a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getBookmarkStartArray(iIntValue);
            case 1:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 2:
                return this.b.getPArray(iIntValue);
            case 3:
                return this.b.insertNewP(iIntValue);
            case 4:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 5:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 6:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 7:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 8:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 10:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 11:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 12:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 13:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 14:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 15:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 17:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 18:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 19:
                return this.b.getAltChunkArray(iIntValue);
            case 20:
                return this.b.insertNewAltChunk(iIntValue);
            case 21:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 22:
                return this.b.getCustomXmlArray(iIntValue);
            case 23:
                return this.b.insertNewCustomXml(iIntValue);
            case 24:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 25:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 26:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 27:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 28:
                return this.b.getPermEndArray(iIntValue);
            default:
                return this.b.insertNewPermEnd(iIntValue);
        }
    }
}
