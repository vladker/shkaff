package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.AbstractFieldIntegrator;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.FirstOrderFieldDifferentialEquations;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RungeKuttaFieldIntegrator<T extends RealFieldElement<T>> extends AbstractFieldIntegrator<T> implements FieldButcherArrayProvider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[][] f6863a;
    private final T[] b;
    private final T[] c;
    private final T step;

    public RungeKuttaFieldIntegrator(Field<T> field, String str, T t6) {
        super(field, str);
        this.c = getC();
        this.f6863a = getA();
        this.b = getB();
        this.step = (T) t6.abs();
    }

    public abstract RungeKuttaFieldStepInterpolator<T> createInterpolator(boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldEquationsMapper<T> fieldEquationsMapper);

    public T fraction(int i5, int i6) {
        return (T) ((RealFieldElement) getField().getZero().add(i5)).divide(i6);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6) {
        sanityChecks(fieldODEState, t6);
        RealFieldElement time = fieldODEState.getTime();
        RealFieldElement[] realFieldElementArrMapState = fieldExpandableODE.getMapper().mapState(fieldODEState);
        setStepStart(initIntegration(fieldExpandableODE, time, realFieldElementArrMapState, t6));
        double d = 0.0d;
        int i5 = 0;
        int i6 = 1;
        boolean z6 = ((RealFieldElement) t6.subtract(fieldODEState.getTime())).getReal() > 0.0d;
        int length = this.c.length + 1;
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(getField(), length, -1);
        RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) MathArrays.buildArray(getField(), realFieldElementArrMapState.length);
        if (z6) {
            if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(this.step)).subtract(t6)).getReal() >= 0.0d) {
                setStepSize((RealFieldElement) t6.subtract(getStepStart().getTime()));
            } else {
                setStepSize(this.step);
            }
        } else if (((RealFieldElement) ((RealFieldElement) getStepStart().getTime().subtract(this.step)).subtract(t6)).getReal() <= 0.0d) {
            setStepSize((RealFieldElement) t6.subtract(getStepStart().getTime()));
        } else {
            setStepSize((RealFieldElement) this.step.negate());
        }
        setIsLastStep(false);
        while (true) {
            RealFieldElement[] realFieldElementArrMapState2 = fieldExpandableODE.getMapper().mapState(getStepStart());
            realFieldElementArr[i5] = fieldExpandableODE.getMapper().mapDerivative(getStepStart());
            int i7 = i6;
            while (i7 < length) {
                int i8 = i5;
                while (i8 < realFieldElementArrMapState.length) {
                    double d6 = d;
                    int i9 = i7 - 1;
                    RealFieldElement realFieldElement = (RealFieldElement) realFieldElementArr[i5][i8].multiply(this.f6863a[i9][i5]);
                    int i10 = i6;
                    while (i10 < i7) {
                        realFieldElement = (RealFieldElement) realFieldElement.add(realFieldElementArr[i10][i8].multiply(this.f6863a[i9][i10]));
                        i10++;
                        i5 = i5;
                    }
                    realFieldElementArr2[i8] = (RealFieldElement) realFieldElementArrMapState2[i8].add(getStepSize().multiply(realFieldElement));
                    i8++;
                    d = d6;
                    i5 = i5;
                    i6 = 1;
                }
                realFieldElementArr[i7] = computeDerivatives((RealFieldElement) getStepStart().getTime().add(getStepSize().multiply(this.c[i7 - 1])), realFieldElementArr2);
                i7++;
                d = d;
                i5 = i5;
                i6 = 1;
            }
            double d7 = d;
            int i11 = i5;
            for (int i12 = i11; i12 < realFieldElementArrMapState.length; i12++) {
                RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElementArr[i11][i12].multiply(this.b[i11]);
                for (int i13 = 1; i13 < length; i13++) {
                    realFieldElement2 = (RealFieldElement) realFieldElement2.add(realFieldElementArr[i13][i12].multiply(this.b[i13]));
                }
                realFieldElementArr2[i12] = (RealFieldElement) realFieldElementArrMapState2[i12].add(getStepSize().multiply(realFieldElement2));
            }
            RealFieldElement realFieldElement3 = (RealFieldElement) getStepStart().getTime().add(getStepSize());
            FieldODEStateAndDerivative<T> fieldODEStateAndDerivative = new FieldODEStateAndDerivative<>(realFieldElement3, realFieldElementArr2, computeDerivatives(realFieldElement3, realFieldElementArr2));
            System.arraycopy(realFieldElementArr2, i11, realFieldElementArrMapState2, i11, realFieldElementArrMapState.length);
            setStepStart(acceptStep(createInterpolator(z6, realFieldElementArr, getStepStart(), fieldODEStateAndDerivative, fieldExpandableODE.getMapper()), t6));
            if (!isLastStep()) {
                double real = ((RealFieldElement) ((RealFieldElement) getStepStart().getTime().add(getStepSize())).subtract(t6)).getReal();
                if (!z6 ? real <= d7 : real >= d7) {
                    setStepSize((RealFieldElement) t6.subtract(getStepStart().getTime()));
                }
            }
            if (isLastStep()) {
                FieldODEStateAndDerivative<T> stepStart = getStepStart();
                setStepStart(null);
                setStepSize(null);
                return stepStart;
            }
            i5 = i11;
            d = d7;
            i6 = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] singleStep(FirstOrderFieldDifferentialEquations<T> firstOrderFieldDifferentialEquations, T t6, T[] tArr, T t7) {
        T[] tArr2 = (T[]) ((RealFieldElement[]) tArr.clone());
        int i5 = 1;
        int length = this.c.length + 1;
        RealFieldElement[][] realFieldElementArr = (RealFieldElement[][]) MathArrays.buildArray(getField(), length, -1);
        RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) tArr.clone();
        RealFieldElement realFieldElement = (RealFieldElement) t7.subtract(t6);
        int i6 = 0;
        realFieldElementArr[0] = firstOrderFieldDifferentialEquations.computeDerivatives(t6, tArr2);
        int i7 = 1;
        while (i7 < length) {
            int i8 = i6;
            while (i8 < tArr.length) {
                int i9 = i7 - 1;
                RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElementArr[i6][i8].multiply(this.f6863a[i9][i6]);
                int i10 = i5;
                while (i10 < i7) {
                    realFieldElement2 = (RealFieldElement) realFieldElement2.add(realFieldElementArr[i10][i8].multiply(this.f6863a[i9][i10]));
                    i10++;
                    i6 = i6;
                }
                realFieldElementArr2[i8] = (RealFieldElement) tArr2[i8].add(realFieldElement.multiply(realFieldElement2));
                i8++;
                i6 = i6;
                i5 = 1;
            }
            realFieldElementArr[i7] = firstOrderFieldDifferentialEquations.computeDerivatives((RealFieldElement) t6.add(realFieldElement.multiply(this.c[i7 - 1])), realFieldElementArr2);
            i7++;
            i6 = i6;
            i5 = 1;
        }
        int i11 = i6;
        for (int i12 = i11; i12 < tArr.length; i12++) {
            RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElementArr[i11][i12].multiply(this.b[i11]);
            for (int i13 = 1; i13 < length; i13++) {
                realFieldElement3 = (RealFieldElement) realFieldElement3.add(realFieldElementArr[i13][i12].multiply(this.b[i13]));
            }
            tArr2[i12] = (RealFieldElement) tArr2[i12].add(realFieldElement.multiply(realFieldElement3));
        }
        return tArr2;
    }
}
