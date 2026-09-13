package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdaptiveStepsizeIntegrator extends AbstractIntegrator {
    private double initialStep;
    protected int mainSetDimension;
    private double maxStep;
    private double minStep;
    protected double scalAbsoluteTolerance;
    protected double scalRelativeTolerance;
    protected double[] vecAbsoluteTolerance;
    protected double[] vecRelativeTolerance;

    public AdaptiveStepsizeIntegrator(String str, double d, double d6, double d7, double d8) {
        super(str);
        setStepSizeControl(d, d6, d7, d8);
        resetInternalState();
    }

    public double filterStep(double d, boolean z6, boolean z7) {
        double dAbs = FastMath.abs(d);
        double d6 = this.minStep;
        if (dAbs < d6) {
            if (!z7) {
                throw new NumberIsTooSmallException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, Double.valueOf(FastMath.abs(d)), Double.valueOf(this.minStep), true);
            }
            d = z6 ? d6 : -d6;
        }
        double d7 = this.maxStep;
        if (d > d7) {
            return d7;
        }
        return d < (-d7) ? -d7 : d;
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator, org.apache.commons.math3.ode.ODEIntegrator
    public double getCurrentStepStart() {
        return this.stepStart;
    }

    public double getMaxStep() {
        return this.maxStep;
    }

    public double getMinStep() {
        return this.minStep;
    }

    public double initializeStep(boolean z6, int i5, double[] dArr, double d, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        double d6 = this.initialStep;
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            return z6 ? d6 : -d6;
        }
        double d8 = 0.0d;
        double d9 = 0.0d;
        for (int i6 = 0; i6 < dArr.length; i6++) {
            double d10 = dArr2[i6];
            double d11 = dArr[i6];
            double d12 = d10 / d11;
            d8 += d12 * d12;
            double d13 = dArr3[i6] / d11;
            d9 += d13 * d13;
        }
        double dSqrt = (d8 < 1.0E-10d || d9 < 1.0E-10d) ? 1.0E-6d : FastMath.sqrt(d8 / d9) * 0.01d;
        if (!z6) {
            dSqrt = -dSqrt;
        }
        for (int i7 = 0; i7 < dArr2.length; i7++) {
            dArr4[i7] = (dArr3[i7] * dSqrt) + dArr2[i7];
        }
        computeDerivatives(d + dSqrt, dArr4, dArr5);
        for (int i8 = 0; i8 < dArr.length; i8++) {
            double d14 = (dArr5[i8] - dArr3[i8]) / dArr[i8];
            d7 += d14 * d14;
        }
        double dMax = FastMath.max(FastMath.sqrt(d9), FastMath.sqrt(d7) / dSqrt);
        double dMax2 = FastMath.max(FastMath.min(FastMath.abs(dSqrt) * 100.0d, dMax < 1.0E-15d ? FastMath.max(1.0E-6d, FastMath.abs(dSqrt) * 0.001d) : FastMath.pow(0.01d / dMax, 1.0d / ((double) i5))), FastMath.abs(d) * 1.0E-12d);
        if (dMax2 < getMinStep()) {
            dMax2 = getMinStep();
        }
        if (dMax2 > getMaxStep()) {
            dMax2 = getMaxStep();
        }
        return !z6 ? -dMax2 : dMax2;
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    public abstract void integrate(ExpandableStatefulODE expandableStatefulODE, double d);

    public void resetInternalState() {
        this.stepStart = Double.NaN;
        this.stepSize = FastMath.sqrt(this.minStep * this.maxStep);
    }

    @Override // org.apache.commons.math3.ode.AbstractIntegrator
    public void sanityChecks(ExpandableStatefulODE expandableStatefulODE, double d) {
        super.sanityChecks(expandableStatefulODE, d);
        int dimension = expandableStatefulODE.getPrimaryMapper().getDimension();
        this.mainSetDimension = dimension;
        double[] dArr = this.vecAbsoluteTolerance;
        if (dArr != null && dArr.length != dimension) {
            throw new DimensionMismatchException(this.mainSetDimension, this.vecAbsoluteTolerance.length);
        }
        double[] dArr2 = this.vecRelativeTolerance;
        if (dArr2 != null && dArr2.length != dimension) {
            throw new DimensionMismatchException(this.mainSetDimension, this.vecRelativeTolerance.length);
        }
    }

    public void setInitialStepSize(double d) {
        if (d < this.minStep || d > this.maxStep) {
            this.initialStep = -1.0d;
        } else {
            this.initialStep = d;
        }
    }

    public void setStepSizeControl(double d, double d6, double d7, double d8) {
        this.minStep = FastMath.abs(d);
        this.maxStep = FastMath.abs(d6);
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = d7;
        this.scalRelativeTolerance = d8;
        this.vecAbsoluteTolerance = null;
        this.vecRelativeTolerance = null;
    }

    public AdaptiveStepsizeIntegrator(String str, double d, double d6, double[] dArr, double[] dArr2) {
        super(str);
        setStepSizeControl(d, d6, dArr, dArr2);
        resetInternalState();
    }

    public void setStepSizeControl(double d, double d6, double[] dArr, double[] dArr2) {
        this.minStep = FastMath.abs(d);
        this.maxStep = FastMath.abs(d6);
        this.initialStep = -1.0d;
        this.scalAbsoluteTolerance = 0.0d;
        this.scalRelativeTolerance = 0.0d;
        this.vecAbsoluteTolerance = (double[]) dArr.clone();
        this.vecRelativeTolerance = (double[]) dArr2.clone();
    }
}
