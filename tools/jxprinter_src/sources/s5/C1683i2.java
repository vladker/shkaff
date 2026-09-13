package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRunTrackChangeImpl;

/* JADX INFO: renamed from: s5.i2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1683i2 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8422a;
    public final /* synthetic */ CTRunTrackChangeImpl b;

    public /* synthetic */ C1683i2(CTRunTrackChangeImpl cTRunTrackChangeImpl, int i5) {
        this.f8422a = i5;
        this.b = cTRunTrackChangeImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8422a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeCustomXmlDelRangeStart(iIntValue);
                break;
            case 1:
                this.b.removePermEnd(iIntValue);
                break;
            case 2:
                this.b.removeEqArr(iIntValue);
                break;
            case 3:
                this.b.removeMoveToRangeStart(iIntValue);
                break;
            case 4:
                this.b.removeMoveToRangeEnd(iIntValue);
                break;
            case 5:
                this.b.removeBookmarkStart(iIntValue);
                break;
            case 6:
                this.b.removeOMathPara(iIntValue);
                break;
            case 7:
                this.b.removeSmartTag(iIntValue);
                break;
            case 8:
                this.b.removeR(iIntValue);
                break;
            case 9:
                this.b.removeCustomXml(iIntValue);
                break;
            case 10:
                this.b.removeCustomXmlMoveFromRangeStart(iIntValue);
                break;
            case 11:
                this.b.removeProofErr(iIntValue);
                break;
            case 12:
                this.b.removeSdt(iIntValue);
                break;
            case 13:
                this.b.removeCustomXmlMoveToRangeEnd(iIntValue);
                break;
            case 14:
                this.b.removeBox(iIntValue);
                break;
            case 15:
                this.b.removeCustomXmlDelRangeEnd(iIntValue);
                break;
            case 16:
                this.b.removeSSubSup(iIntValue);
                break;
            case 17:
                this.b.removePermStart(iIntValue);
                break;
            case 18:
                this.b.removeSPre(iIntValue);
                break;
            case 19:
                this.b.removePhant(iIntValue);
                break;
            case 20:
                this.b.removeNary(iIntValue);
                break;
            case 21:
                this.b.removeD(iIntValue);
                break;
            case 22:
                this.b.removeBar(iIntValue);
                break;
            case 23:
                this.b.removeM(iIntValue);
                break;
            case 24:
                this.b.removeMoveFromRangeStart(iIntValue);
                break;
            case 25:
                this.b.removeMoveTo(iIntValue);
                break;
            case 26:
                this.b.removeDir(iIntValue);
                break;
            case 27:
                this.b.removeAcc(iIntValue);
                break;
            case 28:
                this.b.removeMoveFromRangeEnd(iIntValue);
                break;
            default:
                this.b.removeDel(iIntValue);
                break;
        }
    }
}
