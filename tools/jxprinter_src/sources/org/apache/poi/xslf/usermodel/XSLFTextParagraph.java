package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.sl.usermodel.AutoNumberingScheme;
import org.apache.poi.sl.usermodel.PaintStyle;
import org.apache.poi.sl.usermodel.TabStop;
import org.apache.poi.sl.usermodel.TextParagraph;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextAutonumberBullet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTextParagraph implements TextParagraph<XSLFShape, XSLFTextParagraph, XSLFTextRun> {
    private final CTTextParagraph _p;
    private final List<XSLFTextRun> _runs = new ArrayList();
    private final XSLFTextShape _shape;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface Procedure {
        void accept();
    }

    public XSLFTextParagraph(CTTextParagraph cTTextParagraph, XSLFTextShape xSLFTextShape) {
        this._p = cTTextParagraph;
        this._shape = xSLFTextShape;
        XmlCursor xmlCursorNewCursor = cTTextParagraph.newCursor();
        try {
            if (xmlCursorNewCursor.toFirstChild()) {
                do {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTTextLineBreak) {
                        this._runs.add(new XSLFLineBreak((CTTextLineBreak) object, this));
                    } else if ((object instanceof CTRegularTextRun) || (object instanceof CTTextField)) {
                        this._runs.add(new XSLFTextRun(object, this));
                    }
                } while (xmlCursorNewCursor.toNextSibling());
            }
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private static boolean doubleNotEquals(Double d, Double d6) {
        return !Objects.equals(d, d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchAutoNumberingScheme(CTTextParagraphProperties cTTextParagraphProperties, Consumer<AutoNumberingScheme> consumer) {
        AutoNumberingScheme autoNumberingSchemeForOoxmlID;
        if (!cTTextParagraphProperties.isSetBuAutoNum() || (autoNumberingSchemeForOoxmlID = AutoNumberingScheme.forOoxmlID(cTTextParagraphProperties.getBuAutoNum().getType().intValue())) == null) {
            return;
        }
        consumer.accept(autoNumberingSchemeForOoxmlID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchBulletFontColor(CTTextParagraphProperties cTTextParagraphProperties, Consumer<Color> consumer) {
        XSLFSheet sheet = getParentShape().getSheet();
        XSLFTheme theme = sheet.getTheme();
        if (cTTextParagraphProperties.isSetBuClr()) {
            consumer.accept(new XSLFColor(cTTextParagraphProperties.getBuClr(), theme, null, sheet).getColor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchBulletFontSize(CTTextParagraphProperties cTTextParagraphProperties, Consumer<Double> consumer) {
        if (cTTextParagraphProperties.isSetBuSzPct()) {
            consumer.accept(Double.valueOf(((double) POIXMLUnits.parsePercent(cTTextParagraphProperties.getBuSzPct().xgetVal())) * 0.001d));
        }
        if (cTTextParagraphProperties.isSetBuSzPts()) {
            consumer.accept(Double.valueOf(((double) (-cTTextParagraphProperties.getBuSzPts().getVal())) * 0.01d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchIsBullet(CTTextParagraphProperties cTTextParagraphProperties, Consumer<Boolean> consumer) {
        if (cTTextParagraphProperties.isSetBuNone()) {
            consumer.accept(Boolean.FALSE);
        } else if (cTTextParagraphProperties.isSetBuFont() || cTTextParagraphProperties.isSetBuChar()) {
            consumer.accept(Boolean.TRUE);
        }
    }

    private <T> T fetchParagraphProperty(ParagraphPropertyFetcher.ParaPropFetcher<T> paraPropFetcher) {
        return (T) new ParagraphPropertyFetcher(this, paraPropFetcher).fetchProperty(getParentShape());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchSpacing(Function<CTTextParagraphProperties, Supplier<CTTextSpacing>> function, CTTextParagraphProperties cTTextParagraphProperties, Consumer<Double> consumer) {
        CTTextSpacing cTTextSpacing = function.apply(cTTextParagraphProperties).get();
        if (cTTextSpacing != null) {
            if (cTTextSpacing.isSetSpcPct()) {
                consumer.accept(Double.valueOf(((double) POIXMLUnits.parsePercent(cTTextSpacing.getSpcPct().xgetVal())) * 0.001d));
            } else if (cTTextSpacing.isSetSpcPts()) {
                consumer.accept(Double.valueOf(((double) (-cTTextSpacing.getSpcPts().getVal())) * 0.01d));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchTabStop(int i5, CTTextParagraphProperties cTTextParagraphProperties, Consumer<Double> consumer) {
        if (cTTextParagraphProperties.isSetTabLst()) {
            CTTextTabStopList tabLst = cTTextParagraphProperties.getTabLst();
            if (i5 < tabLst.sizeOfTabArray()) {
                consumer.accept(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(tabLst.getTabArray(i5).xgetPos()))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fetchTabStops(CTTextParagraphProperties cTTextParagraphProperties, Consumer<List<XSLFTabStop>> consumer) {
        if (cTTextParagraphProperties.isSetTabLst()) {
            ArrayList arrayList = new ArrayList();
            for (CTTextTabStop cTTextTabStop : cTTextParagraphProperties.getTabLst().getTabArray()) {
                arrayList.add(new XSLFTabStop(cTTextTabStop));
            }
            consumer.accept(arrayList);
        }
    }

    private Double getSpacing(Function<CTTextParagraphProperties, Supplier<CTTextSpacing>> function) {
        return (Double) fetchParagraphProperty(new k(function, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getAutoNumberingStartAt$4(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetBuAutoNum() && cTTextParagraphProperties.getBuAutoNum().isSetStartAt()) {
            consumer.accept(Integer.valueOf(cTTextParagraphProperties.getBuAutoNum().getStartAt()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBulletCharacter$3(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetBuChar()) {
            consumer.accept(cTTextParagraphProperties.getBuChar().getChar());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBulletFont$2(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetBuFont()) {
            consumer.accept(cTTextParagraphProperties.getBuFont().getTypeface());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDefaultTabSize$8(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetDefTabSz()) {
            consumer.accept(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextParagraphProperties.xgetDefTabSz()))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getFontAlign$1(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetFontAlgn()) {
            consumer.accept(TextParagraph.FontAlign.values()[cTTextParagraphProperties.getFontAlgn().intValue() - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getIndent$5(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetIndent()) {
            consumer.accept(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getIndent())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getLeftMargin$6(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetMarL()) {
            consumer.accept(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarL())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$getLineSpacing$13(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getRightMargin$7(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetMarR()) {
            consumer.accept(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarR())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$getSpaceAfter$21(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$getSpaceBefore$17(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getTextAlign$0(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
        if (cTTextParagraphProperties.isSetAlgn()) {
            consumer.accept(TextParagraph.TextAlign.values()[cTTextParagraphProperties.getAlgn().intValue() - 1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setLineSpacing$10(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setLineSpacing$11(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Procedure lambda$setLineSpacing$12(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new h(cTTextParagraphProperties, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setSpaceAfter$18(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setSpaceAfter$19(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Procedure lambda$setSpaceAfter$20(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new h(cTTextParagraphProperties, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setSpaceBefore$14(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Supplier lambda$setSpaceBefore$15(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new f(cTTextParagraphProperties, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Procedure lambda$setSpaceBefore$16(CTTextParagraphProperties cTTextParagraphProperties) {
        cTTextParagraphProperties.getClass();
        return new h(cTTextParagraphProperties, 0);
    }

    private void setSpacing(Double d, Function<CTTextParagraphProperties, Supplier<CTTextSpacing>> function, Function<CTTextParagraphProperties, Supplier<CTTextSpacing>> function2, Function<CTTextParagraphProperties, Procedure> function3) {
        CTTextParagraphProperties pPr = (d == null || this._p.isSetPPr()) ? this._p.getPPr() : this._p.addNewPPr();
        if (pPr == null) {
            return;
        }
        CTTextSpacing cTTextSpacing = function.apply(pPr).get();
        if (d == null) {
            if (cTTextSpacing != null) {
                function3.apply(pPr).accept();
                return;
            }
            return;
        }
        if (cTTextSpacing == null) {
            cTTextSpacing = function2.apply(pPr).get();
        }
        if (d.doubleValue() >= 0.0d) {
            if (cTTextSpacing.isSetSpcPts()) {
                cTTextSpacing.unsetSpcPts();
            }
            (cTTextSpacing.isSetSpcPct() ? cTTextSpacing.getSpcPct() : cTTextSpacing.addNewSpcPct()).setVal(Integer.valueOf((int) (d.doubleValue() * 1000.0d)));
        } else {
            if (cTTextSpacing.isSetSpcPct()) {
                cTTextSpacing.unsetSpcPct();
            }
            (cTTextSpacing.isSetSpcPts() ? cTTextSpacing.getSpcPts() : cTTextSpacing.addNewSpcPts()).setVal((int) ((-d.doubleValue()) * 100.0d));
        }
    }

    public XSLFTextRun addLineBreak() {
        XSLFLineBreak xSLFLineBreak = new XSLFLineBreak(this._p.addNewBr(), this);
        CTTextCharacterProperties rPr = xSLFLineBreak.getRPr(true);
        if (!this._runs.isEmpty()) {
            rPr.set(((XSLFTextRun) AbstractC0157z.f(1, this._runs)).getRPr(true));
            if (rPr.isSetHlinkClick()) {
                rPr.unsetHlinkClick();
            }
            if (rPr.isSetHlinkMouseOver()) {
                rPr.unsetHlinkMouseOver();
            }
        }
        this._runs.add(xSLFLineBreak);
        return xSLFLineBreak;
    }

    public XSLFTextRun addNewTextRun() {
        CTRegularTextRun cTRegularTextRunAddNewR = this._p.addNewR();
        cTRegularTextRunAddNewR.addNewRPr().setLang("en-US");
        XSLFTextRun xSLFTextRunNewTextRun = newTextRun(cTRegularTextRunAddNewR);
        this._runs.add(xSLFTextRunNewTextRun);
        return xSLFTextRunNewTextRun;
    }

    public void addTabStop(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetTabLst() ? pPr.getTabLst() : pPr.addNewTabLst()).addNewTab().setPos(Integer.valueOf(Units.toEMU(d)));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void addTabStops(double d, TabStop.TabStopType tabStopType) {
        CTTextParagraphProperties pPr;
        if (getParentShape().getSheet() instanceof XSLFSlideMaster) {
            pPr = getDefaultMasterStyle();
        } else {
            CTTextParagraph xmlObject = getXmlObject();
            pPr = xmlObject.isSetPPr() ? xmlObject.getPPr() : xmlObject.addNewPPr();
        }
        if (pPr == null) {
            return;
        }
        XSLFTabStop xSLFTabStop = new XSLFTabStop((pPr.isSetTabLst() ? pPr.getTabLst() : pPr.addNewTabLst()).addNewTab());
        xSLFTabStop.setPositionInPoints(d);
        xSLFTabStop.setType(tabStopType);
    }

    public void clearButKeepProperties() {
        CTTextParagraph xmlObject = getXmlObject();
        for (int iSizeOfBrArray = xmlObject.sizeOfBrArray(); iSizeOfBrArray > 0; iSizeOfBrArray--) {
            xmlObject.removeBr(iSizeOfBrArray - 1);
        }
        for (int iSizeOfFldArray = xmlObject.sizeOfFldArray(); iSizeOfFldArray > 0; iSizeOfFldArray--) {
            xmlObject.removeFld(iSizeOfFldArray - 1);
        }
        if (this._runs.isEmpty()) {
            return;
        }
        int size = this._runs.size();
        CTTextCharacterProperties rPr = this._runs.get(size - 1).getRPr(false);
        if (rPr != null) {
            if (xmlObject.isSetEndParaRPr()) {
                xmlObject.unsetEndParaRPr();
            }
            xmlObject.addNewEndParaRPr().set(rPr);
        }
        while (size > 0) {
            xmlObject.removeR(size - 1);
            size--;
        }
        this._runs.clear();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void clearTabStops() {
        CTTextParagraphProperties defaultMasterStyle = getParentShape().getSheet() instanceof XSLFSlideMaster ? getDefaultMasterStyle() : getXmlObject().getPPr();
        if (defaultMasterStyle == null || !defaultMasterStyle.isSetTabLst()) {
            return;
        }
        defaultMasterStyle.unsetTabLst();
    }

    public void copy(XSLFTextParagraph xSLFTextParagraph) {
        if (xSLFTextParagraph == this) {
            return;
        }
        CTTextParagraph xmlObject = getXmlObject();
        xSLFTextParagraph.getXmlObject();
        if (xmlObject.isSetPPr()) {
            xmlObject.unsetPPr();
        }
        if (xmlObject.isSetEndParaRPr()) {
            xmlObject.unsetEndParaRPr();
        }
        this._runs.clear();
        for (int iSizeOfBrArray = xmlObject.sizeOfBrArray(); iSizeOfBrArray > 0; iSizeOfBrArray--) {
            xmlObject.removeBr(iSizeOfBrArray - 1);
        }
        for (int iSizeOfRArray = xmlObject.sizeOfRArray(); iSizeOfRArray > 0; iSizeOfRArray--) {
            xmlObject.removeR(iSizeOfRArray - 1);
        }
        for (int iSizeOfFldArray = xmlObject.sizeOfFldArray(); iSizeOfFldArray > 0; iSizeOfFldArray--) {
            xmlObject.removeFld(iSizeOfFldArray - 1);
        }
        for (XSLFTextRun xSLFTextRun : xSLFTextParagraph.getTextRuns()) {
            XmlObject xmlObjectCopy = xSLFTextRun.getXmlObject().copy();
            XSLFTextRun xSLFTextRunAddNewTextRun = addNewTextRun();
            xSLFTextRunAddNewTextRun.getXmlObject().set(xmlObjectCopy);
            xSLFTextRunAddNewTextRun.copy(xSLFTextRun);
        }
        TextParagraph.TextAlign textAlign = xSLFTextParagraph.getTextAlign();
        if (textAlign != getTextAlign()) {
            setTextAlign(textAlign);
        }
        boolean zIsBullet = xSLFTextParagraph.isBullet();
        if (zIsBullet != isBullet()) {
            setBullet(zIsBullet);
            if (zIsBullet) {
                String bulletFont = xSLFTextParagraph.getBulletFont();
                if (bulletFont != null && !bulletFont.equals(getBulletFont())) {
                    setBulletFont(bulletFont);
                }
                String bulletCharacter = xSLFTextParagraph.getBulletCharacter();
                if (bulletCharacter != null && !bulletCharacter.equals(getBulletCharacter())) {
                    setBulletCharacter(bulletCharacter);
                }
                PaintStyle bulletFontColor = xSLFTextParagraph.getBulletFontColor();
                if (bulletFontColor != null && !bulletFontColor.equals(getBulletFontColor())) {
                    setBulletFontColor(bulletFontColor);
                }
                Double bulletFontSize = xSLFTextParagraph.getBulletFontSize();
                if (doubleNotEquals(bulletFontSize, getBulletFontSize())) {
                    setBulletFontSize(bulletFontSize.doubleValue());
                }
            }
        }
        Double leftMargin = xSLFTextParagraph.getLeftMargin();
        if (doubleNotEquals(leftMargin, getLeftMargin())) {
            setLeftMargin(leftMargin);
        }
        Double indent = xSLFTextParagraph.getIndent();
        if (doubleNotEquals(indent, getIndent())) {
            setIndent(indent);
        }
        Double spaceAfter = xSLFTextParagraph.getSpaceAfter();
        if (doubleNotEquals(spaceAfter, getSpaceAfter())) {
            setSpaceAfter(spaceAfter);
        }
        Double spaceBefore = xSLFTextParagraph.getSpaceBefore();
        if (doubleNotEquals(spaceBefore, getSpaceBefore())) {
            setSpaceBefore(spaceBefore);
        }
        Double lineSpacing = xSLFTextParagraph.getLineSpacing();
        if (doubleNotEquals(lineSpacing, getLineSpacing())) {
            setLineSpacing(lineSpacing);
        }
    }

    public AutoNumberingScheme getAutoNumberingScheme() {
        return (AutoNumberingScheme) fetchParagraphProperty(new e(11));
    }

    public Integer getAutoNumberingStartAt() {
        return (Integer) fetchParagraphProperty(new e(17));
    }

    public String getBulletCharacter() {
        return (String) fetchParagraphProperty(new e(7));
    }

    public String getBulletFont() {
        return (String) fetchParagraphProperty(new e(15));
    }

    public PaintStyle getBulletFontColor() {
        Color color = (Color) fetchParagraphProperty(new k(this, 2));
        if (color == null) {
            return null;
        }
        return DrawPaint.createSolidPaint(color);
    }

    public Double getBulletFontSize() {
        return (Double) fetchParagraphProperty(new e(8));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.BulletStyle getBulletStyle() {
        if (isBullet()) {
            return new TextParagraph.BulletStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFTextParagraph.1
                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public AutoNumberingScheme getAutoNumberingScheme() {
                    return XSLFTextParagraph.this.getAutoNumberingScheme();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public Integer getAutoNumberingStartAt() {
                    return XSLFTextParagraph.this.getAutoNumberingStartAt();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public String getBulletCharacter() {
                    return XSLFTextParagraph.this.getBulletCharacter();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public String getBulletFont() {
                    return XSLFTextParagraph.this.getBulletFont();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public PaintStyle getBulletFontColor() {
                    return XSLFTextParagraph.this.getBulletFontColor();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public Double getBulletFontSize() {
                    return XSLFTextParagraph.this.getBulletFontSize();
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public void setBulletFontColor(Color color) {
                    setBulletFontColor(DrawPaint.createSolidPaint(color));
                }

                @Override // org.apache.poi.sl.usermodel.TextParagraph.BulletStyle
                public void setBulletFontColor(PaintStyle paintStyle) {
                    XSLFTextParagraph.this.setBulletFontColor(paintStyle);
                }
            };
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public String getDefaultFontFamily() {
        String fontFamily = this._runs.isEmpty() ? null : this._runs.get(0).getFontFamily();
        return fontFamily == null ? HSSFFont.FONT_ARIAL : fontFamily;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getDefaultFontSize() {
        CTTextParagraphProperties defaultMasterStyle;
        CTTextCharacterProperties endParaRPr = this._p.getEndParaRPr();
        if ((endParaRPr == null || !endParaRPr.isSetSz()) && (defaultMasterStyle = getDefaultMasterStyle()) != null) {
            endParaRPr = defaultMasterStyle.getDefRPr();
        }
        return Double.valueOf((endParaRPr == null || !endParaRPr.isSetSz()) ? 12.0d : ((double) endParaRPr.getSz()) / 100.0d);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0031  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b A[Catch: all -> 0x0059, TryCatch #2 {all -> 0x0059, blocks: (B:23:0x0047, B:25:0x0052, B:35:0x006b, B:37:0x008e, B:40:0x0098, B:30:0x005b, B:32:0x0061), top: B:57:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0098 A[Catch: all -> 0x0059, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0059, blocks: (B:23:0x0047, B:25:0x0052, B:35:0x006b, B:37:0x008e, B:40:0x0098, B:30:0x005b, B:32:0x0061), top: B:57:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x006b, please report this as an issue */
    @Internal
    public CTTextParagraphProperties getDefaultMasterStyle() {
        String str;
        CTPlaceholder cTPlaceholder = this._shape.getPlaceholderDetails().getCTPlaceholder(false);
        int iIntValue = cTPlaceholder == null ? -1 : cTPlaceholder.getType().intValue();
        if (iIntValue == -1) {
            str = "otherStyle";
        } else if (iIntValue == 1 || iIntValue == 3) {
            str = "titleStyle";
        } else if (iIntValue == 5 || iIntValue == 6 || iIntValue == 7) {
            str = "otherStyle";
        } else {
            str = "bodyStyle";
        }
        int indentLevel = getIndentLevel();
        for (XSLFSheet sheet = this._shape.getSheet(); sheet != null; sheet = (XSLFSheet) sheet.getMasterSheet()) {
            XmlCursor xmlCursorNewCursor = sheet.getXmlObject().newCursor();
            try {
                xmlCursorNewCursor.push();
                if (xmlCursorNewCursor.toChild(XSSFRelation.NS_PRESENTATIONML, "txStyles") && xmlCursorNewCursor.toChild(XSSFRelation.NS_PRESENTATIONML, str)) {
                    while (indentLevel >= 0) {
                        xmlCursorNewCursor.push();
                        if (xmlCursorNewCursor.toChild(XSSFRelation.NS_DRAWINGML, "lvl" + (indentLevel + 1) + "pPr")) {
                            CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) xmlCursorNewCursor.getObject();
                            xmlCursorNewCursor.close();
                            return cTTextParagraphProperties;
                        }
                        xmlCursorNewCursor.pop();
                        indentLevel--;
                    }
                } else if (xmlCursorNewCursor.pop() && xmlCursorNewCursor.toChild(XSSFRelation.NS_PRESENTATIONML, "notesStyle")) {
                    while (indentLevel >= 0) {
                        xmlCursorNewCursor.push();
                        if (xmlCursorNewCursor.toChild(XSSFRelation.NS_DRAWINGML, "lvl" + (indentLevel + 1) + "pPr")) {
                            CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) xmlCursorNewCursor.getObject();
                            xmlCursorNewCursor.close();
                            return cTTextParagraphProperties2;
                        }
                        xmlCursorNewCursor.pop();
                        indentLevel--;
                    }
                }
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        return null;
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getDefaultTabSize() {
        return (Double) fetchParagraphProperty(new e(16));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.FontAlign getFontAlign() {
        return (TextParagraph.FontAlign) fetchParagraphProperty(new e(13));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getIndent() {
        return (Double) fetchParagraphProperty(new e(14));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public int getIndentLevel() {
        CTTextParagraphProperties pPr = this._p.getPPr();
        if (pPr == null || !pPr.isSetLvl()) {
            return 0;
        }
        return pPr.getLvl();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getLeftMargin() {
        return (Double) fetchParagraphProperty(new e(6));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getLineSpacing() {
        CTTextNormalAutofit normAutofit;
        Double spacing = getSpacing(new org.apache.poi.xddf.usermodel.text.f(29));
        return (spacing == null || spacing.doubleValue() <= 0.0d || (normAutofit = getParentShape().getTextBodyPr().getNormAutofit()) == null) ? spacing : Double.valueOf(spacing.doubleValue() * (1.0d - (((double) POIXMLUnits.parsePercent(normAutofit.xgetLnSpcReduction())) / 100000.0d)));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getRightMargin() {
        return (Double) fetchParagraphProperty(new e(9));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getSpaceAfter() {
        return getSpacing(new g(7));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public Double getSpaceBefore() {
        return getSpacing(new g(0));
    }

    public double getTabStop(final int i5) {
        Double d = (Double) fetchParagraphProperty(new ParagraphPropertyFetcher.ParaPropFetcher() { // from class: org.apache.poi.xslf.usermodel.i
            @Override // org.apache.poi.xslf.model.ParagraphPropertyFetcher.ParaPropFetcher
            public final void fetch(CTTextParagraphProperties cTTextParagraphProperties, Consumer consumer) {
                XSLFTextParagraph.fetchTabStop(i5, cTTextParagraphProperties, consumer);
            }
        });
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public List<XSLFTabStop> getTabStops() {
        return (List) fetchParagraphProperty(new e(12));
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getRawText());
        }
        return sb.toString();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public TextParagraph.TextAlign getTextAlign() {
        return (TextParagraph.TextAlign) fetchParagraphProperty(new e(10));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public List<XSLFTextRun> getTextRuns() {
        return Collections.unmodifiableList(this._runs);
    }

    @Internal
    public CTTextParagraph getXmlObject() {
        return this._p;
    }

    public boolean isBullet() {
        Boolean bool = (Boolean) fetchParagraphProperty(new e(18));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public boolean isHeaderOrFooter() {
        CTPlaceholder cTPlaceholder = this._shape.getPlaceholderDetails().getCTPlaceholder(false);
        int iIntValue = cTPlaceholder == null ? -1 : cTPlaceholder.getType().intValue();
        return iIntValue == 5 || iIntValue == 6 || iIntValue == 7 || iIntValue == 8;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextRun> iterator() {
        return getTextRuns().iterator();
    }

    public XSLFTextRun newTextRun(XmlObject xmlObject) {
        return new XSLFTextRun(xmlObject, this);
    }

    public boolean removeTextRun(XSLFTextRun xSLFTextRun) {
        if (this._runs.remove(xSLFTextRun)) {
            XmlObject xmlObject = xSLFTextRun.getXmlObject();
            if (xmlObject instanceof CTRegularTextRun) {
                for (int i5 = 0; i5 < getXmlObject().sizeOfRArray(); i5++) {
                    if (getXmlObject().getRArray(i5).equals(xmlObject)) {
                        getXmlObject().removeR(i5);
                        return true;
                    }
                }
            } else if (xmlObject instanceof CTTextField) {
                for (int i6 = 0; i6 < getXmlObject().sizeOfFldArray(); i6++) {
                    if (getXmlObject().getFldArray(i6).equals(xmlObject)) {
                        getXmlObject().removeFld(i6);
                        return true;
                    }
                }
            } else if (xmlObject instanceof CTTextLineBreak) {
                for (int i7 = 0; i7 < getXmlObject().sizeOfBrArray(); i7++) {
                    if (getXmlObject().getBrArray(i7).equals(xmlObject)) {
                        getXmlObject().removeBr(i7);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void setBullet(boolean z6) {
        if (isBullet() == z6) {
            return;
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (z6) {
            pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
            pPr.addNewBuChar().setChar("•");
            return;
        }
        if (pPr.isSetBuFont()) {
            pPr.unsetBuFont();
        }
        if (pPr.isSetBuChar()) {
            pPr.unsetBuChar();
        }
        if (pPr.isSetBuAutoNum()) {
            pPr.unsetBuAutoNum();
        }
        if (pPr.isSetBuBlip()) {
            pPr.unsetBuBlip();
        }
        if (pPr.isSetBuClr()) {
            pPr.unsetBuClr();
        }
        if (pPr.isSetBuClrTx()) {
            pPr.unsetBuClrTx();
        }
        if (pPr.isSetBuFont()) {
            pPr.unsetBuFont();
        }
        if (pPr.isSetBuFontTx()) {
            pPr.unsetBuFontTx();
        }
        if (pPr.isSetBuSzPct()) {
            pPr.unsetBuSzPct();
        }
        if (pPr.isSetBuSzPts()) {
            pPr.unsetBuSzPts();
        }
        if (pPr.isSetBuSzTx()) {
            pPr.unsetBuSzTx();
        }
        pPr.addNewBuNone();
    }

    public void setBulletAutoNumber(AutoNumberingScheme autoNumberingScheme, int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("Start Number must be greater or equal that 1");
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextAutonumberBullet buAutoNum = pPr.isSetBuAutoNum() ? pPr.getBuAutoNum() : pPr.addNewBuAutoNum();
        buAutoNum.setType(STTextAutonumberScheme.Enum.forInt(autoNumberingScheme.ooxmlId));
        buAutoNum.setStartAt(i5);
    }

    public void setBulletCharacter(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuChar() ? pPr.getBuChar() : pPr.addNewBuChar()).setChar(str);
    }

    public void setBulletFont(String str) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuFont() ? pPr.getBuFont() : pPr.addNewBuFont()).setTypeface(str);
    }

    public void setBulletFontColor(Color color) {
        setBulletFontColor(DrawPaint.createSolidPaint(color));
    }

    public void setBulletFontSize(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d >= 0.0d) {
            (pPr.isSetBuSzPct() ? pPr.getBuSzPct() : pPr.addNewBuSzPct()).setVal(Integer.toString((int) (d * 1000.0d)));
            if (pPr.isSetBuSzPts()) {
                pPr.unsetBuSzPts();
                return;
            }
            return;
        }
        (pPr.isSetBuSzPts() ? pPr.getBuSzPts() : pPr.addNewBuSzPts()).setVal((int) ((-d) * 100.0d));
        if (pPr.isSetBuSzPct()) {
            pPr.unsetBuSzPct();
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setBulletStyle(Object... objArr) {
        if (objArr.length == 0) {
            setBullet(false);
            return;
        }
        setBullet(true);
        for (Object obj : objArr) {
            if (obj instanceof Number) {
                setBulletFontSize(((Number) obj).doubleValue());
            } else if (obj instanceof Color) {
                setBulletFontColor((Color) obj);
            } else if (obj instanceof Character) {
                setBulletCharacter(obj.toString());
            } else if (obj instanceof String) {
                setBulletFont((String) obj);
            } else if (obj instanceof AutoNumberingScheme) {
                setBulletAutoNumber((AutoNumberingScheme) obj, 0);
            }
        }
    }

    public void setFontAlign(TextParagraph.FontAlign fontAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (fontAlign != null) {
            pPr.setFontAlgn(STTextFontAlignType.Enum.forInt(fontAlign.ordinal() + 1));
        } else if (pPr.isSetFontAlgn()) {
            pPr.unsetFontAlgn();
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setIndent(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d != null) {
                pPr.setIndent(Units.toEMU(d.doubleValue()));
            } else if (pPr.isSetIndent()) {
                pPr.unsetIndent();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setIndentLevel(int i5) {
        (this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr()).setLvl(i5);
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setLeftMargin(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d != null) {
                pPr.setMarL(Units.toEMU(d.doubleValue()));
            } else if (pPr.isSetMarL()) {
                pPr.unsetMarL();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setLineSpacing(Double d) {
        setSpacing(d, new g(4), new g(5), new g(6));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setRightMargin(Double d) {
        if (d != null || this._p.isSetPPr()) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            if (d != null) {
                pPr.setMarR(Units.toEMU(d.doubleValue()));
            } else if (pPr.isSetMarR()) {
                pPr.unsetMarR();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setSpaceAfter(Double d) {
        setSpacing(d, new org.apache.poi.xddf.usermodel.text.f(26), new org.apache.poi.xddf.usermodel.text.f(27), new org.apache.poi.xddf.usermodel.text.f(28));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setSpaceBefore(Double d) {
        setSpacing(d, new g(1), new g(2), new g(3));
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public void setTextAlign(TextParagraph.TextAlign textAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (textAlign != null) {
            pPr.setAlgn(STTextAlignType.Enum.forInt(textAlign.ordinal() + 1));
        } else if (pPr.isSetAlgn()) {
            pPr.unsetAlgn();
        }
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }

    @Override // org.apache.poi.sl.usermodel.TextParagraph
    public XSLFTextShape getParentShape() {
        return this._shape;
    }

    public XSLFTextRun newTextRun(CTTextLineBreak cTTextLineBreak) {
        return new XSLFLineBreak(cTTextLineBreak, this);
    }

    public void setBulletFontColor(PaintStyle paintStyle) {
        if (!(paintStyle instanceof PaintStyle.SolidPaint)) {
            throw new IllegalArgumentException("Currently XSLF only supports SolidPaint");
        }
        Color colorApplyColorTransform = DrawPaint.applyColorTransform(((PaintStyle.SolidPaint) paintStyle).getSolidColor());
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTColor buClr = pPr.isSetBuClr() ? pPr.getBuClr() : pPr.addNewBuClr();
        (buClr.isSetSrgbClr() ? buClr.getSrgbClr() : buClr.addNewSrgbClr()).setVal(new byte[]{(byte) colorApplyColorTransform.getRed(), (byte) colorApplyColorTransform.getGreen(), (byte) colorApplyColorTransform.getBlue()});
    }
}
