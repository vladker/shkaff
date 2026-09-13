package l5;

import com.microsoft.schemas.compatibility.AlternateContentDocument;
import com.microsoft.schemas.compatibility.impl.AlternateContentDocumentImpl;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.function.BiConsumer;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextBodyImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTextTabStopListImpl;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.impl.CTPropertiesImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMC;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTDImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMCSImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMRImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathParaImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmbeddedFontListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtension;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCommentAuthorListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTCommentListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTEmbeddedFontListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTExtensionListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideIdListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTSlideMasterIdListImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTLTimeConditionListImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellWatch;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXf;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTBookViewsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTBordersImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCacheFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCalcChainImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellStyleXfsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellWatchesImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCellXfsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColFieldsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColsImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTConditionalFormattingImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTControlsImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class g2 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6001a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g2(Object obj, int i5) {
        this.f6001a = i5;
        this.b = obj;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f6001a) {
            case 0:
                ((CTTextBodyImpl) this.b).setPArray(((Integer) obj).intValue(), (CTTextParagraph) obj2);
                break;
            case 1:
                ((CTTextTabStopListImpl) this.b).setTabArray(((Integer) obj).intValue(), (CTTextTabStop) obj2);
                break;
            case 2:
                ((CTPropertiesImpl) this.b).setPropertyArray(((Integer) obj).intValue(), (CTProperty) obj2);
                break;
            case 3:
                ((HttpURLConnection) this.b).setRequestProperty((String) obj, (String) obj2);
                break;
            case 4:
                XSSFCreationHelper.lambda$createFormulaEvaluator$0((HashMap) this.b, (String) obj, (Workbook) obj2);
                break;
            case 5:
                ((AlternateContentDocumentImpl.AlternateContentImpl) this.b).setChoiceArray(((Integer) obj).intValue(), (AlternateContentDocument.AlternateContent.Choice) obj2);
                break;
            case 6:
                ((CTDImpl) this.b).setEArray(((Integer) obj).intValue(), (CTOMathArg) obj2);
                break;
            case 7:
                ((CTMCSImpl) this.b).setMcArray(((Integer) obj).intValue(), (CTMC) obj2);
                break;
            case 8:
                ((CTMImpl) this.b).setMrArray(((Integer) obj).intValue(), (CTMR) obj2);
                break;
            case 9:
                ((CTMRImpl) this.b).setEArray(((Integer) obj).intValue(), (CTOMathArg) obj2);
                break;
            case 10:
                ((CTOMathParaImpl) this.b).setOMathArray(((Integer) obj).intValue(), (CTOMath) obj2);
                break;
            case 11:
                ((CTCommentAuthorListImpl) this.b).setCmAuthorArray(((Integer) obj).intValue(), (CTCommentAuthor) obj2);
                break;
            case 12:
                ((CTCommentListImpl) this.b).setCmArray(((Integer) obj).intValue(), (CTComment) obj2);
                break;
            case 13:
                ((CTEmbeddedFontListImpl) this.b).setEmbeddedFontArray(((Integer) obj).intValue(), (CTEmbeddedFontListEntry) obj2);
                break;
            case 14:
                ((CTExtensionListImpl) this.b).setExtArray(((Integer) obj).intValue(), (CTExtension) obj2);
                break;
            case 15:
                ((CTSlideIdListImpl) this.b).setSldIdArray(((Integer) obj).intValue(), (CTSlideIdListEntry) obj2);
                break;
            case 16:
                ((CTSlideMasterIdListImpl) this.b).setSldMasterIdArray(((Integer) obj).intValue(), (CTSlideMasterIdListEntry) obj2);
                break;
            case 17:
                ((CTTLTimeConditionListImpl) this.b).setCondArray(((Integer) obj).intValue(), (CTTLTimeCondition) obj2);
                break;
            case 18:
                ((CTBookViewsImpl) this.b).setWorkbookViewArray(((Integer) obj).intValue(), (CTBookView) obj2);
                break;
            case 19:
                ((CTBordersImpl) this.b).setBorderArray(((Integer) obj).intValue(), (CTBorder) obj2);
                break;
            case 20:
                ((CTCacheFieldsImpl) this.b).setCacheFieldArray(((Integer) obj).intValue(), (CTCacheField) obj2);
                break;
            case 21:
                ((CTCalcChainImpl) this.b).setCArray(((Integer) obj).intValue(), (CTCalcCell) obj2);
                break;
            case 22:
                ((CTCellStyleXfsImpl) this.b).setXfArray(((Integer) obj).intValue(), (CTXf) obj2);
                break;
            case 23:
                ((CTCellWatchesImpl) this.b).setCellWatchArray(((Integer) obj).intValue(), (CTCellWatch) obj2);
                break;
            case 24:
                ((CTCellXfsImpl) this.b).setXfArray(((Integer) obj).intValue(), (CTXf) obj2);
                break;
            case 25:
                ((CTColFieldsImpl) this.b).setFieldArray(((Integer) obj).intValue(), (CTField) obj2);
                break;
            case 26:
                ((CTColsImpl) this.b).setColArray(((Integer) obj).intValue(), (CTCol) obj2);
                break;
            case 27:
                ((org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTCommentListImpl) this.b).setCommentArray(((Integer) obj).intValue(), (org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment) obj2);
                break;
            case 28:
                ((CTConditionalFormattingImpl) this.b).setCfRuleArray(((Integer) obj).intValue(), (CTCfRule) obj2);
                break;
            default:
                ((CTControlsImpl) this.b).setControlArray(((Integer) obj).intValue(), (CTControl) obj2);
                break;
        }
    }
}
