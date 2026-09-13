package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.xddf.usermodel.text.TextContainer;
import org.apache.poi.xddf.usermodel.text.XDDFRunProperties;
import org.apache.poi.xddf.usermodel.text.XDDFTextBody;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFTitle {
    private final TextContainer parent;
    private final CTTitle title;

    public XDDFTitle(TextContainer textContainer, CTTitle cTTitle) {
        this.parent = textContainer;
        this.title = cTTitle;
    }

    public XDDFTextBody getBody() {
        if (!this.title.isSetTx()) {
            this.title.addNewTx();
        }
        CTTx tx = this.title.getTx();
        if (tx.isSetStrRef()) {
            tx.unsetStrRef();
        }
        if (!tx.isSetRich()) {
            tx.addNewRich();
        }
        return new XDDFTextBody(this.parent, tx.getRich());
    }

    public XDDFRunProperties getOrAddTextProperties() {
        return new XDDFRunProperties(getOrAddTextProperties(this.title.isSetTxPr() ? this.title.getTxPr() : this.title.addNewTxPr()));
    }

    public void setOverlay(Boolean bool) {
        if (bool == null) {
            if (this.title.isSetOverlay()) {
                this.title.unsetOverlay();
            }
        } else if (this.title.isSetOverlay()) {
            this.title.getOverlay().setVal(bool.booleanValue());
        } else {
            this.title.addNewOverlay().setVal(bool.booleanValue());
        }
    }

    public void setText(String str) {
        if (str == null) {
            if (this.title.isSetTx()) {
                this.title.unsetTx();
            }
        } else {
            if (!this.title.isSetLayout()) {
                this.title.addNewLayout();
            }
            getBody().setText(str);
        }
    }

    private CTTextCharacterProperties getOrAddTextProperties(CTTextBody cTTextBody) {
        CTTextParagraph cTTextParagraphAddNewP;
        CTTextParagraphProperties cTTextParagraphPropertiesAddNewPPr;
        if (cTTextBody.getBodyPr() == null) {
            cTTextBody.addNewBodyPr();
        }
        if (cTTextBody.sizeOfPArray() > 0) {
            cTTextParagraphAddNewP = cTTextBody.getPArray(0);
        } else {
            cTTextParagraphAddNewP = cTTextBody.addNewP();
        }
        if (cTTextParagraphAddNewP.isSetPPr()) {
            cTTextParagraphPropertiesAddNewPPr = cTTextParagraphAddNewP.getPPr();
        } else {
            cTTextParagraphPropertiesAddNewPPr = cTTextParagraphAddNewP.addNewPPr();
        }
        if (cTTextParagraphPropertiesAddNewPPr.isSetDefRPr()) {
            return cTTextParagraphPropertiesAddNewPPr.getDefRPr();
        }
        return cTTextParagraphPropertiesAddNewPPr.addNewDefRPr();
    }
}
