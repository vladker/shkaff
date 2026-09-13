package org.apache.poi.ss.formula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ConditionalFormatting;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ConditionalFormattingEvaluator {
    private final Map<String, List<EvaluationConditionalFormatRule>> formats = new HashMap();
    private final Map<CellReference, List<EvaluationConditionalFormatRule>> values = new HashMap();
    private final Workbook workbook;
    private final WorkbookEvaluator workbookEvaluator;

    public ConditionalFormattingEvaluator(Workbook workbook, WorkbookEvaluatorProvider workbookEvaluatorProvider) {
        this.workbook = workbook;
        this.workbookEvaluator = workbookEvaluatorProvider._getWorkbookEvaluator();
    }

    public static CellReference getRef(Cell cell) {
        return new CellReference(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), false, false);
    }

    public void clearAllCachedFormats() {
        this.formats.clear();
    }

    public void clearAllCachedValues() {
        this.values.clear();
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(CellReference cellReference) {
        Sheet sheetAt;
        List<EvaluationConditionalFormatRule> list = this.values.get(cellReference);
        List list2 = list;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            if (cellReference.getSheetName() != null) {
                sheetAt = this.workbook.getSheet(cellReference.getSheetName());
            } else {
                Workbook workbook = this.workbook;
                sheetAt = workbook.getSheetAt(workbook.getActiveSheetIndex());
            }
            boolean stopIfTrue = false;
            for (EvaluationConditionalFormatRule evaluationConditionalFormatRule : getRules(sheetAt)) {
                if (!stopIfTrue && evaluationConditionalFormatRule.matches(cellReference)) {
                    arrayList.add(evaluationConditionalFormatRule);
                    stopIfTrue = evaluationConditionalFormatRule.getRule().getStopIfTrue();
                }
            }
            Collections.sort(arrayList);
            this.values.put(cellReference, arrayList);
            list2 = arrayList;
        }
        return Collections.unmodifiableList(list2);
    }

    public List<EvaluationConditionalFormatRule> getFormatRulesForSheet(String str) {
        return getFormatRulesForSheet(this.workbook.getSheet(str));
    }

    public List<Cell> getMatchingCells(Sheet sheet, int i5, int i6) {
        for (EvaluationConditionalFormatRule evaluationConditionalFormatRule : getRules(sheet)) {
            if (evaluationConditionalFormatRule.getSheet().equals(sheet) && evaluationConditionalFormatRule.getFormattingIndex() == i5 && evaluationConditionalFormatRule.getRuleIndex() == i6) {
                return getMatchingCells(evaluationConditionalFormatRule);
            }
        }
        return Collections.EMPTY_LIST;
    }

    public List<EvaluationConditionalFormatRule> getRules(Sheet sheet) {
        String sheetName = sheet.getSheetName();
        List list = this.formats.get(sheetName);
        if (list == null) {
            if (this.formats.containsKey(sheetName)) {
                return Collections.EMPTY_LIST;
            }
            SheetConditionalFormatting sheetConditionalFormatting = sheet.getSheetConditionalFormatting();
            int numConditionalFormattings = sheetConditionalFormatting.getNumConditionalFormattings();
            ArrayList arrayList = new ArrayList(numConditionalFormattings);
            this.formats.put(sheetName, arrayList);
            for (int i5 = 0; i5 < numConditionalFormattings; i5++) {
                ConditionalFormatting conditionalFormattingAt = sheetConditionalFormatting.getConditionalFormattingAt(i5);
                CellRangeAddress[] formattingRanges = conditionalFormattingAt.getFormattingRanges();
                for (int i6 = 0; i6 < conditionalFormattingAt.getNumberOfRules(); i6++) {
                    arrayList.add(new EvaluationConditionalFormatRule(this.workbookEvaluator, sheet, conditionalFormattingAt, i5, conditionalFormattingAt.getRule(i6), i6, formattingRanges));
                }
            }
            Collections.sort(arrayList);
            list = arrayList;
        }
        return Collections.unmodifiableList(list);
    }

    public WorkbookEvaluator getWorkbookEvaluator() {
        return this.workbookEvaluator;
    }

    public List<EvaluationConditionalFormatRule> getFormatRulesForSheet(Sheet sheet) {
        return getRules(sheet);
    }

    public List<Cell> getMatchingCells(EvaluationConditionalFormatRule evaluationConditionalFormatRule) {
        ArrayList arrayList = new ArrayList();
        Sheet sheet = evaluationConditionalFormatRule.getSheet();
        for (CellRangeAddress cellRangeAddress : evaluationConditionalFormatRule.getRegions()) {
            for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= cellRangeAddress.getLastRow(); firstRow++) {
                Row row = sheet.getRow(firstRow);
                if (row != null) {
                    for (int firstColumn = cellRangeAddress.getFirstColumn(); firstColumn <= cellRangeAddress.getLastColumn(); firstColumn++) {
                        Cell cell = row.getCell(firstColumn);
                        if (cell != null && getConditionalFormattingForCell(cell).contains(evaluationConditionalFormatRule)) {
                            arrayList.add(cell);
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<EvaluationConditionalFormatRule> getConditionalFormattingForCell(Cell cell) {
        return getConditionalFormattingForCell(getRef(cell));
    }
}
