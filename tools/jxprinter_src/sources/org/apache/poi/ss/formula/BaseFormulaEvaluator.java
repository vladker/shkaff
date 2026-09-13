package org.apache.poi.ss.formula;

import java.util.Iterator;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseFormulaEvaluator implements FormulaEvaluator, WorkbookEvaluatorProvider {
    protected final WorkbookEvaluator _bookEvaluator;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.BaseFormulaEvaluator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.NUMERIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public BaseFormulaEvaluator(WorkbookEvaluator workbookEvaluator) {
        this._bookEvaluator = workbookEvaluator;
    }

    public static void evaluateAllFormulaCells(Workbook workbook) {
        evaluateAllFormulaCells(workbook, workbook.getCreationHelper().createFormulaEvaluator());
    }

    public static void setupEnvironment(String[] strArr, BaseFormulaEvaluator[] baseFormulaEvaluatorArr) {
        int length = baseFormulaEvaluatorArr.length;
        WorkbookEvaluator[] workbookEvaluatorArr = new WorkbookEvaluator[length];
        for (int i5 = 0; i5 < length; i5++) {
            workbookEvaluatorArr[i5] = baseFormulaEvaluatorArr[i5]._bookEvaluator;
        }
        CollaboratingWorkbooksEnvironment.setup(strArr, workbookEvaluatorArr);
    }

    @Override // org.apache.poi.ss.formula.WorkbookEvaluatorProvider
    public WorkbookEvaluator _getWorkbookEvaluator() {
        return this._bookEvaluator;
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void clearAllCachedResultValues() {
        this._bookEvaluator.clearAllCachedResultValues();
    }

    public abstract RichTextString createRichTextString(String str);

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellValue evaluate(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cell.getCellType().ordinal()]) {
            case 1:
                return CellValue.valueOf(cell.getBooleanCellValue());
            case 2:
                return CellValue.getError(cell.getErrorCellValue());
            case 3:
                return evaluateFormulaCellValue(cell);
            case 4:
                return new CellValue(cell.getNumericCellValue());
            case 5:
                return new CellValue(cell.getRichStringCellValue().getString());
            case 6:
                return null;
            default:
                throw new IllegalStateException("Bad cell type (" + cell.getCellType() + ")");
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public CellType evaluateFormulaCell(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.FORMULA) {
            return CellType._NONE;
        }
        CellValue cellValueEvaluateFormulaCellValue = evaluateFormulaCellValue(cell);
        setCellValue(cell, cellValueEvaluateFormulaCellValue);
        return cellValueEvaluateFormulaCellValue.getCellType();
    }

    public abstract CellValue evaluateFormulaCellValue(Cell cell);

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public Cell evaluateInCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        if (cell.getCellType() == CellType.FORMULA) {
            CellValue cellValueEvaluateFormulaCellValue = evaluateFormulaCellValue(cell);
            setCellValue(cell, cellValueEvaluateFormulaCellValue);
            setCellType(cell, cellValueEvaluateFormulaCellValue);
            setCellValue(cell, cellValueEvaluateFormulaCellValue);
        }
        return cell;
    }

    public EvaluationWorkbook getEvaluationWorkbook() {
        return this._bookEvaluator.getWorkbook();
    }

    public void setCellType(Cell cell, CellValue cellValue) {
        CellType cellType = cellValue.getCellType();
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()]) {
            case 1:
            case 2:
            case 4:
            case 5:
                setCellType(cell, cellType);
                return;
            case 3:
                throw new IllegalArgumentException("This should never happen. Formulas should have already been evaluated.");
            case 6:
                throw new IllegalArgumentException("This should never happen. Blanks eventually get translated to zero.");
            default:
                throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
        }
    }

    public void setCellValue(Cell cell, CellValue cellValue) {
        CellType cellType = cellValue.getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            cell.setCellValue(cellValue.getBooleanValue());
            return;
        }
        if (i5 == 2) {
            cell.setCellErrorValue(cellValue.getErrorValue());
            return;
        }
        if (i5 == 4) {
            cell.setCellValue(cellValue.getNumberValue());
        } else {
            if (i5 == 5) {
                cell.setCellValue(createRichTextString(cellValue.getStringValue()));
                return;
            }
            throw new IllegalStateException("Unexpected cell value type (" + cellType + ")");
        }
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setDebugEvaluationOutputForNextEval(boolean z6) {
        this._bookEvaluator.setDebugEvaluationOutputForNextEval(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setIgnoreMissingWorkbooks(boolean z6) {
        this._bookEvaluator.setIgnoreMissingWorkbooks(z6);
    }

    @Override // org.apache.poi.ss.usermodel.FormulaEvaluator
    public void setupReferencedWorkbooks(Map<String, FormulaEvaluator> map) {
        CollaboratingWorkbooksEnvironment.setupFormulaEvaluator(map);
    }

    public static void evaluateAllFormulaCells(Workbook workbook, FormulaEvaluator formulaEvaluator) {
        for (int i5 = 0; i5 < workbook.getNumberOfSheets(); i5++) {
            Iterator<Row> it = workbook.getSheetAt(i5).iterator();
            while (it.hasNext()) {
                for (Cell cell : it.next()) {
                    if (cell.getCellType() == CellType.FORMULA) {
                        formulaEvaluator.evaluateFormulaCell(cell);
                    }
                }
            }
        }
    }

    public void setCellType(Cell cell, CellType cellType) {
        cell.setCellType(cellType);
    }
}
