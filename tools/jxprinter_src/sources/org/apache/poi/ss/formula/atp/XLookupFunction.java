package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class XLookupFunction implements FreeRefFunction, ArrayFunction {
    public static final FreeRefFunction instance = new XLookupFunction(ArgumentsEvaluator.instance);
    private final ArgumentsEvaluator evaluator;

    private XLookupFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    private ValueEval _evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        if (valueEvalArr.length < 3) {
            return ErrorEval.VALUE_INVALID;
        }
        ValueEval valueEval = BlankEval.instance;
        if (valueEvalArr.length > 3) {
            try {
                ValueEval singleValue = OperandResolver.getSingleValue(valueEvalArr[3], i5, i6);
                if (singleValue != null) {
                    valueEval = singleValue;
                }
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
        ValueEval valueEval2 = valueEval;
        LookupUtils.MatchMode matchMode = LookupUtils.MatchMode.ExactMatch;
        if (valueEvalArr.length > 4) {
            try {
                matchMode = LookupUtils.matchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[4], i5, i6)));
            } catch (EvaluationException e6) {
                return e6.getErrorEval();
            } catch (Exception unused) {
                return ErrorEval.VALUE_INVALID;
            }
        }
        LookupUtils.MatchMode matchMode2 = matchMode;
        LookupUtils.SearchMode searchMode = LookupUtils.SearchMode.IterateForward;
        if (valueEvalArr.length > 5) {
            try {
                searchMode = LookupUtils.searchMode(OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[5], i5, i6)));
            } catch (EvaluationException e7) {
                return e7.getErrorEval();
            } catch (Exception unused2) {
                return ErrorEval.VALUE_INVALID;
            }
        }
        return evaluate(i5, i6, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], valueEval2, matchMode2, searchMode);
    }

    private AreaEval notFoundAreaEval(final ValueEval valueEval, final int i5) {
        return new AreaEval() { // from class: org.apache.poi.ss.formula.atp.XLookupFunction.1
            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public boolean contains(int i6, int i7) {
                return containsRow(i6) && containsColumn(i7);
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public boolean containsColumn(int i6) {
                return i6 < i5;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public boolean containsRow(int i6) {
                return i6 == 0;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public ValueEval getAbsoluteValue(int i6, int i7) {
                return i7 == 0 ? valueEval : new StringEval("");
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public TwoDEval getColumn(int i6) {
                return null;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public int getFirstColumn() {
                return 0;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public int getFirstRow() {
                return 0;
            }

            @Override // org.apache.poi.ss.formula.SheetRange
            public int getFirstSheetIndex() {
                return 0;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
            public int getHeight() {
                return 1;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public int getLastColumn() {
                return i5 - 1;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public int getLastRow() {
                return 0;
            }

            @Override // org.apache.poi.ss.formula.SheetRange
            public int getLastSheetIndex() {
                return 0;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public ValueEval getRelativeValue(int i6, int i7) {
                return getAbsoluteValue(i6, i7);
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public TwoDEval getRow(int i6) {
                return null;
            }

            @Override // org.apache.poi.ss.formula.ThreeDEval
            public ValueEval getValue(int i6, int i7, int i8) {
                return getAbsoluteValue(i7, i8);
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval, org.apache.poi.ss.formula.TwoDEval
            public int getWidth() {
                return i5;
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public boolean isColumn() {
                return false;
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public boolean isRowHidden(int i6) {
                return false;
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public boolean isSubTotal(int i6, int i7) {
                return false;
            }

            @Override // org.apache.poi.ss.formula.eval.AreaEval
            public AreaEval offset(int i6, int i7, int i8, int i9) {
                return null;
            }

            @Override // org.apache.poi.ss.formula.TwoDEval
            public ValueEval getValue(int i6, int i7) {
                return getAbsoluteValue(i6, i7);
            }
        };
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        return _evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
    }

    @Override // org.apache.poi.ss.formula.functions.ArrayFunction
    public ValueEval evaluateArray(ValueEval[] valueEvalArr, int i5, int i6) {
        return _evaluate(valueEvalArr, i5, i6);
    }

    private ValueEval evaluate(int i5, int i6, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, ValueEval valueEval4, LookupUtils.MatchMode matchMode, LookupUtils.SearchMode searchMode) {
        LookupUtils.ValueVector valueVectorCreateRowVector;
        int width;
        try {
            ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i5, i6);
            TwoDEval twoDEvalResolveTableArrayArg = LookupUtils.resolveTableArrayArg(valueEval2);
            if (twoDEvalResolveTableArrayArg.isColumn()) {
                valueVectorCreateRowVector = LookupUtils.createColumnVector(twoDEvalResolveTableArrayArg, 0);
            } else {
                valueVectorCreateRowVector = LookupUtils.createRowVector(twoDEvalResolveTableArrayArg, 0);
            }
            try {
                int iXlookupIndexOfValue = LookupUtils.xlookupIndexOfValue(singleValue, valueVectorCreateRowVector, matchMode, searchMode);
                if (!(valueEval3 instanceof AreaEval)) {
                    return valueEval3;
                }
                AreaEval areaEval = (AreaEval) valueEval3;
                if (twoDEvalResolveTableArrayArg.isColumn()) {
                    return areaEval.offset(iXlookupIndexOfValue, iXlookupIndexOfValue, 0, areaEval.getWidth() - 1);
                }
                return areaEval.offset(0, areaEval.getHeight() - 1, iXlookupIndexOfValue, iXlookupIndexOfValue);
            } catch (EvaluationException e) {
                if (ErrorEval.NA.equals(e.getErrorEval())) {
                    if (valueEval4 != BlankEval.instance) {
                        if ((valueEval3 instanceof AreaEval) && (width = ((AreaEval) valueEval3).getWidth()) > 1) {
                            return notFoundAreaEval(valueEval4, width);
                        }
                        return valueEval4;
                    }
                    return ErrorEval.NA;
                }
                return e.getErrorEval();
            }
        } catch (EvaluationException e6) {
            return e6.getErrorEval();
        }
    }
}
