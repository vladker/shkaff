package org.apache.poi.xddf.usermodel.text;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTextBody {
    private CTTextBody _body;
    private TextContainer _parent;

    public XDDFTextBody(TextContainer textContainer) {
        this(textContainer, CTTextBody.Factory.newInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ XDDFTextParagraph lambda$getParagraphs$0(CTTextParagraph cTTextParagraph) {
        return new XDDFTextParagraph(cTTextParagraph, this);
    }

    private CTTextParagraphProperties retrieveProperties(CTTextListStyle cTTextListStyle, int i5) {
        switch (i5) {
            case 1:
                if (cTTextListStyle.isSetLvl1PPr()) {
                    return cTTextListStyle.getLvl1PPr();
                }
                return null;
            case 2:
                if (cTTextListStyle.isSetLvl2PPr()) {
                    return cTTextListStyle.getLvl2PPr();
                }
                return null;
            case 3:
                if (cTTextListStyle.isSetLvl3PPr()) {
                    return cTTextListStyle.getLvl3PPr();
                }
                return null;
            case 4:
                if (cTTextListStyle.isSetLvl4PPr()) {
                    return cTTextListStyle.getLvl4PPr();
                }
                return null;
            case 5:
                if (cTTextListStyle.isSetLvl5PPr()) {
                    return cTTextListStyle.getLvl5PPr();
                }
                return null;
            case 6:
                if (cTTextListStyle.isSetLvl6PPr()) {
                    return cTTextListStyle.getLvl6PPr();
                }
                return null;
            case 7:
                if (cTTextListStyle.isSetLvl7PPr()) {
                    return cTTextListStyle.getLvl7PPr();
                }
                return null;
            case 8:
                if (cTTextListStyle.isSetLvl8PPr()) {
                    return cTTextListStyle.getLvl8PPr();
                }
                return null;
            case 9:
                if (cTTextListStyle.isSetLvl9PPr()) {
                    return cTTextListStyle.getLvl9PPr();
                }
                return null;
            default:
                return null;
        }
    }

    public XDDFTextParagraph addNewParagraph() {
        return new XDDFTextParagraph(this._body.addNewP(), this);
    }

    @Internal
    public <R> Optional<R> findDefinedParagraphProperty(Predicate<CTTextParagraphProperties> predicate, Function<CTTextParagraphProperties, R> function, int i5) {
        if (!this._body.isSetLstStyle() || i5 < 0) {
            TextContainer textContainer = this._parent;
            return textContainer != null ? textContainer.findDefinedParagraphProperty(predicate, function) : Optional.empty();
        }
        CTTextListStyle lstStyle = this._body.getLstStyle();
        CTTextParagraphProperties defPPr = i5 == 0 ? lstStyle.getDefPPr() : retrieveProperties(lstStyle, i5);
        return (defPPr == null || !predicate.test(defPPr)) ? findDefinedParagraphProperty(predicate, function, i5 - 1) : Optional.of(function.apply(defPPr));
    }

    @Internal
    public <R> Optional<R> findDefinedRunProperty(Predicate<CTTextCharacterProperties> predicate, Function<CTTextCharacterProperties, R> function, int i5) {
        if (!this._body.isSetLstStyle() || i5 < 0) {
            TextContainer textContainer = this._parent;
            return textContainer != null ? textContainer.findDefinedRunProperty(predicate, function) : Optional.empty();
        }
        CTTextListStyle lstStyle = this._body.getLstStyle();
        CTTextParagraphProperties defPPr = i5 == 0 ? lstStyle.getDefPPr() : retrieveProperties(lstStyle, i5);
        return (defPPr != null && defPPr.isSetDefRPr() && predicate.test(defPPr.getDefRPr())) ? Optional.of(function.apply(defPPr.getDefRPr())) : findDefinedRunProperty(predicate, function, i5 - 1);
    }

    public XDDFBodyProperties getBodyProperties() {
        return new XDDFBodyProperties(this._body.getBodyPr());
    }

    public XDDFParagraphProperties getDefaultProperties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetDefPPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getDefPPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel1Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl1PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl1PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel2Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl2PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl2PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel3Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl3PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl3PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel4Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl4PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl4PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel5Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl5PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl5PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel6Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl6PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl6PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel7Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl7PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl7PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel8Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl8PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl8PPr());
        }
        return null;
    }

    public XDDFParagraphProperties getLevel9Properties() {
        if (this._body.isSetLstStyle() && this._body.getLstStyle().isSetLvl9PPr()) {
            return new XDDFParagraphProperties(this._body.getLstStyle().getLvl9PPr());
        }
        return null;
    }

    public XDDFTextParagraph getParagraph(int i5) {
        return new XDDFTextParagraph(this._body.getPArray(i5), this);
    }

    public List<XDDFTextParagraph> getParagraphs() {
        return Collections.unmodifiableList((List) this._body.getPList().stream().map(new com.google.android.material.color.utilities.a(this, 5)).collect(Collectors.toList()));
    }

    public TextContainer getParentShape() {
        return this._parent;
    }

    @Internal
    public CTTextBody getXmlObject() {
        return this._body;
    }

    public XDDFTextParagraph initialize() {
        this._body.addNewLstStyle();
        this._body.addNewBodyPr();
        XDDFBodyProperties bodyProperties = getBodyProperties();
        bodyProperties.setAnchoring(AnchorType.TOP);
        bodyProperties.setRightToLeft(Boolean.FALSE);
        XDDFTextParagraph xDDFTextParagraphAddNewParagraph = addNewParagraph();
        xDDFTextParagraphAddNewParagraph.setTextAlignment(TextAlignment.LEFT);
        xDDFTextParagraphAddNewParagraph.appendRegularRun("");
        XDDFRunProperties xDDFRunPropertiesAddAfterLastRunProperties = xDDFTextParagraphAddNewParagraph.addAfterLastRunProperties();
        xDDFRunPropertiesAddAfterLastRunProperties.setLanguage(Locale.US);
        xDDFRunPropertiesAddAfterLastRunProperties.setFontSize(Double.valueOf(11.0d));
        return xDDFTextParagraphAddNewParagraph;
    }

    public XDDFTextParagraph insertNewParagraph(int i5) {
        return new XDDFTextParagraph(this._body.insertNewP(i5), this);
    }

    public void removeParagraph(int i5) {
        this._body.removeP(i5);
    }

    public void setBodyProperties(XDDFBodyProperties xDDFBodyProperties) {
        if (xDDFBodyProperties == null) {
            this._body.addNewBodyPr();
        } else {
            this._body.setBodyPr(xDDFBodyProperties.getXmlObject());
        }
    }

    public void setDefaultProperties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setDefPPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetDefPPr()) {
                lstStyle.unsetDefPPr();
            }
        }
    }

    public void setLevel1Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl1PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl1PPr()) {
                lstStyle.unsetLvl1PPr();
            }
        }
    }

    public void setLevel2Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl2PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl2PPr()) {
                lstStyle.unsetLvl2PPr();
            }
        }
    }

    public void setLevel3Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl3PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl3PPr()) {
                lstStyle.unsetLvl3PPr();
            }
        }
    }

    public void setLevel4Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl4PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl4PPr()) {
                lstStyle.unsetLvl4PPr();
            }
        }
    }

    public void setLevel5Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl5PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl5PPr()) {
                lstStyle.unsetLvl5PPr();
            }
        }
    }

    public void setLevel6Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl6PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl6PPr()) {
                lstStyle.unsetLvl6PPr();
            }
        }
    }

    public void setLevel7Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl7PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl7PPr()) {
                lstStyle.unsetLvl7PPr();
            }
        }
    }

    public void setLevel8Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl8PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl8PPr()) {
                lstStyle.unsetLvl8PPr();
            }
        }
    }

    public void setLevel9Properties(XDDFParagraphProperties xDDFParagraphProperties) {
        if (xDDFParagraphProperties != null) {
            (this._body.isSetLstStyle() ? this._body.getLstStyle() : this._body.addNewLstStyle()).setLvl9PPr(xDDFParagraphProperties.getXmlObject());
        } else if (this._body.isSetLstStyle()) {
            CTTextListStyle lstStyle = this._body.getLstStyle();
            if (lstStyle.isSetLvl9PPr()) {
                lstStyle.unsetLvl9PPr();
            }
        }
    }

    public void setText(String str) {
        if (this._body.sizeOfPArray() <= 0) {
            initialize().setText(str);
            return;
        }
        for (int iSizeOfPArray = this._body.sizeOfPArray() - 1; iSizeOfPArray > 0; iSizeOfPArray--) {
            this._body.removeP(iSizeOfPArray);
        }
        getParagraph(0).setText(str);
    }

    @Internal
    public XDDFTextBody(TextContainer textContainer, CTTextBody cTTextBody) {
        this._parent = textContainer;
        this._body = cTTextBody;
    }
}
