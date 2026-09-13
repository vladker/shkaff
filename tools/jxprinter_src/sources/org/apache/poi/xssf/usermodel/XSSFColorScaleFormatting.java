package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.ColorScaleFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFColorScaleFormatting implements ColorScaleFormatting {
    private IndexedColorMap _indexedColorMap;
    private CTColorScale _scale;

    public XSSFColorScaleFormatting(CTColorScale cTColorScale, IndexedColorMap indexedColorMap) {
        this._scale = cTColorScale;
        this._indexedColorMap = indexedColorMap;
    }

    public XSSFColor createColor() {
        return XSSFColor.from(this._scale.addNewColor(), this._indexedColorMap);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public int getNumControlPoints() {
        return this._scale.sizeOfCfvoArray();
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setColors(Color[] colorArr) {
        CTColor[] cTColorArr = new CTColor[colorArr.length];
        for (int i5 = 0; i5 < colorArr.length; i5++) {
            cTColorArr[i5] = ((XSSFColor) colorArr[i5]).getCTColor();
        }
        this._scale.setColorArray(cTColorArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setNumControlPoints(int i5) {
        while (i5 < this._scale.sizeOfCfvoArray()) {
            CTColorScale cTColorScale = this._scale;
            cTColorScale.removeCfvo(cTColorScale.sizeOfCfvoArray() - 1);
            CTColorScale cTColorScale2 = this._scale;
            cTColorScale2.removeColor(cTColorScale2.sizeOfColorArray() - 1);
        }
        while (i5 > this._scale.sizeOfCfvoArray()) {
            this._scale.addNewCfvo();
            this._scale.addNewColor();
        }
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        CTCfvo[] cTCfvoArr = new CTCfvo[conditionalFormattingThresholdArr.length];
        for (int i5 = 0; i5 < conditionalFormattingThresholdArr.length; i5++) {
            cTCfvoArr[i5] = ((XSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i5]).getCTCfvo();
        }
        this._scale.setCfvoArray(cTCfvoArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public XSSFConditionalFormattingThreshold createThreshold() {
        return new XSSFConditionalFormattingThreshold(this._scale.addNewCfvo());
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public XSSFColor[] getColors() {
        CTColor[] colorArray = this._scale.getColorArray();
        XSSFColor[] xSSFColorArr = new XSSFColor[colorArray.length];
        for (int i5 = 0; i5 < colorArray.length; i5++) {
            xSSFColorArr[i5] = XSSFColor.from(colorArray[i5], this._indexedColorMap);
        }
        return xSSFColorArr;
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public XSSFConditionalFormattingThreshold[] getThresholds() {
        CTCfvo[] cfvoArray = this._scale.getCfvoArray();
        XSSFConditionalFormattingThreshold[] xSSFConditionalFormattingThresholdArr = new XSSFConditionalFormattingThreshold[cfvoArray.length];
        for (int i5 = 0; i5 < cfvoArray.length; i5++) {
            xSSFConditionalFormattingThresholdArr[i5] = new XSSFConditionalFormattingThreshold(cfvoArray[i5]);
        }
        return xSSFConditionalFormattingThresholdArr;
    }
}
