package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7943a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ k(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7943a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfDefaultSizeArray;
        switch (this.f7943a) {
            case 0:
                iSizeOfDefaultSizeArray = this.b.sizeOfDefaultSizeArray();
                break;
            case 1:
                iSizeOfDefaultSizeArray = this.b.sizeOfMoveWithCellsArray();
                break;
            case 2:
                iSizeOfDefaultSizeArray = this.b.sizeOfSizeWithCellsArray();
                break;
            case 3:
                iSizeOfDefaultSizeArray = this.b.sizeOfCheckedArray();
                break;
            case 4:
                iSizeOfDefaultSizeArray = this.b.sizeOfHorizArray();
                break;
            case 5:
                iSizeOfDefaultSizeArray = this.b.sizeOfRowHiddenArray();
                break;
            case 6:
                iSizeOfDefaultSizeArray = this.b.sizeOfHelpArray();
                break;
            case 7:
                iSizeOfDefaultSizeArray = this.b.sizeOfJustLastXArray();
                break;
            case 8:
                iSizeOfDefaultSizeArray = this.b.sizeOfVTEditArray();
                break;
            case 9:
                iSizeOfDefaultSizeArray = this.b.sizeOfColHiddenArray();
                break;
            case 10:
                iSizeOfDefaultSizeArray = this.b.sizeOfValidIdsArray();
                break;
            case 11:
                iSizeOfDefaultSizeArray = this.b.sizeOfSecretEditArray();
                break;
            case 12:
                iSizeOfDefaultSizeArray = this.b.sizeOfFirstButtonArray();
                break;
            case 13:
                iSizeOfDefaultSizeArray = this.b.sizeOfTextHAlignArray();
                break;
            case 14:
                iSizeOfDefaultSizeArray = this.b.sizeOfPageArray();
                break;
            case 15:
                iSizeOfDefaultSizeArray = this.b.sizeOfRowArray();
                break;
            case 16:
                iSizeOfDefaultSizeArray = this.b.sizeOfWidthMinArray();
                break;
            case 17:
                iSizeOfDefaultSizeArray = this.b.sizeOfColumnArray();
                break;
            case 18:
                iSizeOfDefaultSizeArray = this.b.sizeOfSelTypeArray();
                break;
            case 19:
                iSizeOfDefaultSizeArray = this.b.sizeOfAccel2Array();
                break;
            case 20:
                iSizeOfDefaultSizeArray = this.b.sizeOfCameraArray();
                break;
            case 21:
                iSizeOfDefaultSizeArray = this.b.sizeOfSelArray();
                break;
            case 22:
                iSizeOfDefaultSizeArray = this.b.sizeOfValArray();
                break;
            case 23:
                iSizeOfDefaultSizeArray = this.b.sizeOfFmlaPictArray();
                break;
            case 24:
                iSizeOfDefaultSizeArray = this.b.sizeOfDismissArray();
                break;
            case 25:
                iSizeOfDefaultSizeArray = this.b.sizeOfDropLinesArray();
                break;
            case 26:
                iSizeOfDefaultSizeArray = this.b.sizeOfDxArray();
                break;
            case 27:
                iSizeOfDefaultSizeArray = this.b.sizeOfFmlaTxbxArray();
                break;
            case 28:
                iSizeOfDefaultSizeArray = this.b.sizeOfFmlaRangeArray();
                break;
            default:
                iSizeOfDefaultSizeArray = this.b.sizeOfDropStyleArray();
                break;
        }
        return Integer.valueOf(iSizeOfDefaultSizeArray);
    }
}
