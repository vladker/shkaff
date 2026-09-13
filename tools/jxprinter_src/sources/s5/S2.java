package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentCellImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class S2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8334a;
    public final /* synthetic */ CTSdtContentCellImpl b;

    public /* synthetic */ S2(CTSdtContentCellImpl cTSdtContentCellImpl, int i5) {
        this.f8334a = i5;
        this.b = cTSdtContentCellImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8334a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 2:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 4:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 5:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 6:
                return this.b.getPermEndArray(iIntValue);
            case 7:
                return this.b.insertNewPermEnd(iIntValue);
            case 8:
                return this.b.getMoveFromRangeStartArray(iIntValue);
            case 9:
                return this.b.getTcArray(iIntValue);
            case 10:
                return this.b.insertNewTc(iIntValue);
            case 11:
                return this.b.getBookmarkStartArray(iIntValue);
            case 12:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 13:
                return this.b.getCustomXmlInsRangeStartArray(iIntValue);
            case 14:
                return this.b.insertNewCustomXmlInsRangeStart(iIntValue);
            case 15:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            case 16:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
            case 17:
                return this.b.insertNewMoveFromRangeStart(iIntValue);
            case 18:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 19:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 20:
                return this.b.getInsArray(iIntValue);
            case 21:
                return this.b.insertNewIns(iIntValue);
            case 22:
                return this.b.getOMathParaArray(iIntValue);
            case 23:
                return this.b.insertNewOMathPara(iIntValue);
            case 24:
                return this.b.getPermStartArray(iIntValue);
            default:
                return this.b.insertNewPermStart(iIntValue);
        }
    }
}
