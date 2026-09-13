package org.apache.poi.xddf.usermodel.text;

import java.util.function.Function;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xslf.usermodel.XSLFDiagram;
import org.apache.poi.xslf.usermodel.XSLFPlaceholderDetails;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7275a;

    public /* synthetic */ f(int i5) {
        this.f7275a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7275a) {
            case 0:
                return XDDFTextRun.lambda$isStrikeThrough$0((STTextStrikeType.Enum) obj);
            case 1:
                return XDDFTextRun.lambda$getFonts$7((CTTextFont) obj);
            case 2:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getDirty());
            case 3:
                return ((CTTextCharacterProperties) obj).getSym();
            case 4:
                return XDDFTextRun.lambda$getFonts$8((CTTextFont) obj);
            case 5:
                return ((CTTextCharacterProperties) obj).getCs();
            case 6:
                return XDDFTextRun.lambda$getFonts$5((CTTextFont) obj);
            case 7:
                return ((CTTextCharacterProperties) obj).getEa();
            case 8:
                return XDDFTextRun.lambda$getFonts$6((CTTextFont) obj);
            case 9:
                return ((CTTextCharacterProperties) obj).getLatin();
            case 10:
                return ((CTTextCharacterProperties) obj).getU();
            case 11:
                return UnderlineType.valueOf((STTextUnderlineType.Enum) obj);
            case 12:
                return XDDFTextRun.lambda$isUnderline$1((STTextUnderlineType.Enum) obj);
            case 13:
                return CapsType.valueOf((STTextCapsType.Enum) obj);
            case 14:
                return ((CTTextCharacterProperties) obj).getLang();
            case 15:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getB());
            case 16:
                return ((CTTextCharacterProperties) obj).xgetSpc();
            case 17:
                return ((CTTextCharacterProperties) obj).getLn();
            case 18:
                return new XDDFLineProperties((CTLineProperties) obj);
            case 19:
                return Long.valueOf(POIXMLUnits.parseLength((STTextPoint) obj));
            case 20:
                return ((CTTextCharacterProperties) obj).getHlinkMouseOver();
            case 21:
                return XSLFDiagram.lambda$hasTextContent$0((CTTextParagraph) obj);
            case 22:
                return XSLFPlaceholderDetails.lambda$setVisible$0((CTHeaderFooter) obj);
            case 23:
                return XSLFPlaceholderDetails.lambda$setVisible$1((CTHeaderFooter) obj);
            case 24:
                return XSLFPlaceholderDetails.lambda$setVisible$2((CTHeaderFooter) obj);
            case 25:
                return XSLFPlaceholderDetails.lambda$setVisible$3((CTHeaderFooter) obj);
            case 26:
                return XSLFTextParagraph.lambda$setSpaceAfter$18((CTTextParagraphProperties) obj);
            case 27:
                return XSLFTextParagraph.lambda$setSpaceAfter$19((CTTextParagraphProperties) obj);
            case 28:
                return XSLFTextParagraph.lambda$setSpaceAfter$20((CTTextParagraphProperties) obj);
            default:
                return XSLFTextParagraph.lambda$getLineSpacing$13((CTTextParagraphProperties) obj);
        }
    }
}
