package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DataValidationEvaluator {
    private final Map<String, List<? extends DataValidation>> validations = new HashMap();
    private final Workbook workbook;
    private final WorkbookEvaluator workbookEvaluator;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DataValidationContext {
        private final DataValidation dv;
        private final DataValidationEvaluator dve;
        private final CellRangeAddressBase region;
        private final CellReference target;

        public DataValidationContext(DataValidation dataValidation, DataValidationEvaluator dataValidationEvaluator, CellRangeAddressBase cellRangeAddressBase, CellReference cellReference) {
            this.dv = dataValidation;
            this.dve = dataValidationEvaluator;
            this.region = cellRangeAddressBase;
            this.target = cellReference;
        }

        public DataValidationEvaluator getEvaluator() {
            return this.dve;
        }

        public String getFormula1() {
            return this.dv.getValidationConstraint().getFormula1();
        }

        public String getFormula2() {
            return this.dv.getValidationConstraint().getFormula2();
        }

        public int getOffsetColumns() {
            return this.target.getCol() - this.region.getFirstColumn();
        }

        public int getOffsetRows() {
            return this.target.getRow() - this.region.getFirstRow();
        }

        public int getOperator() {
            return this.dv.getValidationConstraint().getOperator();
        }

        public CellRangeAddressBase getRegion() {
            return this.region;
        }

        public int getSheetIndex() {
            return this.dve.getWorkbookEvaluator().getSheetIndex(this.target.getSheetName());
        }

        public CellReference getTarget() {
            return this.target;
        }

        public DataValidation getValidation() {
            return this.dv;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum OperatorEnum {
        BETWEEN { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.1
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) >= 0 && d.compareTo(d7) <= 0;
            }
        },
        NOT_BETWEEN { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.2
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) < 0 || d.compareTo(d7) > 0;
            }
        },
        EQUAL { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.3
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) == 0;
            }
        },
        NOT_EQUAL { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.4
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) != 0;
            }
        },
        GREATER_THAN { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.5
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) > 0;
            }
        },
        LESS_THAN { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.6
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) < 0;
            }
        },
        GREATER_OR_EQUAL { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.7
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) >= 0;
            }
        },
        LESS_OR_EQUAL { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum.8
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.OperatorEnum
            public boolean isValid(Double d, Double d6, Double d7) {
                return d.compareTo(d6) <= 0;
            }
        };

        public static final OperatorEnum IGNORED = BETWEEN;

        public abstract boolean isValid(Double d, Double d6, Double d7);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum ValidationEnum {
        ANY { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum.1
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum
            public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
                return true;
            }
        },
        INTEGER { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum.2
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum
            public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
                if (super.isValidValue(cell, dataValidationContext)) {
                    double numericCellValue = cell.getNumericCellValue();
                    if (Double.compare(numericCellValue, (int) numericCellValue) == 0) {
                        return true;
                    }
                }
                return false;
            }
        },
        DECIMAL,
        LIST { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum.3
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum
            public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
                List<ValueEval> validationValuesForConstraint = DataValidationEvaluator.getValidationValuesForConstraint(dataValidationContext);
                if (validationValuesForConstraint == null) {
                    return true;
                }
                Iterator<ValueEval> it = validationValuesForConstraint.iterator();
                while (it.hasNext()) {
                    ValueEval next = it.next();
                    if (next instanceof RefEval) {
                        next = ((RefEval) next).getInnerValueEval(dataValidationContext.getSheetIndex());
                    }
                    if (next instanceof BlankEval) {
                        return true;
                    }
                    if (!(next instanceof ErrorEval)) {
                        if (next instanceof BoolEval) {
                            if (DataValidationEvaluator.isType(cell, CellType.BOOLEAN) && ((BoolEval) next).getBooleanValue() == cell.getBooleanCellValue()) {
                                return true;
                            }
                        } else if (next instanceof NumberEval) {
                            if (DataValidationEvaluator.isType(cell, CellType.NUMERIC) && ((NumberEval) next).getNumberValue() == cell.getNumericCellValue()) {
                                return true;
                            }
                        } else if ((next instanceof StringEval) && DataValidationEvaluator.isType(cell, CellType.STRING) && ((StringEval) next).getStringValue().equalsIgnoreCase(cell.getStringCellValue())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        },
        DATE,
        TIME,
        TEXT_LENGTH { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum.4
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum
            public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
                if (DataValidationEvaluator.isType(cell, CellType.STRING)) {
                    return isValidNumericValue(Double.valueOf(cell.getStringCellValue().length()), dataValidationContext);
                }
                return false;
            }
        },
        FORMULA { // from class: org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum.5
            @Override // org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum
            public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
                ValueEval valueEvalEvaluate = dataValidationContext.getEvaluator().getWorkbookEvaluator().evaluate(dataValidationContext.getFormula1(), dataValidationContext.getTarget(), dataValidationContext.getRegion());
                if (valueEvalEvaluate instanceof RefEval) {
                    RefEval refEval = (RefEval) valueEvalEvaluate;
                    valueEvalEvaluate = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
                }
                if (valueEvalEvaluate instanceof BlankEval) {
                    return true;
                }
                if (valueEvalEvaluate instanceof ErrorEval) {
                    return false;
                }
                if (valueEvalEvaluate instanceof BoolEval) {
                    return ((BoolEval) valueEvalEvaluate).getBooleanValue();
                }
                return (valueEvalEvaluate instanceof NumberEval) && ((NumberEval) valueEvalEvaluate).getNumberValue() != 0.0d;
            }
        };

        private Double evalOrConstant(String str, DataValidationContext dataValidationContext) {
            if (StringUtil.isBlank(str)) {
                return null;
            }
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                ValueEval valueEvalEvaluate = dataValidationContext.getEvaluator().getWorkbookEvaluator().evaluate(str, dataValidationContext.getTarget(), dataValidationContext.getRegion());
                if (valueEvalEvaluate instanceof RefEval) {
                    RefEval refEval = (RefEval) valueEvalEvaluate;
                    valueEvalEvaluate = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
                }
                if (valueEvalEvaluate instanceof BlankEval) {
                    return null;
                }
                if (valueEvalEvaluate instanceof NumberEval) {
                    return Double.valueOf(((NumberEval) valueEvalEvaluate).getNumberValue());
                }
                if (!(valueEvalEvaluate instanceof StringEval)) {
                    throw new NumberFormatException(AbstractC0157z.o("Formula '", str, "' evaluates to something other than a number"));
                }
                String stringValue = ((StringEval) valueEvalEvaluate).getStringValue();
                if (StringUtil.isBlank(stringValue)) {
                    return null;
                }
                return Double.valueOf(stringValue);
            }
        }

        public static boolean isValid(Cell cell, DataValidationContext dataValidationContext) {
            return values()[dataValidationContext.getValidation().getValidationConstraint().getValidationType()].isValidValue(cell, dataValidationContext);
        }

        public boolean isValidNumericCell(Cell cell, DataValidationContext dataValidationContext) {
            if (DataValidationEvaluator.isType(cell, CellType.NUMERIC)) {
                return isValidNumericValue(Double.valueOf(cell.getNumericCellValue()), dataValidationContext);
            }
            return false;
        }

        public boolean isValidNumericValue(Double d, DataValidationContext dataValidationContext) {
            Double d6;
            try {
                Double dEvalOrConstant = evalOrConstant(dataValidationContext.getFormula1(), dataValidationContext);
                if (dEvalOrConstant != null) {
                    if (dataValidationContext.getOperator() == 0 || dataValidationContext.getOperator() == 1) {
                        Double dEvalOrConstant2 = evalOrConstant(dataValidationContext.getFormula2(), dataValidationContext);
                        d6 = dEvalOrConstant2 != null ? dEvalOrConstant2 : null;
                    }
                    return OperatorEnum.values()[dataValidationContext.getOperator()].isValid(d, dEvalOrConstant, d6);
                }
                return true;
            } catch (NumberFormatException unused) {
                return false;
            }
        }

        public boolean isValidValue(Cell cell, DataValidationContext dataValidationContext) {
            return isValidNumericCell(cell, dataValidationContext);
        }
    }

    public DataValidationEvaluator(Workbook workbook, WorkbookEvaluatorProvider workbookEvaluatorProvider) {
        this.workbook = workbook;
        this.workbookEvaluator = workbookEvaluatorProvider._getWorkbookEvaluator();
    }

    public static List<ValueEval> getValidationValuesForConstraint(DataValidationContext dataValidationContext) {
        DataValidationConstraint validationConstraint = dataValidationContext.getValidation().getValidationConstraint();
        if (validationConstraint.getValidationType() != 3) {
            return null;
        }
        String formula1 = validationConstraint.getFormula1();
        ArrayList arrayList = new ArrayList();
        if (validationConstraint.getExplicitListValues() != null && validationConstraint.getExplicitListValues().length > 0) {
            for (String str : validationConstraint.getExplicitListValues()) {
                if (str != null) {
                    arrayList.add(new StringEval(str));
                }
            }
        } else if (formula1 != null) {
            ValueEval valueEvalEvaluateList = dataValidationContext.getEvaluator().getWorkbookEvaluator().evaluateList(formula1, dataValidationContext.getTarget(), dataValidationContext.getRegion());
            if (valueEvalEvaluateList instanceof TwoDEval) {
                TwoDEval twoDEval = (TwoDEval) valueEvalEvaluateList;
                for (int i5 = 0; i5 < twoDEval.getHeight(); i5++) {
                    arrayList.add(twoDEval.getValue(i5, 0));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private List<? extends DataValidation> getValidations(Sheet sheet) {
        List<? extends DataValidation> list = this.validations.get(sheet.getSheetName());
        if (list != null || this.validations.containsKey(sheet.getSheetName())) {
            return list;
        }
        List<? extends DataValidation> dataValidations = sheet.getDataValidations();
        this.validations.put(sheet.getSheetName(), dataValidations);
        return dataValidations;
    }

    public static boolean isType(Cell cell, CellType cellType) {
        CellType cellType2 = cell.getCellType();
        if (cellType2 != cellType) {
            return cellType2 == CellType.FORMULA && cell.getCachedFormulaResultType() == cellType;
        }
        return true;
    }

    public void clearAllCachedValues() {
        this.validations.clear();
    }

    public DataValidationContext getValidationContextForCell(CellReference cellReference) {
        List<? extends DataValidation> validations;
        DataValidation next;
        Sheet sheet = this.workbook.getSheet(cellReference.getSheetName());
        if (sheet == null || (validations = getValidations(sheet)) == null) {
            return null;
        }
        Iterator<? extends DataValidation> it = validations.iterator();
        while (it.hasNext() && (r3 = (next = it.next()).getRegions()) != null) {
            for (CellRangeAddress cellRangeAddress : r3.getCellRangeAddresses()) {
                if (cellRangeAddress.isInRange(cellReference)) {
                    return new DataValidationContext(next, this, cellRangeAddress, cellReference);
                }
            }
        }
        return null;
    }

    public DataValidation getValidationForCell(CellReference cellReference) {
        DataValidationContext validationContextForCell = getValidationContextForCell(cellReference);
        if (validationContextForCell == null) {
            return null;
        }
        return validationContextForCell.getValidation();
    }

    public List<ValueEval> getValidationValuesForCell(CellReference cellReference) {
        DataValidationContext validationContextForCell = getValidationContextForCell(cellReference);
        if (validationContextForCell == null) {
            return null;
        }
        return getValidationValuesForConstraint(validationContextForCell);
    }

    public WorkbookEvaluator getWorkbookEvaluator() {
        return this.workbookEvaluator;
    }

    public boolean isValidCell(CellReference cellReference) {
        DataValidationContext validationContextForCell = getValidationContextForCell(cellReference);
        if (validationContextForCell == null) {
            return true;
        }
        Cell cell = SheetUtil.getCell(this.workbook.getSheet(cellReference.getSheetName()), cellReference.getRow(), cellReference.getCol());
        return (cell == null || isType(cell, CellType.BLANK) || (isType(cell, CellType.STRING) && (cell.getStringCellValue() == null || cell.getStringCellValue().isEmpty()))) ? validationContextForCell.getValidation().getEmptyCellAllowed() : ValidationEnum.isValid(cell, validationContextForCell);
    }
}
