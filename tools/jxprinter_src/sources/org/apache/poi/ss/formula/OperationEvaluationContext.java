package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.constant.ErrorConstant;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class OperationEvaluationContext {
    public static final FreeRefFunction UDF = UserDefinedFunction.instance;
    private final WorkbookEvaluator _bookEvaluator;
    private final int _columnIndex;
    private boolean _isInArrayContext;
    private final boolean _isSingleValue;
    private final int _rowIndex;
    private final int _sheetIndex;
    private final EvaluationTracker _tracker;
    private final EvaluationWorkbook _workbook;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.OperationEvaluationContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$util$CellReference$NameType;

        static {
            int[] iArr = new int[CellReference.NameType.values().length];
            $SwitchMap$org$apache$poi$ss$util$CellReference$NameType = iArr;
            try {
                iArr[CellReference.NameType.BAD_CELL_OR_NAMED_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.NAMED_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.COLUMN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.ROW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$util$CellReference$NameType[CellReference.NameType.CELL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OperationEvaluationContext(WorkbookEvaluator workbookEvaluator, EvaluationWorkbook evaluationWorkbook, int i5, int i6, int i7, EvaluationTracker evaluationTracker) {
        this(workbookEvaluator, evaluationWorkbook, i5, i6, i7, evaluationTracker, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0083  */
    /* JADX WARN: Code duplicated, block: B:24:0x0089  */
    /* JADX WARN: Code duplicated, block: B:25:0x008b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0093  */
    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    public static CellReference applyR1C1Reference(CellReference cellReference, String str) {
        int i5;
        int i6;
        int row;
        int col;
        String upperCase = str.toUpperCase(LocaleUtil.getUserLocale());
        int iIndexOf = upperCase.indexOf(82);
        int iIndexOf2 = upperCase.indexOf(67);
        if (iIndexOf < 0 || iIndexOf2 <= iIndexOf) {
            throw new IllegalArgumentException(str.concat(" is not a valid R1C1 reference"));
        }
        String strTrim = str.substring(iIndexOf + 1, iIndexOf2).trim();
        String strTrim2 = str.substring(iIndexOf2 + 1).trim();
        int i7 = 0;
        int i8 = -1;
        if (!strTrim.startsWith("[") || !strTrim.endsWith("]")) {
            if (strTrim.isEmpty()) {
                i5 = 0;
            } else {
                i6 = Integer.parseInt(strTrim);
                i5 = 0;
            }
            if (!strTrim2.startsWith("[") && strTrim2.endsWith("]")) {
                i7 = Integer.parseInt(strTrim2.substring(1, strTrim2.length() - 1).trim());
            } else if (!strTrim2.isEmpty()) {
                i8 = Integer.parseInt(strTrim2);
            }
            if (i6 >= 0) {
                row = i6 - 1;
            } else {
                row = cellReference.getRow() + i5;
            }
            if (i8 >= 0) {
                col = i8 - 1;
            } else {
                col = cellReference.getCol() + i7;
            }
            return new CellReference(row, col);
        }
        i5 = Integer.parseInt(strTrim.substring(1, strTrim.length() - 1).trim());
        i6 = -1;
        if (!strTrim2.startsWith("[")) {
            if (!strTrim2.isEmpty()) {
                i8 = Integer.parseInt(strTrim2);
            }
        } else if (!strTrim2.isEmpty()) {
            i8 = Integer.parseInt(strTrim2);
        }
        if (i6 >= 0) {
            row = i6 - 1;
        } else {
            row = cellReference.getRow() + i5;
        }
        if (i8 >= 0) {
            col = i8 - 1;
        } else {
            col = cellReference.getCol() + i7;
        }
        return new CellReference(row, col);
    }

    private static CellReference.NameType classifyCellReference(String str, SpreadsheetVersion spreadsheetVersion) {
        return str.length() < 1 ? CellReference.NameType.BAD_CELL_OR_NAMED_RANGE : CellReference.classifyCellReference(str, spreadsheetVersion);
    }

    private ValueEval convertObjectEval(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Array item cannot be null");
        }
        if (obj instanceof String) {
            return new StringEval((String) obj);
        }
        if (obj instanceof Double) {
            return new NumberEval(((Double) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return BoolEval.valueOf(((Boolean) obj).booleanValue());
        }
        if (obj instanceof ErrorConstant) {
            return ErrorEval.valueOf(((ErrorConstant) obj).getErrorCode());
        }
        throw new IllegalArgumentException("Unexpected constant class (" + obj.getClass().getName() + ")");
    }

    private ValueEval getExternalNameXEval(EvaluationWorkbook.ExternalName externalName, String str) {
        try {
            WorkbookEvaluator otherWorkbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(str);
            EvaluationName name = otherWorkbookEvaluator.getName(externalName.getName(), externalName.getIx() - 1);
            if (name != null && name.hasFormula()) {
                if (name.getNameDefinition().length > 1) {
                    throw new RuntimeException("Complex name formulas not supported yet");
                }
                OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(otherWorkbookEvaluator, otherWorkbookEvaluator.getWorkbook(), -1, -1, -1, this._tracker);
                Ptg ptg = name.getNameDefinition()[0];
                if (ptg instanceof Ref3DPtg) {
                    return operationEvaluationContext.getRef3DEval((Ref3DPtg) ptg);
                }
                if (ptg instanceof Ref3DPxg) {
                    return operationEvaluationContext.getRef3DEval((Ref3DPxg) ptg);
                }
                if (ptg instanceof Area3DPtg) {
                    return operationEvaluationContext.getArea3DEval((Area3DPtg) ptg);
                }
                if (ptg instanceof Area3DPxg) {
                    return operationEvaluationContext.getArea3DEval((Area3DPxg) ptg);
                }
            }
            return ErrorEval.REF_INVALID;
        } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException unused) {
            return ErrorEval.REF_INVALID;
        }
    }

    private ValueEval getLocalNameXEval(NameXPxg nameXPxg) {
        int sheetIndex = nameXPxg.getSheetName() != null ? this._workbook.getSheetIndex(nameXPxg.getSheetName()) : -1;
        String nameName = nameXPxg.getNameName();
        EvaluationName name = this._workbook.getName(nameName, sheetIndex);
        return name != null ? new ExternalNameEval(name) : new FunctionNameEval(nameName);
    }

    private static CellReference.NameType getR1C1CellType(String str) {
        String upperCase = str.toUpperCase(LocaleUtil.getUserLocale());
        int iIndexOf = upperCase.indexOf(82);
        int iIndexOf2 = upperCase.indexOf(67);
        if (iIndexOf != -1) {
            return iIndexOf2 == -1 ? CellReference.NameType.ROW : CellReference.NameType.CELL;
        }
        return iIndexOf2 == -1 ? CellReference.NameType.BAD_CELL_OR_NAMED_RANGE : CellReference.NameType.COLUMN;
    }

    private static int parseColRef(String str) {
        return Integer.parseInt(str) - 1;
    }

    private static int parseRowRef(String str) {
        return CellReference.convertColStringToIndex(str);
    }

    public SheetRangeEvaluator createExternSheetRefEvaluator(ExternSheetReferenceToken externSheetReferenceToken) {
        return createExternSheetRefEvaluator(externSheetReferenceToken.getExternSheetIndex());
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._bookEvaluator.findUserDefinedFunction(str);
    }

    public ValueEval getArea3DEval(Area3DPtg area3DPtg) {
        return new LazyAreaEval(area3DPtg.getFirstRow(), area3DPtg.getFirstColumn(), area3DPtg.getLastRow(), area3DPtg.getLastColumn(), createExternSheetRefEvaluator(area3DPtg.getExternSheetIndex()));
    }

    public ValueEval getAreaEval(int i5, int i6, int i7, int i8) {
        return new LazyAreaEval(i5, i6, i7, i8, getRefEvaluatorForCurrentSheet());
    }

    public ValueEval getAreaValueEval(int i5, int i6, int i7, int i8, Object[][] objArr) {
        ValueEval[] valueEvalArr = new ValueEval[objArr.length * objArr[0].length];
        int i9 = 0;
        for (Object[] objArr2 : objArr) {
            int i10 = 0;
            while (i10 < objArr[0].length) {
                valueEvalArr[i9] = convertObjectEval(objArr2[i10]);
                i10++;
                i9++;
            }
        }
        return new CacheAreaEval(i5, i6, i7, i8, valueEvalArr);
    }

    public int getColumnIndex() {
        return this._columnIndex;
    }

    public ValueEval getDynamicReference(String str, String str2, String str3, String str4, boolean z6) {
        int lastRowIndex;
        int i5;
        int rowRef;
        int rowRef2;
        int colRef;
        int columnIndex;
        int rowIndex;
        SheetRefEvaluator sheetRefEvaluatorCreateExternSheetRefEvaluator = createExternSheetRefEvaluator(str, str2);
        if (sheetRefEvaluatorCreateExternSheetRefEvaluator == null) {
            return ErrorEval.REF_INVALID;
        }
        SheetRangeEvaluator sheetRangeEvaluator = new SheetRangeEvaluator(this._sheetIndex, sheetRefEvaluatorCreateExternSheetRefEvaluator);
        SpreadsheetVersion spreadsheetVersion = this._workbook.getSpreadsheetVersion();
        CellReference.NameType nameTypeClassifyCellReference = z6 ? classifyCellReference(str3, spreadsheetVersion) : getR1C1CellType(str3);
        int[] iArr = AnonymousClass1.$SwitchMap$org$apache$poi$ss$util$CellReference$NameType;
        int i6 = iArr[nameTypeClassifyCellReference.ordinal()];
        if (i6 == 1) {
            return ErrorEval.REF_INVALID;
        }
        if (i6 == 2) {
            EvaluationName name = this._workbook.getName(str3, this._sheetIndex);
            if (name == null) {
                throw new RuntimeException(AbstractC0157z.l(").", this._sheetIndex, AbstractC0157z.y("Specified name '", str3, "' is not found in the workbook (sheetIndex=")));
            }
            if (name.isRange()) {
                return this._bookEvaluator.evaluateNameFormula(name.getNameDefinition(), this);
            }
            throw new RuntimeException(AbstractC0157z.o("Specified name '", str3, "' is not a range as expected."));
        }
        if (str4 == null) {
            int i7 = iArr[nameTypeClassifyCellReference.ordinal()];
            if (i7 == 3) {
                if (z6) {
                    return ErrorEval.REF_INVALID;
                }
                try {
                    String strTrim = str3.substring(str3.toUpperCase(LocaleUtil.getUserLocale()).indexOf(67) + 1).trim();
                    if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
                        columnIndex = getColumnIndex() + Integer.parseInt(strTrim.substring(1, strTrim.length() - 1).trim());
                    } else {
                        if (strTrim.isEmpty()) {
                            return ErrorEval.REF_INVALID;
                        }
                        columnIndex = Integer.parseInt(strTrim) - 1;
                    }
                    int i8 = columnIndex;
                    return new LazyAreaEval(0, i8, spreadsheetVersion.getLastRowIndex(), i8, sheetRangeEvaluator);
                } catch (Exception unused) {
                    return ErrorEval.REF_INVALID;
                }
            }
            if (i7 != 4) {
                if (i7 != 5) {
                    throw new IllegalStateException(AbstractC0157z.o("Unexpected reference classification of '", str3, "'."));
                }
                CellReference cellReference = z6 ? new CellReference(str3) : applyR1C1Reference(new CellReference(getRowIndex(), getColumnIndex()), str3);
                return new LazyRefEval(cellReference.getRow(), cellReference.getCol(), sheetRangeEvaluator);
            }
            if (z6) {
                return ErrorEval.REF_INVALID;
            }
            try {
                String strTrim2 = str3.substring(str3.toUpperCase(LocaleUtil.getUserLocale()).indexOf(82) + 1).trim();
                if (strTrim2.startsWith("[") && strTrim2.endsWith("]")) {
                    rowIndex = getRowIndex() + Integer.parseInt(strTrim2.substring(1, strTrim2.length() - 1).trim());
                } else {
                    if (strTrim2.isEmpty()) {
                        return ErrorEval.REF_INVALID;
                    }
                    rowIndex = Integer.parseInt(strTrim2) - 1;
                }
                return new LazyAreaEval(rowIndex, 0, rowIndex, spreadsheetVersion.getLastColumnIndex(), sheetRangeEvaluator);
            } catch (Exception unused2) {
                return ErrorEval.REF_INVALID;
            }
        }
        CellReference.NameType nameTypeClassifyCellReference2 = z6 ? classifyCellReference(str4, spreadsheetVersion) : getR1C1CellType(str4);
        int i9 = iArr[nameTypeClassifyCellReference2.ordinal()];
        if (i9 == 1) {
            return ErrorEval.REF_INVALID;
        }
        if (i9 == 2) {
            throw new RuntimeException(AbstractC0157z.o("Cannot evaluate '", str3, "'. Indirect evaluation of defined names not supported yet"));
        }
        if (nameTypeClassifyCellReference2 != nameTypeClassifyCellReference) {
            return ErrorEval.REF_INVALID;
        }
        int i10 = iArr[nameTypeClassifyCellReference.ordinal()];
        if (i10 != 3) {
            if (i10 == 4) {
                int lastColumnIndex = spreadsheetVersion.getLastColumnIndex();
                int colRef2 = parseColRef(str3);
                colRef = parseColRef(str4);
                rowRef2 = lastColumnIndex;
                rowRef = 0;
                i5 = colRef2;
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException(AbstractC0157z.o("Unexpected reference classification of '", str3, "'."));
                }
                CellReference cellReference2 = z6 ? new CellReference(str3) : applyR1C1Reference(new CellReference(getRowIndex(), getColumnIndex()), str3);
                int row = cellReference2.getRow();
                short col = cellReference2.getCol();
                CellReference cellReference3 = z6 ? new CellReference(str4) : applyR1C1Reference(new CellReference(getRowIndex(), getColumnIndex()), str4);
                colRef = cellReference3.getRow();
                rowRef = col;
                rowRef2 = cellReference3.getCol();
                i5 = row;
            }
            lastRowIndex = colRef;
        } else {
            lastRowIndex = spreadsheetVersion.getLastRowIndex();
            i5 = 0;
            rowRef = parseRowRef(str3);
            rowRef2 = parseRowRef(str4);
        }
        return new LazyAreaEval(i5, rowRef, lastRowIndex, rowRef2, sheetRangeEvaluator);
    }

    public ValueEval getNameXEval(NameXPtg nameXPtg) {
        EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(nameXPtg.getSheetRefIndex());
        if (externalSheet == null || externalSheet.getWorkbookName() == null) {
            return getLocalNameXEval(nameXPtg);
        }
        return getExternalNameXEval(this._workbook.getExternalName(nameXPtg.getSheetRefIndex(), nameXPtg.getNameIndex()), externalSheet.getWorkbookName());
    }

    public ValueEval getRef3DEval(Ref3DPtg ref3DPtg) {
        return new LazyRefEval(ref3DPtg.getRow(), ref3DPtg.getColumn(), createExternSheetRefEvaluator(ref3DPtg.getExternSheetIndex()));
    }

    public ValueEval getRefEval(int i5, int i6) {
        return new LazyRefEval(i5, i6, getRefEvaluatorForCurrentSheet());
    }

    public SheetRangeEvaluator getRefEvaluatorForCurrentSheet() {
        return new SheetRangeEvaluator(this._sheetIndex, new SheetRefEvaluator(this._bookEvaluator, this._tracker, this._sheetIndex));
    }

    public int getRowIndex() {
        return this._rowIndex;
    }

    public int getSheetIndex() {
        return this._sheetIndex;
    }

    public EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    public boolean isArraymode() {
        return this._isInArrayContext;
    }

    public boolean isSingleValue() {
        return this._isSingleValue;
    }

    public void setArrayMode(boolean z6) {
        this._isInArrayContext = z6;
    }

    public OperationEvaluationContext(WorkbookEvaluator workbookEvaluator, EvaluationWorkbook evaluationWorkbook, int i5, int i6, int i7, EvaluationTracker evaluationTracker, boolean z6) {
        this._bookEvaluator = workbookEvaluator;
        this._workbook = evaluationWorkbook;
        this._sheetIndex = i5;
        this._rowIndex = i6;
        this._columnIndex = i7;
        this._tracker = evaluationTracker;
        this._isSingleValue = z6;
    }

    public SheetRangeEvaluator createExternSheetRefEvaluator(String str, String str2, int i5) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(str, str2, i5));
    }

    public ValueEval getRef3DEval(Ref3DPxg ref3DPxg) {
        return new LazyRefEval(ref3DPxg.getRow(), ref3DPxg.getColumn(), createExternSheetRefEvaluator(ref3DPxg.getSheetName(), ref3DPxg.getLastSheetName(), ref3DPxg.getExternalWorkbookNumber()));
    }

    public SheetRangeEvaluator createExternSheetRefEvaluator(int i5) {
        return createExternSheetRefEvaluator(this._workbook.getExternalSheet(i5));
    }

    public ValueEval getArea3DEval(Area3DPxg area3DPxg) {
        return new LazyAreaEval(area3DPxg.getFirstRow(), area3DPxg.getFirstColumn(), area3DPxg.getLastRow(), area3DPxg.getLastColumn(), createExternSheetRefEvaluator(area3DPxg.getSheetName(), area3DPxg.getLastSheetName(), area3DPxg.getExternalWorkbookNumber()));
    }

    public SheetRangeEvaluator createExternSheetRefEvaluator(EvaluationWorkbook.ExternalSheet externalSheet) {
        WorkbookEvaluator otherWorkbookEvaluator;
        int sheetIndex;
        int sheetIndex2;
        if (externalSheet != null && externalSheet.getWorkbookName() != null) {
            String workbookName = externalSheet.getWorkbookName();
            try {
                otherWorkbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(workbookName);
                sheetIndex = otherWorkbookEvaluator.getSheetIndex(externalSheet.getSheetName());
                sheetIndex2 = externalSheet instanceof EvaluationWorkbook.ExternalSheetRange ? otherWorkbookEvaluator.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) externalSheet).getLastSheetName()) : -1;
                if (sheetIndex < 0) {
                    throw new RuntimeException("Invalid sheet name '" + externalSheet.getSheetName() + "' in bool '" + workbookName + "'.");
                }
            } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        } else {
            otherWorkbookEvaluator = this._bookEvaluator;
            sheetIndex = externalSheet == null ? 0 : this._workbook.getSheetIndex(externalSheet.getSheetName());
            sheetIndex2 = externalSheet instanceof EvaluationWorkbook.ExternalSheetRange ? this._workbook.getSheetIndex(((EvaluationWorkbook.ExternalSheetRange) externalSheet).getLastSheetName()) : -1;
        }
        if (sheetIndex2 == -1) {
            sheetIndex2 = sheetIndex;
        }
        int i5 = (sheetIndex2 - sheetIndex) + 1;
        SheetRefEvaluator[] sheetRefEvaluatorArr = new SheetRefEvaluator[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            sheetRefEvaluatorArr[i6] = new SheetRefEvaluator(otherWorkbookEvaluator, this._tracker, i6 + sheetIndex);
        }
        return new SheetRangeEvaluator(sheetIndex, sheetIndex2, sheetRefEvaluatorArr);
    }

    private ValueEval getLocalNameXEval(NameXPtg nameXPtg) {
        EvaluationName name;
        String strResolveNameXText = this._workbook.resolveNameXText(nameXPtg);
        int iIndexOf = strResolveNameXText.indexOf(33);
        if (iIndexOf > -1) {
            String strSubstring = strResolveNameXText.substring(0, iIndexOf);
            String strSubstring2 = strResolveNameXText.substring(iIndexOf + 1);
            EvaluationWorkbook evaluationWorkbook = this._workbook;
            name = evaluationWorkbook.getName(strSubstring2, evaluationWorkbook.getSheetIndex(strSubstring));
        } else {
            name = this._workbook.getName(strResolveNameXText, -1);
        }
        if (name != null) {
            return new ExternalNameEval(name);
        }
        return new FunctionNameEval(strResolveNameXText);
    }

    public ValueEval getNameXEval(NameXPxg nameXPxg) {
        EvaluationWorkbook.ExternalSheet externalSheet = this._workbook.getExternalSheet(nameXPxg.getSheetName(), null, nameXPxg.getExternalWorkbookNumber());
        if (externalSheet != null && externalSheet.getWorkbookName() != null) {
            return getExternalNameXEval(this._workbook.getExternalName(nameXPxg.getNameName(), nameXPxg.getSheetName(), nameXPxg.getExternalWorkbookNumber()), externalSheet.getWorkbookName());
        }
        return getLocalNameXEval(nameXPxg);
    }

    private SheetRefEvaluator createExternSheetRefEvaluator(String str, String str2) {
        WorkbookEvaluator otherWorkbookEvaluator;
        if (str == null) {
            otherWorkbookEvaluator = this._bookEvaluator;
        } else if (str2 != null) {
            try {
                otherWorkbookEvaluator = this._bookEvaluator.getOtherWorkbookEvaluator(str);
            } catch (CollaboratingWorkbooksEnvironment.WorkbookNotFoundException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("sheetName must not be null if workbookName is provided");
        }
        int sheetIndex = str2 == null ? this._sheetIndex : otherWorkbookEvaluator.getSheetIndex(str2);
        if (sheetIndex < 0) {
            return null;
        }
        return new SheetRefEvaluator(otherWorkbookEvaluator, this._tracker, sheetIndex);
    }
}
