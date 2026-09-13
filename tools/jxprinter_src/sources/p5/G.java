package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class G implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7776a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ G(CTOMathImpl cTOMathImpl, int i5) {
        this.f7776a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7776a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeFldSimple(iIntValue);
                break;
            case 1:
                this.b.removePhant(iIntValue);
                break;
            case 2:
                this.b.removeM(iIntValue);
                break;
            case 3:
                this.b.removeMoveTo(iIntValue);
                break;
            case 4:
                this.b.removeCommentRangeEnd(iIntValue);
                break;
            case 5:
                this.b.removeCustomXmlInsRangeEnd(iIntValue);
                break;
            case 6:
                this.b.removeOMathPara(iIntValue);
                break;
            case 7:
                this.b.removeBox(iIntValue);
                break;
            case 8:
                this.b.removeRad(iIntValue);
                break;
            case 9:
                this.b.removeIns(iIntValue);
                break;
            case 10:
                this.b.removeProofErr(iIntValue);
                break;
            case 11:
                this.b.removeBookmarkStart(iIntValue);
                break;
            case 12:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 13:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            case 14:
                this.b.removeMoveFromRangeStart(iIntValue);
                break;
            case 15:
                this.b.removeNary(iIntValue);
                break;
            case 16:
                this.b.removeSdt(iIntValue);
                break;
            case 17:
                this.b.removeCommentRangeStart(iIntValue);
                break;
            case 18:
                this.b.removeBar(iIntValue);
                break;
            case 19:
                this.b.removeHyperlink(iIntValue);
                break;
            case 20:
                this.b.removeLimLow(iIntValue);
                break;
            case 21:
                this.b.removeF(iIntValue);
                break;
            case 22:
                this.b.removeSSubSup(iIntValue);
                break;
            case 23:
                this.b.removeR(iIntValue);
                break;
            case 24:
                this.b.removeSmartTag(iIntValue);
                break;
            case 25:
                this.b.removeCustomXmlMoveFromRangeStart(iIntValue);
                break;
            case 26:
                this.b.removePermStart(iIntValue);
                break;
            case 27:
                this.b.removeOMath(iIntValue);
                break;
            case 28:
                this.b.removeSPre(iIntValue);
                break;
            default:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
        }
    }
}
