package org.apache.poi.xslf.usermodel;

import java.util.function.Function;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7326a;

    public /* synthetic */ g(int i5) {
        this.f7326a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7326a) {
            case 0:
                return XSLFTextParagraph.lambda$getSpaceBefore$17((CTTextParagraphProperties) obj);
            case 1:
                return XSLFTextParagraph.lambda$setSpaceBefore$14((CTTextParagraphProperties) obj);
            case 2:
                return XSLFTextParagraph.lambda$setSpaceBefore$15((CTTextParagraphProperties) obj);
            case 3:
                return XSLFTextParagraph.lambda$setSpaceBefore$16((CTTextParagraphProperties) obj);
            case 4:
                return XSLFTextParagraph.lambda$setLineSpacing$10((CTTextParagraphProperties) obj);
            case 5:
                return XSLFTextParagraph.lambda$setLineSpacing$11((CTTextParagraphProperties) obj);
            case 6:
                return XSLFTextParagraph.lambda$setLineSpacing$12((CTTextParagraphProperties) obj);
            case 7:
                return XSLFTextParagraph.lambda$getSpaceAfter$21((CTTextParagraphProperties) obj);
            case 8:
                return XWPFDocument.lambda$registerPackagePictureData$0((Long) obj);
            case 9:
                return ((CTTblCellMar) obj).getBottom();
            case 10:
                return Boolean.valueOf(((CTTblCellMar) obj).isSetLeft());
            case 11:
                return ((CTTblCellMar) obj).getLeft();
            case 12:
                return ((CTTblCellMar) obj).addNewLeft();
            case 13:
                return Boolean.valueOf(((CTTblCellMar) obj).isSetBottom());
            case 14:
                return Boolean.valueOf(((CTTblBorders) obj).isSetInsideH());
            case 15:
                return Boolean.valueOf(((CTTblBorders) obj).isSetBottom());
            case 16:
                return Boolean.valueOf(((CTTblCellMar) obj).isSetTop());
            case 17:
                return Boolean.valueOf(((CTTblBorders) obj).isSetInsideV());
            case 18:
                return Boolean.valueOf(((CTTblBorders) obj).isSetLeft());
            case 19:
                return Boolean.valueOf(((CTTblBorders) obj).isSetTop());
            case 20:
                return Boolean.valueOf(((CTTblBorders) obj).isSetRight());
            case 21:
                return ((CTTblBorders) obj).getTop();
            case 22:
                return ((CTTblBorders) obj).addNewTop();
            case 23:
                return ((CTTblCellMar) obj).addNewBottom();
            case 24:
                return ((CTTblBorders) obj).getRight();
            case 25:
                return ((CTTblBorders) obj).addNewRight();
            case 26:
                return ((CTTblBorders) obj).getBottom();
            case 27:
                return ((CTTblBorders) obj).addNewBottom();
            case 28:
                return ((CTTblBorders) obj).getInsideV();
            default:
                return ((CTTblBorders) obj).addNewInsideV();
        }
    }
}
