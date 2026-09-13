package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.l2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1698l2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8438a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1698l2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8438a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8438a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getBoxArray(iIntValue);
            case 1:
                return this.b.insertNewBox(iIntValue);
            case 2:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 4:
                return this.b.getSSubSupArray(iIntValue);
            case 5:
                return this.b.insertNewSSubSup(iIntValue);
            case 6:
                return this.b.insertNewPhant(iIntValue);
            case 7:
                return this.b.getPermStartArray(iIntValue);
            case 8:
                return this.b.insertNewPermStart(iIntValue);
            case 9:
                return this.b.getSPreArray(iIntValue);
            case 10:
                return this.b.insertNewSPre(iIntValue);
            case 11:
                return this.b.getNaryArray(iIntValue);
            case 12:
                return this.b.insertNewNary(iIntValue);
            case 13:
                return this.b.getDArray(iIntValue);
            case 14:
                return this.b.insertNewD(iIntValue);
            case 15:
                return this.b.getBarArray(iIntValue);
            case 16:
                return this.b.insertNewBar(iIntValue);
            case 17:
                return this.b.getMArray(iIntValue);
            case 18:
                return this.b.insertNewM(iIntValue);
            case 19:
                return this.b.getFuncArray(iIntValue);
            case 20:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 21:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 22:
                return this.b.getMoveToArray(iIntValue);
            case 23:
                return this.b.insertNewMoveTo(iIntValue);
            case 24:
                return this.b.getDirArray(iIntValue);
            case 25:
                return this.b.insertNewDir(iIntValue);
            case 26:
                return this.b.getAccArray(iIntValue);
            case 27:
                return this.b.insertNewAcc(iIntValue);
            case 28:
                return this.b.insertNewFunc(iIntValue);
            default:
                return this.b.getMoveFromRangeEndArray(iIntValue);
        }
    }
}
