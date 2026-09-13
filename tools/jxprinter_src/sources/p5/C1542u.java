package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl;

/* JADX INFO: renamed from: p5.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1542u implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7830a;
    public final /* synthetic */ CTOMathArgImpl b;

    public /* synthetic */ C1542u(CTOMathArgImpl cTOMathArgImpl, int i5) {
        this.f7830a = i5;
        this.b = cTOMathArgImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7830a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeLimUpp(iIntValue);
                break;
            case 1:
                this.b.removeMoveTo(iIntValue);
                break;
            case 2:
                this.b.removeBorderBox(iIntValue);
                break;
            case 3:
                this.b.removePermStart(iIntValue);
                break;
            case 4:
                this.b.removeBox(iIntValue);
                break;
            case 5:
                this.b.removeCommentRangeEnd(iIntValue);
                break;
            case 6:
                this.b.removeSSup(iIntValue);
                break;
            case 7:
                this.b.removeCustomXmlInsRangeStart(iIntValue);
                break;
            case 8:
                this.b.removePhant(iIntValue);
                break;
            case 9:
                this.b.removeM(iIntValue);
                break;
            case 10:
                this.b.removeLimLow(iIntValue);
                break;
            case 11:
                this.b.removeProofErr(iIntValue);
                break;
            case 12:
                this.b.removeR(iIntValue);
                break;
            case 13:
                this.b.removeSSub(iIntValue);
                break;
            case 14:
                this.b.removeCustomXmlMoveFromRangeStart(iIntValue);
                break;
            case 15:
                this.b.removeOMath(iIntValue);
                break;
            case 16:
                this.b.removeCustomXml(iIntValue);
                break;
            case 17:
                this.b.removePermEnd(iIntValue);
                break;
            case 18:
                this.b.removeEqArr(iIntValue);
                break;
            default:
                this.b.removeSSubSup(iIntValue);
                break;
        }
    }
}
