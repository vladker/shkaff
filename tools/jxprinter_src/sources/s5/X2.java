package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class X2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8359a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ X2(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8359a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8359a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 2:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getSmartTagArray(iIntValue);
            case 4:
                return this.b.insertNewSmartTag(iIntValue);
            case 5:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 6:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 7:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 8:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 10:
                return this.b.getSubDocArray(iIntValue);
            case 11:
                return this.b.insertNewSubDoc(iIntValue);
            case 12:
                return this.b.getCustomXmlArray(iIntValue);
            case 13:
                return this.b.insertNewCustomXml(iIntValue);
            case 14:
                return this.b.getMoveFromArray(iIntValue);
            case 15:
                return this.b.insertNewMoveFrom(iIntValue);
            case 16:
                return this.b.getMoveToArray(iIntValue);
            case 17:
                return this.b.insertNewMoveTo(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 20:
                return this.b.getBookmarkEndArray(iIntValue);
            case 21:
                return this.b.getPermEndArray(iIntValue);
            case 22:
                return this.b.insertNewPermEnd(iIntValue);
            case 23:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 25:
                return this.b.getDirArray(iIntValue);
            case 26:
                return this.b.insertNewDir(iIntValue);
            case 27:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 28:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            default:
                return this.b.insertNewBookmarkEnd(iIntValue);
        }
    }
}
