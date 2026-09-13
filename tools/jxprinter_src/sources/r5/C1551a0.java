package r5;

import com.microsoft.schemas.office.visio.x2012.main.impl.CellTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.ConnectsTypeImpl;
import java.util.function.Consumer;
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

/* JADX INFO: renamed from: r5.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1551a0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8029a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ C1551a0(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8029a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f8029a) {
            case 0:
                ((CTHyperlinksImpl) this.b).removeHyperlink(((Integer) obj).intValue());
                break;
            case 1:
                ((CTIconSetImpl) this.b).removeCfvo(((Integer) obj).intValue());
                break;
            case 2:
                ((CTIgnoredErrorsImpl) this.b).removeIgnoredError(((Integer) obj).intValue());
                break;
            case 3:
                ((CTIndexedColorsImpl) this.b).removeRgbColor(((Integer) obj).intValue());
                break;
            case 4:
                ((CTItemsImpl) this.b).removeItem(((Integer) obj).intValue());
                break;
            case 5:
                ((CTMergeCellsImpl) this.b).removeMergeCell(((Integer) obj).intValue());
                break;
            case 6:
                ((CTNumFmtsImpl) this.b).removeNumFmt(((Integer) obj).intValue());
                break;
            case 7:
                ((CTOleObjectsImpl) this.b).removeOleObject(((Integer) obj).intValue());
                break;
            case 8:
                ((CTPageBreakImpl) this.b).removeBrk(((Integer) obj).intValue());
                break;
            case 9:
                ((CTPageFieldsImpl) this.b).removePageField(((Integer) obj).intValue());
                break;
            case 10:
                ((CTPivotCacheRecordsImpl) this.b).removeR(((Integer) obj).intValue());
                break;
            case 11:
                ((CTPivotCachesImpl) this.b).removePivotCache(((Integer) obj).intValue());
                break;
            case 12:
                ((CTPivotFieldsImpl) this.b).removePivotField(((Integer) obj).intValue());
                break;
            case 13:
                ((CTProtectedRangeImpl) this.b).removeSecurityDescriptor(((Integer) obj).intValue());
                break;
            case 14:
                ((CTProtectedRangesImpl) this.b).removeProtectedRange(((Integer) obj).intValue());
                break;
            case 15:
                ((CTRowFieldsImpl) this.b).removeField(((Integer) obj).intValue());
                break;
            case 16:
                ((CTRowImpl) this.b).removeC(((Integer) obj).intValue());
                break;
            case 17:
                ((CTSheetDataImpl) this.b).removeRow(((Integer) obj).intValue());
                break;
            case 18:
                ((CTSheetViewsImpl) this.b).removeSheetView(((Integer) obj).intValue());
                break;
            case 19:
                ((CTSheetsImpl) this.b).removeSheet(((Integer) obj).intValue());
                break;
            case 20:
                ((CTSingleXmlCellsImpl) this.b).removeSingleXmlCell(((Integer) obj).intValue());
                break;
            case 21:
                ((CTSortStateImpl) this.b).removeSortCondition(((Integer) obj).intValue());
                break;
            case 22:
                ((CTSstImpl) this.b).removeSi(((Integer) obj).intValue());
                break;
            case 23:
                ((CTTableColumnsImpl) this.b).removeTableColumn(((Integer) obj).intValue());
                break;
            case 24:
                ((CTTablePartsImpl) this.b).removeTablePart(((Integer) obj).intValue());
                break;
            case 25:
                ((CTTableStyleImpl) this.b).removeTableStyleElement(((Integer) obj).intValue());
                break;
            case 26:
                ((CTTableStylesImpl) this.b).removeTableStyle(((Integer) obj).intValue());
                break;
            case 27:
                ((CTWorkbookImpl) this.b).removeFileRecoveryPr(((Integer) obj).intValue());
                break;
            case 28:
                ((CellTypeImpl) this.b).removeRefBy(((Integer) obj).intValue());
                break;
            default:
                ((ConnectsTypeImpl) this.b).removeConnect(((Integer) obj).intValue());
                break;
        }
    }
}
