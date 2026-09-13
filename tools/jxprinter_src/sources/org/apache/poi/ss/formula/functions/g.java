package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.EvaluationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class g implements MultiOperandNumericFunction.EvalConsumer, NumericFunction.OneDoubleIf, NumericFunction.TwoDoubleIf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7207a;

    public /* synthetic */ g(int i5) {
        this.f7207a = i5;
    }

    @Override // org.apache.poi.ss.formula.functions.MultiOperandNumericFunction.EvalConsumer
    public void accept(Object obj, Object obj2) throws EvaluationException {
        switch (this.f7207a) {
            case 0:
                MultiOperandNumericFunction.ConsumerFactory.lambda$doNothing$3(obj, (DoubleList) obj2);
                break;
            case 1:
                MultiOperandNumericFunction.ConsumerFactory.lambda$createForBoolEval$1((BoolEval) obj, (DoubleList) obj2);
                break;
            case 2:
                ((DoubleList) obj2).add(0.0d);
                break;
            case 3:
                ((DoubleList) obj2).add(0.0d);
                break;
            default:
                MultiOperandNumericFunction.ConsumerFactory.lambda$throwValueInvalid$4(obj, (DoubleList) obj2);
                break;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneDoubleIf
    public double apply(double d) {
        switch (this.f7207a) {
            case 5:
                return Math.abs(d);
            case 6:
                return MathX.sinh(d);
            case 7:
                return Math.acos(d);
            case 8:
                return Math.sqrt(d);
            case 9:
                return Math.tan(d);
            case 10:
                return MathX.tanh(d);
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            default:
                return MathX.cosh(d);
            case 18:
                return MathX.acosh(d);
            case 21:
                return NumericFunction.lambda$static$0(d);
            case 22:
                return NumericFunction.evaluateOdd(d);
            case 23:
                return NumericFunction.evaluateEven(d);
            case 24:
                return Math.asin(d);
            case 25:
                return MathX.asinh(d);
            case 26:
                return Math.atan(d);
            case 27:
                return MathX.atanh(d);
            case 28:
                return Math.cos(d);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.TwoDoubleIf
    public Object apply(double d, double d6) {
        double dCeiling;
        switch (this.f7207a) {
            case 11:
                return NumericFunction.lambda$static$3(d, d6);
            case 12:
                dCeiling = MathX.ceiling(d, d6);
                break;
            case 13:
                return NumericFunction.lambda$static$4(d, d6);
            case 14:
                return NumericFunction.lambda$static$5(d, d6);
            case 15:
                return NumericFunction.lambda$static$6(d, d6);
            case 16:
                dCeiling = Math.pow(d, d6);
                break;
            case 17:
                dCeiling = MathX.round(d, d6);
                break;
            case 18:
            default:
                dCeiling = MathX.roundUp(d, d6);
                break;
            case 19:
                dCeiling = MathX.roundDown(d, d6);
                break;
        }
        return Double.valueOf(dCeiling);
    }
}
