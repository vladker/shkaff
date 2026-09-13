package org.apache.poi.xslf.usermodel;

import A3.AbstractC0157z;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Insets2D;
import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.apache.poi.xslf.model.TextBodyPropertyFetcher;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextWrappingType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XSLFTextShape extends XSLFSimpleShape implements TextContainer, TextShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final List<XSLFTextParagraph> _paragraphs;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTextShape$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$Placeholder;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder;

        static {
            int[] iArr = new int[Placeholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$Placeholder = iArr;
            try {
                iArr[Placeholder.BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.TITLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CENTERED_TITLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$Placeholder[Placeholder.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TextShape.TextPlaceholder.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder = iArr2;
            try {
                iArr2[TextShape.TextPlaceholder.NOTES.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.HALF_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.QUARTER_BODY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.BODY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_BODY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.CENTER_TITLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[TextShape.TextPlaceholder.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[TextShape.TextAutofit.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit = iArr3;
            try {
                iArr3[TextShape.TextAutofit.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[TextShape.TextAutofit.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[TextShape.TextAutofit.SHAPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public XSLFTextShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        super(xmlObject, xSLFSheet);
        this._paragraphs = new ArrayList();
        CTTextBody textBody = getTextBody(false);
        if (textBody != null) {
            for (CTTextParagraph cTTextParagraph : textBody.getPArray()) {
                this._paragraphs.add(newTextParagraph(cTTextParagraph));
            }
        }
    }

    public XSLFTextParagraph addNewTextParagraph() {
        CTTextParagraph cTTextParagraphAddNewP;
        CTTextBody textBody = getTextBody(false);
        if (textBody == null) {
            CTTextBody textBody2 = getTextBody(true);
            new XDDFTextBody(this, textBody2).initialize();
            cTTextParagraphAddNewP = textBody2.getPArray(0);
            cTTextParagraphAddNewP.removeR(0);
        } else {
            cTTextParagraphAddNewP = textBody.addNewP();
        }
        XSLFTextParagraph xSLFTextParagraphNewTextParagraph = newTextParagraph(cTTextParagraphAddNewP);
        this._paragraphs.add(xSLFTextParagraphNewTextParagraph);
        return xSLFTextParagraphNewTextParagraph;
    }

    public void clearText() {
        this._paragraphs.clear();
        getTextBody(true).setPArray(null);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape
    public void copy(XSLFShape xSLFShape) {
        super.copy(xSLFShape);
        XSLFTextShape xSLFTextShape = (XSLFTextShape) xSLFShape;
        CTTextBody textBody = xSLFTextShape.getTextBody(false);
        if (textBody == null) {
            return;
        }
        CTTextBody textBody2 = getTextBody(true);
        textBody2.setBodyPr((CTTextBodyProperties) textBody.getBodyPr().copy());
        if (textBody2.isSetLstStyle()) {
            textBody2.unsetLstStyle();
        }
        if (textBody.isSetLstStyle()) {
            textBody2.setLstStyle((CTTextListStyle) textBody.getLstStyle().copy());
        }
        boolean wordWrap = xSLFTextShape.getWordWrap();
        if (wordWrap != getWordWrap()) {
            setWordWrap(wordWrap);
        }
        double leftInset = xSLFTextShape.getLeftInset();
        if (leftInset != getLeftInset()) {
            setLeftInset(leftInset);
        }
        double rightInset = xSLFTextShape.getRightInset();
        if (rightInset != getRightInset()) {
            setRightInset(rightInset);
        }
        double topInset = xSLFTextShape.getTopInset();
        if (topInset != getTopInset()) {
            setTopInset(topInset);
        }
        double bottomInset = xSLFTextShape.getBottomInset();
        if (bottomInset != getBottomInset()) {
            setBottomInset(bottomInset);
        }
        VerticalAlignment verticalAlignment = xSLFTextShape.getVerticalAlignment();
        if (verticalAlignment != getVerticalAlignment()) {
            setVerticalAlignment(verticalAlignment);
        }
        clearText();
        Iterator<XSLFTextParagraph> it = xSLFTextShape.getTextParagraphs().iterator();
        while (it.hasNext()) {
            addNewTextParagraph().copy(it.next());
        }
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function) {
        return Optional.empty();
    }

    @Override // org.apache.poi.xddf.usermodel.text.TextContainer
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function) {
        return Optional.empty();
    }

    public double getBottomInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.3
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetBIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextBodyProperties.xgetBIns()))));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Insets2D getInsets() {
        return new Insets2D(getTopInset(), getLeftInset(), getBottomInset(), getRightInset());
    }

    public double getLeftInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.4
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetLIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextBodyProperties.xgetLIns()))));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public double getRightInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.5
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetRIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextBodyProperties.xgetRIns()))));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 7.2d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (XSLFTextParagraph xSLFTextParagraph : this._paragraphs) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(xSLFTextParagraph.getText());
        }
        return sb.toString();
    }

    public TextShape.TextAutofit getTextAutofit() {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr != null) {
            if (textBodyPr.isSetNoAutofit()) {
                return TextShape.TextAutofit.NONE;
            }
            if (textBodyPr.isSetNormAutofit()) {
                return TextShape.TextAutofit.NORMAL;
            }
            if (textBodyPr.isSetSpAutoFit()) {
                return TextShape.TextAutofit.SHAPE;
            }
        }
        return TextShape.TextAutofit.NORMAL;
    }

    public XDDFTextBody getTextBody() {
        CTTextBody textBody = getTextBody(false);
        if (textBody == null) {
            return null;
        }
        return new XDDFTextBody(this, textBody);
    }

    public abstract CTTextBody getTextBody(boolean z6);

    public CTTextBodyProperties getTextBodyPr() {
        return getTextBodyPr(false);
    }

    public TextShape.TextDirection getTextDirection() {
        STTextVerticalType.Enum vert;
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr == null || (vert = textBodyPr.getVert()) == null) {
            return TextShape.TextDirection.HORIZONTAL;
        }
        switch (vert.intValue()) {
            case 2:
            case 5:
            case 6:
                return TextShape.TextDirection.VERTICAL;
            case 3:
                return TextShape.TextDirection.VERTICAL_270;
            case 4:
            case 7:
                return TextShape.TextDirection.STACKED;
            default:
                return TextShape.TextDirection.HORIZONTAL;
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public double getTextHeight() {
        return getTextHeight(null);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public List<XSLFTextParagraph> getTextParagraphs() {
        return Collections.unmodifiableList(this._paragraphs);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public TextShape.TextPlaceholder getTextPlaceholder() {
        Placeholder textType = getTextType();
        if (textType == null) {
            return TextShape.TextPlaceholder.BODY;
        }
        int i5 = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$Placeholder[textType.ordinal()];
        if (i5 == 1) {
            return TextShape.TextPlaceholder.BODY;
        }
        if (i5 != 2) {
            return i5 != 3 ? TextShape.TextPlaceholder.OTHER : TextShape.TextPlaceholder.CENTER_TITLE;
        }
        return TextShape.TextPlaceholder.TITLE;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Double getTextRotation() {
        CTTextBodyProperties textBodyPr = getTextBodyPr();
        if (textBodyPr == null || !textBodyPr.isSetRot()) {
            return null;
        }
        return Double.valueOf(((double) textBodyPr.getRot()) / 60000.0d);
    }

    public Placeholder getTextType() {
        return getPlaceholder();
    }

    public double getTopInset() {
        TextBodyPropertyFetcher<Double> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Double>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.6
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetTIns()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextBodyProperties.xgetTIns()))));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        if (textBodyPropertyFetcher.getValue() == null) {
            return 3.6d;
        }
        return textBodyPropertyFetcher.getValue().doubleValue();
    }

    public VerticalAlignment getVerticalAlignment() {
        TextBodyPropertyFetcher<VerticalAlignment> textBodyPropertyFetcher = new TextBodyPropertyFetcher<VerticalAlignment>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.1
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetAnchor()) {
                    return false;
                }
                setValue(VerticalAlignment.values()[cTTextBodyProperties.getAnchor().intValue() - 1]);
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        return textBodyPropertyFetcher.getValue() == null ? VerticalAlignment.TOP : textBodyPropertyFetcher.getValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public boolean getWordWrap() {
        TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.7
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetWrap()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextBodyProperties.getWrap() == STTextWrappingType.SQUARE));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        return textBodyPropertyFetcher.getValue() == null || textBodyPropertyFetcher.getValue().booleanValue();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public boolean isHorizontalCentered() {
        TextBodyPropertyFetcher<Boolean> textBodyPropertyFetcher = new TextBodyPropertyFetcher<Boolean>() { // from class: org.apache.poi.xslf.usermodel.XSLFTextShape.2
            @Override // org.apache.poi.xslf.model.TextBodyPropertyFetcher
            public boolean fetch(CTTextBodyProperties cTTextBodyProperties) {
                if (!cTTextBodyProperties.isSetAnchorCtr()) {
                    return false;
                }
                setValue(Boolean.valueOf(cTTextBodyProperties.getAnchorCtr()));
                return true;
            }
        };
        fetchShapeProperty(textBodyPropertyFetcher);
        return textBodyPropertyFetcher.getValue() != null && textBodyPropertyFetcher.getValue().booleanValue();
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTextParagraph> iterator() {
        return getTextParagraphs().iterator();
    }

    public XSLFTextParagraph newTextParagraph(CTTextParagraph cTTextParagraph) {
        return new XSLFTextParagraph(cTTextParagraph, this);
    }

    public boolean removeTextParagraph(XSLFTextParagraph xSLFTextParagraph) {
        CTTextParagraph xmlObject = xSLFTextParagraph.getXmlObject();
        CTTextBody textBody = getTextBody(false);
        if (textBody != null && this._paragraphs.remove(xSLFTextParagraph)) {
            for (int i5 = 0; i5 < textBody.sizeOfPArray(); i5++) {
                if (textBody.getPArray(i5).equals(xmlObject)) {
                    textBody.removeP(i5);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Rectangle2D resizeToFitText() {
        return resizeToFitText(null);
    }

    public void setBottomInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetBIns();
            } else {
                textBodyPr.setBIns(Integer.valueOf(Units.toEMU(d)));
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setHorizontalCentered(Boolean bool) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (bool != null) {
                textBodyPr.setAnchorCtr(bool.booleanValue());
            } else if (textBodyPr.isSetAnchorCtr()) {
                textBodyPr.unsetAnchorCtr();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setInsets(Insets2D insets2D) {
        setTopInset(insets2D.top);
        setLeftInset(insets2D.left);
        setBottomInset(insets2D.bottom);
        setRightInset(insets2D.right);
    }

    public void setLeftInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetLIns();
            } else {
                textBodyPr.setLIns(Integer.valueOf(Units.toEMU(d)));
            }
        }
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) {
        super.setPlaceholder(placeholder);
    }

    public void setRightInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetRIns();
            } else {
                textBodyPr.setRIns(Integer.valueOf(Units.toEMU(d)));
            }
        }
    }

    public void setTextAutofit(TextShape.TextAutofit textAutofit) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (textBodyPr.isSetSpAutoFit()) {
                textBodyPr.unsetSpAutoFit();
            }
            if (textBodyPr.isSetNoAutofit()) {
                textBodyPr.unsetNoAutofit();
            }
            if (textBodyPr.isSetNormAutofit()) {
                textBodyPr.unsetNormAutofit();
            }
            int i5 = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextAutofit[textAutofit.ordinal()];
            if (i5 == 1) {
                textBodyPr.addNewNoAutofit();
            } else if (i5 == 2) {
                textBodyPr.addNewNormAutofit();
            } else {
                if (i5 != 3) {
                    return;
                }
                textBodyPr.addNewSpAutoFit();
            }
        }
    }

    public void setTextDirection(TextShape.TextDirection textDirection) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (textDirection != null) {
                textBodyPr.setVert(STTextVerticalType.Enum.forInt(textDirection.ordinal() + 1));
            } else if (textBodyPr.isSetVert()) {
                textBodyPr.unsetVert();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setTextPlaceholder(TextShape.TextPlaceholder textPlaceholder) {
        int i5 = AnonymousClass8.$SwitchMap$org$apache$poi$sl$usermodel$TextShape$TextPlaceholder[textPlaceholder.ordinal()];
        if (i5 == 5) {
            setPlaceholder(Placeholder.TITLE);
            return;
        }
        if (i5 == 6) {
            setPlaceholder(Placeholder.BODY);
            setHorizontalCentered(Boolean.TRUE);
        } else if (i5 == 7) {
            setPlaceholder(Placeholder.CENTERED_TITLE);
        } else if (i5 != 8) {
            setPlaceholder(Placeholder.BODY);
        } else {
            setPlaceholder(Placeholder.CONTENT);
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setTextRotation(Double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            textBodyPr.setRot((int) (d.doubleValue() * 60000.0d));
        }
    }

    public void setTopInset(double d) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (d == -1.0d) {
                textBodyPr.unsetTIns();
            } else {
                textBodyPr.setTIns(Integer.valueOf(Units.toEMU(d)));
            }
        }
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            if (verticalAlignment != null) {
                textBodyPr.setAnchor(STTextAnchoringType.Enum.forInt(verticalAlignment.ordinal() + 1));
            } else if (textBodyPr.isSetAnchor()) {
                textBodyPr.unsetAnchor();
            }
        }
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public void setWordWrap(boolean z6) {
        CTTextBodyProperties textBodyPr = getTextBodyPr(true);
        if (textBodyPr != null) {
            textBodyPr.setWrap(z6 ? STTextWrappingType.SQUARE : STTextWrappingType.NONE);
        }
    }

    @Override // java.lang.Iterable
    public Spliterator<XSLFTextParagraph> spliterator() {
        return getTextParagraphs().spliterator();
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public XSLFTextRun appendText(String str, boolean z6) {
        boolean z7;
        XSLFTextParagraph xSLFTextParagraph;
        CTTextParagraphProperties pPr;
        CTTextCharacterProperties rPr;
        CTTextParagraph xmlObject;
        CTTextCharacterProperties endParaRPr;
        XSLFTextRun xSLFTextRun = null;
        if (str == null) {
            return null;
        }
        if (this._paragraphs.isEmpty()) {
            xSLFTextParagraph = null;
            pPr = null;
            rPr = null;
            z7 = false;
        } else {
            z7 = !z6;
            xSLFTextParagraph = (XSLFTextParagraph) AbstractC0157z.f(1, this._paragraphs);
            CTTextParagraph xmlObject2 = xSLFTextParagraph.getXmlObject();
            pPr = xmlObject2.getPPr();
            List<XSLFTextRun> textRuns = xSLFTextParagraph.getTextRuns();
            if (textRuns.isEmpty()) {
                rPr = null;
            } else {
                rPr = ((XSLFTextRun) AbstractC0157z.f(1, textRuns)).getRPr(false);
                if (rPr == null) {
                    rPr = xmlObject2.getEndParaRPr();
                }
            }
        }
        String[] strArrSplit = str.split("\\r\\n?|\\n");
        int length = strArrSplit.length;
        int i5 = 0;
        while (i5 < length) {
            String str2 = strArrSplit[i5];
            if (!z7) {
                if (xSLFTextParagraph != null && (endParaRPr = (xmlObject = xSLFTextParagraph.getXmlObject()).getEndParaRPr()) != null && endParaRPr != rPr) {
                    xmlObject.unsetEndParaRPr();
                }
                XSLFTextParagraph xSLFTextParagraphAddNewTextParagraph = addNewTextParagraph();
                if (pPr != null) {
                    xSLFTextParagraphAddNewTextParagraph.getXmlObject().setPPr(pPr);
                }
                xSLFTextParagraph = xSLFTextParagraphAddNewTextParagraph;
            }
            String[] strArrSplit2 = str2.split("[\u000b]");
            int length2 = strArrSplit2.length;
            int i6 = 0;
            boolean z8 = true;
            while (i6 < length2) {
                String str3 = strArrSplit2[i6];
                if (!z8) {
                    xSLFTextParagraph.addLineBreak();
                }
                XSLFTextRun xSLFTextRunAddNewTextRun = xSLFTextParagraph.addNewTextRun();
                xSLFTextRunAddNewTextRun.setText(str3);
                if (rPr != null) {
                    xSLFTextRunAddNewTextRun.getRPr(true).set(rPr);
                }
                i6++;
                xSLFTextRun = xSLFTextRunAddNewTextRun;
                z8 = false;
            }
            i5++;
            z7 = false;
        }
        return xSLFTextRun;
    }

    public CTTextBodyProperties getTextBodyPr(boolean z6) {
        CTTextBody textBody = getTextBody(z6);
        if (textBody == null) {
            return null;
        }
        CTTextBodyProperties bodyPr = textBody.getBodyPr();
        return (bodyPr == null && z6) ? textBody.addNewBodyPr() : bodyPr;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public double getTextHeight(Graphics2D graphics2D) {
        return DrawFactory.getInstance(graphics2D).getDrawable((TextShape<?, ?>) this).getTextHeight(graphics2D);
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public Rectangle2D resizeToFitText(Graphics2D graphics2D) {
        Rectangle2D anchor = getAnchor();
        if (anchor.getWidth() == 0.0d) {
            throw new POIXMLException("Anchor of the shape was not set.");
        }
        double textHeight = getTextHeight(graphics2D) + 1.0d;
        Insets2D insets = getInsets();
        anchor.setRect(anchor.getX(), anchor.getY(), anchor.getWidth(), textHeight + insets.top + insets.bottom);
        setAnchor(anchor);
        return anchor;
    }

    @Override // org.apache.poi.sl.usermodel.TextShape
    public XSLFTextRun setText(String str) {
        if (!this._paragraphs.isEmpty()) {
            CTTextBody textBody = getTextBody(false);
            for (int iSizeOfPArray = textBody.sizeOfPArray(); iSizeOfPArray > 1; iSizeOfPArray--) {
                int i5 = iSizeOfPArray - 1;
                textBody.removeP(i5);
                this._paragraphs.remove(i5);
            }
            this._paragraphs.get(0).clearButKeepProperties();
        }
        return appendText(str, false);
    }
}
