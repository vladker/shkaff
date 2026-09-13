package p5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class U implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7789a;
    public final /* synthetic */ CTOMathImpl b;

    public /* synthetic */ U(CTOMathImpl cTOMathImpl, int i5) {
        this.f7789a = i5;
        this.b = cTOMathImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7789a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeMoveFrom(iIntValue);
                break;
            case 1:
                this.b.removeCustomXmlInsRangeStart(iIntValue);
                break;
            case 2:
                this.b.removeLimUpp(iIntValue);
                break;
            case 3:
                this.b.removeSSup(iIntValue);
                break;
            case 4:
                this.b.removeBorderBox(iIntValue);
                break;
            case 5:
                this.b.removeAcc(iIntValue);
                break;
            case 6:
                this.b.removeCustomXml(iIntValue);
                break;
            case 7:
                this.b.removeCustomXmlMoveFromRangeEnd(iIntValue);
                break;
            case 8:
                this.b.removeEqArr(iIntValue);
                break;
            case 9:
                this.b.removeCustomXmlMoveToRangeStart(iIntValue);
                break;
            case 10:
                this.b.removeDel(iIntValue);
                break;
            case 11:
                this.b.removeCustomXmlDelRangeEnd(iIntValue);
                break;
            case 12:
                this.b.removeCustomXmlMoveToRangeEnd(iIntValue);
                break;
            case 13:
                this.b.removeGroupChr(iIntValue);
                break;
            case 14:
                this.b.removeD(iIntValue);
                break;
            case 15:
                this.b.removeSSub(iIntValue);
                break;
            case 16:
                this.b.removeMoveToRangeEnd(iIntValue);
                break;
            case 17:
                this.b.removeCustomXmlDelRangeStart(iIntValue);
                break;
            case 18:
                this.b.removeFunc(iIntValue);
                break;
            default:
                this.b.removePermEnd(iIntValue);
                break;
        }
    }
}
