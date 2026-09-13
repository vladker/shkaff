package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1529g implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7807a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1529g(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7807a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7807a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCustomXmlMoveFromRangeEnd(iIntValue);
                break;
            case 1:
                this.b.removeD(iIntValue);
                break;
            case 2:
                this.b.removeOMathPara(iIntValue);
                break;
            case 3:
                this.b.removeBookmarkStart(iIntValue);
                break;
            case 4:
                this.b.removeFunc(iIntValue);
                break;
            case 5:
                this.b.removeMoveFromRangeStart(iIntValue);
                break;
            case 6:
                this.b.removeRad(iIntValue);
                break;
            case 7:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            case 8:
                this.b.removeF(iIntValue);
                break;
            case 9:
                this.b.removeNary(iIntValue);
                break;
            case 10:
                this.b.removeDel(iIntValue);
                break;
            case 11:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 12:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
            case 13:
                this.b.removeAcc(iIntValue);
                break;
            case 14:
                this.b.removeCustomXmlInsRangeEnd(iIntValue);
                break;
            case 15:
                this.b.removeCustomXmlMoveToRangeEnd(iIntValue);
                break;
            case 16:
                this.b.removeHyperlink(iIntValue);
                break;
            case 17:
                this.b.removeGroupChr(iIntValue);
                break;
            case 18:
                this.b.removeMoveToRangeEnd(iIntValue);
                break;
            case 19:
                this.b.removeCommentRangeStart(iIntValue);
                break;
            case 20:
                this.b.removeCustomXmlDelRangeStart(iIntValue);
                break;
            case 21:
                this.b.removeBar(iIntValue);
                break;
            case 22:
                this.b.removeCustomXmlMoveToRangeStart(iIntValue);
                break;
            case 23:
                this.b.removeCustomXmlDelRangeEnd(iIntValue);
                break;
            case 24:
                this.b.removeSdt(iIntValue);
                break;
            case 25:
                this.b.removeSPre(iIntValue);
                break;
            case 26:
                this.b.removeIns(iIntValue);
                break;
            case 27:
                this.b.removeMoveFrom(iIntValue);
                break;
            case 28:
                this.b.removeFldSimple(iIntValue);
                break;
            default:
                this.b.removeSmartTag(iIntValue);
                break;
        }
    }
}
