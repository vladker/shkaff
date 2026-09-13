package org.apache.poi.hssf.model;

import org.apache.poi.hssf.usermodel.HSSFEvaluationWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class HSSFFormulaParser {
    private HSSFFormulaParser() {
    }

    private static FormulaParsingWorkbook createParsingWorkbook(HSSFWorkbook hSSFWorkbook) {
        return HSSFEvaluationWorkbook.create(hSSFWorkbook);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook) {
        return parse(str, hSSFWorkbook, FormulaType.CELL);
    }

    public static String toFormulaString(HSSFWorkbook hSSFWorkbook, Ptg[] ptgArr) {
        return FormulaRenderer.toFormulaString(HSSFEvaluationWorkbook.create(hSSFWorkbook), ptgArr);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, FormulaType formulaType) {
        return parse(str, hSSFWorkbook, formulaType, -1);
    }

    public static Ptg[] parse(String str, HSSFWorkbook hSSFWorkbook, FormulaType formulaType, int i5) {
        return FormulaParser.parse(str, createParsingWorkbook(hSSFWorkbook), formulaType, i5);
    }
}
