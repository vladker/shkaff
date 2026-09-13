package r5;

import com.microsoft.schemas.office.visio.x2012.main.impl.CellTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.ConnectsTypeImpl;
import java.util.function.Supplier;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTHyperlinksImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIconSetImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIgnoredErrorsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTIndexedColorsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTItemsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTMergeCellsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTNumFmtsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTOleObjectsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPageBreakImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPageFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPivotCacheRecordsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPivotCachesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPivotFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangeImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRowFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRowImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetDataImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetViewsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSingleXmlCellsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSortStateImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSstImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTTableColumnsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTTablePartsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTTableStyleImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTTableStylesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTWorkbookImpl;

/* JADX INFO: renamed from: r5.b0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1553b0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8032a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ C1553b0(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8032a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfHyperlinkArray;
        switch (this.f8032a) {
            case 0:
                iSizeOfHyperlinkArray = ((CTHyperlinksImpl) this.b).sizeOfHyperlinkArray();
                break;
            case 1:
                iSizeOfHyperlinkArray = ((CTIconSetImpl) this.b).sizeOfCfvoArray();
                break;
            case 2:
                iSizeOfHyperlinkArray = ((CTIgnoredErrorsImpl) this.b).sizeOfIgnoredErrorArray();
                break;
            case 3:
                iSizeOfHyperlinkArray = ((CTIndexedColorsImpl) this.b).sizeOfRgbColorArray();
                break;
            case 4:
                iSizeOfHyperlinkArray = ((CTItemsImpl) this.b).sizeOfItemArray();
                break;
            case 5:
                iSizeOfHyperlinkArray = ((CTMergeCellsImpl) this.b).sizeOfMergeCellArray();
                break;
            case 6:
                iSizeOfHyperlinkArray = ((CTNumFmtsImpl) this.b).sizeOfNumFmtArray();
                break;
            case 7:
                iSizeOfHyperlinkArray = ((CTOleObjectsImpl) this.b).sizeOfOleObjectArray();
                break;
            case 8:
                iSizeOfHyperlinkArray = ((CTPageBreakImpl) this.b).sizeOfBrkArray();
                break;
            case 9:
                iSizeOfHyperlinkArray = ((CTPageFieldsImpl) this.b).sizeOfPageFieldArray();
                break;
            case 10:
                iSizeOfHyperlinkArray = ((CTPivotCacheRecordsImpl) this.b).sizeOfRArray();
                break;
            case 11:
                iSizeOfHyperlinkArray = ((CTPivotCachesImpl) this.b).sizeOfPivotCacheArray();
                break;
            case 12:
                iSizeOfHyperlinkArray = ((CTPivotFieldsImpl) this.b).sizeOfPivotFieldArray();
                break;
            case 13:
                iSizeOfHyperlinkArray = ((CTProtectedRangeImpl) this.b).sizeOfSecurityDescriptorArray();
                break;
            case 14:
                iSizeOfHyperlinkArray = ((CTProtectedRangesImpl) this.b).sizeOfProtectedRangeArray();
                break;
            case 15:
                iSizeOfHyperlinkArray = ((CTRowFieldsImpl) this.b).sizeOfFieldArray();
                break;
            case 16:
                iSizeOfHyperlinkArray = ((CTRowImpl) this.b).sizeOfCArray();
                break;
            case 17:
                iSizeOfHyperlinkArray = ((CTSheetDataImpl) this.b).sizeOfRowArray();
                break;
            case 18:
                iSizeOfHyperlinkArray = ((CTSheetViewsImpl) this.b).sizeOfSheetViewArray();
                break;
            case 19:
                iSizeOfHyperlinkArray = ((CTSheetsImpl) this.b).sizeOfSheetArray();
                break;
            case 20:
                iSizeOfHyperlinkArray = ((CTSingleXmlCellsImpl) this.b).sizeOfSingleXmlCellArray();
                break;
            case 21:
                iSizeOfHyperlinkArray = ((CTSortStateImpl) this.b).sizeOfSortConditionArray();
                break;
            case 22:
                iSizeOfHyperlinkArray = ((CTSstImpl) this.b).sizeOfSiArray();
                break;
            case 23:
                iSizeOfHyperlinkArray = ((CTTableColumnsImpl) this.b).sizeOfTableColumnArray();
                break;
            case 24:
                iSizeOfHyperlinkArray = ((CTTablePartsImpl) this.b).sizeOfTablePartArray();
                break;
            case 25:
                iSizeOfHyperlinkArray = ((CTTableStyleImpl) this.b).sizeOfTableStyleElementArray();
                break;
            case 26:
                iSizeOfHyperlinkArray = ((CTTableStylesImpl) this.b).sizeOfTableStyleArray();
                break;
            case 27:
                iSizeOfHyperlinkArray = ((CTWorkbookImpl) this.b).sizeOfFileRecoveryPrArray();
                break;
            case 28:
                iSizeOfHyperlinkArray = ((CellTypeImpl) this.b).sizeOfRefByArray();
                break;
            default:
                iSizeOfHyperlinkArray = ((ConnectsTypeImpl) this.b).sizeOfConnectArray();
                break;
        }
        return Integer.valueOf(iSizeOfHyperlinkArray);
    }
}
