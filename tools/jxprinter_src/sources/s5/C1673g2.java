package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.g2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1673g2 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8410a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1673g2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8410a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8410a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getOMathArray(iIntValue);
            case 1:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 2:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 3:
                return this.b.getPermEndArray(iIntValue);
            case 4:
                return this.b.insertNewPermEnd(iIntValue);
            case 5:
                return this.b.getRArray(iIntValue);
            case 6:
                return this.b.getEqArrArray(iIntValue);
            case 7:
                return this.b.insertNewEqArr(iIntValue);
            case 8:
                return this.b.getMoveToRangeStartArray(iIntValue);
            case 9:
                return this.b.insertNewMoveToRangeStart(iIntValue);
            case 10:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 12:
                return this.b.getBookmarkStartArray(iIntValue);
            case 13:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 14:
                return this.b.insertNewR(iIntValue);
            case 15:
                return this.b.getOMathParaArray(iIntValue);
            case 16:
                return this.b.insertNewOMathPara(iIntValue);
            case 17:
                return this.b.getSmartTagArray(iIntValue);
            case 18:
                return this.b.insertNewSmartTag(iIntValue);
            case 19:
                return this.b.getCustomXmlArray(iIntValue);
            case 20:
                return this.b.insertNewCustomXml(iIntValue);
            case 21:
                return this.b.getCustomXmlMoveFromRangeStartArray(iIntValue);
            case 22:
                return this.b.insertNewCustomXmlMoveFromRangeStart(iIntValue);
            case 23:
                return this.b.getProofErrArray(iIntValue);
            case 24:
                return this.b.insertNewProofErr(iIntValue);
            case 25:
                return this.b.getSdtArray(iIntValue);
            case 26:
                return this.b.insertNewSdt(iIntValue);
            case 27:
                return this.b.getPhantArray(iIntValue);
            case 28:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            default:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
        }
    }
}
