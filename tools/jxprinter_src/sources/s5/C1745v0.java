package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTHyperlinkImpl;

/* JADX INFO: renamed from: s5.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1745v0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8486a;
    public final /* synthetic */ CTHyperlinkImpl b;

    public /* synthetic */ C1745v0(CTHyperlinkImpl cTHyperlinkImpl, int i5) {
        this.f8486a = i5;
        this.b = cTHyperlinkImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8486a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.getMoveFromArray(iIntValue);
            case 2:
                return this.b.insertNewMoveFrom(iIntValue);
            case 3:
                return this.b.getDelArray(iIntValue);
            case 4:
                return this.b.insertNewDel(iIntValue);
            case 5:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 6:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 7:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 8:
                return this.b.getHyperlinkArray(iIntValue);
            case 9:
                return this.b.insertNewHyperlink(iIntValue);
            case 10:
                return this.b.getInsArray(iIntValue);
            case 11:
                return this.b.insertNewIns(iIntValue);
            case 12:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 13:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 14:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 15:
                return this.b.getPermEndArray(iIntValue);
            case 16:
                return this.b.insertNewPermEnd(iIntValue);
            case 17:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 18:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 19:
                return this.b.getProofErrArray(iIntValue);
            case 20:
                return this.b.insertNewProofErr(iIntValue);
            case 21:
                return this.b.getSmartTagArray(iIntValue);
            case 22:
                return this.b.insertNewSmartTag(iIntValue);
            case 23:
                return this.b.getDirArray(iIntValue);
            case 24:
                return this.b.insertNewDir(iIntValue);
            case 25:
                return this.b.getSubDocArray(iIntValue);
            case 26:
                return this.b.insertNewSubDoc(iIntValue);
            case 27:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 28:
                return this.b.getOMathArray(iIntValue);
            default:
                return this.b.insertNewOMath(iIntValue);
        }
    }
}
