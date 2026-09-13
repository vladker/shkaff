package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class EmbeddedRungeKuttaFieldIntegrator<T extends RealFieldElement<T>> extends AdaptiveStepsizeFieldIntegrator<T> implements FieldButcherArrayProvider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[][] f6858a;
    private final T[] b;
    private final T[] c;
    private final T exp;
    private final int fsal;
    private T maxGrowth;
    private T minReduction;
    private T safety;

    public EmbeddedRungeKuttaFieldIntegrator(Field<T> field, String str, int i5, double d, double d6, double d7, double d8) {
        super(field, str, d, d6, d7, d8);
        this.fsal = i5;
        this.c = getC();
        this.f6858a = getA();
        this.b = getB();
        this.exp = (T) field.getOne().divide(-getOrder());
        setSafety((RealFieldElement) field.getZero().add(0.9d));
        setMinReduction((RealFieldElement) field.getZero().add(0.2d));
        setMaxGrowth((RealFieldElement) field.getZero().add(10.0d));
    }

    public abstract RungeKuttaFieldStepInterpolator<T> createInterpolator(boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldEquationsMapper<T> fieldEquationsMapper);

    public abstract T estimateError(T[][] tArr, T[] tArr2, T[] tArr3, T t6);

    public T fraction(int i5, int i6) {
        return (T) ((RealFieldElement) getField().getOne().multiply(i5)).divide(i6);
    }

    public T getMaxGrowth() {
        return this.maxGrowth;
    }

    public T getMinReduction() {
        return this.minReduction;
    }

    public abstract int getOrder();

    public T getSafety() {
        return this.safety;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6) {
        T tFilterStep;
        int i5;
        boolean z6;
        sanityChecks(fieldODEState, t6);
        RealFieldElement time = fieldODEState.getTime();
        RealFieldElement[] realFieldElementArrMapState = fieldExpandableODE.getMapper().mapState(fieldODEState);
        setStepStart(initIntegration(fieldExpandableODE, time, realFieldElementArrMapState, t6));
        double d = 0.0d;
        int i6 = 0;
        boolean z7 = ((RealFieldElement) t6.subtract(fieldODEState.getTime())).getReal() > 0.0d;
        int length = this.c.length + 1;
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(getField(), length, -1);
        RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length);
        T zero = getField().getZero();
        setIsLastStep(false);
        RealFieldElement[] realFieldElementArr3 = realFieldElementArrMapState;
        boolean z8 = true;
        while (true) {
            double d6 = d;
            T tFilterStep2 = zero;
            RealFieldElement[] realFieldElementArrMapState2 = realFieldElementArr3;
            boolean z9 = z8;
            RealFieldElement realFieldElementEstimateError = (RealFieldElement) getField().getZero().add(10.0d);
            while (((RealFieldElement) realFieldElementEstimateError.subtract(1.0d)).getReal() >= d6) {
                realFieldElementArrMapState2 = fieldExpandableODE.getMapper().mapState(getStepStart());
                realFieldElementArr[i6 == true ? 1 : 0] = fieldExpandableODE.getMapper().mapDerivative(getStepStart());
                if (z9) {
                    RealFieldElement[] realFieldElementArr4 = (RealFieldElement[]) MathArrays.buildArray(getField(), this.mainSetDimension);
                    if (this.vecAbsoluteTolerance == null) {
                        int i7 = i6 == true ? 1 : 0;
                        while (i7 < realFieldElementArr4.length) {
                            realFieldElementArr4[i7] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElementArrMapState2[i7].abs()).multiply(this.scalRelativeTolerance)).add(this.scalAbsoluteTolerance);
                            i7++;
                            i6 = i6 == true ? 1 : 0;
                        }
                        i5 = i6;
                    } else {
                        i5 = i6 == true ? 1 : 0;
                        for (int i8 = i5 == true ? 1 : 0; i8 < realFieldElementArr4.length; i8++) {
                            realFieldElementArr4[i8] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElementArrMapState2[i8].abs()).multiply(this.vecRelativeTolerance[i8])).add(this.vecAbsoluteTolerance[i8]);
                        }
                    }
                    T tInitializeStep = initializeStep(z7, getOrder(), realFieldElementArr4, getStepStart(), fieldExpandableODE.getMapper());
                    z6 = i5 == true ? 1 : 0;
                    tFilterStep2 = tInitializeStep;
                } else {
                    i5 = i6 == true ? 1 : 0;
                    z6 = z9;
                }
                setStepSize(tFilterStep2);
                if (z7) {
                    if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(getStepSize())).subtract(t6)).getReal() >= d6) {
                        setStepSize((RealFieldElement) t6.subtract(getStepStart().getTime()));
                    }
                } else if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(getStepSize())).subtract(t6)).getReal() <= d6) {
                    setStepSize((RealFieldElement) t6.subtract(getStepStart().getTime()));
                }
                for (int i9 = 1; i9 < length; i9++) {
                    for (int i10 = i5; i10 < realFieldElementArrMapState.length; i10++) {
                        int i11 = i9 - 1;
                        RealFieldElement realFieldElement = (RealFieldElement) realFieldElementArr[i5][i10].multiply(this.f6858a[i11][i5]);
                        for (int i12 = 1; i12 < i9; i12++) {
                            realFieldElement = (RealFieldElement) realFieldElement.add(realFieldElementArr[i12][i10].multiply(this.f6858a[i11][i12]));
                        }
                        realFieldElementArr2[i10] = (RealFieldElement) realFieldElementArrMapState2[i10].add(getStepSize().multiply(realFieldElement));
                    }
                    realFieldElementArr[i9] = computeDerivatives((RealFieldElement) getStepStart().getTime().add(getStepSize().multiply(this.c[i9 - 1])), realFieldElementArr2);
                }
                for (int i13 = i5; i13 < realFieldElementArrMapState.length; i13++) {
                    RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElementArr[i5][i13].multiply(this.b[i5]);
                    for (int i14 = 1; i14 < length; i14++) {
                        realFieldElement2 = (RealFieldElement) realFieldElement2.add(realFieldElementArr[i14][i13].multiply(this.b[i14]));
                    }
                    realFieldElementArr2[i13] = (RealFieldElement) realFieldElementArrMapState2[i13].add(getStepSize().multiply(realFieldElement2));
                }
                realFieldElementEstimateError = estimateError(realFieldElementArr, realFieldElementArrMapState2, realFieldElementArr2, getStepSize());
                if (((RealFieldElement) realFieldElementEstimateError.subtract(1.0d)).getReal() >= d6) {
                    boolean z10 = i5;
                    tFilterStep2 = filterStep((RealFieldElement) getStepSize().multiply(MathUtils.min(this.maxGrowth, MathUtils.max(this.minReduction, (RealFieldElement) this.safety.multiply(realFieldElementEstimateError.pow(this.exp))))), z7, z10);
                    i6 = z10 ? 1 : 0;
                } else {
                    i6 = 0;
                }
                z9 = z6;
            }
            RealFieldElement realFieldElement3 = (RealFieldElement) getStepStart().getTime().add(getStepSize());
            int i15 = this.fsal;
            FieldODEStateAndDerivative<T> fieldODEStateAndDerivative = new FieldODEStateAndDerivative<>(realFieldElement3, realFieldElementArr2, i15 >= 0 ? realFieldElementArr[i15] : computeDerivatives(realFieldElement3, realFieldElementArr2));
            i6 = 0;
            System.arraycopy(realFieldElementArr2, 0, realFieldElementArrMapState2, 0, realFieldElementArrMapState.length);
            RealFieldElement realFieldElement4 = realFieldElementEstimateError;
            RealFieldElement[][] realFieldElementArr5 = realFieldElementArr;
            setStepStart(acceptStep(createInterpolator(z7, realFieldElementArr5, getStepStart(), fieldODEStateAndDerivative, fieldExpandableODE.getMapper()), t6));
            if (isLastStep()) {
                tFilterStep = tFilterStep2;
            } else {
                RealFieldElement realFieldElement5 = (RealFieldElement) getStepSize().multiply(MathUtils.min(this.maxGrowth, MathUtils.max(this.minReduction, (RealFieldElement) this.safety.multiply(realFieldElement4.pow(this.exp)))));
                double real = ((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(realFieldElement5)).subtract(t6)).getReal();
                tFilterStep = filterStep(realFieldElement5, z7, !z7 ? real > d6 : real < d6);
                double real2 = ((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(tFilterStep)).subtract(t6)).getReal();
                if (!z7 ? real2 <= d6 : real2 >= d6) {
                    tFilterStep = (T) t6.subtract(getStepStart().getTime());
                }
            }
            if (isLastStep()) {
                FieldODEStateAndDerivative<T> stepStart = getStepStart();
                resetInternalState();
                return stepStart;
            }
            realFieldElementArr = realFieldElementArr5;
            zero = tFilterStep;
            realFieldElementArr3 = realFieldElementArrMapState2;
            d = d6;
            z8 = z9 ? 1 : 0;
        }
    }

    public void setMaxGrowth(T t6) {
        this.maxGrowth = t6;
    }

    public void setMinReduction(T t6) {
        this.minReduction = t6;
    }

    public void setSafety(T t6) {
        this.safety = t6;
    }

    public T fraction(double d, double d6) {
        return (T) ((RealFieldElement) getField().getOne().multiply(d)).divide(d6);
    }

    public EmbeddedRungeKuttaFieldIntegrator(Field<T> field, String str, int i5, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, str, d, d6, dArr, dArr2);
        this.fsal = i5;
        this.c = getC();
        this.f6858a = getA();
        this.b = getB();
        this.exp = (T) field.getOne().divide(-getOrder());
        setSafety((RealFieldElement) field.getZero().add(0.9d));
        setMinReduction((RealFieldElement) field.getZero().add(0.2d));
        setMaxGrowth((RealFieldElement) field.getZero().add(10.0d));
    }
}
