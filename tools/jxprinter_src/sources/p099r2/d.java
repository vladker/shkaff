package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7936a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ d(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7936a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfTextVAlignArray;
        switch (this.f7936a) {
            case 0:
                iSizeOfTextVAlignArray = this.b.sizeOfTextVAlignArray();
                break;
            case 1:
                iSizeOfTextVAlignArray = this.b.sizeOfFmlaLinkArray();
                break;
            case 2:
                iSizeOfTextVAlignArray = this.b.sizeOfPrintObjectArray();
                break;
            case 3:
                iSizeOfTextVAlignArray = this.b.sizeOfListItemArray();
                break;
            case 4:
                iSizeOfTextVAlignArray = this.b.sizeOfScriptTextArray();
                break;
            case 5:
                iSizeOfTextVAlignArray = this.b.sizeOfAutoLineArray();
                break;
            case 6:
                iSizeOfTextVAlignArray = this.b.sizeOfNoThreeDArray();
                break;
            case 7:
                iSizeOfTextVAlignArray = this.b.sizeOfDisabledArray();
                break;
            case 8:
                iSizeOfTextVAlignArray = this.b.sizeOfMinArray();
                break;
            case 9:
                iSizeOfTextVAlignArray = this.b.sizeOfAutoPictArray();
                break;
            case 10:
                iSizeOfTextVAlignArray = this.b.sizeOfLockTextArray();
                break;
            case 11:
                iSizeOfTextVAlignArray = this.b.sizeOfFmlaMacroArray();
                break;
            case 12:
                iSizeOfTextVAlignArray = this.b.sizeOfMultiSelArray();
                break;
            case 13:
                iSizeOfTextVAlignArray = this.b.sizeOfMapOCXArray();
                break;
            case 14:
                iSizeOfTextVAlignArray = this.b.sizeOfAccelArray();
                break;
            case 15:
                iSizeOfTextVAlignArray = this.b.sizeOfAnchorArray();
                break;
            case 16:
                iSizeOfTextVAlignArray = this.b.sizeOfNoThreeD2Array();
                break;
            case 17:
                iSizeOfTextVAlignArray = this.b.sizeOfAutoScaleArray();
                break;
            case 18:
                iSizeOfTextVAlignArray = this.b.sizeOfMultiLineArray();
                break;
            case 19:
                iSizeOfTextVAlignArray = this.b.sizeOfScriptExtendedArray();
                break;
            case 20:
                iSizeOfTextVAlignArray = this.b.sizeOfAutoFillArray();
                break;
            case 21:
                iSizeOfTextVAlignArray = this.b.sizeOfVisibleArray();
                break;
            case 22:
                iSizeOfTextVAlignArray = this.b.sizeOfCFArray();
                break;
            case 23:
                iSizeOfTextVAlignArray = this.b.sizeOfMaxArray();
                break;
            case 24:
                iSizeOfTextVAlignArray = this.b.sizeOfColoredArray();
                break;
            case 25:
                iSizeOfTextVAlignArray = this.b.sizeOfFmlaGroupArray();
                break;
            case 26:
                iSizeOfTextVAlignArray = this.b.sizeOfIncArray();
                break;
            case 27:
                iSizeOfTextVAlignArray = this.b.sizeOfLCTArray();
                break;
            case 28:
                iSizeOfTextVAlignArray = this.b.sizeOfScriptLanguageArray();
                break;
            default:
                iSizeOfTextVAlignArray = this.b.sizeOfUIObjArray();
                break;
        }
        return Integer.valueOf(iSizeOfTextVAlignArray);
    }
}
