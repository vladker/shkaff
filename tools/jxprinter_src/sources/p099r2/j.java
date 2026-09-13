package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7942a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ j(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7942a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f7942a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeMoveWithCells(iIntValue);
                break;
            case 1:
                this.b.removeDefaultSize(iIntValue);
                break;
            case 2:
                this.b.removeSizeWithCells(iIntValue);
                break;
            case 3:
                this.b.removeChecked(iIntValue);
                break;
            case 4:
                this.b.removeHoriz(iIntValue);
                break;
            case 5:
                this.b.removeRowHidden(iIntValue);
                break;
            case 6:
                this.b.removeHelp(iIntValue);
                break;
            case 7:
                this.b.removeColHidden(iIntValue);
                break;
            case 8:
                this.b.removeJustLastX(iIntValue);
                break;
            case 9:
                this.b.removeVTEdit(iIntValue);
                break;
            case 10:
                this.b.removeValidIds(iIntValue);
                break;
            case 11:
                this.b.removeSecretEdit(iIntValue);
                break;
            case 12:
                this.b.removeSel(iIntValue);
                break;
            case 13:
                this.b.removeFirstButton(iIntValue);
                break;
            case 14:
                this.b.removeTextHAlign(iIntValue);
                break;
            case 15:
                this.b.removePage(iIntValue);
                break;
            case 16:
                this.b.removeWidthMin(iIntValue);
                break;
            case 17:
                this.b.removeRow(iIntValue);
                break;
            case 18:
                this.b.removeColumn(iIntValue);
                break;
            case 19:
                this.b.removeSelType(iIntValue);
                break;
            case 20:
                this.b.removeCamera(iIntValue);
                break;
            case 21:
                this.b.removeAccel2(iIntValue);
                break;
            case 22:
                this.b.removeVal(iIntValue);
                break;
            case 23:
                this.b.removeFmlaPict(iIntValue);
                break;
            case 24:
                this.b.removeDismiss(iIntValue);
                break;
            case 25:
                this.b.removeDropLines(iIntValue);
                break;
            case 26:
                this.b.removeDx(iIntValue);
                break;
            case 27:
                this.b.removeFmlaTxbx(iIntValue);
                break;
            case 28:
                this.b.removeFmlaRange(iIntValue);
                break;
            default:
                this.b.removeDropStyle(iIntValue);
                break;
        }
    }
}
