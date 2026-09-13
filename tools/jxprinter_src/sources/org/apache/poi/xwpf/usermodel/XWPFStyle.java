package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFStyle {
    private CTStyle ctStyle;
    protected XWPFStyles styles;

    public XWPFStyle(CTStyle cTStyle) {
        this(cTStyle, null);
    }

    public String getBasisStyleID() {
        if (this.ctStyle.getBasedOn() != null) {
            return this.ctStyle.getBasedOn().getVal();
        }
        return null;
    }

    public CTStyle getCTStyle() {
        return this.ctStyle;
    }

    public String getLinkStyleID() {
        if (this.ctStyle.getLink() != null) {
            return this.ctStyle.getLink().getVal();
        }
        return null;
    }

    public String getName() {
        if (this.ctStyle.isSetName()) {
            return this.ctStyle.getName().getVal();
        }
        return null;
    }

    public String getNextStyleID() {
        if (this.ctStyle.getNext() != null) {
            return this.ctStyle.getNext().getVal();
        }
        return null;
    }

    public String getStyleId() {
        return this.ctStyle.getStyleId();
    }

    public XWPFStyles getStyles() {
        return this.styles;
    }

    public STStyleType.Enum getType() {
        return this.ctStyle.getType();
    }

    public boolean hasSameName(XWPFStyle xWPFStyle) {
        return xWPFStyle.getCTStyle().getName().getVal().equals(this.ctStyle.getName().getVal());
    }

    public void setStyle(CTStyle cTStyle) {
        this.ctStyle = cTStyle;
    }

    public void setStyleId(String str) {
        this.ctStyle.setStyleId(str);
    }

    public void setType(STStyleType.Enum r6) {
        this.ctStyle.setType(r6);
    }

    public XWPFStyle(CTStyle cTStyle, XWPFStyles xWPFStyles) {
        this.ctStyle = cTStyle;
        this.styles = xWPFStyles;
    }
}
