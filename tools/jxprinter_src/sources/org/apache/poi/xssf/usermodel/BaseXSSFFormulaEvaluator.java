package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.ExternalLinksTable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseXSSFFormulaEvaluator extends BaseFormulaEvaluator {
    public BaseXSSFFormulaEvaluator(WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
    }

    private void cacheExternalWorkbookCells(EvaluationCell evaluationCell) {
        EvaluationCell evaluationCell2 = evaluationCell;
        Ptg[] formulaTokens = getEvaluationWorkbook().getFormulaTokens(evaluationCell2);
        int length = formulaTokens.length;
        int i5 = 0;
        while (i5 < length) {
            Ptg ptg = formulaTokens[i5];
            if (ptg instanceof Area3DPxg) {
                Area3DPxg area3DPxg = (Area3DPxg) ptg;
                if (area3DPxg.getExternalWorkbookNumber() > 0) {
                    EvaluationWorkbook.ExternalSheet externalSheet = getEvaluationWorkbook().getExternalSheet(area3DPxg.getSheetName(), area3DPxg.getLastSheetName(), area3DPxg.getExternalWorkbookNumber());
                    XSSFCell xSSFCell = ((XSSFEvaluationCell) evaluationCell2).getXSSFCell();
                    XSSFWorkbook xSSFWorkbook = (XSSFWorkbook) xSSFCell.getSheet().getWorkbook().getCreationHelper().getReferencedWorkbooks().get(externalSheet.getWorkbookName());
                    ExternalLinksTable externalLinksTable = xSSFCell.getSheet().getWorkbook().getExternalLinksTable().get(area3DPxg.getExternalWorkbookNumber() - 1);
                    int sheetIndex = xSSFWorkbook.getSheetIndex(area3DPxg.getSheetName());
                    int sheetIndex2 = area3DPxg.getLastSheetName() != null ? xSSFWorkbook.getSheetIndex(area3DPxg.getLastSheetName()) : sheetIndex;
                    while (sheetIndex <= sheetIndex2) {
                        XSSFSheet sheetAt = xSSFWorkbook.getSheetAt(sheetIndex);
                        int firstRow = area3DPxg.getFirstRow();
                        int lastRow = area3DPxg.getLastRow();
                        while (firstRow <= lastRow) {
                            XSSFRow row = sheetAt.getRow(firstRow);
                            int firstColumn = area3DPxg.getFirstColumn();
                            int lastColumn = area3DPxg.getLastColumn();
                            while (firstColumn <= lastColumn) {
                                XSSFCell cell = row.getCell(firstColumn);
                                int i6 = lastColumn;
                                externalLinksTable.cacheData(sheetAt.getSheetName(), ((long) firstRow) + 1, new CellReference(cell).formatAsString(false), cell.getRawValue());
                                firstColumn++;
                                lastRow = lastRow;
                                firstRow = firstRow;
                                row = row;
                                lastColumn = i6;
                                i5 = i5;
                            }
                            firstRow++;
                        }
                        sheetIndex++;
                    }
                }
            }
            i5++;
            evaluationCell2 = evaluationCell;
        }
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    public RichTextString createRichTextString(String str) {
        return new XSSFRichTextString(str);
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    public CellValue evaluateFormulaCellValue(Cell cell) {
        EvaluationCell evaluationCell = toEvaluationCell(cell);
        ValueEval valueEvalEvaluate = this._bookEvaluator.evaluate(evaluationCell);
        cacheExternalWorkbookCells(evaluationCell);
        if (valueEvalEvaluate instanceof NumberEval) {
            return new CellValue(((NumberEval) valueEvalEvaluate).getNumberValue());
        }
        if (valueEvalEvaluate instanceof BoolEval) {
            return CellValue.valueOf(((BoolEval) valueEvalEvaluate).getBooleanValue());
        }
        if (valueEvalEvaluate instanceof StringEval) {
            return new CellValue(((StringEval) valueEvalEvaluate).getStringValue());
        }
        if (valueEvalEvaluate instanceof ErrorEval) {
            return CellValue.getError(((ErrorEval) valueEvalEvaluate).getErrorCode());
        }
        throw new RuntimeException("Unexpected eval class (" + valueEvalEvaluate.getClass().getName() + ")");
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator
    public void setCellType(Cell cell, CellType cellType) {
        if (!(cell instanceof XSSFCell)) {
            cell.setCellType(cellType);
        } else {
            EvaluationWorkbook evaluationWorkbook = getEvaluationWorkbook();
            ((XSSFCell) cell).setCellType(cellType, BaseXSSFEvaluationWorkbook.class.isAssignableFrom(evaluationWorkbook.getClass()) ? (BaseXSSFEvaluationWorkbook) evaluationWorkbook : null);
        }
    }

    public abstract EvaluationCell toEvaluationCell(Cell cell);
}
