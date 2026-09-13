package org.apache.poi.xslf.usermodel;

import com.google.common.primitives.UnsignedBytes;
import java.awt.Color;
import java.util.function.Consumer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.common.usermodel.fonts.FontCharset;
import org.apache.poi.common.usermodel.fonts.FontFamily;
import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.common.usermodel.fonts.FontInfo;
import org.apache.poi.common.usermodel.fonts.FontPitch;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.TextRun;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.CharacterPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontCollection;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTextRun implements TextRun {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XSLFTextRun.class);
    private final XSLFTextParagraph _p;
    private final XmlObject _r;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTextRun$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup;

        static {
            int[] iArr = new int[FontGroup.values().length];
            $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup = iArr;
            try {
                iArr[FontGroup.LATIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.EAST_ASIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.COMPLEX_SCRIPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.SYMBOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class XSLFFontInfo implements FontInfo {
        private final FontGroup fontGroup;

        public /* synthetic */ XSLFFontInfo(XSLFTextRun xSLFTextRun, FontGroup fontGroup, AnonymousClass1 anonymousClass1) {
            this(fontGroup);
        }

        private CTTextFont getCTTextFont(CTTextCharacterProperties cTTextCharacterProperties, boolean z6) {
            CTTextFont ea;
            CTTextFont cs;
            if (cTTextCharacterProperties == null) {
                return null;
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[this.fontGroup.ordinal()];
            if (i5 == 2) {
                ea = cTTextCharacterProperties.getEa();
                if (ea == null && z6) {
                    ea = cTTextCharacterProperties.addNewEa();
                }
            } else if (i5 == 3) {
                ea = cTTextCharacterProperties.getCs();
                if (ea == null && z6) {
                    ea = cTTextCharacterProperties.addNewCs();
                }
            } else if (i5 != 4) {
                ea = cTTextCharacterProperties.getLatin();
                if (ea == null && z6) {
                    ea = cTTextCharacterProperties.addNewLatin();
                }
            } else {
                ea = cTTextCharacterProperties.getSym();
                if (ea == null && z6) {
                    ea = cTTextCharacterProperties.addNewSym();
                }
            }
            if (ea == null) {
                return null;
            }
            String typeface = ea.getTypeface();
            if (typeface == null) {
                typeface = "";
            }
            if (!typeface.startsWith("+mj-") && !typeface.startsWith("+mn-")) {
                return ea;
            }
            CTFontScheme fontScheme = XSLFTextRun.this._p.getParentShape().getSheet().getTheme().getXmlObject().getThemeElements().getFontScheme();
            CTFontCollection majorFont = typeface.startsWith("+mj-") ? fontScheme.getMajorFont() : fontScheme.getMinorFont();
            String strSubstring = typeface.substring(4);
            if ("ea".equals(strSubstring)) {
                cs = majorFont.getEa();
            } else {
                cs = "cs".equals(strSubstring) ? majorFont.getCs() : majorFont.getLatin();
            }
            if (cs == null || cs.getTypeface() == null || "".equals(cs.getTypeface())) {
                return null;
            }
            return cs;
        }

        private CTTextFont getXmlObject(boolean z6) {
            return z6 ? getCTTextFont(XSLFTextRun.this.getRPr(true), true) : (CTTextFont) XSLFTextRun.this.fetchCharacterProperty(new k(this, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$getXmlObject$0(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
            CTTextFont cTTextFont = getCTTextFont(cTTextCharacterProperties, false);
            if (cTTextFont != null) {
                consumer.accept(cTTextFont);
            }
        }

        public void copyFrom(FontInfo fontInfo) {
            CTTextFont xmlObject = getXmlObject(true);
            if (xmlObject == null) {
                return;
            }
            setTypeface(fontInfo.getTypeface());
            setCharset(fontInfo.getCharset());
            FontPitch pitch = fontInfo.getPitch();
            FontFamily family = fontInfo.getFamily();
            if (pitch != null || family != null) {
                setPitch(pitch);
                setFamily(family);
            } else if (xmlObject.isSetPitchFamily()) {
                xmlObject.unsetPitchFamily();
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontCharset getCharset() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetCharset()) {
                return null;
            }
            return FontCharset.valueOf(xmlObject.getCharset() & UnsignedBytes.MAX_VALUE);
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontFamily getFamily() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetPitchFamily()) {
                return null;
            }
            return FontFamily.valueOfPitchFamily(xmlObject.getPitchFamily());
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public FontPitch getPitch() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject == null || !xmlObject.isSetPitchFamily()) {
                return null;
            }
            return FontPitch.valueOfPitchFamily(xmlObject.getPitchFamily());
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public String getTypeface() {
            CTTextFont xmlObject = getXmlObject(false);
            if (xmlObject != null) {
                return xmlObject.getTypeface();
            }
            return null;
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setCharset(FontCharset fontCharset) {
            CTTextFont xmlObject = getXmlObject(true);
            if (xmlObject == null) {
                return;
            }
            if (fontCharset != null) {
                xmlObject.setCharset((byte) fontCharset.getNativeId());
            } else if (xmlObject.isSetCharset()) {
                xmlObject.unsetCharset();
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setFamily(FontFamily fontFamily) {
            CTTextFont xmlObject = getXmlObject(true);
            if (xmlObject != null) {
                if (fontFamily != null || xmlObject.isSetPitchFamily()) {
                    FontPitch fontPitchValueOfPitchFamily = xmlObject.isSetPitchFamily() ? FontPitch.valueOfPitchFamily(xmlObject.getPitchFamily()) : FontPitch.VARIABLE;
                    if (fontFamily == null) {
                        fontFamily = FontFamily.FF_SWISS;
                    }
                    xmlObject.setPitchFamily(FontPitch.getNativeId(fontPitchValueOfPitchFamily, fontFamily));
                }
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setPitch(FontPitch fontPitch) {
            CTTextFont xmlObject = getXmlObject(true);
            if (xmlObject != null) {
                if (fontPitch != null || xmlObject.isSetPitchFamily()) {
                    FontFamily fontFamilyValueOfPitchFamily = xmlObject.isSetPitchFamily() ? FontFamily.valueOfPitchFamily(xmlObject.getPitchFamily()) : FontFamily.FF_SWISS;
                    if (fontPitch == null) {
                        fontPitch = FontPitch.VARIABLE;
                    }
                    xmlObject.setPitchFamily(FontPitch.getNativeId(fontPitch, fontFamilyValueOfPitchFamily));
                }
            }
        }

        @Override // org.apache.poi.common.usermodel.fonts.FontInfo
        public void setTypeface(String str) {
            if (str != null) {
                CTTextFont xmlObject = getXmlObject(true);
                if (xmlObject != null) {
                    xmlObject.setTypeface(str);
                    return;
                }
                return;
            }
            CTTextCharacterProperties rPr = XSLFTextRun.this.getRPr(false);
            if (rPr == null) {
                return;
            }
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$common$usermodel$fonts$FontGroup[FontGroup.getFontGroupFirst(XSLFTextRun.this.getRawText()).ordinal()];
            if (i5 == 2) {
                if (rPr.isSetEa()) {
                    rPr.unsetEa();
                }
            } else if (i5 == 3) {
                if (rPr.isSetCs()) {
                    rPr.unsetCs();
                }
            } else if (i5 != 4) {
                if (rPr.isSetLatin()) {
                    rPr.unsetLatin();
                }
            } else if (rPr.isSetSym()) {
                rPr.unsetSym();
            }
        }

        private XSLFFontInfo(FontGroup fontGroup) {
            this.fontGroup = fontGroup == null ? FontGroup.getFontGroupFirst(XSLFTextRun.this.getRawText()) : fontGroup;
        }
    }

    public XSLFTextRun(XmlObject xmlObject, XSLFTextParagraph xSLFTextParagraph) {
        this._r = xmlObject;
        this._p = xSLFTextParagraph;
        if ((xmlObject instanceof CTRegularTextRun) || (xmlObject instanceof CTTextLineBreak) || (xmlObject instanceof CTTextField)) {
            return;
        }
        throw new OpenXML4JRuntimeException("unsupported text run of type " + xmlObject.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T fetchCharacterProperty(CharacterPropertyFetcher.CharPropFetcher<T> charPropFetcher) {
        return (T) new CharacterPropertyFetcher(this, charPropFetcher).fetchProperty(this._p.getParentShape());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchFontColor(CTTextCharacterProperties cTTextCharacterProperties, Consumer<PaintStyle> consumer, XSLFShape xSLFShape, boolean z6) {
        if (cTTextCharacterProperties == null) {
            return;
        }
        CTShapeStyle spStyle = xSLFShape.getSpStyle();
        CTSchemeColor schemeClr = (spStyle == null || spStyle.getFontRef() == null) ? null : spStyle.getFontRef().getSchemeClr();
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(cTTextCharacterProperties);
        XSLFSheet sheet = xSLFShape.getSheet();
        PaintStyle paintStyleSelectPaint = xSLFShape.selectPaint(fillDelegate, schemeClr, sheet.getPackagePart(), sheet.getTheme(), z6);
        if (paintStyleSelectPaint != null) {
            consumer.accept(paintStyleSelectPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getCharacterSpacing$2(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetSpc()) {
            consumer.accept(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextCharacterProperties.xgetSpc()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getFontSize$1(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetSz()) {
            consumer.accept(Double.valueOf(((double) cTTextCharacterProperties.getSz()) * 0.01d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getTextCap$6(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetCap()) {
            consumer.accept(TextRun.TextCap.values()[cTTextCharacterProperties.getCap().intValue() - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isBold$7(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetB()) {
            consumer.accept(Boolean.valueOf(cTTextCharacterProperties.getB()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isItalic$8(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetI()) {
            consumer.accept(Boolean.valueOf(cTTextCharacterProperties.getI()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isStrikethrough$3(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetStrike()) {
            consumer.accept(Boolean.valueOf(cTTextCharacterProperties.getStrike() != STTextStrikeType.NO_STRIKE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isSubscript$5(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetBaseline()) {
            consumer.accept(Boolean.valueOf(POIXMLUnits.parsePercent(cTTextCharacterProperties.xgetBaseline()) < 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isSuperscript$4(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetBaseline()) {
            consumer.accept(Boolean.valueOf(POIXMLUnits.parsePercent(cTTextCharacterProperties.xgetBaseline()) > 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isUnderlined$9(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
        if (cTTextCharacterProperties.isSetU()) {
            consumer.accept(Boolean.valueOf(cTTextCharacterProperties.getU() != STTextUnderlineType.NONE));
        }
    }

    public void copy(XSLFTextRun xSLFTextRun) {
        String fontFamily = xSLFTextRun.getFontFamily();
        if (fontFamily != null && !fontFamily.equals(getFontFamily())) {
            setFontFamily(fontFamily);
        }
        PaintStyle fontColor = xSLFTextRun.getFontColor();
        if (fontColor != null && !fontColor.equals(getFontColor())) {
            setFontColor(fontColor);
        }
        Double fontSize = xSLFTextRun.getFontSize();
        if (fontSize == null) {
            if (getFontSize() != null) {
                setFontSize(null);
            }
        } else if (!fontSize.equals(getFontSize())) {
            setFontSize(fontSize);
        }
        boolean zIsBold = xSLFTextRun.isBold();
        if (zIsBold != isBold()) {
            setBold(zIsBold);
        }
        boolean zIsItalic = xSLFTextRun.isItalic();
        if (zIsItalic != isItalic()) {
            setItalic(zIsItalic);
        }
        boolean zIsUnderlined = xSLFTextRun.isUnderlined();
        if (zIsUnderlined != isUnderlined()) {
            setUnderlined(zIsUnderlined);
        }
        boolean zIsStrikethrough = xSLFTextRun.isStrikethrough();
        if (zIsStrikethrough != isStrikethrough()) {
            setStrikethrough(zIsStrikethrough);
        }
        XSLFHyperlink hyperlink = xSLFTextRun.getHyperlink();
        if (hyperlink != null) {
            getHyperlink().copy(hyperlink);
        }
    }

    public double getCharacterSpacing() {
        Double d = (Double) fetchCharacterProperty(new e(23));
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public TextRun.FieldType getFieldType() {
        XmlObject xmlObject = this._r;
        if ((xmlObject instanceof CTTextField) && "slidenum".equals(((CTTextField) xmlObject).getType())) {
            return TextRun.FieldType.SLIDE_NUMBER;
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public PaintStyle getFontColor() {
        final XSLFTextShape parentShape = getParagraph().getParentShape();
        final boolean z6 = parentShape.getPlaceholder() != null;
        return (PaintStyle) fetchCharacterProperty(new CharacterPropertyFetcher.CharPropFetcher() { // from class: org.apache.poi.xslf.usermodel.j
            @Override // org.apache.poi.xslf.model.CharacterPropertyFetcher.CharPropFetcher
            public final void fetch(CTTextCharacterProperties cTTextCharacterProperties, Consumer consumer) {
                XSLFTextRun.fetchFontColor(cTTextCharacterProperties, consumer, parentShape, z6);
            }
        });
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getFontFamily() {
        return new XSLFFontInfo(this, FontGroup.getFontGroupFirst(getRawText()), null).getTypeface();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public FontInfo getFontInfo(FontGroup fontGroup) {
        XSLFFontInfo xSLFFontInfo = new XSLFFontInfo(this, fontGroup, null);
        if (xSLFFontInfo.getTypeface() != null) {
            return xSLFFontInfo;
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public Double getFontSize() {
        CTTextBodyProperties textBodyPr;
        CTTextNormalAutofit normAutofit;
        XSLFTextShape parentShape = getParagraph().getParentShape();
        double percent = (parentShape == null || (textBodyPr = parentShape.getTextBodyPr()) == null || (normAutofit = textBodyPr.getNormAutofit()) == null || !normAutofit.isSetFontScale()) ? 1.0d : ((double) POIXMLUnits.parsePercent(normAutofit.xgetFontScale())) / 100000.0d;
        Double d = (Double) fetchCharacterProperty(new e(26));
        if (d == null) {
            return null;
        }
        return Double.valueOf(d.doubleValue() * percent);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public byte getPitchAndFamily() {
        XSLFFontInfo xSLFFontInfo = new XSLFFontInfo(this, FontGroup.getFontGroupFirst(getRawText()), null);
        FontPitch pitch = xSLFFontInfo.getPitch();
        if (pitch == null) {
            pitch = FontPitch.VARIABLE;
        }
        FontFamily family = xSLFFontInfo.getFamily();
        if (family == null) {
            family = FontFamily.FF_SWISS;
        }
        return FontPitch.getNativeId(pitch, family);
    }

    @Internal
    public CTTextCharacterProperties getRPr(boolean z6) {
        XmlObject xmlObject = this._r;
        if (xmlObject instanceof CTTextField) {
            CTTextField cTTextField = (CTTextField) xmlObject;
            if (cTTextField.isSetRPr()) {
                return cTTextField.getRPr();
            }
            if (z6) {
                return cTTextField.addNewRPr();
            }
        } else if (xmlObject instanceof CTTextLineBreak) {
            CTTextLineBreak cTTextLineBreak = (CTTextLineBreak) xmlObject;
            if (cTTextLineBreak.isSetRPr()) {
                return cTTextLineBreak.getRPr();
            }
            if (z6) {
                return cTTextLineBreak.addNewRPr();
            }
        } else {
            CTRegularTextRun cTRegularTextRun = (CTRegularTextRun) xmlObject;
            if (cTRegularTextRun.isSetRPr()) {
                return cTRegularTextRun.getRPr();
            }
            if (z6) {
                return cTRegularTextRun.addNewRPr();
            }
        }
        if (this._p.getXmlObject().isSetPPr() && this._p.getXmlObject().getPPr().isSetDefRPr()) {
            return this._p.getXmlObject().getPPr().getDefRPr();
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getRawText() {
        XmlObject xmlObject = this._r;
        if (xmlObject instanceof CTTextField) {
            return ((CTTextField) xmlObject).getT();
        }
        return xmlObject instanceof CTTextLineBreak ? "\n" : ((CTRegularTextRun) xmlObject).getT();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public TextRun.TextCap getTextCap() {
        TextRun.TextCap textCap = (TextRun.TextCap) fetchCharacterProperty(new e(22));
        return textCap == null ? TextRun.TextCap.NONE : textCap;
    }

    @Internal
    public XmlObject getXmlObject() {
        return this._r;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isBold() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(25));
        return bool != null && bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isItalic() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(24));
        return bool != null && bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isStrikethrough() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(19));
        return bool != null && bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isSubscript() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(21));
        return bool != null && bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isSuperscript() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(27));
        return bool != null && bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public boolean isUnderlined() {
        Boolean bool = (Boolean) fetchCharacterProperty(new e(20));
        return bool != null && bool.booleanValue();
    }

    public void setBaselineOffset(double d) {
        getRPr(true).setBaseline(Integer.valueOf(((int) d) * 1000));
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setBold(boolean z6) {
        getRPr(true).setB(z6);
    }

    public void setCharacterSpacing(double d) {
        CTTextCharacterProperties rPr = getRPr(true);
        if (d != 0.0d) {
            rPr.setSpc(Integer.valueOf((int) (d * 100.0d)));
        } else if (rPr.isSetSpc()) {
            rPr.unsetSpc();
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontColor(Color color) {
        setFontColor(DrawPaint.createSolidPaint(color));
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontFamily(String str) {
        new XSLFFontInfo(this, FontGroup.getFontGroupFirst(getRawText()), null).setTypeface(str);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontInfo(FontInfo fontInfo, FontGroup fontGroup) {
        new XSLFFontInfo(this, fontGroup, null).copyFrom(fontInfo);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontSize(Double d) {
        CTTextCharacterProperties rPr = getRPr(true);
        if (d == null) {
            if (rPr.isSetSz()) {
                rPr.unsetSz();
            }
        } else if (d.doubleValue() >= 1.0d) {
            rPr.setSz((int) (d.doubleValue() * 100.0d));
        } else {
            throw new IllegalArgumentException("Minimum font size is 1pt but was " + d);
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setItalic(boolean z6) {
        getRPr(true).setI(z6);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setStrikethrough(boolean z6) {
        getRPr(true).setStrike(z6 ? STTextStrikeType.SNG_STRIKE : STTextStrikeType.NO_STRIKE);
    }

    public void setSubscript(boolean z6) {
        setBaselineOffset(z6 ? -25.0d : 0.0d);
    }

    public void setSuperscript(boolean z6) {
        setBaselineOffset(z6 ? 30.0d : 0.0d);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setText(String str) {
        XmlObject xmlObject = this._r;
        if (xmlObject instanceof CTTextField) {
            ((CTTextField) xmlObject).setT(str);
        } else {
            if (xmlObject instanceof CTTextLineBreak) {
                return;
            }
            ((CTRegularTextRun) xmlObject).setT(str);
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setUnderlined(boolean z6) {
        getRPr(true).setU(z6 ? STTextUnderlineType.SNG : STTextUnderlineType.NONE);
    }

    public String toString() {
        return "[" + getClass() + "]" + getRawText();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public XSLFHyperlink createHyperlink() {
        XSLFHyperlink hyperlink = getHyperlink();
        return hyperlink != null ? hyperlink : new XSLFHyperlink(getRPr(true).addNewHlinkClick(), this._p.getParentShape().getSheet());
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public XSLFHyperlink getHyperlink() {
        CTHyperlink hlinkClick;
        CTTextCharacterProperties rPr = getRPr(false);
        if (rPr == null || (hlinkClick = rPr.getHlinkClick()) == null) {
            return null;
        }
        return new XSLFHyperlink(hlinkClick, this._p.getParentShape().getSheet());
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public XSLFTextParagraph getParagraph() {
        return this._p;
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontColor(PaintStyle paintStyle) {
        if (!(paintStyle instanceof PaintStyle.SolidPaint)) {
            LOG.atWarn().log("Currently only SolidPaint is supported!");
            return;
        }
        Color colorApplyColorTransform = DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) paintStyle).getSolidColor());
        CTTextCharacterProperties rPr = getRPr(true);
        CTSolidColorFillProperties solidFill = rPr.isSetSolidFill() ? rPr.getSolidFill() : rPr.addNewSolidFill();
        XSLFSheet sheet = getParagraph().getParentShape().getSheet();
        new XSLFColor(solidFill, sheet.getTheme(), solidFill.getSchemeClr(), sheet).setColor(colorApplyColorTransform);
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public String getFontFamily(FontGroup fontGroup) {
        return new XSLFFontInfo(this, fontGroup, null).getTypeface();
    }

    @Override // org.apache.poi.sl.usermodel.TextRun
    public void setFontFamily(String str, FontGroup fontGroup) {
        new XSLFFontInfo(this, fontGroup, null).setTypeface(str);
    }
}
