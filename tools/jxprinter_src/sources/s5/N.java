package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTDirContentRunImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class N implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8307a;
    public final /* synthetic */ CTDirContentRunImpl b;

    public /* synthetic */ N(CTDirContentRunImpl cTDirContentRunImpl, int i5) {
        this.f8307a = i5;
        this.b = cTDirContentRunImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8307a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getPermStartArray(iIntValue);
            case 1:
                return this.b.insertNewPermStart(iIntValue);
            case 2:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 3:
                return this.b.getSubDocArray(iIntValue);
            case 4:
                return this.b.insertNewSubDoc(iIntValue);
            case 5:
                return this.b.getRArray(iIntValue);
            case 6:
                return this.b.insertNewR(iIntValue);
            case 7:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 8:
                return this.b.getFldSimpleArray(iIntValue);
            case 9:
                return this.b.insertNewFldSimple(iIntValue);
            case 10:
                return this.b.getSdtArray(iIntValue);
            case 11:
                return this.b.insertNewSdt(iIntValue);
            case 12:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 13:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 14:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 15:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 16:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 17:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 20:
                return this.b.getInsArray(iIntValue);
            case 21:
                return this.b.getOMathParaArray(iIntValue);
            case 22:
                return this.b.insertNewOMathPara(iIntValue);
            case 23:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 24:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 25:
                return this.b.getDirArray(iIntValue);
            case 26:
                return this.b.insertNewDir(iIntValue);
            case 27:
                return this.b.getMoveToArray(iIntValue);
            case 28:
                return this.b.insertNewMoveTo(iIntValue);
            default:
                return this.b.insertNewIns(iIntValue);
        }
    }
}
