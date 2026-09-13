package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1541t implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7829a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1541t(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7829a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7829a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewFldSimple(iIntValue);
            case 1:
                return this.b.getSmartTagArray(iIntValue);
            case 2:
                return this.b.insertNewSmartTag(iIntValue);
            case 3:
                return this.b.getMoveToArray(iIntValue);
            case 4:
                return this.b.insertNewMoveTo(iIntValue);
            case 5:
                return this.b.getBorderBoxArray(iIntValue);
            case 6:
                return this.b.insertNewBorderBox(iIntValue);
            case 7:
                return this.b.getPermStartArray(iIntValue);
            case 8:
                return this.b.insertNewPermStart(iIntValue);
            case 9:
                return this.b.insertNewSSup(iIntValue);
            case 10:
                return this.b.getBoxArray(iIntValue);
            case 11:
                return this.b.insertNewBox(iIntValue);
            case 12:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 13:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 14:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 15:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 16:
                return this.b.getPhantArray(iIntValue);
            case 17:
                return this.b.insertNewPhant(iIntValue);
            case 18:
                return this.b.getMArray(iIntValue);
            case 19:
                return this.b.insertNewM(iIntValue);
            case 20:
                return this.b.getLimLowArray(iIntValue);
            case 21:
                return this.b.insertNewLimLow(iIntValue);
            case 22:
                return this.b.getPermEndArray(iIntValue);
            case 23:
                return this.b.getProofErrArray(iIntValue);
            case 24:
                return this.b.insertNewProofErr(iIntValue);
            case 25:
                return this.b.getRArray(iIntValue);
            case 26:
                return this.b.insertNewR(iIntValue);
            case 27:
                return this.b.getSSubArray(iIntValue);
            case 28:
                return this.b.insertNewSSub(iIntValue);
            default:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
        }
    }
}
