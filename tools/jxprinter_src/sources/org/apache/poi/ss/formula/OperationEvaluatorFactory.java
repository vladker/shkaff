package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.formula.eval.ConcatEval;
import org.apache.poi.ss.formula.eval.FunctionEval;
import org.apache.poi.ss.formula.eval.IntersectionEval;
import org.apache.poi.ss.formula.eval.PercentEval;
import org.apache.poi.ss.formula.eval.RangeEval;
import org.apache.poi.ss.formula.eval.RelationalOperationEval;
import org.apache.poi.ss.formula.eval.TwoOperandNumericOperation;
import org.apache.poi.ss.formula.eval.UnaryMinusEval;
import org.apache.poi.ss.formula.eval.UnaryPlusEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.ArrayFunction;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.Indirect;
import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
import org.apache.poi.ss.formula.ptg.AddPtg;
import org.apache.poi.ss.formula.ptg.ConcatPtg;
import org.apache.poi.ss.formula.ptg.DividePtg;
import org.apache.poi.ss.formula.ptg.EqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
import org.apache.poi.ss.formula.ptg.IntersectionPtg;
import org.apache.poi.ss.formula.ptg.LessEqualPtg;
import org.apache.poi.ss.formula.ptg.LessThanPtg;
import org.apache.poi.ss.formula.ptg.MultiplyPtg;
import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.PercentPtg;
import org.apache.poi.ss.formula.ptg.PowerPtg;
import org.apache.poi.ss.formula.ptg.RangePtg;
import org.apache.poi.ss.formula.ptg.SubtractPtg;
import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class OperationEvaluatorFactory {
    private static final Map<Byte, Function> _instancesByPtgClass = initialiseInstancesMap();

    private OperationEvaluatorFactory() {
    }

    public static ValueEval evaluate(OperationPtg operationPtg, ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        ValueEval valueEvalEvaluateArrayFunction;
        if (operationPtg == null) {
            throw new IllegalArgumentException("ptg must not be null");
        }
        Function basicFunction = _instancesByPtgClass.get(Byte.valueOf(operationPtg.getSid()));
        FreeRefFunction freeRefFunction = null;
        if (basicFunction == null && (operationPtg instanceof AbstractFunctionPtg)) {
            short functionIndex = ((AbstractFunctionPtg) operationPtg).getFunctionIndex();
            if (functionIndex == 148) {
                freeRefFunction = Indirect.instance;
            } else if (functionIndex != 255) {
                basicFunction = FunctionEval.getBasicFunction(functionIndex);
            } else {
                freeRefFunction = UserDefinedFunction.instance;
            }
        }
        if (basicFunction != null) {
            return (!(basicFunction instanceof ArrayFunction) || (valueEvalEvaluateArrayFunction = evaluateArrayFunction((ArrayFunction) basicFunction, valueEvalArr, operationEvaluationContext)) == null) ? basicFunction.evaluate(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()) : valueEvalEvaluateArrayFunction;
        }
        if (freeRefFunction != null) {
            return freeRefFunction.evaluate(valueEvalArr, operationEvaluationContext);
        }
        throw new RuntimeException("Unexpected operation ptg class (" + operationPtg.getClass().getName() + ")");
    }

    public static ValueEval evaluateArrayFunction(ArrayFunction arrayFunction, ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        EvaluationCell cell = operationEvaluationContext.getWorkbook().getSheet(operationEvaluationContext.getSheetIndex()).getCell(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        if (cell == null) {
            return null;
        }
        if (cell.isPartOfArrayFormulaGroup()) {
            CellRangeAddress arrayFormulaRange = cell.getArrayFormulaRange();
            return arrayFunction.evaluateArray(valueEvalArr, arrayFormulaRange.getFirstRow(), arrayFormulaRange.getFirstColumn());
        }
        if (operationEvaluationContext.isArraymode()) {
            return arrayFunction.evaluateArray(valueEvalArr, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        }
        return null;
    }

    private static Map<Byte, Function> initialiseInstancesMap() {
        HashMap map = new HashMap(32);
        map.put(Byte.valueOf(AddPtg.instance.getSid()), TwoOperandNumericOperation.AddEval);
        map.put(Byte.valueOf(SubtractPtg.instance.getSid()), TwoOperandNumericOperation.SubtractEval);
        map.put(Byte.valueOf(MultiplyPtg.instance.getSid()), TwoOperandNumericOperation.MultiplyEval);
        map.put(Byte.valueOf(DividePtg.instance.getSid()), TwoOperandNumericOperation.DivideEval);
        map.put(Byte.valueOf(PowerPtg.instance.getSid()), TwoOperandNumericOperation.PowerEval);
        map.put(Byte.valueOf(ConcatPtg.instance.getSid()), ConcatEval.instance);
        map.put(Byte.valueOf(LessThanPtg.instance.getSid()), RelationalOperationEval.LessThanEval);
        map.put(Byte.valueOf(LessEqualPtg.instance.getSid()), RelationalOperationEval.LessEqualEval);
        map.put(Byte.valueOf(EqualPtg.instance.getSid()), RelationalOperationEval.EqualEval);
        map.put(Byte.valueOf(GreaterEqualPtg.instance.getSid()), RelationalOperationEval.GreaterEqualEval);
        map.put(Byte.valueOf(GreaterThanPtg.instance.getSid()), RelationalOperationEval.GreaterThanEval);
        map.put(Byte.valueOf(NotEqualPtg.instance.getSid()), RelationalOperationEval.NotEqualEval);
        map.put(Byte.valueOf(IntersectionPtg.instance.getSid()), IntersectionEval.instance);
        map.put(Byte.valueOf(RangePtg.instance.getSid()), RangeEval.instance);
        map.put(Byte.valueOf(UnaryPlusPtg.instance.getSid()), UnaryPlusEval.instance);
        map.put(Byte.valueOf(UnaryMinusPtg.instance.getSid()), UnaryMinusEval.instance);
        map.put(Byte.valueOf(PercentPtg.instance.getSid()), PercentEval.instance);
        return map;
    }
}
