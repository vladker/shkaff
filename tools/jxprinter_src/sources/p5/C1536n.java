package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1536n implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7821a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1536n(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7821a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7821a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 1:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 2:
                return this.b.getCustomXmlMoveToRangeEndArray(iIntValue);
            case 3:
                return this.b.insertNewCustomXmlMoveToRangeEnd(iIntValue);
            case 4:
                return this.b.getHyperlinkArray(iIntValue);
            case 5:
                return this.b.insertNewHyperlink(iIntValue);
            case 6:
                return this.b.insertNewCommentRangeStart(iIntValue);
            case 7:
                return this.b.getGroupChrArray(iIntValue);
            case 8:
                return this.b.insertNewGroupChr(iIntValue);
            case 9:
                return this.b.getMoveToRangeEndArray(iIntValue);
            case 10:
                return this.b.insertNewMoveToRangeEnd(iIntValue);
            case 11:
                return this.b.getCustomXmlDelRangeStartArray(iIntValue);
            case 12:
                return this.b.insertNewCustomXmlDelRangeStart(iIntValue);
            case 13:
                return this.b.getBarArray(iIntValue);
            case 14:
                return this.b.insertNewBar(iIntValue);
            case 15:
                return this.b.getCustomXmlMoveToRangeStartArray(iIntValue);
            case 16:
                return this.b.insertNewCustomXmlMoveToRangeStart(iIntValue);
            case 17:
                return this.b.getCustomXmlDelRangeEndArray(iIntValue);
            case 18:
                return this.b.insertNewCustomXmlDelRangeEnd(iIntValue);
            case 19:
                return this.b.getLimUppArray(iIntValue);
            case 20:
                return this.b.getSdtArray(iIntValue);
            case 21:
                return this.b.insertNewSdt(iIntValue);
            case 22:
                return this.b.getSPreArray(iIntValue);
            case 23:
                return this.b.insertNewSPre(iIntValue);
            case 24:
                return this.b.getInsArray(iIntValue);
            case 25:
                return this.b.insertNewIns(iIntValue);
            case 26:
                return this.b.getMoveFromArray(iIntValue);
            case 27:
                return this.b.insertNewMoveFrom(iIntValue);
            case 28:
                return this.b.insertNewLimUpp(iIntValue);
            default:
                return this.b.getFldSimpleArray(iIntValue);
        }
    }
}
