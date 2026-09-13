package r5;

import java.util.function.Supplier;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCacheFieldImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCacheFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCalcChainImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellStyleXfsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellWatchesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellXfsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCfRuleImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCommentListImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTConditionalFormattingImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTControlsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomPropertiesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomSheetViewsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCustomWorkbookViewsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDataBarImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDataFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDataValidationsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDefinedNamesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDxfsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExtensionListImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalDefinedNamesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalReferencesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalRowImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetDataImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetDataSetImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetNamesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFillsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFontsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTFunctionGroupsImpl;

/* JADX INFO: renamed from: r5.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1568j implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8055a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ C1568j(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8055a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfMpMapArray;
        switch (this.f8055a) {
            case 0:
                iSizeOfMpMapArray = ((CTCacheFieldImpl) this.b).sizeOfMpMapArray();
                break;
            case 1:
                iSizeOfMpMapArray = ((CTCacheFieldsImpl) this.b).sizeOfCacheFieldArray();
                break;
            case 2:
                iSizeOfMpMapArray = ((CTCalcChainImpl) this.b).sizeOfCArray();
                break;
            case 3:
                iSizeOfMpMapArray = ((CTCellStyleXfsImpl) this.b).sizeOfXfArray();
                break;
            case 4:
                iSizeOfMpMapArray = ((CTCellWatchesImpl) this.b).sizeOfCellWatchArray();
                break;
            case 5:
                iSizeOfMpMapArray = ((CTCellXfsImpl) this.b).sizeOfXfArray();
                break;
            case 6:
                iSizeOfMpMapArray = ((CTCfRuleImpl) this.b).sizeOfFormulaArray();
                break;
            case 7:
                iSizeOfMpMapArray = ((CTColFieldsImpl) this.b).sizeOfFieldArray();
                break;
            case 8:
                iSizeOfMpMapArray = ((CTColsImpl) this.b).sizeOfColArray();
                break;
            case 9:
                iSizeOfMpMapArray = ((CTCommentListImpl) this.b).sizeOfCommentArray();
                break;
            case 10:
                iSizeOfMpMapArray = ((CTConditionalFormattingImpl) this.b).sizeOfCfRuleArray();
                break;
            case 11:
                iSizeOfMpMapArray = ((CTControlsImpl) this.b).sizeOfControlArray();
                break;
            case 12:
                iSizeOfMpMapArray = ((CTCustomPropertiesImpl) this.b).sizeOfCustomPrArray();
                break;
            case 13:
                iSizeOfMpMapArray = ((CTCustomSheetViewsImpl) this.b).sizeOfCustomSheetViewArray();
                break;
            case 14:
                iSizeOfMpMapArray = ((CTCustomWorkbookViewsImpl) this.b).sizeOfCustomWorkbookViewArray();
                break;
            case 15:
                iSizeOfMpMapArray = ((CTDataBarImpl) this.b).sizeOfCfvoArray();
                break;
            case 16:
                iSizeOfMpMapArray = ((CTDataFieldsImpl) this.b).sizeOfDataFieldArray();
                break;
            case 17:
                iSizeOfMpMapArray = ((CTDataValidationsImpl) this.b).sizeOfDataValidationArray();
                break;
            case 18:
                iSizeOfMpMapArray = ((CTDefinedNamesImpl) this.b).sizeOfDefinedNameArray();
                break;
            case 19:
                iSizeOfMpMapArray = ((CTDxfsImpl) this.b).sizeOfDxfArray();
                break;
            case 20:
                iSizeOfMpMapArray = ((CTExtensionListImpl) this.b).sizeOfExtArray();
                break;
            case 21:
                iSizeOfMpMapArray = ((CTExternalDefinedNamesImpl) this.b).sizeOfDefinedNameArray();
                break;
            case 22:
                iSizeOfMpMapArray = ((CTExternalReferencesImpl) this.b).sizeOfExternalReferenceArray();
                break;
            case 23:
                iSizeOfMpMapArray = ((CTExternalRowImpl) this.b).sizeOfCellArray();
                break;
            case 24:
                iSizeOfMpMapArray = ((CTExternalSheetDataImpl) this.b).sizeOfRowArray();
                break;
            case 25:
                iSizeOfMpMapArray = ((CTExternalSheetDataSetImpl) this.b).sizeOfSheetDataArray();
                break;
            case 26:
                iSizeOfMpMapArray = ((CTExternalSheetNamesImpl) this.b).sizeOfSheetNameArray();
                break;
            case 27:
                iSizeOfMpMapArray = ((CTFillsImpl) this.b).sizeOfFillArray();
                break;
            case 28:
                iSizeOfMpMapArray = ((CTFontsImpl) this.b).sizeOfFontArray();
                break;
            default:
                iSizeOfMpMapArray = ((CTFunctionGroupsImpl) this.b).sizeOfFunctionGroupArray();
                break;
        }
        return Integer.valueOf(iSizeOfMpMapArray);
    }
}
