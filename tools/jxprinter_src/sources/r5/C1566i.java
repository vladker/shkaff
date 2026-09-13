package r5;

import java.util.function.Consumer;
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

/* JADX INFO: renamed from: r5.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1566i implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8052a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ C1566i(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8052a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f8052a) {
            case 0:
                ((CTCacheFieldImpl) this.b).removeMpMap(((Integer) obj).intValue());
                break;
            case 1:
                ((CTCacheFieldsImpl) this.b).removeCacheField(((Integer) obj).intValue());
                break;
            case 2:
                ((CTCalcChainImpl) this.b).removeC(((Integer) obj).intValue());
                break;
            case 3:
                ((CTCellStyleXfsImpl) this.b).removeXf(((Integer) obj).intValue());
                break;
            case 4:
                ((CTCellWatchesImpl) this.b).removeCellWatch(((Integer) obj).intValue());
                break;
            case 5:
                ((CTCellXfsImpl) this.b).removeXf(((Integer) obj).intValue());
                break;
            case 6:
                ((CTCfRuleImpl) this.b).removeFormula(((Integer) obj).intValue());
                break;
            case 7:
                ((CTColFieldsImpl) this.b).removeField(((Integer) obj).intValue());
                break;
            case 8:
                ((CTColsImpl) this.b).removeCol(((Integer) obj).intValue());
                break;
            case 9:
                ((CTCommentListImpl) this.b).removeComment(((Integer) obj).intValue());
                break;
            case 10:
                ((CTConditionalFormattingImpl) this.b).removeCfRule(((Integer) obj).intValue());
                break;
            case 11:
                ((CTControlsImpl) this.b).removeControl(((Integer) obj).intValue());
                break;
            case 12:
                ((CTCustomPropertiesImpl) this.b).removeCustomPr(((Integer) obj).intValue());
                break;
            case 13:
                ((CTCustomSheetViewsImpl) this.b).removeCustomSheetView(((Integer) obj).intValue());
                break;
            case 14:
                ((CTCustomWorkbookViewsImpl) this.b).removeCustomWorkbookView(((Integer) obj).intValue());
                break;
            case 15:
                ((CTDataBarImpl) this.b).removeCfvo(((Integer) obj).intValue());
                break;
            case 16:
                ((CTDataFieldsImpl) this.b).removeDataField(((Integer) obj).intValue());
                break;
            case 17:
                ((CTDataValidationsImpl) this.b).removeDataValidation(((Integer) obj).intValue());
                break;
            case 18:
                ((CTDefinedNamesImpl) this.b).removeDefinedName(((Integer) obj).intValue());
                break;
            case 19:
                ((CTDxfsImpl) this.b).removeDxf(((Integer) obj).intValue());
                break;
            case 20:
                ((CTExtensionListImpl) this.b).removeExt(((Integer) obj).intValue());
                break;
            case 21:
                ((CTExternalDefinedNamesImpl) this.b).removeDefinedName(((Integer) obj).intValue());
                break;
            case 22:
                ((CTExternalReferencesImpl) this.b).removeExternalReference(((Integer) obj).intValue());
                break;
            case 23:
                ((CTExternalRowImpl) this.b).removeCell(((Integer) obj).intValue());
                break;
            case 24:
                ((CTExternalSheetDataImpl) this.b).removeRow(((Integer) obj).intValue());
                break;
            case 25:
                ((CTExternalSheetDataSetImpl) this.b).removeSheetData(((Integer) obj).intValue());
                break;
            case 26:
                ((CTExternalSheetNamesImpl) this.b).removeSheetName(((Integer) obj).intValue());
                break;
            case 27:
                ((CTFillsImpl) this.b).removeFill(((Integer) obj).intValue());
                break;
            case 28:
                ((CTFontsImpl) this.b).removeFont(((Integer) obj).intValue());
                break;
            default:
                ((CTFunctionGroupsImpl) this.b).removeFunctionGroup(((Integer) obj).intValue());
                break;
        }
    }
}
