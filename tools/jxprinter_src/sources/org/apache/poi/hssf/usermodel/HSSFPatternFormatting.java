package org.apache.poi.hssf.usermodel;

import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.PatternFormatting;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFPatternFormatting implements PatternFormatting {
    private final CFRuleBase cfRuleRecord;
    private final org.apache.poi.hssf.record.cf.PatternFormatting patternFormatting;
    private final HSSFWorkbook workbook;

    public HSSFPatternFormatting(CFRuleBase cFRuleBase, HSSFWorkbook hSSFWorkbook) {
        this.workbook = hSSFWorkbook;
        this.cfRuleRecord = cFRuleBase;
        this.patternFormatting = cFRuleBase.getPatternFormatting();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillBackgroundColor() {
        return (short) this.patternFormatting.getFillBackgroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillForegroundColor() {
        return (short) this.patternFormatting.getFillForegroundColor();
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public short getFillPattern() {
        return (short) this.patternFormatting.getFillPattern();
    }

    public org.apache.poi.hssf.record.cf.PatternFormatting getPatternFormattingBlock() {
        return this.patternFormatting;
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setFillBackgroundColor((short) 0);
        } else {
            setFillBackgroundColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(Color color) {
        HSSFColor hSSFColor = HSSFColor.toHSSFColor(color);
        if (hSSFColor == null) {
            setFillForegroundColor((short) 0);
        } else {
            setFillForegroundColor(hSSFColor.getIndex());
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillPattern(short s6) {
        this.patternFormatting.setFillPattern(s6);
        if (s6 != 0) {
            this.cfRuleRecord.setPatternStyleModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public HSSFColor getFillBackgroundColorColor() {
        return this.workbook.getCustomPalette().getColor(getFillBackgroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public HSSFColor getFillForegroundColorColor() {
        return this.workbook.getCustomPalette().getColor(getFillForegroundColor());
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillBackgroundColor(short s6) {
        this.patternFormatting.setFillBackgroundColor(s6);
        if (s6 != 0) {
            this.cfRuleRecord.setPatternBackgroundColorModified(true);
        }
    }

    @Override // org.apache.poi.ss.usermodel.PatternFormatting
    public void setFillForegroundColor(short s6) {
        this.patternFormatting.setFillForegroundColor(s6);
        if (s6 != 0) {
            this.cfRuleRecord.setPatternColorModified(true);
        }
    }
}
