package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class T implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7788a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ T(CTOMathImpl cTOMathImpl, int i5) {
        this.f7788a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7788a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewSPre(iIntValue);
            case 1:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 2:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 3:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 4:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 5:
                return this.b.getLimUppArray(iIntValue);
            case 6:
                return this.b.insertNewLimUpp(iIntValue);
            case 7:
                return this.b.getSSupArray(iIntValue);
            case 8:
                return this.b.insertNewSSup(iIntValue);
            case 9:
                return this.b.insertNewCustomXml(iIntValue);
            case 10:
                return this.b.getBorderBoxArray(iIntValue);
            case 11:
                return this.b.insertNewBorderBox(iIntValue);
            case 12:
                return this.b.getAccArray(iIntValue);
            case 13:
                return this.b.insertNewAcc(iIntValue);
            case 14:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 15:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 16:
                return this.b.getEqArrArray(iIntValue);
            case 17:
                return this.b.insertNewEqArr(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 20:
                return this.b.getDelArray(iIntValue);
            case 21:
                return this.b.insertNewDel(iIntValue);
            case 22:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 23:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 25:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 26:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 27:
                return this.b.getGroupChrArray(iIntValue);
            case 28:
                return this.b.insertNewGroupChr(iIntValue);
            default:
                return this.b.getDArray(iIntValue);
        }
    }
}
