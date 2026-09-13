package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.AbstractFieldIntegrator;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdaptiveStepsizeFieldIntegrator<T extends RealFieldElement<T>> extends AbstractFieldIntegrator<T> {
    private T initialStep;
    protected int mainSetDimension;
    private T maxStep;
    private T minStep;
    protected double scalAbsoluteTolerance;
    protected double scalRelativeTolerance;
    protected double[] vecAbsoluteTolerance;
    protected double[] vecRelativeTolerance;

    public AdaptiveStepsizeFieldIntegrator(Field<T> field, String str, double d, double d6, double d7, double d8) {
        super(field, str);
        setStepSizeControl(d, d6, d7, d8);
        resetInternalState();
    }

    public T filterStep(T t6, boolean z6, boolean z7) {
        if (((RealFieldElement) ((RealFieldElement) t6.abs()).subtract(this.minStep)).getReal() < 0.0d) {
            if (!z7) {
                throw new NumberIsTooSmallException(LocalizedFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION, Double.valueOf(((RealFieldElement) t6.abs()).getReal()), Double.valueOf(this.minStep.getReal()), true);
            }
            t6 = this.minStep;
            if (!z6) {
                t6 = (T) t6.negate();
            }
        }
        if (((RealFieldElement) t6.subtract(this.maxStep)).getReal() > 0.0d) {
            return this.maxStep;
        }
        return ((RealFieldElement) t6.add(this.maxStep)).getReal() < 0.0d ? (T) this.maxStep.negate() : t6;
    }

    public T getMaxStep() {
        return this.maxStep;
    }

    public T getMinStep() {
        return this.minStep;
    }

    public T initializeStep(boolean z6, int i5, T[] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldEquationsMapper<T> fieldEquationsMapper) {
        if (this.initialStep.getReal() > 0.0d) {
            return z6 ? this.initialStep : (T) this.initialStep.negate();
        }
        RealFieldElement[] realFieldElementArrMapState = fieldEquationsMapper.mapState(fieldODEStateAndDerivative);
        RealFieldElement[] realFieldElementArrMapDerivative = fieldEquationsMapper.mapDerivative(fieldODEStateAndDerivative);
        T zero = getField().getZero();
        T zero2 = getField().getZero();
        for (int i6 = 0; i6 < tArr.length; i6++) {
            RealFieldElement realFieldElement = (RealFieldElement) realFieldElementArrMapState[i6].divide(tArr[i6]);
            zero = (T) zero.add(realFieldElement.multiply(realFieldElement));
            RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElementArrMapDerivative[i6].divide(tArr[i6]);
            zero2 = (T) zero2.add(realFieldElement2.multiply(realFieldElement2));
        }
        RealFieldElement realFieldElement3 = (RealFieldElement) ((zero.getReal() < 1.0E-10d || zero2.getReal() < 1.0E-10d) ? getField().getZero().add(1.0E-6d) : ((RealFieldElement) ((RealFieldElement) zero.divide(zero2)).sqrt()).multiply(0.01d));
        if (!z6) {
            realFieldElement3 = (RealFieldElement) realFieldElement3.negate();
        }
        RealFieldElement[] realFieldElementArr = (RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length);
        for (int i7 = 0; i7 < realFieldElementArrMapState.length; i7++) {
            realFieldElementArr[i7] = (RealFieldElement) realFieldElementArrMapState[i7].add(realFieldElementArrMapDerivative[i7].multiply(realFieldElement3));
        }
        T[] tArrComputeDerivatives = computeDerivatives((RealFieldElement) fieldODEStateAndDerivative.getTime().add(realFieldElement3), realFieldElementArr);
        T zero3 = getField().getZero();
        for (int i8 = 0; i8 < tArr.length; i8++) {
            RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) tArrComputeDerivatives[i8].subtract(realFieldElementArrMapDerivative[i8])).divide(tArr[i8]);
            zero3 = (T) zero3.add(realFieldElement4.multiply(realFieldElement4));
        }
        RealFieldElement realFieldElementMax = MathUtils.max((RealFieldElement) zero2.sqrt(), (RealFieldElement) ((RealFieldElement) zero3.sqrt()).divide(realFieldElement3));
        T t6 = (T) MathUtils.max(this.minStep, MathUtils.min(this.maxStep, MathUtils.max(MathUtils.min((RealFieldElement) ((RealFieldElement) realFieldElement3.abs()).multiply(100), realFieldElementMax.getReal() < 1.0E-15d ? MathUtils.max((RealFieldElement) getField().getZero().add(1.0E-6d), (RealFieldElement) ((RealFieldElement) realFieldElement3.abs()).multiply(0.001d)) : (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElementMax.multiply(100)).reciprocal()).pow(1.0d / ((double) i5))), (RealFieldElement) ((RealFieldElement) fieldODEStateAndDerivative.getTime().abs()).multiply(1.0E-12d))));
        return !z6 ? (T) t6.negate() : t6;
    }

    public void resetInternalState() {
        setStepStart(null);
        setStepSize((RealFieldElement) ((RealFieldElement) this.minStep.multiply(this.maxStep)).sqrt());
    }

    @Override // org.apache.commons.math3.ode.AbstractFieldIntegrator
    public void sanityChecks(FieldODEState<T> fieldODEState, T t6) {
        super.sanityChecks(fieldODEState, t6);
        int stateDimension = fieldODEState.getStateDimension();
        this.mainSetDimension = stateDimension;
        double[] dArr = this.vecAbsoluteTolerance;
        if (dArr != null && dArr.length != stateDimension) {
            throw new DimensionMismatchException(this.mainSetDimension, this.vecAbsoluteTolerance.length);
        }
        double[] dArr2 = this.vecRelativeTolerance;
        if (dArr2 != null && dArr2.length != stateDimension) {
            throw new DimensionMismatchException(this.mainSetDimension, this.vecRelativeTolerance.length);
        }
    }

    public void setInitialStepSize(T t6) {
        if (((RealFieldElement) t6.subtract(this.minStep)).getReal() < 0.0d || ((RealFieldElement) t6.subtract(this.maxStep)).getReal() > 0.0d) {
            this.initialStep = (T) getField().getOne().negate();
        } else {
            this.initialStep = t6;
        }
    }

    public void setStepSizeControl(double d, double d6, double d7, double d8) {
        this.minStep = (T) getField().getZero().add(FastMath.abs(d));
        this.maxStep = (T) getField().getZero().add(FastMath.abs(d6));
        this.initialStep = (T) getField().getOne().negate();
        this.scalAbsoluteTolerance = d7;
        this.scalRelativeTolerance = d8;
        this.vecAbsoluteTolerance = null;
        this.vecRelativeTolerance = null;
    }

    public AdaptiveStepsizeFieldIntegrator(Field<T> field, String str, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, str);
        setStepSizeControl(d, d6, dArr, dArr2);
        resetInternalState();
    }

    public void setStepSizeControl(double d, double d6, double[] dArr, double[] dArr2) {
        this.minStep = (T) getField().getZero().add(FastMath.abs(d));
        this.maxStep = (T) getField().getZero().add(FastMath.abs(d6));
        this.initialStep = (T) getField().getOne().negate();
        this.scalAbsoluteTolerance = 0.0d;
        this.scalRelativeTolerance = 0.0d;
        this.vecAbsoluteTolerance = (double[]) dArr.clone();
        this.vecRelativeTolerance = (double[]) dArr2.clone();
    }
}
