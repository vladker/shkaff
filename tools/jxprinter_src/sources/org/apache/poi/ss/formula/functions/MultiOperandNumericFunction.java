package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.NumericValueEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.StringValueEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MultiOperandNumericFunction implements Function {
    private static final int DEFAULT_MAX_NUM_OPERANDS = SpreadsheetVersion.EXCEL2007.getMaxFunctionArgs();
    private EvalConsumer<BlankEval, DoubleList> blankConsumer;
    private EvalConsumer<BoolEval, DoubleList> boolByRefConsumer;
    private EvalConsumer<BoolEval, DoubleList> boolByValueConsumer;
    private EvalConsumer<MissingArgEval, DoubleList> missingArgConsumer;

    /* JADX INFO: renamed from: org.apache.poi.ss.formula.functions.MultiOperandNumericFunction$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy;

        static {
            int[] iArr = new int[Policy.values().length];
            $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy = iArr;
            try {
                iArr[Policy.COERCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[Policy.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[Policy.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface EvalConsumer<T, R> {
        void accept(T t6, R r6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Policy {
        COERCE,
        SKIP,
        ERROR
    }

    public MultiOperandNumericFunction(boolean z6, boolean z7) {
        Policy policy = Policy.SKIP;
        this.missingArgConsumer = ConsumerFactory.createForMissingArg(policy);
        this.boolByRefConsumer = ConsumerFactory.createForBoolEval(z6 ? Policy.COERCE : policy);
        Policy policy2 = Policy.COERCE;
        this.boolByValueConsumer = ConsumerFactory.createForBoolEval(policy2);
        this.blankConsumer = ConsumerFactory.createForBlank(z7 ? policy2 : policy);
    }

    private void collectValue(ValueEval valueEval, boolean z6, DoubleList doubleList) throws EvaluationException {
        if (valueEval == null) {
            throw new IllegalArgumentException("ve must not be null");
        }
        if (valueEval instanceof BoolEval) {
            BoolEval boolEval = (BoolEval) valueEval;
            if (z6) {
                this.boolByRefConsumer.accept(boolEval, doubleList);
                return;
            } else {
                this.boolByValueConsumer.accept(boolEval, doubleList);
                return;
            }
        }
        if (valueEval instanceof NumericValueEval) {
            doubleList.add(((NumericValueEval) valueEval).getNumberValue());
            return;
        }
        if (valueEval instanceof StringValueEval) {
            if (z6) {
                return;
            }
            if (treatStringsAsZero()) {
                doubleList.add(0.0d);
                return;
            }
            Double d = OperandResolver.parseDouble(((StringValueEval) valueEval).getStringValue().trim());
            if (d == null) {
                throw new EvaluationException(ErrorEval.VALUE_INVALID);
            }
            doubleList.add(d.doubleValue());
            return;
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval == BlankEval.instance) {
            this.blankConsumer.accept((BlankEval) valueEval, doubleList);
        } else {
            if (valueEval == MissingArgEval.instance) {
                this.missingArgConsumer.accept((MissingArgEval) valueEval, doubleList);
                return;
            }
            throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + valueEval.getClass() + ")");
        }
    }

    private void collectValues(ValueEval valueEval, DoubleList doubleList) throws EvaluationException {
        if (valueEval instanceof ThreeDEval) {
            ThreeDEval threeDEval = (ThreeDEval) valueEval;
            for (int firstSheetIndex = threeDEval.getFirstSheetIndex(); firstSheetIndex <= threeDEval.getLastSheetIndex(); firstSheetIndex++) {
                int width = threeDEval.getWidth();
                int height = threeDEval.getHeight();
                for (int i5 = 0; i5 < height; i5++) {
                    for (int i6 = 0; i6 < width; i6++) {
                        ValueEval value = threeDEval.getValue(firstSheetIndex, i5, i6);
                        if ((isSubtotalCounted() || !threeDEval.isSubTotal(i5, i6)) && (isHiddenRowCounted() || !threeDEval.isRowHidden(i5))) {
                            collectValue(value, !treatStringsAsZero(), doubleList);
                        }
                    }
                }
            }
            return;
        }
        if (!(valueEval instanceof TwoDEval)) {
            if (!(valueEval instanceof RefEval)) {
                collectValue(valueEval, false, doubleList);
                return;
            }
            RefEval refEval = (RefEval) valueEval;
            for (int firstSheetIndex2 = refEval.getFirstSheetIndex(); firstSheetIndex2 <= refEval.getLastSheetIndex(); firstSheetIndex2++) {
                collectValue(refEval.getInnerValueEval(firstSheetIndex2), !treatStringsAsZero(), doubleList);
            }
            return;
        }
        TwoDEval twoDEval = (TwoDEval) valueEval;
        int width2 = twoDEval.getWidth();
        int height2 = twoDEval.getHeight();
        for (int i7 = 0; i7 < height2; i7++) {
            for (int i8 = 0; i8 < width2; i8++) {
                ValueEval value2 = twoDEval.getValue(i7, i8);
                if (isSubtotalCounted() || !twoDEval.isSubTotal(i7, i8)) {
                    collectValue(value2, !treatStringsAsZero(), doubleList);
                }
            }
        }
    }

    public abstract double evaluate(double[] dArr);

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i5, int i6) {
        try {
            double dEvaluate = evaluate(getNumberArray(valueEvalArr));
            if (!Double.isNaN(dEvaluate) && !Double.isInfinite(dEvaluate)) {
                return new NumberEval(dEvaluate);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    public int getMaxNumOperands() {
        return DEFAULT_MAX_NUM_OPERANDS;
    }

    public final double[] getNumberArray(ValueEval[] valueEvalArr) throws EvaluationException {
        if (valueEvalArr.length > getMaxNumOperands()) {
            throw EvaluationException.invalidValue();
        }
        DoubleList doubleList = new DoubleList();
        for (ValueEval valueEval : valueEvalArr) {
            collectValues(valueEval, doubleList);
        }
        return doubleList.toArray();
    }

    public boolean isHiddenRowCounted() {
        return true;
    }

    public boolean isSubtotalCounted() {
        return true;
    }

    public void setBlankEvalPolicy(Policy policy) {
        this.blankConsumer = ConsumerFactory.createForBlank(policy);
    }

    public void setMissingArgPolicy(Policy policy) {
        this.missingArgConsumer = ConsumerFactory.createForMissingArg(policy);
    }

    public boolean treatStringsAsZero() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ConsumerFactory {
        private ConsumerFactory() {
        }

        private static <T> EvalConsumer<T, DoubleList> createAny(EvalConsumer<T, DoubleList> evalConsumer, Policy policy) {
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$functions$MultiOperandNumericFunction$Policy[policy.ordinal()];
            if (i5 == 1) {
                return evalConsumer;
            }
            if (i5 == 2) {
                return doNothing();
            }
            if (i5 == 3) {
                return throwValueInvalid();
            }
            throw new AssertionError();
        }

        public static EvalConsumer<BlankEval, DoubleList> createForBlank(Policy policy) {
            return createAny(new g(3), policy);
        }

        public static EvalConsumer<BoolEval, DoubleList> createForBoolEval(Policy policy) {
            return createAny(new g(1), policy);
        }

        public static EvalConsumer<MissingArgEval, DoubleList> createForMissingArg(Policy policy) {
            return createAny(new g(2), policy);
        }

        private static <T> EvalConsumer<T, DoubleList> doNothing() {
            return new g(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$createForBoolEval$1(BoolEval boolEval, DoubleList doubleList) {
            doubleList.add(boolEval.getNumberValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$throwValueInvalid$4(Object obj, DoubleList doubleList) throws EvaluationException {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }

        private static <T> EvalConsumer<T, DoubleList> throwValueInvalid() {
            return new g(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$doNothing$3(Object obj, DoubleList doubleList) {
        }
    }
}
