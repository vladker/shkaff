package org.apache.poi.xddf.usermodel.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LocaleUtil;
import org.apache.poi.util.k;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTextParagraph implements Iterable<XDDFTextRun> {
    private final CTTextParagraph _p;
    private XDDFTextBody _parent;
    private XDDFParagraphProperties _properties;
    private final ArrayList<XDDFTextRun> _runs;

    @Internal
    public XDDFTextParagraph(CTTextParagraph cTTextParagraph, XDDFTextBody xDDFTextBody) {
        this._p = cTTextParagraph;
        this._parent = xDDFTextBody;
        this._runs = new ArrayList<>(cTTextParagraph.sizeOfRArray() + cTTextParagraph.sizeOfFldArray() + cTTextParagraph.sizeOfBrArray());
        for (XmlObject xmlObject : cTTextParagraph.selectChildren(QNameSet.ALL)) {
            if (xmlObject instanceof CTTextLineBreak) {
                this._runs.add(new XDDFTextRun((CTTextLineBreak) xmlObject, this));
            } else if (xmlObject instanceof CTTextField) {
                this._runs.add(new XDDFTextRun((CTTextField) xmlObject, this));
            } else if (xmlObject instanceof CTRegularTextRun) {
                this._runs.add(new XDDFTextRun((CTRegularTextRun) xmlObject, this));
            }
        }
        addDefaultRunProperties();
        addAfterLastRunProperties();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public XDDFSpacing extractSpacing(CTTextSpacing cTTextSpacing) {
        if (cTTextSpacing.isSetSpcPct()) {
            return new XDDFSpacingPercent(cTTextSpacing, cTTextSpacing.getSpcPct(), Double.valueOf(1.0d - (((double) this._parent.getBodyProperties().getAutoFit().getLineSpaceReduction()) / 100000.0d)));
        }
        if (cTTextSpacing.isSetSpcPts()) {
            return new XDDFSpacingPoints(cTTextSpacing, cTTextSpacing.getSpcPts());
        }
        return null;
    }

    private XDDFParagraphProperties getOrCreateProperties() {
        if (!this._p.isSetPPr()) {
            this._properties = new XDDFParagraphProperties(this._p.addNewPPr());
        }
        return getProperties();
    }

    private XDDFParagraphProperties getProperties() {
        if (this._properties == null) {
            this._properties = new XDDFParagraphProperties(this._p.getPPr());
        }
        return this._properties;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBulletColor$0(CTTextParagraphProperties cTTextParagraphProperties) {
        return cTTextParagraphProperties.isSetBuClr() || cTTextParagraphProperties.isSetBuClrTx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFColor lambda$getBulletColor$1(CTTextParagraphProperties cTTextParagraphProperties) {
        return new XDDFParagraphBulletProperties(cTTextParagraphProperties).getBulletColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBulletFont$2(CTTextParagraphProperties cTTextParagraphProperties) {
        return cTTextParagraphProperties.isSetBuFont() || cTTextParagraphProperties.isSetBuFontTx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFFont lambda$getBulletFont$3(CTTextParagraphProperties cTTextParagraphProperties) {
        return new XDDFParagraphBulletProperties(cTTextParagraphProperties).getBulletFont();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBulletSize$4(CTTextParagraphProperties cTTextParagraphProperties) {
        return cTTextParagraphProperties.isSetBuSzPct() || cTTextParagraphProperties.isSetBuSzPts() || cTTextParagraphProperties.isSetBuSzTx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFBulletSize lambda$getBulletSize$5(CTTextParagraphProperties cTTextParagraphProperties) {
        return new XDDFParagraphBulletProperties(cTTextParagraphProperties).getBulletSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getBulletStyle$6(CTTextParagraphProperties cTTextParagraphProperties) {
        return cTTextParagraphProperties.isSetBuAutoNum() || cTTextParagraphProperties.isSetBuBlip() || cTTextParagraphProperties.isSetBuChar() || cTTextParagraphProperties.isSetBuNone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ XDDFBulletStyle lambda$getBulletStyle$7(CTTextParagraphProperties cTTextParagraphProperties) {
        return new XDDFParagraphBulletProperties(cTTextParagraphProperties).getBulletStyle();
    }

    public XDDFRunProperties addAfterLastRunProperties() {
        if (!this._p.isSetEndParaRPr()) {
            this._p.addNewEndParaRPr();
        }
        return getAfterLastRunProperties();
    }

    public XDDFRunProperties addDefaultRunProperties() {
        return getOrCreateProperties().addDefaultRunProperties();
    }

    public XDDFTabStop addTabStop() {
        return getOrCreateProperties().addTabStop();
    }

    public XDDFTextRun appendField(String str, String str2, String str3) {
        CTTextField cTTextFieldAddNewFld = this._p.addNewFld();
        cTTextFieldAddNewFld.setId(str);
        cTTextFieldAddNewFld.setType(str2);
        cTTextFieldAddNewFld.setT(str3);
        cTTextFieldAddNewFld.addNewRPr().setLang(LocaleUtil.getUserLocale().toLanguageTag());
        XDDFTextRun xDDFTextRun = new XDDFTextRun(cTTextFieldAddNewFld, this);
        this._runs.add(xDDFTextRun);
        return xDDFTextRun;
    }

    public XDDFTextRun appendLineBreak() {
        CTTextLineBreak cTTextLineBreakAddNewBr = this._p.addNewBr();
        Iterator it = new IteratorIterable(new ReverseListIterator(this._runs)).iterator();
        while (it.hasNext()) {
            CTTextCharacterProperties properties = ((XDDFTextRun) it.next()).getProperties();
            if (properties != null) {
                cTTextLineBreakAddNewBr.setRPr((CTTextCharacterProperties) properties.copy());
                break;
            }
        }
        XDDFTextRun xDDFTextRun = new XDDFTextRun(cTTextLineBreakAddNewBr, this);
        this._runs.add(xDDFTextRun);
        return xDDFTextRun;
    }

    public XDDFTextRun appendRegularRun(String str) {
        CTRegularTextRun cTRegularTextRunAddNewR = this._p.addNewR();
        cTRegularTextRunAddNewR.setT(str);
        cTRegularTextRunAddNewR.addNewRPr().setLang(LocaleUtil.getUserLocale().toLanguageTag());
        XDDFTextRun xDDFTextRun = new XDDFTextRun(cTRegularTextRunAddNewR, this);
        this._runs.add(xDDFTextRun);
        return xDDFTextRun;
    }

    public int countTabStops() {
        if (this._p.isSetPPr()) {
            return getProperties().countTabStops();
        }
        return 0;
    }

    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        if (this._p.isSetPPr()) {
            return findDefinedParagraphProperty(predicate, function, this._p.getPPr().isSetLvl() ? this._p.getPPr().getLvl() + 1 : 0);
        }
        return this._parent.findDefinedParagraphProperty(predicate, function, 0);
    }

    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        if (this._p.isSetPPr()) {
            return findDefinedRunProperty(predicate, function, this._p.getPPr().isSetLvl() ? this._p.getPPr().getLvl() + 1 : 0);
        }
        return this._parent.findDefinedRunProperty(predicate, function, 0);
    }

    public XDDFRunProperties getAfterLastRunProperties() {
        if (this._p.isSetEndParaRPr()) {
            return new XDDFRunProperties(this._p.getEndParaRPr());
        }
        return null;
    }

    public XDDFColor getBulletColor() {
        return (XDDFColor) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(9), new k(17)).orElse(null);
    }

    public XDDFFont getBulletFont() {
        return (XDDFFont) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(14), new k(23)).orElse(null);
    }

    public XDDFParagraphBulletProperties getBulletProperties() {
        if (this._p.isSetPPr()) {
            return getProperties().getBulletProperties();
        }
        return null;
    }

    public XDDFBulletSize getBulletSize() {
        return (XDDFBulletSize) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(7), new k(19)).orElse(null);
    }

    public XDDFBulletStyle getBulletStyle() {
        return (XDDFBulletStyle) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(18), new k(27)).orElse(null);
    }

    public XDDFRunProperties getDefaultRunProperties() {
        if (this._p.isSetPPr()) {
            return getProperties().getDefaultRunProperties();
        }
        return null;
    }

    public Double getDefaultTabSize() {
        return (Double) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(23), new d(4)).map(new k(13)).map(new k(14)).orElse(null);
    }

    public FontAlignment getFontAlignment() {
        return (FontAlignment) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(22), new d(2)).map(new d(3)).orElse(null);
    }

    public Double getIndentation() {
        return (Double) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(13), new k(22)).map(new k(16)).orElse(null);
    }

    public int getIndentationLevel() {
        if (this._p.isSetPPr()) {
            return getProperties().getLevel();
        }
        return 0;
    }

    public XDDFSpacing getLineSpacing() {
        return (XDDFSpacing) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(17), new k(26)).map(new com.google.android.material.color.utilities.a(this, 6)).orElse(null);
    }

    public Double getMarginLeft() {
        return (Double) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(8), new k(15)).map(new k(16)).orElse(null);
    }

    public Double getMarginRight() {
        return (Double) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(11), new k(20)).map(new k(16)).orElse(null);
    }

    public XDDFParagraphBulletProperties getOrCreateBulletProperties() {
        return getOrCreateProperties().getBulletProperties();
    }

    public XDDFTextBody getParentBody() {
        return this._parent;
    }

    public XDDFSpacing getSpaceAfter() {
        return (XDDFSpacing) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(16), new d(1)).map(new com.google.android.material.color.utilities.a(this, 6)).orElse(null);
    }

    public XDDFSpacing getSpaceBefore() {
        return (XDDFSpacing) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(21), new d(0)).map(new com.google.android.material.color.utilities.a(this, 6)).orElse(null);
    }

    public XDDFTabStop getTabStop(int i5) {
        if (this._p.isSetPPr()) {
            return getProperties().getTabStop(i5);
        }
        return null;
    }

    public List<XDDFTabStop> getTabStops() {
        return this._p.isSetPPr() ? getProperties().getTabStops() : Collections.EMPTY_LIST;
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        ArrayList<XDDFTextRun> arrayList = this._runs;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            XDDFTextRun xDDFTextRun = arrayList.get(i5);
            i5++;
            sb.append(xDDFTextRun.getText());
        }
        return sb.toString();
    }

    public TextAlignment getTextAlignment() {
        return (TextAlignment) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(15), new k(24)).map(new k(25)).orElse(null);
    }

    public List<XDDFTextRun> getTextRuns() {
        return this._runs;
    }

    public boolean hasEastAsianLineBreak() {
        return ((Boolean) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(12), new k(21)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean hasHangingPunctuation() {
        return ((Boolean) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(10), new k(18)).orElse(Boolean.FALSE)).booleanValue();
    }

    public boolean hasLatinLineBreak() {
        return ((Boolean) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(20), new k(29)).orElse(Boolean.FALSE)).booleanValue();
    }

    public XDDFTabStop insertTabStop(int i5) {
        return getOrCreateProperties().insertTabStop(i5);
    }

    public boolean isRightToLeft() {
        return ((Boolean) findDefinedParagraphProperty(new org.apache.commons.compress.archivers.tar.a(19), new k(28)).orElse(Boolean.FALSE)).booleanValue();
    }

    @Override // java.lang.Iterable
    public Iterator<XDDFTextRun> iterator() {
        return this._runs.iterator();
    }

    public void removeTabStop(int i5) {
        if (this._p.isSetPPr()) {
            getProperties().removeTabStop(i5);
        }
    }

    public void setAfterLastRunProperties(XDDFRunProperties xDDFRunProperties) {
        if (xDDFRunProperties != null) {
            this._p.setEndParaRPr(xDDFRunProperties.getXmlObject());
        } else if (this._p.isSetEndParaRPr()) {
            this._p.unsetEndParaRPr();
        }
    }

    public void setBulletColor(XDDFColor xDDFColor) {
        if (xDDFColor != null || this._p.isSetPPr()) {
            getOrCreateBulletProperties().setBulletColor(xDDFColor);
        }
    }

    public void setBulletColorFollowText() {
        getOrCreateBulletProperties().setBulletColorFollowText();
    }

    public void setBulletFont(XDDFFont xDDFFont) {
        if (xDDFFont != null || this._p.isSetPPr()) {
            getOrCreateBulletProperties().setBulletFont(xDDFFont);
        }
    }

    public void setBulletFontFollowText() {
        getOrCreateBulletProperties().setBulletFontFollowText();
    }

    public void setBulletSize(XDDFBulletSize xDDFBulletSize) {
        if (xDDFBulletSize != null || this._p.isSetPPr()) {
            getOrCreateBulletProperties().setBulletSize(xDDFBulletSize);
        }
    }

    public void setBulletStyle(XDDFBulletStyle xDDFBulletStyle) {
        if (xDDFBulletStyle != null || this._p.isSetPPr()) {
            getOrCreateBulletProperties().setBulletStyle(xDDFBulletStyle);
        }
    }

    public void setDefaultRunProperties(XDDFRunProperties xDDFRunProperties) {
        if (xDDFRunProperties != null || this._p.isSetPPr()) {
            getOrCreateProperties().setDefaultRunProperties(xDDFRunProperties);
        }
    }

    public void setDefaultTabSize(Double d) {
        if (d != null || this._p.isSetPPr()) {
            getOrCreateProperties().setDefaultTabSize(d);
        }
    }

    public void setEastAsianLineBreak(Boolean bool) {
        if (bool != null || this._p.isSetPPr()) {
            getOrCreateProperties().setEastAsianLineBreak(bool);
        }
    }

    public void setFontAlignment(FontAlignment fontAlignment) {
        if (fontAlignment != null || this._p.isSetPPr()) {
            getOrCreateProperties().setFontAlignment(fontAlignment);
        }
    }

    public void setHangingPunctuation(Boolean bool) {
        if (bool != null || this._p.isSetPPr()) {
            getOrCreateProperties().setHangingPunctuation(bool);
        }
    }

    public void setIndentation(Double d) {
        if (d != null || this._p.isSetPPr()) {
            getOrCreateProperties().setIndentation(d);
        }
    }

    public void setIndentationLevel(Integer num) {
        if (this._p.isSetPPr()) {
            getProperties().setLevel(num);
        }
    }

    public void setLatinLineBreak(Boolean bool) {
        if (bool != null || this._p.isSetPPr()) {
            getOrCreateProperties().setLatinLineBreak(bool);
        }
    }

    public void setLineSpacing(XDDFSpacing xDDFSpacing) {
        if (xDDFSpacing != null || this._p.isSetPPr()) {
            getOrCreateProperties().setLineSpacing(xDDFSpacing);
        }
    }

    public void setMarginLeft(Double d) {
        if (d != null || this._p.isSetPPr()) {
            getOrCreateProperties().setMarginLeft(d);
        }
    }

    public void setMarginRight(Double d) {
        if (d != null || this._p.isSetPPr()) {
            getOrCreateProperties().setMarginRight(d);
        }
    }

    public void setRightToLeft(Boolean bool) {
        if (bool != null || this._p.isSetPPr()) {
            getOrCreateProperties().setRightToLeft(bool);
        }
    }

    public void setSpaceAfter(XDDFSpacing xDDFSpacing) {
        if (xDDFSpacing != null || this._p.isSetPPr()) {
            getOrCreateProperties().setSpaceAfter(xDDFSpacing);
        }
    }

    public void setSpaceBefore(XDDFSpacing xDDFSpacing) {
        if (xDDFSpacing != null || this._p.isSetPPr()) {
            getOrCreateProperties().setSpaceBefore(xDDFSpacing);
        }
    }

    public void setText(String str) {
        XmlObject xmlObjectCopy = !this._runs.isEmpty() ? ((XDDFTextRun) androidx.collection.a.e(this._runs, 1)).getProperties().copy() : null;
        for (int iSizeOfBrArray = this._p.sizeOfBrArray() - 1; iSizeOfBrArray >= 0; iSizeOfBrArray--) {
            this._p.removeBr(iSizeOfBrArray);
        }
        for (int iSizeOfFldArray = this._p.sizeOfFldArray() - 1; iSizeOfFldArray >= 0; iSizeOfFldArray--) {
            this._p.removeFld(iSizeOfFldArray);
        }
        for (int iSizeOfRArray = this._p.sizeOfRArray() - 1; iSizeOfRArray >= 0; iSizeOfRArray--) {
            this._p.removeR(iSizeOfRArray);
        }
        this._runs.clear();
        XDDFTextRun xDDFTextRunAppendRegularRun = appendRegularRun(str);
        if (xmlObjectCopy != null) {
            xDDFTextRunAppendRegularRun.getProperties().set(xmlObjectCopy);
        }
    }

    public void setTextAlignment(TextAlignment textAlignment) {
        if (textAlignment != null || this._p.isSetPPr()) {
            getOrCreateProperties().setTextAlignment(textAlignment);
        }
    }

    @Override // java.lang.Iterable
    public Spliterator<XDDFTextRun> spliterator() {
        return this._runs.spliterator();
    }

    private <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function, int i5) {
        CTTextParagraphProperties pPr = this._p.getPPr();
        if (pPr != null && predicate.test(pPr)) {
            return Optional.ofNullable(function.apply(pPr));
        }
        return this._parent.findDefinedParagraphProperty(predicate, function, i5);
    }

    private <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function, int i5) {
        CTTextCharacterProperties defRPr = this._p.getPPr().isSetDefRPr() ? this._p.getPPr().getDefRPr() : null;
        if (defRPr != null && predicate.test(defRPr)) {
            return Optional.ofNullable(function.apply(defRPr));
        }
        return this._parent.findDefinedRunProperty(predicate, function, i5);
    }
}
