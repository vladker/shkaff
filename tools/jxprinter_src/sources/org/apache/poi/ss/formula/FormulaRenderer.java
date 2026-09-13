package org.apache.poi.ss.formula;

import A3.AbstractC0157z;
import java.util.Stack;
import org.apache.poi.ss.formula.ptg.ArrayInitialPtg;
import org.apache.poi.ss.formula.ptg.AttrPtg;
import org.apache.poi.ss.formula.ptg.MemAreaPtg;
import org.apache.poi.ss.formula.ptg.MemErrPtg;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;
import org.apache.poi.ss.formula.ptg.OperationPtg;
import org.apache.poi.ss.formula.ptg.ParenthesisPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class FormulaRenderer {
    private static String[] getOperands(Stack<String> stack, int i5) {
        String[] strArr = new String[i5];
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            if (stack.isEmpty()) {
                StringBuilder sbT = AbstractC0157z.t(i5, "Too few arguments supplied to operation. Expected (", ") operands but got (");
                sbT.append((i5 - i6) - 1);
                sbT.append(")");
                throw new IllegalStateException(sbT.toString());
            }
            strArr[i6] = stack.pop();
        }
        return strArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String toFormulaString(FormulaRenderingWorkbook formulaRenderingWorkbook, Ptg[] ptgArr) {
        if (ptgArr == 0 || ptgArr.length == 0) {
            throw new IllegalArgumentException("ptgs must not be null");
        }
        Stack stack = new Stack();
        for (ArrayInitialPtg arrayInitialPtg : ptgArr) {
            if (!(arrayInitialPtg instanceof MemAreaPtg) && !(arrayInitialPtg instanceof MemFuncPtg) && !(arrayInitialPtg instanceof MemErrPtg)) {
                if (arrayInitialPtg instanceof ParenthesisPtg) {
                    stack.push("(" + ((String) stack.pop()) + ")");
                } else if (arrayInitialPtg instanceof AttrPtg) {
                    AttrPtg attrPtg = (AttrPtg) arrayInitialPtg;
                    if (!attrPtg.isOptimizedIf() && !attrPtg.isOptimizedChoose() && !attrPtg.isSkip() && !attrPtg.isSpace() && !attrPtg.isSemiVolatile()) {
                        if (!attrPtg.isSum()) {
                            throw new RuntimeException("Unexpected tAttr: " + attrPtg);
                        }
                        stack.push(attrPtg.toFormulaString(getOperands(stack, attrPtg.getNumberOfOperands())));
                    }
                } else if (arrayInitialPtg instanceof WorkbookDependentFormula) {
                    stack.push(((WorkbookDependentFormula) arrayInitialPtg).toFormulaString(formulaRenderingWorkbook));
                } else if (arrayInitialPtg instanceof OperationPtg) {
                    OperationPtg operationPtg = (OperationPtg) arrayInitialPtg;
                    stack.push(operationPtg.toFormulaString(getOperands(stack, operationPtg.getNumberOfOperands())));
                } else {
                    stack.push(arrayInitialPtg.toFormulaString());
                }
            }
        }
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String str = (String) stack.pop();
        if (stack.isEmpty()) {
            return str;
        }
        throw new IllegalStateException("too much stuff left on the stack");
    }
}
