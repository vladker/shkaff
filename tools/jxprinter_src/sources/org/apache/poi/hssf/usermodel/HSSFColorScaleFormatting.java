package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.poi.hssf.record.common.ExtendedColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.ColorScaleFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFColorScaleFormatting implements ColorScaleFormatting {
    private final CFRule12Record cfRule12Record;
    private final ColorGradientFormatting colorFormatting;
    private final HSSFSheet sheet;

    public HSSFColorScaleFormatting(CFRule12Record cFRule12Record, HSSFSheet hSSFSheet) {
        this.sheet = hSSFSheet;
        this.cfRule12Record = cFRule12Record;
        this.colorFormatting = cFRule12Record.getColorGradientFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public int getNumControlPoints() {
        return this.colorFormatting.getNumControlPoints();
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setColors(Color[] colorArr) {
        ExtendedColor[] extendedColorArr = new ExtendedColor[colorArr.length];
        for (int i5 = 0; i5 < colorArr.length; i5++) {
            extendedColorArr[i5] = ((HSSFExtendedColor) colorArr[i5]).getExtendedColor();
        }
        this.colorFormatting.setColors(extendedColorArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setNumControlPoints(int i5) {
        this.colorFormatting.setNumControlPoints(i5);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        int length = conditionalFormattingThresholdArr.length;
        ColorGradientThreshold[] colorGradientThresholdArr = new ColorGradientThreshold[length];
        for (int i5 = 0; i5 < length; i5++) {
            colorGradientThresholdArr[i5] = (ColorGradientThreshold) ((HSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i5]).getThreshold();
        }
        this.colorFormatting.setThresholds(colorGradientThresholdArr);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFConditionalFormattingThreshold createThreshold() {
        return new HSSFConditionalFormattingThreshold(new ColorGradientThreshold(), this.sheet);
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFExtendedColor[] getColors() {
        ExtendedColor[] colors = this.colorFormatting.getColors();
        HSSFExtendedColor[] hSSFExtendedColorArr = new HSSFExtendedColor[colors.length];
        for (int i5 = 0; i5 < colors.length; i5++) {
            hSSFExtendedColorArr[i5] = new HSSFExtendedColor(colors[i5]);
        }
        return hSSFExtendedColorArr;
    }

    @Override // org.apache.poi.ss.usermodel.ColorScaleFormatting
    public HSSFConditionalFormattingThreshold[] getThresholds() {
        ColorGradientThreshold[] thresholds = this.colorFormatting.getThresholds();
        HSSFConditionalFormattingThreshold[] hSSFConditionalFormattingThresholdArr = new HSSFConditionalFormattingThreshold[thresholds.length];
        for (int i5 = 0; i5 < thresholds.length; i5++) {
            hSSFConditionalFormattingThresholdArr[i5] = new HSSFConditionalFormattingThreshold(thresholds[i5], this.sheet);
        }
        return hSSFConditionalFormattingThresholdArr;
    }
}
