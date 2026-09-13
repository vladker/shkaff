package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.ConditionFilterData;
import org.apache.poi.ss.usermodel.ConditionFilterType;
import org.apache.poi.ss.usermodel.ConditionType;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.ExcelNumberFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFConditionalFormattingRule implements ConditionalFormattingRule {
    private static final byte CELL_COMPARISON = 1;
    private final CFRuleBase cfRuleRecord;
    private final HSSFSheet sheet;
    private final HSSFWorkbook workbook;

    public HSSFConditionalFormattingRule(HSSFSheet hSSFSheet, CFRuleBase cFRuleBase) {
        if (hSSFSheet == null) {
            throw new IllegalArgumentException("pSheet must not be null");
        }
        if (cFRuleBase == null) {
            throw new IllegalArgumentException("pRuleRecord must not be null");
        }
        this.sheet = hSSFSheet;
        this.workbook = hSSFSheet.getWorkbook();
        this.cfRuleRecord = cFRuleBase;
    }

    private CFRule12Record getCFRule12Record(boolean z6) {
        CFRuleBase cFRuleBase = this.cfRuleRecord;
        if (cFRuleBase instanceof CFRule12Record) {
            return (CFRule12Record) cFRuleBase;
        }
        if (z6) {
            throw new IllegalArgumentException("Can't convert a CF into a CF12 record");
        }
        return null;
    }

    public HSSFColorScaleFormatting createColorScaleFormatting() {
        return getColorScaleFormatting(true);
    }

    public HSSFDataBarFormatting createDataBarFormatting() {
        return getDataBarFormatting(true);
    }

    public HSSFIconMultiStateFormatting createMultiStateFormatting() {
        return getMultiStateFormatting(true);
    }

    public CFRuleBase getCfRuleRecord() {
        return this.cfRuleRecord;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public byte getComparisonOperation() {
        return this.cfRuleRecord.getComparisonOperation();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterType getConditionFilterType() {
        if (getConditionType() == ConditionType.FILTER) {
            return ConditionFilterType.FILTER;
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionType getConditionType() {
        return ConditionType.forId(this.cfRuleRecord.getConditionType());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public ConditionFilterData getFilterConfiguration() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula1() {
        return toFormulaString(this.cfRuleRecord.getParsedExpression1());
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getFormula2() {
        if (this.cfRuleRecord.getConditionType() != 1) {
            return null;
        }
        byte comparisonOperation = this.cfRuleRecord.getComparisonOperation();
        if (comparisonOperation == 1 || comparisonOperation == 2) {
            return toFormulaString(this.cfRuleRecord.getParsedExpression2());
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public ExcelNumberFormat getNumberFormat() {
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public int getPriority() {
        CFRule12Record cFRule12Record = getCFRule12Record(false);
        if (cFRule12Record == null) {
            return 0;
        }
        return cFRule12Record.getPriority();
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public boolean getStopIfTrue() {
        return true;
    }

    @Override // org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public int getStripeSize() {
        return 0;
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public String getText() {
        return null;
    }

    public String toFormulaString(Ptg[] ptgArr) {
        return toFormulaString(ptgArr, this.workbook);
    }

    private HSSFBorderFormatting getBorderFormatting(boolean z6) {
        if (this.cfRuleRecord.getBorderFormatting() == null) {
            if (!z6) {
                return null;
            }
            this.cfRuleRecord.setBorderFormatting(new BorderFormatting());
        }
        return new HSSFBorderFormatting(this.cfRuleRecord, this.workbook);
    }

    private HSSFColorScaleFormatting getColorScaleFormatting(boolean z6) {
        CFRule12Record cFRule12Record = getCFRule12Record(z6);
        if (cFRule12Record == null) {
            return null;
        }
        if (cFRule12Record.getColorGradientFormatting() == null) {
            if (!z6) {
                return null;
            }
            cFRule12Record.createColorGradientFormatting();
        }
        return new HSSFColorScaleFormatting(cFRule12Record, this.sheet);
    }

    private HSSFDataBarFormatting getDataBarFormatting(boolean z6) {
        CFRule12Record cFRule12Record = getCFRule12Record(z6);
        if (cFRule12Record == null) {
            return null;
        }
        if (cFRule12Record.getDataBarFormatting() == null) {
            if (!z6) {
                return null;
            }
            cFRule12Record.createDataBarFormatting();
        }
        return new HSSFDataBarFormatting(cFRule12Record, this.sheet);
    }

    private HSSFFontFormatting getFontFormatting(boolean z6) {
        if (this.cfRuleRecord.getFontFormatting() == null) {
            if (!z6) {
                return null;
            }
            this.cfRuleRecord.setFontFormatting(new FontFormatting());
        }
        return new HSSFFontFormatting(this.cfRuleRecord, this.workbook);
    }

    private HSSFIconMultiStateFormatting getMultiStateFormatting(boolean z6) {
        CFRule12Record cFRule12Record = getCFRule12Record(z6);
        if (cFRule12Record == null) {
            return null;
        }
        if (cFRule12Record.getMultiStateFormatting() == null) {
            if (!z6) {
                return null;
            }
            cFRule12Record.createMultiStateFormatting();
        }
        return new HSSFIconMultiStateFormatting(cFRule12Record, this.sheet);
    }

    private HSSFPatternFormatting getPatternFormatting(boolean z6) {
        if (this.cfRuleRecord.getPatternFormatting() == null) {
            if (!z6) {
                return null;
            }
            this.cfRuleRecord.setPatternFormatting(new PatternFormatting());
        }
        return new HSSFPatternFormatting(this.cfRuleRecord, this.workbook);
    }

    public static String toFormulaString(Ptg[] ptgArr, HSSFWorkbook hSSFWorkbook) {
        if (ptgArr == null || ptgArr.length == 0) {
            return null;
        }
        return HSSFFormulaParser.toFormulaString(hSSFWorkbook, ptgArr);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFBorderFormatting createBorderFormatting() {
        return getBorderFormatting(true);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFFontFormatting createFontFormatting() {
        return getFontFormatting(true);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFPatternFormatting createPatternFormatting() {
        return getPatternFormatting(true);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public HSSFBorderFormatting getBorderFormatting() {
        return getBorderFormatting(false);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFColorScaleFormatting getColorScaleFormatting() {
        return getColorScaleFormatting(false);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFDataBarFormatting getDataBarFormatting() {
        return getDataBarFormatting(false);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public HSSFFontFormatting getFontFormatting() {
        return getFontFormatting(false);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule
    public HSSFIconMultiStateFormatting getMultiStateFormatting() {
        return getMultiStateFormatting(false);
    }

    @Override // org.apache.poi.ss.usermodel.ConditionalFormattingRule, org.apache.poi.ss.usermodel.DifferentialStyleProvider
    public HSSFPatternFormatting getPatternFormatting() {
        return getPatternFormatting(false);
    }
}
