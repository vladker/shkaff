package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.ss.formula.EvaluationConditionalFormatRule;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExcelNumberFormat {
    private final String format;
    private final int idx;

    public ExcelNumberFormat(int i5, String str) {
        this.idx = i5;
        this.format = str;
    }

    public static ExcelNumberFormat from(CellStyle cellStyle) {
        if (cellStyle == null) {
            return null;
        }
        return new ExcelNumberFormat(cellStyle.getDataFormat(), cellStyle.getDataFormatString());
    }

    public String getFormat() {
        return this.format;
    }

    public int getIdx() {
        return this.idx;
    }

    public static ExcelNumberFormat from(Cell cell, ConditionalFormattingEvaluator conditionalFormattingEvaluator) {
        ExcelNumberFormat numberFormat = null;
        if (cell == null) {
            return null;
        }
        if (conditionalFormattingEvaluator != null) {
            Iterator<EvaluationConditionalFormatRule> it = conditionalFormattingEvaluator.getConditionalFormattingForCell(cell).iterator();
            while (it.hasNext() && (numberFormat = it.next().getNumberFormat()) == null) {
            }
        }
        return numberFormat == null ? from(cell.getCellStyle()) : numberFormat;
    }
}
