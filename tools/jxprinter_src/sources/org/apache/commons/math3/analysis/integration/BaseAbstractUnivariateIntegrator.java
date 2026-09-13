package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.Incrementor;
import org.apache.commons.math3.util.IntegerSequence;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAbstractUnivariateIntegrator implements UnivariateIntegrator {
    public static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-15d;
    public static final int DEFAULT_MAX_ITERATIONS_COUNT = Integer.MAX_VALUE;
    public static final int DEFAULT_MIN_ITERATIONS_COUNT = 3;
    public static final double DEFAULT_RELATIVE_ACCURACY = 1.0E-6d;
    private final double absoluteAccuracy;
    private IntegerSequence.Incrementor count;
    private IntegerSequence.Incrementor evaluations;
    private UnivariateFunction function;

    @Deprecated
    protected Incrementor iterations;
    private double max;
    private double min;
    private final int minimalIterationCount;
    private final double relativeAccuracy;

    public BaseAbstractUnivariateIntegrator(double d, double d6, int i5, int i6) {
        this.relativeAccuracy = d;
        this.absoluteAccuracy = d6;
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        if (i6 <= i5) {
            throw new NumberIsTooSmallException(Integer.valueOf(i6), Integer.valueOf(i5), false);
        }
        this.minimalIterationCount = i5;
        IntegerSequence.Incrementor incrementorWithMaximalCount = IntegerSequence.Incrementor.create().withMaximalCount(i6);
        this.count = incrementorWithMaximalCount;
        this.iterations = Incrementor.wrap(incrementorWithMaximalCount);
        this.evaluations = IntegerSequence.Incrementor.create();
    }

    public double computeObjectiveValue(double d) {
        try {
            this.evaluations.increment();
            return this.function.value(d);
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public abstract double doIntegrate();

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double getAbsoluteAccuracy() {
        return this.absoluteAccuracy;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getEvaluations() {
        return this.evaluations.getCount();
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getIterations() {
        return this.count.getCount();
    }

    public double getMax() {
        return this.max;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getMaximalIterationCount() {
        return this.count.getMaximalCount();
    }

    public double getMin() {
        return this.min;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public int getMinimalIterationCount() {
        return this.minimalIterationCount;
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double getRelativeAccuracy() {
        return this.relativeAccuracy;
    }

    public void incrementCount() {
        this.count.increment();
    }

    @Override // org.apache.commons.math3.analysis.integration.UnivariateIntegrator
    public double integrate(int i5, UnivariateFunction univariateFunction, double d, double d6) {
        setup(i5, univariateFunction, d, d6);
        return doIntegrate();
    }

    public void setup(int i5, UnivariateFunction univariateFunction, double d, double d6) {
        MathUtils.checkNotNull(univariateFunction);
        UnivariateSolverUtils.verifyInterval(d, d6);
        this.min = d;
        this.max = d6;
        this.function = univariateFunction;
        this.evaluations = this.evaluations.withMaximalCount(i5).withStart(0);
        this.count = this.count.withStart(0);
    }

    public BaseAbstractUnivariateIntegrator(double d, double d6) {
        this(d, d6, 3, Integer.MAX_VALUE);
    }

    public BaseAbstractUnivariateIntegrator(int i5, int i6) {
        this(1.0E-6d, 1.0E-15d, i5, i6);
    }
}
