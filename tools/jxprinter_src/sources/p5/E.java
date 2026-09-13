package p5;

import java.util.function.Function;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class E implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7774a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ E(CTOMathImpl cTOMathImpl, int i5) {
        this.f7774a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f7774a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCustomXmlArray(iIntValue);
            case 1:
                return this.b.getFldSimpleArray(iIntValue);
            case 2:
                return this.b.insertNewFldSimple(iIntValue);
            case 3:
                return this.b.getPhantArray(iIntValue);
            case 4:
                return this.b.insertNewPhant(iIntValue);
            case 5:
                return this.b.getRadArray(iIntValue);
            case 6:
                return this.b.getMArray(iIntValue);
            case 7:
                return this.b.insertNewM(iIntValue);
            case 8:
                return this.b.getMoveToArray(iIntValue);
            case 9:
                return this.b.insertNewMoveTo(iIntValue);
            case 10:
                return this.b.getCommentRangeEndArray(iIntValue);
            case 11:
                return this.b.insertNewCommentRangeEnd(iIntValue);
            case 12:
                return this.b.getCustomXmlInsRangeEndArray(iIntValue);
            case 13:
                return this.b.insertNewCustomXmlInsRangeEnd(iIntValue);
            case 14:
                return this.b.insertNewRad(iIntValue);
            case 15:
                return this.b.getOMathParaArray(iIntValue);
            case 16:
                return this.b.insertNewOMathPara(iIntValue);
            case 17:
                return this.b.getBoxArray(iIntValue);
            case 18:
                return this.b.insertNewBox(iIntValue);
            case 19:
                return this.b.getInsArray(iIntValue);
            case 20:
                return this.b.insertNewIns(iIntValue);
            case 21:
                return this.b.getProofErrArray(iIntValue);
            case 22:
                return this.b.insertNewProofErr(iIntValue);
            case 23:
                return this.b.getBookmarkStartArray(iIntValue);
            case 24:
                return this.b.insertNewBookmarkStart(iIntValue);
            case 25:
                return this.b.getBookmarkEndArray(iIntValue);
            case 26:
                return this.b.insertNewBookmarkEnd(iIntValue);
            case 27:
                return this.b.getHyperlinkArray(iIntValue);
            case 28:
                return this.b.getMoveFromRangeEndArray(iIntValue);
            default:
                return this.b.insertNewMoveFromRangeEnd(iIntValue);
        }
    }
}
