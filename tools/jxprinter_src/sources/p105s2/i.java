package p105s2;

import com.microsoft.schemas.office.visio.x2012.main.impl.PagesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.ShapesTypeImpl;
import com.microsoft.schemas.office.visio.x2012.main.impl.StyleSheetsTypeImpl;
import com.microsoft.schemas.vml.impl.CTFormulasImpl;
import com.microsoft.schemas.vml.impl.CTHandlesImpl;
import java.util.function.Consumer;
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
public final /* synthetic */ class i implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8213a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ i(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f8213a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f8213a) {
            case 0:
                ((PagesTypeImpl) this.b).removePage(((Integer) obj).intValue());
                break;
            case 1:
                ((ShapesTypeImpl) this.b).removeShape(((Integer) obj).intValue());
                break;
            case 2:
                ((StyleSheetsTypeImpl) this.b).removeStyleSheet(((Integer) obj).intValue());
                break;
            case 3:
                ((CTAbstractNumImpl) this.b).removeLvl(((Integer) obj).intValue());
                break;
            case 4:
                ((CTColumnsImpl) this.b).removeCol(((Integer) obj).intValue());
                break;
            case 5:
                ((CTCommentsImpl) this.b).removeComment(((Integer) obj).intValue());
                break;
            case 6:
                ((CTCustomXmlPrImpl) this.b).removeAttr(((Integer) obj).intValue());
                break;
            case 7:
                ((CTEndnotesImpl) this.b).removeEndnote(((Integer) obj).intValue());
                break;
            case 8:
                ((CTFootnotesImpl) this.b).removeFootnote(((Integer) obj).intValue());
                break;
            case 9:
                ((CTLatentStylesImpl) this.b).removeLsdException(((Integer) obj).intValue());
                break;
            case 10:
                ((CTNumImpl) this.b).removeLvlOverride(((Integer) obj).intValue());
                break;
            case 11:
                ((CTSdtComboBoxImpl) this.b).removeListItem(((Integer) obj).intValue());
                break;
            case 12:
                ((CTSdtDropDownListImpl) this.b).removeListItem(((Integer) obj).intValue());
                break;
            case 13:
                ((CTSdtEndPrImpl) this.b).removeRPr(((Integer) obj).intValue());
                break;
            case 14:
                ((CTSmartTagPrImpl) this.b).removeAttr(((Integer) obj).intValue());
                break;
            case 15:
                ((CTStyleImpl) this.b).removeTblStylePr(((Integer) obj).intValue());
                break;
            case 16:
                ((CTStylesImpl) this.b).removeStyle(((Integer) obj).intValue());
                break;
            case 17:
                ((CTTabsImpl) this.b).removeTab(((Integer) obj).intValue());
                break;
            case 18:
                ((CTTblGridBaseImpl) this.b).removeGridCol(((Integer) obj).intValue());
                break;
            case 19:
                ((CTFormulasImpl) this.b).removeF(((Integer) obj).intValue());
                break;
            default:
                ((CTHandlesImpl) this.b).removeH(((Integer) obj).intValue());
                break;
        }
    }
}
