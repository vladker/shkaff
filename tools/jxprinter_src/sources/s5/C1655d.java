package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBdoContentRunImpl;

/* JADX INFO: renamed from: s5.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1655d implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8389a;
    public final /* synthetic */ CTBdoContentRunImpl b;

    public /* synthetic */ C1655d(CTBdoContentRunImpl cTBdoContentRunImpl, int i5) {
        this.f8389a = i5;
        this.b = cTBdoContentRunImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8389a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCustomXmlMoveFromRangeEnd(iIntValue);
                break;
            case 1:
                this.b.removeMoveFrom(iIntValue);
                break;
            case 2:
                this.b.removeProofErr(iIntValue);
                break;
            case 3:
                this.b.removeFldSimple(iIntValue);
                break;
            case 4:
                this.b.removeHyperlink(iIntValue);
                break;
            case 5:
                this.b.removeOMathPara(iIntValue);
                break;
            case 6:
                this.b.removeDir(iIntValue);
                break;
            case 7:
                this.b.removeCustomXml(iIntValue);
                break;
            case 8:
                this.b.removeCustomXmlInsRangeStart(iIntValue);
                break;
            case 9:
                this.b.removeIns(iIntValue);
                break;
            case 10:
                this.b.removeBookmarkStart(iIntValue);
                break;
            case 11:
                this.b.removeCustomXmlMoveToRangeEnd(iIntValue);
                break;
            case 12:
                this.b.removeSubDoc(iIntValue);
                break;
            case 13:
                this.b.removeMoveTo(iIntValue);
                break;
            case 14:
                this.b.removeCustomXmlDelRangeEnd(iIntValue);
                break;
            case 15:
                this.b.removeBdo(iIntValue);
                break;
            case 16:
                this.b.removeMoveFromRangeStart(iIntValue);
                break;
            case 17:
                this.b.removeCustomXmlDelRangeStart(iIntValue);
                break;
            case 18:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 19:
                this.b.removeCommentRangeStart(iIntValue);
                break;
            case 20:
                this.b.removePermStart(iIntValue);
                break;
            case 21:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
            case 22:
                this.b.removeCustomXmlMoveFromRangeStart(iIntValue);
                break;
            case 23:
                this.b.removePermEnd(iIntValue);
                break;
            case 24:
                this.b.removeSdt(iIntValue);
                break;
            case 25:
                this.b.removeCustomXmlMoveToRangeStart(iIntValue);
                break;
            case 26:
                this.b.removeDel(iIntValue);
                break;
            case 27:
                this.b.removeMoveToRangeEnd(iIntValue);
                break;
            case 28:
                this.b.removeSmartTag(iIntValue);
                break;
            default:
                this.b.removeCommentRangeEnd(iIntValue);
                break;
        }
    }
}
