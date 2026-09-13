package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.BaseFormulaEvaluator;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFFormulaEvaluator extends BaseXSSFFormulaEvaluator {
    private final XSSFWorkbook _book;

    public XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook) {
        this(xSSFWorkbook, null, null);
    }

    public static XSSFFormulaEvaluator create(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new XSSFFormulaEvaluator(xSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    public static void evaluateAllFormulaCells(XSSFWorkbook xSSFWorkbook) {
        BaseFormulaEvaluator.evaluateAllFormulaCells(xSSFWorkbook);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        BaseFormulaEvaluator.evaluateAllFormulaCells(this._book, this);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell) cell));
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator
    public EvaluationCell toEvaluationCell(Cell cell) {
        if (cell instanceof XSSFCell) {
            return new XSSFEvaluationCell((XSSFCell) cell);
        }
        throw new IllegalArgumentException("Unexpected type of cell: " + cell.getClass() + ". Only XSSFCells can be evaluated.");
    }

    private XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(xSSFWorkbook, new WorkbookEvaluator(XSSFEvaluationWorkbook.create(xSSFWorkbook), iStabilityClassifier, uDFFinder));
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public XSSFCell evaluateInCell(Cell cell) {
        return (XSSFCell) super.evaluateInCell(cell);
    }

    public XSSFFormulaEvaluator(XSSFWorkbook xSSFWorkbook, WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
        this._book = xSSFWorkbook;
    }
}
