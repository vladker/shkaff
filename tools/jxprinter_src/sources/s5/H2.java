package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentBlockImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class H2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8280a;
    public final /* synthetic */ CTSdtContentBlockImpl b;

    public /* synthetic */ H2(CTSdtContentBlockImpl cTSdtContentBlockImpl, int i5) {
        this.f8280a = i5;
        this.b = cTSdtContentBlockImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8280a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.getDelArray(iIntValue);
            case 2:
                return this.b.insertNewDel(iIntValue);
            case 3:
                return this.b.getTblArray(iIntValue);
            case 4:
                return this.b.insertNewTbl(iIntValue);
            case 5:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 6:
                return this.b.getPermStartArray(iIntValue);
            case 7:
                return this.b.insertNewPermStart(iIntValue);
            case 8:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 9:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 10:
                return this.b.getProofErrArray(iIntValue);
            case 11:
                return this.b.insertNewProofErr(iIntValue);
            case 12:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 13:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 14:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 15:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 17:
                return this.b.getOMathArray(iIntValue);
            case 18:
                return this.b.insertNewOMath(iIntValue);
            case 19:
                return this.b.getBookmarkStartArray(iIntValue);
            case 20:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 21:
                return this.b.getPArray(iIntValue);
            case 22:
                return this.b.insertNewP(iIntValue);
            case 23:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 25:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 27:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 28:
                return this.b.getMoveFromArray(iIntValue);
            default:
                return this.b.insertNewMoveFrom(iIntValue);
        }
    }
}
