package org.apache.poi.xddf.usermodel.text;

import org.apache.poi.common.usermodel.fonts.FontGroup;
import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFParagraphBulletProperties {
    private CTTextParagraphProperties props;

    @Internal
    public XDDFParagraphBulletProperties(CTTextParagraphProperties cTTextParagraphProperties) {
        this.props = cTTextParagraphProperties;
    }

    public void clearAll() {
        if (this.props.isSetBuAutoNum()) {
            this.props.unsetBuAutoNum();
        }
        if (this.props.isSetBuBlip()) {
            this.props.unsetBuBlip();
        }
        if (this.props.isSetBuChar()) {
            this.props.unsetBuChar();
        }
        if (this.props.isSetBuNone()) {
            this.props.unsetBuNone();
        }
        if (this.props.isSetBuClr()) {
            this.props.unsetBuClr();
        }
        if (this.props.isSetBuClrTx()) {
            this.props.unsetBuClrTx();
        }
        if (this.props.isSetBuFont()) {
            this.props.unsetBuFont();
        }
        if (this.props.isSetBuFontTx()) {
            this.props.unsetBuFontTx();
        }
        if (this.props.isSetBuSzPct()) {
            this.props.unsetBuSzPct();
        }
        if (this.props.isSetBuSzPts()) {
            this.props.unsetBuSzPts();
        }
        if (this.props.isSetBuSzTx()) {
            this.props.unsetBuSzTx();
        }
    }

    public XDDFColor getBulletColor() {
        if (this.props.isSetBuClr()) {
            return XDDFColor.forColorContainer(this.props.getBuClr());
        }
        return null;
    }

    public XDDFFont getBulletFont() {
        if (this.props.isSetBuFont()) {
            return new XDDFFont(FontGroup.SYMBOL, this.props.getBuFont());
        }
        return null;
    }

    public XDDFBulletSize getBulletSize() {
        if (this.props.isSetBuSzPct()) {
            return new XDDFBulletSizePercent(this.props.getBuSzPct(), null);
        }
        if (this.props.isSetBuSzPts()) {
            return new XDDFBulletSizePoints(this.props.getBuSzPts());
        }
        if (this.props.isSetBuSzTx()) {
            return new XDDFBulletSizeFollowText(this.props.getBuSzTx());
        }
        return null;
    }

    public XDDFBulletStyle getBulletStyle() {
        if (this.props.isSetBuAutoNum()) {
            return new XDDFBulletStyleAutoNumbered(this.props.getBuAutoNum());
        }
        if (this.props.isSetBuBlip()) {
            return new XDDFBulletStylePicture(this.props.getBuBlip());
        }
        if (this.props.isSetBuChar()) {
            return new XDDFBulletStyleCharacter(this.props.getBuChar());
        }
        if (this.props.isSetBuNone()) {
            return new XDDFBulletStyleNone(this.props.getBuNone());
        }
        return null;
    }

    public CTTextParagraphProperties getXmlObject() {
        return this.props;
    }

    public void setBulletColor(XDDFColor xDDFColor) {
        if (this.props.isSetBuClrTx()) {
            this.props.unsetBuClrTx();
        }
        if (xDDFColor != null) {
            this.props.setBuClr(xDDFColor.getColorContainer());
        } else if (this.props.isSetBuClr()) {
            this.props.unsetBuClr();
        }
    }

    public void setBulletColorFollowText() {
        if (this.props.isSetBuClr()) {
            this.props.unsetBuClr();
        }
        if (this.props.isSetBuClrTx()) {
            return;
        }
        this.props.addNewBuClrTx();
    }

    public void setBulletFont(XDDFFont xDDFFont) {
        if (this.props.isSetBuFontTx()) {
            this.props.unsetBuFontTx();
        }
        if (xDDFFont != null) {
            this.props.setBuFont(xDDFFont.getXmlObject());
        } else if (this.props.isSetBuFont()) {
            this.props.unsetBuFont();
        }
    }

    public void setBulletFontFollowText() {
        if (this.props.isSetBuFont()) {
            this.props.unsetBuFont();
        }
        if (this.props.isSetBuFontTx()) {
            return;
        }
        this.props.addNewBuFontTx();
    }

    public void setBulletSize(XDDFBulletSize xDDFBulletSize) {
        if (this.props.isSetBuSzPct()) {
            this.props.unsetBuSzPct();
        }
        if (this.props.isSetBuSzPts()) {
            this.props.unsetBuSzPts();
        }
        if (this.props.isSetBuSzTx()) {
            this.props.unsetBuSzTx();
        }
        if (xDDFBulletSize != null) {
            if (xDDFBulletSize instanceof XDDFBulletSizeFollowText) {
                this.props.setBuSzTx(((XDDFBulletSizeFollowText) xDDFBulletSize).getXmlObject());
            } else if (xDDFBulletSize instanceof XDDFBulletSizePercent) {
                this.props.setBuSzPct(((XDDFBulletSizePercent) xDDFBulletSize).getXmlObject());
            } else if (xDDFBulletSize instanceof XDDFBulletSizePoints) {
                this.props.setBuSzPts(((XDDFBulletSizePoints) xDDFBulletSize).getXmlObject());
            }
        }
    }

    public void setBulletStyle(XDDFBulletStyle xDDFBulletStyle) {
        if (this.props.isSetBuAutoNum()) {
            this.props.unsetBuAutoNum();
        }
        if (this.props.isSetBuBlip()) {
            this.props.unsetBuBlip();
        }
        if (this.props.isSetBuChar()) {
            this.props.unsetBuChar();
        }
        if (this.props.isSetBuNone()) {
            this.props.unsetBuNone();
        }
        if (xDDFBulletStyle != null) {
            if (xDDFBulletStyle instanceof XDDFBulletStyleAutoNumbered) {
                this.props.setBuAutoNum(((XDDFBulletStyleAutoNumbered) xDDFBulletStyle).getXmlObject());
                return;
            }
            if (xDDFBulletStyle instanceof XDDFBulletStyleCharacter) {
                this.props.setBuChar(((XDDFBulletStyleCharacter) xDDFBulletStyle).getXmlObject());
            } else if (xDDFBulletStyle instanceof XDDFBulletStyleNone) {
                this.props.setBuNone(((XDDFBulletStyleNone) xDDFBulletStyle).getXmlObject());
            } else if (xDDFBulletStyle instanceof XDDFBulletStylePicture) {
                this.props.setBuBlip(((XDDFBulletStylePicture) xDDFBulletStyle).getXmlObject());
            }
        }
    }
}
