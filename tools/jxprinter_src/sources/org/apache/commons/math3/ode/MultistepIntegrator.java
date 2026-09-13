package org.apache.commons.math3.ode;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MultistepIntegrator extends AdaptiveStepsizeIntegrator {
    private double exp;
    private double maxGrowth;
    private double minReduction;
    private final int nSteps;
    protected Array2DRowRealMatrix nordsieck;
    private double safety;
    protected double[] scaled;
    private FirstOrderIntegrator starter;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InitializationCompletedMarkerException extends RuntimeException {
        private static final long serialVersionUID = -1914085471038046418L;

        public InitializationCompletedMarkerException() {
            super((Throwable) null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Deprecated
    public interface NordsieckTransformer {
        Array2DRowRealMatrix initializeHighOrderDerivatives(double d, double[] dArr, double[][] dArr2, double[][] dArr3);
    }

    public MultistepIntegrator(String str, int i5, int i6, double d, double d6, double d7, double d8) {
        super(str, d, d6, d7, d8);
        if (i5 < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS, Integer.valueOf(i5), 2, true);
        }
        this.starter = new DormandPrince853Integrator(d, d6, d7, d8);
        this.nSteps = i5;
        this.exp = (-1.0d) / ((double) i6);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    public double computeStepGrowShrinkFactor(double d) {
        return FastMath.min(this.maxGrowth, FastMath.max(this.minReduction, FastMath.pow(d, this.exp) * this.safety));
    }

    public double getMaxGrowth() {
        return this.maxGrowth;
    }

    public double getMinReduction() {
        return this.minReduction;
    }

    public int getNSteps() {
        return this.nSteps;
    }

    public double getSafety() {
        return this.safety;
    }

    public ODEIntegrator getStarterIntegrator() {
        return this.starter;
    }

    public abstract Array2DRowRealMatrix initializeHighOrderDerivatives(double d, double[] dArr, double[][] dArr2, double[][] dArr3);

    public void setMaxGrowth(double d) {
        this.maxGrowth = d;
    }

    public void setMinReduction(double d) {
        this.minReduction = d;
    }

    public void setSafety(double d) {
        this.safety = d;
    }

    public void setStarterIntegrator(FirstOrderIntegrator firstOrderIntegrator) {
        this.starter = firstOrderIntegrator;
    }

    public void start(double d, double[] dArr, double d6) {
        this.starter.clearEventHandlers();
        this.starter.clearStepHandlers();
        this.starter.addStepHandler(new NordsieckInitializer((this.nSteps + 3) / 2, dArr.length));
        try {
            FirstOrderIntegrator firstOrderIntegrator = this.starter;
            if (firstOrderIntegrator instanceof AbstractIntegrator) {
                ((AbstractIntegrator) firstOrderIntegrator).integrate(getExpandable(), d6);
            } else {
                firstOrderIntegrator.integrate(new FirstOrderDifferentialEquations() { // from class: org.apache.commons.math3.ode.MultistepIntegrator.1
                    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
                    public void computeDerivatives(double d7, double[] dArr2, double[] dArr3) {
                        MultistepIntegrator.this.getExpandable().computeDerivatives(d7, dArr2, dArr3);
                    }

                    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
                    public int getDimension() {
                        return MultistepIntegrator.this.getExpandable().getTotalDimension();
                    }
                }, d, dArr, d6, new double[dArr.length]);
            }
            throw new MathIllegalStateException(LocalizedFormats.MULTISTEP_STARTER_STOPPED_EARLY, new Object[0]);
        } catch (InitializationCompletedMarkerException unused) {
            getCounter().increment(this.starter.getEvaluations());
            this.starter.clearStepHandlers();
        }
    }

    public MultistepIntegrator(String str, int i5, int i6, double d, double d6, double[] dArr, double[] dArr2) {
        super(str, d, d6, dArr, dArr2);
        this.starter = new DormandPrince853Integrator(d, d6, dArr, dArr2);
        this.nSteps = i5;
        this.exp = (-1.0d) / ((double) i6);
        setSafety(0.9d);
        setMinReduction(0.2d);
        setMaxGrowth(FastMath.pow(2.0d, -this.exp));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class NordsieckInitializer implements StepHandler {
        private int count = 0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final double[] f6827t;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final double[][] f6828y;
        private final double[][] yDot;

        public NordsieckInitializer(int i5, int i6) {
            this.f6827t = new double[i5];
            Class cls = Double.TYPE;
            this.f6828y = (double[][]) Array.newInstance((Class<?>) cls, i5, i6);
            this.yDot = (double[][]) Array.newInstance((Class<?>) cls, i5, i6);
        }

        @Override // org.apache.commons.math3.ode.sampling.StepHandler
        public void handleStep(StepInterpolator stepInterpolator, boolean z6) {
            double previousTime = stepInterpolator.getPreviousTime();
            double currentTime = stepInterpolator.getCurrentTime();
            int i5 = 0;
            if (this.count == 0) {
                stepInterpolator.setInterpolatedTime(previousTime);
                this.f6827t[0] = previousTime;
                ExpandableStatefulODE expandable = MultistepIntegrator.this.getExpandable();
                EquationsMapper primaryMapper = expandable.getPrimaryMapper();
                primaryMapper.insertEquationData(stepInterpolator.getInterpolatedState(), this.f6828y[this.count]);
                primaryMapper.insertEquationData(stepInterpolator.getInterpolatedDerivatives(), this.yDot[this.count]);
                int i6 = 0;
                for (EquationsMapper equationsMapper : expandable.getSecondaryMappers()) {
                    equationsMapper.insertEquationData(stepInterpolator.getInterpolatedSecondaryState(i6), this.f6828y[this.count]);
                    equationsMapper.insertEquationData(stepInterpolator.getInterpolatedSecondaryDerivatives(i6), this.yDot[this.count]);
                    i6++;
                }
            }
            this.count++;
            stepInterpolator.setInterpolatedTime(currentTime);
            this.f6827t[this.count] = currentTime;
            ExpandableStatefulODE expandable2 = MultistepIntegrator.this.getExpandable();
            EquationsMapper primaryMapper2 = expandable2.getPrimaryMapper();
            primaryMapper2.insertEquationData(stepInterpolator.getInterpolatedState(), this.f6828y[this.count]);
            primaryMapper2.insertEquationData(stepInterpolator.getInterpolatedDerivatives(), this.yDot[this.count]);
            int i7 = 0;
            for (EquationsMapper equationsMapper2 : expandable2.getSecondaryMappers()) {
                equationsMapper2.insertEquationData(stepInterpolator.getInterpolatedSecondaryState(i7), this.f6828y[this.count]);
                equationsMapper2.insertEquationData(stepInterpolator.getInterpolatedSecondaryDerivatives(i7), this.yDot[this.count]);
                i7++;
            }
            int i8 = this.count;
            double[] dArr = this.f6827t;
            if (i8 != dArr.length - 1) {
                return;
            }
            MultistepIntegrator multistepIntegrator = MultistepIntegrator.this;
            double d = dArr[0];
            multistepIntegrator.stepStart = d;
            multistepIntegrator.stepSize = (dArr[dArr.length - 1] - d) / ((double) (dArr.length - 1));
            multistepIntegrator.scaled = (double[]) this.yDot[0].clone();
            while (true) {
                MultistepIntegrator multistepIntegrator2 = MultistepIntegrator.this;
                double[] dArr2 = multistepIntegrator2.scaled;
                if (i5 >= dArr2.length) {
                    multistepIntegrator2.nordsieck = multistepIntegrator2.initializeHighOrderDerivatives(multistepIntegrator2.stepSize, this.f6827t, this.f6828y, this.yDot);
                    throw new InitializationCompletedMarkerException();
                }
                dArr2[i5] = dArr2[i5] * multistepIntegrator2.stepSize;
                i5++;
            }
        }

        @Override // org.apache.commons.math3.ode.sampling.StepHandler
        public void init(double d, double[] dArr, double d6) {
        }
    }
}
