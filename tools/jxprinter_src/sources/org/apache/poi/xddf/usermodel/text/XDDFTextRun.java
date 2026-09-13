package org.apache.poi.xddf.usermodel.text;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.apache.poi.util.k;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.poi.xddf.usermodel.XDDFFillProperties;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFSolidFillProperties;
import org.opencv.videoio.Videoio;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTextRun {
    private final XDDFTextParagraph _parent;
    private XDDFRunProperties _properties;
    private CTRegularTextRun _rtr;
    private CTTextField _tf;
    private CTTextLineBreak _tlb;

    @Internal
    public XDDFTextRun(CTTextLineBreak cTTextLineBreak, XDDFTextParagraph xDDFTextParagraph) {
        this._tlb = cTTextLineBreak;
        this._parent = xDDFTextParagraph;
    }

    private <R> Optional<R> findDefinedProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        CTTextCharacterProperties properties = getProperties();
        return (properties == null || !predicate.test(properties)) ? this._parent.findDefinedRunProperty(predicate, function) : Optional.ofNullable(function.apply(properties));
    }

    private XDDFRunProperties getOrCreateProperties() {
        if (this._properties == null) {
            if (isLineBreak()) {
                this._properties = new XDDFRunProperties(this._tlb.isSetRPr() ? this._tlb.getRPr() : this._tlb.addNewRPr());
            } else if (isField()) {
                this._properties = new XDDFRunProperties(this._tf.isSetRPr() ? this._tf.getRPr() : this._tf.addNewRPr());
            } else if (isRegularRun()) {
                this._properties = new XDDFRunProperties(this._rtr.isSetRPr() ? this._rtr.getRPr() : this._rtr.addNewRPr());
            }
        }
        return this._properties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getCharacterKerning$9(Integer num) {
        return Double.valueOf(((double) num.intValue()) * 0.01d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFFont lambda$getFonts$5(CTTextFont cTTextFont) {
        return new XDDFFont(FontGroup.COMPLEX_SCRIPT, cTTextFont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFFont lambda$getFonts$6(CTTextFont cTTextFont) {
        return new XDDFFont(FontGroup.EAST_ASIAN, cTTextFont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFFont lambda$getFonts$7(CTTextFont cTTextFont) {
        return new XDDFFont(FontGroup.LATIN, cTTextFont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFFont lambda$getFonts$8(CTTextFont cTTextFont) {
        return new XDDFFont(FontGroup.SYMBOL, cTTextFont);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isCapitals$2(STTextCapsType.Enum r6) {
        return Boolean.valueOf(r6 != STTextCapsType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isStrikeThrough$0(STTextStrikeType.Enum r6) {
        return Boolean.valueOf(r6 != STTextStrikeType.NO_STRIKE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isSubscript$3(Integer num) {
        return Boolean.valueOf(num.intValue() < 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isSuperscript$4(Integer num) {
        return Boolean.valueOf(num.intValue() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isUnderline$1(STTextUnderlineType.Enum r6) {
        return Boolean.valueOf(r6 != STTextUnderlineType.NONE);
    }

    public XDDFHyperlink createMouseOver(String str) {
        XDDFHyperlink xDDFHyperlink = new XDDFHyperlink("", str);
        getOrCreateProperties().setMouseOver(xDDFHyperlink);
        return xDDFHyperlink;
    }

    public Locale getAlternativeLanguage() {
        return (Locale) findDefinedProperty(new e(8), new d(26)).map(new d(27)).orElse(null);
    }

    public String getBookmark() {
        return (String) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(29), new d(12)).orElse(null);
    }

    public CapsType getCapitals() {
        return (CapsType) findDefinedProperty(new e(5), new d(23)).map(new f(13)).orElse(null);
    }

    public Double getCharacterKerning() {
        return (Double) findDefinedProperty(new e(0), new d(13)).map(new d(14)).orElse(null);
    }

    public Double getCharacterSpacing() {
        return (Double) findDefinedProperty(new e(14), new f(16)).map(new f(19)).map(new k(14)).orElse(null);
    }

    public Boolean getDirty() {
        return (Boolean) findDefinedProperty(new e(7), new f(2)).orElse(null);
    }

    public XDDFColor getFontColor() {
        return ((XDDFSolidFillProperties) findDefinedProperty(new e(9), new d(28)).map(new d(29)).orElse(new XDDFSolidFillProperties())).getColor();
    }

    public Double getFontSize() {
        Integer num = (Integer) findDefinedProperty(new e(3), new d(20)).orElse(Integer.valueOf(Videoio.CAP_XIAPI));
        return Double.valueOf(((double) num.intValue()) * (((double) this._parent.getParentBody().getBodyProperties().getAutoFit().getFontScale()) / 1.0E7d));
    }

    public XDDFFont[] getFonts() {
        LinkedList linkedList = new LinkedList();
        findDefinedProperty(new e(10), new f(5)).map(new f(6)).ifPresent(new org.apache.poi.sl.extractor.b(linkedList, 1));
        findDefinedProperty(new e(12), new f(7)).map(new f(8)).ifPresent(new org.apache.poi.sl.extractor.b(linkedList, 1));
        findDefinedProperty(new e(13), new f(9)).map(new f(1)).ifPresent(new org.apache.poi.sl.extractor.b(linkedList, 1));
        findDefinedProperty(new e(11), new f(3)).map(new f(4)).ifPresent(new org.apache.poi.sl.extractor.b(linkedList, 1));
        return (XDDFFont[]) linkedList.toArray(new XDDFFont[0]);
    }

    public XDDFColor getHighlight() {
        return (XDDFColor) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(24), new d(11)).map(new d(18)).orElse(null);
    }

    public XDDFHyperlink getHyperlink() {
        return (XDDFHyperlink) findDefinedProperty(new e(1), new d(15)).map(new d(5)).orElse(null);
    }

    public Locale getLanguage() {
        return (Locale) findDefinedProperty(new e(16), new f(14)).map(new d(27)).orElse(null);
    }

    public XDDFLineProperties getLineProperties() {
        return (XDDFLineProperties) findDefinedProperty(new e(18), new f(17)).map(new f(18)).orElse(null);
    }

    public XDDFHyperlink getMouseOver() {
        return (XDDFHyperlink) findDefinedProperty(new e(19), new f(20)).map(new d(5)).orElse(null);
    }

    public Boolean getNoProof() {
        return (Boolean) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(26), new d(8)).orElse(null);
    }

    public Boolean getNormalizeHeights() {
        return (Boolean) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(28), new d(10)).orElse(null);
    }

    public XDDFTextParagraph getParentParagraph() {
        return this._parent;
    }

    @Internal
    public CTTextCharacterProperties getProperties() {
        if (isLineBreak() && this._tlb.isSetRPr()) {
            return this._tlb.getRPr();
        }
        if (isField() && this._tf.isSetRPr()) {
            return this._tf.getRPr();
        }
        if (isRegularRun() && this._rtr.isSetRPr()) {
            return this._rtr.getRPr();
        }
        XDDFRunProperties defaultRunProperties = this._parent.getDefaultRunProperties();
        if (defaultRunProperties == null) {
            return null;
        }
        return defaultRunProperties.getXmlObject();
    }

    public Boolean getSpellError() {
        return (Boolean) findDefinedProperty(new e(4), new d(22)).orElse(null);
    }

    public StrikeType getStrikeThrough() {
        return (StrikeType) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(25), new d(6)).map(new d(7)).orElse(null);
    }

    public String getText() {
        if (isLineBreak()) {
            return "\n";
        }
        return isField() ? this._tf.getT() : this._rtr.getT();
    }

    public UnderlineType getUnderline() {
        return (UnderlineType) findDefinedProperty(new e(15), new f(10)).map(new f(11)).orElse(null);
    }

    public boolean isBold() {
        return ((Boolean) findDefinedProperty(new e(17), new f(15)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isCapitals() {
        return ((Boolean) findDefinedProperty(new e(5), new d(23)).map(new d(24)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isField() {
        return this._tf != null;
    }

    public boolean isItalic() {
        return ((Boolean) findDefinedProperty(new e(6), new d(25)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isKumimoji() {
        return ((Boolean) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(27), new d(9)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isLineBreak() {
        return this._tlb != null;
    }

    public boolean isRegularRun() {
        return this._rtr != null;
    }

    public boolean isStrikeThrough() {
        return ((Boolean) findDefinedProperty(new org.apache.commons.compress.archivers.tar.a(25), new d(6)).map(new f(0)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isSubscript() {
        return ((Boolean) findDefinedProperty(new e(2), new d(16)).map(new d(17)).map(new d(21)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isSuperscript() {
        return ((Boolean) findDefinedProperty(new e(2), new d(16)).map(new d(17)).map(new d(19)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean isUnderline() {
        return ((Boolean) findDefinedProperty(new e(15), new f(10)).map(new f(12)).orElse(Boolean.FALSE)).booleanValue();
    }

    public XDDFHyperlink linkToAction(String str) {
        XDDFHyperlink xDDFHyperlink = new XDDFHyperlink("", str);
        getOrCreateProperties().setHyperlink(xDDFHyperlink);
        return xDDFHyperlink;
    }

    public XDDFHyperlink linkToExternal(String str, PackagePart packagePart, POIXMLRelation pOIXMLRelation) {
        XDDFHyperlink xDDFHyperlink = new XDDFHyperlink(packagePart.addExternalRelationship(str, pOIXMLRelation.getRelation()).getId());
        getOrCreateProperties().setHyperlink(xDDFHyperlink);
        return xDDFHyperlink;
    }

    public XDDFHyperlink linkToInternal(String str, PackagePart packagePart, POIXMLRelation pOIXMLRelation, PackagePartName packagePartName) {
        XDDFHyperlink xDDFHyperlink = new XDDFHyperlink(packagePart.addRelationship(packagePartName, TargetMode.INTERNAL, pOIXMLRelation.getRelation()).getId(), str);
        getOrCreateProperties().setHyperlink(xDDFHyperlink);
        return xDDFHyperlink;
    }

    public void setAlternativeLanguage(Locale locale) {
        getOrCreateProperties().setAlternativeLanguage(locale);
    }

    public void setBaseline(Double d) {
        if (d == null) {
            getOrCreateProperties().setBaseline(null);
        } else {
            getOrCreateProperties().setBaseline(Integer.valueOf((int) (d.doubleValue() * 1000.0d)));
        }
    }

    public void setBold(Boolean bool) {
        getOrCreateProperties().setBold(bool);
    }

    public void setBookmark(String str) {
        getOrCreateProperties().setBookmark(str);
    }

    public void setCapitals(CapsType capsType) {
        getOrCreateProperties().setCapitals(capsType);
    }

    public void setCharacterKerning(Double d) {
        getOrCreateProperties().setCharacterKerning(d);
    }

    public void setCharacterSpacing(Double d) {
        getOrCreateProperties().setCharacterSpacing(d);
    }

    public void setDirty(Boolean bool) {
        getOrCreateProperties().setDirty(bool);
    }

    public void setFillProperties(XDDFFillProperties xDDFFillProperties) {
        getOrCreateProperties().setFillProperties(xDDFFillProperties);
    }

    public void setFontColor(XDDFColor xDDFColor) {
        XDDFSolidFillProperties xDDFSolidFillProperties = new XDDFSolidFillProperties();
        xDDFSolidFillProperties.setColor(xDDFColor);
        setFillProperties(xDDFSolidFillProperties);
    }

    public void setFontSize(Double d) {
        getOrCreateProperties().setFontSize(d);
    }

    public void setFonts(XDDFFont[] xDDFFontArr) {
        getOrCreateProperties().setFonts(xDDFFontArr);
    }

    public void setHighlight(XDDFColor xDDFColor) {
        getOrCreateProperties().setHighlight(xDDFColor);
    }

    public void setItalic(Boolean bool) {
        getOrCreateProperties().setItalic(bool);
    }

    public void setKumimoji(Boolean bool) {
        getOrCreateProperties().setKumimoji(bool);
    }

    public void setLanguage(Locale locale) {
        getOrCreateProperties().setLanguage(locale);
    }

    public void setLineProperties(XDDFLineProperties xDDFLineProperties) {
        getOrCreateProperties().setLineProperties(xDDFLineProperties);
    }

    public void setNoProof(Boolean bool) {
        getOrCreateProperties().setNoProof(bool);
    }

    public void setNormalizeHeights(Boolean bool) {
        getOrCreateProperties().setNormalizeHeights(bool);
    }

    public void setSpellError(Boolean bool) {
        getOrCreateProperties().setSpellError(bool);
    }

    public void setStrikeThrough(StrikeType strikeType) {
        getOrCreateProperties().setStrikeThrough(strikeType);
    }

    public void setSubscript(Double d) {
        setBaseline(d == null ? null : Double.valueOf(-Math.abs(d.doubleValue())));
    }

    public void setSuperscript(Double d) {
        setBaseline(d == null ? null : Double.valueOf(Math.abs(d.doubleValue())));
    }

    public void setText(String str) {
        if (isField()) {
            this._tf.setT(str);
        } else if (isRegularRun()) {
            this._rtr.setT(str);
        }
    }

    public void setUnderline(UnderlineType underlineType) {
        getOrCreateProperties().setUnderline(underlineType);
    }

    @Internal
    public XDDFTextRun(CTTextField cTTextField, XDDFTextParagraph xDDFTextParagraph) {
        this._tf = cTTextField;
        this._parent = xDDFTextParagraph;
    }

    @Internal
    public XDDFTextRun(CTRegularTextRun cTRegularTextRun, XDDFTextParagraph xDDFTextParagraph) {
        this._rtr = cTRegularTextRun;
        this._parent = xDDFTextParagraph;
    }
}
