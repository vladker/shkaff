package org.apache.poi.xssf.streaming;

import androidx.collection.a;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.IStabilityClassifier;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class SXSSFFormulaEvaluator extends BaseXSSFFormulaEvaluator {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SXSSFFormulaEvaluator.class);
    private final SXSSFWorkbook wb;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RowFlushedException extends IllegalStateException {
        public RowFlushedException(int i5, int i6) {
            super(a.m("Row ", i5, i6, " has been flushed (rows up to ", " have been flushed), cannot evaluate all cells"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SheetsFlushedException extends IllegalStateException {
        public SheetsFlushedException() {
            super("One or more sheets have been flushed, cannot evaluate all cells");
        }
    }

    public SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook) {
        this(sXSSFWorkbook, null, null);
    }

    public static SXSSFFormulaEvaluator create(SXSSFWorkbook sXSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        return new SXSSFFormulaEvaluator(sXSSFWorkbook, iStabilityClassifier, uDFFinder);
    }

    public static void evaluateAllFormulaCells(SXSSFWorkbook sXSSFWorkbook, boolean z6) {
        int lastFlushedRowNum;
        SXSSFFormulaEvaluator sXSSFFormulaEvaluator = new SXSSFFormulaEvaluator(sXSSFWorkbook);
        Iterator<Sheet> it = sXSSFWorkbook.iterator();
        while (it.hasNext()) {
            if (((SXSSFSheet) it.next()).areAllRowsFlushed()) {
                throw new SheetsFlushedException();
            }
        }
        for (Sheet sheet : sXSSFWorkbook) {
            if ((sheet instanceof SXSSFSheet) && (lastFlushedRowNum = ((SXSSFSheet) sheet).getLastFlushedRowNum()) > -1) {
                if (!z6) {
                    throw new RowFlushedException(0, lastFlushedRowNum);
                }
                LOG.atInfo().log("Rows up to {} have already been flushed, skipping", Unbox.box(lastFlushedRowNum));
            }
            Iterator<Row> it2 = sheet.iterator();
            while (it2.hasNext()) {
                for (Cell cell : it2.next()) {
                    if (cell.getCellType() == CellType.FORMULA) {
                        sXSSFFormulaEvaluator.evaluateFormulaCell(cell);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void evaluateAll() {
        evaluateAllFormulaCells(this.wb, false);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyDeleteCell(Cell cell) {
        this._bookEvaluator.notifyDeleteCell(new SXSSFEvaluationCell((SXSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifySetFormula(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new SXSSFEvaluationCell((SXSSFCell) cell));
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void notifyUpdateCell(Cell cell) {
        this._bookEvaluator.notifyUpdateCell(new SXSSFEvaluationCell((SXSSFCell) cell));
    }

    @Override // org.apache.poi.xssf.usermodel.BaseXSSFFormulaEvaluator
    public EvaluationCell toEvaluationCell(Cell cell) {
        if (cell instanceof SXSSFCell) {
            return new SXSSFEvaluationCell((SXSSFCell) cell);
        }
        throw new IllegalArgumentException("Unexpected type of cell: " + cell.getClass() + ". Only SXSSFCells can be evaluated.");
    }

    private SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(sXSSFWorkbook, new WorkbookEvaluator(SXSSFEvaluationWorkbook.create(sXSSFWorkbook), iStabilityClassifier, uDFFinder));
    }

    @Override // org.apache.poi.ss.formula.BaseFormulaEvaluator, org.apache.poi.ss.usermodel.FormulaEvaluator
    public SXSSFCell evaluateInCell(Cell cell) {
        return (SXSSFCell) super.evaluateInCell(cell);
    }

    private SXSSFFormulaEvaluator(SXSSFWorkbook sXSSFWorkbook, WorkbookEvaluator workbookEvaluator) {
        super(workbookEvaluator);
        this.wb = sXSSFWorkbook;
    }
}
