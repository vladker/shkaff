package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.PagesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.ShapesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.StyleSheetsTypeImpl;
import com.microsoft.schemas.vml.impl.CTFormulasImpl;
import com.microsoft.schemas.vml.impl.CTHandlesImpl;
import java.util.function.Supplier;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTAbstractNumImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTColumnsImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCommentsImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTCustomXmlPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTEndnotesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTFootnotesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTLatentStylesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTNumImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtComboBoxImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtDropDownListImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtEndPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSmartTagPrImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTStyleImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTStylesImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTabsImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTTblGridBaseImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8214a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ j(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8214a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfPageArray;
        switch (this.f8214a) {
            case 0:
                iSizeOfPageArray = ((PagesTypeImpl) this.b).sizeOfPageArray();
                break;
            case 1:
                iSizeOfPageArray = ((ShapesTypeImpl) this.b).sizeOfShapeArray();
                break;
            case 2:
                iSizeOfPageArray = ((StyleSheetsTypeImpl) this.b).sizeOfStyleSheetArray();
                break;
            case 3:
                iSizeOfPageArray = ((CTAbstractNumImpl) this.b).sizeOfLvlArray();
                break;
            case 4:
                iSizeOfPageArray = ((CTColumnsImpl) this.b).sizeOfColArray();
                break;
            case 5:
                iSizeOfPageArray = ((CTCommentsImpl) this.b).sizeOfCommentArray();
                break;
            case 6:
                iSizeOfPageArray = ((CTCustomXmlPrImpl) this.b).sizeOfAttrArray();
                break;
            case 7:
                iSizeOfPageArray = ((CTEndnotesImpl) this.b).sizeOfEndnoteArray();
                break;
            case 8:
                iSizeOfPageArray = ((CTFootnotesImpl) this.b).sizeOfFootnoteArray();
                break;
            case 9:
                iSizeOfPageArray = ((CTLatentStylesImpl) this.b).sizeOfLsdExceptionArray();
                break;
            case 10:
                iSizeOfPageArray = ((CTNumImpl) this.b).sizeOfLvlOverrideArray();
                break;
            case 11:
                iSizeOfPageArray = ((CTSdtComboBoxImpl) this.b).sizeOfListItemArray();
                break;
            case 12:
                iSizeOfPageArray = ((CTSdtDropDownListImpl) this.b).sizeOfListItemArray();
                break;
            case 13:
                iSizeOfPageArray = ((CTSdtEndPrImpl) this.b).sizeOfRPrArray();
                break;
            case 14:
                iSizeOfPageArray = ((CTSmartTagPrImpl) this.b).sizeOfAttrArray();
                break;
            case 15:
                iSizeOfPageArray = ((CTStyleImpl) this.b).sizeOfTblStylePrArray();
                break;
            case 16:
                iSizeOfPageArray = ((CTStylesImpl) this.b).sizeOfStyleArray();
                break;
            case 17:
                iSizeOfPageArray = ((CTTabsImpl) this.b).sizeOfTabArray();
                break;
            case 18:
                iSizeOfPageArray = ((CTTblGridBaseImpl) this.b).sizeOfGridColArray();
                break;
            case 19:
                iSizeOfPageArray = ((CTFormulasImpl) this.b).sizeOfFArray();
                break;
            default:
                iSizeOfPageArray = ((CTHandlesImpl) this.b).sizeOfHArray();
                break;
        }
        return Integer.valueOf(iSizeOfPageArray);
    }
}
