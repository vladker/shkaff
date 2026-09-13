package l5;

import com.microsoft.schemas.compatibility.impl.AlternateContentDocumentImpl;
import java.io.IOException;
import java.util.BitSet;
import java.util.function.Consumer;
import org.apache.poi.poifs.crypt.dsig.services.RevocationData;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableRowImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableStyleListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextBodyImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextTabStopListImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.CTPropertiesImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTDImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMCSImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMRImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathParaImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCommentAuthorListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCommentListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCustomerDataListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTEmbeddedFontListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTExtensionListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideIdListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideMasterIdListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTLTimeConditionListImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTAuthorsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTAutoFilterImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTBookViewsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTBordersImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class d2 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5989a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d2(Object obj, int i5) {
        this.f5989a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5989a) {
            case 0:
                ((CTTableRowImpl) this.b).removeTc(((Integer) obj).intValue());
                break;
            case 1:
                ((CTTableStyleListImpl) this.b).removeTblStyle(((Integer) obj).intValue());
                break;
            case 2:
                ((CTTextBodyImpl) this.b).removeP(((Integer) obj).intValue());
                break;
            case 3:
                ((CTTextTabStopListImpl) this.b).removeTab(((Integer) obj).intValue());
                break;
            case 4:
                ((CTPropertiesImpl) this.b).removeProperty(((Integer) obj).intValue());
                break;
            case 5:
                ((Exception) this.b).addSuppressed((IOException) obj);
                break;
            case 6:
                ((IOException) this.b).addSuppressed((IOException) obj);
                break;
            case 7:
                ((RevocationData) this.b).addCRL((byte[]) obj);
                break;
            case 8:
                SlideShowExtractor.lambda$null$3((BitSet) this.b, (String) obj);
                break;
            case 9:
                SlideShowExtractor.lambda$null$6((V2.f) this.b, (String) obj);
                break;
            case 10:
                ((CharacterPropertyFetcher) this.b).setValue(obj);
                break;
            case 11:
                ((ParagraphPropertyFetcher) this.b).setValue(obj);
                break;
            case 12:
                ((AlternateContentDocumentImpl.AlternateContentImpl) this.b).removeChoice(((Integer) obj).intValue());
                break;
            case 13:
                ((CTDImpl) this.b).removeE(((Integer) obj).intValue());
                break;
            case 14:
                ((CTMCSImpl) this.b).removeMc(((Integer) obj).intValue());
                break;
            case 15:
                ((CTMImpl) this.b).removeMr(((Integer) obj).intValue());
                break;
            case 16:
                ((CTMRImpl) this.b).removeE(((Integer) obj).intValue());
                break;
            case 17:
                ((CTOMathParaImpl) this.b).removeOMath(((Integer) obj).intValue());
                break;
            case 18:
                ((CTCommentAuthorListImpl) this.b).removeCmAuthor(((Integer) obj).intValue());
                break;
            case 19:
                ((CTCommentListImpl) this.b).removeCm(((Integer) obj).intValue());
                break;
            case 20:
                ((CTCustomerDataListImpl) this.b).removeCustData(((Integer) obj).intValue());
                break;
            case 21:
                ((CTEmbeddedFontListImpl) this.b).removeEmbeddedFont(((Integer) obj).intValue());
                break;
            case 22:
                ((CTExtensionListImpl) this.b).removeExt(((Integer) obj).intValue());
                break;
            case 23:
                ((CTSlideIdListImpl) this.b).removeSldId(((Integer) obj).intValue());
                break;
            case 24:
                ((CTSlideMasterIdListImpl) this.b).removeSldMasterId(((Integer) obj).intValue());
                break;
            case 25:
                ((CTTLTimeConditionListImpl) this.b).removeCond(((Integer) obj).intValue());
                break;
            case 26:
                ((CTAuthorsImpl) this.b).removeAuthor(((Integer) obj).intValue());
                break;
            case 27:
                ((CTAutoFilterImpl) this.b).removeFilterColumn(((Integer) obj).intValue());
                break;
            case 28:
                ((CTBookViewsImpl) this.b).removeWorkbookView(((Integer) obj).intValue());
                break;
            default:
                ((CTBordersImpl) this.b).removeBorder(((Integer) obj).intValue());
                break;
        }
    }
}
