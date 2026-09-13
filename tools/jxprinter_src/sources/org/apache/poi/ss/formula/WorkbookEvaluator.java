package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.util.Supplier;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.atp.AnalysisToolPak;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ExternalNameEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NotImplementedException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefListEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayMode;
import org.apache.poi.ss.formula.functions.Choose;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.IfFunc;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.ArrayPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.BoolPtg;
import org.apache.poi.ss.formula.ptg.ControlPtg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.ExpPtg;
import org.apache.poi.ss.formula.ptg.FuncVarPtg;
import org.apache.poi.ss.formula.ptg.IntPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.MissingArgPtg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.NumberPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;
import org.apache.poi.ss.formula.ptg.StringPtg;
import org.apache.poi.ss.formula.ptg.UnionPtg;
import org.apache.poi.ss.formula.ptg.UnknownPtg;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class WorkbookEvaluator {
    private static final Logger LOG = LogManager.getLogger((Class<?>) WorkbookEvaluator.class);
    private final Logger EVAL_LOG;
    private EvaluationCache _cache;
    private CollaboratingWorkbooksEnvironment _collaboratingWorkbookEnvironment;
    private final IEvaluationListener _evaluationListener;
    private boolean _ignoreMissingWorkbooks;
    private final Map<String, Integer> _sheetIndexesByName;
    private final Map<EvaluationSheet, Integer> _sheetIndexesBySheet;
    private final IStabilityClassifier _stabilityClassifier;
    private final AggregatingUDFFinder _udfFinder;
    private final EvaluationWorkbook _workbook;
    private int _workbookIx;
    private boolean dbgEvaluationOutputForNextEval;
    private int dbgEvaluationOutputIndent;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.WorkbookEvaluator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$CellType;

        static {
            int[] iArr = new int[CellType.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$CellType = iArr;
            try {
                iArr[CellType.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BLANK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$usermodel$CellType[CellType.FORMULA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this(evaluationWorkbook, null, iStabilityClassifier, uDFFinder);
    }

    private NotImplementedException addExceptionInfo(NotImplementedException notImplementedException, int i5, int i6, int i7) {
        try {
            return new NotImplementedException("Error evaluating cell " + new CellReference(this._workbook.getSheetName(i5), i6, i7, false, false).formatAsString(), notImplementedException);
        } catch (Exception e) {
            LOG.atError().withThrowable(e).log("Can't add exception info");
            return notImplementedException;
        }
    }

    private boolean adjustRegionRelativeReference(Ptg[] ptgArr, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        int row = cellReference.getRow() - cellRangeAddressBase.getFirstRow();
        int col = cellReference.getCol() - cellRangeAddressBase.getFirstColumn();
        boolean z6 = false;
        for (Ptg ptg : ptgArr) {
            if (ptg instanceof RefPtgBase) {
                RefPtgBase refPtgBase = (RefPtgBase) ptg;
                SpreadsheetVersion spreadsheetVersion = this._workbook.getSpreadsheetVersion();
                if (refPtgBase.isRowRelative() && row > 0) {
                    int row2 = refPtgBase.getRow() + row;
                    if (row2 > spreadsheetVersion.getMaxRows()) {
                        throw new IndexOutOfBoundsException(spreadsheetVersion.name() + " files can only have " + spreadsheetVersion.getMaxRows() + " rows, but row " + row2 + " was requested.");
                    }
                    refPtgBase.setRow(row2);
                    z6 = true;
                }
                if (refPtgBase.isColRelative() && col > 0) {
                    int column = refPtgBase.getColumn() + col;
                    if (column > spreadsheetVersion.getMaxColumns()) {
                        throw new IndexOutOfBoundsException(spreadsheetVersion.name() + " files can only have " + spreadsheetVersion.getMaxColumns() + " columns, but column " + column + " was requested.");
                    }
                    refPtgBase.setColumn(column);
                    z6 = true;
                }
            }
        }
        return z6;
    }

    private static int countTokensToBeSkipped(Ptg[] ptgArr, int i5, int i6) {
        int i7 = i5;
        while (i6 != 0) {
            i7++;
            if (i7 >= ptgArr.length) {
                throw new RuntimeException("Skip distance too far (ran out of formula tokens).");
            }
            i6 -= ptgArr[i7].getSize();
            if (i6 < 0) {
                throw new RuntimeException("Bad skip distance (wrong token size calculation).");
            }
        }
        return i7 - i5;
    }

    private static ValueEval dereferenceResult(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) {
        if (operationEvaluationContext == null) {
            throw new IllegalArgumentException("OperationEvaluationContext ec is null");
        }
        if (operationEvaluationContext.getWorkbook() == null) {
            throw new IllegalArgumentException("OperationEvaluationContext ec.getWorkbook() is null");
        }
        EvaluationCell cell = operationEvaluationContext.getWorkbook().getSheet(operationEvaluationContext.getSheetIndex()).getCell(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        ValueEval elementFromArray = (cell != null && cell.isPartOfArrayFormulaGroup() && (valueEval instanceof AreaEval)) ? OperandResolver.getElementFromArray((AreaEval) valueEval, cell) : dereferenceResult(valueEval, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        return elementFromArray == BlankEval.instance ? NumberEval.ZERO : elementFromArray;
    }

    private ValueEval evaluateAny(EvaluationCell evaluationCell, final int i5, final int i6, final int i7, EvaluationTracker evaluationTracker) throws Throwable {
        EvaluationTracker evaluationTracker2;
        NotImplementedException notImplementedException;
        ValueEval numberEval;
        ValueEval valueEvalValueOf;
        int i8 = i7;
        IStabilityClassifier iStabilityClassifier = this._stabilityClassifier;
        boolean z6 = iStabilityClassifier == null || !iStabilityClassifier.isCellFinal(i5, i6, i8);
        if (evaluationCell == null || evaluationCell.getCellType() != CellType.FORMULA) {
            ValueEval valueFromNonFormulaCell = getValueFromNonFormulaCell(evaluationCell);
            if (z6) {
                evaluationTracker.acceptPlainValueDependency(this._workbook, this._workbookIx, i5, i6, i8, valueFromNonFormulaCell);
            }
            return valueFromNonFormulaCell;
        }
        FormulaCellCacheEntry orCreateFormulaCellEntry = this._cache.getOrCreateFormulaCellEntry(evaluationCell);
        if (z6 || orCreateFormulaCellEntry.isInputSensitive()) {
            evaluationTracker.acceptFormulaDependency(orCreateFormulaCellEntry);
        }
        IEvaluationListener iEvaluationListener = this._evaluationListener;
        if (orCreateFormulaCellEntry.getValue() != null) {
            if (iEvaluationListener != null) {
                iEvaluationListener.onCacheHit(i5, i6, i8, orCreateFormulaCellEntry.getValue());
            }
            return orCreateFormulaCellEntry.getValue();
        }
        try {
            if (!evaluationTracker.startEvaluate(orCreateFormulaCellEntry)) {
                return ErrorEval.CIRCULAR_REF_ERROR;
            }
            try {
                try {
                    try {
                        Ptg[] formulaTokens = this._workbook.getFormulaTokens(evaluationCell);
                        evaluationTracker2 = evaluationTracker;
                        try {
                            OperationEvaluationContext operationEvaluationContext = new OperationEvaluationContext(this, this._workbook, i5, i6, i8, evaluationTracker2);
                            if (iEvaluationListener == null) {
                                numberEval = evaluateFormula(operationEvaluationContext, formulaTokens);
                            } else {
                                iEvaluationListener.onStartEvaluate(evaluationCell, orCreateFormulaCellEntry);
                                numberEval = evaluateFormula(operationEvaluationContext, formulaTokens);
                                iEvaluationListener.onEndEvaluate(orCreateFormulaCellEntry, numberEval);
                            }
                            evaluationTracker2.updateCacheResult(numberEval);
                        } catch (NotImplementedException e) {
                            e = e;
                            notImplementedException = e;
                            i8 = i7;
                            throw addExceptionInfo(notImplementedException, i5, i6, i8);
                        } catch (RuntimeException e6) {
                            e = e6;
                            if (!(e.getCause() instanceof CollaboratingWorkbooksEnvironment.WorkbookNotFoundException) || !this._ignoreMissingWorkbooks) {
                                throw e;
                            }
                            LOG.atInfo().log("{} - Continuing with cached value!", e.getCause().getMessage());
                            int i9 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[evaluationCell.getCachedFormulaResultType().ordinal()];
                            if (i9 == 1) {
                                numberEval = new NumberEval(evaluationCell.getNumericCellValue());
                            } else if (i9 != 2) {
                                if (i9 == 3) {
                                    valueEvalValueOf = BlankEval.instance;
                                } else if (i9 == 4) {
                                    valueEvalValueOf = BoolEval.valueOf(evaluationCell.getBooleanCellValue());
                                } else {
                                    if (i9 != 5) {
                                        throw new RuntimeException("Unexpected cell type '" + evaluationCell.getCellType() + "' found!");
                                    }
                                    valueEvalValueOf = ErrorEval.valueOf(evaluationCell.getErrorCellValue());
                                }
                                numberEval = valueEvalValueOf;
                            } else {
                                numberEval = new StringEval(evaluationCell.getStringCellValue());
                            }
                        }
                    } catch (NotImplementedException e7) {
                        e = e7;
                    }
                } catch (NotImplementedException e8) {
                    notImplementedException = e8;
                }
            } catch (RuntimeException e9) {
                e = e9;
                evaluationTracker2 = evaluationTracker;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                evaluationTracker.endEvaluate(orCreateFormulaCellEntry);
                throw th2;
            }
            evaluationTracker2.endEvaluate(orCreateFormulaCellEntry);
            final ValueEval valueEval = numberEval;
            LOG.atDebug().log(new Supplier() { // from class: org.apache.poi.ss.formula.d
                @Override // org.apache.logging.log4j.util.Supplier
                public final Object get() {
                    return this.f7199a.lambda$evaluateAny$0(i5, i6, i7, valueEval);
                }
            });
            return valueEval;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private ValueEval getEvalForNameRecord(EvaluationName evaluationName, OperationEvaluationContext operationEvaluationContext) {
        if (evaluationName.isFunctionName()) {
            return new FunctionNameEval(evaluationName.getNameText());
        }
        if (evaluationName.hasFormula()) {
            return evaluateNameFormula(evaluationName.getNameDefinition(), operationEvaluationContext);
        }
        throw new RuntimeException("Don't know how to evaluate name '" + evaluationName.getNameText() + "'");
    }

    private ValueEval getEvalForPtg(Ptg ptg, OperationEvaluationContext operationEvaluationContext) {
        if (ptg instanceof NamePtg) {
            return getEvalForNameRecord(this._workbook.getName((NamePtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPtg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPtg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof NameXPxg) {
            return processNameEval(operationEvaluationContext.getNameXEval((NameXPxg) ptg), operationEvaluationContext);
        }
        if (ptg instanceof IntPtg) {
            return new NumberEval(((IntPtg) ptg).getValue());
        }
        if (ptg instanceof NumberPtg) {
            return new NumberEval(((NumberPtg) ptg).getValue());
        }
        if (ptg instanceof StringPtg) {
            return new StringEval(((StringPtg) ptg).getValue());
        }
        if (ptg instanceof BoolPtg) {
            return BoolEval.valueOf(((BoolPtg) ptg).getValue());
        }
        if (ptg instanceof ErrPtg) {
            return ErrorEval.valueOf(((ErrPtg) ptg).getErrorCode());
        }
        if (ptg instanceof MissingArgPtg) {
            return MissingArgEval.instance;
        }
        if ((ptg instanceof AreaErrPtg) || (ptg instanceof RefErrorPtg) || (ptg instanceof DeletedArea3DPtg) || (ptg instanceof DeletedRef3DPtg)) {
            return ErrorEval.REF_INVALID;
        }
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
        if (ptg instanceof RefPtg) {
            RefPtg refPtg = (RefPtg) ptg;
            return operationEvaluationContext.getRefEval(refPtg.getRow(), refPtg.getColumn());
        }
        if (ptg instanceof AreaPtg) {
            AreaPtg areaPtg = (AreaPtg) ptg;
            return operationEvaluationContext.getAreaEval(areaPtg.getFirstRow(), areaPtg.getFirstColumn(), areaPtg.getLastRow(), areaPtg.getLastColumn());
        }
        if (ptg instanceof ArrayPtg) {
            ArrayPtg arrayPtg = (ArrayPtg) ptg;
            return operationEvaluationContext.getAreaValueEval(0, 0, arrayPtg.getRowCount() - 1, arrayPtg.getColumnCount() - 1, arrayPtg.getTokenArrayValues());
        }
        if (ptg instanceof UnknownPtg) {
            throw new RuntimeException("UnknownPtg not allowed");
        }
        if (ptg instanceof ExpPtg) {
            throw new RuntimeException("ExpPtg currently not supported");
        }
        throw new RuntimeException("Unexpected ptg class (" + ptg.getClass().getName() + ")");
    }

    public static Collection<String> getNotSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getNotSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getNotSupportedFunctionNames());
        return Collections.unmodifiableCollection(treeSet);
    }

    private int getSheetIndex(EvaluationSheet evaluationSheet) {
        Integer numValueOf = this._sheetIndexesBySheet.get(evaluationSheet);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(evaluationSheet);
            if (sheetIndex < 0) {
                throw new RuntimeException("Specified sheet from a different book");
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesBySheet.put(evaluationSheet, numValueOf);
        }
        return numValueOf.intValue();
    }

    public static Collection<String> getSupportedFunctionNames() {
        TreeSet treeSet = new TreeSet();
        treeSet.addAll(FunctionEval.getSupportedFunctionNames());
        treeSet.addAll(AnalysisToolPak.getSupportedFunctionNames());
        return Collections.unmodifiableCollection(treeSet);
    }

    public static ValueEval getValueFromNonFormulaCell(EvaluationCell evaluationCell) {
        if (evaluationCell == null) {
            return BlankEval.instance;
        }
        CellType cellType = evaluationCell.getCellType();
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$CellType[cellType.ordinal()];
        if (i5 == 1) {
            return new NumberEval(evaluationCell.getNumericCellValue());
        }
        if (i5 == 2) {
            return new StringEval(evaluationCell.getStringCellValue());
        }
        if (i5 == 3) {
            return BlankEval.instance;
        }
        if (i5 == 4) {
            return BoolEval.valueOf(evaluationCell.getBooleanCellValue());
        }
        if (i5 == 5) {
            return ErrorEval.valueOf(evaluationCell.getErrorCellValue());
        }
        throw new RuntimeException("Unexpected cell type (" + cellType + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Message lambda$evaluateAny$0(int i5, int i6, int i7, ValueEval valueEval) {
        String sheetName = getSheetName(i5);
        CellReference cellReference = new CellReference(i6, i7);
        StringBuilder sbY = AbstractC0157z.y("Evaluated ", sheetName, "!");
        sbY.append(cellReference.formatAsString());
        sbY.append(" to ");
        sbY.append(valueEval);
        return new SimpleMessage(sbY.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Message lambda$evaluateFormula$1(String str, OperationEvaluationContext operationEvaluationContext, Ptg[] ptgArr) {
        StringBuilder sbX = AbstractC0157z.x(str, "- evaluateFormula('");
        sbX.append(operationEvaluationContext.getRefEvaluatorForCurrentSheet().getSheetNameRange());
        sbX.append("'/");
        sbX.append(new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString());
        sbX.append("): ");
        sbX.append(Arrays.toString(ptgArr).replace("\\Qorg.apache.poi.ss.formula.ptg.\\E", ""));
        return new SimpleMessage(sbX.toString());
    }

    private ValueEval processNameEval(ValueEval valueEval, OperationEvaluationContext operationEvaluationContext) {
        return valueEval instanceof ExternalNameEval ? getEvalForNameRecord(((ExternalNameEval) valueEval).getName(), operationEvaluationContext) : valueEval;
    }

    public static void registerFunction(String str, FreeRefFunction freeRefFunction) {
        AnalysisToolPak.registerFunction(str, freeRefFunction);
    }

    public void attachToEnvironment(CollaboratingWorkbooksEnvironment collaboratingWorkbooksEnvironment, EvaluationCache evaluationCache, int i5) {
        this._collaboratingWorkbookEnvironment = collaboratingWorkbooksEnvironment;
        this._cache = evaluationCache;
        this._workbookIx = i5;
    }

    public void clearAllCachedResultValues() {
        this._cache.clear();
        this._sheetIndexesBySheet.clear();
        this._workbook.clearAllCachedResultValues();
    }

    public void detachFromEnvironment() {
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._cache = new EvaluationCache(this._evaluationListener);
        this._workbookIx = 0;
    }

    public ValueEval evaluate(EvaluationCell evaluationCell) {
        return evaluateAny(evaluationCell, getSheetIndex(evaluationCell.getSheet()), evaluationCell.getRowIndex(), evaluationCell.getColumnIndex(), new EvaluationTracker(this._cache));
    }

    /* JADX WARN: Code duplicated, block: B:122:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x01b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x0158 A[PHI: r7
  0x0158: PHI (r7v1 org.apache.poi.ss.formula.ptg.Ptg) = 
  (r7v0 org.apache.poi.ss.formula.ptg.Ptg)
  (r7v3 org.apache.poi.ss.formula.ptg.Ptg)
  (r7v3 org.apache.poi.ss.formula.ptg.Ptg)
 binds: [B:16:0x006d, B:54:0x0134, B:56:0x013a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x0172  */
    /* JADX WARN: Code duplicated, block: B:74:0x0188  */
    /* JADX WARN: Code duplicated, block: B:76:0x018c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0198  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:83:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c0 A[LOOP:2: B:84:0x01ab->B:90:0x01c0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:91:0x01c3 A[EDGE_INSN: B:91:0x01c3->B:92:0x01c4 BREAK  A[LOOP:2: B:84:0x01ab->B:90:0x01c0]] */
    /* JADX WARN: Code duplicated, block: B:93:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:97:0x01dc  */
    @Internal
    public ValueEval evaluateFormula(OperationEvaluationContext operationEvaluationContext, Ptg[] ptgArr) {
        String strSubstring;
        ValueEval evalForPtg;
        ValueEval[] valueEvalArr;
        int i5;
        boolean z6;
        boolean z7;
        int i6;
        Ptg ptg;
        ValueEval valueEval;
        int iCountTokensToBeSkipped;
        int chooseFuncOffset;
        int i7;
        if (this.dbgEvaluationOutputForNextEval) {
            this.dbgEvaluationOutputIndent = 1;
            this.dbgEvaluationOutputForNextEval = true;
        }
        int i8 = this.dbgEvaluationOutputIndent;
        if (i8 > 0) {
            strSubstring = "                                                                                                    ".substring(0, Math.min(100, i8 * 2));
            this.EVAL_LOG.atWarn().log((Supplier<Message>) new M1.b(strSubstring, 6, operationEvaluationContext, ptgArr));
            this.dbgEvaluationOutputIndent++;
        } else {
            strSubstring = "";
        }
        String str = strSubstring;
        EvaluationCell cell = operationEvaluationContext.getWorkbook().getSheet(operationEvaluationContext.getSheetIndex()).getCell(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        Stack stack = new Stack();
        int length = ptgArr.length;
        int iCountTokensToBeSkipped2 = 0;
        while (iCountTokensToBeSkipped2 < length) {
            Ptg ptg2 = ptgArr[iCountTokensToBeSkipped2];
            if (this.dbgEvaluationOutputIndent > 0) {
                this.EVAL_LOG.atInfo().log("{}  * ptg {}: {}, stack: {}", str, Unbox.box(iCountTokensToBeSkipped2), ptg2, stack);
            }
            if (ptg2 instanceof AttrPtg) {
                AttrPtg attrPtg = (AttrPtg) ptg2;
                if (attrPtg.isSum()) {
                    ptg2 = FuncVarPtg.SUM;
                }
                if (attrPtg.isOptimizedChoose()) {
                    ValueEval valueEval2 = (ValueEval) stack.pop();
                    int[] jumpTable = attrPtg.getJumpTable();
                    int length2 = jumpTable.length;
                    try {
                        int iEvaluateFirstArg = Choose.evaluateFirstArg(valueEval2, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
                        if (iEvaluateFirstArg < 1 || iEvaluateFirstArg > length2) {
                            stack.push(ErrorEval.VALUE_INVALID);
                            chooseFuncOffset = attrPtg.getChooseFuncOffset();
                            i7 = chooseFuncOffset + 4;
                        } else {
                            i7 = jumpTable[iEvaluateFirstArg - 1];
                        }
                    } catch (EvaluationException e) {
                        stack.push(e.getErrorEval());
                        chooseFuncOffset = attrPtg.getChooseFuncOffset();
                    }
                    iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, i7 - ((length2 * 2) + 2));
                } else if (attrPtg.isOptimizedIf()) {
                    if (!cell.isPartOfArrayFormulaGroup()) {
                        ValueEval valueEval3 = (ValueEval) stack.pop();
                        try {
                            if (!IfFunc.evaluateFirstArg(valueEval3, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex())) {
                                iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                                Ptg ptg3 = ptgArr[iCountTokensToBeSkipped2 + 1];
                                if ((ptgArr[iCountTokensToBeSkipped2] instanceof AttrPtg) && (ptg3 instanceof FuncVarPtg) && ((FuncVarPtg) ptg3).getFunctionIndex() == 1) {
                                    stack.push(valueEval3);
                                    stack.push(BoolEval.FALSE);
                                }
                            }
                        } catch (EvaluationException e6) {
                            stack.push(e6.getErrorEval());
                            iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData());
                            iCountTokensToBeSkipped = countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, ((AttrPtg) ptgArr[iCountTokensToBeSkipped2]).getData() + 1);
                            iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
                        }
                    }
                } else if (attrPtg.isSkip() && !cell.isPartOfArrayFormulaGroup()) {
                    iCountTokensToBeSkipped2 += countTokensToBeSkipped(ptgArr, iCountTokensToBeSkipped2, attrPtg.getData() + 1);
                    if (stack.peek() == MissingArgEval.instance) {
                        stack.pop();
                        stack.push(BlankEval.instance);
                    }
                } else if ((ptg2 instanceof ControlPtg) && !(ptg2 instanceof MemFuncPtg) && !(ptg2 instanceof MemAreaPtg) && !(ptg2 instanceof MemErrPtg)) {
                    if (ptg2 instanceof UnionPtg) {
                        stack.push(new RefListEval((ValueEval) stack.pop(), (ValueEval) stack.pop()));
                    } else {
                        if (ptg2 instanceof OperationPtg) {
                            OperationPtg operationPtg = (OperationPtg) ptg2;
                            int numberOfOperands = operationPtg.getNumberOfOperands();
                            valueEvalArr = new ValueEval[numberOfOperands];
                            z6 = false;
                            for (i5 = numberOfOperands - 1; i5 >= 0; i5--) {
                                valueEval = (ValueEval) stack.pop();
                                valueEvalArr[i5] = valueEval;
                                if (valueEval instanceof AreaEval) {
                                    z6 = true;
                                }
                            }
                            if (z6) {
                                z7 = false;
                                break;
                            }
                            i6 = iCountTokensToBeSkipped2;
                            while (true) {
                                if (i6 < length) {
                                    ptg = ptgArr[i6];
                                    if (ptg instanceof FuncVarPtg) {
                                        try {
                                            z7 = FunctionEval.getBasicFunction(((FuncVarPtg) ptg).getFunctionIndex()) instanceof ArrayMode;
                                            break;
                                        } catch (NotImplementedException unused) {
                                            z7 = false;
                                            break;
                                        }
                                    }
                                    i6++;
                                }
                                z7 = false;
                                break;
                            }
                            operationEvaluationContext.setArrayMode(z7);
                            evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg, valueEvalArr, operationEvaluationContext);
                            operationEvaluationContext.setArrayMode(false);
                        } else {
                            evalForPtg = getEvalForPtg(ptg2, operationEvaluationContext);
                        }
                        if (evalForPtg != null) {
                            throw new RuntimeException("Evaluation result must not be null");
                        }
                        stack.push(evalForPtg);
                        if (this.dbgEvaluationOutputIndent > 0) {
                            this.EVAL_LOG.atInfo().log("{}    = {}", str, evalForPtg);
                        }
                    }
                }
                iCountTokensToBeSkipped2 += iCountTokensToBeSkipped;
            } else if (ptg2 instanceof ControlPtg) {
                continue;
            } else if (ptg2 instanceof UnionPtg) {
                stack.push(new RefListEval((ValueEval) stack.pop(), (ValueEval) stack.pop()));
            } else {
                if (ptg2 instanceof OperationPtg) {
                    OperationPtg operationPtg2 = (OperationPtg) ptg2;
                    int numberOfOperands2 = operationPtg2.getNumberOfOperands();
                    valueEvalArr = new ValueEval[numberOfOperands2];
                    z6 = false;
                    while (i5 >= 0) {
                        valueEval = (ValueEval) stack.pop();
                        valueEvalArr[i5] = valueEval;
                        if (valueEval instanceof AreaEval) {
                            z6 = true;
                        }
                    }
                    if (z6) {
                        z7 = false;
                        break;
                    }
                    i6 = iCountTokensToBeSkipped2;
                    while (true) {
                        if (i6 < length) {
                            ptg = ptgArr[i6];
                            if (ptg instanceof FuncVarPtg) {
                                z7 = FunctionEval.getBasicFunction(((FuncVarPtg) ptg).getFunctionIndex()) instanceof ArrayMode;
                                break;
                            }
                            i6++;
                        }
                        z7 = false;
                        break;
                    }
                    operationEvaluationContext.setArrayMode(z7);
                    evalForPtg = OperationEvaluatorFactory.evaluate(operationPtg2, valueEvalArr, operationEvaluationContext);
                    operationEvaluationContext.setArrayMode(false);
                } else {
                    evalForPtg = getEvalForPtg(ptg2, operationEvaluationContext);
                }
                if (evalForPtg != null) {
                    throw new RuntimeException("Evaluation result must not be null");
                }
                stack.push(evalForPtg);
                if (this.dbgEvaluationOutputIndent > 0) {
                    this.EVAL_LOG.atInfo().log("{}    = {}", str, evalForPtg);
                }
            }
            iCountTokensToBeSkipped2++;
        }
        ValueEval valueEvalDereferenceResult = (ValueEval) stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("evaluation stack not empty");
        }
        if (operationEvaluationContext.isSingleValue()) {
            valueEvalDereferenceResult = dereferenceResult(valueEvalDereferenceResult, operationEvaluationContext);
        }
        if (this.dbgEvaluationOutputIndent > 0) {
            this.EVAL_LOG.atInfo().log("{}finished eval of {}: {}", str, new CellReference(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()).formatAsString(), valueEvalDereferenceResult);
            int i9 = this.dbgEvaluationOutputIndent - 1;
            this.dbgEvaluationOutputIndent = i9;
            if (i9 == 1) {
                this.dbgEvaluationOutputIndent = -1;
            }
        }
        return valueEvalDereferenceResult;
    }

    public ValueEval evaluateList(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        return evaluate(str, cellReference, cellRangeAddressBase, FormulaType.DATAVALIDATION_LIST);
    }

    public ValueEval evaluateNameFormula(Ptg[] ptgArr, OperationEvaluationContext operationEvaluationContext) {
        if (ptgArr.length == 1) {
            Ptg ptg = ptgArr[0];
            if (!(ptg instanceof FuncVarPtg)) {
                return getEvalForPtg(ptg, operationEvaluationContext);
            }
        }
        return evaluateFormula(new OperationEvaluationContext(this, operationEvaluationContext.getWorkbook(), operationEvaluationContext.getSheetIndex(), operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), new EvaluationTracker(this._cache), false), ptgArr);
    }

    public ValueEval evaluateReference(EvaluationSheet evaluationSheet, int i5, int i6, int i7, EvaluationTracker evaluationTracker) {
        return evaluateAny(evaluationSheet.getCell(i6, i7), i5, i6, i7, evaluationTracker);
    }

    public FreeRefFunction findUserDefinedFunction(String str) {
        return this._udfFinder.findFunction(str);
    }

    public CollaboratingWorkbooksEnvironment getEnvironment() {
        return this._collaboratingWorkbookEnvironment;
    }

    public IEvaluationListener getEvaluationListener() {
        return this._evaluationListener;
    }

    public EvaluationName getName(String str, int i5) {
        return this._workbook.getName(str, i5);
    }

    public WorkbookEvaluator getOtherWorkbookEvaluator(String str) {
        return this._collaboratingWorkbookEnvironment.getWorkbookEvaluator(str);
    }

    public EvaluationSheet getSheet(int i5) {
        return this._workbook.getSheet(i5);
    }

    public int getSheetIndexByExternIndex(int i5) {
        return this._workbook.convertFromExternSheetIndex(i5);
    }

    public String getSheetName(int i5) {
        return this._workbook.getSheetName(i5);
    }

    public EvaluationWorkbook getWorkbook() {
        return this._workbook;
    }

    public boolean isDebugEvaluationOutputForNextEval() {
        return this.dbgEvaluationOutputForNextEval;
    }

    public boolean isIgnoreMissingWorkbooks() {
        return this._ignoreMissingWorkbooks;
    }

    public void notifyDeleteCell(EvaluationCell evaluationCell) {
        this._cache.notifyDeleteCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public void notifyUpdateCell(EvaluationCell evaluationCell) {
        this._cache.notifyUpdateCell(this._workbookIx, getSheetIndex(evaluationCell.getSheet()), evaluationCell);
    }

    public void setDebugEvaluationOutputForNextEval(boolean z6) {
        this.dbgEvaluationOutputForNextEval = z6;
    }

    public void setIgnoreMissingWorkbooks(boolean z6) {
        this._ignoreMissingWorkbooks = z6;
    }

    public WorkbookEvaluator(EvaluationWorkbook evaluationWorkbook, IEvaluationListener iEvaluationListener, IStabilityClassifier iStabilityClassifier, UDFFinder uDFFinder) {
        this.EVAL_LOG = LogManager.getLogger("POI.FormulaEval");
        this.dbgEvaluationOutputIndent = -1;
        this._workbook = evaluationWorkbook;
        this._evaluationListener = iEvaluationListener;
        this._cache = new EvaluationCache(iEvaluationListener);
        this._sheetIndexesBySheet = new IdentityHashMap();
        this._sheetIndexesByName = new IdentityHashMap();
        this._collaboratingWorkbookEnvironment = CollaboratingWorkbooksEnvironment.EMPTY;
        this._workbookIx = 0;
        this._stabilityClassifier = iStabilityClassifier;
        AggregatingUDFFinder aggregatingUDFFinder = evaluationWorkbook == null ? null : (AggregatingUDFFinder) evaluationWorkbook.getUDFFinder();
        if (aggregatingUDFFinder != null && uDFFinder != null) {
            aggregatingUDFFinder.add(uDFFinder);
        }
        this._udfFinder = aggregatingUDFFinder;
    }

    public static void registerFunction(String str, Function function) {
        FunctionEval.registerFunction(str, function);
    }

    public ValueEval evaluate(String str, CellReference cellReference) {
        String sheetName = cellReference == null ? null : cellReference.getSheetName();
        int sheetIndex = sheetName == null ? -1 : getWorkbook().getSheetIndex(sheetName);
        int row = cellReference == null ? -1 : cellReference.getRow();
        return evaluateNameFormula(FormulaParser.parse(str, (FormulaParsingWorkbook) getWorkbook(), FormulaType.CELL, sheetIndex, row), new OperationEvaluationContext(this, getWorkbook(), sheetIndex, row, cellReference != null ? cellReference.getCol() : (short) -1, new EvaluationTracker(this._cache)));
    }

    public int getSheetIndex(String str) {
        Integer numValueOf = this._sheetIndexesByName.get(str);
        if (numValueOf == null) {
            int sheetIndex = this._workbook.getSheetIndex(str);
            if (sheetIndex < 0) {
                return -1;
            }
            numValueOf = Integer.valueOf(sheetIndex);
            this._sheetIndexesByName.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    public static ValueEval dereferenceResult(ValueEval valueEval, int i5, int i6) {
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
            return singleValue == BlankEval.instance ? NumberEval.ZERO : singleValue;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public ValueEval evaluate(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase) {
        return evaluate(str, cellReference, cellRangeAddressBase, FormulaType.CELL);
    }

    private ValueEval evaluate(String str, CellReference cellReference, CellRangeAddressBase cellRangeAddressBase, FormulaType formulaType) {
        String sheetName = cellReference == null ? null : cellReference.getSheetName();
        if (sheetName != null) {
            int sheetIndex = getWorkbook().getSheetIndex(sheetName);
            Ptg[] ptgArr = FormulaParser.parse(str, (FormulaParsingWorkbook) getWorkbook(), formulaType, sheetIndex, cellReference.getRow());
            adjustRegionRelativeReference(ptgArr, cellReference, cellRangeAddressBase);
            return evaluateNameFormula(ptgArr, new OperationEvaluationContext(this, getWorkbook(), sheetIndex, cellReference.getRow(), cellReference.getCol(), new EvaluationTracker(this._cache), formulaType.isSingleValue()));
        }
        throw new IllegalArgumentException("Sheet name is required");
    }
}
