package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
import org.apache.poi.hssf.record.cf.Threshold;
import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
import org.apache.poi.ss.usermodel.IconMultiStateFormatting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFIconMultiStateFormatting implements IconMultiStateFormatting {
    private final org.apache.poi.hssf.record.cf.IconMultiStateFormatting iconFormatting;
    private final HSSFSheet sheet;

    public HSSFIconMultiStateFormatting(CFRule12Record cFRule12Record, HSSFSheet hSSFSheet) {
        this.sheet = hSSFSheet;
        this.iconFormatting = cFRule12Record.getMultiStateFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public IconMultiStateFormatting.IconSet getIconSet() {
        return this.iconFormatting.getIconSet();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isIconOnly() {
        return this.iconFormatting.isIconOnly();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public boolean isReversed() {
        return this.iconFormatting.isReversed();
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconOnly(boolean z6) {
        this.iconFormatting.setIconOnly(z6);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setIconSet(IconMultiStateFormatting.IconSet iconSet) {
        this.iconFormatting.setIconSet(iconSet);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setReversed(boolean z6) {
        this.iconFormatting.setReversed(z6);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public void setThresholds(ConditionalFormattingThreshold[] conditionalFormattingThresholdArr) {
        int length = conditionalFormattingThresholdArr.length;
        Threshold[] thresholdArr = new Threshold[length];
        for (int i5 = 0; i5 < length; i5++) {
            thresholdArr[i5] = ((HSSFConditionalFormattingThreshold) conditionalFormattingThresholdArr[i5]).getThreshold();
        }
        this.iconFormatting.setThresholds(thresholdArr);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public HSSFConditionalFormattingThreshold createThreshold() {
        return new HSSFConditionalFormattingThreshold(new IconMultiStateThreshold(), this.sheet);
    }

    @Override // org.apache.poi.ss.usermodel.IconMultiStateFormatting
    public HSSFConditionalFormattingThreshold[] getThresholds() {
        Threshold[] thresholds = this.iconFormatting.getThresholds();
        HSSFConditionalFormattingThreshold[] hSSFConditionalFormattingThresholdArr = new HSSFConditionalFormattingThreshold[thresholds.length];
        for (int i5 = 0; i5 < thresholds.length; i5++) {
            hSSFConditionalFormattingThresholdArr[i5] = new HSSFConditionalFormattingThreshold(thresholds[i5], this.sheet);
        }
        return hSSFConditionalFormattingThresholdArr;
    }
}
