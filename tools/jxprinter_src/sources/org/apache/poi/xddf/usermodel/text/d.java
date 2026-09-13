package org.apache.poi.xddf.usermodel.text;

import java.util.Locale;
import java.util.function.Function;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7273a;

    public /* synthetic */ d(int i5) {
        this.f7273a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7273a) {
            case 0:
                return ((CTTextParagraphProperties) obj).getSpcBef();
            case 1:
                return ((CTTextParagraphProperties) obj).getSpcAft();
            case 2:
                return ((CTTextParagraphProperties) obj).getFontAlgn();
            case 3:
                return FontAlignment.valueOf((STTextFontAlignType.Enum) obj);
            case 4:
                return ((CTTextParagraphProperties) obj).xgetDefTabSz();
            case 5:
                return new XDDFHyperlink((CTHyperlink) obj);
            case 6:
                return ((CTTextCharacterProperties) obj).getStrike();
            case 7:
                return StrikeType.valueOf((STTextStrikeType.Enum) obj);
            case 8:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getNoProof());
            case 9:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getKumimoji());
            case 10:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getNormalizeH());
            case 11:
                return ((CTTextCharacterProperties) obj).getHighlight();
            case 12:
                return ((CTTextCharacterProperties) obj).getBmk();
            case 13:
                return Integer.valueOf(((CTTextCharacterProperties) obj).getKern());
            case 14:
                return XDDFTextRun.lambda$getCharacterKerning$9((Integer) obj);
            case 15:
                return ((CTTextCharacterProperties) obj).getHlinkClick();
            case 16:
                return ((CTTextCharacterProperties) obj).xgetBaseline();
            case 17:
                return Integer.valueOf(POIXMLUnits.parsePercent((STPercentage) obj));
            case 18:
                return XDDFColor.forColorContainer((CTColor) obj);
            case 19:
                return XDDFTextRun.lambda$isSuperscript$4((Integer) obj);
            case 20:
                return Integer.valueOf(((CTTextCharacterProperties) obj).getSz());
            case 21:
                return XDDFTextRun.lambda$isSubscript$3((Integer) obj);
            case 22:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getErr());
            case 23:
                return ((CTTextCharacterProperties) obj).getCap();
            case 24:
                return XDDFTextRun.lambda$isCapitals$2((STTextCapsType.Enum) obj);
            case 25:
                return Boolean.valueOf(((CTTextCharacterProperties) obj).getI());
            case 26:
                return ((CTTextCharacterProperties) obj).getAltLang();
            case 27:
                return Locale.forLanguageTag((String) obj);
            case 28:
                return ((CTTextCharacterProperties) obj).getSolidFill();
            default:
                return new XDDFSolidFillProperties((CTSolidColorFillProperties) obj);
        }
    }
}
