package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1527e implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7803a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1527e(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7803a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7803a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSSupArray(iIntValue);
            case 1:
                return this.b.getCustomXmlMoveFromRangeEndArray(iIntValue);
            case 2:
                return this.b.insertNewCustomXmlMoveFromRangeEnd(iIntValue);
            case 3:
                return this.b.getDArray(iIntValue);
            case 4:
                return this.b.insertNewD(iIntValue);
            case 5:
                return this.b.getFArray(iIntValue);
            case 6:
                return this.b.getOMathParaArray(iIntValue);
            case 7:
                return this.b.insertNewOMathPara(iIntValue);
            case 8:
                return this.b.getBookmarkStartArray(iIntValue);
            case 9:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 10:
                return this.b.getFuncArray(iIntValue);
            case 11:
                return this.b.insertNewFunc(iIntValue);
            case 12:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 13:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 14:
                return this.b.insertNewF(iIntValue);
            case 15:
                return this.b.getRadArray(iIntValue);
            case 16:
                return this.b.insertNewRad(iIntValue);
            case 17:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 18:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 19:
                return this.b.getNaryArray(iIntValue);
            case 20:
                return this.b.insertNewNary(iIntValue);
            case 21:
                return this.b.getDelArray(iIntValue);
            case 22:
                return this.b.insertNewDel(iIntValue);
            case 23:
                return this.b.getBookmarkEndArray(iIntValue);
            case 24:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 25:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 26:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 27:
                return this.b.getCommentRangeStartArray(iIntValue);
            case 28:
                return this.b.getAccArray(iIntValue);
            default:
                return this.b.insertNewAcc(iIntValue);
        }
    }
}
