package org.apache.poi.xslf.usermodel;

import java.util.function.Consumer;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements POIXMLRelation.PackagePartConstructor, POIXMLRelation.NoArgConstructor, ParagraphPropertyFetcher.ParaPropFetcher, CharacterPropertyFetcher.CharPropFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7324a;

    public /* synthetic */ e(int i5) {
        this.f7324a = i5;
    }

    @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher.CharPropFetcher
    public void fetch(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        switch (this.f7324a) {
            case 19:
                XSLFTextRun.lambda$isStrikethrough$3(cTTextCharacterProperties, consumer);
                break;
            case 20:
                XSLFTextRun.lambda$isUnderlined$9(cTTextCharacterProperties, consumer);
                break;
            case 21:
                XSLFTextRun.lambda$isSubscript$5(cTTextCharacterProperties, consumer);
                break;
            case 22:
                XSLFTextRun.lambda$getTextCap$6(cTTextCharacterProperties, consumer);
                break;
            case 23:
                XSLFTextRun.lambda$getCharacterSpacing$2(cTTextCharacterProperties, consumer);
                break;
            case 24:
                XSLFTextRun.lambda$isItalic$8(cTTextCharacterProperties, consumer);
                break;
            case 25:
                XSLFTextRun.lambda$isBold$7(cTTextCharacterProperties, consumer);
                break;
            case 26:
                XSLFTextRun.lambda$getFontSize$1(cTTextCharacterProperties, consumer);
                break;
            default:
                XSLFTextRun.lambda$isSuperscript$4(cTTextCharacterProperties, consumer);
                break;
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.NoArgConstructor
    public POIXMLDocumentPart init() {
        switch (this.f7324a) {
            case 1:
                return new XSSFWorkbook();
            case 3:
                return new XSLFChart();
            case 5:
                return new XSLFDiagramDrawing();
            case 28:
                return new XSSFSheet();
            default:
                return new XSSFPictureData();
        }
    }

    @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher.ParaPropFetcher
    public void fetch(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        switch (this.f7324a) {
            case 6:
                XSLFTextParagraph.lambda$getLeftMargin$6(cTTextParagraphProperties, consumer);
                break;
            case 7:
                XSLFTextParagraph.lambda$getBulletCharacter$3(cTTextParagraphProperties, consumer);
                break;
            case 8:
                XSLFTextParagraph.fetchBulletFontSize(cTTextParagraphProperties, consumer);
                break;
            case 9:
                XSLFTextParagraph.lambda$getRightMargin$7(cTTextParagraphProperties, consumer);
                break;
            case 10:
                XSLFTextParagraph.lambda$getTextAlign$0(cTTextParagraphProperties, consumer);
                break;
            case 11:
                XSLFTextParagraph.fetchAutoNumberingScheme(cTTextParagraphProperties, consumer);
                break;
            case 12:
                XSLFTextParagraph.fetchTabStops(cTTextParagraphProperties, consumer);
                break;
            case 13:
                XSLFTextParagraph.lambda$getFontAlign$1(cTTextParagraphProperties, consumer);
                break;
            case 14:
                XSLFTextParagraph.lambda$getIndent$5(cTTextParagraphProperties, consumer);
                break;
            case 15:
                XSLFTextParagraph.lambda$getBulletFont$2(cTTextParagraphProperties, consumer);
                break;
            case 16:
                XSLFTextParagraph.lambda$getDefaultTabSize$8(cTTextParagraphProperties, consumer);
                break;
            case 17:
                XSLFTextParagraph.lambda$getAutoNumberingStartAt$4(cTTextParagraphProperties, consumer);
                break;
            default:
                XSLFTextParagraph.fetchIsBullet(cTTextParagraphProperties, consumer);
                break;
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.PackagePartConstructor
    public POIXMLDocumentPart init(PackagePart packagePart) {
        switch (this.f7324a) {
            case 0:
                return new XSLFTheme(packagePart);
            case 1:
            default:
                return new XSLFChart(packagePart);
            case 2:
                return new XSSFWorkbook(packagePart);
        }
    }
}
