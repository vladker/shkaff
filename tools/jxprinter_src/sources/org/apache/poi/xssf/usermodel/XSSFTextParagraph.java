package org.apache.poi.xssf.usermodel;

import A3.AbstractC0157z;
import androidx.webkit.ProxyConfig;
import com.google.common.primitives.UnsignedBytes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.model.ParagraphPropertyFetcher;
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
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStopList;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontAlignType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFTextParagraph implements Iterable<XSSFTextRun> {
    private final CTTextParagraph _p;
    private final List<XSSFTextRun> _runs = new ArrayList();
    private final CTShape _shape;

    public XSSFTextParagraph(CTTextParagraph cTTextParagraph, CTShape cTShape) {
        this._p = cTTextParagraph;
        this._shape = cTShape;
        for (XmlObject xmlObject : cTTextParagraph.selectPath(ProxyConfig.MATCH_ALL_SCHEMES)) {
            if (xmlObject instanceof CTRegularTextRun) {
                this._runs.add(new XSSFTextRun((CTRegularTextRun) xmlObject, this));
            } else if (xmlObject instanceof CTTextLineBreak) {
                CTRegularTextRun cTRegularTextRunNewInstance = CTRegularTextRun.Factory.newInstance();
                cTRegularTextRunNewInstance.setRPr(((CTTextLineBreak) xmlObject).getRPr());
                cTRegularTextRunNewInstance.setT("\n");
                this._runs.add(new XSSFTextRun(cTRegularTextRunNewInstance, this));
            } else if (xmlObject instanceof CTTextField) {
                CTTextField cTTextField = (CTTextField) xmlObject;
                CTRegularTextRun cTRegularTextRunNewInstance2 = CTRegularTextRun.Factory.newInstance();
                cTRegularTextRunNewInstance2.setRPr(cTTextField.getRPr());
                cTRegularTextRunNewInstance2.setT(cTTextField.getT());
                this._runs.add(new XSSFTextRun(cTRegularTextRunNewInstance2, this));
            }
        }
    }

    private boolean fetchParagraphProperty(ParagraphPropertyFetcher paragraphPropertyFetcher) {
        boolean zFetch = this._p.isSetPPr() ? paragraphPropertyFetcher.fetch(this._p.getPPr()) : false;
        return !zFetch ? paragraphPropertyFetcher.fetch(this._shape) : zFetch;
    }

    public XSSFTextRun addLineBreak() {
        CTTextCharacterProperties cTTextCharacterPropertiesAddNewRPr = this._p.addNewBr().addNewRPr();
        if (!this._runs.isEmpty()) {
            cTTextCharacterPropertiesAddNewRPr.set(((XSSFTextRun) AbstractC0157z.f(1, this._runs)).getRPr());
        }
        CTRegularTextRun cTRegularTextRunNewInstance = CTRegularTextRun.Factory.newInstance();
        cTRegularTextRunNewInstance.setRPr(cTTextCharacterPropertiesAddNewRPr);
        cTRegularTextRunNewInstance.setT("\n");
        XSSFLineBreak xSSFLineBreak = new XSSFLineBreak(cTRegularTextRunNewInstance, this, cTTextCharacterPropertiesAddNewRPr);
        this._runs.add(xSSFLineBreak);
        return xSSFLineBreak;
    }

    public XSSFTextRun addNewTextRun() {
        CTRegularTextRun cTRegularTextRunAddNewR = this._p.addNewR();
        cTRegularTextRunAddNewR.addNewRPr().setLang("en-US");
        XSSFTextRun xSSFTextRun = new XSSFTextRun(cTRegularTextRunAddNewR, this);
        this._runs.add(xSSFTextRun);
        return xSSFTextRun;
    }

    public void addTabStop(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetTabLst() ? pPr.getTabLst() : pPr.addNewTabLst()).addNewTab().setPos(Integer.valueOf(Units.toEMU(d)));
    }

    public ListAutoNumber getBulletAutoNumberScheme() {
        ParagraphPropertyFetcher<ListAutoNumber> paragraphPropertyFetcher = new ParagraphPropertyFetcher<ListAutoNumber>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.18
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuAutoNum()) {
                    return false;
                }
                setValue(ListAutoNumber.values()[cTTextParagraphProperties.getBuAutoNum().getType().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue() == null ? ListAutoNumber.ARABIC_PLAIN : paragraphPropertyFetcher.getValue();
    }

    public int getBulletAutoNumberStart() {
        ParagraphPropertyFetcher<Integer> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Integer>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.17
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuAutoNum() || !cTTextParagraphProperties.getBuAutoNum().isSetStartAt()) {
                    return false;
                }
                setValue(Integer.valueOf(cTTextParagraphProperties.getBuAutoNum().getStartAt()));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0;
        }
        return paragraphPropertyFetcher.getValue().intValue();
    }

    public String getBulletCharacter() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.4
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuChar()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuChar().getChar());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public String getBulletFont() {
        ParagraphPropertyFetcher<String> paragraphPropertyFetcher = new ParagraphPropertyFetcher<String>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.3
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuFont()) {
                    return false;
                }
                setValue(cTTextParagraphProperties.getBuFont().getTypeface());
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public Color getBulletFontColor() {
        ParagraphPropertyFetcher<Color> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Color>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.5
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuClr() || !cTTextParagraphProperties.getBuClr().isSetSrgbClr()) {
                    return false;
                }
                byte[] val = cTTextParagraphProperties.getBuClr().getSrgbClr().getVal();
                setValue(new Color(val[0] & UnsignedBytes.MAX_VALUE, val[1] & UnsignedBytes.MAX_VALUE, val[2] & UnsignedBytes.MAX_VALUE));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue();
    }

    public double getBulletFontSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.6
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuSzPct()) {
                    setValue(Double.valueOf(((double) POIXMLUnits.parsePercent(cTTextParagraphProperties.getBuSzPct().xgetVal())) * 0.001d));
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuSzPts()) {
                    return false;
                }
                setValue(Double.valueOf(((double) (-cTTextParagraphProperties.getBuSzPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 100.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getDefaultTabSize() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.10
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetDefTabSz()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(cTTextParagraphProperties.xgetDefTabSz()))));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getIndent() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.7
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetIndent()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getIndent())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getLeftMargin() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.8
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetMarL()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarL())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public int getLevel() {
        CTTextParagraphProperties pPr = this._p.getPPr();
        if (pPr == null) {
            return 0;
        }
        return pPr.getLvl();
    }

    public double getLineSpacing() {
        CTTextNormalAutofit normAutofit;
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.12
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetLnSpc()) {
                    return false;
                }
                CTTextSpacing lnSpc = cTTextParagraphProperties.getLnSpc();
                if (lnSpc.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) POIXMLUnits.parsePercent(lnSpc.getSpcPct().xgetVal())) * 0.001d));
                    return true;
                }
                if (!lnSpc.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-lnSpc.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        double dDoubleValue = paragraphPropertyFetcher.getValue() == null ? 100.0d : paragraphPropertyFetcher.getValue().doubleValue();
        return (dDoubleValue <= 0.0d || (normAutofit = this._shape.getTxBody().getBodyPr().getNormAutofit()) == null) ? dDoubleValue : (1.0d - (((Double) normAutofit.getLnSpcReduction()).doubleValue() / 100000.0d)) * dDoubleValue;
    }

    @Internal
    public CTShape getParentShape() {
        return this._shape;
    }

    public double getRightMargin() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.9
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetMarR()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(cTTextParagraphProperties.getMarR())));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getSpaceAfter() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.14
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcAft()) {
                    return false;
                }
                CTTextSpacing spcAft = cTTextParagraphProperties.getSpcAft();
                if (spcAft.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) POIXMLUnits.parsePercent(spcAft.getSpcPct().xgetVal())) * 0.001d));
                    return true;
                }
                if (!spcAft.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-spcAft.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getSpaceBefore() {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.13
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetSpcBef()) {
                    return false;
                }
                CTTextSpacing spcBef = cTTextParagraphProperties.getSpcBef();
                if (spcBef.isSetSpcPct()) {
                    setValue(Double.valueOf(((double) POIXMLUnits.parsePercent(spcBef.getSpcPct().xgetVal())) * 0.001d));
                    return true;
                }
                if (!spcBef.isSetSpcPts()) {
                    return true;
                }
                setValue(Double.valueOf(((double) (-spcBef.getSpcPts().getVal())) * 0.01d));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public double getTabStop(final int i5) {
        ParagraphPropertyFetcher<Double> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Double>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.11
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetTabLst()) {
                    return false;
                }
                CTTextTabStopList tabLst = cTTextParagraphProperties.getTabLst();
                if (i5 >= tabLst.sizeOfTabArray()) {
                    return false;
                }
                setValue(Double.valueOf(Units.toPoints(POIXMLUnits.parseLength(tabLst.getTabArray(i5).xgetPos()))));
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return 0.0d;
        }
        return paragraphPropertyFetcher.getValue().doubleValue();
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        Iterator<XSSFTextRun> it = this._runs.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getText());
        }
        return sb.toString();
    }

    public TextAlign getTextAlign() {
        ParagraphPropertyFetcher<TextAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextAlign>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.1
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetAlgn()) {
                    return false;
                }
                setValue(TextAlign.values()[cTTextParagraphProperties.getAlgn().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue() == null ? TextAlign.LEFT : paragraphPropertyFetcher.getValue();
    }

    public TextFontAlign getTextFontAlign() {
        ParagraphPropertyFetcher<TextFontAlign> paragraphPropertyFetcher = new ParagraphPropertyFetcher<TextFontAlign>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.2
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetFontAlgn()) {
                    return false;
                }
                setValue(TextFontAlign.values()[cTTextParagraphProperties.getFontAlgn().intValue() - 1]);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        return paragraphPropertyFetcher.getValue() == null ? TextFontAlign.BASELINE : paragraphPropertyFetcher.getValue();
    }

    public List<XSSFTextRun> getTextRuns() {
        return this._runs;
    }

    @Internal
    public CTTextParagraph getXmlObject() {
        return this._p;
    }

    public boolean isBullet() {
        ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.15
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (cTTextParagraphProperties.isSetBuNone()) {
                    setValue(Boolean.FALSE);
                    return true;
                }
                if (!cTTextParagraphProperties.isSetBuFont()) {
                    return false;
                }
                if (!cTTextParagraphProperties.isSetBuChar() && !cTTextParagraphProperties.isSetBuAutoNum()) {
                    return false;
                }
                setValue(Boolean.TRUE);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return false;
        }
        return paragraphPropertyFetcher.getValue().booleanValue();
    }

    public boolean isBulletAutoNumber() {
        ParagraphPropertyFetcher<Boolean> paragraphPropertyFetcher = new ParagraphPropertyFetcher<Boolean>(getLevel()) { // from class: org.apache.poi.xssf.usermodel.XSSFTextParagraph.16
            @Override // org.apache.poi.xssf.model.ParagraphPropertyFetcher
            public boolean fetch(CTTextParagraphProperties cTTextParagraphProperties) {
                if (!cTTextParagraphProperties.isSetBuAutoNum()) {
                    return false;
                }
                setValue(Boolean.TRUE);
                return true;
            }
        };
        fetchParagraphProperty(paragraphPropertyFetcher);
        if (paragraphPropertyFetcher.getValue() == null) {
            return false;
        }
        return paragraphPropertyFetcher.getValue().booleanValue();
    }

    @Override // java.lang.Iterable
    public Iterator<XSSFTextRun> iterator() {
        return this._runs.iterator();
    }

    public void setBullet(boolean z6) {
        if (isBullet() == z6) {
            return;
        }
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (z6) {
            if (pPr.isSetBuNone()) {
                pPr.unsetBuNone();
            }
            if (!pPr.isSetBuFont()) {
                pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
            }
            if (pPr.isSetBuAutoNum()) {
                return;
            }
            pPr.addNewBuChar().setChar("•");
            return;
        }
        pPr.addNewBuNone();
        if (pPr.isSetBuAutoNum()) {
            pPr.unsetBuAutoNum();
        }
        if (pPr.isSetBuBlip()) {
            pPr.unsetBuBlip();
        }
        if (pPr.isSetBuChar()) {
            pPr.unsetBuChar();
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
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTColor buClr = pPr.isSetBuClr() ? pPr.getBuClr() : pPr.addNewBuClr();
        (buClr.isSetSrgbClr() ? buClr.getSrgbClr() : buClr.addNewSrgbClr()).setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
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

    public void setIndent(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d != -1.0d) {
            pPr.setIndent(Units.toEMU(d));
        } else if (pPr.isSetIndent()) {
            pPr.unsetIndent();
        }
    }

    public void setLeftMargin(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d != -1.0d) {
            pPr.setMarL(Units.toEMU(d));
        } else if (pPr.isSetMarL()) {
            pPr.unsetMarL();
        }
    }

    public void setLevel(int i5) {
        (this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr()).setLvl(i5);
    }

    public void setLineSpacing(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing cTTextSpacingNewInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            cTTextSpacingNewInstance.addNewSpcPct().setVal(Integer.valueOf((int) (d * 1000.0d)));
        } else {
            cTTextSpacingNewInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setLnSpc(cTTextSpacingNewInstance);
    }

    public void setRightMargin(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (d != -1.0d) {
            pPr.setMarR(Units.toEMU(d));
        } else if (pPr.isSetMarR()) {
            pPr.unsetMarR();
        }
    }

    public void setSpaceAfter(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing cTTextSpacingNewInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            cTTextSpacingNewInstance.addNewSpcPct().setVal(Integer.valueOf((int) (d * 1000.0d)));
        } else {
            cTTextSpacingNewInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setSpcAft(cTTextSpacingNewInstance);
    }

    public void setSpaceBefore(double d) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        CTTextSpacing cTTextSpacingNewInstance = CTTextSpacing.Factory.newInstance();
        if (d >= 0.0d) {
            cTTextSpacingNewInstance.addNewSpcPct().setVal(Integer.valueOf((int) (d * 1000.0d)));
        } else {
            cTTextSpacingNewInstance.addNewSpcPts().setVal((int) ((-d) * 100.0d));
        }
        pPr.setSpcBef(cTTextSpacingNewInstance);
    }

    public void setTextAlign(TextAlign textAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (textAlign != null) {
            pPr.setAlgn(STTextAlignType.Enum.forInt(textAlign.ordinal() + 1));
        } else if (pPr.isSetAlgn()) {
            pPr.unsetAlgn();
        }
    }

    public void setTextFontAlign(TextFontAlign textFontAlign) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        if (textFontAlign != null) {
            pPr.setFontAlgn(STTextFontAlignType.Enum.forInt(textFontAlign.ordinal() + 1));
        } else if (pPr.isSetFontAlgn()) {
            pPr.unsetFontAlgn();
        }
    }

    public String toString() {
        return "[" + getClass() + "]" + getText();
    }

    public void setBullet(ListAutoNumber listAutoNumber, int i5) {
        if (i5 >= 1) {
            CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
            CTTextAutonumberBullet buAutoNum = pPr.isSetBuAutoNum() ? pPr.getBuAutoNum() : pPr.addNewBuAutoNum();
            buAutoNum.setType(STTextAutonumberScheme.Enum.forInt(listAutoNumber.ordinal() + 1));
            buAutoNum.setStartAt(i5);
            if (!pPr.isSetBuFont()) {
                pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
            }
            if (pPr.isSetBuNone()) {
                pPr.unsetBuNone();
            }
            if (pPr.isSetBuBlip()) {
                pPr.unsetBuBlip();
            }
            if (pPr.isSetBuChar()) {
                pPr.unsetBuChar();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Start Number must be greater or equal that 1");
    }

    public void setBullet(ListAutoNumber listAutoNumber) {
        CTTextParagraphProperties pPr = this._p.isSetPPr() ? this._p.getPPr() : this._p.addNewPPr();
        (pPr.isSetBuAutoNum() ? pPr.getBuAutoNum() : pPr.addNewBuAutoNum()).setType(STTextAutonumberScheme.Enum.forInt(listAutoNumber.ordinal() + 1));
        if (!pPr.isSetBuFont()) {
            pPr.addNewBuFont().setTypeface(HSSFFont.FONT_ARIAL);
        }
        if (pPr.isSetBuNone()) {
            pPr.unsetBuNone();
        }
        if (pPr.isSetBuBlip()) {
            pPr.unsetBuBlip();
        }
        if (pPr.isSetBuChar()) {
            pPr.unsetBuChar();
        }
    }
}
