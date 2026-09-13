package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class N0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8308a;
    public final /* synthetic */ CTPImpl b;

    public /* synthetic */ N0(CTPImpl cTPImpl, int i5) {
        this.f8308a = i5;
        this.b = cTPImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8308a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 1:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
            case 2:
                this.b.removeCustomXmlInsRangeStart(iIntValue);
                break;
            case 3:
                this.b.removeCustomXmlDelRangeStart(iIntValue);
                break;
            case 4:
                this.b.removeCustomXmlMoveToRangeEnd(iIntValue);
                break;
            case 5:
                this.b.removeSdt(iIntValue);
                break;
            case 6:
                this.b.removeBdo(iIntValue);
                break;
            case 7:
                this.b.removeDir(iIntValue);
                break;
            case 8:
                this.b.removeCommentRangeStart(iIntValue);
                break;
            case 9:
                this.b.removeMoveFrom(iIntValue);
                break;
            case 10:
                this.b.removeCustomXmlMoveToRangeStart(iIntValue);
                break;
            case 11:
                this.b.removeCustomXmlDelRangeEnd(iIntValue);
                break;
            case 12:
                this.b.removeSmartTag(iIntValue);
                break;
            case 13:
                this.b.removeMoveTo(iIntValue);
                break;
            case 14:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            case 15:
                this.b.removeFldSimple(iIntValue);
                break;
            case 16:
                this.b.removeIns(iIntValue);
                break;
            case 17:
                this.b.removeHyperlink(iIntValue);
                break;
            case 18:
                this.b.removeSubDoc(iIntValue);
                break;
            case 19:
                this.b.removeMoveFromRangeStart(iIntValue);
                break;
            case 20:
                this.b.removeCustomXmlMoveFromRangeStart(iIntValue);
                break;
            case 21:
                this.b.removeCustomXml(iIntValue);
                break;
            case 22:
                this.b.removeCustomXmlInsRangeEnd(iIntValue);
                break;
            case 23:
                this.b.removeOMathPara(iIntValue);
                break;
            case 24:
                this.b.removePermEnd(iIntValue);
                break;
            case 25:
                this.b.removeCommentRangeEnd(iIntValue);
                break;
            case 26:
                this.b.removeBookmarkStart(iIntValue);
                break;
            case 27:
                this.b.removeMoveToRangeEnd(iIntValue);
                break;
            case 28:
                this.b.removePermStart(iIntValue);
                break;
            default:
                this.b.removeOMath(iIntValue);
                break;
        }
    }
}
