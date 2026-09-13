package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class E implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8262a;
    public final /* synthetic */ CTCustomXmlRunImpl b;

    public /* synthetic */ E(CTCustomXmlRunImpl cTCustomXmlRunImpl, int i5) {
        this.f8262a = i5;
        this.b = cTCustomXmlRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8262a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 2:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 5:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 6:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 7:
                return this.b.insertNewProofErr(iIntValue);
            case 8:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 10:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 12:
                return this.b.getHyperlinkArray(iIntValue);
            case 13:
                return this.b.insertNewHyperlink(iIntValue);
            case 14:
                return this.b.getPermStartArray(iIntValue);
            case 15:
                return this.b.insertNewPermStart(iIntValue);
            case 16:
                return this.b.getSmartTagArray(iIntValue);
            case 17:
                return this.b.insertNewSmartTag(iIntValue);
            case 18:
                return this.b.getDirArray(iIntValue);
            case 19:
                return this.b.insertNewDir(iIntValue);
            case 20:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 21:
                return this.b.getMoveToArray(iIntValue);
            case 22:
                return this.b.insertNewMoveTo(iIntValue);
            case 23:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 24:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 25:
                return this.b.getBookmarkStartArray(iIntValue);
            case 26:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 27:
                return this.b.getInsArray(iIntValue);
            case 28:
                return this.b.insertNewIns(iIntValue);
            default:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
        }
    }
}
