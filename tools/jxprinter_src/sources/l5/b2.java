package l5;

import com.microsoft.schemas.compatibility.impl.AlternateContentDocumentImpl;
import java.util.function.Supplier;
import javax.crypto.SecretKey;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
import org.apache.poi.hssf.record.common.FeatFormulaErr2;
import org.apache.poi.hssf.record.common.FeatSmartTag;
import org.apache.poi.ss.formula.Formula;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableImpl;
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
public final /* synthetic */ class b2 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5981a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b2(Object obj, int i5) {
        this.f5981a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f5981a) {
            case 0:
                return Integer.valueOf(((CTTableImpl) this.b).sizeOfTrArray());
            case 1:
                return Integer.valueOf(((CTTableRowImpl) this.b).sizeOfTcArray());
            case 2:
                return Integer.valueOf(((CTTableStyleListImpl) this.b).sizeOfTblStyleArray());
            case 3:
                return Integer.valueOf(((CTTextBodyImpl) this.b).sizeOfPArray());
            case 4:
                return Integer.valueOf(((CTTextTabStopListImpl) this.b).sizeOfTabArray());
            case 5:
                return Integer.valueOf(((CTPropertiesImpl) this.b).sizeOfPropertyArray());
            case 6:
                return ((ClassID) this.b).toString();
            case 7:
                return Integer.valueOf(((MissingRowDummyRecord) this.b).getRowNumber());
            case 8:
                return Integer.valueOf(((FeatFormulaErr2) this.b)._getRawErrorCheckValue());
            case 9:
                return ((FeatSmartTag) this.b).lambda$getGenericProperties$0();
            case 10:
                return ((SecretKey) this.b).getEncoded();
            case 11:
                return ((Formula) this.b).getExpReference();
            case 12:
                return Integer.valueOf(((AlternateContentDocumentImpl.AlternateContentImpl) this.b).sizeOfChoiceArray());
            case 13:
                return Integer.valueOf(((CTDImpl) this.b).sizeOfEArray());
            case 14:
                return Integer.valueOf(((CTMCSImpl) this.b).sizeOfMcArray());
            case 15:
                return Integer.valueOf(((CTMImpl) this.b).sizeOfMrArray());
            case 16:
                return Integer.valueOf(((CTMRImpl) this.b).sizeOfEArray());
            case 17:
                return Integer.valueOf(((CTOMathParaImpl) this.b).sizeOfOMathArray());
            case 18:
                return Integer.valueOf(((CTCommentAuthorListImpl) this.b).sizeOfCmAuthorArray());
            case 19:
                return Integer.valueOf(((CTCommentListImpl) this.b).sizeOfCmArray());
            case 20:
                return Integer.valueOf(((CTCustomerDataListImpl) this.b).sizeOfCustDataArray());
            case 21:
                return Integer.valueOf(((CTEmbeddedFontListImpl) this.b).sizeOfEmbeddedFontArray());
            case 22:
                return Integer.valueOf(((CTExtensionListImpl) this.b).sizeOfExtArray());
            case 23:
                return Integer.valueOf(((CTSlideIdListImpl) this.b).sizeOfSldIdArray());
            case 24:
                return Integer.valueOf(((CTSlideMasterIdListImpl) this.b).sizeOfSldMasterIdArray());
            case 25:
                return Integer.valueOf(((CTTLTimeConditionListImpl) this.b).sizeOfCondArray());
            case 26:
                return Integer.valueOf(((CTAuthorsImpl) this.b).sizeOfAuthorArray());
            case 27:
                return Integer.valueOf(((CTAutoFilterImpl) this.b).sizeOfFilterColumnArray());
            case 28:
                return Integer.valueOf(((CTBookViewsImpl) this.b).sizeOfWorkbookViewArray());
            default:
                return Integer.valueOf(((CTBordersImpl) this.b).sizeOfBorderArray());
        }
    }
}
