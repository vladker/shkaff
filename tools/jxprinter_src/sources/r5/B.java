package r5;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomProperty;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtension;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetData;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItem;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTNumFmt;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTProtectedRange;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRgbColor;
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
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPivotCachesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTPivotFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTProtectedRangesImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class B implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7979a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ B(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f7979a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f7979a) {
            case 0:
                ((CTCustomPropertiesImpl) this.b).setCustomPrArray(((Integer) obj).intValue(), (CTCustomProperty) obj2);
                break;
            case 1:
                ((CTCustomSheetViewsImpl) this.b).setCustomSheetViewArray(((Integer) obj).intValue(), (CTCustomSheetView) obj2);
                break;
            case 2:
                ((CTCustomWorkbookViewsImpl) this.b).setCustomWorkbookViewArray(((Integer) obj).intValue(), (CTCustomWorkbookView) obj2);
                break;
            case 3:
                ((CTDataBarImpl) this.b).setCfvoArray(((Integer) obj).intValue(), (CTCfvo) obj2);
                break;
            case 4:
                ((CTDataFieldsImpl) this.b).setDataFieldArray(((Integer) obj).intValue(), (CTDataField) obj2);
                break;
            case 5:
                ((CTDataValidationsImpl) this.b).setDataValidationArray(((Integer) obj).intValue(), (CTDataValidation) obj2);
                break;
            case 6:
                ((CTDefinedNamesImpl) this.b).setDefinedNameArray(((Integer) obj).intValue(), (CTDefinedName) obj2);
                break;
            case 7:
                ((CTDxfsImpl) this.b).setDxfArray(((Integer) obj).intValue(), (CTDxf) obj2);
                break;
            case 8:
                ((CTExtensionListImpl) this.b).setExtArray(((Integer) obj).intValue(), (CTExtension) obj2);
                break;
            case 9:
                ((CTExternalDefinedNamesImpl) this.b).setDefinedNameArray(((Integer) obj).intValue(), (CTExternalDefinedName) obj2);
                break;
            case 10:
                ((CTExternalReferencesImpl) this.b).setExternalReferenceArray(((Integer) obj).intValue(), (CTExternalReference) obj2);
                break;
            case 11:
                ((CTExternalRowImpl) this.b).setCellArray(((Integer) obj).intValue(), (CTExternalCell) obj2);
                break;
            case 12:
                ((CTExternalSheetDataImpl) this.b).setRowArray(((Integer) obj).intValue(), (CTExternalRow) obj2);
                break;
            case 13:
                ((CTExternalSheetDataSetImpl) this.b).setSheetDataArray(((Integer) obj).intValue(), (CTExternalSheetData) obj2);
                break;
            case 14:
                ((CTExternalSheetNamesImpl) this.b).setSheetNameArray(((Integer) obj).intValue(), (CTExternalSheetName) obj2);
                break;
            case 15:
                ((CTFillsImpl) this.b).setFillArray(((Integer) obj).intValue(), (CTFill) obj2);
                break;
            case 16:
                ((CTFontsImpl) this.b).setFontArray(((Integer) obj).intValue(), (CTFont) obj2);
                break;
            case 17:
                ((CTHyperlinksImpl) this.b).setHyperlinkArray(((Integer) obj).intValue(), (CTHyperlink) obj2);
                break;
            case 18:
                ((CTIconSetImpl) this.b).setCfvoArray(((Integer) obj).intValue(), (CTCfvo) obj2);
                break;
            case 19:
                ((CTIgnoredErrorsImpl) this.b).setIgnoredErrorArray(((Integer) obj).intValue(), (CTIgnoredError) obj2);
                break;
            case 20:
                ((CTIndexedColorsImpl) this.b).setRgbColorArray(((Integer) obj).intValue(), (CTRgbColor) obj2);
                break;
            case 21:
                ((CTItemsImpl) this.b).setItemArray(((Integer) obj).intValue(), (CTItem) obj2);
                break;
            case 22:
                ((CTMergeCellsImpl) this.b).setMergeCellArray(((Integer) obj).intValue(), (CTMergeCell) obj2);
                break;
            case 23:
                ((CTNumFmtsImpl) this.b).setNumFmtArray(((Integer) obj).intValue(), (CTNumFmt) obj2);
                break;
            case 24:
                ((CTOleObjectsImpl) this.b).setOleObjectArray(((Integer) obj).intValue(), (CTOleObject) obj2);
                break;
            case 25:
                ((CTPageBreakImpl) this.b).setBrkArray(((Integer) obj).intValue(), (CTBreak) obj2);
                break;
            case 26:
                ((CTPageFieldsImpl) this.b).setPageFieldArray(((Integer) obj).intValue(), (CTPageField) obj2);
                break;
            case 27:
                ((CTPivotCachesImpl) this.b).setPivotCacheArray(((Integer) obj).intValue(), (CTPivotCache) obj2);
                break;
            case 28:
                ((CTPivotFieldsImpl) this.b).setPivotFieldArray(((Integer) obj).intValue(), (CTPivotField) obj2);
                break;
            default:
                ((CTProtectedRangesImpl) this.b).setProtectedRangeArray(((Integer) obj).intValue(), (CTProtectedRange) obj2);
                break;
        }
    }
}
