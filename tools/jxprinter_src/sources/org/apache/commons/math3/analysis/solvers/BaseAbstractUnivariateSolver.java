package org.apache.commons.math3.analysis.solvers;

import androidx.collection.a;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAbstractUnivariateSolver<FUNC extends UnivariateFunction> implements BaseUnivariateSolver<FUNC> {
    private static final double DEFAULT_FUNCTION_VALUE_ACCURACY = 1.0E-15d;
    private static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-14d;
    private final double absoluteAccuracy;
    private IntegerSequence.Incrementor evaluations;
    private FUNC function;
    private final double functionValueAccuracy;
    private final double relativeAccuracy;
    private double searchMax;
    private double searchMin;
    private double searchStart;

    public BaseAbstractUnivariateSolver(double d) {
        this(DEFAULT_RELATIVE_ACCURACY, d, 1.0E-15d);
    }

    public double computeObjectiveValue(double d) {
        incrementEvaluationCount();
        return this.function.value(d);
    }

    public abstract double doSolve();

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getFunctionValueAccuracy() {
        return this.functionValueAccuracy;
    }

    public double getMax() {
        return this.searchMax;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public int getMaxEvaluations() {
        return this.evaluations.getMaximalCount();
    }

    public double getMin() {
        return this.searchMin;
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    public double getStartValue() {
        return this.searchStart;
    }

    public void incrementEvaluationCount() {
        try {
            this.evaluations.increment();
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public boolean isBracketing(double d, double d6) {
        return UnivariateSolverUtils.isBracketing(this.function, d, d6);
    }

    public boolean isSequence(double d, double d6, double d7) {
        return UnivariateSolverUtils.isSequence(d, d6, d7);
    }

    public void setup(int i5, FUNC func, double d, double d6, double d7) {
        MathUtils.checkNotNull(func);
        this.searchMin = d;
        this.searchMax = d6;
        this.searchStart = d7;
        this.function = func;
        this.evaluations = this.evaluations.withMaximalCount(i5).withStart(0);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int i5, FUNC func, double d, double d6, double d7) {
        setup(i5, func, d, d6, d7);
        return doSolve();
    }

    public void verifyBracketing(double d, double d6) {
        UnivariateSolverUtils.verifyBracketing(this.function, d, d6);
    }

    public void verifyInterval(double d, double d6) {
        UnivariateSolverUtils.verifyInterval(d, d6);
    }

    public void verifySequence(double d, double d6, double d7) {
        UnivariateSolverUtils.verifySequence(d, d6, d7);
    }

    public BaseAbstractUnivariateSolver(double d, double d6) {
        this(d, d6, 1.0E-15d);
    }

    public BaseAbstractUnivariateSolver(double d, double d6, double d7) {
        this.absoluteAccuracy = d6;
        this.relativeAccuracy = d;
        this.functionValueAccuracy = d7;
        this.evaluations = IntegerSequence.Incrementor.create();
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int i5, FUNC func, double d, double d6) {
        return solve(i5, func, d, d6, a.a(d6, d, 0.5d, d));
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseUnivariateSolver
    public double solve(int i5, FUNC func, double d) {
        return solve(i5, func, Double.NaN, Double.NaN, d);
    }
}
