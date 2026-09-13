package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFConditionalFormatting implements ConditionalFormatting {
    private final CFRecordsAggregate cfAggregate;
    private final HSSFSheet sheet;

    public HSSFConditionalFormatting(HSSFSheet hSSFSheet, CFRecordsAggregate cFRecordsAggregate) {
        if (hSSFSheet == null) {
            throw new IllegalArgumentException("sheet must not be null");
        }
        if (cFRecordsAggregate == null) {
            throw new IllegalArgumentException("cfAggregate must not be null");
        }
        this.sheet = hSSFSheet;
        this.cfAggregate = cFRecordsAggregate;
    }

    public void addRule(HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.addRule(hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    public CFRecordsAggregate getCFRecordsAggregate() {
        return this.cfAggregate;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public CellRangeAddress[] getFormattingRanges() {
        return this.cfAggregate.getHeader().getCellRanges();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public int getNumberOfRules() {
        return this.cfAggregate.getNumberOfRules();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setFormattingRanges(CellRangeAddress[] cellRangeAddressArr) {
        this.cfAggregate.getHeader().setCellRanges(cellRangeAddressArr);
    }

    public void setRule(int i5, HSSFConditionalFormattingRule hSSFConditionalFormattingRule) {
        this.cfAggregate.setRule(i5, hSSFConditionalFormattingRule.getCfRuleRecord());
    }

    public String toString() {
        return this.cfAggregate.toString();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void addRule(ConditionalFormattingRule conditionalFormattingRule) {
        addRule((HSSFConditionalFormattingRule) conditionalFormattingRule);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public HSSFConditionalFormattingRule getRule(int i5) {
        return new HSSFConditionalFormattingRule(this.sheet, this.cfAggregate.getRule(i5));
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormatting
    public void setRule(int i5, ConditionalFormattingRule conditionalFormattingRule) {
        setRule(i5, (HSSFConditionalFormattingRule) conditionalFormattingRule);
    }
}
