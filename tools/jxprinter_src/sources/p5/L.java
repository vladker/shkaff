package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class L implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7781a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ L(CTOMathImpl cTOMathImpl, int i5) {
        this.f7781a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7781a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 1:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 2:
                return this.b.getNaryArray(iIntValue);
            case 3:
                return this.b.insertNewNary(iIntValue);
            case 4:
                return this.b.getSdtArray(iIntValue);
            case 5:
                return this.b.insertNewSdt(iIntValue);
            case 6:
                return this.b.insertNewHyperlink(iIntValue);
            case 7:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 8:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 9:
                return this.b.getBarArray(iIntValue);
            case 10:
                return this.b.insertNewBar(iIntValue);
            case 11:
                return this.b.getLimLowArray(iIntValue);
            case 12:
                return this.b.insertNewLimLow(iIntValue);
            case 13:
                return this.b.getFArray(iIntValue);
            case 14:
                return this.b.insertNewF(iIntValue);
            case 15:
                return this.b.getSSubSupArray(iIntValue);
            case 16:
                return this.b.insertNewSSubSup(iIntValue);
            case 17:
                return this.b.getRArray(iIntValue);
            case 18:
                return this.b.insertNewR(iIntValue);
            case 19:
                return this.b.getMoveFromArray(iIntValue);
            case 20:
                return this.b.getSmartTagArray(iIntValue);
            case 21:
                return this.b.insertNewSmartTag(iIntValue);
            case 22:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 23:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 24:
                return this.b.getPermStartArray(iIntValue);
            case 25:
                return this.b.insertNewPermStart(iIntValue);
            case 26:
                return this.b.getOMathArray(iIntValue);
            case 27:
                return this.b.insertNewOMath(iIntValue);
            case 28:
                return this.b.insertNewMoveFrom(iIntValue);
            default:
                return this.b.getSPreArray(iIntValue);
        }
    }
}
