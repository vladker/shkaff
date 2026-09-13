package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7935a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ c(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7935a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7935a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeTextVAlign(iIntValue);
                break;
            case 1:
                this.b.removeFmlaLink(iIntValue);
                break;
            case 2:
                this.b.removePrintObject(iIntValue);
                break;
            case 3:
                this.b.removeListItem(iIntValue);
                break;
            case 4:
                this.b.removeScriptText(iIntValue);
                break;
            case 5:
                this.b.removeAutoLine(iIntValue);
                break;
            case 6:
                this.b.removeDisabled(iIntValue);
                break;
            case 7:
                this.b.removeNoThreeD(iIntValue);
                break;
            case 8:
                this.b.removeMin(iIntValue);
                break;
            case 9:
                this.b.removeAutoPict(iIntValue);
                break;
            case 10:
                this.b.removeLockText(iIntValue);
                break;
            case 11:
                this.b.removeFmlaMacro(iIntValue);
                break;
            case 12:
                this.b.removeMultiSel(iIntValue);
                break;
            case 13:
                this.b.removeMapOCX(iIntValue);
                break;
            case 14:
                this.b.removeAccel(iIntValue);
                break;
            case 15:
                this.b.removeAnchor(iIntValue);
                break;
            case 16:
                this.b.removeNoThreeD2(iIntValue);
                break;
            case 17:
                this.b.removeAutoScale(iIntValue);
                break;
            case 18:
                this.b.removeMultiLine(iIntValue);
                break;
            case 19:
                this.b.removeAutoFill(iIntValue);
                break;
            case 20:
                this.b.removeScriptExtended(iIntValue);
                break;
            case 21:
                this.b.removeVisible(iIntValue);
                break;
            case 22:
                this.b.removeCF(iIntValue);
                break;
            case 23:
                this.b.removeMax(iIntValue);
                break;
            case 24:
                this.b.removeColored(iIntValue);
                break;
            case 25:
                this.b.removeFmlaGroup(iIntValue);
                break;
            case 26:
                this.b.removeInc(iIntValue);
                break;
            case 27:
                this.b.removeLCT(iIntValue);
                break;
            case 28:
                this.b.removeScriptLanguage(iIntValue);
                break;
            default:
                this.b.removeUIObj(iIntValue);
                break;
        }
    }
}
