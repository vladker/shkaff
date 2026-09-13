package r5;

import com.microsoft.schemas.office.visio.x2012.main.ConnectType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.ShapeSheetType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetType;
import com.microsoft.schemas.office.visio.x2012.main.impl.ConnectsTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.MastersTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.PagesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.ShapesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.StyleSheetsTypeImpl;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileRecoveryPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRst;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSortCondition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleElement;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRowFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTRowImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetDataImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTSheetViewImpl;
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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAttr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtListItem;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTAbstractNumImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCommentsImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTEndnotesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFootnotesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTLatentStylesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtComboBoxImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtDropDownListImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtEndPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSettingsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class B0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7980a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ B0(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f7980a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7980a) {
            case 0:
                ((CTRowFieldsImpl) this.b).setFieldArray(((Integer) obj).intValue(), (CTField) obj2);
                break;
            case 1:
                ((CTRowImpl) this.b).setCArray(((Integer) obj).intValue(), (CTCell) obj2);
                break;
            case 2:
                ((CTSheetDataImpl) this.b).setRowArray(((Integer) obj).intValue(), (CTRow) obj2);
                break;
            case 3:
                ((CTSheetViewImpl) this.b).setSelectionArray(((Integer) obj).intValue(), (CTSelection) obj2);
                break;
            case 4:
                ((CTSheetViewsImpl) this.b).setSheetViewArray(((Integer) obj).intValue(), (CTSheetView) obj2);
                break;
            case 5:
                ((CTSheetsImpl) this.b).setSheetArray(((Integer) obj).intValue(), (CTSheet) obj2);
                break;
            case 6:
                ((CTSingleXmlCellsImpl) this.b).setSingleXmlCellArray(((Integer) obj).intValue(), (CTSingleXmlCell) obj2);
                break;
            case 7:
                ((CTSortStateImpl) this.b).setSortConditionArray(((Integer) obj).intValue(), (CTSortCondition) obj2);
                break;
            case 8:
                ((CTSstImpl) this.b).setSiArray(((Integer) obj).intValue(), (CTRst) obj2);
                break;
            case 9:
                ((CTTableColumnsImpl) this.b).setTableColumnArray(((Integer) obj).intValue(), (CTTableColumn) obj2);
                break;
            case 10:
                ((CTTablePartsImpl) this.b).setTablePartArray(((Integer) obj).intValue(), (CTTablePart) obj2);
                break;
            case 11:
                ((CTTableStyleImpl) this.b).setTableStyleElementArray(((Integer) obj).intValue(), (CTTableStyleElement) obj2);
                break;
            case 12:
                ((CTTableStylesImpl) this.b).setTableStyleArray(((Integer) obj).intValue(), (CTTableStyle) obj2);
                break;
            case 13:
                ((CTWorkbookImpl) this.b).setFileRecoveryPrArray(((Integer) obj).intValue(), (CTFileRecoveryPr) obj2);
                break;
            case 14:
                ((ConnectsTypeImpl) this.b).setConnectArray(((Integer) obj).intValue(), (ConnectType) obj2);
                break;
            case 15:
                ((MastersTypeImpl) this.b).setMasterArray(((Integer) obj).intValue(), (MasterType) obj2);
                break;
            case 16:
                ((PagesTypeImpl) this.b).setPageArray(((Integer) obj).intValue(), (PageType) obj2);
                break;
            case 17:
                ((ShapesTypeImpl) this.b).setShapeArray(((Integer) obj).intValue(), (ShapeSheetType) obj2);
                break;
            case 18:
                ((StyleSheetsTypeImpl) this.b).setStyleSheetArray(((Integer) obj).intValue(), (StyleSheetType) obj2);
                break;
            case 19:
                ((CTAbstractNumImpl) this.b).setLvlArray(((Integer) obj).intValue(), (CTLvl) obj2);
                break;
            case 20:
                ((CTCommentsImpl) this.b).setCommentArray(((Integer) obj).intValue(), (CTComment) obj2);
                break;
            case 21:
                ((CTCustomXmlPrImpl) this.b).setAttrArray(((Integer) obj).intValue(), (CTAttr) obj2);
                break;
            case 22:
                ((CTEndnotesImpl) this.b).setEndnoteArray(((Integer) obj).intValue(), (CTFtnEdn) obj2);
                break;
            case 23:
                ((CTFootnotesImpl) this.b).setFootnoteArray(((Integer) obj).intValue(), (CTFtnEdn) obj2);
                break;
            case 24:
                ((CTLatentStylesImpl) this.b).setLsdExceptionArray(((Integer) obj).intValue(), (CTLsdException) obj2);
                break;
            case 25:
                ((CTNumImpl) this.b).setLvlOverrideArray(((Integer) obj).intValue(), (CTNumLvl) obj2);
                break;
            case 26:
                ((CTSdtComboBoxImpl) this.b).setListItemArray(((Integer) obj).intValue(), (CTSdtListItem) obj2);
                break;
            case 27:
                ((CTSdtDropDownListImpl) this.b).setListItemArray(((Integer) obj).intValue(), (CTSdtListItem) obj2);
                break;
            case 28:
                ((CTSdtEndPrImpl) this.b).setRPrArray(((Integer) obj).intValue(), (CTRPr) obj2);
                break;
            default:
                ((CTSettingsImpl) this.b).setAttachedSchemaArray(((Integer) obj).intValue(), (CTString) obj2);
                break;
        }
    }
}
